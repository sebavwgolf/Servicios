package com.ayudaencasa.app.services.impl;

import com.ayudaencasa.app.criteria.OtherCriteria;
import com.ayudaencasa.app.entities.Other;
import com.ayudaencasa.app.entities.Other_;
import com.ayudaencasa.app.exceptions.OtherNotFoundException;
import com.ayudaencasa.app.repositories.OtherRepository;
import com.ayudaencasa.app.services.OtherService;
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
public class OtherServiceImpl extends QueryService<Other> implements OtherService {
    
    @Autowired
    private OtherRepository otherRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    private Specification<Other> createSpecification(OtherCriteria otherCriteria) {
        Specification<Other> specification = Specification.where(null);
        if (otherCriteria != null) {
            if (otherCriteria.getType() != null) {
                specification = specification.and(buildStringSpecification(otherCriteria.getType(), Other_.type));
            }
            if (otherCriteria.getSalary() != null) {
                specification = specification.and(buildRangeSpecification(otherCriteria.getSalary(), Other_.salary));
            }
            if (otherCriteria.getWorkingZone() != null) {
                specification = specification.and(buildStringSpecification(otherCriteria.getWorkingZone(), Other_.workingZone));
            }
            if (otherCriteria.getDescription() != null) {
                specification = specification.and(buildStringSpecification(otherCriteria.getDescription(), Other_.description));
            }
            if(otherCriteria.getHoursFrom() != null){
                
                specification = specification.and(buildRangeSpecification(otherCriteria.getHoursFrom(), Other_.hoursFrom));
            }
            if(otherCriteria.getHoursTo() != null){
                specification = specification.and(buildRangeSpecification(otherCriteria.getHoursTo(), Other_.hoursTo));
            }
        }
        return specification;
    }

    @Override
    public List<Other> findByCriteria(OtherCriteria gardenerCriteria) {
        final Specification<Other> specification = createSpecification(gardenerCriteria);
        List<Other> others = otherRepository.findAll(specification);
        return others;
    }
    
    @Override
    @Transactional
    public Other create(@NonNull Other other) {
        return otherRepository.save(other);
    }

    @Override
    @Transactional
    public void update(@NonNull String id, @NonNull Other newOther) throws OtherNotFoundException {
        Optional<Other> opt = otherRepository.findById(id);
        if(opt.isPresent()){
            Other other = opt.get();
            modelMapper.map(newOther, other);
            otherRepository.save(other);
        } else {
            throw new OtherNotFoundException();
        }
    }

    @Override
    @Transactional
    public void delete(@NonNull String id) {
        Optional<Other> opt = otherRepository.findById(id);
        if(opt.isPresent()){
            otherRepository.delete(opt.get());
        } else {
            throw new OtherNotFoundException();
        }
    }

    @Override
    public Other findById(@NonNull String id) {
        Optional<Other> opt = otherRepository.findById(id);
        if(opt.isPresent()){
            return opt.get();
        } else {
            throw new OtherNotFoundException();
        }
    }

    @Override
    public List<Other> findAll() {
        return otherRepository.findAll();
    }
    
    
}
