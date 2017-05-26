package hibernate.entity;
// Generated May 4, 2017 2:32:41 PM by Hibernate Tools 4.3.1



/**
 * Comments generated by hbm2java
 */
public class Comments  implements java.io.Serializable {


     private Integer commentId;
     private Tiendo tiendo;
     private String commentContent;
     private String commentCreatedate;
     private String commentLastmodified;
     private Boolean commentStatus;
     private Boolean commentIsread;
     private int userId;
     private Boolean isdelete;
     private String deleteDate;
     private Integer deleteUserid;

    public Comments() {
    }

	
    public Comments(Tiendo tiendo, int userId) {
        this.tiendo = tiendo;
        this.userId = userId;
    }
    public Comments(Tiendo tiendo, String commentContent, String commentCreatedate, String commentLastmodified, Boolean commentStatus, Boolean commentIsread, int userId, Boolean isdelete, String deleteDate, Integer deleteUserid) {
       this.tiendo = tiendo;
       this.commentContent = commentContent;
       this.commentCreatedate = commentCreatedate;
       this.commentLastmodified = commentLastmodified;
       this.commentStatus = commentStatus;
       this.commentIsread = commentIsread;
       this.userId = userId;
       this.isdelete = isdelete;
       this.deleteDate = deleteDate;
       this.deleteUserid = deleteUserid;
    }
   
    public Integer getCommentId() {
        return this.commentId;
    }
    
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
    public Tiendo getTiendo() {
        return this.tiendo;
    }
    
    public void setTiendo(Tiendo tiendo) {
        this.tiendo = tiendo;
    }
    public String getCommentContent() {
        return this.commentContent;
    }
    
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
    public String getCommentCreatedate() {
        return this.commentCreatedate;
    }
    
    public void setCommentCreatedate(String commentCreatedate) {
        this.commentCreatedate = commentCreatedate;
    }
    public String getCommentLastmodified() {
        return this.commentLastmodified;
    }
    
    public void setCommentLastmodified(String commentLastmodified) {
        this.commentLastmodified = commentLastmodified;
    }
    public Boolean getCommentStatus() {
        return this.commentStatus;
    }
    
    public void setCommentStatus(Boolean commentStatus) {
        this.commentStatus = commentStatus;
    }
    public Boolean getCommentIsread() {
        return this.commentIsread;
    }
    
    public void setCommentIsread(Boolean commentIsread) {
        this.commentIsread = commentIsread;
    }
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
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




}


