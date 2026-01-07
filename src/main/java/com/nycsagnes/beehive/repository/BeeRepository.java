package com.nycsagnes.beehive.repository;

import com.nycsagnes.beehive.domain.Bee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeeRepository extends JpaRepository<Bee, Long> {
}
