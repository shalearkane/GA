package org.maps;

import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Chromosome c = new Chromosome();
        c.gene = new Vector<>(Constants.MAX_TASKS+1);
        c.gene.add(0, new Gene(0, 0));
        c.gene.add(1, new Gene(1, 3));
        c.gene.add(2, new Gene(3, 3));
        c.gene.add(3, new Gene(4, 2));
        c.gene.add(4, new Gene(2, 1));
        c.gene.add(5, new Gene(5, 3));
        c.gene.add(6, new Gene(6, 2));
        c.gene.add(7, new Gene(9, 2));
        c.gene.add(8, new Gene(7, 3));
        c.gene.add(9, new Gene(8, 1));
        c.gene.add(10, new Gene(10, 2));
        c.set_schedule();
        System.out.println(c.feasibility);
        for(Vector<ScheduledTaskDetails> v : c.schedule) {
            System.out.println("p");
            for(ScheduledTaskDetails sd : v) {
                System.out.println(sd.g.task + " " + sd.end_time);
            }
        }
    }
    // (1 : 3), (3 : 3), (4 : 2), (2 : 1), (5 : 3), (6 : 2), (9 : 2), (7 : 3), (8 : 1), (10 : 2),
}
