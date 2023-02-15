package our.war.help.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import our.war.help.exception.ThingAlreadyExistsException;
import our.war.help.exception.ThingNotFoundException;
import our.war.help.model.Thing;
import our.war.help.repository.ThingRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api")
public class ThingsController {
    private final ThingRepository thingRepository;

    @Autowired
    public ThingsController(ThingRepository thingRepository) {
        this.thingRepository = thingRepository;
    }

    @PostMapping("/things")
    // @ApiOperation("create new thing")
    public ResponseEntity<Void> newThing(@RequestBody Thing thing) {
        if (thingRepository.findByName(thing.getName()) == null) {
            thingRepository.save(thing);
            return ok().build();
        }
        throw new ThingAlreadyExistsException("The thing with this name already exists");
    }

    @PutMapping("/things/{id}")
    //@ApiOperation("update thing by id")
    public ResponseEntity<Void> updateThing(@RequestBody Thing thing, @PathVariable Long id) throws ThingNotFoundException {
        if (thing != null) {
            Optional<Thing> anotherThing = thingRepository.findById(id);
            if (anotherThing.isPresent()) {

                anotherThing.get().setName(thing.getName());
                anotherThing.get().setQuantity(thing.getQuantity());
                anotherThing.get().setNeedFunds(thing.getNeedFunds());
                anotherThing.get().setCollectedFunds(thing.getCollectedFunds());
                anotherThing.get().setDescription(thing.getDescription());

                thingRepository.save(anotherThing.get());
                return ok().build();
            }
        }
        throw new ThingNotFoundException("Thing with this " + id + " not found");
    }

    @GetMapping("/things/{id}")
    //@ApiOperation("get one thing by id")
    public Thing getThingById(@PathVariable Long id) throws ThingNotFoundException {
        Optional<Thing> thing = thingRepository.findById(id);
        if (thing.isPresent()) {
            return thing.get();
        }
        throw new ThingNotFoundException("Thing with this " + id + " not found");
    }

    @DeleteMapping("/things/{id}")
    //@ApiOperation("delete thing by id")
    public ResponseEntity<Void> deleteThingById(@PathVariable Long id) {
        thingRepository.deleteById(id);
        return ok().build();
    }

    @GetMapping("/things")
    //@ApiOperation("get all things")
    public List<Thing> getAllThings() throws ThingNotFoundException {
        List<Thing> soldiers = thingRepository.findAll();
        if (!soldiers.isEmpty()) {
            return soldiers;
        }
        throw new ThingNotFoundException("Things not found");
    }
}
