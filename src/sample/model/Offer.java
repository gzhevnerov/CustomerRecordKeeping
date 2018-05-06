package sample.model;

public class Offer {



    private int marketingOfferId;
    private String serviceName;
    private String offerType;
    private String status;
    private String offerSum;
    private int marketingOfferTypeId;
    private int employeeId;

    public Offer(int marketingOfferId, String serviceName, String offerType, String status, String offerSum, int employeeId) {
        this.marketingOfferId = marketingOfferId;
        this.serviceName = serviceName;
        this.offerType = offerType;
        this.status = status;
        this.offerSum = offerSum;
        this.employeeId = employeeId;
    }

    public Offer(String serviceName, String offerType, String status, String offerSum, int marketingOfferTypeId, int employeeId) {
        this.serviceName = serviceName;
        this.offerType = offerType;
        this.status = status;
        this.offerSum = offerSum;
        this.marketingOfferTypeId = marketingOfferTypeId;
        this.employeeId = employeeId;
    }

    public void setMarketingOfferTypeId(int marketingOfferTypeId) {
        this.marketingOfferTypeId = marketingOfferTypeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Offer(int marketingOfferId, String serviceName, String offerType, String status, String offerSum, int marketingOfferTypeId, int employeeId) {
        this.marketingOfferId = marketingOfferId;
        this.serviceName = serviceName;
        this.offerType = offerType;
        this.status = status;
        this.offerSum = offerSum;
        this.marketingOfferTypeId = marketingOfferTypeId;
        this.employeeId = employeeId;
    }

    public void setMarketingOfferId(int marketingOfferId) {
        this.marketingOfferId = marketingOfferId;
    }

    public void setMarketing_offer_type_id(Integer marketing_offer_type_id) {
        this.marketingOfferTypeId = marketing_offer_type_id;
    }

    public Integer getMarketingOfferTypeId() {
        return marketingOfferTypeId;
    }

    public void setMarketing_offer_id(Integer customer_id) {
        this.marketingOfferId = marketingOfferId;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOfferSum(String offerSum) {
        this.offerSum = offerSum;
    }

    public Integer getMarketingOfferId() {
        return marketingOfferId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getOfferType() {
        return offerType;
    }

    public String getStatus() {
        return status;
    }

    public String getOfferSum() {
        return offerSum;
    }

    public Offer(Integer marketingOfferId, String serviceName, String offerType, String status, String offerSum, Integer marketingOfferTypeId) {
        this.marketingOfferId = marketingOfferId;
        this.serviceName = serviceName;
        this.offerType = offerType;
        this.status = status;
        this.offerSum = offerSum;
        this.marketingOfferTypeId = marketingOfferTypeId;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "marketingOfferId=" + marketingOfferId +
                ", serviceName='" + serviceName + '\'' +
                ", offerType='" + offerType + '\'' +
                ", status='" + status + '\'' +
                ", offerSum='" + offerSum + '\'' +
                '}';
    }

    public Offer(String serviceName, String offerType, String status, String offerSum) {
        this.serviceName = serviceName;
        this.offerType = offerType;
        this.status = status;
        this.offerSum = offerSum;
    }
    public Offer(Integer marketingOfferId) {
        this.marketingOfferId = marketingOfferId;
    }
}
