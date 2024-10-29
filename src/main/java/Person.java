public class Person {
    private String name;
    private int age;
    private String email;
    private String role;

    @Override
    public String toString() {
        return "------USER INFO--------\n" +
            "Name: " + name + "\n" +
            "Age: " + age + "\n" +
            "Email: " + email + "\n" +
            "Role: " + role + "\n" +
            "-----------------------";
    }
}
