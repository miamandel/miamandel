package at.htl.model;

public class EmployeeResult {
    Employee employee;
    long count;

    public EmployeeResult(Employee employee, long count) {
        this.employee = employee;
        this.count = count;
    }

    public Employee getEmployee() {
        return employee;
    }

    public long getCount() {
        return count;
    }
}
