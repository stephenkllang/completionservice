package com.kinlab;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

/**
 * Created by Stephen Lang on 0001, July, 1, 2016.
 */
public class SubClassDelegateTest {
    private BaseEntity baseEntity;
    private String email = "email";
    private String name = "name";
    private String description = "description";
    private Boolean isGood = true;
    private String anotherDescription = "another description";
    private AnotherEntity anotherEntity;
    private List<AnotherEntity> anotherEntities;

    @Before
    public void setUp() throws Exception {
        anotherEntity = new AnotherEntity(anotherDescription);
        anotherEntities = new ArrayList<>();
        anotherEntities.add(anotherEntity);
        baseEntity = new BaseEntity(email, name, description, isGood, anotherEntity, anotherEntities);


    }

    @Test
    public void subClassDelegateTest() throws Exception {
        SubClassDelegate subClassDelegate = new SubClassDelegate(baseEntity);
        assertThat(subClassDelegate.getDescription(), equalTo(description));
        assertThat(subClassDelegate.isLocked(), equalTo(new Boolean(true)));
        assertThat(subClassDelegate.getAnotherEntity(), equalTo(anotherEntity));
        assertThat(subClassDelegate.getAnotherEntities(), hasSize(1));

    }



    @Test
    public void copyTest() {
//        assertThat(theBiscuit, is(equalTo(myBiscuit))); assertThat(theBiscuit, is(myBiscuit));
    }
}
