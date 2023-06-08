# language: pt

  Funcionalidade: Pesuisa de livros na minha biblioteca

    Contexto://Server para repetir passos dos cenarios
      Dado Que a minha biblioteca esta inicializada

    Cenario: Pesquisa de um livro dado o titulo
      Quando Eu pesquiso o livro "Effective Java"
      Entao Eu encontro esse livro

    Cenario: Pesquisa do topico mais popular
      Quando Eu pesquiso o topico mais popular
      Entao Eu encontro o topico COMPUTACAO