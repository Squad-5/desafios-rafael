package com.challenge.interfaces;

import java.math.BigDecimal;

public interface Calculavel {

    BigDecimal somar(Object objeto) throws IllegalAccessException, InstantiationException;
    BigDecimal subtrair(Object objeto) throws IllegalAccessException, InstantiationException;
    BigDecimal totalizar(Object objeto) throws InstantiationException, IllegalAccessException;

}
