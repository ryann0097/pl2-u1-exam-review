package model;
import java.util.Date;

public class Pessoa {
    protected String nome;
    protected Date dataNascimento;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }
}
