package com.nycsagnes.beehive.repository;

import com.nycsagnes.beehive.domain.Hive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HiveRepository extends JpaRepository<Hive, Long> {
}
