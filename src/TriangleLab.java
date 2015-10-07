import java.util.*;
import java.text.*;

public class TriangleLab{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String color;
        boolean isFilled;
        double x1,y1,x2,y2,x3,y3;

        // takes input
        System.out.print("Enter color and isFilled (true or false): ");
        color = sc.next();
        isFilled = sc.nextBoolean();
        System.out.print("Enter three points for a triangle: ");
        x1 = sc.nextDouble();
        y1 = sc.nextDouble();
        x2 = sc.nextDouble();
        y2 = sc.nextDouble();
        x3 = sc.nextDouble();
        y3 = sc.nextDouble();
        
        // creates triangle object, sets color and filled to user input
        Tri tri = new Tri(x1,y1,x2,y2,x3,y3);
        tri.setColor(color);
        tri.setFilled(isFilled);
        
        // output attributes of triangle.
        System.out.print("The " + tri.getColor() + " triangle is ");
        if(tri.isFilled()){
            System.out.print("filled\n");
        }
        else if(!tri.isFilled()){
            System.out.print("not filled\n");
        }
        System.out.print("It has area of ");
        System.out.printf("%,.2f", tri.getArea() );
        System.out.print(" and perimeter of ");
        System.out.printf("%,.2f", tri.getPerimeter());
    }
}

class Tri{
    private double x1, y1, x2, y2, x3, y3 = 1.0;
    private String color;
    private boolean filled;
    
     public Tri(){
         
    }
     
     public Tri(double x1, double y1, double x2, double y2, double x3, 
                     double y3){
         this.x1 = x1;
         this.y1 = y1;
         this.x2 = x2;
         this.y2 = y2;
         this.x3 = x3;
         this.y3 = y3;
     }
     
     public double getSide1(){
         return Math.sqrt( Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2) );
     }
     
     public double getSide2(){
         return Math.sqrt( Math.pow((x3 - x2),2) + Math.pow((y3 - y2),2) );
     } 
     
     public double getSide3(){
         return Math.sqrt( Math.pow((x1 - x3),2) + Math.pow((y1 - y3),2) );
     }
     
     public double getArea(){
         double p, area;
         p = (getSide1() + getSide2() + getSide3()) / 2;
         return Math.sqrt(p * (p - getSide1()) * (p - getSide2()) * 
                         (p - getSide3()));
     }
     
     public double getPerimeter(){
         return getSide1() + getSide2() + getSide3();
     }
     
      /** Return color */
  public String getColor() {
    return color;
  }

  /** Set a new color */
  public void setColor(String color) {
    this.color = color;
  }

  /** Return filled. Since filled is boolean,
   *  the get method is named isFilled */
  public boolean isFilled() {
    return filled;
  }

  /** Set a new filled */
  public void setFilled(boolean filled) {
    this.filled = filled;
  }
     
    @Override
    public String toString(){
        return "Triangle: side1 = " + getSide1() + " side2 = " + getSide2() +
               " side3 = " + getSide3();
    }
     
}

