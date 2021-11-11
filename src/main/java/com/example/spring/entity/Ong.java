package com.example.spring.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Ong {

    private @Id @GeneratedValue Long id;
    private String nome;
    private String instituicao;
    private String publico_destinado;
    private String telefone;
    private String endereco;
    private String bairro;
    private String responsavel;


    public Ong() {
    }

    public Ong(String nome, String instituicao, String publico_destinado, String telefone, String endereco, String bairro, String responsavel) {
        this.nome = nome;
        this.instituicao = instituicao;
        this.publico_destinado = publico_destinado;
        this.telefone = telefone;
        this.endereco = endereco;
        this.bairro = bairro;
        this.responsavel = responsavel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ong ong = (Ong) o;
        return Objects.equals(id, ong.id) && Objects.equals(nome, ong.nome) && Objects.equals(instituicao, ong.instituicao) && Objects.equals(publico_destinado, ong.publico_destinado) && Objects.equals(telefone, ong.telefone) && Objects.equals(endereco, ong.endereco) && Objects.equals(bairro, ong.bairro) && Objects.equals(responsavel, ong.responsavel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, instituicao, publico_destinado, telefone, endereco, bairro, responsavel);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getPublico_destinado() {
        return publico_destinado;
    }

    public void setPublico_destinado(String publico_destinado) {
        this.publico_destinado = publico_destinado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "Ong{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", instituicao='" + instituicao + '\'' +
                ", publico_destinado='" + publico_destinado + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                ", bairro='" + bairro + '\'' +
                ", responsavel='" + responsavel + '\'' +
                '}';
    }
}
