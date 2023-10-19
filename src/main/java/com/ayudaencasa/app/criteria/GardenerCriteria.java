package com.ayudaencasa.app.criteria;

import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
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
//Filtros de búsqueda
public class GardenerCriteria {
    
    private DoubleFilter surface;
    private BooleanFilter tools;
    private BooleanFilter poolCleaning;
    private BooleanFilter gardenFence;
    private BooleanFilter plantDisinfection;
    private IntegerFilter salary;
    private StringFilter workingZone;
    private StringFilter description;
    private IntegerFilter hoursFrom;
    private IntegerFilter hoursTo;

}
