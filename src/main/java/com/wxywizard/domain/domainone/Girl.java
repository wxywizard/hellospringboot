package com.wxywizard.domain.domainone;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Girl {

    @Id
    @GenericGenerator(name="system-uuid", strategy="uuid")
    @GeneratedValue(generator = "system-uuid")
    private String id;

    private String cupSize;

    private Integer age;

    public Girl() {
    }

}
