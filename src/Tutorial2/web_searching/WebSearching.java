package Tutorial2.web_searching01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URI;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebSearching {
    private static final String START_URL = "https://lms.fit.hanu.vn/?lang=en";
    private static final String TARGET_PHRASE = "Java Software Development";

    public static void main(String[] args) {
        try {
            findJavaSoftwareDevelopment(START_URL, TARGET_PHRASE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void findJavaSoftwareDevelopment(String startUrl, String targetPhrase) throws IOException {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(startUrl);

        while (!queue.isEmpty()) {
            String currentUrl = queue.poll();
            if (visited.contains(currentUrl)) {
                continue;
            }
            visited.add(currentUrl);

            System.out.println("Visiting: " + currentUrl);

            // Fetch the content of the page
            String pageContent = fetchPageContent(currentUrl);

            // Check if the target phrase is in the page content
            if (pageContent != null && pageContent.contains(targetPhrase)) {
                System.out.println("Found '" + targetPhrase + "' at: " + currentUrl);
                return;
            }

            // Extract links from the page content
            Set<String> links = extractLinks(pageContent, currentUrl);
            for (String link : links) {
                if (!visited.contains(link) && validateString(link)) {
                    queue.add(link);
                }
            }
        }
        System.out.println("The target phrase was not found.");
    }

    private static boolean validateString(String urlString) {
        return urlString.startsWith("https://lms.fit.hanu.vn");
    }

    private static String fetchPageContent(String urlString) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            System.err.println("Malformed URL: " + urlString);
        } catch (IOException e) {
            System.err.println("Error reading from URL: " + urlString);
        }
        return content.toString();
    }

    private static Set<String> extractLinks(String pageContent, String baseUrl) {
        Set<String> links = new HashSet<>();
        if (pageContent == null) {
            return links;
        }

        Pattern pattern = Pattern.compile("href=\"(.*?)\"", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(pageContent);
        while (matcher.find()) {
            String link = matcher.group(1);
            if (!link.startsWith("http")) {
                link = resolveUrl(baseUrl, link);
            }
            links.add(link);
        }
        return links;
    }

    private static String resolveUrl(String baseUrl, String relativeUrl) {
        try {
            URI baseUri = new URI(baseUrl);
            URI resolvedUri = baseUri.resolve(relativeUrl);
            return resolvedUri.toString();
        } catch (Exception e) {
            return relativeUrl;
        }
    }
}
