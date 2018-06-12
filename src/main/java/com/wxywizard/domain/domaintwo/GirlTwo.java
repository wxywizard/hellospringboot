package com.wxywizard.domain.domaintwo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class GirlTwo {

    @Id
    @GenericGenerator(name="system-uuid", strategy="uuid")
    @GeneratedValue(generator = "system-uuid")
    private String id;

    private String cupSize;

    private Integer age;

    public GirlTwo() {
    }

}
