import java.util.*;

class Activity {
    int start;
    int finish;

    Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

public class ActivitySelection {
    public static void selectActivities(List<Activity> activities) {

        // Sort by finish time
        activities.sort(Comparator.comparingInt(a -> a.finish));

        System.out.println("Selected activities:");

        // Always pick the first activity
        Activity lastSelected = activities.get(0);
        System.out.println("Start: " + lastSelected.start + ", Finish: " + lastSelected.finish);

        // Pick remaining non-overlapping activities
        for (int i = 1; i < activities.size(); i++) {
            Activity curr = activities.get(i);

            if (curr.start >= lastSelected.finish) {
                System.out.println("Start: " + curr.start + ", Finish: " + curr.finish);
                lastSelected = curr;
            }
        }
    }

    public static void main(String[] args) {

        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(5, 9));
        activities.add(new Activity(1, 2));
        activities.add(new Activity(3, 4));
        activities.add(new Activity(0, 6));
        activities.add(new Activity(5, 7));
        activities.add(new Activity(8, 9));

        selectActivities(activities);
    }
}
