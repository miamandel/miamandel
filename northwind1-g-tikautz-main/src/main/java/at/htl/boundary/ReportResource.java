package at.htl.boundary;

import at.htl.model.*;
import at.htl.repository.ReportRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/report")
public class ReportResource {
    @Inject
    ReportRepository reportRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/employee_max_orders")
    public EmployeeResult maxOrders() {
        return reportRepository.getEmployeeWithMaxOrders();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/revenue_per_category")
    public List<ResultODT> revenuePerCategory() {
        return reportRepository.getRevenuePerCategory();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/top_shipper_per_region")
    public List<ShipperResult> topShipperPerRegion() {
        return reportRepository.getTopShipperPerRegion();
    }
}
