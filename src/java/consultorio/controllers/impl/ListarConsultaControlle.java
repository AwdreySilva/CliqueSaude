/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.controllers.impl;

import consultorio.controllers.AbstractController;
import consultorio.dao.jpa.consulta.ConsultaDAO;
import consultorio.dao.jpa.consulta.ConsultaDAOFactory;
import consultorio.entidades.Consulta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jess
 */
public class ListarConsultaControlle extends AbstractController {

    @Override
    public void execute() {
        List<Consulta> consulta = new ArrayList<Consulta>();
        ConsultaDAO con = ConsultaDAOFactory.getConsultaDAO();
        consulta = con.buscaTodosConsulta();
        
        this.setReturnPage("/HabilitarAgenda.jsp");
        this.getRequest().setAttribute("consulta", consulta);
    }
    
}
