package at.htl.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Employeeterritories implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "EMPLOYEEID", referencedColumnName = "EMPLOYEEID", nullable = false)
    private Employee employeesByEmployeeid;

    @Id
    @ManyToOne
    @JoinColumn(name = "TERRITORYID", referencedColumnName = "TERRITORYID", nullable = false)
    private Territory territoriesByTerritoryid;

    public Employee getEmployeesByEmployeeid() {
        return employeesByEmployeeid;
    }

    public void setEmployeesByEmployeeid(Employee employeesByEmployeeid) {
        this.employeesByEmployeeid = employeesByEmployeeid;
    }

    public Territory getTerritoriesByTerritoryid() {
        return territoriesByTerritoryid;
    }

    public void setTerritoriesByTerritoryid(Territory territoriesByTerritoryid) {
        this.territoriesByTerritoryid = territoriesByTerritoryid;
    }
}
