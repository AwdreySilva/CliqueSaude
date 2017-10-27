/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Jessica Silveira/ Joyce Miyazato/ Felipe Figoli
 */

@Entity
@PrimaryKeyJoinColumn(name="usuario_id")
public class Medico extends Usuario{
    @Column(name="CRM")
    private String crm;
    
    @Column(name="especialidade")
    private String especialidade;

    public Medico(int id, String nome, String email, String sexo, String dataNascimento, String especialidade, String crn) {
        super(id, nome, email, sexo, dataNascimento);
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public Medico() {
    }
    
    public String getCRM() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
    
      public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
}
