import java.util.Scanner;
import java.util.Random;

public class JavaLab4 {

public static void main (String [] args) {
int runAgain=1;
int numberIterations;

while(runAgain==1) {


Random randNumber= new Random();
Scanner inScan = new Scanner(System.in);		//int scanner

System.out.println("How many iterations do you want?");
numberIterations=inScan.nextInt();

RollDice(randNumber,numberIterations);
System.out.println("Do you want to run again? (Enter 1 for Yes and 2 for No)");
runAgain=inScan.nextInt();





	}
}
public static void RollDice(Random randNumber, int numberIterations) {

	int i=0;
	int total=0;
	int two=0,three=0,four=0,five=0,six=0,seven=0,eight=0,nine=0,ten=0,eleven=0,twelve=0;
	
	for (i=1;i<numberIterations;i++) {
		int dice1=randNumber.nextInt(6) + 1;
		int dice2=randNumber.nextInt(6) + 1;
		total=dice1+dice2;
		if (total==2) {
			two++;
		}
		if (total==3) {
			three++;
		}
		if (total==4) {
			four++;
		}
		if (total==5) {
			five++;
		}
		if (total==6) {
			six++;
		}
		if (total==7) {
			seven++;
		}
		if (total==8) {
			eight++;
		}
		if (total==9) {
			nine++;
		}
		if (total==10) {
			ten++;
		}
		if (total==11) {
			eleven++;
		}
		if (total==12) {
			twelve++;
		}

	}
	
	//System.out.println(dice1 + "  " +dice2);
	System.out.println("Number\tFraction");
	System.out.println("2\t"+two+"/"+numberIterations);
	System.out.println("3\t"+three+"/"+numberIterations);
	System.out.println("4\t"+four+"/"+numberIterations);
	System.out.println("5\t"+five+"/"+numberIterations);
	System.out.println("6\t"+six+"/"+numberIterations);
	System.out.println("7\t"+seven+"/"+numberIterations);
	System.out.println("8\t"+eight+"/"+numberIterations);
	System.out.println("9\t"+nine+"/"+numberIterations);
	System.out.println("10\t"+ten+"/"+numberIterations);
	System.out.println("11\t"+eleven+"/"+numberIterations);
	System.out.println("12\t"+twelve+"/"+numberIterations);
	
	
	

	
	
	
	}



}


