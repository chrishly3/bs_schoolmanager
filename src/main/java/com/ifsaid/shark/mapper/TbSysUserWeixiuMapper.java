package com.ifsaid.shark.mapper;

import com.ifsaid.shark.entity.TbSysUserEvaluate;
import com.ifsaid.shark.entity.TbSysUserWeixiu;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
@Repository
public interface TbSysUserWeixiuMapper {



    /**
     * 模糊查询报修单
     * @param repairUserName
     * @param repairType
     * @return
     */
    @Select("select * from tb_sys_user_weixiu "
            + "where repair_userName like #{repairUserName} and repair_type like #{repairType} and def = 0")
    List<TbSysUserWeixiu> selectOrderLike(@Param("repairUserName") String repairUserName, @Param("repairType") String repairType);

    /**
     * 查询所有保修单
     * @return
     */
    @Select("select * from tb_sys_user_weixiu where def =0")
    public List<TbSysUserWeixiu> listOrder();

    /**
     * 逻辑删除报修单
     * @param id
     * @return
     */
    @Update("UPDATE tb_sys_user_weixiu SET def = 1 WHERE id=#{id}")
    Integer removeById(String id);

    @Select("select * from tb_sys_user_weixiu "
            + "where repair_userName = #{loginUserName}and def = 0")
    List<TbSysUserWeixiu> getOrders(@Param("loginUserName") String loginUserName);

    @Insert("insert into tb_sys_user_evaluate(createuser_id,repairuser_id,msgtext,creattime,def,repair_id,star) values(#{createuserId},#{repairuserId},#{msgText},#{creattime},#{def},#{repairId},#{star})")
    Integer addEvalatedata(TbSysUserEvaluate tbSysUserEvaluate);


}
