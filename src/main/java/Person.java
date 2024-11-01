public class Person {
    private String name;
    private int age;
    @SensitiveData
    private String email;
    private String role;

    public Person(String name, int age, String email, String role) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.role = role;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "------USER INFO--------\n" +
            "Name: " + name + "\n" +
            "Age: " + age + "\n" +
            "Email: " + email + "\n" +
            "Role: " + role + "\n" +
            "-----------------------";
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
