package co.edu.escuelaing.SimpleWebServer;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The WebServer class is a simple framework for managing web services and static files.
 * It allows developers to define RESTful services using lambda expressions, extract query parameters
 * from HTTP requests, and specify the location of static files to be served by the server.
 */
public class WebServer {
    
    // ConcurrentHashMap is used for thread-safe access to services.
    public static Map<String, Service> services = new ConcurrentHashMap<>();
    public static String staticFilesLocation = "";

    /**
     * Registers a new service to a specific URL path.
     *
     * @param url The URL path that will trigger the service.
     * @param s   The service, defined as a lambda expression implementing the Service interface.
     */
    public static void get(String url, Service s) {
        if (url != null && s != null) {
            services.put(url, s);
        } else {
            throw new IllegalArgumentException("URL and Service must not be null");
        }
    }

    /**
     * Extracts the value of a specific query parameter from a given HTTP request.
     *
     * @param request The full HTTP request string, including the query string.
     * @param param   The name of the query parameter to extract.
     * @return The value of the specified query parameter, or an empty string if the parameter is not found.
     */
    public static String queryParams(String request, String param) {
        if (request == null || param == null) {
            throw new IllegalArgumentException("Request and parameter must not be null");
        }
        
        if (request.contains("?")) {
            String[] parts = request.split("\\?");
            if (parts.length > 1) {
                String queryString = parts[1];
                String[] params = queryString.split("&");
                for (String p : params) {
                    String[] keyValue = p.split("=");
                    if (keyValue.length > 1 && keyValue[0].equals(param)) {
                        return keyValue[1];
                    }
                }
            }
        }
        return "";
    }

    /**
     * Sets the location of the static files directory.
     * This directory will be used by the server to serve static content.
     *
     * @param location The path to the directory containing static files.
     */
    public static void staticfiles(String location) {
        if (location != null && !location.trim().isEmpty()) {
            staticFilesLocation = location;
        } else {
            throw new IllegalArgumentException("Static files location must not be null or empty");
        }
    }
}
