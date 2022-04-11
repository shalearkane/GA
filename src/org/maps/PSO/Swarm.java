package org.maps.PSO;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

import static org.maps.InputData.Constants.*;

public class Swarm {
    Particle[] swarm = new Particle[MAX_SWARM];
    Particle[] pbest = new Particle[MAX_SWARM];
    Particle gbest = new Particle();
    public Swarm() {
        gbest.fitness = Integer.MAX_VALUE;
        for(int i = 1; i<= MAX_SWARM; i++) {
            Particle c_rand = new Particle();
            c_rand.generate();
            swarm[i-1] = c_rand;
            pbest[i-1] = c_rand;
            if(gbest.fitness > c_rand.fitness) {
                gbest = c_rand;
            }
        }
    }

    private void update_pbest() {
        for(int i = 0; i<MAX_SWARM; i++) {
            if(swarm[i].fitness < pbest[i].fitness) {
                pbest[i] = swarm[i];
            }
        }
    }

    private void update_gbest() {
        for(int i = 0; i<MAX_SWARM; i++) {
            if(swarm[i].fitness < gbest.fitness) {
                gbest = swarm[i];
            }
        }
    }

    public void proceed_generation() {
        Random random = new Random();
        for(int i = 0; i<MAX_SWARM;i++) {
            for(int j = 1; j<= MAX_TASKS; j++) {
                // compare with pbest
                if(swarm[i].gene[j].processor == pbest[i].gene[j].processor) {
                    // reduce velocity
                    swarm[i].velocity[j] -= random.nextFloat(1)*SWARM_C1;
                } else {
                    // increase velocity
                    swarm[i].velocity[j] += random.nextFloat(1)*SWARM_C1;
                }

                // compare with gbest
                if(swarm[i].gene[j].processor == gbest.gene[j].processor) {
                    // reduce velocity
                    swarm[i].velocity[j] -= random.nextFloat(1)*SWARM_C2;
                } else {
                    // increase velocity
                    swarm[i].velocity[j] += random.nextFloat(1)*2;
                }
            }
        }
    }
}
