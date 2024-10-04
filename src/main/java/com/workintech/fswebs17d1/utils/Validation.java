package com.workintech.fswebs17d1.utils;

import com.workintech.fswebs17d1.entity.Animal;

public class Validation {
    public static void checkId(Integer id){
        if(id<0){
            System.out.println("id can not be less than zero!");
        };
        if(id==null) System.out.println("Id is null");

    }
}
