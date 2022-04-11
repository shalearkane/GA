package org.maps.PSO;

import org.maps.GA.Chromosome;
import org.maps.GA.Gene;

import java.util.Random;

import static org.maps.InputData.Constants.MAX_PROCESSORS;
import static org.maps.InputData.Constants.MAX_TASKS;

public class Particle extends Chromosome implements Comparable<Particle> {
    public float[] velocity = new float[MAX_TASKS + 1];

    @Override
    public void generate() {
        Random random = new Random();
        gene[0] = new Gene(0, 0);
        velocity[0] = -1;
        feasibility = false;
        while (!feasibility) {
            for (int i = 1; i <= MAX_TASKS; i++) {
                gene[i] = new Gene(i, random.nextInt(MAX_PROCESSORS) + 1);
                velocity[i] = random.nextInt(10);
            }
            calculate_details();
        }
    }

    @Override
    public void set_fitness() {
        assert average_cost != -1 : "average cost is not calculated";
        assert makespan != -1 : "makespan is not calculated";
        fitness = average_cost + makespan;
    }

    @Override
    public int compareTo(Particle o) {
        return Float.compare(o.fitness, this.fitness);
    }
}
