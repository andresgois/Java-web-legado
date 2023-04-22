package br.com.livraria.modelo.vo;

import java.util.ArrayList;

public class Indicador {
   
    private int id;
    private String code;
    private String description;
    private int selected = 0;
    private ArrayList<Integer> tussCodes;
    private String unity;
    private ArrayList<IndicatorsData> data;
    
    public Indicador() {}
    
    public Indicador(int id,String code, String description) {
        super();
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public ArrayList<Integer> getTussCodes() {
        return tussCodes;
    }

    public void setTussCodes(ArrayList<Integer> tussCodes) {
        this.tussCodes = tussCodes;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public ArrayList<IndicatorsData> getData() {
        return data;
    }

    public void setData(ArrayList<IndicatorsData> data) {
        this.data = data;
    }
    
    
}
