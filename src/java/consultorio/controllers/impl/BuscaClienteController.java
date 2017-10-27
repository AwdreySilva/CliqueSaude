/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.controllers.impl;

import consultorio.controllers.AbstractController;
import consultorio.dao.jpa.cliente.ClienteDAO;
import consultorio.dao.jpa.cliente.ClienteDAOFactory;
import consultorio.dao.jpa.cliente.ClienteNaoEncontradoException;
import consultorio.dao.jpa.endereco.EnderecoDAO;
import consultorio.dao.jpa.endereco.EnderecoDAOFactory;
import consultorio.dao.jpa.telefone.TelefoneDAO;
import consultorio.dao.jpa.telefone.TelefoneDAOFactory;
import consultorio.dao.jpa.telefone.TelefoneNaoEncontradoException;
import consultorio.entidades.Cliente;
import consultorio.entidades.Endereco;
import consultorio.entidades.Telefone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jess
 */
public class BuscaClienteController extends AbstractController {

    @Override
    public void execute() {
        
        String sID = request.getParameter("id");
        int id = Integer.parseInt(sID);
        String sNome = request.getParameter("nome");

        
        Cliente c = new Cliente();
        ClienteDAO cl = ClienteDAOFactory.getClienteDAO();
        
        if(id != 0){

            try {
                c = cl.buscaClientePorId(id) ;
            } catch (ClienteNaoEncontradoException ex) {
                Logger.getLogger(BuscaClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
 
           
        }
        else if(sNome != null){
            c = (Cliente) cl.buscaClientePorNome(sNome);
        } 

        Telefone tel = new Telefone();
        TelefoneDAO t = TelefoneDAOFactory.getTelefoneDAO();
        try {
           tel =  (Telefone) t.buscaTelefone(c);
        } catch (TelefoneNaoEncontradoException ex) {
            Logger.getLogger(BuscaMedicoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Endereco end = new Endereco();
        EnderecoDAO e = EnderecoDAOFactory.getEnderecoDAO();
        end = (Endereco) e.buscaEndereco(c);
        
        
        this.setReturnPage("/ResultadoCliente.jsp");
        this.getRequest().setAttribute("cliente", c);
        this.getRequest().setAttribute("tel", tel);
        this.getRequest().setAttribute("endereco", end);
    }
    
    
}
