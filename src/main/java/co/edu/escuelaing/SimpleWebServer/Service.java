package co.edu.escuelaing.SimpleWebServer;

/**
 * The {@code Service} interface provides a contract for services that process requests and generate responses.
 * Implementations of this interface should define how to handle requests and generate corresponding responses.
 * 
 * <p>This interface defines a single method:</p>
 * <ul>
 *   <li>{@link #getValue(String, String)} - Processes the provided request and response and returns a string value.</li>
 * </ul>
 * 
 * @see co.edu.escuelaing.ServiceImpl
 */
public interface Service {

    /**
     * Processes the given request and response, and returns a string value based on the processing.
     * 
     * @param request The input request to be processed. It should contain the data needed for processing.
     * @param response The response to be populated based on the request processing.
     * @return A string value derived from the processing of the request and response.
     */
    String getValue(String request, String response);
}
