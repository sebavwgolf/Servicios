/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ayudaencasa.app.dto.input;

import java.time.LocalTime;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateGardenerDTO {

    private Double surface;
    private Boolean tools;
    private Boolean poolCleaning;
    private Boolean gardenFence;
    private Boolean plantDisinfection;

//    @NotNull
//    @NonNull
    private Integer salary;
    private String workingZone;
    private String description;
    private List<String> days;

//    @Temporal(value = TemporalType.TIME).
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalTime")
//    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime workingHoursFrom;

//    @Temporal(value = TemporalType.TIME)
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalTime")
//    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime workingHoursTo;

//    @NotNull
//    @NonNull
//    @Setter(AccessLevel.NONE)
    private Integer hoursFrom;

//    @NotNull
//    @NonNull
    private Integer hoursTo;
    private Boolean status;
    

}
