/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.controllers.impl;

import consultorio.controllers.AbstractController;
import consultorio.dao.jpa.consulta.ConsultaDAO;
import consultorio.dao.jpa.consulta.ConsultaDAOFactory;
import consultorio.dao.jpa.consulta.ConsultaNaoEncontradoException;
import consultorio.entidades.Consulta;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jess
 */
public class BuscaConsultaController extends AbstractController {

    @Override
    public void execute() {
        
        String sID = request.getParameter("id");
        int id = Integer.parseInt(sID);
        String sData = request.getParameter("data");
        
        Consulta consulta = new Consulta();
        ConsultaDAO con = ConsultaDAOFactory.getConsultaDAO();
        
        if(id != 0){
            try {
                consulta = con.buscaConsultaPorId(id);
            } catch (ConsultaNaoEncontradoException ex) {
                Logger.getLogger(BuscaConsultaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(sData != null){
            try {
                consulta = (Consulta) con.buscaDataPorData(sData);
            } catch (ConsultaNaoEncontradoException ex) {
                Logger.getLogger(BuscaConsultaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
        this.setReturnPage("/ResultadoConsulta.jsp");
        this.getRequest().setAttribute("consulta", consulta);
    }
    
    
}
