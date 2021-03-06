package de.kaiwidmaier.suggestamovie.data;

import com.google.gson.annotations.SerializedName;

public class CrewMember {

  @SerializedName("credit_id")
  private String creditId;
  @SerializedName("department")
  private String department;
  @SerializedName("job")
  private String job;
  @SerializedName("name")
  private String name;
  @SerializedName("profile_path")
  private String profilePath;

  public String getCreditId() {
    return creditId;
  }

  public void setCreditId(String creditId) {
    this.creditId = creditId;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getProfilePath() {
    return profilePath;
  }

  public void setProfilePath(String profilePath) {
    this.profilePath = profilePath;
  }
}
