package vn.edu.uit.quanlybo.Model;

/**
 * Created by phuc9 on 10/28/2016.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Cow implements Serializable{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("father")
    @Expose
    private String father;
    @SerializedName("mother")
    @Expose
    private String mother;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("typeId")
    @Expose
    private String typeId;
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
    private String price;
    @SerializedName("market_code")
    @Expose
    private String marketCode;
    @SerializedName("dateCreated")
    @Expose
    private String dateCreated;
    @SerializedName("dateUpdated")
    @Expose
    private String dateUpdated;
    @SerializedName("type_name")
    @Expose
    private String typeName;
    @SerializedName("target_name")
    @Expose
    private String targetName;
    @SerializedName("gender_name")
    @Expose
    private String genderName;
    @SerializedName("source_name")
    @Expose
    private String sourceName;
    @SerializedName("day_old")
    @Expose
    private Integer dayOld;

    public Cow(String id, String father, String mother, String userId, String typeId, String qrId, String nfcId, String birthday, String gender, String target, String isBorn, String price, String marketCode, String dateCreated, String dateUpdated, String typeName, String targetName, String genderName, String sourceName, Integer dayOld) {
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
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.typeName = typeName;
        this.targetName = targetName;
        this.genderName = genderName;
        this.sourceName = sourceName;
        this.dayOld = dayOld;
    }

    public Cow() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public Integer getDayOld() {
        return dayOld;
    }

    public void setDayOld(Integer dayOld) {
        this.dayOld = dayOld;
    }
}