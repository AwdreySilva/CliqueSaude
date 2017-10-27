/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.dao.jpa.endereco;

import consultorio.entidades.Endereco;
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

/**
 *
 * @author Jessica Silveira/ Joyce Miyazato/ Felipe Figoli
 */
public class EnderecoDAOJPAImpl implements EnderecoDAO {
    static final private Log log = LogFactory.getLog(EnderecoDAOJPAImpl.class);
    private boolean bIsClosed = false;
        
    public EnderecoDAOJPAImpl() {}

    @Override
    public Collection buscaEndereco(Usuario user) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select u from endereco u ");
        Collection result = null;
        result = q.getResultList();
        if(result.equals(user)){
            return result;
        }
        else{
            try {
                throw new EnderecoNaoEncontradoException("Endereço não encontrado");
            } catch (EnderecoNaoEncontradoException ex) {
                Logger.getLogger(EnderecoDAOJPAImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        em.clear();
        em.close();
        emf.close();
        return null;
    }

    @Override
    public List<Endereco> buscaTodosEndereco() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select u from endereco u ");
        List<Endereco> result = null;
        result = q.getResultList();
        em.clear();
        em.close();
        emf.close();
        return result;
    }

    @Override
    public void removeEndereco(int id) throws EnderecoNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Endereco u = em.find(Endereco.class, id);
        em.remove(u);
        if (u == null) throw new EnderecoNaoEncontradoException("Endereço não encontrado");
        em.clear();
        em.close();
        emf.close();
    } 

    public Endereco criaEndereco(String rua, String numero, String bairro, String cep, String cidade, String uf, String pais, Usuario user) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Endereco u = new Endereco();
        em.getTransaction().begin();
        u.setRua(rua);
        u.setNumero(numero);
        u.setBairro(bairro);
        u.setCep(cep);
        u.setCidade(cidade);
        u.setUf(uf);
        u.setPais(pais);
        u.setUser(user);
        em.persist(u);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        return u;
    }

    
    public void updateEndereco(int id,String rua, String numero, String bairro, String cep, String cidade, String uf, String pais, Usuario user) throws EnderecoNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Endereco u = em.find(Endereco.class, id);
        if (u == null) throw new EnderecoNaoEncontradoException("Endereço não encontrado");
        u.setRua(rua);
        u.setNumero(numero);
        u.setBairro(bairro);
        u.setCep(cep);
        u.setCidade(cidade);
        u.setUf(uf);
        u.setPais(pais);
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
