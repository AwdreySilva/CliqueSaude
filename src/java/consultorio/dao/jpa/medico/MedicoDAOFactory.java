/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.dao.jpa.medico;

/**
 *
 * @author Jessica Silveira/ Joyce Miyazato/ Felipe Figoli
 */
public final class MedicoDAOFactory {

    private MedicoDAOFactory() {
    }
    
    public static MedicoDAO getMedicoDAO(){
        return new MedicoDAOJPAImpl();
    }
}
