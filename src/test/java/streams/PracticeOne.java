package streams;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeOne {

    @Test
    public void countNames() {
        // count no of name in list starting with 'A' alphabet
        ArrayList<String> names = new ArrayList<String>();
        names.add("Apple");
        names.add("Pineapple");
        names.add("Candy");
        names.add("Banana");
        names.add("AA");

        Long c = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);

        System.out.println(Stream.of("Shaurya","Suresh","Nirmala","Veera","Tejal","Samu").filter(s -> s.startsWith("S")).count());
        Stream<String> list = Stream.of("Shaurya","Suresh","Nirmala","Veera","Tejal","Samu");
        //list.filter(s -> s.length()>2).forEach(System.out::println);
        //list.forEach(System.out::println);
        list.limit(1).forEach(System.out::println);

    }

    @Test
    public void mapMethod() {
        // print names in capital which has length > 4
        Stream<String> list1 = Stream.of("Shaurya","Suresh","Nirmala","Veera","Teja","Samu");
        list1.filter(s -> s.length()>4).map(String::toUpperCase).forEach(System.out::println);
    }

    @Test
    public void sortMethod() {
        // print names ends with 'a' in sorted order
        Stream<String> list1 = Stream.of("Shaurya","Suresh","Nirmala","Veera","Teja","Samu");
        list1.filter(s -> s.endsWith("a")).sorted().map(String::toUpperCase).forEach(System.out::println);
    }

    @Test
    public void mergeArrayListMethod() {
        // merge 2 stream list and sort
        Stream<String> list2 = Stream.of("Shaurya","Suresh","Nirmala","Veera","Teja","Samu");
        Stream<String> list3 = Stream.of("Pune","Mumbai","Nagar","Nashik");
        Stream<String> newlist = Stream.concat(list2,list3);
        newlist.sorted().forEach(System.out::println);
    }

    @Test
    public void streamCollectMethod() {
        // collect to new list
        List<String> list =Stream.of("Shaurya","Suresh","Nirmala","Veera","Teja","Samu")
                .filter(s -> s.length()>4).map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(list.get(0));
    }

    @Test
    public void streamUniqSorrMethod() {
        List<Integer> integers = Arrays.asList(5,3,6,8,9,3,5,1,3,7,4,2);
        //print unique number
        //sort the array
        List<Integer> newint = integers.stream().distinct().sorted().collect(Collectors.toList());
        newint.forEach(System.out::println);
    }

}
