package pt.saude365;

public class DetalhesMedicamento {
    
    private String dci;
    private String nome;
    private String dose;
    private String formaFarmaceutica;
    private String generico;
    private String titular;
    private String dataAutorizacao;
    private String estadoAutorizacao;
    private String classificacaoDispensa;
    private String classificacaoEstupefaciente;
    private String anatomicalClassification;
    private String classificacaoFarmacoterapeutica;
    private String viaAdministracao;
    private String grupoProduto;
    private String numeroProcesso;
    private String margemTerapeutica;
    
    public DetalhesMedicamento() {
        super();
    }
    
    public void setNome(String str){
        this.nome = str;    
    }

    public String getNome() {
        return nome;
    }

    public void setDci(String dci) {
        this.dci = dci;
    }

    public String getDci() {
        return dci;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getDose() {
        return dose;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setGenerico(String generico) {
        this.generico = generico;
    }

    public String getGenerico() {
        return generico;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getTitular() {
        return titular;
    }

    public void setDataAutorizacao(String dataAutorizacao) {
        this.dataAutorizacao = dataAutorizacao;
    }

    public String getDataAutorizacao() {
        return dataAutorizacao;
    }

    public void setEstadoAutorizacao(String estadoAutorizacao) {
        this.estadoAutorizacao = estadoAutorizacao;
    }

    public String getEstadoAutorizacao() {
        return estadoAutorizacao;
    }

    public void setClassificacaoDispensa(String classificacaoDispensa) {
        this.classificacaoDispensa = classificacaoDispensa;
    }

    public String getClassificacaoDispensa() {
        return classificacaoDispensa;
    }

    public void setClassificacaoEstupefaciente(String classificacaoEstupefaciente) {
        this.classificacaoEstupefaciente = classificacaoEstupefaciente;
    }

    public String getClassificacaoEstupefaciente() {
        return classificacaoEstupefaciente;
    }

    public void setAnatomicalClassification(String anatomicalClassification) {
        this.anatomicalClassification = anatomicalClassification;
    }

    public String getAnatomicalClassification() {
        return anatomicalClassification;
    }

    public void setClassificacaoFarmacoterapeutica(String classificacaoFarmacoterapeutica) {
        this.classificacaoFarmacoterapeutica = classificacaoFarmacoterapeutica;
    }

    public String getClassificacaoFarmacoterapeutica() {
        return classificacaoFarmacoterapeutica;
    }

    public void setViaAdministracao(String viaAdministracao) {
        this.viaAdministracao = viaAdministracao;
    }

    public String getViaAdministracao() {
        return viaAdministracao;
    }

    public void setGrupoProduto(String grupoProduto) {
        this.grupoProduto = grupoProduto;
    }

    public String getGrupoProduto() {
        return grupoProduto;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setMargemTerapeutica(String margemTerapeutica) {
        this.margemTerapeutica = margemTerapeutica;
    }

    public String getMargemTerapeutica() {
        return margemTerapeutica;
    }
}
