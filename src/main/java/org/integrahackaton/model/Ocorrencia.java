package org.integrahackaton.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;

@Entity(name = "ocorrencia2")
@Table(name = "ocorrencia2")
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long duf;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Calendar dataDuf;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Calendar dataEntrega;
    private String fiscal;
    private String observacao;
    private String ouvidoria;
    private Integer prazoDias;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Calendar vencimentoPrazo;
    private Tipo tipo;

    @OneToOne
    private Person personName;
    @OneToOne
    private Imovel imovelName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getDuf() {
        return duf;
    }

    public void setDuf(Long duf) {
        this.duf = duf;
    }

    public Calendar getDataDuf() {
        return dataDuf;
    }

    public void setDataDuf(Calendar dataDuf) {
        this.dataDuf = dataDuf;
    }

    public Calendar getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Calendar dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getFiscal() {
        return fiscal;
    }

    public void setFiscal(String fiscal) {
        this.fiscal = fiscal;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getOuvidoria() {
        return ouvidoria;
    }

    public void setOuvidoria(String ouvidoria) {
        this.ouvidoria = ouvidoria;
    }

    public Integer getPrazoDias() {
        return prazoDias;
    }

    public void setPrazoDias(Integer prazoDias) {
        this.prazoDias = prazoDias;
    }

    public Calendar getVencimentoPrazo() {
        return vencimentoPrazo;
    }

    public void setVencimentoPrazo(Calendar vencimentoPrazo) {
        this.vencimentoPrazo = vencimentoPrazo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Person getPersonName() {
        return personName;
    }

    public void setPersonName(Person personName) {
        this.personName = personName;
    }

    public Imovel getImovelName() {
        return imovelName;
    }

    public void setImovelName(Imovel imovelName) {
        this.imovelName = imovelName;
    }
}
