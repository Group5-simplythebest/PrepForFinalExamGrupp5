import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UserFilter<T> extends Person {

    public UserFilter() {
        super();
    }

    public <T> void userSearch (List<T> list) throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("--------------------------------\nSEARCH PERSON LIST\nType search word: ");
        String args = scanner.nextLine();

        if (list == null){
            System.out.println("The list is empty.");
            return;
        }


        for (Object object : list) {
            Class clazz = object.getClass();

            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields){
                field.setAccessible(true);
                if (field.get(object).toString().equalsIgnoreCase(args)){
                    System.out.println("This " + clazz.getSimpleName() + " has matches the search word:");
                    printAnything(object);
                }
            }
        }
        System.out.println("Search ended.");

    }

    public  void printAnything(Object object) throws IllegalAccessException {
        Class clazz = object.getClass();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields){
            field.setAccessible(true);
            if (field.isAnnotationPresent(SensitiveData.class) ){
                System.out.println(field.getName() + ": ****");
            } else {
                System.out.println(field.getName() + ": " + field.get(object).toString());
            }
        }
    }

    public static Person search(List<Person> list, String name) {
        Person temp;
        temp = list.stream().filter(person -> person.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
        if (temp == null) {
            System.out.println("Search failed no one by that name exists in the list");
            return null;
        }
        return temp;
    }

    public static List<Person> sortByAge(List<Person> list) {
        list.sort(Comparator.comparing(Person::getAge));
        return list;
    }
}
