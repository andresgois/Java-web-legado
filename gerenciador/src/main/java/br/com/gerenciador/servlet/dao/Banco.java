package br.com.gerenciador.servlet.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.gerenciador.servlet.model.Empresa;

public class Banco {
    
    private static List<Empresa> lista = new ArrayList<>();
    private static Integer SEQUENCIAL = 1;
    
    static {
        Empresa emp1 = new Empresa();
        emp1.setId(SEQUENCIAL++);
        emp1.setNome("Tech");
        Empresa emp2 = new Empresa();
        emp2.setId(SEQUENCIAL++);
        emp2.setNome("Alura");
        lista.add(emp1);
        lista.add(emp2);
    }

    public void adicionar(Empresa empresa) {
        empresa.setId(SEQUENCIAL++);
        Banco.lista.add(empresa);
    }
    
    public List<Empresa> getEmpresas() {
        //lista.forEach(System.out::println);
        return Banco.lista;
    }
    
    public void removeEmpresa(Integer id) {
        Iterator<Empresa> it = lista.iterator();
        
        while(it.hasNext()) {
            Empresa emp = it.next();
            if(emp.getId() == id) {
                it.remove();
            }
        }
        /*for(Empresa e: lista){
            if(e.getId() == id) {
                lista.remove(e);
            }
        }*/
    }
    
}
