package Crawler_Package;
import java.util.List;
import java.util.ArrayList;
import twitter4j.*;
import twitter4j.conf.*;
import twitter4j.Paging;
import twitter4j.conf.ConfigurationBuilder;

public class Crawler {
	
	static final String CONSUMER_KEY = "oUo2aFdLlqtfjKN5lZ9li3kMX";
	static final String CONSUMER_SECRET = "PTm6WfpGlKDgAt9i7a7j22LHCclfHeH0UUprEeUUDimB2hTAKD";
	static final String ACCESS_TOKEN = "3246891997-pxbNm3d8HpzlVlGUtnoc8zVOWSel3ZbWtw8K8HL";
	static final String ACCESS_TOKEN_SECRET = "LwPTH7s6DJm8a8WRUM4F7Lf3u98gJatOFAEFhZbxS7YHP";

	public static void main(String[] args) {
		ConfigurationBuilder cb = new ConfigurationBuilder();
	    cb.setDebugEnabled(true)
	    .setOAuthConsumerKey(CONSUMER_KEY)
	    .setOAuthConsumerSecret(CONSUMER_SECRET)
	    .setOAuthAccessToken(ACCESS_TOKEN)
	    .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);

	    TwitterFactory tf = new TwitterFactory(cb.build());
	    Twitter twitter = tf.getInstance();
	    int count = 0;
	    Paging paging = new Paging(1, 200);
	    try {
//	    Twitter twitter = TwitterFactory.getSingleton();
//	    List<Status> statuses = twitter.getUserTimeline("CitImmCanada",paging);
//	    List<Status> statuses1 = twitter.getUserTimeline("vfsglobalcare",paging);
//	    List<Status> statuses2 = twitter.getUserTimeline("VFSGlobal",paging);
//	    List<Status> statuses3 = twitter.getUserTimeline("nadirypatel",paging);
//	    System.out.println("Showing home timeline.");
//	    for (Status status : statuses) {
//	        System.out.println(status.getUser().getName() + " >>>>------> " + status.getUser().getScreenName() + " >>>>------> " + status.getText() );
//	        String url= "https://twitter.com/" + status.getUser().getScreenName() 
//	        	    + "/status/" + status.getId();
//	        System.out.println(url );
//	        count++;
//	    }
//	    for (Status status : statuses1) {
//	        System.out.println(status.getUser().getName() + " >>>>------> " + status.getUser().getScreenName() + " >>>>------> " + status.getText() );
//	        String url= "https://twitter.com/" + status.getUser().getScreenName() 
//	        	    + "/status/" + status.getId();
//	        System.out.println(url );
//	    }
//	    
//	    for (Status status : statuses2) {
//	        System.out.println(status.getUser().getName() + " >>>>------> " + status.getUser().getScreenName() + " >>>>------> " + status.getText() );
//	        String url= "https://twitter.com/" + status.getUser().getScreenName() 
//	        	    + "/status/" + status.getId();
//	        System.out.println(url );
//	    }
//	    
//	    for (Status status : statuses3) {
//	        System.out.println(status.getUser().getName() + " >>>>------> " + status.getUser().getScreenName() + " >>>>------> " + status.getText() );
//	        String url= "https://twitter.com/" + status.getUser().getScreenName() 
//	        	    + "/status/" + status.getId();
//	        System.out.println(url );
//	    }
//	    System.out.println(count);
	    
	    Query query = new Query("#IRCC");
	    Query query1 = new Query("#ircc");
	    
	    QueryResult result =twitter.search(query);
	    
	    for (Status status : result.getTweets()) {
	        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
	    }
	    
	      }
     catch (TwitterException te) {
        te.printStackTrace();
        System.out.println("Failed to get timeline: " + te.getMessage());
        System.exit(-1);
    }
	    
	    
	    
	    

	}

}
