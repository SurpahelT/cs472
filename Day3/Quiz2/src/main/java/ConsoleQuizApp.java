import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConsoleQuizApp {
    private static final String BASE_URL = "http://localhost:8080/quiz_war_exploded/quiz";
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            try {
//                // Get the current quiz state
//                String question = sendGetRequest(BASE_URL);
//                if (question == null || question.isEmpty()) {
//                    System.out.println("Quiz has finished or no question available.");
//                    break;
//                }
//
//                System.out.println("Current question: " + question);
//                System.out.print("Enter your answer: ");
//                String answer = scanner.nextLine();
//
//                // Submit the answer
//                sendPostRequest(BASE_URL, answer);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        scanner.close();
//    }
//
//    private static String sendGetRequest(String urlStr) throws Exception {
//        URL url = new URL(urlStr);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//
//        int responseCode = conn.getResponseCode();
//        if (responseCode == HttpURLConnection.HTTP_OK) {
//            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            StringBuilder response = new StringBuilder();
//            String inputLine;
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//            return parseQuestion(response.toString()); // Implement parseQuestion to extract the question from the response
//        } else {
//            throw new RuntimeException("Failed : HTTP error code : " + responseCode);
//        }
//    }
//
//    private static void sendPostRequest(String urlStr, String answer) throws Exception {
//        URL url = new URL(urlStr);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("POST");
//        conn.setDoOutput(true);
//        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//
//        String urlParameters = "answer=" + answer;
//        OutputStream os = conn.getOutputStream();
//        os.write(urlParameters.getBytes());
//        os.flush();
//        os.close();
//
//        int responseCode = conn.getResponseCode();
//        if (responseCode == HttpURLConnection.HTTP_OK) {
//            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            StringBuilder response = new StringBuilder();
//            String inputLine;
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//            // Handle the response if needed
//            System.out.println("Response: " + response.toString());
//        } else {
//            throw new RuntimeException("Failed : HTTP error code : " + responseCode);
//        }
//    }
//
//    // Implement this method based on how your servlet responds to GET requests
//    private static String parseQuestion(String response) {
//        // Example parsing, adjust according to your response format
//        return response;
//    }
//}
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        try {
            // Get the current quiz state
            String response = sendGetRequest(BASE_URL);
            String question = parseQuestion(response);
            String score = parseScore(response);

            if (question == null || question.isEmpty()) {
                System.out.println("Quiz has finished or no question available.");
                break;
            }

            System.out.println("Current question: " + question);
            System.out.println("Your current score is: " + score);
            System.out.print("Enter your answer: ");
            String answer = scanner.nextLine();

            // Submit the answer
            sendPostRequest(BASE_URL, answer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    scanner.close();
}

    private static String sendGetRequest(String urlStr) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            throw new RuntimeException("Failed : HTTP error code : " + responseCode);
        }
    }

    private static void sendPostRequest(String urlStr, String answer) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        String urlParameters = "answer=" + answer;
        OutputStream os = conn.getOutputStream();
        os.write(urlParameters.getBytes());
        os.flush();
        os.close();

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // Handle the response if needed
            System.out.println("Response: " + response.toString());
        } else {
            throw new RuntimeException("Failed : HTTP error code : " + responseCode);
        }
    }

    private static String parseQuestion(String response) {
        Document doc = Jsoup.parse(response);
        Element questionElement = doc.select("p > strong").first();
        if (questionElement != null) {
            return questionElement.text();
        }
        return "No question available";
    }

    private static String parseScore(String response) {
        Document doc = Jsoup.parse(response);
        Element scoreElement = doc.select("p:containsOwn(Your current score is)").first();
        if (scoreElement != null) {
            return scoreElement.text().replace("Your current score is", "").trim();
        }
        return "Score not available";
    }
}