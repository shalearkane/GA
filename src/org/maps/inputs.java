package org.maps;
import java.util.*;

import static org.maps.constants.MAX_PROCESSORS;
import static org.maps.constants.MAX_TASKS;

public class inputs {


    public static void main(String[] args){

        class Comm_cost_pair{
            int to_node;
            int comm_cost;
            Comm_cost_pair(int to_node, int comm_cost){
                this.to_node = to_node;
                this.comm_cost = comm_cost;
            }


        }
        Scanner sc= new Scanner(System.in);

        int[][] processing_cost =
        {
            //  1,  2,  3
            {0, 0, 0, 0},    // 0
            {0, 14, 16, 9},  // 1
            {0, 13, 19, 18}, // 2
            {0, 11, 13, 19}, // 3
            {0, 13, 8, 17},  // 4
            {0, 12, 13, 10}, // 5
            {0, 13, 16, 9},  // 6
            {0, 7, 15, 11},  // 7
            {0, 5, 11, 14},  // 8
            {0, 18, 12, 20}, // 9
            {0, 21, 7, 16},  // 10

        };

//        for(int i=0;i<MAX_TASKS+1;i++){
//            for(int j=0;j<MAX_PROCESSORS+1;j++){
//                processing_cost[i][j] = sc.nextInt();
//            }
//        }

        Comm_cost_pair[][] dag = new Comm_cost_pair[][]
                {
                {new Comm_cost_pair(0,0) },                                           // 0
                {new Comm_cost_pair(2,18) , new Comm_cost_pair(3, 12), new Comm_cost_pair(4, 9),new Comm_cost_pair(5, 11), new Comm_cost_pair(6, 14)}, // 1
                {new Comm_cost_pair(8, 19), new Comm_cost_pair(9, 16)},                           // 2
                {new Comm_cost_pair(7, 23)},                                    // 3
                {new Comm_cost_pair(8, 27), new Comm_cost_pair(9, 23)},                           // 4
                {new Comm_cost_pair(9, 13)},                                    // 5
                {new Comm_cost_pair(8, 15)},                                    // 6
                {new Comm_cost_pair(10, 17)},                                   // 7
                {new Comm_cost_pair(10, 11)},                                   // 8
                {new Comm_cost_pair(10, 13)},                                   // 9
                {new Comm_cost_pair(0, 0)}
        };

        for(int i=0;i<5;i++){
            for(int j=0;j<1;j++){
                System.out.println(dag[i][j].to_node);
            }
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<1;j++){
                System.out.println(processing_cost[i][j]);
            }
        }


    }
}



//            {
//            {},                                           // 0
//            {{2, 18}, {3, 12}, {4, 9}, {5, 11}, {6, 14}}, // 1
//            {{8, 19}, {9, 16}},                           // 2
//            {{7, 23}},                                    // 3
//            {{8, 27}, {9, 23}},                           // 4
//            {{9, 13}},                                    // 5
//            {{8, 15}},                                    // 6
//            {{10, 17}},                                   // 7
//            {{10, 11}},                                   // 8
//            {{10, 13}},                                   // 9
//            {}};                                          // 10
