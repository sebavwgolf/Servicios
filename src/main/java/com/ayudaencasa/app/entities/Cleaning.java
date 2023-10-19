package com.ayudaencasa.app.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "UPDATE categories SET deleted_at = current_timestamp() WHERE id = ?")
@Where(clause = "deleted_at is null")
@Entity
public class Cleaning extends Job implements Serializable{
    
    private Integer rooms;
    private Boolean exteriors;
    private Boolean cooking;
    private Boolean laundry;
    private Boolean ironing;

    
    @Override
    public String getType() {
        return "Cleaning";
    }

    
    
    
    
}
