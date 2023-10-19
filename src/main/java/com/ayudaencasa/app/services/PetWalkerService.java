package com.ayudaencasa.app.services;

import com.ayudaencasa.app.criteria.PetWalkerCriteria;
import com.ayudaencasa.app.entities.PetWalker;
import com.ayudaencasa.app.exceptions.PetWalkerNotFoundException;
import java.util.List;

public interface PetWalkerService {

    public PetWalker create(PetWalker petWalker);

    public void update(String id, PetWalker petWalker) throws PetWalkerNotFoundException;

    public void delete(String id) throws PetWalkerNotFoundException;

    public PetWalker findById(String id) throws PetWalkerNotFoundException;
    
    public List <PetWalker> findAll();
    
    public List<PetWalker> findByCriteria(PetWalkerCriteria petWalkerCriteria);

}
