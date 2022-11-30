public class MonthSave {
    String itemName;
    boolean isExpense;
    int quantity;
    int sumOfOne;
    Integer month;

    public MonthSave(String itemName, boolean isExpense, int quantity, int sumOfOne, Integer month) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
        this.month = month;
    }
}
