package pl.coderslab.DatabaseNF.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String serviceName;
    @NotBlank
    private String serviceCategory;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceCategory() {
        return serviceCategory;
    }
    public void setServiceCategory(String serviceCategory) {
        this.serviceCategory = serviceCategory;
    }


    @Override
    public String toString() {
        return "Usługa: " +
                "id: '" + id + '\'' +
                ", nazwa usługi: '" + serviceName + '\'' +
                ", kategoria usługi: '" + serviceCategory + '\'';
    }
}
