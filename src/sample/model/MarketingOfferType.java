package sample.model;

public class MarketingOfferType {
    private int marketingOfferTypeId;
    private String marketingOfferTypeName;

    @Override
    public String toString() {
        return marketingOfferTypeName;
    }

    public int getMarketingOfferTypeId() {
        return marketingOfferTypeId;
    }

    public void setMarketingOfferTypeId(int marketingOfferTypeId) {
        this.marketingOfferTypeId = marketingOfferTypeId;
    }

    public String getMarketingOfferTypeName() {
        return marketingOfferTypeName;
    }

    public void setMarketingOfferTypeName(String marketingOfferTypeName) {
        this.marketingOfferTypeName = marketingOfferTypeName;
    }

    public MarketingOfferType(int marketingOfferTypeId, String marketingOfferTypeName) {
        this.marketingOfferTypeId = marketingOfferTypeId;
        this.marketingOfferTypeName = marketingOfferTypeName;
    }
}
