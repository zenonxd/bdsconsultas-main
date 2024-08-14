package com.devsuperior.uri2602.repositories;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomRepository extends JpaRepository<Customer, Long> {
    //nativeQuery = SQL raíz, não SJPQL
    @Query(nativeQuery = true, value = "SELECT name "
    + "FROM customers "
    + "WHERE UPPER(state) = UPPER(:state)")
    List<CustomerMinProjection> search1(String state);

    /*
    leia-se: "SELECT new (objetos desse tipo 👇 + o nome do construtor
    customizado que criamos. "obj.name" pois o apelido que damos para
    cada objeto que vamos buscar, é obj.
    */
    @Query("SELECT new com.devsuperior.uri2602.dto.CustomerMinDTO(obj.name) "
    + "FROM Customer obj "
    + "WHERE upper(obj.state) = upper(:state) ")
    List<CustomerMinDTO> search2(String state);
}
