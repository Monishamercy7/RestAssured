package com.crm.POJOClass;

public class Project {
	
//	Create global variables for all the keys
	String createdBy;
	String projectName;
	String status;
	int teamSize;
	
//	Create a parameterized Constructor
	public Project(String createdBy, String projectName, String status, int teamSize)
	{
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.status = status;
		this.teamSize = teamSize;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}
	public String getprojectName() {
		return projectName;
	}
	public void setprojectName(String projectName)
	{
		this.projectName = projectName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize)
	{
		this.teamSize = teamSize;
	}
	
	

}
