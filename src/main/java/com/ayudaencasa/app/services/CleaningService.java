package com.ayudaencasa.app.services;

import com.ayudaencasa.app.criteria.CleaningCriteria;
import com.ayudaencasa.app.entities.Cleaning;
import com.ayudaencasa.app.exceptions.CleaningNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CleaningService {

    public Cleaning create(Cleaning cleaning);
           
    public void update(String id, Cleaning cleaning);
    
    public void delete(String id) throws CleaningNotFoundException;
    
    public Cleaning findById(String id) throws CleaningNotFoundException;
    
    public List<Cleaning> findAll();
    
    public List<Cleaning> findByCriteria(CleaningCriteria cleaningCriteria);
    
    
    
    
    
//    public Cleaning create(@NonNull Integer rooms, Boolean exteriors, Boolean cooking, Boolean laundry, Boolean ironing, Integer salary, String workingZone, Date dateFrom, Date dateTo, Boolean status) {
//
//        Cleaning cleaning = new Cleaning();
//        cleaning.setRooms(rooms);
//        cleaning.setExteriors(exteriors);
//        cleaning.setCooking(cooking);
//        cleaning.setLaundry(laundry);
//        cleaning.setIroning(ironing);
//        cleaning.setSalary(salary);
//        cleaning.setWorkingZone(workingZone);
//        cleaning.setDateFrom(dateFrom);
//        cleaning.setDateTo(dateTo);
//        cleaning.setStatus(status);
//
//        return cleaningRepository.save(cleaning);
//
//    }
    
//    public void update(@NonNull String id, Integer rooms, Boolean exteriors, Boolean cooking, Boolean laundry, Boolean ironing, Integer salary, String workingZone, Date dateFrom, Date dateTo, Boolean status) {
//        Cleaning cleaning = cleaningRepository.findById(id).get();
//        cleaning.setRooms(rooms);
//        cleaning.setExteriors(exteriors);
//        cleaning.setCooking(cooking);
//        cleaning.setLaundry(laundry);
//        cleaning.setIroning(ironing);
//        cleaning.setSalary(salary);
//        cleaning.setWorkingZone(workingZone);
//        cleaning.setDateFrom(dateFrom);
//        cleaning.setDateTo(dateTo);
//        cleaning.setStatus(status);
//        
//        cleaningRepository.save(cleaning);
//
//    }
    
//    public void delete(String id, Date deleteAt ) {
//        Cleaning cleaning = cleaningRepository.findById(id).get();
//        cleaning.setDeletedAt(deleteAt);
//        
//    }

//    public Cleaning findById(@NonNull String id) {
//        Cleaning cleaning = cleaningRepository.findById(id).get();
//        
//        return cleaningRepository.getById(id);
//
//    }
//
//    public List<Cleaning> findAll(@NonNull String id) {
//        
//        
//        return cleaningRepository.findAll();
//
//    }
}
