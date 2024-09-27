package MyPack;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class WeatherResponse {

    Main main;
    Wind wind;
    Weather[] weather;

    class Main {

        double temp;
        int humidity;
    }

    class Wind {

        double speed;
    }

    class Weather {

        String description;
    }
}

@WebServlet("/weather")
public class WeatherServlet extends HttpServlet {

    private static final String API_KEY = "ff39280f109fb802f544b3f30076e710";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String city = request.getParameter("city");
        if (city == null || city.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "City name cannot be empty.");
            return;
        }

        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&appid=" + API_KEY;

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to fetch weather data. Response Code: " + responseCode);
                return;
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            // Parse the JSON response using Gson
            Gson gson = new Gson();
            WeatherResponse weatherResponse = gson.fromJson(content.toString(), WeatherResponse.class);

            String description = weatherResponse.weather[0].description;
            double temperature = weatherResponse.main.temp;
            int humidity = weatherResponse.main.humidity;
            double windSpeed = weatherResponse.wind.speed;

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String currentDateTime = now.format(formatter);

            request.setAttribute("city", city);
            request.setAttribute("temperature", temperature);
            request.setAttribute("description", description);
            request.setAttribute("humidity", humidity);
            request.setAttribute("windSpeed", windSpeed);

            request.getRequestDispatcher("index.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error occurred while fetching weather data.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
