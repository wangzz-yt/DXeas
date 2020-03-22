package com.kingdee.eas.custom.tocloud.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.measure.unit.BaseUnit;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.cp.dm.web.dto.CtrlUnitInfoDTO;
import com.kingdee.eas.custom.tocloud.SynDateLogEntryInfo;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonDataBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonFAUXPROF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonFSTOCKF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonStaffF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudMaterialReqBean;
import com.kingdee.eas.custom.tocloud.bean.CloudMaterialReqEntryBean;
import com.kingdee.eas.custom.tocloud.service.ISynData;
import com.kingdee.eas.farm.hatch.BEggHatchBillEggEntryFactory;
import com.kingdee.eas.farm.hatch.BEggHatchBillEggEntryInfo;
import com.kingdee.eas.farm.hatch.BEggHatchBillFactory;
import com.kingdee.eas.farm.hatch.BEggHatchBillInfo;
import com.kingdee.eas.farm.hatch.HatchBaseDataFactory;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.mobile.convert.util.CtrlUnitInfoConvert;

public class SynDataBEggHatchToMaterialReq implements ISynData{

	/**
	 * 业务类型是种蛋上孵单--生成cloud领料出库单（006）
	 */
	@Override
	public String synData(Context ctx, String billId, String entryId,
			String targetSystemId, String bizTypeId, List<String> errorMessage,
			SynDateLogEntryInfo synDateLogEntryInfo) throws Exception {

		//实例化
		BEggHatchBillInfo bEggHatchBillInfo = BEggHatchBillFactory.getLocalInstance(ctx).getBEggHatchBillInfo(new ObjectUuidPK(billId));
		BEggHatchBillEggEntryInfo entryInfo = BEggHatchBillEggEntryFactory.getLocalInstance(ctx).getBEggHatchBillEggEntryInfo(new ObjectUuidPK(entryId));
		//设定日期显示格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		//创建领料出库单表头
		CloudMaterialReqBean cloudMaterialReqBean = new CloudMaterialReqBean();
		CloudCommonF7Bean f7Bean = null;


		//设置id
		String FID = "0";
		cloudMaterialReqBean.setFID(FID);

		//单据编号
		String FBillNo = "";
		cloudMaterialReqBean.setFBillNo(FBillNo);

		//单据类型
		String FBillType = "JDSCLL01_SYS";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FBillType);
		cloudMaterialReqBean.setFBillType(f7Bean);

		//日期
		String FDate = bEggHatchBillInfo.getBizDate().toString();
		cloudMaterialReqBean.setFDate(FDate);

		//备注
		String FDescription = "种蛋上孵单数据同步";
		cloudMaterialReqBean.setFDescription(FDescription);

		//发料组织
		StorageOrgUnitInfo storageInfo = StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(new ObjectUuidPK((bEggHatchBillInfo.getCU().getId())));
		String targetOrgNum = storageInfo.getNumber();
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		cloudMaterialReqBean.setFStockOrgId(f7Bean);

