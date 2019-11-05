package com.challenge;

import com.challenge.entity.Candidate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException {

        for(Annotation annotation : Candidate.class.getField("created_at").getDeclaredAnnotations()){
            System.out.println(annotation);
        }



//        try {
//            for (Annotation annotation : Candidate.class.getField("created_at").getDeclaredAnnotations()){
//                System.out.println(annotation);
//            }
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
    }
}
