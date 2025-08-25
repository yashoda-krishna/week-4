package com.example.JPA.Repository;


    import com.example.JPA.Entity.Customer;
    import org.springframework.data.domain.Example;
    import org.springframework.data.jpa.repository.*;
    import org.springframework.data.repository.query.FluentQuery;
    import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;
import java.util.List;
    import java.util.function.Function;

@Repository
    public interface CustomerRepository extends JpaRepository<Customer, Long> {

        // READ
        @Query(value= "SELECT * FROM customers WHERE id = :id", nativeQuery = true)
        Customer findByIdNative(@Param("id") Long id);





   @Query(value = "SELECT * FROM customers", nativeQuery = true)
        List<Customer> findAllNative();

        // UPDATE
        @Modifying
        @Transactional
        @Query(value = "UPDATE customers SET name = :name, email = :email, status = :status,payment= :=payment WHERE id = :id", nativeQuery = true)
        int updateCustomer(@Param("id") Long id,
                           @Param("name") String name,
                           @Param("email") String email,
                           @Param("status") String status,
                           @Param("payment") Long payment);

        // DELETE
        @Modifying
        @Transactional
        @Query(value = "DELETE FROM customers WHERE id = :id", nativeQuery = true)
        int deleteByIdNative(@Param("id") Long id);
    }


