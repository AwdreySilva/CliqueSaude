/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.dao.jpa.cliente;

import consultorio.entidades.Cliente;
import consultorio.entidades.Endereco;
import consultorio.entidades.Telefone;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Jessica Silveira/ Joyce Miyazato/ Felipe Figoli
 */
public interface ClienteDAO {
    public Cliente buscaClientePorId(int id) throws ClienteNaoEncontradoException;
    public Collection buscaClientePorNome(String nome);
    public List<Cliente> buscaTodosClientes();
    public void removeCliente(int id) throws ClienteNaoEncontradoException;
    public Cliente criaCliente(String nome, String email, String cpf, String sexo, String data );
    public void updateCliente(int id, String nome, String email, String cpf, String sexo, String data) throws ClienteNaoEncontradoException;
    public void close();
    public boolean isClosed();
    
}
