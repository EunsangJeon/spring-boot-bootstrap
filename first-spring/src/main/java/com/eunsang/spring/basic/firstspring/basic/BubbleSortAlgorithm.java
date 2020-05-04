package com.eunsang.spring.basic.firstspring.basic;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // #3
@Primary
public class BubbleSortAlgorithm implements SortAlgorithm {
    public int[] sort(int[] numbers) {
        // SORTING LOGIC
        return numbers;
    }
}
