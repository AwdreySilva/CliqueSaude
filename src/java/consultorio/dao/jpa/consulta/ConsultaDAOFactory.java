/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.dao.jpa.consulta;

/**
 *
 * @author Jessica Silveira/ Joyce Miyazato/ Felipe Figoli
 */
public final class ConsultaDAOFactory {
    private ConsultaDAOFactory() {
    }
    public static ConsultaDAO getConsultaDAO(){
        return new ConsultaDAOJPAImpl();
    }
}