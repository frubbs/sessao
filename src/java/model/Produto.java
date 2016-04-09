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
    private float preco;
    private float precoCusto;
    

    public Produto(Integer id, String nome, ClassificacaoProduto tipo, float preco, float precoCusto) {
        this.nome = nome;
        this.tipo = tipo;
        
        this.id = id;
        this.preco = preco;
        
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

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(float precoCusto) {
        this.precoCusto = precoCusto;
    }

    
    
    
    
    
    
}
