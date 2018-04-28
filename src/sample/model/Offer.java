package sample.model;

public class Offer {
    private int marketingOfferId;
    private String serviceName;
    private String offerType;
    private String stutus;
    private String offer_sum;
    private int marketing_offer_type_id;
    private int employee_id;

    public Offer(String serviceName, String offerType, String stutus, String offer_sum, int marketing_offer_type_id, int employee_id) {
        this.serviceName = serviceName;
        this.offerType = offerType;
        this.stutus = stutus;
        this.offer_sum = offer_sum;
        this.marketing_offer_type_id = marketing_offer_type_id;
        this.employee_id = employee_id;
    }

    public void setMarketing_offer_type_id(int marketing_offer_type_id) {
        this.marketing_offer_type_id = marketing_offer_type_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public Offer(int marketingOfferId, String serviceName, String offerType, String stutus, String offer_sum, int marketing_offer_type_id, int employee_id) {
        this.marketingOfferId = marketingOfferId;
        this.serviceName = serviceName;
        this.offerType = offerType;
        this.stutus = stutus;
        this.offer_sum = offer_sum;
        this.marketing_offer_type_id = marketing_offer_type_id;
        this.employee_id = employee_id;
    }

    public void setMarketingOfferId(int marketingOfferId) {
        this.marketingOfferId = marketingOfferId;
    }

    public void setMarketing_offer_type_id(Integer marketing_offer_type_id) {
        this.marketing_offer_type_id = marketing_offer_type_id;
    }

    public Integer getMarketing_offer_type_id() {
        return marketing_offer_type_id;
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

    public void setStutus(String stutus) {
        this.stutus = stutus;
    }

    public void setOffer_sum(String offer_sum) {
        this.offer_sum = offer_sum;
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

    public String getStutus() {
        return stutus;
    }

    public String getOffer_sum() {
        return offer_sum;
    }

    public Offer(Integer marketingOfferId, String serviceName, String offerType, String stutus, String offer_sum, Integer marketing_offer_type_id) {
        this.marketingOfferId = marketingOfferId;
        this.serviceName = serviceName;
        this.offerType = offerType;
        this.stutus = stutus;
        this.offer_sum = offer_sum;
        this.marketing_offer_type_id = marketing_offer_type_id;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "marketingOfferId=" + marketingOfferId +
                ", serviceName='" + serviceName + '\'' +
                ", offerType='" + offerType + '\'' +
                ", stutus='" + stutus + '\'' +
                ", offer_sum='" + offer_sum + '\'' +
                '}';
    }

    public Offer(String serviceName, String offerType, String stutus, String offer_sum) {
        this.serviceName = serviceName;
        this.offerType = offerType;
        this.stutus = stutus;
        this.offer_sum = offer_sum;
    }
    public Offer(Integer marketingOfferId) {
        this.marketingOfferId = marketingOfferId;
    }
}
