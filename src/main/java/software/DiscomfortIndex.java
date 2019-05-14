package software;

public class DiscomfortIndex {
    public String DiscomfortIndex(double temp, double humidity){
        if (temp>=36.0f && humidity>=80.0f){
            return "매우 불쾌";
        } else if (temp>=32.0f && humidity>=65.0f){
            return "불쾌";
        } else if (temp>=28.0f && humidity>=50.0f){
            return "보통";
        } else{
            return "좋음";
        }
    }
}
