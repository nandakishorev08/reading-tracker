import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Reading Tracker =====");
            System.out.println("1. Add Topic");
            System.out.println("2. List All Topics");
            System.out.println("3. Search Topic");
            System.out.println("4. Update Status");
            System.out.println("5. Save & Exit");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Subject: ");
                    String subject = sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    tracker.addTopic(subject, title, desc);
                    break;

                case 2:
                    tracker.listTopics();
                    break;

                case 3:
                    System.out.print("Keyword: ");
                    String kw = sc.nextLine();
                    tracker.search(kw);
                    break;

                case 4:
                    System.out.print("Enter Topic ID: ");
                    String id = sc.nextLine();
                    System.out.print("New Status (NOT_STARTED, IN_PROGRESS, DONE, REVISION_NEEDED): ");
                    Status status = Status.valueOf(sc.nextLine());
                    tracker.updateStatus(id, status);
                    break;

                case 5:
                    tracker.saveToFile();
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
