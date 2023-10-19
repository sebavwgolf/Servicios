
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
public class SearchCleaningDTO {
    
    private Integer roomsFrom;
    private Integer roomsTo; 
    private String exteriors;
    private String cooking;
    private String laundry;
    private String ironing;
    private Integer salaryFrom;
    private Integer salaryTo;
    private String workingZone;
    private String description;
    private String day;
    private LocalTime workingHoursFrom;
    private LocalTime workingHoursTo;
    private Integer hoursFrom;
    private Integer hoursTo;
    
    public void setHoursFrom(LocalTime workingHoursFrom){
        hoursFrom = workingHoursFrom.toSecondOfDay();
    }
    
    public void setHoursTo(LocalTime workingHoursTo){
        hoursTo = workingHoursTo.toSecondOfDay();
    }
    
}
