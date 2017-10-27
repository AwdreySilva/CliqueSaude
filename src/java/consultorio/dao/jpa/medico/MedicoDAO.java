/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.dao.jpa.medico;

import consultorio.entidades.Endereco;
import consultorio.entidades.Medico;
import consultorio.entidades.Telefone;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Jessica Silveira/ Joyce Miyazato/ Felipe Figoli
 */
public interface MedicoDAO {
    public Medico buscaMedicoPorId(int id) throws MedicoNaoEncontradoException;
    public Collection buscaMedicoPorNome(String nome);
    public Collection buscaMedicoPorEspecialidade(String especialidade);
    public List<Medico> buscaTodosMedico();
    public void removeMedico(int id) throws MedicoNaoEncontradoException;
    public Medico criaMedico(String nome,String email, String crm, String sexo, String data, String especialidade);
    public void updateMedico(int id, String nome, String email, String crm, String sexo, String data,String especialidade) throws MedicoNaoEncontradoException;
    public void close();
    public boolean isClosed();
    
}
