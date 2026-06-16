package com.tejasvivermani.module1Introduction.homework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CakeBaker {
    public final Frosting frosting;
    public final Syrup syrup;

    public CakeBaker(@Qualifier("Chocolate") Frosting frosting,
                     @Qualifier("Strawberry") Syrup syrup) {
        this.frosting = frosting;
        this.syrup = syrup;
    }

    public void bakeCake(){
        System.out.println("Baking cake with : "+frosting.getFrostingType()+" and  "+syrup.getSyrupType());
    }
}
