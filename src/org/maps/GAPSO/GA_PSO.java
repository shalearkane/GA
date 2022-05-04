package org.maps.GAPSO;

import org.maps.GA.Chromosome;
import org.maps.GA.Population;
import org.maps.PSO.Particle;
import org.maps.PSO.Swarm;

import static org.maps.InputData.Constants.MAX_SWARM;

public class GA_PSO {
    public Swarm s;
    public Population p;

    public void convert_population_to_swarm() {
        s = new Swarm();
        final int population_size = p.population_array.size();
        for (int i = 0; i < population_size; i++) {
            s.swarm[i] = new Particle(p.population_array.get(i));
            s.swarm[i].calculate_details();
        }

        for(int i = population_size; i<MAX_SWARM; i++) {
            s.swarm[i]=new Particle();
            s.swarm[i].generate();
            s.swarm[i].calculate_details();
        }
    }
}
