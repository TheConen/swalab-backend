package com.swalab.backend.model;

import java.util.List;

public class Warehouse {
    
    private List<WarehousePartAndOrder> partAndOrders;

    public Warehouse() {
    }

    public Warehouse(List<WarehousePartAndOrder> partAndOrders) {
        this.partAndOrders = partAndOrders;
    }

    public List<WarehousePartAndOrder> getPartAndOrders() {
        return partAndOrders;
    }

    public void setPartAndOrders(List<WarehousePartAndOrder> partAndOrders) {
        this.partAndOrders = partAndOrders;
    }

    public void addPartOrOrder(WarehousePartAndOrder partAndOrder) {
        partAndOrders.add(partAndOrder);
    }
}
