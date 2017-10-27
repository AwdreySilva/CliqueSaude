/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.dao.jpa.telefone;

import consultorio.entidades.Telefone;
import consultorio.entidades.Usuario;
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

public class TelefoneDAOJPAImpl implements TelefoneDAO {
    static final private Log log = LogFactory.getLog(TelefoneDAOJPAImpl.class);
    private boolean bIsClosed = false;
        
    public TelefoneDAOJPAImpl() {}

    @Override
    public Collection buscaTelefone(Usuario user) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select u from telefone u ");
        Collection result = null;
        result = q.getResultList();
        if(result.equals(user)){
            return result;
        }
        else{
            try {
                throw new TelefoneNaoEncontradoException("Telefone não encontrado");
            } catch (TelefoneNaoEncontradoException ex) {
                Logger.getLogger(TelefoneDAOJPAImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        em.clear();
        em.close();
        emf.close();
        return null;
    }

    @Override
    public List<Telefone> buscaTodosTelefone() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select u from telefone u ");
        List<Telefone> result = null;
        result = q.getResultList();
        em.clear();
        em.close();
        emf.close();
        return result;
    }

    @Override
    public void removeTelefone(int id) throws TelefoneNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Telefone u = em.find(Telefone.class, id);
        em.remove(u);
        if (u == null) throw new  TelefoneNaoEncontradoException("Telfone não encontrado");
        em.clear();
        em.close();
        emf.close();
    } 

    public Telefone criaTelefone(String ddd, String numero, Usuario user) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Telefone u = new Telefone();
        em.getTransaction().begin();
        u.setDdd(ddd);
        u.setNumero(numero);
        u.setUser(user);
        em.persist(u);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        return u;
    }

    
    public void updateTelefone(int id, String ddd, String numero, Usuario user) throws TelefoneNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Telefone u = em.find(Telefone.class, id);
        if (u == null) throw new TelefoneNaoEncontradoException("Telefone não encontrado");
        u.setDdd(ddd);
        u.setNumero(numero);
        u.setUser(user);
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