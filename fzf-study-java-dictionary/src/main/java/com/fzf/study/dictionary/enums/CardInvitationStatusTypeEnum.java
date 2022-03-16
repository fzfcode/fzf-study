package com.fzf.study.dictionary.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: HouGang
 * @date: 2020-09-15 10:59:09
 * @description: 邀请办卡卡片状态列表
 * @version: v1.0
 */
@Getter
public enum CardInvitationStatusTypeEnum {

    /**
     * 不区分状态
     */
    ALL("0000", "不区分状态查询"),
    /**
     * 审批通过的被邀请卡片
     */
    ACCEPTED("1001", "已通过"),
    /**
     * 审批未通过的被邀请卡片
     */
    REJECTED("1002", "未通过"),
    /**
     * 审批已激活的被邀请卡片
     */
    ACTIVATED("2001", "已激活"),
    /**
     * 审批未激活的被邀请卡片
     */
    NOT_ACTIVATED("2002", "未激活");

    private String code;
    private String desc;

    private static final Map<String, List<CardInvitationStatusEnum>> MAP = new HashMap<>(128);

    public static final Map<String, CardInvitationStatusTypeEnum> MAPTYPE = new HashMap<>();

    static {
        //不区分状态
        MAP.put(CardInvitationStatusTypeEnum.ALL.code, Arrays.asList(
                CardInvitationStatusEnum.EXT_INFO_COMMIT,
                CardInvitationStatusEnum.APS_ACCEPTED,
                CardInvitationStatusEnum.APS_REJECTED,
                CardInvitationStatusEnum.CARD_ACTIVATED
        ));

        //审批通过状态列表
        MAP.put(CardInvitationStatusTypeEnum.ACCEPTED.code, Arrays.asList(
                CardInvitationStatusEnum.APS_ACCEPTED,
                CardInvitationStatusEnum.CARD_ACTIVATED
        ));

        //审批未通过的被邀请卡片
        MAP.put(CardInvitationStatusTypeEnum.REJECTED.code, Arrays.asList(
                CardInvitationStatusEnum.APS_REJECTED
        ));

        //审批已激活的被邀请卡片
        MAP.put(CardInvitationStatusTypeEnum.ACTIVATED.code, Arrays.asList(
                CardInvitationStatusEnum.CARD_ACTIVATED
        ));

        //审批未激活的被邀请卡片
        MAP.put(CardInvitationStatusTypeEnum.NOT_ACTIVATED.code, Arrays.asList(
                CardInvitationStatusEnum.APS_ACCEPTED
        ));

        for (CardInvitationStatusTypeEnum type : values()) {
            MAPTYPE.put(type.getCode(), type);
        }
    }

    CardInvitationStatusTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static CardInvitationStatusTypeEnum getSearchTypeByCode(String value) {
        return MAPTYPE.get(value);
    }

    public static List<CardInvitationStatusEnum> getCardInvitationStatusList(CardInvitationStatusTypeEnum cardInvitationStatusTypeEnum) {
        return MAP.get(cardInvitationStatusTypeEnum.code);
    }
}
