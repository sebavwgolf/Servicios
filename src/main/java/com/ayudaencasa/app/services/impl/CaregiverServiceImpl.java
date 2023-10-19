package com.ayudaencasa.app.services.impl;

import com.ayudaencasa.app.criteria.CaregiverCriteria;
import com.ayudaencasa.app.entities.Caregiver;
import com.ayudaencasa.app.entities.Caregiver_;
import com.ayudaencasa.app.exceptions.UserNotFoundException;
import com.ayudaencasa.app.repositories.CaregiverRepository;
import com.ayudaencasa.app.services.CaregiverService;
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
public class CaregiverServiceImpl extends QueryService<Caregiver> implements CaregiverService {

    @Autowired
    private CaregiverRepository caregiverRepository;

    @Autowired
    private ModelMapper modelMapper;

    private Specification<Caregiver> createSpecification(CaregiverCriteria caregiverCriteria) {
        Specification<Caregiver> specification = Specification.where(null);
        if (caregiverCriteria != null) {
            if (caregiverCriteria.getQuantity() != null) {
                specification = specification.and(buildRangeSpecification(caregiverCriteria.getQuantity(), Caregiver_.quantity));
            }
            if (caregiverCriteria.getAgeFrom() != null) {
                specification = specification.and(buildRangeSpecification(caregiverCriteria.getAgeFrom(), Caregiver_.ageFrom));
            }
            if (caregiverCriteria.getAgeTo() != null) {
                specification = specification.and(buildRangeSpecification(caregiverCriteria.getAgeTo(), Caregiver_.ageTo));
            }
            if (caregiverCriteria.getCooking() != null) {
                specification = specification.and(buildSpecification(caregiverCriteria.getCooking(), Caregiver_.cooking));
            }
            if (caregiverCriteria.getCleaningPeople() != null) {
                specification = specification.and(buildSpecification(caregiverCriteria.getCleaningPeople(), Caregiver_.cleaningPeople));
            }
            if (caregiverCriteria.getTranfering() != null) {
                specification = specification.and(buildSpecification(caregiverCriteria.getTranfering(), Caregiver_.tranfering));
            }

            if (caregiverCriteria.getSalary() != null) {
                specification = specification.and(buildRangeSpecification(caregiverCriteria.getSalary(), Caregiver_.salary));
            }
            if (caregiverCriteria.getWorkingZone() != null) {
                specification = specification.and(buildStringSpecification(caregiverCriteria.getWorkingZone(), Caregiver_.workingZone));
            }
            if (caregiverCriteria.getDescription() != null) {
                specification = specification.and(buildStringSpecification(caregiverCriteria.getDescription(), Caregiver_.description));
            }
            if (caregiverCriteria.getHoursFrom() != null) {
                specification = specification.and(buildRangeSpecification(caregiverCriteria.getHoursFrom(), Caregiver_.hoursFrom));
            }
            if (caregiverCriteria.getHoursTo() != null) {
                specification = specification.and(buildRangeSpecification(caregiverCriteria.getHoursTo(), Caregiver_.hoursTo));
            }
        }
        return specification;
    }

    @Override
    public List<Caregiver> findByCriteria(CaregiverCriteria caregiverCriteria) {
        final Specification<Caregiver> specification = createSpecification(caregiverCriteria);
        List<Caregiver> caregivers = caregiverRepository.findAll(specification);
        return caregivers;
    }

    @Override
    @Transactional
    public Caregiver create(@NonNull Caregiver caregiver) {
        return caregiverRepository.save(caregiver);
    }

    @Override
    @Transactional
    public void update(@NonNull String id, @NonNull Caregiver newCaregiver) throws Exception {
        Optional<Caregiver> opt = caregiverRepository.findById(id);
        if (opt.isPresent()) {
            Caregiver caregiver = opt.get();
            modelMapper.map(newCaregiver, caregiver);
            caregiverRepository.save(caregiver);
        } else {
            throw new Exception();
        }
    }

    @Override
    @Transactional
    public void delete(@NonNull String id) throws Exception {
        Optional<Caregiver> opt = caregiverRepository.findById(id);
        if (opt.isPresent()) {
            caregiverRepository.delete(opt.get());
        } else {
            throw new Exception();
        }
    }

    @Override
    public Caregiver findById(@NonNull String id) {
        Optional<Caregiver> opt = caregiverRepository.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public List<Caregiver> findAll() {
        return caregiverRepository.findAll();
    }

}
