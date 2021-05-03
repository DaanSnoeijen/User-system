package com.example.demo.Datalayer;

import com.example.demo.Entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepo extends JpaRepository<PlayerEntity, Long> {

    @Query("SELECT a FROM PlayerEntity a WHERE a.username = ?1 AND a.password = ?2")
    PlayerEntity FindByUserNameAndPassword(String Username, String Password);
}
