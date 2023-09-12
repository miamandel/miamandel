package at.htl.model;

public class ResultODT {
    private String name;
    private double revenue;

    public ResultODT(String name, double revenue) {
        this.name = name;
        this.revenue = revenue;
    }

    public String getName() {
        return name;
    }

    public double getRevenue() {
        return revenue;
    }
}
