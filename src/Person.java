public class Person {
    String firstName;
    String lastName;
    String middleName;
    String country;
    String address;
    String phone;
    int age;
    String gender;

    public Person firstName (String firstName){
        this.firstName = firstName;
        return this;
    }
    public Person lastName(String lastName){
        this.lastName = lastName;
        return this;
    }
    public Person middleName(String middleName){
        this.middleName = middleName;
        return this;
    }
    public Person country(String country){
        this.country = country;
        return this;
    }
    public Person address(String address){
        this.address = address;
        return this;
    }
    public Person phone(String phone){
        this.phone = phone;
        return this;
    }
    public Person age(int age){
        this.age = age;
        return this;
    }
    public Person gender(String gender){
        this.gender = gender;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);
        person.firstName("ololo").middleName("pisch-pisch").lastName("Udaff");
        System.out.println(person);
    }
}
