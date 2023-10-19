package com.ayudaencasa.app.controllers;

import com.ayudaencasa.app.criteria.OtherCriteria;
import com.ayudaencasa.app.dto.input.CreateOtherDTO;
import com.ayudaencasa.app.dto.input.SearchOtherDTO;
import com.ayudaencasa.app.entities.Other;
import com.ayudaencasa.app.services.OtherService;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.StringFilter;
import java.util.ArrayList;
import java.util.List;
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
@RequestMapping("/other")
public class OtherController {
    
    @Autowired
    private OtherService otherService;
    
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public Other create(@RequestBody CreateOtherDTO inputOther) {
        Other other = new Other();
        if(inputOther.getWorkingHoursTo() != null){
            other.setHoursTo(inputOther.getWorkingHoursTo());    
        }
        if(inputOther.getWorkingHoursFrom() != null){
            other.setHoursFrom(inputOther.getWorkingHoursFrom());
        }
        BeanUtils.copyProperties(inputOther, other);
        return otherService.create(other);
    }
    
    @GetMapping("/list")
    public List<Other> findAll(@RequestParam(required = false) String q) {
        return otherService.findAll();
    }
    
    @PostMapping("/filter")
    public ResponseEntity<List<Other>> findByFilter(@RequestBody SearchOtherDTO searchOther) {    
        if(searchOther.getWorkingHoursTo() != null){
            searchOther.setHoursTo(searchOther.getWorkingHoursTo());    
        }
        if(searchOther.getWorkingHoursFrom() != null){
            searchOther.setHoursFrom(searchOther.getWorkingHoursFrom());
        }
        OtherCriteria otherCriteria = createCriteria(searchOther);
        List<Other> others = otherService.findByCriteria(otherCriteria);
       
        if(searchOther.getDay() != null) {
            List<Other> ot = new ArrayList<>();
            for (Other other : others){
                for (String day : other.getDays()) {
                    if(day.equalsIgnoreCase(searchOther.getDay())) {
                        ot.add(other);
                    }
                } 
            }
            others = ot;
        }  
        return new ResponseEntity<>(others, HttpStatus.OK);
    }
    
    private OtherCriteria createCriteria(SearchOtherDTO searchOther){
        OtherCriteria otherCriteria = new OtherCriteria();
        if(searchOther != null){
            if(!StringUtils.isBlank(searchOther.getType())){
                StringFilter filter = new StringFilter();
                otherCriteria.setType(filter);
            }         
            if(searchOther.getSalaryFrom()!= null || searchOther.getSalaryTo()!= null){
                IntegerFilter filter = new IntegerFilter();
                if(searchOther.getSalaryFrom() != null){
                    filter.setGreaterThanOrEqual(searchOther.getSalaryFrom());
                    otherCriteria.setSalary(filter);
                }
                if(searchOther.getSalaryTo() != null){
                    filter.setLessThanOrEqual(searchOther.getSalaryTo());
                    otherCriteria.setSalary(filter);
                }
            }
            if(!StringUtils.isBlank(searchOther.getWorkingZone())){
                StringFilter filter = new StringFilter();
                filter.setContains(searchOther.getWorkingZone());
                otherCriteria.setWorkingZone(filter);
            }
            if(!StringUtils.isBlank(searchOther.getDescription())){
                StringFilter filter = new StringFilter();
                filter.setContains(searchOther.getWorkingZone());
                otherCriteria.setDescription(filter);
            }
            if(searchOther.getWorkingHoursFrom() != null) {           
                IntegerFilter filter = new IntegerFilter();
                filter.setLessThanOrEqual(searchOther.getHoursFrom());
                otherCriteria.setHoursFrom(filter);
            }
            if(searchOther.getWorkingHoursTo() != null){               
                IntegerFilter filter = new IntegerFilter();
                filter.setGreaterThanOrEqual(searchOther.getHoursTo());
                otherCriteria.setHoursTo(filter);
            }
        }
        return otherCriteria;
    }
    
    @GetMapping("")
    public Other findById(@RequestParam String id) {
        return otherService.findById(id);
    }    
    
    @PostMapping("/delete")
    public void delete(@RequestParam String id) {
        otherService.delete(id);
    }
    
    @PostMapping("/update")
    public void update(@RequestParam String id, Other newOther) {
        otherService.update(id, newOther);
    }
    
}
