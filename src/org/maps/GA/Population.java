package org.maps.GA;

import java.util.*;

import static org.maps.Heft.Heft.get_heft_chromosome;
import static org.maps.InputData.Constants.*;

public class Population {
    public Vector<Chromosome> population_array = new Vector<>();
    float average_fitness_val;
    Random rn = new Random();

    Vector<Chromosome> population_gen_random() {
        Vector<Chromosome> result = new Vector<>();
        for (int i = 0; i < MAX_POPULATION - 1; i++) {
            Chromosome c = new Chromosome();
            Set<Integer> queued = new HashSet<>();
            c.gene[0] = new Gene(0, 0);
            for (int j = 1; j <= MAX_TASKS; j++) {
                int max_task_range = Math.min(MAX_TASKS, j + 5);
                int task = rn.nextInt(max_task_range) + 1;
                while (queued.contains(task)) {
                    task = rn.nextInt(max_task_range) + 1;
                }
                queued.add(task);
                c.gene[j] = new Gene(task, rn.nextInt(MAX_PROCESSORS) + 1);
            }
            c.calculate_details();
            if (c.feasibility) {
                result.add(c);
                c.print_details();
            } else {
//                System.out.println("Not feasible");
                i--;
            }
        }
        result.sort((o1, o2) -> (int)(o1.fitness - o2.fitness));
        result.sort(new Comparator.Cmp_fitness_val());
        System.out.println("This is working, right?");
        result.firstElement().print_details();
        return result;
    }

    void population(final Chromosome heft) {
        System.out.println("Generating random population");
        population_array = population_gen_random();
        population_array.add(heft);
    }

    Offspring crossover(Chromosome A, Chromosome B) {
        Offspring offspring_chromo = new Offspring();
        Set<Integer> tasks_in_c1 = new HashSet<>();
        Set<Integer> tasks_in_c2 = new HashSet<>();
        int counter_for_c1 = 0;
        int counter_for_c2 = 0;

        offspring_chromo.c1 = new Chromosome();
        offspring_chromo.c1.gene = new Gene[MAX_TASKS + 1];
        offspring_chromo.c2 = new Chromosome();
        offspring_chromo.c2.gene = new Gene[MAX_TASKS + 1];
//        Gene zero = new Gene(0, 0);
//        offspring_chromo.c1.gene[0] = zero;
//        offspring_chromo.c2.gene[0] = zero;

        int r = rn.nextInt(MAX_TASKS) + 1;

        for (int i = 0; i <= r; i++) {
            offspring_chromo.c1.gene[counter_for_c1] = new Gene(A.gene[i].task, A.gene[i].processor);
            counter_for_c1++;
            tasks_in_c1.add(A.gene[i].task);

            offspring_chromo.c2.gene[counter_for_c2] = new Gene(B.gene[i].task, B.gene[i].processor);
            counter_for_c2++;
            tasks_in_c2.add(B.gene[i].task);
        }

        for (int i = 0; i <= MAX_TASKS; i++) {
            if (!tasks_in_c1.contains(B.gene[i].task)) {
                offspring_chromo.c1.gene[counter_for_c1] = new Gene(B.gene[i].task, B.gene[i].processor);
                counter_for_c1++;
            }

            if (!tasks_in_c2.contains(A.gene[i].task)) {
                offspring_chromo.c2.gene[counter_for_c2] = new Gene(A.gene[i].task, A.gene[i].processor);
                counter_for_c2++;
            }
        }
        assert counter_for_c1 == MAX_TASKS + 1;
        assert counter_for_c2 == MAX_TASKS + 1;

        return offspring_chromo;
    }

    Chromosome mutation(Chromosome off_spring, float mutation_rate) {
        float r2 = rn.nextFloat(1);
        if (r2 <= mutation_rate) {
            int a = rn.nextInt(MAX_TASKS) + 1;
            int b = rn.nextInt(MAX_TASKS) + 1;
            if (off_spring.gene[a].processor != off_spring.gene[b].processor || off_spring.gene[a].task != off_spring.gene[b].task) {
                Gene temp = off_spring.gene[a];
                off_spring.gene[a] = off_spring.gene[b];
                off_spring.gene[b] = temp;
            }
        }

        return off_spring;
    }

    Vector<Chromosome> roulette(Vector<Chromosome> population) {
        Vector<Chromosome> result = new Vector<>();
        float max_fitness = 0;
        for (Chromosome chromosome : population) {
            max_fitness = Math.max(chromosome.fitness, max_fitness);
        }
        for (Chromosome chromosome : population) {
            final float rand_0_1 = rn.nextFloat(1);
            final float roulette_v = (float) (max_fitness * rand_0_1 * 0.5);
            if (chromosome.fitness >= roulette_v) {
                result.add(chromosome);
            }
        }
        return result;
    }


    void generation() {
        float sum_fitness = 0;
        for (Chromosome chromosome : population_array) {
            chromosome.calculate_details();
            sum_fitness = sum_fitness + chromosome.fitness;
        }

        average_fitness_val = sum_fitness / (float) population_array.size();
        population_array = roulette(population_array);

        int limit = Math.min(population_array.size(), (int) (MAX_POPULATION * 0.7));
        for (int i = 0; i < limit - 2; i += 2) {
            Offspring offsprng = crossover(population_array.get(i), population_array.get(i + 1));
            Chromosome temp_1 = mutation(offsprng.c1, MUTATION_RATE);
            Chromosome temp_2 = mutation(offsprng.c2, MUTATION_RATE);

            temp_1.calculate_details();
            if (temp_1.feasibility) {
                population_array.add(temp_1);
            }

            temp_2.calculate_details();
            if (temp_2.feasibility) {
                population_array.add(temp_2);
            }

        }
        population_array.sort((o1, o2) -> (int)(o1.fitness - o2.fitness));
        if (population_array.size() > MAX_POPULATION) population_array.setSize(MAX_POPULATION);
//        System.out.println(average_fitness_val);
    }

    public void Driver() {
        Chromosome heft = get_heft_chromosome();
        heft.calculate_details();
        heft.print_chromosome();
        System.out.println("makespan heft: ");
        System.out.println(heft.makespan);

        population(heft);
        for (int i = 0; i < MAX_GENERATION; i++) {
            generation();
            System.out.println(population_array.size());
        }

        Chromosome final_chromo = population_array.firstElement();
        final_chromo.print_chromosome();
        System.out.print("makespan final: ");
        System.out.println(final_chromo.makespan);
        System.out.println(final_chromo.fitness);
        System.out.println(heft.fitness);

        for (Chromosome chromosome : population_array) {
            chromosome.print_chromosome();
        }
        System.out.println(population_array.size());
    }
}
