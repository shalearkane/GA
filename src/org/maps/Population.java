package org.maps;

import java.util.Collections;
import java.util.Random;
import java.util.Set;

import static org.maps.Constants.MAX_TASKS;


public class Population {

    Offspring crossover(Chromosome A, Chromosome B) {
        Offspring offspring_chromo = new Offspring();
        Set<Integer> tasks_in_c1 = null;
        Set<Integer> tasks_in_c2 = null;
        int counter_for_c1 = 1;
        int counter_for_c2 = 1;
        Random rn = new Random();
        int r = rn.nextInt(MAX_TASKS) + 1;

        for (int i = 1; i <= r; i++) {
            offspring_chromo.c1.gene.set(counter_for_c1, A.gene.get(i));
            counter_for_c1++;
            tasks_in_c1.add(A.gene.get(i).tasks);

            offspring_chromo.c2.gene.set(counter_for_c2, B.gene.get(i));
            counter_for_c2++;
            tasks_in_c2.add(B.gene.get(i).tasks);

        }

        for (int i = 1; i <= MAX_TASKS; i++) {
            if (!tasks_in_c1.contains(B.gene.get(i).tasks)) {
                offspring_chromo.c1.gene.set(counter_for_c1, B.gene.get(i));
                counter_for_c1++;
            }

            if (!tasks_in_c2.contains(A.gene.get(i).tasks)) {
                offspring_chromo.c2.gene.set(counter_for_c2, A.gene.get(i));
                counter_for_c2++;
            }
        }

        return offspring_chromo;
    }

    Chromosome mutation(Chromosome off_spring, float mutation_rate){
        Random rm = new Random();
        float r2 = rm.nextFloat(1);
        if(r2 <= mutation_rate){
            int a = rm.nextInt(MAX_TASKS) +1;
            int b = rm.nextInt(MAX_TASKS) +1;
            if(off_spring.gene.get(a).processor != off_spring.gene.get(b).processor ||
                    off_spring.gene.get(a).tasks != off_spring.gene.get(b).tasks){
                Collections.swap(off_spring.gene,a,b);
            }
        }
        return off_spring;
    }






}
