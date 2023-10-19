package com.ayudaencasa.app.criteria;

import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CaregiverCriteria {
    
    private IntegerFilter salary;
    private StringFilter workingZone;
    private StringFilter description;
    private IntegerFilter hoursFrom;
    private IntegerFilter hoursTo;
    private IntegerFilter quantity;   
    private IntegerFilter ageFrom;   
    private IntegerFilter ageTo;  
    private BooleanFilter cooking;  
    private BooleanFilter cleaningPeople;  
    private BooleanFilter tranfering;
    
}
