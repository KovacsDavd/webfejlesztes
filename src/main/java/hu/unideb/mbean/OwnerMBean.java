package hu.unideb.mbean;

import hu.unideb.entity.Owner;
import hu.unideb.service.OwnerService;
import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class OwnerMBean implements Serializable {

    @Inject
    private OwnerService ownerService;

    private List<Owner> ownerList;

    private Owner selectedOwner = new Owner();

    private void load() {
        ownerList = ownerService.getAll();
    }

    @PostConstruct
    private void init() {
        load();
    }

    public void initNewOwner() {
        this.selectedOwner = new Owner();
    }

    public void remove() {
        ownerService.remove(selectedOwner);
        initNewOwner();
        load();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Successful remove"));
    }

    public void save() {
        if (selectedOwner.getId() == null) {
            ownerService.add(selectedOwner);
        } else {
            ownerService.update(selectedOwner);
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Successful save"));
        load();
        PrimeFaces.current().executeScript("PF('ownerDialog').hide()");
    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<Owner> ownerList) {
        this.ownerList = ownerList;
    }

    public Owner getSelectedOwner() {
        return selectedOwner;
    }

    public void setSelectedOwner(Owner selectedOwner) {
        this.selectedOwner = selectedOwner;
    }
}
