package com.ayudaencasa.app.controllers;

import com.ayudaencasa.app.criteria.CaregiverCriteria;
import com.ayudaencasa.app.dto.input.CreateCaregiverDTO;
import com.ayudaencasa.app.dto.input.SearchCaregiverDTO;
import com.ayudaencasa.app.entities.Caregiver;
import com.ayudaencasa.app.services.CaregiverService;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.StringFilter;
import java.util.ArrayList;
import java.util.List;
//import javax.validation.Valid;
import net.logstash.logback.encoder.org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Validated
@RequestMapping("/caregiver")
public class CaregiverController {

    @Autowired
    private CaregiverService caregiverService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public Caregiver create(@RequestBody CreateCaregiverDTO inputCaregiver) {
        Caregiver caregiver = new Caregiver();
        if(inputCaregiver.getWorkingHoursTo() != null){
            caregiver.setHoursTo(inputCaregiver.getWorkingHoursTo());    
        }
        if(inputCaregiver.getWorkingHoursFrom() != null){
            caregiver.setHoursFrom(inputCaregiver.getWorkingHoursFrom());
        }
        BeanUtils.copyProperties(inputCaregiver, caregiver);
        return caregiverService.create(caregiver);
    }
    
    @GetMapping("/list")
    public List<Caregiver> findAll(@RequestParam(required = false) String q) {
        return caregiverService.findAll();
    }
    
    @PostMapping("/filter")
    public ResponseEntity<List<Caregiver>> findByFilter(@RequestBody SearchCaregiverDTO searchCaregiver) {    
        if(searchCaregiver.getWorkingHoursTo() != null){
            searchCaregiver.setHoursTo(searchCaregiver.getWorkingHoursTo());    
        }
        if(searchCaregiver.getWorkingHoursFrom() != null){
            searchCaregiver.setHoursFrom(searchCaregiver.getWorkingHoursFrom());
        }
        CaregiverCriteria caregiverCriteria = createCriteria(searchCaregiver);
        List<Caregiver> caregivers = caregiverService.findByCriteria(caregiverCriteria);
       
        if(searchCaregiver.getDay() != null) {
            List<Caregiver> car = new ArrayList<>();
            for (Caregiver caregiver : caregivers){
                for (String day : caregiver.getDays()) {
                    if(day.equalsIgnoreCase(searchCaregiver.getDay())) {
                        car.add(caregiver);
                    }
                } 
            }
            caregivers = car;
        }  
        return new ResponseEntity<>(caregivers, HttpStatus.OK);
    }
    
    private CaregiverCriteria createCriteria(SearchCaregiverDTO searchCaregiver){
        CaregiverCriteria caregiverCriteria = new CaregiverCriteria();
        if(searchCaregiver != null){
            if(searchCaregiver.getQuantityFrom() != null || searchCaregiver.getQuantityTo() != null){
                IntegerFilter filter = new IntegerFilter();
                if(searchCaregiver.getQuantityFrom() != null){
                    filter.setGreaterThanOrEqual(searchCaregiver.getQuantityFrom());
                    caregiverCriteria.setQuantity(filter);
                }
                if(searchCaregiver.getQuantityTo() != null){
                    filter.setLessThanOrEqual(searchCaregiver.getQuantityTo());
                    caregiverCriteria.setQuantity(filter);
                }
            }
            if(searchCaregiver.getAgeFrom() != null){
                IntegerFilter filter = new IntegerFilter();
                filter.setGreaterThanOrEqual(searchCaregiver.getAgeFrom());
                caregiverCriteria.setAgeFrom(filter);       
            }
            if(searchCaregiver.getAgeTo() != null){
                IntegerFilter filter = new IntegerFilter();
                filter.setLessThanOrEqual(searchCaregiver.getAgeTo());
                caregiverCriteria.setAgeTo(filter);       
            }
            if(!StringUtils.isBlank(searchCaregiver.getCooking())){
                BooleanFilter filter = new BooleanFilter();
                switch(searchCaregiver.getCooking()){
                    case "true":
                        filter.setEquals(true);
                        break;
                    case "false":
                        filter.setEquals(false);
                        break;
                    default:
                        filter.setEquals(false);        
                }
                caregiverCriteria.setCooking(filter);
            }
            if(!StringUtils.isBlank(searchCaregiver.getCleaningPeople())){
                BooleanFilter filter = new BooleanFilter();
                switch(searchCaregiver.getCleaningPeople()){
                    case "true":
                        filter.setEquals(true);
                        break;
                    case "false":
                        filter.setEquals(false);
                        break;
                    default:
                        filter.setEquals(false);        
                }
                caregiverCriteria.setCleaningPeople(filter);
            }
            if(!StringUtils.isBlank(searchCaregiver.getTranfering())){
                BooleanFilter filter = new BooleanFilter();
                switch(searchCaregiver.getTranfering()){
                    case "true":
                        filter.setEquals(true);
                        break;
                    case "false":
                        filter.setEquals(false);
                        break;
                    default:
                        filter.setEquals(false);        
                }
                caregiverCriteria.setTranfering(filter);
            }
            if(searchCaregiver.getSalaryFrom()!= null || searchCaregiver.getSalaryTo()!= null){
                IntegerFilter filter = new IntegerFilter();
                if(searchCaregiver.getSalaryFrom() != null){
                    filter.setGreaterThanOrEqual(searchCaregiver.getSalaryFrom());
                    caregiverCriteria.setSalary(filter);
                }
                if(searchCaregiver.getSalaryTo() != null){
                    filter.setLessThanOrEqual(searchCaregiver.getSalaryTo());
                    caregiverCriteria.setSalary(filter);
                }
            }
            if(!StringUtils.isBlank(searchCaregiver.getWorkingZone())){
                StringFilter filter = new StringFilter();
                filter.setContains(searchCaregiver.getWorkingZone());
                caregiverCriteria.setWorkingZone(filter);
            }
            if(!StringUtils.isBlank(searchCaregiver.getDescription())){
                StringFilter filter = new StringFilter();
                filter.setContains(searchCaregiver.getDescription());
                caregiverCriteria.setDescription(filter);
            }
            if(searchCaregiver.getWorkingHoursFrom() != null) {           
                IntegerFilter filter = new IntegerFilter();
                filter.setLessThanOrEqual(searchCaregiver.getHoursFrom());
                caregiverCriteria.setHoursFrom(filter);
            }
            if(searchCaregiver.getWorkingHoursTo() != null){               
                IntegerFilter filter = new IntegerFilter();
                filter.setGreaterThanOrEqual(searchCaregiver.getHoursTo());
                caregiverCriteria.setHoursTo(filter);
            }
        }
        return caregiverCriteria;
    }
    
    
    @GetMapping("")
    public Caregiver findById(@RequestParam String id) throws Exception {
        return caregiverService.findById(id);
    }
     
    @PostMapping("/delete")
    public void delete(@RequestParam String id) throws Exception {
        caregiverService.delete(id);
    }
    
    @PostMapping("/update")
    public void update(@RequestParam String id, Caregiver newCaregiver) throws Exception {
        caregiverService.update(id, newCaregiver);
    }
}
