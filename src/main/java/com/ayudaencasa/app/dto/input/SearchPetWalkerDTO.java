/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class SearchPetWalkerDTO {
    
    private Integer petQuantityFrom;
    private Integer petQuantityTo;
    private String petType;
    private String petRace;   
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
