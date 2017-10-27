/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.controllers.impl;

import consultorio.controllers.AbstractController;
import consultorio.dao.jpa.endereco.EnderecoDAO;
import consultorio.dao.jpa.endereco.EnderecoDAOFactory;
import consultorio.dao.jpa.medico.MedicoDAO;
import consultorio.dao.jpa.medico.MedicoDAOFactory;
import consultorio.dao.jpa.medico.MedicoNaoEncontradoException;
import consultorio.dao.jpa.telefone.TelefoneDAO;
import consultorio.dao.jpa.telefone.TelefoneDAOFactory;
import consultorio.dao.jpa.telefone.TelefoneNaoEncontradoException;
import consultorio.entidades.Endereco;
import consultorio.entidades.Medico;
import consultorio.entidades.Telefone;
import consultorio.entidades.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jess
 */
public class BuscaMedicosTodosController extends AbstractController {

    @Override
    public void execute() {
        
        MedicoDAO m = MedicoDAOFactory.getMedicoDAO();
        List<Medico> med = m.buscaTodosMedico();

       
        Telefone tel = new Telefone();
        TelefoneDAO t = TelefoneDAOFactory.getTelefoneDAO();
        try {
           tel =  (Telefone) t.buscaTelefone((Usuario) med);
        } catch (TelefoneNaoEncontradoException ex) {
            Logger.getLogger(BuscaMedicoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Endereco end = new Endereco();
        EnderecoDAO e = EnderecoDAOFactory.getEnderecoDAO();
        end = (Endereco) e.buscaEndereco((Usuario) med);
        
        
        this.setReturnPage("/ResultadoTodosMedico.jsp");
        this.getRequest().setAttribute("medico", med);
        this.getRequest().setAttribute("tel", tel);
        this.getRequest().setAttribute("endereco", end);
    }
    
}
