import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numberOfSubjects;
        System.out.print("Enter the number of subjects: ");
        numberOfSubjects = scanner.nextInt();

        int[] marks = new int[numberOfSubjects];
        
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " : ");
            int subjectMarks = scanner.nextInt();
            
            while (subjectMarks < 0 || subjectMarks > 100) {
                System.out.println("Invalid input! Marks should be between 0 and 100.");
                System.out.print("Please re-enter marks for subject " + (i + 1) + ": ");
                subjectMarks = scanner.nextInt();
            }
            
            marks[i] = subjectMarks;
        }

        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        double averagePercentage = (double) totalMarks / numberOfSubjects;

        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("\n--- Result ---");
        System.out.println("Total Marks: " + totalMarks + " / " + (numberOfSubjects * 100));
        System.out.printf("Average Percentage: %.2f %%\n", averagePercentage); // Two decimal points
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
