package pl.javastart.controller.web;
import java.util.HashMap;
import java.util.Map;


import org.springframework.stereotype.Service;


import pl.javastart.model.Pupil;

@Service
public class UserValidation
{
    public Map<String, String> validateUser(Pupil pupilModel) 
    {
    	
    Map<String, String> errorsMap = new HashMap<>();
    
    if (pupilModel.getFirstName()=="" ||
            !pupilModel.getFirstName().trim().matches("^[A-Z][a-z]{2,}$")) 
    {
        errorsMap.put("firstNameValRes", "Wymagane przynajmniej 3 znaki(pierwsza duża reszta z małej litery)");
    }
    
    
    if (pupilModel.getLastName()=="" ||
            !pupilModel.getLastName().trim().matches("^[A-Z][a-z]{2,}(-[A-Z][a-z]{2,})?$")) 
    {
        errorsMap.put("lastNameValRes", "Wymagane przynajmniej 3 znaki(pierwsza duża reszta z małej litery)");
    }
    
		return errorsMap;
    }
}

