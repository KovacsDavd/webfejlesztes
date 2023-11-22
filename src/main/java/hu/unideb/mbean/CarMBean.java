package hu.unideb.mbean;

import hu.unideb.entity.Car;
import hu.unideb.entity.Owner;
import hu.unideb.service.CarService;
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
public class CarMBean implements Serializable {

    @Inject
    private CarService carService;

    @Inject
    private OwnerService ownerService;

    private Long ownerID;

    private List<Car> carList;

    private List<Owner> ownerList;

    private Car selectedCar = new Car();

    private void load() {
        ownerList = ownerService.getAll();
        carList = carService.getAll();
    }

    @PostConstruct
    private void init() {
        load();
    }

    public void initNewCar() {
        this.selectedCar = new Car();
        this.ownerID = null;
    }

    public void remove() {
        carService.remove(selectedCar);
        initNewCar();
        load();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Successful remove"));
    }

    public void save() {
        if (ownerID != null) {
            selectedCar.setOwner(ownerService.findById(ownerID));
        }
        if (selectedCar.getId() == null) {
            carService.add(selectedCar);
        } else {
            carService.update(selectedCar);
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Successful save"));
        load();
        PrimeFaces.current().executeScript("PF('carDialog').hide()");
    }

    public Long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(Long ownerID) {
        this.ownerID = ownerID;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<Owner> ownerList) {
        this.ownerList = ownerList;
    }

    public Car getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;

        if (selectedCar.getOwner() != null) {
            ownerID = selectedCar.getOwner().getId();
        } else {
            ownerID = null;
        }
    }
}
