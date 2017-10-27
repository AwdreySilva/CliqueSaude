/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.dao.jpa.consulta;

import consultorio.entidades.Cliente;
import consultorio.entidades.Consulta;
import consultorio.entidades.Medico;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Jessica Silveira/ Joyce Miyazato/ Felipe Figoli
 */
public interface ConsultaDAO {
    public Consulta buscaConsultaPorId(int id) throws ConsultaNaoEncontradoException;
    public List<Consulta> buscaTodosConsulta();
    public Collection buscaDataPorData(String data) throws ConsultaNaoEncontradoException;;
    public void removeConsulta(int id) throws ConsultaNaoEncontradoException;
    public Consulta criaConsulta(String data, String horario, Medico medico, Cliente cliente);
    public void updateConsulta(int id,String data, String horario, Medico medico, Cliente cliente) throws ConsultaNaoEncontradoException;
    public void close();
    public boolean isClosed();
    
}
