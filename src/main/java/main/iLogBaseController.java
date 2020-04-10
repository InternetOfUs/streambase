package main;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

	@RequestMapping("/**")
	public ResponseEntity mirrorRest(@RequestBody(required = false) String body,
									 HttpMethod method, HttpServletRequest request, HttpServletResponse response)
			throws URISyntaxException {

		logger.info("REST Request at: " + request.getRequestURL());

		URI uri = getUri(request, schemeProtocol, serverAddress, port);

		HttpHeaders headers = getHeaders(request);

		return sendRest(uri, method, body, headers);


	}

	private ResponseEntity sendRest(URI uri, HttpMethod method, String body, HttpHeaders headers) {

		HttpEntity<String> httpEntity = new HttpEntity<>(body, headers);

		RestTemplate restTemplate = new RestTemplate();

		try {

			return restTemplate.exchange(uri, method, httpEntity, String.class);
		} catch(HttpStatusCodeException e) {

			return ResponseEntity.status(e.getRawStatusCode())
					.headers(e.getResponseHeaders())
					.body(e.getResponseBodyAsString());
		}
	}

	private URI getUri(HttpServletRequest request, String schemeProtocol, String serverAddress, int port) throws URISyntaxException{

		String requestUrl = request.getRequestURI();

		URI uri = new URI(schemeProtocol, null, serverAddress, port, null, null, null);
		uri = UriComponentsBuilder.fromUri(uri)
				.path(requestUrl)
				.query(request.getQueryString())
				.build(true).toUri();

		return uri;
	}

	private HttpHeaders getHeaders(HttpServletRequest request){

		HttpHeaders headers = new HttpHeaders();

		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			headers.set(headerName, request.getHeader(headerName));
		}

		return headers;
	}
}