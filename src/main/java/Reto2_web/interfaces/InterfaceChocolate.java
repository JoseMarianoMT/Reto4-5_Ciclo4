
package Reto2_web.interfaces;

import Reto2_web.modelo.Chocolate;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Jose Mariano
 */
public interface InterfaceChocolate extends MongoRepository<Chocolate, String>{
    public List<Chocolate> findByPrice(double price);
    public List<Chocolate> findByDescriptionContainingIgnoreCase(String description);
}
