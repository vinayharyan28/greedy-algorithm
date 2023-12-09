import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    static int[][] activitySelectionSorting(int[] start, int[] end){
        int[][] activities = new int[start.length][3];
        for (int i=0; i<start.length; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // Lambda function
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        return activities;
    }


    static void activitySelectionProblem(int[] start, int[] end){
        //End time basis sorted
        int[][] activitySelection2DArray = activitySelectionSorting(start, end);
        int maxActivity = 1;
        ArrayList<Integer> answer = new ArrayList<>();

        //1st activity
        answer.add(activitySelection2DArray[0][0]);
        int lastEnd = activitySelection2DArray[0][2];

        for (int i=1; i<end.length; i++){
            if (activitySelection2DArray[i][1] >= lastEnd){
                //Activity select
                maxActivity++;
                answer.add(activitySelection2DArray[i][0]);
                lastEnd = activitySelection2DArray[i][2];
            }
        }

        System.out.println("Max activities = " + maxActivity);

        for (Integer integer : answer) {
            System.out.print("A" + integer + " ");
        }
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9}; // sorted on end time
        activitySelectionProblem(start, end);
    }
}
