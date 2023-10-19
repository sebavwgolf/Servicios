package com.ayudaencasa.app.controllers;

import com.ayudaencasa.app.criteria.PetWalkerCriteria;
import com.ayudaencasa.app.dto.input.CreatePetWalkerDTO;
import com.ayudaencasa.app.dto.input.SearchPetWalkerDTO;
import com.ayudaencasa.app.entities.PetWalker;
import com.ayudaencasa.app.services.PetWalkerService;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.StringFilter;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping ("/petWalker")
public class PetWalkerController {
    
    @Autowired
    private PetWalkerService petWalkerService;
    
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public PetWalker create (@Valid @RequestBody CreatePetWalkerDTO inputPetWalker){
        PetWalker petWalker = new PetWalker();
        if(inputPetWalker.getWorkingHoursTo() != null){
            petWalker.setHoursTo(inputPetWalker.getWorkingHoursTo());    
        }
        if(inputPetWalker.getWorkingHoursFrom() != null){
            petWalker.setHoursFrom(inputPetWalker.getWorkingHoursFrom());
        }
        BeanUtils.copyProperties(inputPetWalker,petWalker );
        return petWalkerService.create(petWalker);
    }
    
    @GetMapping("/list")
    public List <PetWalker> findAll (@RequestParam (required = false) String q){
        return petWalkerService.findAll();
    }
    
    @PostMapping("/filter")
    public ResponseEntity<List<PetWalker>> findByFilter (@RequestBody SearchPetWalkerDTO searchPetWalker){
        if(searchPetWalker.getWorkingHoursTo() != null){
            searchPetWalker.setHoursTo(searchPetWalker.getWorkingHoursTo());    
        }
        if(searchPetWalker.getWorkingHoursFrom() != null){
            searchPetWalker.setHoursFrom(searchPetWalker.getWorkingHoursFrom());
        }
        PetWalkerCriteria petWalkerCriteria = createCriteria (searchPetWalker);
        List <PetWalker> petWalkers = petWalkerService.findByCriteria(petWalkerCriteria);
        
        if(searchPetWalker.getDay() != null) {
            List<PetWalker> pet = new ArrayList<>();
            for (PetWalker petWalker : petWalkers){
                for (String day : petWalker.getDays()) {
                    if(day.equalsIgnoreCase(searchPetWalker.getDay())) {
                        pet.add(petWalker);
                    }
                } 
            }
            petWalkers = pet;
        }
        return new ResponseEntity<>(petWalkers, HttpStatus.OK);      
    }
    
    private PetWalkerCriteria createCriteria (SearchPetWalkerDTO searchPetWalker){
        PetWalkerCriteria petWalkerCriteria = new PetWalkerCriteria();
        if (searchPetWalker != null){
            if (searchPetWalker.getPetQuantityFrom()!= null || searchPetWalker.getPetQuantityTo()!= null) {
                IntegerFilter filter = new IntegerFilter ();
                if (searchPetWalker.getPetQuantityFrom()!= null ) {
                    filter.setGreaterThanOrEqual (searchPetWalker.getPetQuantityFrom());
                    petWalkerCriteria.setPetQuantity(filter);
                    }
                if (searchPetWalker.getPetQuantityTo()!= null ) {
                    filter.setLessThanOrEqual (searchPetWalker.getPetQuantityTo());
                    petWalkerCriteria.setPetQuantity(filter);
                }
            }
            if (!StringUtils.isBlank(searchPetWalker.getPetRace())) {
                StringFilter filter = new StringFilter();
                filter.setContains (searchPetWalker.getPetRace());
                petWalkerCriteria.setPetRace (filter);
            }
            if (!StringUtils.isBlank (searchPetWalker.getPetType())) {
                StringFilter filter = new StringFilter();
                filter.setContains (searchPetWalker.getPetType());
                petWalkerCriteria.setPetType (filter);
            }
            if(searchPetWalker.getSalaryFrom()!= null || searchPetWalker.getSalaryTo()!= null){
                IntegerFilter filter = new IntegerFilter();
                if(searchPetWalker.getSalaryFrom() != null){
                    filter.setGreaterThanOrEqual(searchPetWalker.getSalaryFrom());
                    petWalkerCriteria.setSalary(filter);
                }
                if(searchPetWalker.getSalaryTo() != null){
                    filter.setLessThanOrEqual(searchPetWalker.getSalaryTo());
                    petWalkerCriteria.setSalary(filter);
                }
            }
            if(!StringUtils.isBlank(searchPetWalker.getWorkingZone())){
                StringFilter filter = new StringFilter();
                filter.setContains(searchPetWalker.getWorkingZone());
                petWalkerCriteria.setWorkingZone(filter);
            }
            if(!StringUtils.isBlank(searchPetWalker.getDescription())){
                StringFilter filter = new StringFilter();
                filter.setContains(searchPetWalker.getDescription());
                petWalkerCriteria.setDescription(filter);
            }
            if(searchPetWalker.getWorkingHoursFrom() != null) {           
                IntegerFilter filter = new IntegerFilter();
                filter.setLessThanOrEqual(searchPetWalker.getHoursFrom());
                petWalkerCriteria.setHoursFrom(filter);
            }
            if(searchPetWalker.getWorkingHoursTo() != null){               
                IntegerFilter filter = new IntegerFilter();
                filter.setGreaterThanOrEqual(searchPetWalker.getHoursTo());
                petWalkerCriteria.setHoursTo(filter);
            }    
        }
        return petWalkerCriteria;
    }
    
    @GetMapping("")
    public PetWalker findById (@RequestParam String id){
        return petWalkerService.findById(id);
    }
    
    @GetMapping ("/delete")
    public void delete (String id){
        petWalkerService.delete(id);
    }
    
    @PostMapping("/update")
    public void update (String id, PetWalker newPetWalker){
        petWalkerService.update(id, newPetWalker);
        
    }
}
