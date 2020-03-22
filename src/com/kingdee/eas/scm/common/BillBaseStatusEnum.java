/**
 * output package name
 */
package com.kingdee.eas.scm.common;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class BillBaseStatusEnum extends IntEnum
{
    public static final int NULL_VALUE = -1;//alias=
    public static final int ADD_VALUE = 0;//alias=新增
    public static final int TEMPORARILYSAVED_VALUE = 1;//alias=保存
    public static final int SUBMITED_VALUE = 2;//alias=提交
    public static final int DELETED_VALUE = 3;//alias=作废
    public static final int AUDITED_VALUE = 4;//alias=审核
    public static final int RELEASED_VALUE = 5;//alias=下达
    public static final int BLOCKED_VALUE = 6;//alias=冻结
    public static final int CLOSED_VALUE = 7;//alias=关闭
    public static final int COMPLETE_VALUE = 8;//alias=完工
    public static final int FINISH_VALUE = 90;//alias=完成
    public static final int PUBLISHED_VALUE = 10;//alias=发布
    public static final int FINCLOSED_VALUE = 11;//alias=结案
    public static final int ALTERING_VALUE = -2;//alias=变更中
    public static final int VERSION_VALUE = -3;//alias=历史版本
    public static final int ALREADYTURN_VALUE = 12;//alias=已转
    public static final int EDITED_VALUE = 13;//alias=修改完毕
    public static final int REVIEW_VALUE = 14;//alias=评审中
    public static final int REVIEWCOMPLETE_VALUE = 15;//alias=评审完毕
    public static final int AFFIRM_VALUE = 16;//alias=确认
    public static final int DISPOSEING_VALUE = 17;//alias=处理中
    public static final int OPER_VALUE = 18;//alias=开工
    public static final int CANCELCANCEL_VALUE = 201;//alias=启用
    public static final int CANCEL_VALUE = 202;//alias=禁用

    public static final BillBaseStatusEnum NULL = new BillBaseStatusEnum("NULL", NULL_VALUE);
    public static final BillBaseStatusEnum ADD = new BillBaseStatusEnum("ADD", ADD_VALUE);
    public static final BillBaseStatusEnum TEMPORARILYSAVED = new BillBaseStatusEnum("TEMPORARILYSAVED", TEMPORARILYSAVED_VALUE);
    public static final BillBaseStatusEnum SUBMITED = new BillBaseStatusEnum("SUBMITED", SUBMITED_VALUE);
    public static final BillBaseStatusEnum DELETED = new BillBaseStatusEnum("DELETED", DELETED_VALUE);
    public static final BillBaseStatusEnum AUDITED = new BillBaseStatusEnum("AUDITED", AUDITED_VALUE);
    public static final BillBaseStatusEnum RELEASED = new BillBaseStatusEnum("RELEASED", RELEASED_VALUE);
    public static final BillBaseStatusEnum BLOCKED = new BillBaseStatusEnum("BLOCKED", BLOCKED_VALUE);
    public static final BillBaseStatusEnum CLOSED = new BillBaseStatusEnum("CLOSED", CLOSED_VALUE);
    public static final BillBaseStatusEnum COMPLETE = new BillBaseStatusEnum("COMPLETE", COMPLETE_VALUE);
    public static final BillBaseStatusEnum FINISH = new BillBaseStatusEnum("FINISH", FINISH_VALUE);
    public static final BillBaseStatusEnum PUBLISHED = new BillBaseStatusEnum("PUBLISHED", PUBLISHED_VALUE);
    public static final BillBaseStatusEnum FINCLOSED = new BillBaseStatusEnum("FINCLOSED", FINCLOSED_VALUE);
    public static final BillBaseStatusEnum ALTERING = new BillBaseStatusEnum("ALTERING", ALTERING_VALUE);
    public static final BillBaseStatusEnum VERSION = new BillBaseStatusEnum("VERSION", VERSION_VALUE);
    public static final BillBaseStatusEnum ALREADYTURN = new BillBaseStatusEnum("ALREADYTURN", ALREADYTURN_VALUE);
    public static final BillBaseStatusEnum EDITED = new BillBaseStatusEnum("EDITED", EDITED_VALUE);
    public static final BillBaseStatusEnum REVIEW = new BillBaseStatusEnum("REVIEW", REVIEW_VALUE);
    public static final BillBaseStatusEnum REVIEWCOMPLETE = new BillBaseStatusEnum("REVIEWCOMPLETE", REVIEWCOMPLETE_VALUE);
    public static final BillBaseStatusEnum AFFIRM = new BillBaseStatusEnum("AFFIRM", AFFIRM_VALUE);
    public static final BillBaseStatusEnum DISPOSEING = new BillBaseStatusEnum("DISPOSEING", DISPOSEING_VALUE);
    public static final BillBaseStatusEnum OPER = new BillBaseStatusEnum("OPER", OPER_VALUE);
    public static final BillBaseStatusEnum cancelcancel = new BillBaseStatusEnum("cancelcancel", CANCELCANCEL_VALUE);
    public static final BillBaseStatusEnum cancel = new BillBaseStatusEnum("cancel", CANCEL_VALUE);

    /**
     * construct function
     * @param integer billBaseStatusEnum
     */
    private BillBaseStatusEnum(String name, int billBaseStatusEnum)
    {
        super(name, billBaseStatusEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static BillBaseStatusEnum getEnum(String billBaseStatusEnum)
    {
        return (BillBaseStatusEnum)getEnum(BillBaseStatusEnum.class, billBaseStatusEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static BillBaseStatusEnum getEnum(int billBaseStatusEnum)
    {
        return (BillBaseStatusEnum)getEnum(BillBaseStatusEnum.class, billBaseStatusEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(BillBaseStatusEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(BillBaseStatusEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(BillBaseStatusEnum.class);
    }
}