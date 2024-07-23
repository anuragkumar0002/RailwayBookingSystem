public class User {
    private String name;
    private String mealPreference;
    private String berthPreference;

    public User(String name, String mealPreference, String berthPreference) {
        this.name = name;
        this.mealPreference = mealPreference;
        this.berthPreference = berthPreference;
    }

    public String getName() {
        return name;
    }

    public String getMealPreference() {
        return mealPreference;
    }

    public String getBerthPreference() {
        return berthPreference;
    }
}
