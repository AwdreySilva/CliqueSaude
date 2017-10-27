/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.dao.jpa.endereco;

import consultorio.entidades.Endereco;
import consultorio.entidades.Usuario;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Jessica Silveira/ Joyce Miyazato/ Felipe Figoli
 */
public interface EnderecoDAO {
    public Collection buscaEndereco(Usuario user);
    public List<Endereco> buscaTodosEndereco();
    public void removeEndereco(int id) throws EnderecoNaoEncontradoException;
    public Endereco criaEndereco(String rua, String numero, String bairro, String cep, String cidade, String uf, String pais, Usuario user);
    public void updateEndereco(int id,String rua, String numero, String bairro, String cep, String cidade, String uf, String pais, Usuario user) throws EnderecoNaoEncontradoException;
    public void close();
    public boolean isClosed();
    
}