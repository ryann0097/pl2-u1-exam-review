package model;

public class ItemProduto {
    private Produto produto;
    private int quantidade;

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public double getValorTotal() {
        return this.produto.getPreco() * this.quantidade;
    }
}
