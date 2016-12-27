package vn.edu.uit.quanlybo.Network.Model;

/**
 * Created by PhucHuynh on 11/29/16.
 */

public class CreateCowRequest {

    private int userId;
    private int father;
    private int mother;
    private int typeId;
    private String nfcId;
    private String qrId;
    private String gender;
    private String birthday;
    private String target;
    private String isBorn;

    public CreateCowRequest(int userId, int typeId, String nfcId, String qrId, String gender, String birthday, String target, String isBorn) {
        this.userId = userId;
        this.typeId = typeId;
        this.nfcId = nfcId;
        this.qrId = qrId;
        this.gender = gender;
        this.birthday = birthday;
        this.target = target;
        this.isBorn = isBorn;
    }

    public CreateCowRequest(int userId, int father, int mother, int typeId, String nfcId, String qrId, String gender, String birthday, String target, String isBorn) {
        this.userId = userId;
        this.father = father;
        this.mother = mother;
        this.typeId = typeId;
        this.nfcId = nfcId;
        this.qrId = qrId;
        this.gender = gender;
        this.birthday = birthday;
        this.target = target;
        this.isBorn = isBorn;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFather() {
        return father;
    }

    public void setFather(int father) {
        this.father = father;
    }

    public int getMother() {
        return mother;
    }

    public void setMother(int mother) {
        this.mother = mother;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getNfcId() {
        return nfcId;
    }

    public void setNfcId(String nfcId) {
        this.nfcId = nfcId;
    }

    public String getQrId() {
        return qrId;
    }

    public void setQrId(String qrId) {
        this.qrId = qrId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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
}
