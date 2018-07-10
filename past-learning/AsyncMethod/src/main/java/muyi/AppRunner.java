package muyi;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner{
    private static final Logger log = LoggerFactory.getLogger(AppRunner.class);

    private final GitHubLookupService gitHubLookupService;

    public AppRunner(GitHubLookupService gitHubLookupService){
        this.gitHubLookupService = gitHubLookupService;
    }

    @Override
    public void run(String... args) throws Exception{
        //start the clock
        long start = System.currentTimeMillis();

        //3 async methods
        CompletableFuture<UserBean> page1 = gitHubLookupService.findUser("aaaa");
        CompletableFuture<UserBean> page2 = gitHubLookupService.findUser("bbbb");
        CompletableFuture<UserBean> page3 = gitHubLookupService.findUser("cccc");
        
        //wait until they are all done
        CompletableFuture.allOf(page1,page2,page3).join();
        

        // Print results, including elapsed time
        log.info("Elapsed time: " + (System.currentTimeMillis() - start));
        log.info("--> " + page1.get());
        log.info("--> " + page2.get());
        log.info("--> " + page3.get());



    }



}