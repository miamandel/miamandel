package at.htl.repository;


import at.htl.model.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ReportRepository {
    @Inject
    EntityManager em;

    public EmployeeResult getEmployeeWithMaxOrders(){
        return em.createQuery("Select NEW at.htl.model.EmployeeResult(e,count(o))" +
                " from Order o" +
                " join o.employeesByEmployeeid e" +
                " group by e" +
                " having count(o) >= ALL (" +
                " select count(o2) from Order o2" +
                " group by o2.employeesByEmployeeid" +
                "    ) order by count(o) desc", EmployeeResult.class).getResultList().get(0);
    }

    public List<ResultODT> getRevenuePerCategory(){

        return (List<ResultODT>) em.createQuery("select NEW at.htl.model.ResultODT(c.categoryname, sum(od.unitprice * od.quantity))" +
                " from Orderdetail od " +
                " join od.productsByProductid p " +
                " join p.categoriesByCategoryid c " +
                " group by c.categoryname order by sum(od.unitprice * od.quantity) desc ",ResultODT.class).getResultList();
    }

    public List<ShipperResult> getTopShipperPerRegion(){

        return em.createQuery("select NEW at.htl.model.ShipperResult(s.companyname,o.territoriesByTerritoryid.regionByRegionid.regiondescription, count(o))" +
                " from Order o" +
                " join o.shippersByShipvia s" +
                " group by o" +
                " having count(o) >= ALL (" +
                " select count(o2) from Order o2" +
                " group by o2.shipregion" +
                "    ) order by count(o) desc",ShipperResult.class).getResultList();
    }


}
