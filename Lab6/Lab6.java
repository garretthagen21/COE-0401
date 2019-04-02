import java.util.*;

public class Lab6{
	public static void main(String [] args) {

int ans=1;

while(ans==1)	{
		double maximum=0,minimum=0,sum=0,average=0;
		Scanner inScan=new Scanner(System.in);
		int numItems,i;
		
		//Ask user how many items will be entered
		System.out.println("How many items will be entered?");
		numItems=inScan.nextInt();
		
		
		double [] data= new double[numItems];
		
		for(i=0;i<numItems;i++) {
			System.out.println("Please enter a number");
			data[i]=inScan.nextInt();
		}
		maximum=Lab12.max(data);
		minimum=Lab12.min(data);
		sum=Lab12.sum(data);
		average=Lab12.ave(data);
		
		System.out.println("Maximum: "+maximum);
		System.out.println("Minimum: "+minimum);
		System.out.println("Sum: "+sum);
		System.out.println("Average: "+average);
	
		System.out.println("Do you want to go again? (1=Yes 2=No)");
		ans=inScan.nextInt();
		
		}		
		
		
	}	
		
		public static double max(double [] data) {
			int i;
			double max=data[0];
			
			for(i=0;i<data.length;i++) {
				if (data[i]>max){
					max=data[i];
				}
			}
			return max;
		}
        // array.

		public static double min(double [] data) {   // return the minimum value in the 
			int i;
			double min=data[0];
			
			for(i=0;i<data.length;i++) {
				if (data[i]<min){
					min=data[i];
				}
			}
			return min;
		}
        // array

		public static double sum(double [] data) { 
			int i;
			double sum=0;
			
			for(i=0;i<data.length;i++) {
				sum+=data[i];
			}
			return sum;
		}// sum the items in the array
			
		
        // and return the result

		public static double ave(double [] data) {
			int i;
			double average,sum=0;
			
			for(i=0;i<data.length;i++) {
				sum+=data[i];
			}
			average=sum/(data.length);
			return average;
		}
		
	}
        // and then return the average
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
