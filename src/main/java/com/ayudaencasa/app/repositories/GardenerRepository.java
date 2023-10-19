package com.ayudaencasa.app.repositories;

import com.ayudaencasa.app.entities.Gardener;
import org.springframework.stereotype.Repository;

@Repository
public interface GardenerRepository extends JobRepository<Gardener>{
    
}
