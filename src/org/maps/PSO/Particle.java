package org.maps.PSO;

import org.maps.GA.Chromosome;
import org.maps.GA.Gene;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

import static org.maps.InputData.Constants.MAX_PROCESSORS;
import static org.maps.InputData.Constants.MAX_TASKS;

public class Particle extends Chromosome {
    public int[] velocity = new int[MAX_TASKS+1];

    void generate_rand_particle() {
        Random random = new Random();
        gene[0] = new Gene(0,0);
        velocity[0] = -1;
        for(int i = 1; i<= MAX_TASKS; i++) {
            gene[i] = new Gene(i, random.nextInt(MAX_PROCESSORS)+1);
            velocity[i] = random.nextInt(10);
        }
    }
}
