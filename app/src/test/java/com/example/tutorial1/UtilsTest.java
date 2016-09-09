package com.example.tutorial1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {


    @Test
    public void shouldReturnSortedList() throws Exception {
        Utils utils = new Utils();
        List<Integer> sortedList = utils.sortNumbersDescending(getFakeList());

        assertThat(sortedList.get(0)).isEqualTo(4);
        assertThat(sortedList.get(1)).isEqualTo(3);
        assertThat(sortedList.get(2)).isEqualTo(2);
        assertThat(sortedList.get(3)).isEqualTo(1);
        assertThat(sortedList.get(4)).isEqualTo(0);
    }

    public List<Integer> getFakeList() {
        List<Integer> fakeList = new ArrayList<>();
        fakeList.add(2);
        fakeList.add(1);
        fakeList.add(0);
        fakeList.add(4);
        fakeList.add(3);
        return fakeList;
    }
}