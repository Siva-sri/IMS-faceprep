package ims;
public class Policy {
    private String policyNumber;
    private String policyType;
    private double basePremium;
    private String startDate;
    private String endDate;

    public Policy(String policyNumber, String policyType, double basePremium, String startDate, String endDate) {
        this.policyNumber = policyNumber;
        this.policyType = policyType;
        this.basePremium = basePremium;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and setters
    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public double getBasePremium() {
        return basePremium;
    }

    public void setBasePremium(double basePremium) {
        this.basePremium = basePremium;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double calculatePremium() {
        double premium = basePremium;
        switch (policyType.toLowerCase()) {
            case "health":
                premium *= 1.1;
                break;
            case "life":
                premium *= 1.2;
                break;
            case "vehicle":
                premium *= 1.3;
                break;
            default:
                premium *= 1.0;
                break;
        }
        return premium;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyType='" + policyType + '\'' +
                ", basePremium=" + basePremium +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", calculatedPremium=" + calculatePremium() +
                '}';
    }
}

