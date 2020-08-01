package school.cesar.eta.unit;

public class BodyMassIndex {

    public static double calculate(double weight, double height){
        return weight / Math.pow(height, 2);
    }

    public static String classify(double bmi) {
        String category = "Severely Underweight";

        if (bmi >= 30) {
            category = "Obese";
        } else if (bmi >= 25) {
            category = "Overweight";
        } else if (bmi >= 18.5) {
            category = "Healthy Weight";
        } else if (bmi >= 16) {
            category = "Underweight";
        }

        return category;
    }

    public static String classify(double weight, double height) {
        double bmi = calculate(weight, height);
        return classify(bmi);
    }
}
