package com.craftofprogramming.biblioteca;

//Define os estados comum entre as definicoes de passos a ser usado
public final class ContextoDeTeste {

    public static final ContextoDeTeste INSTANCIA = new ContextoDeTeste();

    private ServicoDeBiblioteca biblioteca;

    public ServicoDeBiblioteca obtemServico(boolean carrega) {
        biblioteca = ServicoDeBiblioteca.obtemServico(carrega);
        return biblioteca;
    }

    public ServicoDeBiblioteca biblioteca() {
        return biblioteca;
    }

}
