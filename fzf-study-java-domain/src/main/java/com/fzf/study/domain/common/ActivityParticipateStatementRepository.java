package com.fzf.study.domain.common;


import com.fzf.study.dictionary.enums.ActivityParticipateStatusEnum;

/**
 * 活动参与状态Repository
 * @author sunke04
 */
public interface ActivityParticipateStatementRepository {

    /**
     * 保存活动参与状态
     * @param participateStatement 活动参与状态
     * @return id
     */
    long add(ActivityParticipateStatement participateStatement);

    /**
     * CAS更新活动参与状态
     * @param participateChannel 参与渠道
     * @param requestId 请求id
     * @param expectStatus 预期当期status
     * @param updateStatus 待更新status
     * @return 是否更新成功
     */
    boolean compareAndSet(String participateChannel, String requestId,
                          ActivityParticipateStatusEnum expectStatus, ActivityParticipateStatusEnum updateStatus);
}
