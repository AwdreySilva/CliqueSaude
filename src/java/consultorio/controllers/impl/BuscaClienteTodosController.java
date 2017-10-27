/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.controllers.impl;

import consultorio.controllers.AbstractController;
import consultorio.dao.jpa.cliente.ClienteDAO;
import consultorio.dao.jpa.cliente.ClienteDAOFactory;
import consultorio.dao.jpa.endereco.EnderecoDAO;
import consultorio.dao.jpa.endereco.EnderecoDAOFactory;
import consultorio.dao.jpa.telefone.TelefoneDAO;
import consultorio.dao.jpa.telefone.TelefoneDAOFactory;
import consultorio.dao.jpa.telefone.TelefoneNaoEncontradoException;
import consultorio.entidades.Cliente;
import consultorio.entidades.Endereco;
import consultorio.entidades.Telefone;
import consultorio.entidades.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jess
 */
public class BuscaClienteTodosController  extends AbstractController {

    @Override
    public void execute() {
        
        ClienteDAO c = ClienteDAOFactory.getClienteDAO();
        List<Cliente> cl = c.buscaTodosClientes();

       
        Telefone tel = new Telefone();
        TelefoneDAO t = TelefoneDAOFactory.getTelefoneDAO();
        try {
           tel =  (Telefone) t.buscaTelefone((Usuario) cl);
        } catch (TelefoneNaoEncontradoException ex) {
            Logger.getLogger(BuscaMedicoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Endereco end = new Endereco();
        EnderecoDAO e = EnderecoDAOFactory.getEnderecoDAO();
        end = (Endereco) e.buscaEndereco((Usuario) cl);
        
        
        this.setReturnPage("/ResultadoTodosCliente.jsp");
        this.getRequest().setAttribute("cliente", cl);
        this.getRequest().setAttribute("tel", tel);
        this.getRequest().setAttribute("endereco", end);
    }
    
}