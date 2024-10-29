import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        List<Person> persons = new ArrayList<>();

        public void printPersonInfo(Person person) {
            for (Field field : person.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    if (field.isAnnotationPresent(SensitiveData)) {
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
}
