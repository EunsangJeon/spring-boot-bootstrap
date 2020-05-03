package com.eunsang.spring.basic.firstspring;

public class BinarySearchImpl {

    // #2 To give little bit of lose coupling
    private SortAlgorithm sortAlgorithm;

    public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
        super();
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
