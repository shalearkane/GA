package org.maps;

import java.util.Vector;

public class Chromosome {
    public Vector<Gene> gene;
    public Integer makespan;
    public boolean feasibility;
    public float fitness;
    public Vector<Vector<ScheduledTaskDetails>> schedule;

    public void set_makespan() {
        int max_end_time = 0;
        for(Vector <ScheduledTaskDetails> processor : schedule) {
            for(ScheduledTaskDetails schedtls : processor) {
                max_end_time = Integer.max(schedtls.end_time, max_end_time);
            }
        }
        makespan = max_end_time;
    }

    public void set_schedule() {
        //
    }


}
