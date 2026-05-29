package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.AtLeast;
import org.mockito.internal.verification.AtMost;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class OneShotTest {
    @Test
    void name() {
        List<Integer> integers = List.of(1, 2, 3);

        Assertions.assertThat(integers).contains(1);
        Assertions.assertThat(integers).contains(2);
        Assertions.assertThat(integers).contains(3);
        Assertions.assertThat(integers).doesNotContain(4);
    }

    @Test
    void mockTest() {
        ArrayList mock = mock(ArrayList.class);
        System.out.println(mock.get(0));
    }

    @Test
    void stubTest() {
        ArrayList mock = mock(ArrayList.class);
        doReturn(10000).when(mock).size();
        Assertions.assertThat(mock.size()).isEqualTo(10000);
    }

    @Test
    void testAtLeastAndAtMost() {
        ArrayList mock = mock(ArrayList.class);

        for (int i = 0; i < 4; i++) {
            mock.size();
        }


        verify(mock, new AtLeast(2)).size();
        verify(mock, new AtMost(5)).size();

        for (int i = 0; i < 3; i++) {
            mock.add("hi");
        }
        verify(mock, new AtLeast(2)).add("hi");
        verify(mock, new AtMost(4)).add("hi");
    }

    @Test
    void testArgumentMatcher() {
        ArrayList mock = mock(ArrayList.class);

        for (int i = 0; i < 4; i++) {
            mock.size();
        }

        verify(mock, new AtLeast(2)).size();
        verify(mock, new AtMost(5)).size();
    }
}
