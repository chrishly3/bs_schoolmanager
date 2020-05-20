package com.ifsaid.shark.entity;


import com.ifsaid.shark.common.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_sys_user_weixiu")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TbSysUserWeixiu extends BaseEntity implements java.io.Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  /**
   * 维修员code
   */
  private String userId;
  /**
   * 创建人学生code
   */
  private String createPerson;
  /**
   * 维修原因
   */
  private String weixiuMsg;

  /**
   * 创建时间
   */
//  private java.sql.Timestamp createTime;
  /**
   * 维修状态
   */
  private long weixiuStatus;
  /**
   * 逻辑删除
   */
  private long defDe;



}
