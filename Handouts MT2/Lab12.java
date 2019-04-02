public class Lab12{


double minimum;
double sum;
double ave;


public static double max(double [] data) {
	double maximum=1;		// return the maximum value in 
	maximum=recMax(data,0,data[0]);
	return maximum;
}
  
public static double recMax(double [] theData,int index, double tempMax)	{
	
	
	if(index<theData.length){	
		if(theData[index]>tempMax) {
			tempMax=theData[index];
			
		}
		return recMax(theData,index+1,tempMax);
	}
	else {
	return tempMax;
	}
}

public static double min(double [] data) {// return the minimum value in
	double minimum=0;		// return the maximum value in 
	minimum=recMin(data,0,data[0]);
	return minimum;

}

public static double recMin(double [] theData,int index, double tempMin)	{
	
	
	if(index<theData.length){	
		if(theData[index]<tempMin) {
			tempMin=theData[index];
			
		}
		return recMin(theData,index+1,tempMin);
	}
	else {
	return tempMin;
	}
}

                                            // array

public static double sum(double [] data) {// sum the items in the array
	double sum=0;		// return the maximum value in 
	sum=recSum(data,0,0);
	return sum;

}

public static double recSum(double [] theData,int index, double tempSum)	{
	
    if(index<theData.length){	
		tempSum+=theData[index];
		return recSum(theData,index+1,tempSum);
	}
	else {
	return tempSum;
	}
}

                                            // and return the result

public static double ave(double [] data) {   // call sum to get the sum
		
	double average=0;		// return the maximum value in 
	average=recAve(data,0,0);
	return average;

}
public static double recAve(double [] theData,int index,double average)	{
    if(index<theData.length){	
		average=sum(theData)/(index+1);
		return recAve(theData,index+1,average);
	}
	else {
	return average;
	}
}
                                            // and then return the average



}