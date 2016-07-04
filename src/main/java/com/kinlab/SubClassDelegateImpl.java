package com.kinlab;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Created by Stephen Lang on 0003, July, 3, 2016.
 * Use Idea to create delegate method only for super class attributes
 *     except those overloaded by boolean with the same name.
 *     Do not create delegate for toString(), hash, etc.
 * Use Idea to create getter for boolean overloading super class attributes
 *
 */
@RequiredArgsConstructor(staticName="getInstance")
//@Data(staticConstructor="getInstance")
@ToString
public class SubClassDelegateImpl extends BaseEntity implements SubClassDelegate {
    private final BaseEntity baseEntity;
    @Getter
    private boolean email = false;

//    public boolean isEmail() {
//        return email;
//    }

    //    private SubClassDelegateImpl(final BaseEntity baseEntity) {
//        this.baseEntity = baseEntity;
//    }
//
//    public static SubClassDelegateImpl getInstance(final BaseEntity baseEntity) {
//        return new SubClassDelegateImpl(baseEntity);
//    }
//
    @Override
    public String getDescription() {
        return baseEntity.getDescription();
    }

    @Override
    public boolean isGood() {
        return baseEntity.isGood();
    }


    @Override
    public AnotherEntity getAnotherEntity() {
        return baseEntity.getAnotherEntity();
    }

    @Override
    public List<String> getText() {
        return baseEntity.getText();
    }

    @Override
    public void setText(List<String> text) {
        baseEntity.setText(text);
    }

    @Override
    public void setDescription(String description) {
        baseEntity.setDescription(description);
    }

    @Override
    public String getName() {
        return baseEntity.getName();
    }

    @Override
    public void setGood(boolean good) {
        baseEntity.setGood(good);
    }

    @Override
    public void setAnotherEntity(AnotherEntity anotherEntity) {
        baseEntity.setAnotherEntity(anotherEntity);
    }

}
