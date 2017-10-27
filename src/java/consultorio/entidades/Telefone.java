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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 *  author Jessica Silveira/ Joyce Miyazato/ Felipe Figoli
 */
@Entity 
@Table(name = "telefone")
public class Telefone {
    
    @Id 
    @Column(name = "telefone_id") 
    @SequenceGenerator(name = "telefoneGenerator", sequenceName = "telefone_id_sequence", allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "telefoneGenerator")
    private int idTel;
    
    @Column(name="ddd")
    private String ddd;
    
    @Column(name="numero")
    private String numero;

    @OneToOne(optional = false)
    @JoinColumn (name = "usuario_id")
    private Usuario user;
    
    public Telefone() {
    }

    public Telefone(int idTel, String ddd, String numero, Usuario user) {
        this.idTel = idTel;
        this.ddd = ddd;
        this.numero = numero;
        this.user = user;
    }

   

    public int getIdTel() {
        return idTel;
    }

    public void setIdTel(int idTel) {
        this.idTel = idTel;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    
    
    

    
}
