package org.maps;

import org.maps.GA.Chromosome;
import org.maps.GA.Population;
import org.maps.GAPSO.GA_PSO;
import org.maps.Heft.Heft;
import org.maps.InputData.Inputs;
import org.maps.PSO.Swarm;

public class Main {

    public static void main(String[] args) {
        Inputs.generate_dependency_table();
//        Swarm ss = new Swarm();
//        for(int i = 0; i<100; i++) {
//            ss.proceed_generation();
//            ss.print_gbest();
//        }
//        ss.gbest.print_velocity();
//        ss.gbest.print_chromosome();

//        ss.gbest.print_schedule();
//        System.out.println();

        GA_PSO gp = new GA_PSO();
        gp.p = new Population();
        gp.p.Driver();

        gp.convert_population_to_swarm();
        for(int i = 0; i<100; i++) {
            gp.s.proceed_generation();
            gp.s.print_gbest();
        }

        gp.s.print_gbest();

    }
    // (1 : 3), (3 : 3), (4 : 2), (2 : 1), (5 : 3), (6 : 2), (9 : 2), (7 : 3), (8 : 1), (10 : 2),
}
