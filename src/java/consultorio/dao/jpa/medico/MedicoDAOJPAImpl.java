/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.dao.jpa.medico;

import consultorio.entidades.Endereco;
import consultorio.entidades.Medico;
import consultorio.entidades.Telefone;
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
public class MedicoDAOJPAImpl implements MedicoDAO {
    static final private Log log = LogFactory.getLog(MedicoDAOJPAImpl.class);
    private boolean bIsClosed = false;
        
    public MedicoDAOJPAImpl() {}

    @Override
    public Medico buscaMedicoPorId(int id) throws MedicoNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Medico u = em.find(Medico.class, id);
        if (u == null) throw new MedicoNaoEncontradoException("Medico não encontrado");
        em.clear();
        em.close();
        emf.close();
        return u;
    }

    @Override
    public Collection buscaMedicoPorNome(String nome) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select m from Medico m ");
        Collection result = null;
        result = q.getResultList();
        if(result.equals(nome)){
            return result;
        }
        else{
            try {
                throw new MedicoNaoEncontradoException("Medico não encontrado");
            } catch (MedicoNaoEncontradoException ex) {
                Logger.getLogger(MedicoDAOJPAImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        em.clear();
        em.close();
        emf.close();
        return null;
    }
    
    @Override
    public Collection buscaMedicoPorEspecialidade(String especialidade) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select m from Medico m ");
        Collection result = null;
        result = q.getResultList();
        if(result.equals(especialidade)){
            return result;
        }
        else{
            try {
                throw new MedicoNaoEncontradoException("Medico não encontrado");
            } catch (MedicoNaoEncontradoException ex) {
                Logger.getLogger(MedicoDAOJPAImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        em.clear();
        em.close();
        emf.close();
        return null;
    }

    @Override
    public List<Medico> buscaTodosMedico() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT m FROM Medico m");
        List<Medico> result = null;
        result = q.getResultList();
        em.clear();
        em.close();
        emf.close();
        return result;
    }

    @Override
    public void removeMedico(int id) throws MedicoNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Medico u = em.find(Medico.class, id);
        em.remove(u);
        if (u == null) throw new MedicoNaoEncontradoException("Medico não encontrado");
        em.clear();
        em.close();
        emf.close();
    } 

    public Medico criaMedico(String nome, String email, String crm, String sexo, String data, String especialidade) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Medico u = new Medico();
        em.getTransaction().begin();
        u.setNome(nome);
        u.setEmail(email);
        u.setDataNascimento(data);
        u.setCrm(crm);
        u.setSexo(sexo);
        u.setEspecialidade(especialidade);
        em.persist(u);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        return u;
    }

    
    public void updateMedico(int id, String nome, String email, String crm, String sexo, String data, String especialidade) throws MedicoNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Medico u = em.find(Medico.class, id);
        if (u == null) throw new MedicoNaoEncontradoException("Medico não encontrado");
        u.setNome(nome);
        u.setEmail(email);
        u.setDataNascimento(data);
        u.setCrm(crm);
        u.setSexo(sexo);
        u.setEspecialidade(especialidade);
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