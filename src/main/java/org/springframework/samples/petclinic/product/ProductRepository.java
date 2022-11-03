package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.owner.Owner;



public interface ProductRepository extends CrudRepository<Product, Integer>{
    List<Product> findAll();
    
    @Query("SELECT pt FROM ProductType pt")
    List<ProductType> findAllProductTypes();
    
    @Query("SELECT pt FROM ProductType pt WHERE pt.name = :name")
    ProductType findProductTypeByName(@Param("name") String name);
    
    @Query("SELECT p FROM Product p WHERE p.price < :price")
    List<Product> findByPriceLessThan(@Param("price") double price); //debería crearse solo
    
    Optional<Product> findById(int id);
    
    Product findByName(String name);
    
    Product save(Product p) throws DataAccessException;
}
