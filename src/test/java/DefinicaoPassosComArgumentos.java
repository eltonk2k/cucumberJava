import com.craftofprogramming.ContextoDeTeste;
import com.craftofprogramming.biblioteca.Livro;
import com.craftofprogramming.biblioteca.ServicoDeBiblioteca;
import com.craftofprogramming.biblioteca.Topico;
import io.cucumber.java.DataTableType;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import java.time.Year;
import java.util.List;
import java.util.Map;

public class DefinicaoPassosComArgumentos {

    private ServicoDeBiblioteca servicoDeBiblioteca;


    @DataTableType
    public Livro definicaoLivro(Map<String, String> entrada) {
        return new Livro(
                entrada.get("titulo"),
                Integer.parseInt(entrada.get("Numero de Paginas").trim()), //trim retirar os espacos em branco
                Topico.valueOf(entrada.get("Topico").trim()),
                Year.parse(entrada.get("Data de Publicacao").trim()),
                entrada.get("Autores"));
    }

    @E("a seguinte tabela de livros:")
    public void aSeguinteTabelaDeLivros(List<Livro> livros) {//Outra forma de converter a lista pra strings seria List<String> livros)
        //servicoDeBiblioteca = ServicoDeBiblioteca.obtemServico();
        final ServicoDeBiblioteca biblioteca = ContextoDeTeste.INSTANCIA.servicoDeBiblioteca();
        livros.forEach(livro -> biblioteca.adiciona(livro));

    }


}
