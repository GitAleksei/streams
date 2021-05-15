package streams.task2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> surnames = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies",
                "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    surnames.get(new Random().nextInt(surnames.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)]
            ));
        }

        long countMinor = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();

        List<String> conscriptList = persons.stream()
                .filter(x -> x.getSex() == Sex.MAN)
                .filter(x -> (x.getAge() >= 18) && (x.getAge() <= 27))
                .map(Person::getSurname)
                .collect(Collectors.toList());

        List<Person> workablePersons = persons.stream()
                .filter(x -> x.getAge() >= 18)
                .filter(x -> ((x.getSex() == Sex.MAN) && (x.getAge() <= 65))
                        || ((x.getSex() == Sex.WOMAN) && (x.getAge() <= 60)))
                .sorted(Comparator.comparing(Person::getSurname))
                .collect(Collectors.toList());
    }
}
