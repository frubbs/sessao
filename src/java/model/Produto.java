/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author rafa
 */
public class Produto {
    private Integer id;
    private String nome;
    private ClassificacaoProduto tipo;

    public Produto(Integer id, String nome, ClassificacaoProduto tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public ClassificacaoProduto getTipo() {
        return tipo;
    }

    
    
}
