package org.agoncal.fascicle.jpa.integrating.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unused")
// tag::adocSnippet[]
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

  List<Address> findAllByCountry(@Param("country") String country);

  @Query("SELECT a FROM Address a WHERE a.zipcode LIKE %:zip%")
  List<Address> findAllLikeZip(@Param("zip") String zip);
}
// end::adocSnippet[]
