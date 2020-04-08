package com.iqbusiness.registration.repositories;

import com.iqbusiness.registration.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
//    @Query("DELETE p FROM Person p WHERE f.id_number = idNumber")
//    void removeByIdNumber(@Param("idNumber") String idNumber);
    Person findByIdNumber(String idNumber);

}
