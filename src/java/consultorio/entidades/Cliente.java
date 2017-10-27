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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Jessica Silveira/ Joyce Miyazato/ Felipe Figoli
 */

@Entity
@PrimaryKeyJoinColumn(name="usuario_id")
public class Cliente extends Usuario{

    @Column(name="CPF")
    private String CPF;

    public Cliente(int id, String nome, String email, String CPF, String sexo, String dataNascimento) {
        super(id, nome, email, sexo, dataNascimento);
        this.CPF = CPF;
    }

    public Cliente(){
        
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCPF() {
        return CPF;
    }

}
