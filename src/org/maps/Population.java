package org.maps;

import java.util.*;

import static org.maps.Constants.MAX_POPULATION;
import static org.maps.Constants.MAX_TASKS;


public class Population {
    Vector<Chromosome> population_array;
    float average_fitness_val;

    Vector<Chromosome> population_gen_random(){
        Vector<Chromosome> result = new Vector<Chromosome>();
        for(int i=0;i<MAX_POPULATION -1 ;i++){
            Chromosome c = new Chromosome();
            Set<Integer> queued= new HashSet<Integer>();
            for(int j=1;j<=MAX_TASKS;j++){
                int task = rn.nextInt(MAX_TASKS)+1;
                while (queued.contains(task) != false){
                    task= rn.nextInt(MAX_TASKS) +1;
                }
                queued.add(task);
                c.gene.get(j).task = task;
                c.gene.get(j).processor = rn.nextInt(3) +1;
            }

            if(c.feasibility){
                result.add(c);
                print_chromosome(c);
            }
            else{
                i--;
            }
        }
        return result;
    }

    void population(final Chromosome heft){
        int i=0;
        Chromosome temp;
        population_array = population_gen_random();
    }

    Random rn = new Random();
    Offspring crossover(Chromosome A, Chromosome B) {
        Offspring offspring_chromo = new Offspring();
        Set<Integer> tasks_in_c1 = null;
        Set<Integer> tasks_in_c2 = null;
        int counter_for_c1 = 1;
        int counter_for_c2 = 1;

        int r = rn.nextInt(MAX_TASKS) + 1;

        for (int i = 1; i <= r; i++) {
            offspring_chromo.c1.gene.set(counter_for_c1, A.gene.get(i));
            counter_for_c1++;
            tasks_in_c1.add(A.gene.get(i).task);

            offspring_chromo.c2.gene.set(counter_for_c2, B.gene.get(i));
            counter_for_c2++;
            tasks_in_c2.add(B.gene.get(i).task);

        }

        for (int i = 1; i <= MAX_TASKS; i++) {
            if (!tasks_in_c1.contains(B.gene.get(i).task)) {
                offspring_chromo.c1.gene.set(counter_for_c1, B.gene.get(i));
                counter_for_c1++;
            }

            if (!tasks_in_c2.contains(A.gene.get(i).task)) {
                offspring_chromo.c2.gene.set(counter_for_c2, A.gene.get(i));
                counter_for_c2++;
            }
        }

        return offspring_chromo;
    }

    Chromosome mutation(Chromosome off_spring, float mutation_rate){

        float r2 = rn.nextFloat(1);
        if(r2 <= mutation_rate){
            int a = rn.nextInt(MAX_TASKS) +1;
            int b = rn.nextInt(MAX_TASKS) +1;
            if(off_spring.gene.get(a).processor != off_spring.gene.get(b).processor ||
                    off_spring.gene.get(a).task != off_spring.gene.get(b).task){
                Collections.swap(off_spring.gene,a,b);
            }
        }

        return off_spring;
    }

    Vector<Chromosome> roulette(Vector<Chromosome> population){
        Vector<Chromosome> result = new Vector<Chromosome>();
        final int initial_size = population.size();
        float max_fitness = 0;
        for(int i=0;i<initial_size;i++){
            max_fitness= Math.max(population.get(i).fitness, max_fitness);
        }
        for(int i=0;i<initial_size;i++){
            final float rand_0_1 = rn.nextFloat(1);
            final float roulette_v = max_fitness * rand_0_1;
            if(population.get(i).fitness >= roulette_v){
                result.add(population.get(i));
            }
        }
        return result;
    }

}
