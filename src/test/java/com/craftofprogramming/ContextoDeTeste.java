package com.craftofprogramming;

import com.craftofprogramming.biblioteca.ServicoDeBiblioteca;

//Define os estados comum entre as definicoes de passos a ser usado
public final class ContextoDeTeste {

    public static final ContextoDeTeste INSTANCIA = new ContextoDeTeste();
    private ServicoDeBiblioteca servicoDeBiblioteca;

    public ServicoDeBiblioteca obtemServico(boolean carrega) {
        servicoDeBiblioteca = ServicoDeBiblioteca.obtemServico(carrega);
        return servicoDeBiblioteca;
    }

    public ServicoDeBiblioteca servicoDeBiblioteca(){
        return servicoDeBiblioteca;
    }

}
