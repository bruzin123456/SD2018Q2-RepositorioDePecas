package server.remote;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PartImpl implements Part
{
    private int codigo;
    private String nome;
    private String descricao;
    private List<SubPart> subParts = new ArrayList<>();

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

    public List<SubPart> getSubParts() {
        return subParts;
    }

    public void addSubPart(int codigo, int count){
        SubPart sub = new SubPart();
        sub.codigoPart = codigo;
        sub.count = count;
        subParts.add(sub);
    }

}