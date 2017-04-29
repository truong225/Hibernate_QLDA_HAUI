package hibernate.entity;
// Generated Apr 24, 2017 1:01:57 PM by Hibernate Tools 4.3.1



/**
 * Detai generated by hbm2java
 */
public class Detai  implements java.io.Serializable {


     private Integer projectId;
     private String projectName;
     private String projectContentlink;
     private Integer projectAuthorid;
     private int projectInstructorid;
     private Integer projectProgress;
     private String projectStartdate;
     private Boolean projectStatus;
     private String projectDescription;
     private Integer projectViewcount;
     private Integer projectPagecount;
     private Boolean projectCancel;

    public Detai() {
    }

	
    public Detai(int projectInstructorid) {
        this.projectInstructorid = projectInstructorid;
    }
    public Detai(String projectName, String projectContentlink, Integer projectAuthorid, int projectInstructorid, Integer projectProgress, String projectStartdate, Boolean projectStatus, String projectDescription, Integer projectViewcount, Integer projectPagecount, Boolean projectCancel) {
       this.projectName = projectName;
       this.projectContentlink = projectContentlink;
       this.projectAuthorid = projectAuthorid;
       this.projectInstructorid = projectInstructorid;
       this.projectProgress = projectProgress;
       this.projectStartdate = projectStartdate;
       this.projectStatus = projectStatus;
       this.projectDescription = projectDescription;
       this.projectViewcount = projectViewcount;
       this.projectPagecount = projectPagecount;
       this.projectCancel = projectCancel;
    }
   
    public Integer getProjectId() {
        return this.projectId;
    }
    
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
    public String getProjectName() {
        return this.projectName;
    }
    
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public String getProjectContentlink() {
        return this.projectContentlink;
    }
    
    public void setProjectContentlink(String projectContentlink) {
        this.projectContentlink = projectContentlink;
    }
    public Integer getProjectAuthorid() {
        return this.projectAuthorid;
    }
    
    public void setProjectAuthorid(Integer projectAuthorid) {
        this.projectAuthorid = projectAuthorid;
    }
    public int getProjectInstructorid() {
        return this.projectInstructorid;
    }
    
    public void setProjectInstructorid(int projectInstructorid) {
        this.projectInstructorid = projectInstructorid;
    }
    public Integer getProjectProgress() {
        return this.projectProgress;
    }
    
    public void setProjectProgress(Integer projectProgress) {
        this.projectProgress = projectProgress;
    }
    public String getProjectStartdate() {
        return this.projectStartdate;
    }
    
    public void setProjectStartdate(String projectStartdate) {
        this.projectStartdate = projectStartdate;
    }
    public Boolean getProjectStatus() {
        return this.projectStatus;
    }
    
    public void setProjectStatus(Boolean projectStatus) {
        this.projectStatus = projectStatus;
    }
    public String getProjectDescription() {
        return this.projectDescription;
    }
    
    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }
    public Integer getProjectViewcount() {
        return this.projectViewcount;
    }
    
    public void setProjectViewcount(Integer projectViewcount) {
        this.projectViewcount = projectViewcount;
    }
    public Integer getProjectPagecount() {
        return this.projectPagecount;
    }
    
    public void setProjectPagecount(Integer projectPagecount) {
        this.projectPagecount = projectPagecount;
    }
    public Boolean getProjectCancel() {
        return this.projectCancel;
    }
    
    public void setProjectCancel(Boolean projectCancel) {
        this.projectCancel = projectCancel;
    }




}

