package ma.ensias.employe.service;

import lombok.AllArgsConstructor;
import ma.ensias.employe.entities.Employe;
import ma.ensias.employe.repository.EmployeRepository;
import ma.ensias.employe.response.EmployeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeService {
    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    ModelMapper modelMapper;
    public EmployeResponse getEmployeById(int id) {
        Optional<Employe> optional = employeRepository.findById(id);

        if (optional.isPresent()) {
            Employe employe = optional.get();
            return modelMapper.map(employe, EmployeResponse.class);
        } else {
            throw new RuntimeException("Employé introuvable : " + id);
        }
    }
}
