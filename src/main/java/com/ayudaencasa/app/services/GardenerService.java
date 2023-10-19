/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ayudaencasa.app.services;

import com.ayudaencasa.app.criteria.GardenerCriteria;
import com.ayudaencasa.app.entities.Gardener;
import com.ayudaencasa.app.exceptions.GardenerNotFoundException;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Usr
 */
public interface GardenerService {
    
    public Gardener create(Gardener gardener);
    public void update(String id, Gardener gardener) throws GardenerNotFoundException;
    public void delete(String id) throws GardenerNotFoundException;
    public Gardener findById(String id) throws GardenerNotFoundException;
    public List<Gardener> findAll();
    public List<Gardener> findByCriteria(GardenerCriteria gardenerCriteria);
//    @Query("SELECT g FROM :gardeners WHERE :day IN g.days")
//    public List<Gardener> findByDay(String day, List<Gardener> gardeners);
    
}
