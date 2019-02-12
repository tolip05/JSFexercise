package regapp.domein.enteties.services;

import org.modelmapper.ModelMapper;
import regapp.domein.enteties.Employe;
import regapp.domein.enteties.repositoris.EmployeeRepository;
import regapp.domein.enteties.service.EmployeServiceModel;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class EmployServiceImpl implements EmployeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Inject
    public EmployServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean saveEmploye(EmployeServiceModel employeServiceModel) {

        try{
            this.employeeRepository.save(this.modelMapper
            .map(employeServiceModel,Employe.class));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<EmployeServiceModel> findAllEmployees() {

        List<EmployeServiceModel> models = this.employeeRepository.findAll()
                .stream()
                .map(e -> this.modelMapper.map(e, EmployeServiceModel.class))
                .collect(Collectors.toList());
        return models;

    }

    @Override
    public boolean removeEmploye(String id) {
        try{
            this.employeeRepository.remove(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
