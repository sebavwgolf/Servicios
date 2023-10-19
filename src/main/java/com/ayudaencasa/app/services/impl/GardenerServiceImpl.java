package com.ayudaencasa.app.services.impl;

import com.ayudaencasa.app.criteria.GardenerCriteria;
import com.ayudaencasa.app.entities.Gardener;
import com.ayudaencasa.app.entities.Gardener_;
import com.ayudaencasa.app.exceptions.GardenerNotFoundException;
import com.ayudaencasa.app.repositories.GardenerRepository;
import com.ayudaencasa.app.services.GardenerService;
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
public class GardenerServiceImpl extends QueryService<Gardener> implements GardenerService {

    @Autowired
    private GardenerRepository gardenerRepository;

    @Autowired
    private ModelMapper modelMapper;

    private Specification<Gardener> createSpecification(GardenerCriteria gardenerCriteria) {
        Specification<Gardener> specification = Specification.where(null);
        if (gardenerCriteria != null) {
            if (gardenerCriteria.getSurface() != null) {
                specification = specification.and(buildRangeSpecification(gardenerCriteria.getSurface(), Gardener_.surface));
            }
            if (gardenerCriteria.getTools() != null) {
                specification = specification.and(buildSpecification(gardenerCriteria.getTools(), Gardener_.tools));
            }
            if (gardenerCriteria.getPoolCleaning() != null) {
                specification = specification.and(buildSpecification(gardenerCriteria.getPoolCleaning(), Gardener_.poolCleaning));
            }
            if (gardenerCriteria.getGardenFence() != null) {
                specification = specification.and(buildSpecification(gardenerCriteria.getGardenFence(), Gardener_.gardenFence));
            }
            if (gardenerCriteria.getPlantDisinfection() != null) {
                specification = specification.and(buildSpecification(gardenerCriteria.getPlantDisinfection(), Gardener_.plantDisinfection));
            }
            if (gardenerCriteria.getSalary() != null) {
                specification = specification.and(buildRangeSpecification(gardenerCriteria.getSalary(), Gardener_.salary));
            }
            if (gardenerCriteria.getWorkingZone() != null) {
                specification = specification.and(buildStringSpecification(gardenerCriteria.getWorkingZone(), Gardener_.workingZone));
            }
            if (gardenerCriteria.getDescription() != null) {
                specification = specification.and(buildStringSpecification(gardenerCriteria.getDescription(), Gardener_.description));
            }
            if(gardenerCriteria.getHoursFrom() != null){
                
                specification = specification.and(buildRangeSpecification(gardenerCriteria.getHoursFrom(), Gardener_.hoursFrom));
            }
            if(gardenerCriteria.getHoursTo() != null){
                specification = specification.and(buildRangeSpecification(gardenerCriteria.getHoursTo(), Gardener_.hoursTo));
            }
        }
        return specification;
    }

    @Override
    public List<Gardener> findByCriteria(GardenerCriteria gardenerCriteria) {
        final Specification<Gardener> specification = createSpecification(gardenerCriteria);
        List<Gardener> gardeners = gardenerRepository.findAll(specification);
        return gardeners;
    }

    @Override
    @Transactional
    public Gardener create(@NonNull Gardener gardener) {
        return gardenerRepository.save(gardener);
    }

    @Override
    @Transactional
    public void update(@NonNull String id, @NonNull Gardener newGardener) throws GardenerNotFoundException {
        Optional<Gardener> opt = gardenerRepository.findById(id);
        if (opt.isPresent()) {
            Gardener gardener = opt.get();
            modelMapper.map(newGardener, gardener);
            gardenerRepository.save(gardener);
        } else {
            throw new GardenerNotFoundException();
        }
    }

    @Override
    @Transactional
    public void delete(@NonNull String id) {
        Optional<Gardener> opt = gardenerRepository.findById(id);
        if (opt.isPresent()) {
            gardenerRepository.delete(opt.get());
        } else {
            throw new GardenerNotFoundException();
        }
    }

    @Override
    public Gardener findById(@NonNull String id) {
        Optional<Gardener> opt = gardenerRepository.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new GardenerNotFoundException();
        }
    }

    @Override
    public List<Gardener> findAll() {
        return gardenerRepository.findAll();
    }

}
