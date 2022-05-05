package org.maps;

import org.maps.GA.Chromosome;
import org.maps.GA.Population;
import org.maps.GAPSO.GA_PSO;
import org.maps.Heft.Heft;
import org.maps.InputData.Inputs;
import org.maps.PSO.Swarm;

import static org.maps.InputData.Constants.MAX_GENERATION;

public class Main {

    public static void main(String[] args) {
        Inputs.generate_dependency_table();

        // Just PSO
        Swarm ss = new Swarm();
        for(int i = 0; i<MAX_GENERATION; i++) {
            ss.proceed_generation();
        }
        System.out.println("PSO results : ");
        ss.gbest.print_details();

        GA_PSO gp = new GA_PSO();
        gp.p = new Population();
        gp.p.Driver();

        System.out.println("GA results : ");
        gp.p.population_array.firstElement().print_details();

        gp.convert_population_to_swarm();
        gp.s.Driver();

        System.out.println("PSO (GAPSO) results : ");
        gp.s.print_gbest();

    }
    // (1 : 3), (3 : 3), (4 : 2), (2 : 1), (5 : 3), (6 : 2), (9 : 2), (7 : 3), (8 : 1), (10 : 2),
}
