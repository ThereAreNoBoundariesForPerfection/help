package our.war.help.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import our.war.help.exception.SoldierAlreadyExistsException;
import our.war.help.exception.SoldierNotFoundException;
import our.war.help.model.Soldier;
import our.war.help.repository.SoldierRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api")
public class SoldiersController {
    private final SoldierRepository soldierRepository;

    @Autowired
    public SoldiersController(SoldierRepository soldierRepository) {
        this.soldierRepository = soldierRepository;
    }

    @PostMapping("/soldiers")
    // @ApiOperation("create new soldier")
    public ResponseEntity<Void> newSoldier(@RequestBody Soldier soldier) {
        if (soldierRepository.findByEmail(soldier.getEmail()) == null) {
            soldierRepository.save(soldier);
            return ok().build();
        }
        throw new SoldierAlreadyExistsException("The soldier with this email already exists");
    }

    @PutMapping("/soldiers/{id}")
    //@ApiOperation("update soldier by id")
    public ResponseEntity<Void> updateSoldier(@RequestBody Soldier soldier, @PathVariable Long id) throws SoldierNotFoundException {
        if (soldier != null) {
            Optional<Soldier> anotherSoldier = soldierRepository.findById(id);
            if (anotherSoldier.isPresent()) {

                anotherSoldier.get().setFirstName(soldier.getFirstName());
                anotherSoldier.get().setLastName(soldier.getLastName());
                anotherSoldier.get().setPhone(soldier.getPhone());
                anotherSoldier.get().setEmail(soldier.getEmail());
                anotherSoldier.get().setNeedFunds(soldier.getNeedFunds());
                anotherSoldier.get().setCollectedFunds(soldier.getCollectedFunds());
                anotherSoldier.get().setDescriptionDamageHealth(soldier.getDescriptionDamageHealth());

                soldierRepository.save(anotherSoldier.get());
                return ok().build();
            }
        }
        throw new SoldierNotFoundException("Soldier with this " + id + " not found");
    }

    @GetMapping("/soldiers/{id}")
    //@ApiOperation("get one soldier by id")
    public Soldier getSoldierById(@PathVariable Long id) throws SoldierNotFoundException {
        Optional<Soldier> soldier = soldierRepository.findById(id);
        if (soldier.isPresent()) {
            return soldier.get();
        }
        throw new SoldierNotFoundException("Soldier with this " + id + " not found");
    }

    @DeleteMapping("/tasks/{id}")
    //@ApiOperation("delete soldier by id")
    public ResponseEntity<Void> deleteSoldierById(@PathVariable Long id) {
        soldierRepository.deleteById(id);
        return ok().build();
    }

    @GetMapping("/soldiers")
    //@ApiOperation("get all soldiers")
    public List<Soldier> getAllSoldiers() throws SoldierNotFoundException {
        List<Soldier> soldiers = soldierRepository.findAll();
        if (!soldiers.isEmpty()) {
            return soldiers;
        }
        throw new SoldierNotFoundException("Soldiers not found");
    }
}
