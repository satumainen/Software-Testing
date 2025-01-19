package assig2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.calls;


@ExtendWith(MockitoExtension.class)
class MockitoTests {

    @Mock
    Exemption exemptionMock; //mock made here

    @InjectMocks
    TaxCalculator2 calculator; //mock injected here


    /*
    Four children with ages 10,12,18,20 - mock called twice
     */
    @Test
    public void MockCalledTwice() {
        when(exemptionMock.getExemptionValue(1)).thenReturn(1.0); //when childrenNo 1
        when(exemptionMock.getExemptionValue(2)).thenReturn(2.0); //when childrenNo 2

        double[] income = {40000};
        int[] ages = {10, 12, 18, 20}; //two minor children
        double expectedOutput = 7997.0; //40 000 * 0.2 - 1 - 2 = 8 000 - 3 = 7997
        double actual = calculator.computeTax(income, ages);

        assertEquals(expectedOutput, actual); //assertion

        InOrder inOrder = inOrder(exemptionMock);

        inOrder.verify(exemptionMock, calls(1)).getExemptionValue(1);
        inOrder.verify(exemptionMock, calls(1)).getExemptionValue(2);
        inOrder.verifyNoMoreInteractions();

        verify(exemptionMock, times(2)).getExemptionValue(anyInt());

    }

    /*
    Five children with ages 7,11,14,15,19 - mock called four times
     */
    @Test
    public void MockCalled4Times() {
        when(exemptionMock.getExemptionValue(1)).thenReturn(1.0); //when childrenNo 1
        when(exemptionMock.getExemptionValue(2)).thenReturn(2.0);
        when(exemptionMock.getExemptionValue(3)).thenReturn(3.0);
        when(exemptionMock.getExemptionValue(4)).thenReturn(4.0);

        double[] income = {40000};
        int[] ages = {7,11,14,15,19};
        double expectedOutput = 7990.0;
        double actual = calculator.computeTax(income, ages);

        assertEquals(expectedOutput, actual); //assertion

        InOrder inOrder = inOrder(exemptionMock);

        inOrder.verify(exemptionMock, calls(1)).getExemptionValue(1);
        inOrder.verify(exemptionMock, calls(1)).getExemptionValue(2);
        inOrder.verify(exemptionMock, calls(1)).getExemptionValue(3);
        inOrder.verify(exemptionMock, calls(1)).getExemptionValue(4);
        inOrder.verifyNoMoreInteractions();

        verify(exemptionMock, times(4)).getExemptionValue(anyInt());

    }
    /*
    Three children ages 19,22,24 - mock never called
     */
    @Test
    public void ExemptionValueNeverCalled() {
        double[] income = {40000};
        int[] ages = {19,22,24};
        double expectedOutput = 8000;
        double actual = calculator.computeTax(income, ages);

        assertEquals(expectedOutput, actual); //assertion

        verify(exemptionMock, never()).getExemptionValue(anyInt());

    }

}



