package sweb.disi.unitn.it;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import sweb.disi.unitn.it.convertapi.ConverterAPI;
import sweb.disi.unitn.it.validation.UserValidator;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Enumeration;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class iLogBaseController {

    final static Logger logger = LogManager.getLogger(iLogBaseController.class);

    @Value("${ilogbase.address}")
    String serverAddress;

    @Value("${ilogbase.port}")
    int port;

    @Value("${ilogbase.scheme-protocol}")
    String schemeProtocol;

    @Value("${ilogbase.authentication_header}")
    String authenticationHeader;

    @PostConstruct
    private void init() {

    }

    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public ResponseEntity dataPost(@RequestBody String body, HttpMethod method,
                                   HttpServletRequest request, HttpServletResponse response)
            throws URISyntaxException {

        logger.info("POST: --custom /data");

        UserValidator userValidator = new UserValidator(request.getHeader(authenticationHeader));
        if (!userValidator.isValid(body)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("UserId doesn't match");
        }
        body = ConverterAPI.convertV2toV1(body);

        URI uri = getUri(request, schemeProtocol, serverAddress, port);

        HttpHeaders headers = getHeaders(request);
        headers.set("Authorization", "test:");
        headers.set("source", "wenet");

        return sendRest(uri, method, body, headers);
    }

    @RequestMapping(value = "/userSubscription", method = RequestMethod.POST)
    public ResponseEntity userSubscriptionPost(@RequestBody(required = false) String body,
                                               HttpMethod method, HttpServletRequest request, HttpServletResponse response)
            throws URISyntaxException {

        logger.info(method.toString() + " Request at: " + request.getRequestURL());

        URI uri = getUri(request, schemeProtocol, serverAddress, port);

        HttpHeaders headers = getHeaders(request);
        headers.set("Authorization", "test:");

        ResponseEntity re = sendRest(uri, method, body, headers);
        return ResponseEntity.status(re.getStatusCode())
                .headers(re.getHeaders())
                .body(re.getBody());
    }

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public ResponseEntity streambaseDataGetAll(HttpMethod method, HttpServletRequest request, HttpServletResponse response)
            throws URISyntaxException {

        logger.info(method.toString() + " Request at: " + request.getRequestURL());

        UserValidator userValidator = new UserValidator(request.getHeader(authenticationHeader));

        URI uri = getUri(request, schemeProtocol, serverAddress, port);

        HttpHeaders headers = getHeaders(request);
        if (!headers.containsKey("experimentId")) {
            headers.add("experimentId", "wenet");
        }
        headers.set("Authorization", "test:");

        ResponseEntity re = sendRest(uri, method, null, headers);
        return ResponseEntity.status(re.getStatusCode())
                .headers(re.getHeaders())
                .body(ConverterAPI.convertGetAllV1toV2((String) re.getBody()));
    }

    @RequestMapping(value = "/data/{userId}", method = RequestMethod.GET)
    public ResponseEntity streambaseDataGet(HttpMethod method, HttpServletRequest request, HttpServletResponse response)
            throws URISyntaxException {

        logger.info(method.toString() + " Request at: " + request.getRequestURL());

        UserValidator userValidator = new UserValidator(request.getHeader(authenticationHeader));

        URI uri = getUri(request, schemeProtocol, serverAddress, port);

        HttpHeaders headers = getHeaders(request);
        if (!headers.containsKey("experimentId")) {
            headers.add("experimentId", "wenet");
        }
        headers.set("Authorization", "test:");

        ResponseEntity re = sendRest(uri, method, null, headers);
        return ResponseEntity.status(re.getStatusCode())
                .headers(re.getHeaders())
                .body(ConverterAPI.convertV1toV2((String) re.getBody()));
    }

    @RequestMapping("/**")
    public ResponseEntity mirrorRest(@RequestBody(required = false) String body,
                                     HttpMethod method, HttpServletRequest request, HttpServletResponse response)
            throws URISyntaxException {

        logger.info(method.toString() + " Request at: " + request.getRequestURL());

        UserValidator userValidator = new UserValidator(request.getHeader(authenticationHeader));
        if (!userValidator.isValid(body)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("UserId doesn't match");
        }

        //Convert body
        if (null != body) {
            body = ConverterAPI.convertV2toV1(body);
        }

        URI uri = getUri(request, schemeProtocol, serverAddress, port);

        HttpHeaders headers = getHeaders(request);
        headers.set("Authorization", "test:");

        ResponseEntity re = sendRest(uri, method, body, headers);
        return ResponseEntity.status(re.getStatusCode())
                .headers(re.getHeaders())
                .body(ConverterAPI.convertV1toV2((String) re.getBody()));
    }

    private ResponseEntity sendRest(URI uri, HttpMethod method, String body, HttpHeaders headers) {

        HttpEntity<String> httpEntity = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();

        try {

            return restTemplate.exchange(uri, method, httpEntity, String.class);
        } catch (HttpStatusCodeException e) {

            return ResponseEntity.status(e.getRawStatusCode())
                    .headers(e.getResponseHeaders())
                    .body(e.getResponseBodyAsString());
        }
    }

    private URI getUri(HttpServletRequest request, String schemeProtocol, String serverAddress, int port) throws URISyntaxException {

        String requestUrl = request.getRequestURI();

        URI uri = new URI(schemeProtocol, null, serverAddress, port, null, null, null);
        uri = UriComponentsBuilder.fromUri(uri)
                .path(requestUrl)
                .query(request.getQueryString())
                .build(true).toUri();

        return uri;
    }

    private HttpHeaders getHeaders(HttpServletRequest request) {

        HttpHeaders headers = new HttpHeaders();

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.set(headerName, request.getHeader(headerName));
        }

        return headers;
    }
}
