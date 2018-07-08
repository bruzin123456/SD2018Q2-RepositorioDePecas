package com.sistemas_distribuidos;

import java.util.List;
import java.util.ArrayList;
import javafx.util.Pair;

public class Part
{
    private int codigo;
    private String nome;
    private String descricao;
    private List<Pair<Part, Integer>> subParts;
}