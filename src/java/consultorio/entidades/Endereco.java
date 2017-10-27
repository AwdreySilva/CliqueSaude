/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * author Jessica Silveira/ Joyce Miyazato/ Felipe Figoli
 */

@Entity 
@Table(name = "endereco")
public class Endereco {
    
    @Id 
    @Column(name = "endereco_id") 
    @SequenceGenerator(name = "enderecoGenerator", sequenceName = "endereco_id_sequence", allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enderecoGenerator")
    private int idEnd;
    
    @Column(name="rua")
    private String rua;
    
    @Column(name="numero")
    private String numero;
    
    @Column(name="bairro")
    private String bairro;
    
    @Column(name="cep")
    private String cep;
    
    @Column(name="cidade")
    private String cidade;
    
    @Column(name="uf")
    private String uf;
    
    @Column(name="pais")
    private String pais;
    
    @OneToOne(optional = false)
    @JoinColumn (name = "usuario_id")
    private Usuario user;

    public Endereco(int idEnd, String rua, String numero, String bairro, String cep, String cidade, String uf, String pais, Usuario user) {
        this.idEnd = idEnd;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.pais = pais;
        this.user = user;
    }

    public Endereco() {
    }
    
    

    public int getIdEnd() {
        return idEnd;
    }

    public void setIdEnd(int idEnd) {
        this.idEnd = idEnd;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    
}
