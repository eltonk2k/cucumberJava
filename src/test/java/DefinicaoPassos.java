import com.craftofprogramming.biblioteca.Livro;
import com.craftofprogramming.biblioteca.ServicoDeBiblioteca;
import com.craftofprogramming.biblioteca.Topico;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.Optional;

public class DefinicaoPassos {

    private ServicoDeBiblioteca servicoDeBiblioteca;
    private Livro book;
    private Optional<Topico> topico;

    @Dado("Que a minha biblioteca esta inicializada")
    public void queAMinhaBibliotecaEstaInicializada() {
        servicoDeBiblioteca = ServicoDeBiblioteca.obtemServico();
    }


    @Quando("Eu pesquiso o livro {string}")
    public void euPesquisoOLivro(String bookTitle) {
        book = servicoDeBiblioteca.pesquisaLivroPorTitulo(bookTitle);
    }

    @Entao("Eu encontro esse livro")
    public void euEncontroEsseLivro() {
       Assert.assertNotNull(book);

    }


    @Quando("Eu pesquiso o topico mais popular")
    public void euPesquisoOTopicoMaisPopular() {
        topico = servicoDeBiblioteca.topicoMaisPopular();
    }

    @Entao("Eu encontro o topico {}") //Deixando em branco Reconhece qualquer expressao
    public void euEncontroOTopico(Topico topicoEncontrado) {
        Assert.assertEquals(topicoEncontrado, topico.get());
    }
}
