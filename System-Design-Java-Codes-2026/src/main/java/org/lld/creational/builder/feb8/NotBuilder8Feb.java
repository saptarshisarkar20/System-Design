package org.lld.creational.builder.feb8;

import java.util.HashMap;
import java.util.Map;

/**
 * The HttpRequest_1  class models a simple HTTP request with fields for URL, method,
 * body, headers, query parameters, and timeout.
 *
 * <p><b>Design Considerations / Potential Issues:</b></p>
 *
 * <ul>
 *   <li><b>Constructor Overloading:</b>
 *       <ul>
 *         <li>Six different constructors are provided, which can lead to confusion
 *             about which one to use in practice.</li>
 *         <li>Overloaded constructors may cause ambiguity if parameters overlap
 *             (e.g., String arguments for both URL and method).</li>
 *         <li>Maintaining many constructors increases code complexity and makes
 *             future changes harder.</li>
 *       </ul>
 *   </li>
 *
 *   <li><b>Mutability:</b>
 *       <ul>
 *         <li>All fields are mutable through setter methods, which means the state
 *             of an HttpRequest_1  object can change after construction.</li>
 *         <li>This mutability may lead to unintended side effects if the object is
 *             shared across multiple parts of a program.</li>
 *         <li>Headers and queryParams are stored in mutable Maps, so external code
 *             can modify them directly after assignment.</li>
 *         <li>For safer design, consider making the class immutable by removing
 *             setters and using a builder pattern instead.</li>
 *       </ul>
 *   </li>
 *
 *   <li><b>Thread Safety:</b>
 *       <ul>
 *         <li>Because of mutability, this class is not thread-safe. Concurrent
 *             modifications could lead to inconsistent state.</li>
 *       </ul>
 *   </li>
 *
 *   <li><b>Extensibility:</b>
 *       <ul>
 *         <li>Adding new fields (e.g., cookies, authentication) would require
 *             additional constructors, further complicating overloads.</li>
 *         <li>A builder pattern or factory method could simplify extensibility.</li>
 *       </ul>
 *   </li>
 * </ul>
 *
 * <p>Despite these issues, the current design is useful for demonstration and
 * learning purposes, showing how constructors, setters, and printing methods
 * can be implemented in Java.</p>
 */

// OLD METHOD WITHOUT BUILDER DESIGN
class HttpRequest_1 {
    private String url;
    private String method;
    private String body;
    private Map<String, String> headers;
    private Map<String, String> queryParams;
    private int timeout;

    // 2. Constructor with URL
    public HttpRequest_1(String url) {
        this.method = "GET";
        this.timeout = 30;
        this.url = url;
    }

    // 3. Constructor with URL and method
    public HttpRequest_1(String url, String method) {
        this(url);
        this.method = method;
    }

    // 4. Constructor with URL, method, and body
    public HttpRequest_1(String url, String method, String body) {
        this(url, method);
        this.body = body;
    }

    // 5. Constructor with URL, method, body, and headers
    public HttpRequest_1(String url, String method, String body, Map<String, String> headers) {
        this(url, method, body);
        this.headers = headers;
    }

    // 6. Constructor with all parameters
    public HttpRequest_1(String url, String method, String body, Map<String, String> headers, Map<String, String> queryParams, int timeout) {
        this.url = url;
        this.method = method;
        this.body = body;
        this.headers = headers;
        this.queryParams = queryParams;
        this.timeout = timeout;
    }

    // Setter methods
    public void setUrl(String url) {
        this.url = url;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setQueryParams(Map<String, String> queryParams) {
        this.queryParams = queryParams;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    // Execute function
    public void execute() {
        System.out.println("=== HttpRequest_1  Details ===");
        System.out.println("URL        : " + url);
        System.out.println("Method     : " + method);
        System.out.println("Body       : " + body);
        System.out.println("Headers    : " + (headers.isEmpty() ? "{}" : headers));
        System.out.println("QueryParams: " + (queryParams.isEmpty() ? "{}" : queryParams));
        System.out.println("Timeout    : " + timeout + " ms");
        System.out.println("============================");
    }
}
//------------------------------------------------------------------------


public class NotBuilder8Feb {
    public static void main(String[] args) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("XSRF", "qiorh89qweghf9wegf993qgiwebfi");

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("search", "java");
        queryParams.put("region", "APAC");

        HttpRequest_1 request = new HttpRequest_1(
                "https://example.com",
                "POST",
                "{\"key\":\"value\"}",
                headers,
                queryParams,
                5000
        );

        request.execute();
    }
}