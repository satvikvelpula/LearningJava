import java.util.*;

public class Person {

    private String name;
    private int age;
    private String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public void setName(String settable) {
        name = settable;
    }

    public void setAge(int settable) {
        age = settable;
    }

    public void setCity(String settable) {
        city = settable;
    }
}

// Create a List: Create a list of Person objects with various names, ages, and cities.
class Populate {

    private List<Person> personList;
    private List<String> names;
    private List<Integer> ages;
    private List<String> cities;
    private HashMap<Integer, Person> personMap;

    public Populate() {
        personList = new ArrayList<>();
        personMap = new HashMap<>();
        names = new ArrayList<>(Arrays.asList("Sofia", "Amir", "Lucia", "Hiro", "Amina", "Liam", "Isabella", "Mateo", "Nia", "Kai"));
        ages = new ArrayList<>(Arrays.asList(22, 35, 28, 40, 19, 31, 27, 24, 30, 26));
        cities = new ArrayList<>(Arrays.asList("New York", "New York", "Madrid", "New York", "Sydney", "Berlin", "New York", "Nairobi", "Seoul", "Mumbai"));
    }


    public void initialize(List<String> nameList, List<Integer> ageList, List<String> citiesList) {
        names = nameList;
        ages = ageList;
        cities = citiesList;
        int randIndex = (int) (Math.random() * names.size()); // taking reference from nameList, all update equally (count)
        String selected_name = names.get(randIndex);
        int selected_age = ages.get(randIndex);
        String selected_city = cities.get(randIndex);
        personList.add(new Person(selected_name, selected_age, selected_city));
        names.remove(randIndex);
        ages.remove(randIndex);
        cities.remove(randIndex);

    }

    public void assignVarNames(List<Person> personable) {
        int varName = 1;
        for (Person i : personList) {
            personMap.put(varName, i);
            varName++;
        }
    }

    public List<String> getNames() {
        return names;
    }

    public List<Integer> getAges() {
        return ages;
    }

    public List<String> getCities() {
        return cities;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public HashMap<Integer, Person> getMap() {
        return personMap;
    }


}

class Main {
    public static void main(String[] args) {

        ArrayList<Person> persons = new ArrayList<>();
        ArrayList<Person> sorted = new ArrayList<>();

        Populate populate_init = new Populate();

        for (int i = 1; i < 11; i++) {
            populate_init.initialize(populate_init.getNames(), populate_init.getAges(), populate_init.getCities());
        }
        populate_init.assignVarNames(populate_init.getPersonList());


        for (Map.Entry<Integer, Person> val : populate_init.getMap().entrySet()) {
            Person value = val.getValue();
            persons.add(value);
        }

        Comparator<Person> comparator = (p1, p2) -> {
            int compare_1 = p1.getAge();
            int compare_2 = p2.getAge();
            int compared = Integer.compare(compare_1, compare_2);
            return compared;
        };

        Collections.sort(persons, comparator);

        for (int i = persons.size() - 1; i >= 0; i--) {
            Person person_at_index = persons.get(i);


            Filterable<String> filterable = lambda_param -> {
                if (person_at_index.getCity().equals(lambda_param)) {return;}
                persons.remove(person_at_index);
            };

            filterable.removeIf("New York");
        }

        for (Person i : persons) {
            System.out.println(i.getName() + " " + i.getAge() + " " + i.getCity());
        }

    }
}
