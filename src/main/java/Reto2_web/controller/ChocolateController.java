
package Reto2_web.controller;

import Reto2_web.modelo.Chocolate;
import Reto2_web.servicios.ChocolateService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jose Mariano
 */
@RestController
@RequestMapping("/api/chocolate")
@CrossOrigin("*")
public class ChocolateController {
    @Autowired
    private ChocolateService chocolateService;

    @GetMapping("/all")
    public List<Chocolate> getAll() {
        return chocolateService.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<Chocolate> getClothe(@PathVariable("reference") String reference) {
        return chocolateService.getClothe(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Chocolate create(@RequestBody Chocolate gadget) {
        return chocolateService.create(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Chocolate update(@RequestBody Chocolate gadget) {
        return chocolateService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return chocolateService.delete(reference);
    }
    
    @GetMapping("/price/{price}")
    public List<Chocolate> fintByPrice(@PathVariable("price") double price){
       return chocolateService.fintByPrice(price);   
    }

     @GetMapping("/description/{description}")
    public List<Chocolate> findByDescriptionContainingIgnoreCase(@PathVariable("description") String description){
       return chocolateService.findByDescriptionContainingIgnoreCase(description);   
    }
    
}
