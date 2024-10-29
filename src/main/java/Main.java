import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Anna", 30, "anna@example.com", "Engineer"));
        persons.add(new Person("Bengt", 45, "bengt@example.com", "Teacher"));
        persons.add(new Person("Karin", 60, "karin@example.com", "Doctor"));
        persons.add(new Person("Klas", 3, "klas@example.com", "Child"));
        persons.add(new Person("Linnea", 25, "linnea@example.com", "Singer"));
        UserFilter userFilter = new UserFilter<>();

        for (Person person : persons) {
            printPersonInfo(person);
        }

        try {
            userFilter.userSearch(persons);
        } catch (IllegalAccessException e) {
            System.out.println("Filter doesn't work" + e.getMessage());
        }
        }



        public static void printPersonInfo(Person person) {
            System.out.println("-----------------------------------------------");
            for (Field field : person.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    if (field.isAnnotationPresent(SensitiveData.class)) {
                        System.out.println(field.getName() + ": ***");
                    } else {
                        System.out.println(field.getName() + ": " + field.get(person));
                    }
                } catch (IllegalAccessException e){
                    e.printStackTrace();
                }
            }
        }

    }
