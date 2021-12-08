package com.jannkasper.baeldung;

import com.jannkasper.baeldung.entity.GitHubUser;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

/**
 * https://www.baeldung.com/integration-testing-a-rest-api
 */
public class GithubApiTest {

    @Test
    public void givenUserDoesNotExists_whenUserInfoIsRetrieved_then404IsReceived() throws IOException {

        // Given
        String name = "random_a";
        HttpUriRequest request = new HttpGet("https://api.github.com/users/" + name);

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // Then
        Assert.assertThat(
                httpResponse.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.SC_NOT_FOUND));
    }

    @Test
    public void givenRequestWithNoAcceptHeader_whenRequestIsExecuted_thenDefaultResponseContentTypeIsJson() throws IOException {

        // Given
        String jsonMimeType = "application/json";
        HttpUriRequest request = new HttpGet("https://api.github.com/users/eugenp");

        // When
        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        // Then
        String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
        assertEquals( jsonMimeType, mimeType );
    }

    @Test
    public void givenUserExists_whenUserInformationIsRetrieved_thenRetrievedResourceIsCorrect() throws IOException {

        // Given
        HttpUriRequest request = new HttpGet("https://api.github.com/users/eugenp");

        // When
        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        // Then
        GitHubUser resource = RetrieveUtil.retrieveResourceFromResponse(response, GitHubUser.class);
        Assert.assertThat( "eugenp", Matchers.is(resource.getLogin()));
    }
}
