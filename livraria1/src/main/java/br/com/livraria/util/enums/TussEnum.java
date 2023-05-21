package br.com.livraria.util.enums;

public enum TussEnum {
    
    HEMOGLOBINA             ("HEMOGLOBINA",             "40304345, 40304361"),
    CONTAGEM_PLAQUETAS      ("CONTAGEM DE PLAQUETAS",   "40304922"),
    GLICEMIA                ("GLICEMIA",                "40302040, 40302709, 40305228"),
    COLESTEROL_TOTAL        ("COLESTEROL TOTAL",        "40302750, 40301605"),
    HDL                     ("HDL",                     "40301583, 40302750"),
    LDL                     ("LDL",                     "40301591, 40302750"),
    TRIGLICERIDEOS          ("TRIGLICERÍDEOS",          "40302750, 40302547"),
    UREIA                   ("URÉIA",                   "40302580"),
    CREATININA              ("CREATININA",              "40301630"),
    SODIO                   ("SÓDIO",                   "40302423"),
    POTASSIO                ("POTÁSSIO",                "40302318"),
    INR                     ("INR (R.N.I.)",            "40304590"),
    TSH1                    ("TSH",                     "40305627, 40316521"),
    T4_LIVRE                ("T4 LIVRE",                "40305627, 40316491"),
    ACIDO_URICO             ("ÁCIDO ÚRICO",             "40301150, 40312127");
    
    private String descricaoTuss;
    private String tuss;
    
    
    private TussEnum(String descricaoTuss, String tuss) {
        this.descricaoTuss = descricaoTuss;
        this.tuss = tuss;
    }


    public String getDescricaoTuss() {
        return descricaoTuss;
    }


    public void setDescricaoTuss(String descricaoTuss) {
        this.descricaoTuss = descricaoTuss;
    }


    public String getTuss() {
        return tuss;
    }


    public void setTuss(String tuss) {
        this.tuss = tuss;
    }
}
