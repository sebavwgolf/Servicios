
package com.ayudaencasa.app.dto.input;

import java.time.LocalTime;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CreateCaregiverDTO {
    
    private Integer salary;
    private String workingZone;
    private String description;
    private List<String> days;
    private LocalTime workingHoursFrom;
    private LocalTime workingHoursTo;
    private Integer hoursFrom;
    private Integer hoursTo;
    private Boolean status;
    private Integer quantity;    
    private Integer ageFrom;   
    private Integer ageTo;  
    private Boolean cooking; 
    private Boolean cleaningPeople;   
    private Boolean tranfering;
    
}
