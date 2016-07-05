package com.kinlab;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Created by Stephen Lang on 0003, July, 3, 2016.
 * Use Idea to create delegate getter method only for super class attributes
 * except those overloaded by boolean with the same name.
 * Do not create delegate for toString(), hash, etc.
 * Assign @getter to boolean attribute overloading super class attributes
 */
@RequiredArgsConstructor(staticName = "getInstance")
@ToString
public class SubClassDelegateImpl extends BaseEntity implements SubClassDelegate {
    private final BaseEntity baseEntity;
    @Getter
    private boolean email = false;
    @Getter
    private boolean name = false;

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
//    private SubClassDelegateImpl(final BaseEntity baseEntity) {
//        this.baseEntity = baseEntity;
//    }
//
//    public static SubClassDelegateImpl getInstance(final BaseEntity baseEntity) {
//        return new SubClassDelegateImpl(baseEntity);
//    }

}
