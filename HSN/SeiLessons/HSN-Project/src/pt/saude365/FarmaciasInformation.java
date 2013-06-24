package pt.saude365;

public class FarmaciasInformation {
    
    private String farmaciaName;
    private String directorTecnico;
    private String morada;
    private String distrito;
    private String concelho;
    private String freguesia;
    private String telefone;

    public void setFarmaciaName(String farmaciaName) {
        this.farmaciaName = farmaciaName;
    }

    public String getFarmaciaName() {
        return farmaciaName;
    }

    public void setDirectorTecnico(String directorTecnico) {
        this.directorTecnico = directorTecnico;
    }

    public String getDirectorTecnico() {
        return directorTecnico;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getMorada() {
        return morada;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setConcelho(String concelho) {
        this.concelho = concelho;
    }

    public String getConcelho() {
        return concelho;
    }

    public void setFreguesia(String freguesia) {
        this.freguesia = freguesia;
    }

    public String getFreguesia() {
        return freguesia;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }
}
