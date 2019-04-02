//Garrett Hagen
//Intermediate Java CS 401 
//9:30 AM Section
//This program simulates shopping at WWW and was created on 9/20/2017 in Eclipse

import java.util.Scanner;

public class Assignment1 {

		
public static void main (String [] args) {
Scanner inScan = new Scanner(System.in);		//int scanner
Scanner textScan=new Scanner(System.in);		//text scanner
//Declare Variables
int inLine=1;
int passwordAttempt=1;
int discount=0;
int orderNumber;
int gryffindorPins=0, slytherinPins=0, hufflepuffPins=0,ravenclawPins=0,totalPins=0,totalpinPrice=0;
int quaffleBoxes=0,singleQuaffles=0,totalQuaffles=0,totalquafflePrice=0,totalregularquafflePrice=0,boxPrice=638,quaffleResponse=0,totalsinglequafflePrice=0,totalquaffleboxPrice=0;
int broomkitPrice=986,broomkitTotal=0,broomkitResponse=0,broomkitregulartotalPrice=0,broomkittotalPrice=0; 
boolean currentlyShopping=true;	
boolean currentlySelecting=true;
int pinTeam;
int numPins;
int pinPrice=20;
int total=0;
int regularTotal=0;
int bonusDiscount=0;
int finalTotal=0;
int savings=0;
String discountStatus="regular";		
String password="PotterPuppetPals";



 
		
System.out.println("Welcome to Quality Quidditch Supplies!");
System.out.println("[Hogsmeade Convenience Location]");
System.out.println("Is there a customer in line? (1 = Yes, 2 = No)");

inLine=inScan.nextInt();
if (inLine<0) {
	inLine=-inLine;
	System.out.println("Entry interpreted as " + inLine );
}


while (inLine==1) { 
	passwordAttempt=1;
	currentlyShopping=true;
	System.out.println("What is the password?");
	password=textScan.next();
	//System.out.println(password);
		
	while (!password.equals("PotterPuppetPals") && passwordAttempt==1) {
		System.out.println("Incorrect Password. Try 1 More time");	
		password=textScan.next();
		passwordAttempt++;
	}
	
	if(password.equals("PotterPuppetPals")) {
			System.out.println("Welcome Dumbledore Army Member! Please enjoy our discounted prices!");
			discount=1;
			discountStatus="discounted";
			
		}
	
	else if (!password.equals("Potter") && passwordAttempt>1) { 
		discount=0;
		discountStatus="regular";
	}
	PriceList(discount);
	while(currentlyShopping) {		
		
		
		//Choose Option
			System.out.println("\nPlease Choose an Option\n");	
			System.out.println("1) Update House Pins Order");
			System.out.println("2) Update Quaffles Order");
			System.out.println("3) Update Broomstick Kits Order");
			System.out.println("4) Show Price List");
			System.out.println("5) Check Out");
		
		//Scan for choice
			orderNumber=inScan.nextInt();
			if (orderNumber<0) {
				orderNumber=-orderNumber;
				System.out.println("Entry interpreted as " + orderNumber );
			}
			
			if (orderNumber==1) {
				//House Pins
				CurrentPinOrder(gryffindorPins, slytherinPins, hufflepuffPins,ravenclawPins,totalPins);
		         
				
		
				
				while(currentlySelecting) {		
					//Choose Option
						System.out.println("\nWhat team do you want to buy pins for?\n");	
						System.out.println("1) Gryffindor");
						System.out.println("2) Slytherin");
						System.out.println("3) HufflePuff");
						System.out.println("4) Ravenclaw");
						System.out.println("5) Done Pin Shopping");
					
					//Scan for choice
						pinTeam=inScan.nextInt();
						//error check
						if (pinTeam<0) {
							pinTeam=-pinTeam;
							System.out.println("Entry interpreted as " + pinTeam);
						}
						
						if (pinTeam==1) {
							System.out.println("How many Gryffindor Pins would you like?");
							numPins=inScan.nextInt();
							gryffindorPins=numPins;
							System.out.println("You will pay the " + discountStatus + " price of " + pinPrice + " Knuts");
						}
						else if(pinTeam==2) {
							System.out.println("How many Slytherin Pins would you like?");
							numPins=inScan.nextInt();
							slytherinPins=numPins;
							System.out.println("You will pay the " + discountStatus + " price of " + pinPrice + " Knuts");
							}
						else if(pinTeam==3) {
							System.out.println("How many Hufflepuff Pins would you like?");
							numPins=inScan.nextInt();
							hufflepuffPins=numPins;
							System.out.println("You will pay the " + discountStatus + " price of " + pinPrice + " Knuts");
						}
						else if(pinTeam==4) {
							System.out.println("How many Ravenclaw Pins would you like?");
							numPins=inScan.nextInt();
							ravenclawPins=numPins;
							System.out.println("You will pay the " + discountStatus + " price of " + pinPrice + " Knuts");
						}
						else if(pinTeam==5) {
							currentlySelecting=false;
						}
			    		totalPins=gryffindorPins+slytherinPins+hufflepuffPins+ravenclawPins;
			    		if (discount==1 && totalPins>=10) {
			    		pinPrice=18;
			    		totalpinPrice=18*totalPins;
			    		System.out.println("Congratulations you have earned the discounted pin price of 18 Knuts!");
				    }
			    		else {
					totalpinPrice=20*totalPins;
					}
			    		//display current order
			    		CurrentPinOrder(gryffindorPins,slytherinPins,hufflepuffPins,ravenclawPins,totalPins);
				}
			}
			
			//Quaffle Selection
			
			else if(orderNumber==2) {
				if (discount==1) {
					boxPrice=580;
				}
				//display current quaffle order
				CurrentQuaffleOrder(quaffleBoxes,singleQuaffles,totalQuaffles);
		
				System.out.println("How many quaffles would you like for the price of: ");
				System.out.println("\t145 Knuts per Quaffle ");
				System.out.println("\t" + boxPrice + " Knuts per Quaffle ");
				System.out.println("(Enter the total number of Quaffles) ");
				
				
				quaffleResponse=inScan.nextInt();
				if (quaffleResponse<0) {
					quaffleResponse=-quaffleResponse;
					System.out.println("Entry interpreted as " + quaffleResponse);
				}
				totalQuaffles=quaffleResponse;
		
				quaffleBoxes=totalQuaffles/5;
				singleQuaffles=totalQuaffles%5;
			    totalquafflePrice=boxPrice*quaffleBoxes + 145*singleQuaffles;
				totalregularquafflePrice=638*quaffleBoxes + 145*singleQuaffles;
				totalquaffleboxPrice=boxPrice*quaffleBoxes;
				totalsinglequafflePrice=145*singleQuaffles;
				CurrentQuaffleOrder(quaffleBoxes,singleQuaffles,totalQuaffles);
				
				
				}
			
			//Broom Kit Selection 
			
			else if(orderNumber==3) {    
				if (discount==1) {
					broomkitPrice=899;
					}
				System.out.println("How many Broomstick repair kits would you like to buy for the price of " +broomkitPrice+ " Knuts");
				broomkitResponse=inScan.nextInt();
				broomkitTotal=broomkitResponse;
				broomkittotalPrice=broomkitTotal*broomkitPrice;
				broomkitregulartotalPrice=broomkitTotal*986;
				CurrentBroomKitOrder(broomkitTotal);
				
			}
			else if(orderNumber==4) {
				PriceList(discount);
			}
			else if(orderNumber==5) {			//Checkout
				currentlyShopping=false;
					if(discount==0) {
						if (totalPins>0) {
						System.out.println("Here is your subtotal");
						
						System.out.println("\t" + totalPins + " House Pins at 20 Knuts each\t\t" +totalpinPrice);	//pins
							if(gryffindorPins>0) {
								System.out.println("\t"+gryffindorPins+" Gryffindor Pins");
							}
							if(slytherinPins>0) {
								System.out.println("\t"+slytherinPins+" Slytherin Pins");
							}
							if(hufflepuffPins>0) {
								System.out.println("\t"+hufflepuffPins+" Hufflepuff Pins");
							}
							if(ravenclawPins>0) {
								System.out.println("\t"+ravenclawPins+" Ravenclaw Pins");
							}
						}
						
						
						if (totalQuaffles>0) {
							if(quaffleBoxes>0) {
								System.out.println("\t"+quaffleBoxes+" boxes of Quaffles at 638 Knuts each\t" +totalquaffleboxPrice);
							}
							if (singleQuaffles>0) {
								System.out.println("\t"+singleQuaffles+" single Quaffles at 145 Knuts eac\t" +totalsinglequafflePrice);
							}
						}
						
					if(broomkitTotal>0) {
						System.out.println("\t"+broomkitTotal+" Broom Repair Kits at " +broomkitPrice+ " Knuts each\t" +broomkittotalPrice);
					}
					
					total=totalpinPrice+totalquafflePrice+broomkittotalPrice;
					
					if (total>0) {
					System.out.println("\t\t\t\t\t\t\t----");
					System.out.println("Total\t\t\t\t\t\t"+total);
					}
					else {
							System.out.println("You have not purchased anything. Have a nice day!");
						
					}
				}
				
					//Discount checkout 
					
					if(discount==1) {
						if (totalPins>0) {
						System.out.println("Here is your subtotal");
						
						System.out.println("\t" + totalPins + " House Pins at " +pinPrice+ " Knuts each\t\t" +totalpinPrice);	//pins
							if(gryffindorPins>0) {
								System.out.println("\t"+gryffindorPins+" Gryffindor Pins");
							}
							if(slytherinPins>0) {
								System.out.println("\t"+slytherinPins+" Slytherin Pins");
							}
							if(hufflepuffPins>0) {
								System.out.println("\t"+hufflepuffPins+" Hufflepuff Pins");
							}
							if(ravenclawPins>0) {
								System.out.println("\t"+ravenclawPins+" Ravenclaw Pins");
							}
						}
						
						
						if (totalQuaffles>0) {
							if(quaffleBoxes>0) {
								System.out.println("\t"+quaffleBoxes+" boxes of Quaffles at " +boxPrice+  " Knuts each\t" +totalquaffleboxPrice);
							}
							if (singleQuaffles>0) {
								System.out.println("\t"+singleQuaffles+" single Quaffles at 145 Knuts eac\t" +totalsinglequafflePrice);
							}
						}
						
					if(broomkitTotal>0) {
						System.out.println("\t"+broomkitTotal+" Broom Repair Kits at " +broomkitPrice+ " Knuts each\t" +broomkittotalPrice);
					}
					
					
					regularTotal=totalregularquafflePrice+broomkitregulartotalPrice+(totalPins*20);
					total=totalpinPrice+totalquafflePrice+broomkittotalPrice;
					bonusDiscount=total/10;
					finalTotal=total-bonusDiscount;
					savings=regularTotal-finalTotal;
					
					if(total>0) {
					System.out.println("Here is your subtotal: ");
					System.out.println("Regular Total:\t\t\t\t\t\t"+regularTotal);
					System.out.println("\t\t\t\t\t\t\t----");
					System.out.println("Discount Total:\t\t\t\t\t\t"+total);
					System.out.println("Bonus 10% Discount:\t\t\t\t\t-"+bonusDiscount);
					System.out.println("\t\t\t\t\t\t\t----");
					System.out.println("Final Total:\t\t\t\t\t\t"+finalTotal);
					System.out.println("\t\t\t\t\t\t\t----");
					System.out.println("Total Savings:\t\t\t\t\t\t"+savings);
					
					total=finalTotal;
					Checkout(total);		//Go to check out
					}		            
					else {
						System.out.println("You have not purchased anything. Have a nice day!");
					}
					
				
					}
					
			  }
    		
			
	
	   }
	System.out.println("Is there a customer in line? (1 = Yes 2 = No)");
	inLine=textScan.nextInt();

  }



		
}

//End of Main

//Checkout
public static void Checkout(int total) {
	System.out.println("Please enter a payment amount in the following format: ");
	System.out.println("\t\t<amount><space><currency>");
	System.out.println("\t\t<amount> = an integer");
	System.out.println("\t\t<space> = a blank space");
	System.out.println("\t\t<currency> = a currency");
	System.out.println("You may enter as many times as you like. Each entry will be\n added to you total until sufficient funds have been obtained.\nRecall the currency exchange:");
	System.out.println("\t29 Knuts = 1 Sickle");
	System.out.println("\t493 Knuts = 17 Sickles = 1 Galleon");
	Scanner textScan=new Scanner(System.in);
	Scanner inScan=new Scanner(System.in);
	
	int currentAmount=0;
	int totalPaid=0;
	int currentKnuts=0;
	int stillOwe=1;
	
	String currency;
	
	while(stillOwe>0) {
	System.out.println("Payment: ");
	currentAmount=inScan.nextInt();
	currency=inScan.next();
	
	if (currentAmount<0) {
		currentAmount=-currentAmount;
		System.out.println("Entry interpreted as " + currentAmount );
	}
	
	if (currency.equals("Sickles") || currency.equals("Sickle")){
		currentKnuts=currentAmount*29;
		totalPaid=totalPaid+currentKnuts;
		System.out.println("You have added " + currentKnuts + " to your total ");
		}
	if (currency.equals("Knuts") || currency.equals("Knut")){
		currentKnuts=currentAmount;
		totalPaid=totalPaid+currentKnuts;
		System.out.println("You have added " + currentKnuts + " to your total ");
		}
	if (currency.equals("Galleons") || currency.equals("Galleon")){
		currentKnuts=currentAmount*493;
		totalPaid=totalPaid+currentKnuts;
		System.out.println("You have added " + currentKnuts + " to your total ");
		}

	System.out.println("You have paid " + totalPaid + " out of " +total+ " Knuts");
	stillOwe=total-totalPaid;
	if (stillOwe>0) {
	System.out.println("You still owe " + stillOwe + " Knuts ");
	}
}
	
	
	int overPaid=0;
	int galleonChange=0;
	int sickleChange=0;
	int knutChange=0;
	
	System.out.println("Thank You!");
	overPaid=totalPaid-total;
	if(overPaid>0) {
	System.out.println("You have overpaid  by " + overPaid + " Knuts ");
	System.out.println("Here is your change: ");
		if (overPaid/493>0) {
			galleonChange=galleonChange+(overPaid/493);
			overPaid=overPaid-(galleonChange*493);
			System.out.println("\t" + galleonChange + " Galleons");
		}
		if (overPaid/29>0) {
			sickleChange=sickleChange+(overPaid/29);
			overPaid=overPaid-(sickleChange*29);
			System.out.println("\t" + sickleChange + " Sickles");
		}
		if(overPaid>0) {
		knutChange=overPaid;
		System.out.println("\t" + knutChange + " Knuts");
		}
		System.out.println("Thank you for Shopping at WWW!");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

	//Current Pin Order
	public static void CurrentPinOrder(int gryffindorPins, int slytherinPins, int hufflepuffPins, int ravenclawPins,int totalPins) {
		if (totalPins>0){
			System.out.println("Here is your current order:\n");
			System.out.println(totalPins + " Team Pins");
			if(gryffindorPins>0) {
				System.out.println(gryffindorPins + " Gryffindor Pins");
			}
			if(slytherinPins>0) {
				System.out.println(slytherinPins + " Slytherin Pins");
			}
			if(hufflepuffPins>0) {
				System.out.println(hufflepuffPins + " Hufflepuff Pins");
			}
			if(ravenclawPins>0) {
				System.out.println(ravenclawPins + " Ravenclaw Pins");
			}
		  }
		else{
			System.out.println("You have no pins yet");
		 }
		
	}

		
//Quaffle Current Order
	public static void CurrentQuaffleOrder(int quaffleBoxes, int singleQuaffles, int totalQuaffles) {
		    if (totalQuaffles==0) {
		    	System.out.println("You have no quaffles yet");
		    	}
		    
		   if (totalQuaffles>0){
			System.out.println("Here is your current Quaffle order:\n");
			System.out.println(totalQuaffles + "  Total Quaffles");
			if(quaffleBoxes>0) {
				System.out.println(quaffleBoxes + " Boxes of Quaffles");
			}
			if(singleQuaffles>0) {
				System.out.println(singleQuaffles + " Single Quaffles");
			}
			
		
	   }	
		
		
	}
	
	//Broom kit current order
	public static void CurrentBroomKitOrder(int broomkitTotal) {
	if (broomkitTotal<=0) {
		System.out.println("You have not ordered any Broomstick Repair Kits");
	}
	else {
		System.out.println("Here is your current order:");
		System.out.println("\t"+broomkitTotal+" Broomstick Repair Kits");
		
	}
	
	}
	
	//Price List Function
public static void PriceList(int discount) {
	//Show regular prices
	
	//Show currency conversions
	
	System.out.println("We appreciate exact change!");
	System.out.println("Recall our currency options:");
	System.out.println("\t29 Knuts == 1 Sickle");
	System.out.println("\t17 Sickles == 1 Galleon == 493 Knuts\n");
	
if (discount==0) {	
	System.out.println("Please enjoy our regular prices!");	
	System.out.println("\nHere is our price list:\n");
	System.out.println("House Pins (Each)						20 Knuts");
	System.out.println("\tAvailible in Gryffindor,Slytherin,HufflePuff and Ravenclaw");
	System.out.println("Quaffles (Each)							145 Knuts");
	System.out.println("Quaffles (Box of 5)						638 Knuts");
	System.out.println("Broomstick Service Kits (Each)					986 Knuts");
}
else if (discount==1) {
	//Show Discount Prices
	
	System.out.println("Please enjoy our discount prices!");	
	System.out.println("\nHere is our price list:\n");
	System.out.println("House Pins (Each)						20 Knuts");
	System.out.println("\tAvailible in Gryffindor,Slytherin,HufflePuff and Ravenclaw");
	System.out.println("Quaffles (Each)							145 Knuts");
	System.out.println("Quaffles (Box of 5)						580 Knuts");
	System.out.println("Broomstick Service Kits (Each)					899 Knuts");
 }	
}

}
