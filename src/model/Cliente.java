package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa{
    private double carteira;
    private List<ItemProduto>carrinhoDeCompras = new ArrayList<>();
    private double totalCompras;

    public void setTotalCompras(){
        double total = 0;
        for (ItemProduto itemProduto : carrinhoDeCompras) {
            total += itemProduto.getValorTotal();
        }
        totalCompras = total;
    }

    public double getTotalCompras(){
        return totalCompras;
    }

    public void setCarteira(double carteira){
        this.carteira = carteira;
    }

    public double getCarteira(){
        return this.carteira;
    }

    public void adicionarProduto(int id, int quantidade, List<Produto> produtos){
        for (Produto produto : produtos) {
            if(produto.getId() == id){
                ItemProduto itemProduto = new ItemProduto();
                itemProduto.setProduto(produto);
                itemProduto.setQuantidade(quantidade);
                carrinhoDeCompras.add(itemProduto);
            }
        }
    }

    public void removerProduto(int id){
        for (ItemProduto itemProduto : carrinhoDeCompras) {
            if(itemProduto.getProduto().getId() == id){
                carrinhoDeCompras.remove(itemProduto);
            }
        }
    }

    public void listarCompras() {
        double total = 0;
        System.out.println("Lista de Compras:");
        for (ItemProduto itemProduto : carrinhoDeCompras) {
            System.out.println("Produto: " + itemProduto.getProduto().getNome() + 
                               ", Quantidade: " + itemProduto.getQuantidade() + 
                               ", Valor Total: " + itemProduto.getValorTotal());
            total += itemProduto.getValorTotal();
        }
        System.out.println("Total das Compras: " + total);
    }
}
