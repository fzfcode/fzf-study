package com.fzf.study.infrastructure.db.mapper;

import com.fzf.study.infrastructure.db.po.ActivityPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: SunKe
 * @date: 2020/9/3 9:44 下午
 * @description: 活动Mapper
 */
public interface ActivityMapper {

    /**
     * 查询活动
     *
     * @param id 主键id
     * @return 活动信息
     */
    ActivityPO queryByPrimaryKey(long id);

    /**
     * 查询未过期的活动列表
     *
     * @param type   活动类型
     * @param status 活动状态
     * @return 活动列表
     */
    List<ActivityPO> queryUnexpiredActivities(@Param("type") int type,
                                              @Param("status") int status);

    /**
     * 创建活动
     *
     * @param activityPo 活动PO
     * @return 影响行数
     */
    int add(ActivityPO activityPo);

    /**
     * 更新活动
     * @param activityPo 活动PO
     * @return 影响行数
     */
    int update(ActivityPO activityPo);

    /**
     * 分页查询活动列表
     * @param type 活动类型
     * @param startIndex 取数据起点
     * @param size 数据数量
     * @return
     */
    List<ActivityPO> queryPageByType(@Param("type") int type,
                                     @Param("startIndex") Integer startIndex, @Param("size") Integer size);

    /**
     * 查询分类下活动数量
     * @param type 活动类型
     * @return 分类下活动数量
     */
    int countByType(@Param("type") int type);

    /**
     * 查询有效期内的活动列表
     * @param type 活动类型
     * @param status 活动状态
     * @return 活动列表
     */
    List<ActivityPO> queryUnderwayActivities(@Param("type") int type,
                                             @Param("status") int status);

    /**
     * 查询未过期的活动
     *
     * @param id     活动ID
     * @param type   活动类型
     * @param status 活动状态
     * @return 活动列表
     */
    ActivityPO queryUnexpiredActivitiesByPrimaryKey(
            @Param("primaryId") long id, @Param("type") int type,
            @Param("status") int status);


    /**
     * 查询活动状态
     * @param activityId
     * @return
     */
    int queryActivityStatus(@Param("activityId") Long activityId);

    /**
     * 查询状态有效的活动列表
     * @param type 活动类型
     * @param status 活动状态
     * @return 活动列表
     */
    List<ActivityPO> queryValidActivities(@Param("type") int type,
                                          @Param("status") int status);


    /**
     * 查询有效期内的活动
     * @param type 活动类型
     * @param status 活动状态
     * @return 活动信息
     */
    ActivityPO queryUnderwayActivity(@Param("type") int type,
                                     @Param("status") int status);


    /**
     * 查询活动 (单活动)
     * @param type 活动类型
     * @return 活动信息
     */
    ActivityPO queryActivityByType(@Param("type") int type);
}
