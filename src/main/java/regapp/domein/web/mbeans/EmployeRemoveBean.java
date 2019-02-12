package regapp.domein.web.mbeans;

import regapp.domein.enteties.services.EmployeService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class EmployeRemoveBean {
    private EmployeService employeService;

    public EmployeRemoveBean() {
    }

    @Inject
    public EmployeRemoveBean(EmployeService employeService) {
        this.employeService = employeService;
    }

    public void remove(String id) throws IOException {

        this.employeService.removeEmploye(id);
        ExternalContext context = FacesContext.getCurrentInstance()
                .getExternalContext();
        context.redirect("/");
    }
}
