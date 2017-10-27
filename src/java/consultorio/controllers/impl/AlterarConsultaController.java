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
import consultorio.dao.jpa.consulta.ConsultaDAO;
import consultorio.dao.jpa.consulta.ConsultaDAOFactory;
import consultorio.dao.jpa.consulta.ConsultaNaoEncontradoException;
import consultorio.dao.jpa.medico.MedicoDAO;
import consultorio.dao.jpa.medico.MedicoDAOFactory;
import consultorio.dao.jpa.medico.MedicoNaoEncontradoException;
import consultorio.entidades.Cliente;
import consultorio.entidades.Consulta;
import consultorio.entidades.Medico;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jess
 */
public class AlterarConsultaController extends AbstractController  {

    @Override
    public void execute() {
         boolean sucesso = false;
         
        String sID = request.getParameter("id");
        int id = Integer.parseInt(sID);
        String sData = request.getParameter("date");
        String sSemana = request.getParameter("Semana");
        String sHora = request.getParameter("time");
        String sIDMED = request.getParameter("idMed");
        int idMED = Integer.parseInt(sIDMED);
        String sNomeMed = request.getParameter("noemMed");
        String sEspecialidade = request.getParameter("especialidade");
        String sIDCLI = request.getParameter("idCli");
        int idcli = Integer.parseInt(sIDCLI);
        String sNomeCli = request.getParameter("nomeCli");
       
        Cliente user = new Cliente();
        ClienteDAO dao = ClienteDAOFactory.getClienteDAO();
        if(sNomeCli != null){
            user = (Cliente) dao.buscaClientePorNome(sNomeCli);
        } 
        else  if(idcli != 0){
            try {
                user = (Cliente) dao.buscaClientePorId(idcli);
            } catch (ClienteNaoEncontradoException ex) {
                Logger.getLogger(AddConsultaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Medico userM = new Medico();
        MedicoDAO med = MedicoDAOFactory.getMedicoDAO();
        
        if(sNomeMed != null){
            userM = (Medico) med.buscaMedicoPorNome(sNomeMed);
        } 
        else  if(idMED != 0){          
            try {
                userM = med.buscaMedicoPorId(idMED);
            } catch (MedicoNaoEncontradoException ex) {
                Logger.getLogger(AddConsultaController.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        if(sEspecialidade != null){
            userM = (Medico) med.buscaMedicoPorEspecialidade(sEspecialidade);
        }
        
        Consulta consulta = new Consulta();
        ConsultaDAO con = ConsultaDAOFactory.getConsultaDAO();
        try {
            con.updateConsulta(id, sData, sSemana, sHora, userM, user);
        } catch (ConsultaNaoEncontradoException ex) {
            Logger.getLogger(AlterarConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         this.setReturnPage("/confirmacaoCriacao.jsp");
        this.getRequest().setAttribute("resultado", new Boolean(sucesso));
    }
    
}
