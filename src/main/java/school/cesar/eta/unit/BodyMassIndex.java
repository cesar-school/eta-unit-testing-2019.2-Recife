package school.cesar.eta.unit;

public class BodyMassIndex {

    public static String calculate(float bmi) {
        String category = "Severely Underweight";

        if (bmi >= 30) {
            category = "Obese";
        } else if (bmi >= 25f) {
            category = "Overweight";
        } else if (bmi >= 18.5f) {
            category = "Healthy Weight";
        } else if (bmi >= 16f) {
            category = "Underweight";
        }

        return category;
    }
}
