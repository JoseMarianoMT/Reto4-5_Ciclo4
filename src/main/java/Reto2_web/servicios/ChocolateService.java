
package Reto2_web.servicios;

import Reto2_web.modelo.Chocolate;
import Reto2_web.repositorio.ChocolateRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 *
 * @author Jose Mariano
 */
@Service
public class ChocolateService {

    @Autowired
    private ChocolateRepository clotheRepository;

    public List<Chocolate> getAll() {
        return clotheRepository.getAll();
    }

    public Optional<Chocolate> getClothe(String reference) {
        return clotheRepository.getClothe(reference);
    }

    public Chocolate create(Chocolate accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return clotheRepository.create(accesory);
        }
    }

    public Chocolate update(Chocolate accesory) {

        if (accesory.getReference() != null) {
            Optional<Chocolate> accesoryDb = clotheRepository.getClothe(accesory.getReference());
            if (!accesoryDb.isEmpty()) {
                
                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }
                
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                clotheRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(accesory -> {
            clotheRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
     public List<Chocolate> fintByPrice(double price){
        return clotheRepository.fintByPrice(price);
    }   
     
    public List<Chocolate> findByDescriptionContainingIgnoreCase(String description){
        return clotheRepository.findByDescriptionContainingIgnoreCase(description);
    }   

}


