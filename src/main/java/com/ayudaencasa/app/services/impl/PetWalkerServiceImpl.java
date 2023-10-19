package com.ayudaencasa.app.services.impl;

import com.ayudaencasa.app.criteria.PetWalkerCriteria;
import com.ayudaencasa.app.entities.PetWalker;
import com.ayudaencasa.app.entities.PetWalker_;
import com.ayudaencasa.app.exceptions.PetWalkerNotFoundException;
import com.ayudaencasa.app.repositories.PetWalkerRepository;
import com.ayudaencasa.app.services.PetWalkerService;
import io.github.jhipster.service.QueryService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class PetWalkerServiceImpl extends QueryService<PetWalker> implements PetWalkerService{
    
    @Autowired
    private PetWalkerRepository petWalkerRepo;
    
    @Autowired
    private ModelMapper modelMapper;
    
    private Specification<PetWalker> createSpecification(PetWalkerCriteria petWalkerCriteria) {
        Specification<PetWalker> specification = Specification.where(null);
        if (petWalkerCriteria != null) {
            if (petWalkerCriteria.getPetQuantity() != null) {
                specification = specification.and(buildRangeSpecification(petWalkerCriteria.getPetQuantity(), PetWalker_.petQuantity));
            }
            if (petWalkerCriteria.getPetType() != null) {
                specification = specification.and(buildStringSpecification(petWalkerCriteria.getPetType(), PetWalker_.petType));
            }
            if (petWalkerCriteria.getPetRace() != null) {
                specification = specification.and(buildSpecification(petWalkerCriteria.getPetRace(), PetWalker_.petRace));
            }
            if (petWalkerCriteria.getSalary() != null) {
                specification = specification.and(buildRangeSpecification(petWalkerCriteria.getSalary(), PetWalker_.salary));
            }
            if (petWalkerCriteria.getWorkingZone() != null) {
                specification = specification.and(buildStringSpecification(petWalkerCriteria.getWorkingZone(), PetWalker_.workingZone));
            }
            if (petWalkerCriteria.getDescription() != null) {
                specification = specification.and(buildStringSpecification(petWalkerCriteria.getDescription(), PetWalker_.description));
            }
            if(petWalkerCriteria.getHoursFrom() != null){
                
                specification = specification.and(buildRangeSpecification(petWalkerCriteria.getHoursFrom(), PetWalker_.hoursFrom));
            }
            if(petWalkerCriteria.getHoursTo() != null){
                specification = specification.and(buildRangeSpecification(petWalkerCriteria.getHoursTo(), PetWalker_.hoursTo));
            }
        }
        return specification;
    }

    @Override
    public List<PetWalker> findByCriteria(PetWalkerCriteria petWalkerCriteria) {
        final Specification<PetWalker> specification = createSpecification(petWalkerCriteria);
        List<PetWalker> petWalkers = petWalkerRepo.findAll(specification);
        return petWalkers;
    }
    
    @Override
    @Transactional
    public PetWalker create (@NonNull PetWalker petWalker){
        return petWalkerRepo.save(petWalker);
    }
    
    @Override
    @Transactional
    public void update (@NonNull String id, @NonNull PetWalker newPetWalker) throws PetWalkerNotFoundException{
    Optional <PetWalker> opt = petWalkerRepo.findById(id);
        if (opt.isPresent()) {
            PetWalker petWalker = opt.get();
            modelMapper.map (newPetWalker, petWalker);
            petWalkerRepo.save(petWalker);
        } else{
            throw new PetWalkerNotFoundException();
        }
    }
    
    @Override
    @Transactional
    public void delete (@NonNull String id){
        Optional <PetWalker> opt = petWalkerRepo.findById(id);
          if (opt.isPresent()) {
          petWalkerRepo.delete(opt.get());
          } else {
              throw new PetWalkerNotFoundException();
          }
    }
    
    @Override
    public PetWalker findById (@NonNull String id){
        Optional <PetWalker> opt = petWalkerRepo.findById(id);
        if (opt.isPresent()){
            return opt.get();
        } else {
              throw new PetWalkerNotFoundException();
          }
    }
    
    @Override
    public List <PetWalker> findAll(){
        return petWalkerRepo.findAll();
    }
    
}
