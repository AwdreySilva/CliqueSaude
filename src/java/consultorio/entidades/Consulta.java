/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Jessica Silveira/ Joyce Miyazato/ Felipe Figoli
 */

@Entity 
@Table(name = "consulta")
public class Consulta {
    
    @Id 
    @Column(name = "consulta_id") 
    @SequenceGenerator(name = "consultaGenerator", sequenceName = "consulta_id_sequence", allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consultaGenerator")
    private int consulta_id;
    
    @Column(name="horario")
    private String horario;
    
    @Column(name="datas")
    private String data;
    
    @OneToOne(optional = false)
    @JoinColumn (name = "CPF")
    private Cliente cliente;
    
    @OneToOne(optional = false)
    @JoinColumn (name = "CRM")
    private Medico med; 

    public Consulta(int consulta_id, String horario, String data, Cliente cliente, Medico med) {
        this.consulta_id = consulta_id;
        this.horario = horario;
        this.data = data;
        this.cliente = cliente;
        this.med = med;
    }

    public Consulta() {
    }
    
    public int getConsulta_id() {
        return consulta_id;
    }

    public void setConsulta_id(int consulta_id) {
        this.consulta_id = consulta_id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Medico getMed() {
        return med;
    }

    public void setMed(Medico med) {
        this.med = med;
    }
    
}
