package org.example.evaltest.repository;

import org.example.evaltest.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeRepository extends JpaRepository<Time, Integer> {
    List<Time> findAllByOrderByHeureDesc();
}
