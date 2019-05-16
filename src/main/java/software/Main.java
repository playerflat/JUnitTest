package software;

public class Main {
    public static void main(String[] args) {
        DiscomfortIndex discomfortIndex = new DiscomfortIndex();
        double temp = discomfortIndex.Temp();
        double humidity = discomfortIndex.Humidity();

        String DI = discomfortIndex.DiscomfortIndex(temp, humidity);
        System.out.println(DI);
    }
}
