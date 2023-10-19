/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ayudaencasa.app.services;

import com.ayudaencasa.app.criteria.OtherCriteria;
import com.ayudaencasa.app.entities.Other;
import com.ayudaencasa.app.exceptions.OtherNotFoundException;
import java.util.List;

/**
 *
 * @author Usr
 */
public interface OtherService {
    
    public Other create(Other other);
    public void update(String id, Other other) throws OtherNotFoundException;
    public void delete(String id) throws OtherNotFoundException;
    public Other findById(String id) throws OtherNotFoundException;
    public List<Other> findAll();
    public List<Other> findByCriteria(OtherCriteria otherCriteria);
    
}
