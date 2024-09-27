 Weather Forecast Web Application
 
 Description:- This is a simple weather forecast web application built using Java Servlets, JSP, HTML, and CSS. It allows users to enter a city name and retrieve the current weather data, including temperature, humidity, wind speed, and weather description. The application utilizes the OpenWeather API for fetching real-time weather data.

 Features- 
 City Search- Users can search for the weather by entering a city name.
 Real-Time Data- Displays real-time weather data fetched from the OpenWeather API.
 Responsive Design- User-friendly interface with responsive design for various screen sizes.
 Weather Icons- Dynamic weather icons based on the weather conditions.

 Technologies Used:-

Backend- Java Servlets, Gson (for JSON parsing)
Frontend- HTML, CSS, JSP
API- OpenWeather API
IDE- NetBeans

 Setup Instructions

1. Clone the Repository
   ```bash
   git clone https://github.com/your-username/weather-forecast-web-app.git
   ```

2. Navigate to the Project Directory
   ```bash
   cd weather-forecast-web-app
   ```

3. Import into NetBeans
   - Open NetBeans IDE.
   - Select **File** > **Open Project**.
   - Choose the cloned project directory.

4. Add Dependencies
   - Ensure you have the Gson library included in your project. You can add it via Maven or download the JAR file and add it to your project’s libraries.

5. API Key
   - Sign up at [OpenWeather](https://openweathermap.org/) to get your API key.
   - Replace the `API_KEY` variable in `WeatherServlet.java` with your actual API key.

6. Run the Application
   - Deploy the application on a servlet container like Apache Tomcat.
   - Access the application in your web browser: `http://localhost:8080/weather-forecast-web-app`.

 Usage

1. Open the application in your web browser.
2. Enter a city name in the search box and click the search button.
3. View the current weather details, including temperature, humidity, and wind speed.

 Contributing

Contributions are welcome! Please open an issue or submit a pull request if you would like to contribute to this project.

 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

 Acknowledgments

- [OpenWeather API](https://openweathermap.org/)
- [Gson Library](https://github.com/google/gson)

---

Feel free to modify any sections to better reflect your project!
