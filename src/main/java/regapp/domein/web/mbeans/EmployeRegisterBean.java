package regapp.domein.web.mbeans;

import org.modelmapper.ModelMapper;
import regapp.domein.enteties.models.EmployeRegisterBindingModel;
import regapp.domein.enteties.service.EmployeServiceModel;
import regapp.domein.enteties.services.EmployeService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
@Named
@RequestScoped
public class EmployeRegisterBean {
private EmployeRegisterBindingModel employeRegisterBindingModel;
private EmployeService employeService;
private ModelMapper modelMapper;

    public EmployeRegisterBean() {
        this.employeRegisterBindingModel = new EmployeRegisterBindingModel();
    }

    @Inject
    public EmployeRegisterBean(EmployeService employeService, ModelMapper modelMapper) {
        this();
        this.employeService = employeService;
        this.modelMapper = modelMapper;
    }

    public EmployeRegisterBindingModel getEmployeRegisterBindingModel() {
        return this.employeRegisterBindingModel;
    }

    public void setEmployeRegisterBindingModel(EmployeRegisterBindingModel employeRegisterBindingModel) {
        this.employeRegisterBindingModel = employeRegisterBindingModel;
    }
    public void register() throws IOException {
        this.employeService.saveEmploye(this.modelMapper
                .map(this.employeRegisterBindingModel, EmployeServiceModel.class));

        ExternalContext context = FacesContext.getCurrentInstance()
                .getExternalContext();
        context.redirect("/");
    }
}
