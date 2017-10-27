/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.entidades;


import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Jessica Silveira/ Joyce Miyazato/ Felipe Figoli
 */

@Entity 
@Inheritance(strategy =InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE")
@Table(name = "usuario")

public class Usuario {
    @Id 
    @Column(name = "usuario_id") 
    @SequenceGenerator(name = "usuarioGenerator", sequenceName = "usuario_id_sequence", allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioGenerator")
    private int id;
    
    @Column(name="nome")
    private String nome;
    
    @Column(name="email")
    private String email;
    
    @Column(name="sexo")
    private String sexo;
    
    @Column(name="datas")
    private String dataNascimento;

    public Usuario() {
    }
  

    public Usuario(int id, String nome, String email, String sexo, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
   
    
    
       
}
