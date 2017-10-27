/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.controllers.impl;

import consultorio.controllers.AbstractController;
import consultorio.dao.jpa.endereco.EnderecoDAO;
import consultorio.dao.jpa.endereco.EnderecoDAOFactory;
import consultorio.dao.jpa.endereco.EnderecoNaoEncontradoException;
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
public class AlterarMedicoController extends AbstractController{
    @Override
    public void execute() {
       boolean sucesso = false;
        
        String sID = request.getParameter("id");
        int id = Integer.parseInt(sID);
        String sNome = request.getParameter("nome");
        String sEmail = request.getParameter("email");
        String sCrn = request.getParameter("crn");
        String sData = request.getParameter("date");
        String sSexo = request.getParameter("sex");
        String sEspecialidade = request.getParameter("especialidade");
        
        String sDDD1 = request.getParameter("ddd1");
        String sDDD2 = request.getParameter("ddd2");
        String sTel = request.getParameter("tel");
        String sCel = request.getParameter("cel");
        
        String sRua = request.getParameter("rua");
        String sNum = request.getParameter("numero");
        String sBairro = request.getParameter("bairro");
        String sCep = request.getParameter("cep");
        String sCidade = request.getParameter("cidade");
        String sUF = request.getParameter("UF");
        String sPais = request.getParameter("pais");
        
        Medico user = new Medico(-1,sNome, sEmail, sSexo, sData, sEspecialidade, sCrn);
        MedicoDAO dao = MedicoDAOFactory.getMedicoDAO();
        try {
            dao.updateMedico(id, sNome, sEmail, sCrn, sSexo, sData, sEspecialidade);
        } catch (MedicoNaoEncontradoException ex) {
            Logger.getLogger(AlterarMedicoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Telefone tel = new Telefone(-1, sDDD1, sTel, user);
        TelefoneDAO t = TelefoneDAOFactory.getTelefoneDAO();
        try {
            t.updateTelefone(id, sDDD2, sNum, user);
        } catch (TelefoneNaoEncontradoException ex) {
            Logger.getLogger(AlterarMedicoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Endereco end = new Endereco(-1,sRua, sNum, sBairro, sCep, sCidade, sUF, sPais, user);
        EnderecoDAO e = EnderecoDAOFactory.getEnderecoDAO();
        try {
            e.updateEndereco(id, sRua, sNum, sBairro, sCep, sCidade, sUF, sPais, user);
        } catch (EnderecoNaoEncontradoException ex) {
            Logger.getLogger(AlterarMedicoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.setReturnPage("/confirmacaoCriacao.jsp");
        this.getRequest().setAttribute("resultado", new Boolean(sucesso));
    }
    
    
}
