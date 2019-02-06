//  package pl.javastart.controller.rest;
//
//import java.util.Comparator;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import pl.javastart.model.Pupil;
//import pl.javastart.repository.PupilRepository;
//
//
//@RestController
//@RequestMapping("/api/registerKeyController")
//public class RegisterKeyControllerRest 
//{
//
//    private PupilRepository pupilRepo;
//
//    @Autowired
//    public RegisterKeyControllerRest(PupilRepository pupilRepo) 
//    {
//        this.pupilRepo = pupilRepo;
//    }
//
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Pupil> getCities(@RequestParam(defaultValue="name") String orderBy)
//    {
//        List<Pupil> cities = pupilRepo.findAll();
//        
//        if("name".equals(orderBy))
//        {
//          cities.sort(Comparator.comparing(Pupil::getFirstName));
//        } 
//        
//        else if("population".equals(orderBy)) 	
//        {
//            cities.sort(Comparator.comparing(Pupil::getPesel));
//        }
//        return cities;
//    }
//
//    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Pupil> getPupil(@PathVariable Long id) 
//    {
//        return pupilRepo.findById(id)
//        		.map(ResponseEntity::ok)
//        		.orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void savePupil(@RequestBody Pupil pupil) 
//    {
//        pupilRepo.save(pupil);
//    }
//}