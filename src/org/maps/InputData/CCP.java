package org.maps.InputData;

/**
 * Communication Cost Pair
 */
public class CCP {
    public final int to_node;
    public final int comm_cost;

    CCP(int to_node, int comm_cost) {
        this.to_node = to_node;
        this.comm_cost = comm_cost;
    }
}
