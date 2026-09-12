package com.example.patient;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

//Remove @RepositoryRestResource below to disable auto REST api:
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

}

    

