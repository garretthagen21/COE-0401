public class MySquare extends MyRectangle{

protected int sideLength;



public MySquare() {
sideLength=0;
startX=0;
startY=0;

}

public MySquare(int x, int y, int side){
// Constructors to allow new objects to be created. x and y are the
// location coordinates and size is the side length
	sideLength=side;
	startX=x;
	startY=y;
	width=side;
	height=side;
	
	
}

public String toString() {
// Redefining toString(). See output for effect.
	StringBuilder S = new StringBuilder();
	S.append("Side: " + sideLength);
	S.append(" X: " + startX);
	S.append(" Y: " + startY);
	return S.toString();
}

public void setSize(int w, int h) {
// Redefining setSize(). This must be done because the inherited version
// allows the width and height to differ but in a square they must be the
// same. In this version, if the width and height are not the same, the
// method should output a message and not change anything.
	if(w==h) {
		//sideLength=w;
		width=w;
		height=h;
	}
	else {
		System.out.println("The width: " +w+" and height: " +h+ " are not the same. No action taken");
	}
	
	
	
}
public void setSide(int side){
// This is a new method that updates that size of the square. Think about
// how this will be implemented using the existing inherited instance vars.
	
	sideLength=side;
	height=side;
	width=side;
}

}