package com.mrepis.gdtrackerback.repository;

import com.mrepis.gdtrackerback.model.Demon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemonRepository extends JpaRepository<Demon, Long> {

}