		//库存组
		String FStockerGroupId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockerGroupId);
		cloudMaterialReqBean.setFStockerGroupId(f7Bean);

		//仓管员
		String FStockerId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockerId);
		cloudMaterialReqBean.setFStockerId(f7Bean);

		//领料人
		String FPickerId = "";
		CloudCommonStaffF7Bean f8Bean = new CloudCommonStaffF7Bean();
		f8Bean.setFStaffNumber(FPickerId);
		cloudMaterialReqBean.setFPickerId(f8Bean);

		//本位币
		String FCurrId = "PRE001";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FCurrId);
		cloudMaterialReqBean.setFCurrId(f7Bean);

		//货主类型
		String FOwnerTypeId0 = "BD_OwnerOrg";
		cloudMaterialReqBean.setFOwnerTypeId0(FOwnerTypeId0);

		//货主
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		cloudMaterialReqBean.setFOwnerId0(f7Bean);

		//生产组织
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		cloudMaterialReqBean.setFPrdOrgId(f7Bean);

		//生产车间
		StorageOrgUnitInfo hatchInfo = StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(new ObjectUuidPK(bEggHatchBillInfo.getStorageOrgUnit().getId()));
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(hatchInfo.getNumber());
		cloudMaterialReqBean.setFWorkShopId(f7Bean);

		//跨组织业务类型
		String FTransferBizTypeId = "OverOrgPick";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FTransferBizTypeId);
		cloudMaterialReqBean.setFTransferBizTypeId(f7Bean);

		//序列号上传
		String FScanBox = "";
		cloudMaterialReqBean.setFScanBox(FScanBox);

		//班次
		String F_F_BANZ1 = "01";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(F_F_BANZ1);
		cloudMaterialReqBean.setF_F_BANZ1(f7Bean);






		JSONArray entryArray = new JSONArray();

		//设置分录
		CloudMaterialReqEntryBean cloudMaterialReqEntryBeanInfo = new CloudMaterialReqEntryBean();

		//设置FEntryID
		String FEntryID = "0";
		cloudMaterialReqEntryBeanInfo.setFEntryID(FEntryID);

		//物料编码
		String FMaterialId = "06.03.01.001";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FMaterialId);
		cloudMaterialReqEntryBeanInfo.setFMaterialId(f7Bean);

		//辅助属性
		String FAuxPropId = "";
		CloudCommonFAUXPROF7Bean  FAuxPropIdfaux = new CloudCommonFAUXPROF7Bean();
		FAuxPropIdfaux.setFAUXPROPID__FOPCODE(FAuxPropId);
		cloudMaterialReqEntryBeanInfo.setFAuxPropId(FAuxPropIdfaux);

		//BOM版本
		String FBomId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FBomId);
		cloudMaterialReqEntryBeanInfo.setFBomId(f7Bean);

		//单位
		String FUnitID = "mei";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FUnitID);
		cloudMaterialReqEntryBeanInfo.setFUnitID(f7Bean);

		//申请数量
		String FAppQty = String.valueOf(entryInfo.getEggQty());
		cloudMaterialReqEntryBeanInfo.setFAppQty(FAppQty);

		//实发数量
		cloudMaterialReqEntryBeanInfo.setFActualQty(FAppQty);

		//仓库
		String FStockId = "ZQ06";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockId);
		cloudMaterialReqEntryBeanInfo.setFStockId(f7Bean);

		//仓位
		String FStockLocId = "";
		CloudCommonFSTOCKF7Bean FStockLocIdStock = new CloudCommonFSTOCKF7Bean();
		FStockLocIdStock.setFSTOCKLOCID__FOPCODE(FStockLocId);
		cloudMaterialReqEntryBeanInfo.setFStockLocId(FStockLocIdStock);

		//批号
		StockingBatchInfo batchInfo = entryInfo.getOutBatch();
		StockingBatchInfo batchInfo1 = null;
		if(batchInfo != null){
			batchInfo1 = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(new ObjectUuidPK(batchInfo.getId()));
			String batchNum = batchInfo1.getNumber().substring(0, 8);
			f7Bean = new CloudCommonF7Bean();
			f7Bean.setFNumber(batchNum);
			cloudMaterialReqEntryBeanInfo.setFLot(f7Bean);
		} else {
			throw new Exception("请维护种蛋上孵单的种禽批次");
		}


		//生产对象
		String FProductId = "06.002";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FProductId);
		cloudMaterialReqEntryBeanInfo.setFProductId(f7Bean);

		//生产编号
		String FProductNo = batchInfo1.getNumber().substring(0,8);
		cloudMaterialReqEntryBeanInfo.setFProductNo(FProductNo);

		//生产编号影响成本
		String FIsAffectCost = "true";
		cloudMaterialReqEntryBeanInfo.setFIsAffectCost(FIsAffectCost);

		//产品组
		String FPRODUCTGROUPID = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FPRODUCTGROUPID);
		cloudMaterialReqEntryBeanInfo.setFPRODUCTGROUPID(f7Bean);

		//库存单位
		String FStockUnitId = "mei";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockUnitId);
		cloudMaterialReqEntryBeanInfo.setFStockUnitId(f7Bean);

		//库存单位实发数量
		cloudMaterialReqEntryBeanInfo.setFStockActualQty(FAppQty);

		//货主类型
		String FOwnerTypeId = "BD_OwnerOrg";
		cloudMaterialReqEntryBeanInfo.setFOwnerTypeId(FOwnerTypeId);

		//车间
		String FEntryWorkShopId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FEntryWorkShopId);
		cloudMaterialReqEntryBeanInfo.setFEntryWorkShopId(f7Bean);

		//货主
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		cloudMaterialReqEntryBeanInfo.setFOwnerId(f7Bean);

		//辅单位 
		String FExtAuxUnitId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FExtAuxUnitId);
		cloudMaterialReqEntryBeanInfo.setFExtAuxUnitId(f7Bean);

		//实发数量（辅单位）
		String FExtAuxUnitQty = "0";
		cloudMaterialReqEntryBeanInfo.setFExtAuxUnitQty(FExtAuxUnitQty);

		//成本价
		cloudMaterialReqEntryBeanInfo.setFPrice(null);

		//总成本
		cloudMaterialReqEntryBeanInfo.setFAmount(null);

		//产品货主类型
		String FParentOwnerTypeId = "BD_OwnerOrg";
		cloudMaterialReqEntryBeanInfo.setFParentOwnerTypeId(FParentOwnerTypeId);

		//产品货主
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		cloudMaterialReqEntryBeanInfo.setFParentOwnerId(f7Bean);

		//基本单位
		String FBaseUnitId = "01";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FBaseUnitId);
		cloudMaterialReqEntryBeanInfo.setFBaseUnitId(f7Bean);

		//服务上下文
		String FServiceContext = "";
		cloudMaterialReqEntryBeanInfo.setFServiceContext(FServiceContext);

		//基本单位数量
		cloudMaterialReqEntryBeanInfo.setFBaseActualQty(FAppQty);

		//库存状态
		String FStockStatusId = "KCZT01_SYS";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockStatusId);
		cloudMaterialReqEntryBeanInfo.setFStockStatusId(f7Bean);

		//生产日期
		String FProduceDate = "";
		cloudMaterialReqEntryBeanInfo.setFProduceDate(FProduceDate);

		//库存辅单位
		String FSecUnitId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FSecUnitId);
		cloudMaterialReqEntryBeanInfo.setFSecUnitId(f7Bean);

		//实发数量(库存辅单位)
		String FSecActualQty = "";
		cloudMaterialReqEntryBeanInfo.setFSecActualQty(FSecActualQty);

		//备注
		String FEntrtyMemo = "";
		cloudMaterialReqEntryBeanInfo.setFEntrtyMemo(FEntrtyMemo);

		//计划跟踪号
		String FMtoNo = "";
		cloudMaterialReqEntryBeanInfo.setFMtoNo(FMtoNo);

		//基本单位申请数量
		cloudMaterialReqEntryBeanInfo.setFBaseAppQty(FAppQty);

		//保管者类型
		String FKeeperTypeId = "BD_KeeperOrg";
		cloudMaterialReqEntryBeanInfo.setFKeeperTypeId(FKeeperTypeId);

		//保管者
		f7Bean  = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		cloudMaterialReqEntryBeanInfo.setFKeeperId(f7Bean);

		//有效期至
		String FExpiryDate = "";
		cloudMaterialReqEntryBeanInfo.setFExpiryDate(FExpiryDate);

		//调整
		String F_abc_Text = "1";
		cloudMaterialReqEntryBeanInfo.setF_abc_Text(F_abc_Text);



		entryArray.add(cloudMaterialReqEntryBeanInfo);
		//设置表头的FEntity
		cloudMaterialReqBean.setFEntity(entryArray);




		//将实体转化为jsonObject
		String manuString = JSONObject.toJSONString(cloudMaterialReqBean, SerializerFeature.WriteNullStringAsEmpty);
		JSONObject allJson = JSONObject.parseObject(manuString, Feature.OrderedField);

		//data（必填）
		CloudCommonDataBean cloudCommonDataBean = new CloudCommonDataBean();
		cloudCommonDataBean.setCreator("");
		cloudCommonDataBean.setNeedUpDateFields(null);
		cloudCommonDataBean.setModel(allJson);

		//新建CloudCommonBean对象
		CloudCommonBean commonBean = new CloudCommonBean();
		commonBean.setFormid("SP_PickMtrl");
		commonBean.setData(cloudCommonDataBean);

		//将实体转化为字符串
		return JSONObject.toJSONString(commonBean, SerializerFeature.WriteNullStringAsEmpty);
	}
}
