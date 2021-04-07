package homeworkLesson5;

public class Employee {
    private static int employeesCount;

    String fullName;
    String position;
    String email;
    String phone;
    private int salary;
    int age;

    public static int getEmployeesCount(){
        return employeesCount;
    }

    public static void incEmployeesCount(){
        employeesCount++;
    }


    public Employee(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
        incEmployeesCount();
    }

    public void printInfo(){
        System.out.println(this);

    }

    @Override
    public String toString() {
        return "Full name: " + fullName + "   Position: " + position + "  Email: " + email + "  Phone: " + phone + "\n Salary: " + salary + " RUB   Age: " + age + "\n";
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
