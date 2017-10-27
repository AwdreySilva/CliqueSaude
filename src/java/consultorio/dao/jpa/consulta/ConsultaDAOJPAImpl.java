/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.dao.jpa.consulta;

import consultorio.entidades.Cliente;
import consultorio.entidades.Consulta;
import consultorio.entidades.Medico;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Jessica Silveira/ Joyce Miyazato/ Felipe Figoli
 */
public class ConsultaDAOJPAImpl implements ConsultaDAO {
    static final private Log log = LogFactory.getLog(ConsultaDAOJPAImpl.class);
    private boolean bIsClosed = false;
        
    public ConsultaDAOJPAImpl() {}

    @Override
    public Consulta buscaConsultaPorId(int id) throws ConsultaNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Consulta u = em.find(Consulta.class, id);
        if (u == null) throw new ConsultaNaoEncontradoException("Consulta não encontrado");
        em.clear();
        em.close();
        emf.close();
        return u;
    }

    @Override
    public Collection buscaDataPorData(String data) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select u consulta u ");
        Collection result = null;
        result = q.getResultList();
        if(result.equals(data)){
            return result;
        }
        else{
            try {
                throw new ConsultaNaoEncontradoException("Consulta não encontrado");
            } catch (ConsultaNaoEncontradoException ex) {
                Logger.getLogger(ConsultaDAOJPAImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        em.clear();
        em.close();
        emf.close();
        return null;
    }
    @Override
    public List<Consulta> buscaTodosConsulta() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select u from consulta u ");
        List<Consulta> result = null;
        result = q.getResultList();
        em.clear();
        em.close();
        emf.close();
        return result;
    }

    @Override
    public void removeConsulta(int id) throws ConsultaNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Consulta u = em.find(Consulta.class, id);
        em.remove(u);
        if (u == null) throw new ConsultaNaoEncontradoException("Consulta não encontrado");
        em.clear();
        em.close();
        emf.close();
    } 

    public Consulta criaConsulta(String data, String horario, Medico medico, Cliente cliente) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Consulta c = new Consulta();
        em.getTransaction().begin();
        c.setHorario(horario);
        c.setData(data);
        c.setCliente(cliente);
        c.setMed(medico);
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        return c;
    }

    
    public void updateConsulta(int id, String data, String horario, Medico medico, Cliente cliente) throws ConsultaNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Consulta u = em.find(Consulta.class, id);
        if (u == null) throw new ConsultaNaoEncontradoException("Consulta não encontrado");
        u.setHorario(horario);
        u.setData(data);
        u.setCliente(cliente);
        u.setMed(medico);
        em.clear();
        em.close();
        emf.close();
    }

     @Override
    public void close() {
        log.info("close() called");
        bIsClosed = true;
    }

    @Override
    public boolean isClosed() {
        return bIsClosed;
    }

}
