import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class FractalTree extends PApplet {

private double fractionLength = .8f; 
private int smallestBranch = 10; 
private double branchAngle = .27f;  
public void setup() 
{   
	size(640,480);    
	noLoop(); 
} 
public void draw() 
{   
	background(0);   
	stroke(0,255,0);   
	line(430,480,430,380);
	drawBranches(430,380,80,3*Math.PI/2);
	stroke(0,0, 255); 
	line(215,480,215,380); 
	drawBranches(215, 380,80,3*Math.PI/2);
	stroke(255,0,0);   
	line(0,480,0,380);
	drawBranches(0,380,80,3*Math.PI/2);
	stroke(255,0,0);   
	line(640,480,640,380);
	drawBranches(640,380,80,3*Math.PI/2);
} 
public void drawBranches(int x,int y, double branchLength, double angle) 
{   
	double angle1 = angle + branchAngle;
	double angle2 = angle - branchAngle;
	int endX1 = (int)(branchLength*Math.cos(angle1) + x);
	int endX2 = (int)(branchLength*Math.cos(angle2) + x);
	int endY1 = (int)(branchLength*Math.sin(angle1) + y);
	int endY2 = (int)(branchLength*Math.sin(angle2) + y);
	if (branchLength >= smallestBranch)
	{
		line(x, y, endX1, endY1);
		line(x, y, endX2, endY2);
		drawBranches(endX1, endY1, branchLength * fractionLength, angle1);
		drawBranches(endX2, endY2, branchLength * fractionLength, angle2);
	}
	else
	{
		line(x, y, endX1, endY1);
		line(x, y, endX2, endY2);
	}
} 
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "FractalTree" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
