package Crawler_Package;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import twitter4j.*;
import twitter4j.conf.*;
import twitter4j.conf.ConfigurationBuilder;


public class TwitterCrawler {
	
	static final String CONSUMER_KEY = "oUo2aFdLlqtfjKN5lZ9li3kMX";
	static final String CONSUMER_SECRET = "PTm6WfpGlKDgAt9i7a7j22LHCclfHeH0UUprEeUUDimB2hTAKD";
	static final String ACCESS_TOKEN = "3246891997-pxbNm3d8HpzlVlGUtnoc8zVOWSel3ZbWtw8K8HL";
	static final String ACCESS_TOKEN_SECRET = "LwPTH7s6DJm8a8WRUM4F7Lf3u98gJatOFAEFhZbxS7YHP";
	
	
	public static Twitter createTwitterInstance()
	{
		
		ConfigurationBuilder configSetUp = new ConfigurationBuilder();
		configSetUp.setDebugEnabled(true)
	    .setOAuthConsumerKey(CONSUMER_KEY)
	    .setOAuthConsumerSecret(CONSUMER_SECRET)
	    .setOAuthAccessToken(ACCESS_TOKEN)
	    .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);

	    TwitterFactory factoryInstance = new TwitterFactory(configSetUp.build());
	    
	    return factoryInstance.getInstance();
	}
	
	public static Paging TweetCrawlerLength(int length)
	{
		
//		Scanner pager = new Scanner(System.in);
		
		Paging tweetLenght = new Paging(1, length);
		
		return tweetLenght;
	}
	
	public static void generateTwitterTweetCrawling(String AccountName, Paging tweetLenght, Twitter twitter)
	{
		
		try 
		{
		
			List<Status> statuses = twitter.getUserTimeline(AccountName,tweetLenght);
			
			WriteCrawlerFileforTweets (statuses);
		    
		}
		
		catch (TwitterException te) {
		        te.printStackTrace();
		        System.out.println("Failed to get timeline: " + te.getMessage());
		        System.exit(-1);
		}
		
		
		
		
	}
	
	
	public static void generateTwitterHastTagCrawling(String HastTags, int tweetLenght, Twitter twitter)
	{
		
		try 
		{
		
			Query query = new Query(HastTags);
		    
		    
		    QueryResult statuses =twitter.search(query);
			
		    WriteCrawlerFileforHashTags (statuses, tweetLenght);
		    
		}
		
		catch (TwitterException te) {
		        te.printStackTrace();
		        System.out.println("Failed to get timeline: " + te.getMessage());
		        System.exit(-1);
		}
		
	}
	
	
	public static void CreateCrawlerFile ()
	{
		try {
		      File myObj = new File("src/Crawler_Package/TwetterCrawler.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		try {
		      File myObj = new File("src/Crawler_Package/TwetterCrawlerURLsOnly.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	
	public static void WriteCrawlerFileforTweets (List<Status> statuses)
	{
		
		
		
		
		try {
		      FileWriter myWriter = new FileWriter("src/Crawler_Package/TwetterCrawler.txt",true);
		      
				for (Status status : statuses) 
				{
					
			        String url= "https://twitter.com/" + status.getUser().getScreenName() 
			        	    + "/status/" + status.getId();
			        
			        myWriter.write(url + " >>>>------> " +status.getUser().getName() + " >>>>------> " + status.getUser().getScreenName() + " >>>>------> " + status.getCreatedAt() + " >>>>------> " + status.getText() + "\n");
			      
			    }

		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
		
		
		try {
		      FileWriter myWriter = new FileWriter("src/Crawler_Package/TwetterCrawlerURLsOnly.txt",true);
		      
				for (Status status : statuses) 
				{
					
			        String url= "https://twitter.com/" + status.getUser().getScreenName() 
			        	    + "/status/" + status.getId();
			        
			        myWriter.write(url + "\n");
			      
			    }

		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}
	
	
	
	public static void WriteCrawlerFileforHashTags (QueryResult statuses, int tweetLenght)
	{
		
		
		int Tweetcount = 0;
		
		try {
		      FileWriter myWriter = new FileWriter("src/Crawler_Package/TwetterCrawler.txt",true);
		      
				for (Status status : statuses.getTweets()) 
				{
					
			        String url= "https://twitter.com/" + status.getUser().getScreenName() 
			        	    + "/status/" + status.getId();
			        
			        myWriter.write(url + " >>>>------> " +status.getUser().getName() + " >>>>------> " + status.getUser().getScreenName() + " >>>>------> " + status.getCreatedAt() + " >>>>------> " + status.getText() + "\n");
			        
			        Tweetcount++;
			        
			        if (Tweetcount > tweetLenght)
			        {
			        	break;
			        }
			    }

		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
		Tweetcount = 0;
		
		try {
		      FileWriter myWriter = new FileWriter("src/Crawler_Package/TwetterCrawlerURLsOnly.txt",true);
		      
				for (Status status : statuses.getTweets()) 
				{
					
			        String url= "https://twitter.com/" + status.getUser().getScreenName() 
			        	    + "/status/" + status.getId();
			        
			        myWriter.write(url + "\n");
			        
			        if (Tweetcount > tweetLenght)
			        {
			        	break;
			        }
			      
			    }

		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}
	
	

	
	

	public static void main(String[] args) {
		
		Twitter CallforTweets = createTwitterInstance();
		
		CreateCrawlerFile();
		
		generateTwitterTweetCrawling( "CitImmCanada", TweetCrawlerLength(1000), CallforTweets );
		generateTwitterTweetCrawling( "vfsglobalcare", TweetCrawlerLength(1000), CallforTweets );
		generateTwitterTweetCrawling( "VFSGlobal", TweetCrawlerLength(1000), CallforTweets );
		generateTwitterTweetCrawling( "CanadainIndia", TweetCrawlerLength(1000), CallforTweets );
		generateTwitterTweetCrawling( "nadirypatel", TweetCrawlerLength(1000), CallforTweets );
		
		generateTwitterHastTagCrawling("#ircc", 1000, CallforTweets);
		generateTwitterHastTagCrawling("#IRCC", 1000, CallforTweets);
		generateTwitterHastTagCrawling("#VFS", 1000, CallforTweets);
		generateTwitterHastTagCrawling("#VFSGlobal", 1000, CallforTweets);
		generateTwitterHastTagCrawling("#CanadainIndia", 1000, CallforTweets);
		

	}

}
