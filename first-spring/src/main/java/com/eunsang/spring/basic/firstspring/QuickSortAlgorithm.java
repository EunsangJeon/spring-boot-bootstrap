package com.eunsang.spring.basic.firstspring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class QuickSortAlgorithm implements SortAlgorithm {
    public int[] sort(int[] numbers) {
        // SORTING LOGIC
        return numbers;
    }
}
