import java.io.*;
import java.util.*;

public class Tracker {
    private ArrayList<Topic> topics = new ArrayList<>();
    private final String filePath = "../data/topics.txt";

    public Tracker() {
        loadFromFile();
    }

    private String generateId() {
        return "T" + (topics.size() + 1);
    }

    public void addTopic(String subject, String title, String description) {
        String id = generateId();
        Topic t = new Topic(id, subject, title, description, Status.NOT_STARTED);
        topics.add(t);
        System.out.println("Topic added: " + t);
    }

    public void listTopics() {
        if (topics.isEmpty()) {
            System.out.println("No topics found.");
            return;
        }

        for (Topic t : topics) {
            System.out.println(t);
        }
    }

    public void search(String keyword) {
        boolean found = false;
        for (Topic t : topics) {
            if (t.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                t.getSubject().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(t);
                found = true;
            }
        }
        if (!found) System.out.println("No matching topics found.");
    }

    public void updateStatus(String id, Status newStatus) {
        for (Topic t : topics) {
            if (t.getId().equalsIgnoreCase(id)) {
                t.setStatus(newStatus);
                System.out.println("Updated: " + t);
                return;
            }
        }
        System.out.println("Topic ID not found.");
    }

    public void loadFromFile() {
        File file = new File(filePath);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                Topic t = Topic.fromFileString(line);
                if (t != null) topics.add(t);
            }

        } catch (Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    public void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            for (Topic t : topics) {
                pw.println(t.toFileString());
            }
            System.out.println("Saved successfully.");
        } catch (Exception e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
