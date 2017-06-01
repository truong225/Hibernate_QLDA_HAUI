package hibernate.entity;
// Generated Jun 1, 2017 11:03:26 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Users generated by hbm2java
 */
public class Users  implements java.io.Serializable {


     private Integer userId;
     private String userName;
     private String userPassword;
     private String userFullname;
     private String userDateofbirth;
     private String userGender;
     private String userFaculty;
     private String userDegree;
     private String userAvatar;
     private Boolean userActive;
     private String userAddress;
     private String userEmail;
     private String userMobile;
     private String userReligion;
     private Integer userType;
     private String userSubject;
     private String userDescription;
     private String userClass;
     private Integer userCountLogin;
     private Integer userNumDthd;
     private Integer userNumSvdhd;
     private Boolean isdelete;
     private String deleteDate;
     private Integer deleteUserid;
     private Integer userNv;
     private Set<Detai> detais = new HashSet<Detai>(0);

    public Users() {
    }

	
    public Users(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }
    public Users(String userName, String userPassword, String userFullname, String userDateofbirth, String userGender, String userFaculty, String userDegree, String userAvatar, Boolean userActive, String userAddress, String userEmail, String userMobile, String userReligion, Integer userType, String userSubject, String userDescription, String userClass, Integer userCountLogin, Integer userNumDthd, Integer userNumSvdhd, Boolean isdelete, String deleteDate, Integer deleteUserid, Integer userNv, Set<Detai> detais) {
       this.userName = userName;
       this.userPassword = userPassword;
       this.userFullname = userFullname;
       this.userDateofbirth = userDateofbirth;
       this.userGender = userGender;
       this.userFaculty = userFaculty;
       this.userDegree = userDegree;
       this.userAvatar = userAvatar;
       this.userActive = userActive;
       this.userAddress = userAddress;
       this.userEmail = userEmail;
       this.userMobile = userMobile;
       this.userReligion = userReligion;
       this.userType = userType;
       this.userSubject = userSubject;
       this.userDescription = userDescription;
       this.userClass = userClass;
       this.userCountLogin = userCountLogin;
       this.userNumDthd = userNumDthd;
       this.userNumSvdhd = userNumSvdhd;
       this.isdelete = isdelete;
       this.deleteDate = deleteDate;
       this.deleteUserid = deleteUserid;
       this.userNv = userNv;
       this.detais = detais;
    }
   
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPassword() {
        return this.userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getUserFullname() {
        return this.userFullname;
    }
    
    public void setUserFullname(String userFullname) {
        this.userFullname = userFullname;
    }
    public String getUserDateofbirth() {
        return this.userDateofbirth;
    }
    
    public void setUserDateofbirth(String userDateofbirth) {
        this.userDateofbirth = userDateofbirth;
    }
    public String getUserGender() {
        return this.userGender;
    }
    
    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }
    public String getUserFaculty() {
        return this.userFaculty;
    }
    
    public void setUserFaculty(String userFaculty) {
        this.userFaculty = userFaculty;
    }
    public String getUserDegree() {
        return this.userDegree;
    }
    
    public void setUserDegree(String userDegree) {
        this.userDegree = userDegree;
    }
    public String getUserAvatar() {
        return this.userAvatar;
    }
    
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }
    public Boolean getUserActive() {
        return this.userActive;
    }
    
    public void setUserActive(Boolean userActive) {
        this.userActive = userActive;
    }
    public String getUserAddress() {
        return this.userAddress;
    }
    
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
    public String getUserEmail() {
        return this.userEmail;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserMobile() {
        return this.userMobile;
    }
    
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }
    public String getUserReligion() {
        return this.userReligion;
    }
    
    public void setUserReligion(String userReligion) {
        this.userReligion = userReligion;
    }
    public Integer getUserType() {
        return this.userType;
    }
    
    public void setUserType(Integer userType) {
        this.userType = userType;
    }
    public String getUserSubject() {
        return this.userSubject;
    }
    
    public void setUserSubject(String userSubject) {
        this.userSubject = userSubject;
    }
    public String getUserDescription() {
        return this.userDescription;
    }
    
    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }
    public String getUserClass() {
        return this.userClass;
    }
    
    public void setUserClass(String userClass) {
        this.userClass = userClass;
    }
    public Integer getUserCountLogin() {
        return this.userCountLogin;
    }
    
    public void setUserCountLogin(Integer userCountLogin) {
        this.userCountLogin = userCountLogin;
    }
    public Integer getUserNumDthd() {
        return this.userNumDthd;
    }
    
    public void setUserNumDthd(Integer userNumDthd) {
        this.userNumDthd = userNumDthd;
    }
    public Integer getUserNumSvdhd() {
        return this.userNumSvdhd;
    }
    
    public void setUserNumSvdhd(Integer userNumSvdhd) {
        this.userNumSvdhd = userNumSvdhd;
    }
    public Boolean getIsdelete() {
        return this.isdelete;
    }
    
    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
    public String getDeleteDate() {
        return this.deleteDate;
    }
    
    public void setDeleteDate(String deleteDate) {
        this.deleteDate = deleteDate;
    }
    public Integer getDeleteUserid() {
        return this.deleteUserid;
    }
    
    public void setDeleteUserid(Integer deleteUserid) {
        this.deleteUserid = deleteUserid;
    }
    public Integer getUserNv() {
        return this.userNv;
    }
    
    public void setUserNv(Integer userNv) {
        this.userNv = userNv;
    }
    public Set<Detai> getDetais() {
        return this.detais;
    }
    
    public void setDetais(Set<Detai> detais) {
        this.detais = detais;
    }




}


