package org.lld.builder.feb8;

import java.util.HashMap;
import java.util.Map;

// with BUILDER PATTERN
class HttpRequest_2 {
    private String url;
    private String method;
    private String body;
    private Map<String, String> headers;
    private Map<String, String> queryParams;
    private int timeout;

    // protected constructor
    HttpRequest_2() {
    }

    // ✅ Add getters for validation
    String getUrl() {
        return url;
    }

    // package scoped setters
    void setUrl(String url) {
        this.url = url;
    }

    String getMethod() {
        return method;
    }

    void setMethod(String method) {
        this.method = method;
    }

    String getBody() {
        return body;
    }

    void setBody(String body) {
        this.body = body;
    }

    Map<String, String> getHeaders() {
        return headers;
    }

    void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    Map<String, String> getQueryParams() {
        return queryParams;
    }

    void setQueryParams(Map<String, String> queryParams) {
        this.queryParams = queryParams;
    }

    int getTimeout() {
        return timeout;
    }

    void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public void execute() {
        System.out.println("=== HttpRequest_2 Details ===");
        System.out.println("URL        : " + url);
        System.out.println("Method     : " + method);
        System.out.println("Body       : " + body);
        System.out.println("Headers    : " + (headers == null || headers.isEmpty() ? "{}" : headers));
        System.out.println("QueryParams: " + (queryParams == null || queryParams.isEmpty() ? "{}" : queryParams));
        System.out.println("Timeout    : " + timeout + " ms");
        System.out.println("============================");
    }
}

class HttpRequest_2Builder {
    private final HttpRequest_2 req;

    public HttpRequest_2Builder() {
        this.req = new HttpRequest_2();
    }

    // Method chaining
    public HttpRequest_2Builder withUrl(final String url) {
        req.setUrl(url);
        return this;
    }

    public HttpRequest_2Builder withMethod(final String meth) {
        req.setMethod(meth);
        return this;
    }

    public HttpRequest_2Builder withBody(final String body) {
        req.setBody(body);
        return this;
    }

    public HttpRequest_2Builder withQueryParams(Map<String, String> queryParams) {
        req.setQueryParams(queryParams);
        return this;
    }

    public HttpRequest_2Builder withHeaders(Map<String, String> headers) {
        req.setHeaders(headers);
        return this;
    }

    public HttpRequest_2Builder withTimeout(final int timeOut) {
        req.setTimeout(timeOut);
        return this;
    }

    // Final Build method with validations
    public HttpRequest_2 build() {
        if (req.getUrl() == null || req.getUrl().trim().isEmpty()) {
            throw new IllegalStateException("URL cannot be null or empty");
        }

        if (req.getMethod() == null || req.getMethod().trim().isEmpty()) {
            throw new IllegalStateException("HTTP method cannot be null or empty");
        }
        String upperMethod = req.getMethod().toUpperCase();
        if (!upperMethod.equals("GET") && !upperMethod.equals("POST") &&
                !upperMethod.equals("PUT") && !upperMethod.equals("DELETE") &&
                !upperMethod.equals("PATCH") && !upperMethod.equals("HEAD")) {
            throw new IllegalStateException("Invalid HTTP method: " + req.getMethod());
        }

        if (req.getTimeout() < 0) {
            throw new IllegalStateException("Timeout cannot be negative");
        }

        if (req.getHeaders() == null) {
            req.setHeaders(new HashMap<>());
        }
        if (req.getQueryParams() == null) {
            req.setQueryParams(new HashMap<>());
        }

        return req;
    }
}

public class TendsToBuilder8Feb {

    // Example usage
    public static void main(String[] args) {

        HttpRequest_2 request = new HttpRequest_2Builder()
                .withUrl("https://example.com")
                .withMethod("POST")
                .withBody("{\"key\":\"value\"}")
                .withTimeout(5000)
                .build();

        request.execute();

    }

}