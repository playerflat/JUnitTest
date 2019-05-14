package software;

public class Mockito {
    public static void main(String[] args) {
        double temp = new Temp().Temp();
        double humidity = new Humidity().Humidity();
        String DI = new DiscomfortIndex().DiscomfortIndex(temp, humidity);

        System.out.println(DI);
    }
}
