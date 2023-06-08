import com.craftofprogramming.biblioteca.Livro;
import com.craftofprogramming.biblioteca.ServicoDeBiblioteca;
import com.craftofprogramming.biblioteca.Topico;
import io.cucumber.java.pt.*;
import org.hamcrest.CoreMatchers;
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

    @E("Que o total de livros carregados e {int}")
    public void queOTotalDeLivrosCarregadosE(int totalDeLivros) {
        Assert.assertThat(servicoDeBiblioteca.contagemDosLivros(), CoreMatchers.is(CoreMatchers.equalTo(totalDeLivros)));
    }


    @Mas("Eu nao encontro o topico {}")
    public void euNaoEncontroOTopicoSCIFI(Topico topico) {
        Assert.assertTrue(servicoDeBiblioteca.topicoMaisPopular().get()!=topico);
    }
}
