package org.maps.PSO;

import org.maps.GA.Chromosome;

import java.util.Collections;
import java.util.Vector;

import static org.maps.InputData.Constants.MAX_SWARM;

public class Swarm {
    Vector<Particle> S = new Vector<>(MAX_SWARM);
    public Swarm() {
        for(int i = 1; i<= MAX_SWARM; i++) {
            Particle c_rand = new Particle();
            c_rand.generate();
            S.add(c_rand);
        }
        Collections.sort(S);
        for(int i = 1; i<= MAX_SWARM; i++) {
            S.get(i-1).print_details();
            S.get(i-1).print_schedule();
        }
    }
}
