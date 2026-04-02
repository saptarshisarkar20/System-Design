package org.lld.creational.builder.feb8;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class HttpRequest {

    private final String url;
    private final String method;
    private final String body;
    private final Map<String, String> headers;
    private final Map<String, String> queryParams;
    private final int timeout;

    // 🔒 Private constructor – ONLY Builder can call this
    protected HttpRequest(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.body = builder.body;
        this.timeout = builder.timeout;
        this.headers = Collections.unmodifiableMap(builder.headers);
        this.queryParams = Collections.unmodifiableMap(builder.queryParams);
    }

    // ✅ Only getters – IMMUTABLE object
    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public String getBody() {
        return body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public int getTimeout() {
        return timeout;
    }

    public void execute() {
        System.out.println("=== HttpRequest ===");
        System.out.println("URL     : " + url);
        System.out.println("Method  : " + method);
        System.out.println("Body    : " + body);
        System.out.println("Headers : " + headers);
        System.out.println("Params  : " + queryParams);
        System.out.println("Timeout : " + timeout);
    }
}

// ================= BUILDER =================
class Builder {

    // required
    String url;
    String method;

    // optional
    String body;
    int timeout = 1000;
    Map<String, String> headers = new HashMap<>();
    Map<String, String> queryParams = new HashMap<>();

    public Builder url(String url) {
        this.url = url;
        return this;
    }

    public Builder method(String method) {
        this.method = method;
        return this;
    }

    public Builder body(String body) {
        this.body = body;
        return this;
    }

    public Builder timeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    public Builder header(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    public Builder queryParam(String key, String value) {
        this.queryParams.put(key, value);
        return this;
    }

    public HttpRequest build() {
        validate();
        return new HttpRequest(this);
    }

    private void validate() {
        if (url == null || url.isBlank()) {
            throw new IllegalStateException("URL is required");
        }

        if (method == null || method.isBlank()) {
            throw new IllegalStateException("HTTP method is required");
        }

        String m = method.toUpperCase();
        if (!m.matches("GET|POST|PUT|DELETE|PATCH|HEAD")) {
            throw new IllegalStateException("Invalid HTTP method: " + method);
        }

        if (timeout < 0) {
            throw new IllegalStateException("Timeout cannot be negative");
        }
    }
}


// BUILDER WITH DIRECTOR
class HttpRequestDirector_1 {
    public static HttpRequest createGetReq(final String url) {
        return new Builder()
                .url(url)
                .method("GET")
                .build();
    }

    public static HttpRequest createJsonPostReq(final String url, final String body) {
        return new Builder()
                .url(url)
                .method("POST")
                .body(body)
                .build();
    }
}

public class Builder8Feb {
    public static void main(String[] args) {

        HttpRequest request = new Builder()
                .url("https://example.com")
                .method("POST")
                .body("{\"key\":\"value\"}")
                .header("Authorization", "Bearer token")
                .timeout(5000)
                .build();

        request.execute();

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        HttpRequest req1 = HttpRequestDirector_1.createGetReq("www.builder-director-get.com");
        req1.execute();

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        HttpRequest req2 = HttpRequestDirector_1.createJsonPostReq("www.builder-director-post.com", "this is req body");
        req2.execute();
    }
}