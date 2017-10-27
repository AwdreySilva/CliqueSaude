/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.controllers.impl;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jess
 */
public class BuscaMedicoController extends AbstractController {

    @Override
    public void execute() {
        
        String sID = request.getParameter("id");
        int id = Integer.parseInt(sID);
        String sNome = request.getParameter("nome");
        String sEspecialidade = request.getParameter("especialidade");
        
        Medico med = new Medico();
        MedicoDAO m = MedicoDAOFactory.getMedicoDAO();
        
        if(id != 0){
            
            try {
                med = m.buscaMedicoPorId(id);
                        
                        } catch (MedicoNaoEncontradoException ex) {
                Logger.getLogger(BuscaMedicoController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        else if(sNome != null){
            med = (Medico) m.buscaMedicoPorNome(sNome);
        } 
        if(sEspecialidade != null){
            med = (Medico) m.buscaMedicoPorEspecialidade(sEspecialidade);
        }
        Telefone tel = new Telefone();
        TelefoneDAO t = TelefoneDAOFactory.getTelefoneDAO();
        try {
           tel =  (Telefone) t.buscaTelefone(med);
        } catch (TelefoneNaoEncontradoException ex) {
            Logger.getLogger(BuscaMedicoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Endereco end = new Endereco();
        EnderecoDAO e = EnderecoDAOFactory.getEnderecoDAO();
        end = (Endereco) e.buscaEndereco(med);
        
        
        this.setReturnPage("/ResultadoMedico.jsp");
        this.getRequest().setAttribute("medico", med);
        this.getRequest().setAttribute("tel", tel);
        this.getRequest().setAttribute("endereco", end);
    }
    
}
