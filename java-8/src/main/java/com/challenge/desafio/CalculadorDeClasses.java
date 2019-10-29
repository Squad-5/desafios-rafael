package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    private Object objeto = new Object();

    @Override
    public BigDecimal somar(Object objeto) throws IllegalAccessException {

        setObjeto(objeto);
        Class annotation = Somar.class;
        return retornarTotalSomado(annotation);
    }


    @Override
    public BigDecimal subtrair(Object objeto) throws IllegalAccessException {
        setObjeto(objeto);
        Class annotation = Subtrair.class;
        return retornarTotalSomado(annotation);
    }

    @Override
    public BigDecimal totalizar(Object objeto) throws IllegalAccessException {
        return somar(objeto).subtract(subtrair(objeto));
    }

    public Field[] getAtributos(Class classe){
        return classe.getDeclaredFields();
    }

    public BigDecimal retornarTotalSomado(Class annotation) throws IllegalAccessException {

        Field[] atributos = getAtributos(getObjeto().getClass());
        BigDecimal totalSomado = new BigDecimal(0);

        for (Field atributo : atributos) {
            totalSomado = totalSomado.add(calcular(atributo,annotation));
        }

        if (totalSomado.equals(new BigDecimal(0))) return BigDecimal.ZERO;

        return totalSomado;
    }

    public BigDecimal calcular(Field atributo, Class annotation) throws IllegalAccessException {

        BigDecimal totalSomado = new BigDecimal(0);

        if (atributo.isAnnotationPresent(annotation)) {
            atributo.setAccessible(true);
            BigDecimal valor = (BigDecimal) atributo.get(getObjeto());
            totalSomado = totalSomado.add(valor);
        }

        return totalSomado;
    }

    private void setObjeto(Object objeto){
        this.objeto = objeto;
    }

    private Object getObjeto(){
        return this.objeto;
    }

}
