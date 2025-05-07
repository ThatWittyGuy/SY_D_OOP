class NonEligibleException extends Exception {
    public NonEligibleException(String message) {
        super(message);
    }
}

class Citizen {
    private String name;
    private int id;
    private String country;
    private String sex;
    private String maritalStatus;
    private double annualIncome;
    private String economyStatus;
    private int age;

    public Citizen(String name, int id, String country, String sex, String maritalStatus, double annualIncome, String economyStatus, int age) {
        this.name = name;
        this.id = id;
        this.country = country;
        this.sex = sex;
        this.maritalStatus = maritalStatus;
        this.annualIncome = annualIncome;
        this.economyStatus = economyStatus;
        this.age = age;
    }

    public void checkEligibility() throws NonEligibleException {
        if (age < 18 && !country.equalsIgnoreCase("India")) {
            throw new NonEligibleException("Citizen is not eligible. Age below 18 and country is not India.");
        }
    }

    @Override
    public String toString() {
        return "Citizen [Name: " + name + ", ID: " + id + ", Country: " + country + ", Sex: " + sex + ", Marital Status: " + maritalStatus +
                ", Annual Income: " + annualIncome + ", Economy Status: " + economyStatus + ", Age: " + age + "]";
    }
}

public class CitizenTest {
    public static void main(String[] args) {
        Citizen citizen = new Citizen("John Doe", 12345, "USA", "Male", "Single", 50000.0, "Middle-Class", 17);

        try {
            citizen.checkEligibility();
            System.out.println(citizen.toString());
        } catch (NonEligibleException e) {
            System.out.println(e.getMessage());
        }
    }
}
