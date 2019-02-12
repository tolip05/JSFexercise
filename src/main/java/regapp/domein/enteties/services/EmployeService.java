package regapp.domein.enteties.services;

import regapp.domein.enteties.service.EmployeServiceModel;

import java.util.List;

public interface EmployeService {

    boolean saveEmploye(EmployeServiceModel employeServiceModel);
    List<EmployeServiceModel>findAllEmployees();

    boolean removeEmploye(String id);
}
