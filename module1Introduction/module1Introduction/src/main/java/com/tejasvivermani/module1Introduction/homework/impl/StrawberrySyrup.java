package com.tejasvivermani.module1Introduction.homework.impl;

import com.tejasvivermani.module1Introduction.homework.Syrup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Strawberry")
public class StrawberrySyrup implements Syrup {

    @Override
    public String getSyrupType() {
        return "Strawberry Syrup";
    }
}
