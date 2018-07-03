package com.examweb.group.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/2
 */
@Data
@NoArgsConstructor
public class Account extends Model<Account>{

    //@TableId(type= IdType.AUTO)
    private String id;
    @NotBlank(message = "姓名不能为空")
    private String name;
    @NotBlank(message = "电话号码不能为空")
    private String phone;
    private String email;
    private String password;
    private String certificateStyle;
    private String certificateNumber;

    @JsonIgnore
    private String AccountStyle;
    @JsonIgnore
    private String isDelete;
    @JsonIgnore
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAccountStyle() {
        return AccountStyle;
    }

    public void setAccountStyle(String accountStyle) {
        AccountStyle = accountStyle;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
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

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", certificateStyle='" + certificateStyle + '\'' +
                ", certificateNumber='" + certificateNumber + '\'' +
                ", AccountStyle='" + AccountStyle + '\'' +
                ", isDelete='" + isDelete + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
