import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CaluclatingTheBowlingScores {

		
	static final int TotalFrames=10;
	static Scanner inputScore = new Scanner(System.in);
	static List<Integer> ListScore1=new ArrayList<Integer>();
	static List<Integer> ListScore2=new ArrayList<Integer>();
	static int score1,score2,score3;
	static int totalBowlingScore=0;
	public static void main(String[] args) {
		
		for(int frame =1;frame<=TotalFrames;frame++)
		{
			//Read all frames scores			
			//enter score of first ball
			System.out.println("Enter score1 of Frame" +frame+ " : ");			
			score1=inputScore.nextInt();				
			if(score1==10 &&frame!=10)
				score2=0;
			else
			{
				//enter score of second ball
				System.out.println("Enter score2 of Frame" +frame+ " : ");
				score2=inputScore.nextInt();				
			}
			ListScore1.add(score1);
			ListScore2.add(score2);
			if(frame==10 && score1+score2==10)
			{
				//enter score of third ball
				System.out.println("Enter score3 of Frame" +frame+ " : ");
				score3=inputScore.nextInt();	
				System.out.println("Third ball score in Last Frame :"+score3);
			}
		}

		//displays HashMapValues
		System.out.println("ListScore1 : "+ListScore1);
		System.out.println("ListScore2 : "+ListScore2);
		
		//caluclate Total Score
		for(int frame =0;frame<TotalFrames;frame++)
		{
			if(ListScore1.get(frame)==10 &&frame!=9)			
				totalBowlingScore=strikeCaluclation(frame);	
			
			else if(frame==9)			
				totalBowlingScore=tenthFrameScoreCaluclation(frame);	
			
			else if(ListScore1.get(frame)+ListScore2.get(frame)==10)
				totalBowlingScore=spareCaluclation(frame);		
			
			else
				totalBowlingScore=totalBowlingScore+ListScore1.get(frame)+ListScore2.get(frame);
			
		}
		
		System.out.println("Total score of All Frames : "+totalBowlingScore);
	}
	public static int tenthFrameScoreCaluclation(int frame)
	{
		return totalBowlingScore+score3+ListScore1.get(frame)+ListScore2.get(frame);
	}
	public static int strikeCaluclation(int frame)
	{
		return totalBowlingScore+ListScore1.get(frame)+ListScore1.get(frame+1)+ListScore2.get(frame+1);
	}
	public static int spareCaluclation(int frame)
	{
		return totalBowlingScore+ListScore1.get(frame+1)+ListScore1.get(frame)+ListScore2.get(frame);
	}
	
}