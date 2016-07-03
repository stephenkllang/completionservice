package com.kinlab;

import java.util.List;

/**
 * Created by Stephen Lang on 0003, July, 3, 2016.
 */
public class SubClassDelegate extends BaseEntity {
    private BaseEntity baseEntity;
    private boolean locked = true;

    public SubClassDelegate(BaseEntity baseEntity) {
        this.baseEntity = baseEntity;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    @Override
    public String getEmail() {
        return baseEntity.getEmail();
    }

    @Override
    public String getName() {
        return baseEntity.getName();
    }

    @Override
    public String getDescription() {
        return baseEntity.getDescription();
    }

    @Override
    public Boolean getIsGood() {
        return baseEntity.getIsGood();
    }

    @Override
    public AnotherEntity getAnotherEntity() {
        return baseEntity.getAnotherEntity();
    }

    @Override
    public void setEmail(String email) {
        baseEntity.setEmail(email);
    }

    @Override
    public void setName(String name) {
        baseEntity.setName(name);
    }

    @Override
    public void setDescription(String description) {
        baseEntity.setDescription(description);
    }

    @Override
    public void setIsGood(Boolean isGood) {
        baseEntity.setIsGood(isGood);
    }

    @Override
    public void setAnotherEntity(AnotherEntity anotherEntity) {
        baseEntity.setAnotherEntity(anotherEntity);
    }

    @Override
    public boolean equals(Object o) {
        return baseEntity.equals(o);
    }

    @Override
    public int hashCode() {
        return baseEntity.hashCode();
    }

    @Override
    public boolean canEqual(Object other) {
        return baseEntity.canEqual(other);
    }

    @Override
    public String toString() {
        return baseEntity.toString();
    }

    @Override
    public List<AnotherEntity> getAnotherEntities() {
        return baseEntity.getAnotherEntities();
    }
}
