/*
http://www.objectdb.com/tutorial/jpa/netbeans/spring/dao
 */
package guest;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Xiaoyi
 */
@Component
public class GuestDao {
    //Injected database connection
    @PersistenceContext 
    private EntityManager em;
    
    //stores a new guest
    @Transactional
    public void persist(Guest guest){
        em.persist(guest);
    }
    
    //retrieves all the the guests
    public List<Guest> getAllGuest(){
        TypedQuery<Guest> query = em.createQuery(
            "SELECT g FROM Guest g ORDER BY g.id", Guest.class);
        return query.getResultList();
    }
}
