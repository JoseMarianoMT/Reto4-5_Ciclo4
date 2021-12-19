
package Reto2_web.repositorio;


import Reto2_web.modelo.Chocolate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Reto2_web.interfaces.InterfaceChocolate;

/**
 * @Jose Mariano
 */
@Repository
public class ChocolateRepository {
    @Autowired
    private InterfaceChocolate repository;

    public List<Chocolate> getAll() {
        return repository.findAll();
    }

    public Optional<Chocolate> getClothe(String reference) {
        return repository.findById(reference);
    }

    
    public Chocolate create(Chocolate clothe) {
        return repository.save(clothe);
    }

    public void update(Chocolate clothe) {
        repository.save(clothe);
    }
    
    public void delete(Chocolate clothe) {
        repository.delete(clothe);
    }
    
    public List<Chocolate> fintByPrice(double price){
        return repository.findByPrice(price);
    } 
    
    public List<Chocolate> findByDescriptionContainingIgnoreCase(String description){
        return repository.findByDescriptionContainingIgnoreCase(description);
    } 
    
}
