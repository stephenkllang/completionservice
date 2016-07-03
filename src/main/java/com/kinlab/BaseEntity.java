package com.kinlab;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Stephen Lang on 0001, July, 1, 2016.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseEntity {
    private String email, name, description;
    private Boolean isGood;
    private AnotherEntity anotherEntity;
    private List<AnotherEntity> anotherEntities;
}
