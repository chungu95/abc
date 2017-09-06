import Model.Address;
import Model.Employee;
import Model.Req;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Req req = new Req();
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Chung");
        employee.setAge(22);
        List<Address> addresses = new ArrayList<Address>();
        for (int i = 0; i < 3; i++) {
            addresses.add(new Address("LVV", "9" + i));
        }
        employee.setAddresses(addresses);
        req.setEmployee(employee);
        try {
            File file = new File("D:\\file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Req.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            jaxbMarshaller.setProperty("com.sun.xml.bind.xmlHeaders",
                    "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.dhl.com ship-val-req_AP.xsd");
            jaxbMarshaller.marshal(req, file);
            jaxbMarshaller.marshal(req, System.out);
        } catch (JAXBException je) {
            je.printStackTrace();
        }
    }
}
