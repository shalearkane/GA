package org.maps;

import java.util.*;

public class Chromosome {
    public Vector<Gene> gene = new Vector<>(Constants.MAX_PROCESSORS + 1);
    public Integer makespan;
    public boolean feasibility;
    public float fitness;
    public float average_cost;
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
        Queue<Gene> q_temp = new LinkedList<>();
        for (int i = 0; i <= Constants.MAX_PROCESSORS; i++) {
            schedule.add(i, new Vector<>());
            taskQueueOnProcessor.add(i, q_temp);
        }
        for (Vector<ScheduledTaskDetails> v : schedule) {
            Gene g = new Gene(0, 0);
            ScheduledTaskDetails sds = new ScheduledTaskDetails(g, 0, 0);
            v.add(sds);
        }
        Set<Integer> completed_tasks = new HashSet<>();
        Map<Integer, Integer> task_to_processor = new HashMap<>();
        Map<Integer, Integer> end_time_of_task = new HashMap<>();
        Inputs.generate_dependency_table();
        for (Gene g : gene) {
            if (g.processor == 0 || g.task == 0) continue;
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
                if(q.isEmpty()) continue;
                final Gene g = q.peek();
                int max_comm_ends = 0;
                boolean dependencies_satisfied = true;
                // check all dependencies have completed or not
                assert g != null;
                Set<Integer> dependency_list = Inputs.dependency.get(g.task);
                for (Integer d_task : dependency_list) {
                    if (!completed_tasks.contains(d_task)) {
                        dependencies_satisfied = false;
                        break;
                    }
                    for (Comm_cost_pair ccp : Inputs.dag[d_task]) {
                        if (ccp.to_node == g.task) {
                            if (task_to_processor.get(d_task) != g.processor) {
                                int comm_ends = ccp.comm_cost + end_time_of_task.get(d_task);
                                max_comm_ends = Integer.max(max_comm_ends, comm_ends);
                            }
                            break;
                        }
                    }
                }
                if (dependencies_satisfied) {
                    has_any_task_completed = true;
                    q.remove();
                    taskQueueOnProcessor.set(i, q);
                    completed_tasks.add(g.task);
                    System.out.println(schedule.get(g.processor).lastElement().end_time + " : " + max_comm_ends);
                    int start_time = Integer.max(schedule.get(g.processor).lastElement().end_time, max_comm_ends);
                    int end_time = start_time + Inputs.processing_cost[g.task][g.processor];
                    ScheduledTaskDetails sd = new ScheduledTaskDetails(g, start_time, end_time);

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
        for (Queue<Gene> top : taskQueueOnProcessor) {
            if (!top.isEmpty()) {
                feasibility = false;
                break;
            }
        }
    }

}
