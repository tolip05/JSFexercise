package regapp.domein.web.mbeans;

import org.modelmapper.ModelMapper;
import regapp.domein.enteties.models.view.EmployeListViewModel;
import regapp.domein.enteties.services.EmployeService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class EmployeListBean {
    private List<EmployeListViewModel> employees;


    private EmployeService employeService;
    private ModelMapper modelMapper;

    public EmployeListBean() {

    }

    @Inject
    public EmployeListBean(EmployeService employeService, ModelMapper modelMapper) {
        this.employeService = employeService;
        this.modelMapper = modelMapper;
       this.employees = this.employeService.findAllEmployees()
                .stream()
                .map(employe -> this.modelMapper
                        .map(employe,EmployeListViewModel.class))
                .collect(Collectors.toList());

    }



    public List<EmployeListViewModel> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<EmployeListViewModel> employees) {
        this.employees = employees;
    }
}
