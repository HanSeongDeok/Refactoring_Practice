package org.example.refactoring2.function;

public class StatementsBuilderImpl implements StatementsBuilder{
    // field
    private double totalAmount;
    private int frequentRenterPoints;
    private StringBuilder contents;
    // getter
    public double getTotalAmount() {return totalAmount;}
    public int getFrequentRenterPoints() {return frequentRenterPoints;}
    public StringBuilder getContents() {return contents;}
    private static StatementsBuilderImpl statementsBuilder;
    private StatementsBuilderImpl(){}

    // singleton-factory
    public static StatementsBuilder builder(){
        if (statementsBuilder == null) statementsBuilder = new StatementsBuilderImpl();
        return statementsBuilder;
    }

    // builder implementation
    @Override
    public StatementsBuilder setTotalAmount(double amount) {
        totalAmount = amount;
        return this;
    }
    @Override
    public StatementsBuilder setFrequentRenterPoints(int points) {
        frequentRenterPoints = points;
        return this;
    }
    @Override
    public StatementsBuilder setContents(StringBuilder stringBuilder) {
        contents = stringBuilder;
        return this;
    }
    // 명시적으로 setting 이 끝났음을 알림
    @Override
    public StatementsBuilder done() {
        // TODO validation
        return this;
    }
}
