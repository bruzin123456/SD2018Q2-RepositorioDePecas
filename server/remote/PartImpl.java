package server.remote;

import java.io.Serializable;
import java.util.List;

import javafx.util.Pair;

public class PartImpl implements Part, Serializable
{
    private int codigo;
    private String nome;
    private String descricao;
    private List<Pair<PartImpl, Integer>> subParts;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Pair<PartImpl, Integer>> getSubParts() {
        return subParts;
    }

    public void setSubParts(List<Pair<PartImpl, Integer>> subParts) {
        this.subParts = subParts;
    }
}