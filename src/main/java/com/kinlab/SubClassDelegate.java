package com.kinlab;

/**
 * Created by Stephen Lang on 0003, July, 3, 2016.
 */
public interface SubClassDelegate  {
    boolean locked = true;
    default boolean isLocked(){
        return locked;
    }


}
