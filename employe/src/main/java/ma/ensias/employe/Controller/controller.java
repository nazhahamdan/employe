package ma.ensias.employe.Controller;


import ma.ensias.employe.response.EmployeResponse;
import ma.ensias.employe.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @Autowired
    private EmployeService employeService;

    @GetMapping("/employes/{id}")
    public EmployeResponse getEmploye(@PathVariable int id){
        return employeService.getEmployeById(id);
    }
}
