package software;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class MainTest {

    /*  온도 습도 불쾌지수
     *   36  80  매우불쾌
     *   32  65    불쾌
     *   28  50    보통
     *    else     좋음
     */
    @Test
    public void testMain() {
        DiscomfortIndex di = spy(DiscomfortIndex.class);

        verify(di, times(1)).Temp();
        verify(di, never()).Temp();
        verify(di, atLeastOnce()).Temp();
        verify(di, atMost(2)).Temp();
        verify(di, atLeast(2)).Temp();
        verify(di, timeout(100)).Temp();
    }
}