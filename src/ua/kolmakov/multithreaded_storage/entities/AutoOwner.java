package ua.kolmakov.multithreaded_storage.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 */

// 3. Разработать программу, предназначенную для обработки данных ГАИ о владельцах автотранспорта и зарегистрированных на них автомобилей.
// О владельцах автотранспорта хранится следующая информация: фамилия, имя, отчество, год рождения, серия и номер паспорта,
//дата выдачи и адрес прописки, номер и категория прав,- список правонарушений.
// Об автотранспорте хранится следующая информация: марка автомобиля и название модели, дата выпуска,
//дата прохождения последнего ТО,номерной знак, факт участия в ДТП.
// Организовать данные о паспорте и автотранспорте в виде отдельных структур,
//которые используются внутри структуры, описывающей автовладельца.
//Учесть возможность владения несколькими автомобилями. Возможные правонарушения организовать в виде перечисления.
//Краткая информация о ДТП, представленная битовыми полями,
//должна включать информацию о вине водителя, количестве пострадавших и количестве транспортных средств, пострадавших в ДТП.
//В программе создать хранить 10 автовладельцев. Программа должна предоставлять следующий набор функций:

//д) вывод информации о всех транспортных средствах (ФИО владельца в том числе);
//е) поиск информации о транспортных средствах, зарегистрированных на данного автовладельца (поиск осуществлять по фамилии);
//ж) поиск информации о владельце по части номерного знака;
//з) вывод информации о всех транспортных средствах, вовремя не прошедших ТО;
//и) вывод информации о всех автовладельцах, которые управляли транспортом в нетрезвом виде;
//к) вывод информации о всех транспортных средствах, участвовавших в ДТП.

@XmlRootElement(name = "autoowner")
public class AutoOwner {
    private Passport passport;
    private Licence licence;
    private List<Vehicle> vehicles;
    private List<Offence> offences;

    private AutoOwner() {
        vehicles = new ArrayList<>();
        offences = new ArrayList<>();
    }

    public static Builder newBuilder() {
        return new AutoOwner().new Builder();
    }

    public Passport getPassport() {
        return passport;
    }

    public Licence getLicence() {
        return licence;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public List<Offence> getOffences() {
        return offences;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void addOffence(Offence offence) {
        offences.add(offence);
    }

    //******************************************************************

    @XmlElement(name = "passport")
    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @XmlElement(name = "licence")
    public void setLicence(Licence licence) {
        this.licence = licence;
    }

    @XmlElementWrapper(name = "vehicles")
    @XmlElement(name = "vehicle")
    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @XmlElementWrapper(name = "offences")
    @XmlElement(name = "offence")
    public void setOffences(List<Offence> offences) {
        this.offences = offences;
    }

    public class Builder {
        private Builder() {
        }

        public Builder setPassport(Passport passport) {
            AutoOwner.this.passport = passport;
            return this;
        }

        public Builder setLicence(Licence licence) {
            AutoOwner.this.licence = licence;
            return this;
        }

        public AutoOwner build() {
            return AutoOwner.this;
        }
    }

    @Override
    public String toString() {
        return "\nAUTO_OWNER{" +
                "\npassport=" + passport +
                "\nlicence=" + licence +
                "\nvehicles=" + vehicles +
                "\noffences=" + offences +
                "}\n";
    }
}
