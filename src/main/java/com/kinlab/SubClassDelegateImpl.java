package com.kinlab;

import lombok.ToString;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Stephen Lang on 0003, July, 3, 2016.
 */
//@RequiredArgsConstructor(staticName="newInstance")
//@Data(staticConstructor="getInstance")
@ToString

public class SubClassDelegateImpl extends BaseEntity implements SubClassDelegate {
    private final BaseEntity baseEntity;
    private boolean email = false;

    private SubClassDelegateImpl(final BaseEntity baseEntity) {
        this.baseEntity = baseEntity;
    }

    public static SubClassDelegateImpl getInstance(final BaseEntity baseEntity) {
        baseEntity.setEmail(null);
        return new SubClassDelegateImpl(baseEntity);
    }

    public boolean isEmail() {
        return email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }

    @PostConstruct
    public void onConstructor () {
//        Calendar.getInstance();
            System.out.println("onConstructor");
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
    public boolean isGood() {
        return baseEntity.isGood();
    }


    @Override
    public AnotherEntity getAnotherEntity() {
        return baseEntity.getAnotherEntity();
    }

    @Override
    public List<AnotherEntity> getAnotherEntities() {
        return baseEntity.getAnotherEntities();
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
    public void setGood(boolean good) {
        baseEntity.setGood(good);
    }

    @Override
    public void setAnotherEntity(AnotherEntity anotherEntity) {
        baseEntity.setAnotherEntity(anotherEntity);
    }

    @Override
    public void setAnotherEntities(List<AnotherEntity> anotherEntities) {
        baseEntity.setAnotherEntities(anotherEntities);
    }

//    @Override
//    public boolean equals(Object o) {
//        return baseEntity.equals(o);
//    }
//
//    @Override
//    public int hashCode() {
//        return baseEntity.hashCode();
//    }
//
//    @Override
//    public boolean canEqual(Object other) {
//        return baseEntity.canEqual(other);
//    }
//
//    @Override
//    public String toString() {
//        return baseEntity.toString();
//    }

}
