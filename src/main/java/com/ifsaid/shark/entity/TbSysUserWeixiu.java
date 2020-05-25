package com.ifsaid.shark.entity;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;

@EntityScan
@Entity
@Data
public class TbSysUserWeixiu {

  private long id;
  private String user_Id;
  private String repair_UserName;
  private String repair_Message;
  private java.sql.Timestamp create_Time;
  private long repair_Status;
  private long def;
  private String repair_Type;
  private String repair_Doornum;




}
