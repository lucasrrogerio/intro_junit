package carrinho;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {

    private Carrinho carrinho;

    @BeforeEach
    public void inicializa() {
        carrinho = new Carrinho();
        carrinho.addItem(new Produto("ABC", 50.0));
        carrinho.addItem(new Produto("XYZ", 100.0));
    }

    @Test
    public void testeQuantidadeItens() {
        Assertions.assertEquals(2, carrinho.getQtdeItems());
    }

    @Test
    public void testeValorTotal() {
        Assertions.assertEquals(150.00, carrinho.getValorTotal());
    }

    @Test
    public void testeRemoverItem() throws ProdutoNaoEncontradoException {
        Produto produto = new Produto("Novo Produto", 30.0);
        carrinho.addItem(produto);
        carrinho.removeItem(produto);
        Assertions.assertEquals(2, carrinho.getQtdeItems());
    }

    @Test
    public void testeRemoverItemQueNaoExiste() {
        Assertions.assertThrows(ProdutoNaoEncontradoException.class,
                () -> carrinho.removeItem(new Produto("FGH", 20.0)));
    }

    @Test
    public void testeEsvazia() {
        carrinho.esvazia();
        Assertions.assertEquals(0, carrinho.getQtdeItems());

        carrinho.addItem(new Produto("ABC", 50.0));
        carrinho.addItem(new Produto("XYZ", 100.0));
    }

}
