public class Model {
    private int number1;
    private int number2;
    private int sum;
    // Getters y setters
    public int getNumber1() {
    return number1;
    }
    public void setNumber1(int number1) {
    this.number1 = number1;
    }
    public int getNumber2() {
    return number2;
    }
    public void setNumber2(int number2) {
    this.number2 = number2;
    }
    public int getSum() {
    return sum;
    }
    public void calculateSum() {
    this.sum = this.number1 + this.number2;
    }
    }