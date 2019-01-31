package pl.javastart.controller.rest;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.javastart.model.Mark;
import pl.javastart.repository.MarkRepository;

@RestController
@RequestMapping("/api/cities")
public class MarkControllerRest {

    private MarkRepository markRepo;

    @Autowired
    public MarkControllerRest(MarkRepository markRepo) {
        this.markRepo = markRepo;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Mark> getMarks(@RequestParam(defaultValue="name") String orderBy) {
    	int id=2;
//        List<Object[]> marks = markRepo.findMark("janpedz");
//        if("name".equals(orderBy)) {
//        	marks.sort(Comparator.comparing(Mark::get));
//        } else if("population".equals(orderBy)) {
//            cities.sort(Comparator.comparing(City::getPopulation));
//        }
        return null;
    }
//
//    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<City> getCity(@PathVariable Long id) {
//        return cityRepo.findById(id)
//        		.map(ResponseEntity::ok)
//        		.orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void saveCity(@RequestBody City city) {
//        cityRepo.save(city);
//    }
}