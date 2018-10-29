package tareaprogramada2.datos1.register;

public class HealthOffice {

    private Patient person;
    private ColorPatientCondition color;
    private boolean available;
    int id;
    int patientCounter;

    public HealthOffice(Patient person, ColorPatientCondition color, boolean available, int id, int patientCounter) {
        this.person = person;
        this.color = color;
        this.available = available;
        this.id = id;
        this.patientCounter = patientCounter;
    }

    public Patient getPerson() {
        return person;
    }

    public void setPerson(Patient person) {
        this.person = person;
    }

    public ColorPatientCondition getColor() {
        return color;
    }

    public void setColor(ColorPatientCondition color) {
        this.color = color;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientCounter() {
        return patientCounter;
    }

    public void setPatientCounter(int patientCounter) {
        this.patientCounter = patientCounter;
    }
    
    

}
