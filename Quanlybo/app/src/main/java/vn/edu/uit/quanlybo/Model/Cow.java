package vn.edu.uit.quanlybo.Model;

/**
 * Created by phuc9 on 10/28/2016.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Cow {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("father")
    @Expose
    private Integer father;
    @SerializedName("mother")
    @Expose
    private Integer mother;
    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("typeId")
    @Expose
    private Integer typeId;
    @SerializedName("qrId")
    @Expose
    private String qrId;
    @SerializedName("nfcId")
    @Expose
    private String nfcId;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("target")
    @Expose
    private String target;
    @SerializedName("isBorn")
    @Expose
    private String isBorn;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("market_code")
    @Expose
    private Integer marketCode;
    @SerializedName("dateCreated")
    @Expose
    private Date dateCreated;
    @SerializedName("dateUpdated")
    @Expose
    private Date dateUpdated;

    public Cow(Integer id, Integer father, Integer mother, Integer userId, Integer typeId, String qrId, String nfcId, String birthday, String gender, String target, String isBorn, Integer price, Integer marketCode) {
        this.id = id;
        this.father = father;
        this.mother = mother;
        this.userId = userId;
        this.typeId = typeId;
        this.qrId = qrId;
        this.nfcId = nfcId;
        this.birthday = birthday;
        this.gender = gender;
        this.target = target;
        this.isBorn = isBorn;
        this.price = price;
        this.marketCode = marketCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFather() {
        return father;
    }

    public void setFather(Integer father) {
        this.father = father;
    }

    public Integer getMother() {
        return mother;
    }

    public void setMother(Integer mother) {
        this.mother = mother;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getQrId() {
        return qrId;
    }

    public void setQrId(String qrId) {
        this.qrId = qrId;
    }

    public String getNfcId() {
        return nfcId;
    }

    public void setNfcId(String nfcId) {
        this.nfcId = nfcId;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getIsBorn() {
        return isBorn;
    }

    public void setIsBorn(String isBorn) {
        this.isBorn = isBorn;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(Integer marketCode) {
        this.marketCode = marketCode;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "id=" + id +
                ", father=" + father +
                ", mother=" + mother +
                ", userId=" + userId +
                ", typeId=" + typeId +
                ", qrId='" + qrId + '\'' +
                ", nfcId='" + nfcId + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", target='" + target + '\'' +
                ", isBorn='" + isBorn + '\'' +
                ", price=" + price +
                ", marketCode=" + marketCode +
                ", dateCreated=" + dateCreated +
                ", dateUpdated=" + dateUpdated +
                '}';
    }
}