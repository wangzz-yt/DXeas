package com.kingdee.eas.custom.taihe.weight.app;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.taihe.weight.CarSendBillFactory;
import com.kingdee.eas.custom.taihe.weight.CarSendBillInfo;
import com.kingdee.eas.custom.taihe.weight.CarcassEntryInfo;
import com.kingdee.eas.custom.taihe.weight.CarcassFactory;
import com.kingdee.eas.custom.taihe.weight.CarcassInfo;
import com.kingdee.eas.custom.taihe.weight.CarcassType;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class THWgtFacadeControllerBean extends AbstractTHWgtFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.taihe.weight.app.THWgtFacadeControllerBean");
    /**
     * 上传过磅信息
     */
    protected String _updateWgtInfo(Context ctx, String jsonStr)throws BOSException
    {
    	JSONObject resultJSON=new JSONObject();
    	resultJSON.put("result", 0);
    	resultJSON.put("message", "success");
    	
    	JSONObject dataJSON=JSONObject.fromObject(jsonStr);
//    	String deptNum=dataJSON.getString("deptNum");//部门编码
    	String wgtTimeStr=dataJSON.getString("wgtTime");//过磅码
    	String wgtNum=dataJSON.getString("wgtNum").toUpperCase();//过磅码
    	BigDecimal qty=new BigDecimal(dataJSON.getString("qty"));
    	BigDecimal wgt=new BigDecimal(dataJSON.getString("wgt"));
    	
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date wgtTime=null;
    	try {
    		wgtTime=sdf.parse(wgtTimeStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}//
		CarSendBillInfo carSendInfo=getSendCarBillIDFromWgtNum(ctx, wgtNum);
		if(carSendInfo!=null) {
			CarcassInfo info=new CarcassInfo();
			info.setBizDate(wgtTime);
			info.setCompany(carSendInfo.getCompany());
			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
			info.setSendCarNum(carSendInfo);
//			info.setMaterialNum(carSendInfo.getBatchContract()!=null?carSendInfo.getBatchContract().getNumber():"");
			info.setDriver(carSendInfo.getDriver());
			info.setCarNum(carSendInfo.getCar().getNumber());
			
			CarcassEntryInfo entryInfo=new CarcassEntryInfo();
			//entryInfo.setCarcassType(CarcassType.carcass);
			entryInfo.setQty(qty);
			entryInfo.setWgt(wgt);
			
			info.getEntrys().add(entryInfo);
			try {
				CarcassFactory.getLocalInstance(ctx).submit(info);
			} catch (EASBizException e) {
				resultJSON.put("result", 1);
		    	resultJSON.put("message", e.getMessage());
			}
		}else{
			resultJSON.put("result", 1);
	    	resultJSON.put("message", "过磅码不存在："+wgtNum);
		}
        return resultJSON.toString();
    }
    
    /**
     * 根据过磅码查询派车单号
     * @throws BOSException 
     */
    private CarSendBillInfo getSendCarBillIDFromWgtNum(Context ctx,String wgtNum) throws BOSException {
    	IRowSet rs=DbUtil.executeQuery(ctx, "select fid from CT_WEI_CarSendBill where FWeightNum=?",new Object[]{wgtNum});
    	try {
			if(rs.next()) {
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add("*");
				slor.add("batchContract.*");
				slor.add("car.*");
				return CarSendBillFactory.getLocalInstance(ctx).getCarSendBillInfo(new ObjectUuidPK(rs.getString("fid")),slor);
			}
		} catch (Exception e) {
			throw new BOSException(e);
		}
    	return null;
    }
}