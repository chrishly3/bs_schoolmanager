package com.ifsaid.shark.entity;


public class TbSysUserEvaluate {

  private long id;
  private String createuserId;
  private String repairuserId;
  private String msgText;
  private java.sql.Timestamp creattime;
  private long def;
  private long repairId;
  private long star;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCreateuserId() {
    return createuserId;
  }

  public void setCreateuserId(String createuserId) {
    this.createuserId = createuserId;
  }


  public String getRepairuserId() {
    return repairuserId;
  }

  public void setRepairuserId(String repairuserId) {
    this.repairuserId = repairuserId;
  }


  public String getMsgText() {
    return msgText;
  }

  public void setMsgText(String msgText) {
    this.msgText = msgText;
  }


  public java.sql.Timestamp getCreattime() {
    return creattime;
  }

  public void setCreattime(java.sql.Timestamp creattime) {
    this.creattime = creattime;
  }


  public long getDef() {
    return def;
  }

  public void setDef(long def) {
    this.def = def;
  }


  public long getRepairId() {
    return repairId;
  }

  public void setRepairId(long repairId) {
    this.repairId = repairId;
  }

  public long getStar() {
    return star;
  }

  public void setStar(long star) {
    this.star = star;
  }



}
