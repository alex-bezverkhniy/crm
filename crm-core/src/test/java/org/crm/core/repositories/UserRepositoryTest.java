package org.crm.core.repositories;

import org.crm.common.domain.User;
import org.crm.core.CoreApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by alex-dev on 7/23/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CoreApplication.class)
@ActiveProfiles("local")
public class UserRepositoryTest {
    protected static Logger log = LoggerFactory.getLogger(UserRepositoryTest.class);

    private int port = 9000;

    @Autowired
    UserRepository userRepository;

    @Test
    public void findByUserName() {
        HttpHeaders headers = getHeaders();
        headers.setAccept(Arrays.asList(MediaType.TEXT_HTML));
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        form.set("username", "user");
        form.set("password", "user");

        HttpEntity<String> requestEntity = new HttpEntity<String>(getHeaders());

        RestTemplate template = new RestTemplate();
        ResponseEntity<User> entity = template.getForEntity("http://localhost:9000/users/2", User.class);
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<String> page = new TestRestTemplate().getForEntity(
                "http://localhost:" + this.port + "/login", String.class);
        assertEquals(HttpStatus.OK, page.getStatusCode());
        String cookie = page.getHeaders().getFirst("Set-Cookie");
        headers.set("Cookie", cookie);
        Matcher matcher = Pattern.compile("(?s).*name=\"_csrf\".*?value=\"([^\"]+).*")
                .matcher(page.getBody());
        assertTrue("No csrf token: " + page.getBody(), matcher.matches());
        headers.set("X-CSRF-TOKEN", matcher.group(1));
        return headers;
    }
/*
    static HttpHeaders getHeaders(String auth) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.ALL.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        byte[] encodedAuthorisation = Base64.encode(auth.getBytes());
        headers.add("Authorization", "Basic " + new String(encodedAuthorisation));

        return headers;
    }
*/
}
