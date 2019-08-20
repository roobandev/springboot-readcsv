package net.rooban;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") int id) throws Exception {
        Service rService = new Service();
        //rService.readFileOneByOne();
        Entity entity = rService.readFileAll(id);
        return new ResponseEntity<Entity>(entity, HttpStatus.OK);
    }
}
