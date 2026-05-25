public abstract class MembershipPlan implements Billable {
    private String planCode;
    private String clientName;
    private int months;
    private double baseMonthlyFee;
    private boolean autoRenew;

    public MembershipPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew) {
        this.planCode = planCode;
        this.clientName = clientName;
        this.months = months;
        this.baseMonthlyFee = baseMonthlyFee;
        this.autoRenew = autoRenew;
    }

    public String getPlanCode() { return planCode; }
    public String getClientName() { return clientName; }
    public int getMonths() { return months; }
    public double getBaseMonthlyFee() { return baseMonthlyFee; }
    public boolean isAutoRenew() { return autoRenew; }

    public abstract String getPlanType();

    @Override
    public abstract double calculateMonthlyNetPrice();

    @Override
    public double calculateMonthlyGrossPrice() {
        return calculateMonthlyNetPrice() * 1.23; // Using standard 23% VAT
    }

    public double calculateTotalNetPrice() {
        return calculateMonthlyNetPrice() * months;
    }

    public final void printSummary() {
        System.out.println("Plan Code: " + planCode);
        System.out.println("Client: " + clientName);
        System.out.println("Type: " + getPlanType());
        System.out.println("Monthly Net: " + calculateMonthlyNetPrice());
        System.out.println("Monthly Gross: " + calculateMonthlyGrossPrice());
        System.out.println("Total Contract Net: " + calculateTotalNetPrice());
    }

    @Override
    public String toString() {
        return String.format("MembershipPlan[code=%s, client=%s, months=%d, baseFee=%.2f, autoRenew=%b]",
                planCode, clientName, months, baseMonthlyFee, autoRenew);
    }
}
