package sample.model;

public class Offer {
    private int customer_id;
    private String service_name;
    private String offer_type;
    private String stutus;
    private String offer_sum;

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public void setOffer_type(String offer_type) {
        this.offer_type = offer_type;
    }

    public void setStutus(String stutus) {
        this.stutus = stutus;
    }

    public void setOffer_sum(String offer_sum) {
        this.offer_sum = offer_sum;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public String getService_name() {
        return service_name;
    }

    public String getOffer_type() {
        return offer_type;
    }

    public String getStutus() {
        return stutus;
    }

    public String getOffer_sum() {
        return offer_sum;
    }

    public Offer(Integer customer_id, String service_name, String offer_type, String stutus, String offer_sum) {
        this.customer_id = customer_id;
        this.service_name = service_name;
        this.offer_type = offer_type;
        this.stutus = stutus;
        this.offer_sum = offer_sum;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "customer_id=" + customer_id +
                ", service_name='" + service_name + '\'' +
                ", offer_type='" + offer_type + '\'' +
                ", stutus='" + stutus + '\'' +
                ", offer_sum='" + offer_sum + '\'' +
                '}';
    }

    public Offer(String service_name, String offer_type, String stutus, String offer_sum) {
        this.service_name = service_name;
        this.offer_type = offer_type;
        this.stutus = stutus;
        this.offer_sum = offer_sum;
    }
}
