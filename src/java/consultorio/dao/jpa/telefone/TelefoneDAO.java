/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.dao.jpa.telefone;

import consultorio.entidades.Telefone;
import consultorio.entidades.Usuario;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Jessica Silveira/ Joyce Miyazato/ Felipe Figoli
 */
public interface TelefoneDAO {
    public Collection buscaTelefone(Usuario user) throws TelefoneNaoEncontradoException;
    public List<Telefone> buscaTodosTelefone();
    public void removeTelefone(int id) throws TelefoneNaoEncontradoException;
    public Telefone criaTelefone(String ddd, String numero, Usuario user);
    public void updateTelefone(int id, String ddd, String numero, Usuario user) throws TelefoneNaoEncontradoException;
    public void close();
    public boolean isClosed();
    
}
