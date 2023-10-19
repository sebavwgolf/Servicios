package com.ayudaencasa.app.criteria;

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
public class OtherCriteria {
    
    private StringFilter type;
    private IntegerFilter salary;
    private StringFilter workingZone;
    private StringFilter description;
    private IntegerFilter hoursFrom;
    private IntegerFilter hoursTo;
    
}
