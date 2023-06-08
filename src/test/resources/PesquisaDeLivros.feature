# language: pt

  Funcionalidade: Pesquisa de livros na minha biblioteca

    Contexto:#Server para repetir passos dos cenarios
      Dado Que a minha biblioteca esta inicializada
      E Que o total de livros carregados e 10

    Cenario: Pesquisa de um livro dado o titulo
      Quando Eu pesquiso o livro "Effective Java"
      Entao Eu encontro esse livro

    Cenario: Pesquisa do topico mais popular
      Quando Eu pesquiso o topico mais popular
      Entao Eu encontro o topico COMPUTACAO
      Mas Eu nao encontro o topico SCI_FI
      E Eu nao encontro o topico FINANCAS
