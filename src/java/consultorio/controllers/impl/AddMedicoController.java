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
import consultorio.dao.jpa.telefone.TelefoneDAO;
import consultorio.dao.jpa.telefone.TelefoneDAOFactory;
import consultorio.entidades.Endereco;
import consultorio.entidades.Medico;
import consultorio.entidades.Telefone;

/**
 *
 * @author Jess
 */
public class AddMedicoController extends AbstractController{
    @Override
    public void execute() {
       boolean sucesso = false;
        
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
        
        MedicoDAO dao = MedicoDAOFactory.getMedicoDAO();
        Medico user = dao.criaMedico(sNome, sEmail, sCrn, sSexo, sData, sEspecialidade);
        
        TelefoneDAO t = TelefoneDAOFactory.getTelefoneDAO();
        Telefone tel = t.criaTelefone(sDDD1, sTel, user);
        
        EnderecoDAO e = EnderecoDAOFactory.getEnderecoDAO();
        Endereco end = e.criaEndereco(sRua, sNum, sBairro, sCep, sCidade, sUF, sPais, user);
        
        this.setReturnPage("/confirmacaoCriacao.jsp");
        this.getRequest().setAttribute("resultado", new Boolean(sucesso));
    }
    
    
}
