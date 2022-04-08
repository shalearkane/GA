package org.maps;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class comparator {
    static class Cmp_fitness_val implements Comparator<Chromosome>{
        public int compare(@NotNull Chromosome c1, @NotNull Chromosome c2){
            if(c1.fitness > c2.fitness)
                return 1;
            else
                return 0;
        }
    }
}
