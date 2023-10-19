package com.ayudaencasa.app.repositories;

import com.ayudaencasa.app.entities.Cleaning;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CleaningRepository extends JobRepository<Cleaning> {
  
    @Query("SELECT c FROM Cleaning c WHERE c.rooms = :rooms")
    List <Cleaning> findRooms(@Param("rooms")Integer rooms);
   
}
