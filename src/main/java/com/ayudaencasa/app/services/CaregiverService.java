package com.ayudaencasa.app.services;

import com.ayudaencasa.app.criteria.CaregiverCriteria;
import com.ayudaencasa.app.entities.Caregiver;
import java.util.List;

public interface CaregiverService {

public Caregiver create(Caregiver caregiver);
    public void update(String id, Caregiver newCaregiver)throws Exception;
    public void delete(String id)throws Exception;
    public Caregiver findById(String id) throws Exception;
    public List<Caregiver> findAll();
    public List<Caregiver> findByCriteria(CaregiverCriteria caregiverCriteria);
    
 
  
}