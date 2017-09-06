package Model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "req:ShipmentRequest")
public class Req {
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
