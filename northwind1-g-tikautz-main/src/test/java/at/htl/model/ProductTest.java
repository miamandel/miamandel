package at.htl.model;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class ProductTest {
/*    @Inject
    EntityManager em;

    @Test
    void testSelectAllProducts(){
        // sql: select * from product
        // jpql: select p from Product p => CASE SENSITIVE!!
        TypedQuery<Product> q = em.createQuery("select p from Product p", Product.class);

        List<Product> result = q.getResultList();

        for(Product p : result){
            System.out.printf("%5d %20s\n", p.getProductid(), p.getProductname());
        }

    }

    @Test
    void testSelectAllProductsWithCategory(){
        // sql: select * from product, category c where p.categoryid = c.categoryid
        // sql: select * from product p join category c (p.categoryid = c.categoryid)
        // sql: select * from product p join category c using (categoryid)

        // jpql: select p from Product p
        TypedQuery<Product> q = em.createQuery("select p from Product p", Product.class);

        List<Product> result = q.getResultList();

        for(Product p : result){
            System.out.printf("%5d %20s %20s\n", p.getProductid(), p.getProductname(), p.getCategoriesByCategoryid().getCategoryname());
        }

    }

    @Test
    void testSelectProductsByName(){
        // sql: select * from product where productname = 'Chocolate'

        // jpql: select p from Product p where p.productname = ?1
        // jpql: select p from Product p where p.productname = :pname
        String pName = "Chocolade";

        TypedQuery<Product> q = em.createQuery("select p from Product p where p.productname = :pname", Product.class);
        q.setParameter("pname", pName);

        List<Product> result = q.getResultList();

        for(Product p : result){
            System.out.printf("%5d %20s %20s\n", p.getProductid(), p.getProductname(), p.getCategoriesByCategoryid().getCategoryname());
        }

    }

    @Test
    void testNamedQuery(){
        TypedQuery<Product> q = em.createNamedQuery(
                Product.PRODUCT_FINDBYNAME, Product.class
        );

        q.setParameter("pname", "Chocolade");
        List<Product> result = q.getResultList();

        for(Product p:result){
            System.out.println(p.getProductname());
        }
    }

    @Test
    void cntProductsPerCat(){
        // SQL:
        TypedQuery<ResultODT> q = em.createQuery("select NEW at.htl.model.ResultODT (c.categoryname, count(p)) " +
                "from Category c left join c p " +
                "group by c.categoryname ", ResultODT.class);
        List<ResultODT> result = q.getResultList();

        for(ResultODT o : result){
            System.out.printf("%-30s: %5d\n", o.getName(), o.getRevenue());
        }
    }


     */

}