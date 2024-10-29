import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class UserFilter<T> extends Person {

    public <T> void userSearch (List<T> list) throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type search word: ");
        String args = scanner.nextLine();

        if (list == null){
            System.out.println("The list is empty.");
            return;
        }

        ParameterizedType objectInList = (ParameterizedType) list;
        Class<T> classOfObjectInList = (Class<T>) objectInList.getActualTypeArguments()[0];

        for (Object object : list) {
            Class clazz = object.getClass();

            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields){
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
            if (field.getClass().isAnnotationPresent(SensitiveData.class) ){
                System.out.println(field.getName() + ": ****");
            } else {
                System.out.println(field.getName() + ": " + field.get(object).toString());
            }
        }
    }

}
