package muyi;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitHubLookupService{

    private static final Logger log = LoggerFactory.getLogger(GitHubLookupService.class);

    private final RestTemplate restTemplate;

    public GitHubLookupService(RestTemplateBuilder builder){
        this.restTemplate = builder.build();
    }


    /**
     * The findUser method is flagged with Spring’s @Async annotation, indicating it will run on a separate thread
     * The method’s return type is CompletableFuture<User> instead of User, a requirement for any asynchronous service
     */
    @Async
    public CompletableFuture<UserBean> findUser(String user) throws InterruptedException{
        log.info("Looking up " + user);
        //String url = String.format("https://api.github.com/users/%s", user);
        String url = String.format("http://localhost:8080/user?name=%s",user);

        UserBean resultUser = restTemplate.getForObject(url, UserBean.class);

        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(resultUser);

    }

}