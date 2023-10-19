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
public class SearchGardenerDTO {
    
    private Double surfaceFrom;
    private Double surfaceTo; 
    private String tools;
    private String poolCleaning;
    private String gardenFence;
    private String plantDisinfection;
    private Integer salaryFrom;
    private Integer salaryTo;
    private String workingZone;
    private String description;
    
    private String day;

    private LocalTime workingHoursFrom;

    private LocalTime workingHoursTo;
    
//    @Setter(AccessLevel.NONE)
    private Integer hoursFrom;
    
//    @Setter(AccessLevel.NONE)
    private Integer hoursTo;
    
    public void setHoursFrom(LocalTime workingHoursFrom){
        hoursFrom = workingHoursFrom.toSecondOfDay();
    }
    
    public void setHoursTo(LocalTime workingHoursTo){
        hoursTo = workingHoursTo.toSecondOfDay();
    }
    
 
}
