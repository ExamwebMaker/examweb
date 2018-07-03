package com.examweb.group.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/3
 */
@Data
@NoArgsConstructor
public class Examinee extends Model<Examinee>{
    private String id;
    private String examWay;
    private String zhaoShengUnit;
    private String specialPlan;
    private String name;
    private String nameSpell;
    private String nowSolier;
    private String nation;
    private String sex;
    private String marrige;
    private String policy;
    private String connectAddress;
    private String connectPostalcode;
    private String nativePlace;
    private String huKouPlace;
    private String huKouDetail;
    private String birthPlace;
    private String nowStudyOrWorkUnit;
    private String filePlace;
    private String fileUnitName;
    private String fileUnitAddress;
    private String fileUnitPostalcode;
    private String certificateStyle;
    private String certificateNumber;
    private String rewardAndPunishment;
    private String account_id;
    private String wantDepartmentName;
    private String wantMajorName;
    private String examSubject;
    private String learnWay;
    private String researchWay;
    private String examPointName;
    private String examPointAddress;
    @JsonIgnore
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updateTime;
    @JsonIgnore
    private String isDelete;
    @JsonIgnore
    private String isCheck;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExamWay() {
        return examWay;
    }

    public void setExamWay(String examWay) {
        this.examWay = examWay;
    }

    public String getZhaoShengUnit() {
        return zhaoShengUnit;
    }

    public void setZhaoShengUnit(String zhaoShengUnit) {
        this.zhaoShengUnit = zhaoShengUnit;
    }

    public String getSpecialPlan() {
        return specialPlan;
    }

    public void setSpecialPlan(String specialPlan) {
        this.specialPlan = specialPlan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameSpell() {
        return nameSpell;
    }

    public void setNameSpell(String nameSpell) {
        this.nameSpell = nameSpell;
    }

    public String getNowSolier() {
        return nowSolier;
    }

    public void setNowSolier(String nowSolier) {
        this.nowSolier = nowSolier;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMarrige() {
        return marrige;
    }

    public void setMarrige(String marrige) {
        this.marrige = marrige;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getConnectAddress() {
        return connectAddress;
    }

    public void setConnectAddress(String connectAddress) {
        this.connectAddress = connectAddress;
    }

    public String getConnectPostalcode() {
        return connectPostalcode;
    }

    public void setConnectPostalcode(String connectPostalcode) {
        this.connectPostalcode = connectPostalcode;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getHuKouPlace() {
        return huKouPlace;
    }

    public void setHuKouPlace(String huKouPlace) {
        this.huKouPlace = huKouPlace;
    }

    public String getHuKouDetail() {
        return huKouDetail;
    }

    public void setHuKouDetail(String huKouDetail) {
        this.huKouDetail = huKouDetail;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getNowStudyOrWorkUnit() {
        return nowStudyOrWorkUnit;
    }

    public void setNowStudyOrWorkUnit(String nowStudyOrWorkUnit) {
        this.nowStudyOrWorkUnit = nowStudyOrWorkUnit;
    }

    public String getFilePlace() {
        return filePlace;
    }

    public void setFilePlace(String filePlace) {
        this.filePlace = filePlace;
    }

    public String getFileUnitName() {
        return fileUnitName;
    }

    public void setFileUnitName(String fileUnitName) {
        this.fileUnitName = fileUnitName;
    }

    public String getFileUnitAddress() {
        return fileUnitAddress;
    }

    public void setFileUnitAddress(String fileUnitAddress) {
        this.fileUnitAddress = fileUnitAddress;
    }

    public String getFileUnitPostalcode() {
        return fileUnitPostalcode;
    }

    public void setFileUnitPostalcode(String fileUnitPostalcode) {
        this.fileUnitPostalcode = fileUnitPostalcode;
    }

    public String getCertificateStyle() {
        return certificateStyle;
    }

    public void setCertificateStyle(String certificateStyle) {
        this.certificateStyle = certificateStyle;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getRewardAndPunishment() {
        return rewardAndPunishment;
    }

    public void setRewardAndPunishment(String rewardAndPunishment) {
        this.rewardAndPunishment = rewardAndPunishment;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getWantDepartmentName() {
        return wantDepartmentName;
    }

    public void setWantDepartmentName(String wantDepartmentName) {
        this.wantDepartmentName = wantDepartmentName;
    }

    public String getWantMajorName() {
        return wantMajorName;
    }

    public void setWantMajorName(String wantMajorName) {
        this.wantMajorName = wantMajorName;
    }

    public String getExamSubject() {
        return examSubject;
    }

    public void setExamSubject(String examSubject) {
        this.examSubject = examSubject;
    }

    public String getLearnWay() {
        return learnWay;
    }

    public void setLearnWay(String learnWay) {
        this.learnWay = learnWay;
    }

    public String getResearchWay() {
        return researchWay;
    }

    public void setResearchWay(String researchWay) {
        this.researchWay = researchWay;
    }

    public String getExamPointName() {
        return examPointName;
    }

    public void setExamPointName(String examPointName) {
        this.examPointName = examPointName;
    }

    public String getExamPointAddress() {
        return examPointAddress;
    }

    public void setExamPointAddress(String examPointAddress) {
        this.examPointAddress = examPointAddress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(String isCheck) {
        this.isCheck = isCheck;
    }

    @Override
    public String toString() {
        return "Examinee{" +
                "id='" + id + '\'' +
                ", examWay='" + examWay + '\'' +
                ", zhaoShengUnit='" + zhaoShengUnit + '\'' +
                ", specialPlan='" + specialPlan + '\'' +
                ", name='" + name + '\'' +
                ", nameSpell='" + nameSpell + '\'' +
                ", nowSolier='" + nowSolier + '\'' +
                ", nation='" + nation + '\'' +
                ", sex='" + sex + '\'' +
                ", marrige='" + marrige + '\'' +
                ", policy='" + policy + '\'' +
                ", connectAddress='" + connectAddress + '\'' +
                ", connectPostalcode='" + connectPostalcode + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", huKouPlace='" + huKouPlace + '\'' +
                ", huKouDetail='" + huKouDetail + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", nowStudyOrWorkUnit='" + nowStudyOrWorkUnit + '\'' +
                ", filePlace='" + filePlace + '\'' +
                ", fileUnitName='" + fileUnitName + '\'' +
                ", fileUnitAddress='" + fileUnitAddress + '\'' +
                ", fileUnitPostalcode='" + fileUnitPostalcode + '\'' +
                ", certificateStyle='" + certificateStyle + '\'' +
                ", certificateNumber='" + certificateNumber + '\'' +
                ", rewardAndPunishment='" + rewardAndPunishment + '\'' +
                ", account_id='" + account_id + '\'' +
                ", wantDepartmentName='" + wantDepartmentName + '\'' +
                ", wantMajorName='" + wantMajorName + '\'' +
                ", examSubject='" + examSubject + '\'' +
                ", learnWay='" + learnWay + '\'' +
                ", researchWay='" + researchWay + '\'' +
                ", examPointName='" + examPointName + '\'' +
                ", examPointAddress='" + examPointAddress + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete='" + isDelete + '\'' +
                ", isCheck='" + isCheck + '\'' +
                '}';
    }

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
