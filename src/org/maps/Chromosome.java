package org.maps;

import java.util.*;

public class Chromosome {
    public Vector<Gene> gene = new Vector<>(Constants.MAX_PROCESSORS + 1);
    public Integer makespan;
    public boolean feasibility;
    public float fitness;
    public Vector<Vector<ScheduledTaskDetails>> schedule = new Vector<>(Constants.MAX_PROCESSORS + 1);

    public void set_makespan() {
        int max_end_time = 0;
        for (Vector<ScheduledTaskDetails> processor : schedule) {
            max_end_time = Integer.max(processor.lastElement().end_time, max_end_time);
        }
        makespan = max_end_time;
    }

    public void set_schedule() {
        // 3 queue for task
        Vector<Queue<Gene>> taskQueueOnProcessor = new Vector<>(Constants.MAX_PROCESSORS + 1);
        Set<Integer> completed_tasks = new HashSet<>();
        Map<Integer, Integer> task_to_processor = new HashMap<>();
        Map<Integer, Integer> end_time_of_task = new HashMap<>();
        for (Gene g : gene) {
            if(g.processor == 0 || g.task == 0) continue;
            Queue<Gene> q = taskQueueOnProcessor.get(g.processor);
            q.add(g);
            task_to_processor.put(g.task, g.processor);
            taskQueueOnProcessor.set(g.processor, q);
        }

        boolean has_any_task_completed;
        do {
            has_any_task_completed = false;
            for (int i = 1; i <= Constants.MAX_PROCESSORS; i++) {
                Queue<Gene> q = taskQueueOnProcessor.get(i);
                Gene g = q.peek();
                int max_comm_delay = 0;
                boolean dependencies_satisfied = true;
                // check all dependencies have completed or not
                assert g != null;
                Set<Integer> dependency_list = Inputs.dependency.get(g.task);
                for (Integer d_task : dependency_list) {
                    if (!completed_tasks.contains(d_task)) {
                        dependencies_satisfied = false;
                        break;
                    }
                    for (Comm_cost_pair ccp : Inputs.dag[g.task]) {
                        if (ccp.to_node == d_task) {
                            if (task_to_processor.get(d_task) != g.processor)
                                max_comm_delay = Integer.max(max_comm_delay, ccp.comm_cost);
                            break;
                        }
                    }
                }
                if (dependencies_satisfied) {
                    has_any_task_completed = true;
                    q.remove();
                    taskQueueOnProcessor.set(i, q);
                    completed_tasks.add(g.task);

                    ScheduledTaskDetails sd = new ScheduledTaskDetails();
                    sd.start_time = Integer.max(schedule.get(g.processor).lastElement().end_time, max_comm_delay);
                    sd.end_time = sd.start_time + Inputs.processing_cost[g.task][g.processor];
                    sd.g = g;

                    Vector<ScheduledTaskDetails> processor_schedule = schedule.get(g.processor);
                    processor_schedule.add(sd);
                    schedule.set(g.processor, processor_schedule);

                    // update maps
                    end_time_of_task.put(g.task, sd.end_time);
                }
            }
        } while (has_any_task_completed);

        // check if the queue is empty
        feasibility = true;
        for(Queue<Gene> top : taskQueueOnProcessor) {
            if (!top.isEmpty()) {
                feasibility = false;
                break;
            }
        }
    }

}
