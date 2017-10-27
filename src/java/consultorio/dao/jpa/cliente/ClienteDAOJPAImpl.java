/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.dao.jpa.cliente;

/**
 *
 * @author Jessica Silveira/ Joyce Miyazato/ Felipe Figoli
 */
import consultorio.entidades.Cliente;
import consultorio.entidades.Endereco;
import consultorio.entidades.Telefone;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.commons.logging.*;

public class ClienteDAOJPAImpl implements ClienteDAO {
    static final private Log log = LogFactory.getLog(ClienteDAOJPAImpl.class);
    private boolean bIsClosed = false;
        
    public ClienteDAOJPAImpl() {}

    @Override
    public Cliente buscaClientePorId(int id) throws ClienteNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Cliente u = em.find(Cliente.class, id);
        if (u == null) throw new ClienteNaoEncontradoException("Cliente não encontrado");
        em.clear();
        em.close();
        emf.close();
        return u;
    }

    @Override
    public Collection buscaClientePorNome(String nome) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select c from Cliente c ");
        Collection result = null;
        result = q.getResultList();
        if(result.equals(nome)){
            return result;
        }
        else{
            try {
                throw new ClienteNaoEncontradoException("Cliente não encontrado");
            } catch (ClienteNaoEncontradoException ex) {
                Logger.getLogger(ClienteDAOJPAImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        em.clear();
        em.close();
        emf.close();
        return null;
    }

    @Override
    public List<Cliente> buscaTodosClientes() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select c from Cliente c ");
        List<Cliente> result = null;
        result = q.getResultList();
        em.clear();
        em.close();
        emf.close();
        return result;
    }

    @Override
    public void removeCliente(int id) throws ClienteNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Cliente u = em.find(Cliente.class, id);
        em.remove(u);
        if (u == null) throw new ClienteNaoEncontradoException("Cliente não encontrado");
        em.clear();
        em.close();
        emf.close();
    } 

    public Cliente criaCliente(String nome, String email, String cpf, String sexo, String data) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Cliente u = new Cliente();
        u.setNome(nome);
        u.setEmail(email);
        u.setDataNascimento(data);
        u.setCPF(cpf);
        u.setSexo(sexo);
        
        em.persist(u);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        return u;
    }

    
    public void updateCliente(int id, String nome, String email, String cpf, String sexo, String data) throws ClienteNaoEncontradoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioMedicoPU");
        EntityManager em = emf.createEntityManager();
        Cliente u = em.find(Cliente.class, id);
        if (u == null) throw new ClienteNaoEncontradoException("Cliente não encontrado");
        u.setNome(nome);
        u.setEmail(email);
        u.setDataNascimento(data);
        u.setCPF(cpf);
        u.setSexo(sexo);
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