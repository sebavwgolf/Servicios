package com.ayudaencasa.app.dto.input;

import java.time.LocalTime;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class CreateCleaningDTO {

    private Integer rooms;
    
    private Boolean exteriors;
    
    private Boolean cooking;
    
    private Boolean laundry;
    
    private Boolean ironing;
    
    private Integer salary;
    private String workingZone;
    private String description;
    private List<String> days;
    private LocalTime workingHoursFrom;
    private LocalTime workingHoursTo;
    private Integer hoursFrom;
    private Integer hoursTo;
    private Boolean status;
    
}
