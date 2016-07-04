package com.kinlab;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

/**
 * Created by Stephen Lang on 0001, July, 1, 2016.
 */
public class SubClassDelegateTest {
    @Test
    public void subClassDelegateTest() throws Exception {

        SubClassDelegateImpl subClassDelegate = SubClassDelegateImpl.getInstance(baseEntity);
        assertThat(subClassDelegate.getDescription(), equalTo(description));
        assertThat(subClassDelegate.isLocked(), equalTo(new Boolean(true)));
//        assertThat(subClassDelegate.isEmail(), equalTo(new Boolean(false)));
//        assertThat(subClassDelegate.getEmail(), equalTo(null));
        assertThat(subClassDelegate.getAnotherEntity(), equalTo(anotherEntity));
        assertThat(subClassDelegate.getText(), hasSize(2));
        assertThat(subClassDelegate.toString(), containsStringIgnoringCase(baseEntity.getClass().getSimpleName()));
//        System.out.println(subClassDelegate.toString());
    }

    @Test
    public void jsonTest() throws Exception {
            // Create the node factory that gives us nodes.
//            JsonNodeFactory factory = new JsonNodeFactory(false);
//            // create a json factory to write the treenode as json. for the example
//            // we just write to console
//            JsonFactory jsonFactory = new JsonFactory();
//            JsonGenerator generator = jsonFactory.createGenerator(System.out);
            ObjectMapper mapper = new ObjectMapper();

            // the root node - album
//            JsonNode album = factory.objectNode();
//            mapper.writeTree(generator, album);
        SubClassDelegateImpl subClassDelegate = SubClassDelegateImpl.getInstance(baseEntity);
        String json = mapper.writeValueAsString(subClassDelegate);
        assertThat(json, not(containsStringIgnoringCase(baseEntity.getClass().getSimpleName())));
        System.out.println(json);


    }

    private BaseEntity baseEntity;
    private String email = "email";
    private String name = "name";
    private String description = "description";
    private Boolean isGood = false;
    private String anotherDescription = "another description";
    private AnotherEntity anotherEntity;
    private String[] text = {"aaa", "bbb"};

    @Before
    public void setUp() throws Exception {
        anotherEntity = new AnotherEntity(anotherDescription);
        baseEntity = new BaseEntity(email, name, description, isGood, anotherEntity, Arrays.asList(text));

    }





}
