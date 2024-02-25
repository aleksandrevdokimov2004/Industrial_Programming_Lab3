public class PointComplex {
    private double real, imaginary;

    PointComplex(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }
    
    PointComplex(){
        this(0,0);
    }

    public double getReal(){
        return real;
    }

    public double getImaginary(){
        return imaginary;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public PointComplex sum(PointComplex anotherPoint){
        return new PointComplex((this.real+anotherPoint.getReal()), (this.imaginary+anotherPoint.getImaginary()));
    }

    public static PointComplex sum(PointComplex point, PointComplex anotherPoint){
        return new PointComplex((point.getReal()+anotherPoint.getReal()), (point.getImaginary()+anotherPoint.getImaginary()));
    }

    public PointComplex sub(PointComplex anotherPoint){
        return new PointComplex((this.real-anotherPoint.getReal()), (this.imaginary-anotherPoint.getImaginary()));
    }

    public static PointComplex sub(PointComplex point, PointComplex anotherPoint){
        return new PointComplex((point.getReal()-anotherPoint.getReal()), (point.getImaginary()-anotherPoint.getImaginary()));
    }

    public String toString(){
        if(imaginary==0) return String.format("%.1fi", real);
        if(imaginary<0) return String.format("%.1f%.1fi", real, imaginary);
        return String.format("%.1f+%.1fi", real, imaginary);
    }

    public double getDistFromThisToPointComplex(PointComplex anotherPoint){

        return Math.sqrt(Math.pow(anotherPoint.getReal()-this.real, 2)+Math.pow(anotherPoint.getImaginary()-this.imaginary, 2));
    }

    public double getDistFromThisToCordStart(){
        return Math.sqrt(Math.pow(this.real, 2)+Math.pow(this.imaginary, 2));
    }

    public static double getDistFromOneToAnotherPoint(PointComplex onePoint, PointComplex secondPoint){
        return Math.sqrt(Math.pow(onePoint.getReal()-secondPoint.getReal(), 2)+Math.pow(onePoint.getImaginary()-secondPoint.getImaginary(), 2));
    }

}
