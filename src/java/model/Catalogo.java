/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author rafa
 */
public class Catalogo {
    
    private HashMap<Integer,Produto> lista;
     
public Catalogo(String filename) {
        this.lista = new HashMap<Integer,Produto>();
        lerDoArquivo(filename);
    }
    
    private void lerDoArquivo(String filename)
    {
        BufferedReader br = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(filename));

                        int i = 0;
			while ((sCurrentLine = br.readLine()) != null) {
                            String[] s = sCurrentLine.split(";");
                            
                            lista.put(i, new Produto(i, s[0], ClassificacaoProduto.valueOf(s[1])));
                            i++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

    }
    
    
    //somente para testes
    public Catalogo() {
        
    }
    
    //somente para testes
    public void setLista(HashMap<Integer,Produto> lista) {
        this.lista = lista;
    }
    
    
    public Produto buscarProdutoPorId(Integer id){
        return lista.get(id);
    }
    
    public ArrayList<Produto> listarProdutos() {
        ArrayList<Produto> resultList = new ArrayList<Produto>();
        Iterator it = lista.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry par = (Map.Entry) it.next();
            Produto p = (Produto)par.getValue();
            
            resultList.add(p);
        }
        
        return resultList;
    }
    
    public ArrayList<Produto> listarProdutos(ClassificacaoProduto tipo) {
        ArrayList<Produto> resultList = new ArrayList<Produto>();
        Iterator it = lista.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry par = (Map.Entry) it.next();
            Produto p = (Produto)par.getValue();
            if (p.getTipo().equals(tipo))
                resultList.add(p);
        }
        
        return resultList;
    }
    
    
    
    
    
    
    
}
