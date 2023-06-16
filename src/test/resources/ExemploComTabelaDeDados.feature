# language: pt

  Funcionalidade: Exemplo de uso de tabela de dados
    Cenario: Exemplo de uso de tabela de dados
      Dado Que a minha biblioteca esta inicializada vazia
      E a seguinte tabela de livros:
        | titulo    | Numero de Paginas | Topico     | Data de Publicacao | Autores |
        | LivroUm   | 42                | COMPUTACAO | 2020               | Nilton  |
        | LivroDois | 150               | ROMANCE    | 2021               | Santos  |
      Quando Eu pesquiso o livro "LivroUm" e COMPUTACAO
      Entao Eu encontro o livro "LivroUm"
      Quando Eu pesquiso o livro "LivroDois" e ROMANCE
      Entao Eu encontro o livro "LivroDois"


    Cenario: Exemplo de uso de Doc Strings
      Dado Que a minha biblioteca esta inicializada vazia
      E a seguinte lista de livros:
      """lista_de_livros
        LivroTres , 200, COMPUTACAO, 2020, Cassandra
        LivroQuatro, 300, FINANCAS, 2021, Miranda
      """
      Quando Eu pesquiso o livro "LivroTres" e COMPUTACAO
      Entao Eu encontro o livro "LivroUm"
      Quando Eu pesquiso o livro "LivroQuatro" e FINANCAS
      Entao Eu encontro o livro "LivroQuatro"