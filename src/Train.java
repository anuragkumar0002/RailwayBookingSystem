import java.util.ArrayList;
import java.util.List;

public class Train {
    private int trainNumber;
    private List<Coach> coaches;

    public Train(int trainNumber) {
        this.trainNumber = trainNumber;
        this.coaches = new ArrayList<>();

        // Fill coaches in sequence 1, 3, 5, 7, 9, 10, 2, 4, 6, 8
        int[] coachSequence = {1, 3, 5, 7, 9, 10, 2, 4, 6, 8};
        for (int i : coachSequence) {
            coaches.add(new Coach(i));
        }
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public int getTrainNumber() {
        return trainNumber;
    }
}
