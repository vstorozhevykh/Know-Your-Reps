
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class CivicInformation {
    private static final String API_KEY = "AIzaSyCRPayxQ5s1p42Ibxm9YfffbysBxpFkUQE";
    private static final String BASE_URL = "https://www.googleapis.com/civicinfo/v2";

    public static void main(String[] args) {
        try {
            CivicInformation civicInfo = new CivicInformation();
            civicInfo.fetchCivicData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fetchCivicData(String addressString) throws Exception {
        // Construct the API request URL (Modify as needed)
        //String query = "/representatives?address=New%20York&key=" + API_KEY; // Example endpoint
        String query = "/representatives?address="+addressString+"&key=" + API_KEY;
        URL url = URI.create(BASE_URL + query).toURL();

        // Open connection
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        // Check response code
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Read response
        if (responseCode == HttpURLConnection.HTTP_OK) { // 200 OK
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Print the JSON response
            System.out.println("Response: " + response.toString());
        } else {
            System.out.println("Failed to fetch data. Response Code: " + responseCode);
        }

        // Close the connection
        connection.disconnect();
    }
}