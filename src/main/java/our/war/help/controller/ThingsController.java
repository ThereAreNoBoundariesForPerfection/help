package our.war.help.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api("controller witch show work swagger")
public class ThingsController {
    private final ThingRepository thingRepository;

    @Autowired
    public ThingsController(ThingRepository thingRepository) {
        this.thingRepository = thingRepository;
    }

    @PostMapping("/things")
    @ApiOperation("create new thing")
    public ResponseEntity<Void> newThing(@RequestBody Thing thing) {
        if (thingRepository.findByName(thing.getName()) == null) {
            thingRepository.save(thing);
            return ok().build();
        }
        throw new ThingAlreadyExistsException("The thing with this name already exists");
    }

    @PutMapping("/things/{id}")
    @ApiOperation("update thing by id")
    public ResponseEntity<Void> updateThing(@RequestBody Thing newThing, @PathVariable Long id) throws ThingNotFoundException {
        if (newThing != null) {
            Optional<Thing> currentThing = thingRepository.findById(id);
            if (currentThing.isPresent()) {

                currentThing.get().setName(newThing.getName());
                currentThing.get().setQuantity(newThing.getQuantity());
                currentThing.get().setNeedFunds(newThing.getNeedFunds());
                currentThing.get().setCollectedFunds(newThing.getCollectedFunds());
                currentThing.get().setDescription(newThing.getDescription());

                thingRepository.save(currentThing.get());
                return ok().build();
            }
        }
        throw new ThingNotFoundException("Thing with this " + id + " not found");
    }

    @GetMapping("/things/{id}")
    @ApiOperation("get one thing by id")
    public Thing getThingById(@PathVariable Long id) throws ThingNotFoundException {
        Optional<Thing> thing = thingRepository.findById(id);
        if (thing.isPresent()) {
            return thing.get();
        }
        throw new ThingNotFoundException("Thing with this " + id + " not found");
    }

    @DeleteMapping("/things/{id}")
    @ApiOperation("delete thing by id")
    public ResponseEntity<Void> deleteThingById(@PathVariable Long id) {
        thingRepository.deleteById(id);
        return ok().build();
    }

    @GetMapping("/things")
    @ApiOperation("get all things")
    public List<Thing> getAllThings() throws ThingNotFoundException {
        List<Thing> soldiers = thingRepository.findAll();
        if (!soldiers.isEmpty()) {
            return soldiers;
        }
        throw new ThingNotFoundException("Things not found");
    }
}
