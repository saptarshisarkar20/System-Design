package org.lld.stepBuilder.feb8;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

interface UrlStep {
    MethodStep url(String url);
}

interface MethodStep {
    BodyStep method(String method);
}

interface BodyStep {
    OptionalStep body(String body);
}

interface OptionalStep {
    OptionalStep header(String key, String value);

    OptionalStep queryParam(String key, String value);

    OptionalStep timeout(int timeout);

    HttpRequest build();
}


class HttpRequest {

    private final String url;
    private final String method;
    private final String body;
    private final Map<String, String> headers;
    private final Map<String, String> queryParams;
    private final int timeout;

    protected HttpRequest(StepHttpRequestBuilder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.body = builder.body;
        this.timeout = builder.timeout;
        this.headers = Collections.unmodifiableMap(builder.headers);
        this.queryParams = Collections.unmodifiableMap(builder.queryParams);
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


class StepHttpRequestBuilder
        implements UrlStep, MethodStep, BodyStep, OptionalStep {

    String url;
    String method;
    String body;

    int timeout = 1000;
    Map<String, String> headers = new HashMap<>();
    Map<String, String> queryParams = new HashMap<>();

    private StepHttpRequestBuilder() {
    }

    // ENTRY POINT
    public static UrlStep builder() {
        return new StepHttpRequestBuilder();
    }

    @Override
    public MethodStep url(String url) {
        this.url = url;
        return this;
    }

    @Override
    public BodyStep method(String method) {
        this.method = method;
        return this;
    }

    @Override
    public OptionalStep body(String body) {
        this.body = body;
        return this;
    }

    @Override
    public OptionalStep header(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    @Override
    public OptionalStep queryParam(String key, String value) {
        this.queryParams.put(key, value);
        return this;
    }

    @Override
    public OptionalStep timeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    @Override
    public HttpRequest build() {
        validate();
        return new HttpRequest(this);
    }

    private void validate() {
        String m = method.toUpperCase();
        if (!m.matches("GET|POST|PUT|DELETE|PATCH|HEAD")) {
            throw new IllegalStateException("Invalid HTTP method: " + method);
        }
        if (timeout < 0) {
            throw new IllegalStateException("Timeout cannot be negative");
        }
    }
}


public class StepBuilder8Feb {
    public static void main(String[] args) {

        HttpRequest request =
                StepHttpRequestBuilder.builder()
                        .url("https://example.com")     // REQUIRED
                        .method("POST")                 // REQUIRED
                        .body("{\"key\":\"value\"}")    // REQUIRED
                        .header("Authorization", "Bearer token")
                        .timeout(5000)
                        .build();

        request.execute();

        // Gives error if we skip a step
//        HttpRequest request2 =
//                StepHttpRequestBuilder.builder()
//                        .url("https://example.com")     // REQUIRED
//                        .body("{\"key\":\"value\"}")    // REQUIRED
//                        .header("Authorization", "Bearer token")
//                        .timeout(5000)
//                        .build();
//
//        request2.execute();
    }
}