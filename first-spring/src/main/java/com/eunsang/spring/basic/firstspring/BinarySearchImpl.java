package com.eunsang.spring.basic.firstspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // #3
public class BinarySearchImpl {

    // #2 To give little bit of lose coupling
    //private SortAlgorithm sortAlgorithm;

    // #3 using Spring
    @Autowired
    private SortAlgorithm sortAlgorithm;
    // Technically, it is called "constructor injection".
    // There are other ways like "setter injection".
    public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
        super();
        System.out.println(sortAlgorithm); // to see which object has been passed as parameter
        this.sortAlgorithm = sortAlgorithm;
    }

    public int binarySearch(int[] numbers, int numberToSearchFor) {

        // #1 Let's say that sort logic is located here.
        // BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
        // int[] sortedNumber = bubbleSortAlgorithm.sort(numbers);
        // We can say that it is tightly coupled.

        // #2
        int[] sortedNumber = sortAlgorithm.sort(numbers);


        // SEARCH LOGIC HERE

        return 3;
    }
}
