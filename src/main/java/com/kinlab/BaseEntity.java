package com.kinlab;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonFormat
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BaseEntity {
    private String email, name, description;
    private boolean good;
    private AnotherEntity anotherEntity;
    private List<AnotherEntity> anotherEntities;
}
