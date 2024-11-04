package model;

import java.util.List;
import java.util.ArrayList;

public class Prateleira {
    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(String nome, double preco, int id){
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setId(id);
        produtos.add(produto);
    }

    public List<Produto> getProdutos(){
        return produtos;
    }

    public void mostrarMaisCaro(){
        Produto maisCaro = produtos.get(0);
        for (Produto produto : produtos) {
            if(produto.getPreco() > maisCaro.getPreco()){
                maisCaro = produto;
            }
        }
        System.out.println("Produto mais caro: " + maisCaro.getNome());
    }

    public void mostrarMaisBarato(){
        Produto maisBarato = produtos.get(0);
        for (Produto produto : produtos) {
            if(produto.getPreco() < maisBarato.getPreco()){
                maisBarato = produto;
            }
        }
        System.out.println("Produto mais barato: " + maisBarato.getNome());
    }

    public void mostrarProdutos(){
        System.out.println("==================== Produtos disponíveis ====================");
        for (Produto produto : produtos) {
            System.out.println("ID do produto" + produto.getId() + "Nome: " + produto.getNome() + " Preço: " + produto.getPreco());
        }
        System.out.println("===============================================================");
    }

}
