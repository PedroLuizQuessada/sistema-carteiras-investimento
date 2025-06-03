package com.quesssystems.sistemacarteirasinvestimento.exceptions;

public class NumeroMoedasException extends RuntimeException {
    public NumeroMoedasException(Integer numeroMoedasInvalido, Integer numeroMaximoMoedas) {
      super(String.format("Número de moedas: %d inválido. O número máximo de moedas é: %d", numeroMoedasInvalido, numeroMaximoMoedas));
    }
}
