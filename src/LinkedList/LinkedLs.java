package LinkedList;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LinkedLs {
    public static void main(String[] args){
        List<String> arls = Arrays.asList("one", "two", "three", "four","as","ret","tyjht","rtyhjt");
        arls.stream().filter(e -> e.length() > 3).peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase).peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        List<String> lnk = new LinkedList<>();
        lnk.add("tom");
        lnk.add("ewr");
        lnk.add("er3r");
       // lnk.get(7);
        LinkedList<String> lnkd = new LinkedList<>(lnk);
        System.out.println("peek: "+lnkd.peek());
        System.out.println("peekfirst: " +lnkd.peekFirst());
        lnkd.remove(1);
        System.out.println("peek: "+lnkd.peek());
        System.out.println("peekfirst: " +lnkd.peekFirst());
        System.out.println(lnkd.get(1));
        int[] arr = {1,2,3};

        int indx = Collections.binarySearch(arls, "THREE");
        System.out.println(indx);

    }


}
