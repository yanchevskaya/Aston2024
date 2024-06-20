public class Bowl {
    //создание класса миска с едой
    private int amountOfFood;

    public Bowl(int amountOfFood) {
        this.amountOfFood = amountOfFood;
    }

    public void setAmountOfFood(int amountOfFood) {
        this.amountOfFood = amountOfFood;
    }

    public int getAmountOfFood() {
        return amountOfFood;
    }
    //метод добавления пищи в миску
    public void addFood(int food){
        setAmountOfFood(getAmountOfFood()+food);
    }

}
