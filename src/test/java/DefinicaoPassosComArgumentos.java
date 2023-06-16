import com.craftofprogramming.ContextoDeTeste;
import com.craftofprogramming.biblioteca.Livro;
import com.craftofprogramming.biblioteca.ServicoDeBiblioteca;
import com.craftofprogramming.biblioteca.Topico;
import io.cucumber.java.DataTableType;
import io.cucumber.java.DocStringType;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
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

    @DocStringType(contentType = "lista_de_livros")
    public List<Livro> definicaoDeListaDeLivros(String docString) {
        List<Livro> livros = new ArrayList<>();
        Arrays.stream(docString.split("\\n")).forEach(e -> {
            final String[] split = e.split(",");
            livros.add(new Livro(
                    split[0].trim(),
                    Integer.parseInt(split[1].trim()),
                    Topico.valueOf(split[2].trim()),
                    Year.parse(split[3].trim()),
                    split[4].trim()
            ));
        });
        return livros;
    }

    @E("a seguinte lista de livros:")
    public void aSeguinteListaDeLivros(List<Livro> livros) {
        final ServicoDeBiblioteca biblioteca = ContextoDeTeste.INSTANCIA.servicoDeBiblioteca();
        livros.forEach(livro -> biblioteca.adiciona(livro));
    }
}
