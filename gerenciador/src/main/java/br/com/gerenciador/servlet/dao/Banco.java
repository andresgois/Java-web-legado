package br.com.gerenciador.servlet.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.gerenciador.servlet.model.Empresa;

public class Banco {
    
    private static List<Empresa> lista = new ArrayList<>();
    
    static {
        Empresa emp1 = new Empresa();
        emp1.setId(1);
        emp1.setNome("Tech");
        Empresa emp2 = new Empresa();
        emp2.setId(2);
        emp2.setNome("Alura");
        lista.add(emp1);
        lista.add(emp2);
    }

    public void adicionar(Empresa empresa) {
        Banco.lista.add(empresa);
    }
    
    public List<Empresa> getEmpresas() {
        lista.forEach(System.out::println);
        return Banco.lista;
    }
    
}
