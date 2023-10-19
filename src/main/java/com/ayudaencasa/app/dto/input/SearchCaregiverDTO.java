
package com.ayudaencasa.app.dto.input;

import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchCaregiverDTO {
    
    private Integer salaryFrom;
    private Integer salaryTo;
    private String workingZone;
    private String description;  
    private String day;
    private LocalTime workingHoursFrom;
    private LocalTime workingHoursTo; 
    private Integer hoursFrom;  
    private Integer hoursTo;
    private Integer quantityFrom;
    private Integer quantityTo;
    private Integer ageFrom;   
    private Integer ageTo;  
    private String cooking; 
    private String cleaningPeople;   
    private String tranfering;
    
    public void setHoursFrom(LocalTime workingHoursFrom){
        hoursFrom = workingHoursFrom.toSecondOfDay();
    }
    
    public void setHoursTo(LocalTime workingHoursTo){
        hoursTo = workingHoursTo.toSecondOfDay();
    }
    
    
}
