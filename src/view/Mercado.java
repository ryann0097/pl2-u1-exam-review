package view;
import java.util.*;
import model.*;

public class Mercado {
    private Prateleira prateleira = new Prateleira();
    private List<Funcionario>tabelaDeFuncionarios = new ArrayList<Funcionario>();

    public void realizarVenda(Cliente cliente){
        if(tabelaDeFuncionarios.isEmpty()){
            System.out.println("Não há funcionários disponíveis para atender o cliente");
            return;
        }
        boolean funcionarioDisponivel = false;
        for (Funcionario funcionario : tabelaDeFuncionarios) {
            if(funcionario.getDisponivel()){
                funcionario.atenderCliente(cliente);
                funcionarioDisponivel = true;
                break;
            }
        }
        if(!funcionarioDisponivel){
            System.out.println("Nenhum funcionário disponível para atender o cliente");
            return;
        }

        cliente.setTotalCompras();
        double carteiraCliente = cliente.getCarteira();
        double totalCompras = cliente.getTotalCompras();
        System.out.println("Total da compra: " + totalCompras);

        if(carteiraCliente < totalCompras){
            System.out.println("Cliente não possui saldo suficiente para realizar a compra");
            return;
        } else if (totalCompras == 0){
            System.out.println("Carrinho de compras vazio");
            return;
        } else if (totalCompras <= carteiraCliente){
            System.out.println("Compra realizada com sucesso. Troco: " + (carteiraCliente - totalCompras));
            cliente.setCarteira(carteiraCliente - totalCompras);
        }
    }

    public void adicionarFuncionario(Funcionario funcionario){
        tabelaDeFuncionarios.add(funcionario);
    }

    public void adicionarProduto(String nome, double preco, int id){
        prateleira.adicionarProduto(nome, preco, id);
    }

    public void mostrarLoja(){
        prateleira.mostrarProdutos();
        System.out.println("Produtos especiais:");
        prateleira.mostrarMaisCaro();
        prateleira.mostrarMaisBarato();
    }

    public void mostrarFuncionarios(){
        System.out.println("==================== Funcionários disponíveis ====================");
        for (Funcionario funcionario : tabelaDeFuncionarios) {
            System.out.println("Nome: " + funcionario.getNome() + " Cargo: " + funcionario.getCargo() + " Salário: " + funcionario.getSalario());
        }
        System.out.println("===============================================================");
    }

    public void Main(){
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        Cliente cliente3 = new Cliente();

        // Preenchimento e implementação dos métodos

        // Cliente 1
        cliente1.setNome("João Silva");
        cliente1.setCarteira(50.00);
        //cliente1.setDataNascimento(null);

        // Cliente 2
        cliente2.setNome("Maria Oliveira");
        cliente2.setCarteira(30.00);

        // Cliente 3
        cliente3.setNome("Ana Lima");
        cliente3.setCarteira(100.00);

        Funcionario funcionario1 = new Funcionario();
        Funcionario funcionario2 = new Funcionario();
        Funcionario funcionario3 = new Funcionario();

        // Funcionario 1
        funcionario1.setNome("Carlos Souza");
        funcionario1.setDisponivel(true);
        funcionario1.setSalario(1500.00);
        funcionario1.setCargo("Vendedor");

        funcionario2.setNome("Ana Beatriz");
        funcionario2.setDisponivel(true);
        funcionario2.setSalario(2500.00);
        funcionario2.setCargo("Gerente");

        funcionario3.setNome("Ricardo Pereira");
        funcionario3.setDisponivel(false);
        funcionario3.setSalario(1300.00);
        funcionario3.setCargo("Estoquista");

        Produto produto1 = new Produto();
        Produto produto2 = new Produto();
        Produto produto3 = new Produto();
        Produto produto6 = new Produto();
        Produto produto8 = new Produto();
        Produto produto10 = new Produto();
        Produto produto4 = new Produto();

        produto1.setNome("Caderno");
        produto1.setPreco(10.50);
        produto1.setId(1);

        produto2.setNome("Caneta");
        produto2.setPreco(2.00);
        produto2.setId(2);

        produto3.setNome("Mochila");
        produto3.setPreco(35.00);
        produto3.setId(3);

        produto4.setNome("Lápis");
        produto4.setPreco(1.50);
        produto4.setId(4);

        produto6.setNome("Régua");
        produto6.setPreco(3.00);
        produto6.setId(6);

        produto8.setNome("Livro");
        produto8.setPreco(25.00);
        produto8.setId(8);

        produto10.setNome("Estojinho");
        produto10.setPreco(8.00);
        produto10.setId(10);

        prateleira.adicionarProduto(produto1.getNome(), produto1.getPreco(), produto1.getId());
        prateleira.adicionarProduto(produto2.getNome(), produto2.getPreco(), produto2.getId());
        prateleira.adicionarProduto(produto3.getNome(), produto3.getPreco(), produto3.getId());
        prateleira.adicionarProduto(produto4.getNome(), produto4.getPreco(), produto4.getId());
        prateleira.adicionarProduto(produto6.getNome(), produto6.getPreco(), produto6.getId());
        prateleira.adicionarProduto(produto8.getNome(), produto8.getPreco(), produto8.getId());
        prateleira.adicionarProduto(produto10.getNome(), produto10.getPreco(), produto10.getId());

        mostrarLoja();

        adicionarFuncionario(funcionario1);
        adicionarFuncionario(funcionario2);
        adicionarFuncionario(funcionario3);

        mostrarFuncionarios();

        // Compras do primeiro cliente
        cliente1.adicionarProduto(1, 1, prateleira.getProdutos());
        cliente1.adicionarProduto(2, 1, prateleira.getProdutos());
        cliente1.adicionarProduto(4, 1, prateleira.getProdutos());
        cliente1.adicionarProduto(6, 1, prateleira.getProdutos());
        cliente1.adicionarProduto(10, 1, prateleira.getProdutos());

        // Compras do segundo cliente
        cliente2.adicionarProduto(1, 1, prateleira.getProdutos());
        cliente2.adicionarProduto(2, 1, prateleira.getProdutos());
        cliente2.adicionarProduto(4, 5, prateleira.getProdutos());
        cliente2.adicionarProduto(6, 1, prateleira.getProdutos());

        // Compras do terceiro cliente
        cliente3.adicionarProduto(1, 1, prateleira.getProdutos());
        cliente3.adicionarProduto(3, 2, prateleira.getProdutos());
        cliente3.adicionarProduto(8, 1, prateleira.getProdutos());

        cliente2.setTotalCompras();
        cliente3.setTotalCompras();

        realizarVenda(cliente3);
        realizarVenda(cliente2);
    }

}
