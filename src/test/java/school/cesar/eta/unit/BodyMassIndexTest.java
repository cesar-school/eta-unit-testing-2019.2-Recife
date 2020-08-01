package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.cesar.eta.unit.utils.BodyMassIndexMock;

public class BodyMassIndexTest {

    private BodyMassIndex bmi;

    @BeforeEach
    public void setupTest() {
        bmi = new BodyMassIndex();
    }

    @Test
    public void classify_bmiUnder16_severelyUnderweight() {
        String actual = bmi.classify(15.9f);
        Assertions.assertEquals("Severely Underweight", actual);
    }

    @Test
    public void classify_bmi16_underweight() {
        String actual = bmi.classify(16f);
        Assertions.assertEquals("Underweight", actual);
    }

    @Test
    public void classify_18Dot5_healthyWeight() {
        String actual = bmi.classify(18.5f);
        Assertions.assertEquals("Healthy Weight", actual);
    }

    @Test
    public void classify_bmi25_overweight() {
        Assertions.assertEquals("Overweight", bmi.classify(25));
    }

    @Test
    public void classify_bmi30_obese() {
        Assertions.assertEquals("Obese", bmi.classify(30));
    }

    @Test
    public void calculate_weight80AndHeight2_20() {
        Assertions.assertEquals(20, bmi.calculate(80, 2));
    }

    @Test
    public void classify_mockedMethods_none() {
        bmi = new BodyMassIndex() {
            @Override
            public double calculate(double weight, double height) {
                return -1;
            }

            @Override
            public String classify(double bmi) {
                return "none";
            }
        };

        Assertions.assertEquals("none", bmi.classify(-2, -3));
    }

    @Test
    public void classify_spyCalculateMethodsParam() {
        final double[] actualWeight = new double[1];
        final double[] actualHeight = new double[1];

        bmi = new BodyMassIndex() {
            @Override
            public double calculate(double weight, double height) {
                actualWeight[0] = weight;
                actualHeight[0] = height;
                return 20;
            }

            @Override
            public String classify(double bmi) {
                return super.classify(bmi);
            }
        };

        bmi.classify(10, 20);

        Assertions.assertEquals(10, actualWeight[0]);
        Assertions.assertEquals(20, actualHeight[0]);
    }

    @Test
    public void classify_spyClassifyMethodParams() {
        bmi = new BodyMassIndexMock();

        bmi.classify(10, 2);
        Assertions.assertEquals(50, ((BodyMassIndexMock) bmi).bmiValue);
    }
}
