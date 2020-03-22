package com.kingdee.eas.custom.runkanban.common;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.kingdee.bos.Context;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class BreedingHen {

	
	//育成存栏与初始入栏母鸡批次汇总,育成场明细数据
	public static String HatchFactoryDetailsData(Context ctx, String paramStr){

		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONArray resultArray=new JSONArray();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" /*dialect*/");
		sql.append(" select ");
		sql.append(" t.cfstoorgid stoOrgID,");
		sql.append(" sto.fnumber farmNumber,");
		sql.append(" max(sto.fname_l2) farmName,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) and tbe.cfchikentype = 1 then");
		sql.append(" te.CFBreekingStock");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayHenBreekingStockQty,");
		sql.append(" ");
		sql.append(" sum(case");
		sql.append(" when  to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) and tbe.cfchikentype = 1 then");
		sql.append(" tbe.CFinitQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) henInitQty,");
		sql.append(" max(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) and tbe.cfchikentype = 1 then");
		sql.append(" t.cfweek");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) week, ");
		sql.append(" max(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) and tbe.cfchikentype = 1 then");
		sql.append(" t.cfweekday");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) weekday");
		sql.append(" from CT_FM_BroodDaily t");
		sql.append(" inner join CT_FM_BroodDailyAssEntry te");
		sql.append(" on te.fparentid = t.fid");
		sql.append(" inner join ct_fm_breedbatchentry tbe on te.cfhenhouseid = tbe.cfhenhouseid and t.cfbreedbatchid = tbe.fparentid");
		sql.append(" inner join t_org_storage sto on t.cfstoorgid = sto.fid");
		sql.append(" where (to_char(t.fbizdate, 'yyyy-MM-dd') = substr('"+fbizdate+"', 1, 10))");
		sql.append(" group by t.cfstoorgid,sto.fnumber order by sto.fnumber ");
	
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				resultObj.put("stoOrgID",rs.getString("stoOrgID"));
				resultObj.put("farmNumber",rs.getString("farmNumber"));
				resultObj.put("farmName",rs.getString("farmName"));
				resultObj.put("dayHenBreekingStockQty",rs.getString("dayHenBreekingStockQty"));
				resultObj.put("henInitQty",rs.getString("henInitQty"));
				resultObj.put("week",rs.getString("week"));
				resultObj.put("weekday",rs.getString("weekday"));
				
				resultArray.add(resultObj);
			}
		} catch (Exception e) {
			resultArray.add( e.getMessage());
		}
		return resultArray.toString();
	
	}
	
	//产蛋数据按年月日统计批次汇总，产蛋场明细数据
	public static String LayEggsFactoryDetailsData(Context ctx, String paramStr){

		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONArray resultArray=new JSONArray();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		
		sql.append(" /*dialect*/");
		sql.append(" select ");
		sql.append(" storageID,");
		sql.append(" max(storageNumber) storageNumber,");
		sql.append(" max(storageName) storageName,");
		sql.append(" sum(batchHenInitQty) batchHenInitQty,");
		sql.append(" sum(dayQualifiedEggs) dayQualifiedEggs,");
		sql.append(" sum(monthQualifiedEggs) monthQualifiedEggs,");
		sql.append(" sum(batchQualifiedEggs) batchQualifiedEggs,");
		sql.append(" sum(dayAllEggs) dayAllEggs,");
		sql.append(" sum(monthAllEggs) monthAllEggs,");
		sql.append(" sum(batchAllEggs) batchAllEggs,");
		sql.append(" sum(dayhenQty) dayhenQty,");
		sql.append(" sum(monthhenQty) monthhenQty,");
		sql.append(" sum(batchAllhenQty) batchAllhenQty,");
		sql.append(" max(week) week,");
		sql.append(" max(weekDay) weekDay");
		sql.append(" from (");
		sql.append(" select");
		sql.append(" t.CFStoOrgID storageID,");
		sql.append(" max(ts.fnumber) storageNumber,");
		sql.append(" max(ts.fname_l2) storageName,");
		sql.append(" 0 batchHenInitQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) then");
		sql.append(" te.CFQualifiedEggs");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayQualifiedEggs,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1, 7)  and    t.cfweek >= 26 then");
		sql.append(" te.CFQualifiedEggs");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthQualifiedEggs,");
		sql.append(" sum(case");
		sql.append(" when      t.cfweek >= 26 then");
		sql.append(" te.CFQualifiedEggs");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) batchQualifiedEggs,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) then");
		sql.append(" te.CFQualifiedEggs+te.CFFreakEggs+te.CFDoubleYolkedEggs+CFBrokenEggs");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayAllEggs,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1, 7)  and    t.cfweek >= 26 then");
		sql.append(" te.CFQualifiedEggs+te.CFFreakEggs+te.CFDoubleYolkedEggs+CFBrokenEggs");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthAllEggs,");
		sql.append(" sum(case");
		sql.append(" when    t.cfweek >= 26 then");
		sql.append(" te.CFQualifiedEggs+te.CFFreakEggs+te.CFDoubleYolkedEggs+CFBrokenEggs");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end)  batchAllEggs,");
		sql.append(" 0 dayhenQty,");
		sql.append(" 0 monthhenQty,");
		sql.append(" 0 batchAllhenQty,");
		sql.append(" 0 week,");
		sql.append(" 0 weekDay");
		sql.append(" from CT_FM_LayEggDaily t");
		sql.append(" inner join CT_FM_LayEggDailyConveyor te");
		sql.append(" on t.fid = te.fparentid");
		sql.append(" inner join t_org_storage ts on t.CFStoOrgID = ts.fid");
		sql.append(" where ");
		sql.append(" t.CFBreedBatchID in (");
		sql.append(" select tt.CFBreedBatchID from CT_FM_LayEggDaily tt where  to_char(tt.fbizdate, 'yyyy-MM-dd') =  substr('"+fbizdate+"', 1, 10)");
		sql.append(" )");
		sql.append(" and (t.fbizdate <(to_date('"+fbizdate+"','yyyy-mm-dd')+1))");
		sql.append(" group by t.CFStoOrgID");
		sql.append(" union all");
		sql.append(" select ");
		sql.append(" ts.fid storageID,");
		sql.append(" max(ts.fnumber) storageNumber,");
		sql.append(" max(ts.fname_l2) storageName,");
		sql.append(" sum(case");
		sql.append(" when t.cfweek=26 and t.cfweekday=1 then");
		sql.append(" te.CFHenhouseBreekingStock");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) batchHenInitQty,");
		sql.append(" 0,");
		sql.append(" 0,");
		sql.append(" 0,");
		sql.append(" 0,");
		sql.append(" 0,");
		sql.append(" 0,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) then");
		sql.append(" te.CFHenhouseBreekingStock");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayhenQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1, 7) and    t.cfweek >= 26 then");
		sql.append(" te.CFHenhouseBreekingStock");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthhenQty,");
		sql.append(" sum(case");
		sql.append(" when   t.cfweek >= 26 then");
		sql.append(" te.CFHenhouseBreekingStock");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end)  batchAllhenQty,");
		sql.append(" max(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) then");
		sql.append(" t.cfweek");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) week,");
		sql.append(" max(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) then");
		sql.append(" t.cfweekday");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) weekday");
		sql.append(" from CT_FM_Layeggdaily t ");
		sql.append(" inner join CT_FM_LayEDCDE te on t.fid = te.fparentid ");
		sql.append(" inner join t_org_storage ts on t.CFStoOrgID = ts.fid");
		sql.append(" where ");
		sql.append(" t.CFBreedBatchID in (");
		sql.append(" select tt.CFBreedBatchID from CT_FM_LayEggDaily tt where  to_char(tt.fbizdate, 'yyyy-MM-dd') =  substr('"+fbizdate+"', 1, 10)");
		sql.append(" ) and (t.fbizdate <(to_date('"+fbizdate+"','yyyy-mm-dd')+1))");
		sql.append(" group by ts.fid");
		sql.append(" ) group by storageID");

		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				resultObj.put("storageID",rs.getString("storageID"));
				resultObj.put("storageNumber",rs.getString("storageNumber"));
				resultObj.put("storageName",rs.getString("storageName"));
				resultObj.put("batchHenInitQty",rs.getString("batchHenInitQty"));
				resultObj.put("dayQualifiedEggs",rs.getString("dayQualifiedEggs"));
				resultObj.put("monthQualifiedEggs",rs.getString("monthQualifiedEggs"));
				resultObj.put("batchQualifiedEggs",rs.getString("batchQualifiedEggs"));
				resultObj.put("dayAllEggs",rs.getString("dayAllEggs"));
				resultObj.put("monthAllEggs",rs.getString("monthAllEggs"));
				resultObj.put("batchAllEggs",rs.getString("batchAllEggs"));
				resultObj.put("dayhenQty",rs.getString("dayhenQty"));
				resultObj.put("monthhenQty",rs.getString("monthhenQty"));
				resultObj.put("batchAllhenQty",rs.getString("batchAllhenQty"));
				resultObj.put("week",rs.getString("week"));
				resultObj.put("weekDay",rs.getString("weekDay"));

				resultArray.add(resultObj);
			}
		} catch (Exception e) {
			resultArray.add( e.getMessage());
		}
		return resultArray.toString();
	
	}
	
	public static String FFBHAD(Context ctx, String paramStr) {
		 JSONObject resultObj=new JSONObject();
		 resultObj.put("HFRADCD", HFRADCD(ctx,paramStr)); //育成场经营与死淘数据HatchFactoryRunAndDeathCullData
		 resultObj.put("LEFRADCD", LEFRADCD(ctx,paramStr));//产蛋场经营与死淘数据LayEggsFactoryRunAndDeathCullData
		 resultObj.put("LEFSDMY", LEFSDMY(ctx,paramStr));//产蛋场种蛋统计（日、月、年）LayEggsFactoryStatisticDayMonthYear
		return resultObj.toString();
	}
	
	//产蛋场种蛋统计（日、月、年）
	private static String LEFSDMY(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" /*dialect*/");
		sql.append(" select");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) then");
		sql.append(" te.CFQualifiedEggs");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayQualifiedEggs,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1, 7) then");
		sql.append(" te.CFQualifiedEggs");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthQualifiedEggs,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy') =");
		sql.append(" substr('"+fbizdate+"', 1, 4) then");
		sql.append(" te.CFQualifiedEggs");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearQualifiedEggs,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) then");
		sql.append(" te.CFQualifiedEggs+te.CFFreakEggs+te.CFDoubleYolkedEggs+CFBrokenEggs");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayAllEggs,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1, 7) then");
		sql.append(" te.CFQualifiedEggs+te.CFFreakEggs+te.CFDoubleYolkedEggs+CFBrokenEggs");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthAllEggs,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy') =");
		sql.append(" substr('"+fbizdate+"', 1, 4) then");
		sql.append(" te.CFQualifiedEggs+te.CFFreakEggs+te.CFDoubleYolkedEggs+CFBrokenEggs");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearAllEggs");
		sql.append(" from CT_FM_LayEggDaily t");
		sql.append(" inner join CT_FM_LayEggDailyConveyor te");
		sql.append(" on t.fid = te.fparentid");
		sql.append("  where ");
		sql.append(" (to_char(t.fbizdate, 'yyyy') = substr('"+fbizdate+"', 1, 4) )");
		sql.append(" and (t.fbizdate <(to_date('"+fbizdate+"','yyyy-mm-dd')+1)  )");
		
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				
				resultObj.put("dayQualifiedEggs",rs.getString("dayQualifiedEggs"));
				resultObj.put("monthQualifiedEggs",rs.getString("monthQualifiedEggs"));
				resultObj.put("yearQualifiedEggs",rs.getString("yearQualifiedEggs"));
				resultObj.put("dayAllEggs",rs.getString("dayAllEggs"));
				resultObj.put("monthAllEggs",rs.getString("monthAllEggs"));
				resultObj.put("yearAllEggs",rs.getString("yearAllEggs"));
			}
		} catch (Exception e) {
			resultObj.put("error", e.getMessage());
		}
		return resultObj.toString();
	}
	//产蛋场经营与死淘数据
	public static String LEFRADCD(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONArray resultArray=new JSONArray();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" /*dialect*/");
		sql.append(" select ");
		sql.append(" t.cfstoorgid stoOrgID,");
		sql.append(" sto.fnumber farmNumber,");
		sql.append(" max(sto.fname_l2) farmName,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) and te.fseq = 1 then");
		sql.append(" t.CFCoalFual");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayCoalQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1,7) and te.fseq = 1 then");
		sql.append(" t.CFCoalFual");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthCoalQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy') =");
		sql.append(" substr('"+fbizdate+"', 1,4) and te.fseq = 1 then");
		sql.append(" t.CFCoalFual");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearCoalQty,");
		sql.append(" ");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) and te.fseq = 1 then");
		sql.append(" t.CFElectricityQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayElecQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1,7) and te.fseq = 1 then");
		sql.append(" t.CFElectricityQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthElecQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy') =");
		sql.append(" substr('"+fbizdate+"', 1,4) and te.fseq = 1 then");
		sql.append(" t.CFElectricityQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearElecQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-mm-dd') =");
		sql.append(" substr('"+fbizdate+"', 1,7) || '-01' and te.fseq = 1 then");
		sql.append(" t.CFInitPersonQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthInitPersonQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1,7) and te.fseq = 1 then");
		sql.append(" t.CFEntryPersonQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthAddPersonQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1,7) and te.fseq = 1 then");
		sql.append(" t.CFLeavePersonQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthLeavePersonQty,");
		sql.append(" ");
		sql.append(" add_months(to_date(substr('"+fbizdate+"', 1, 7), 'YYYY-MM'),1)-to_date(substr('"+fbizdate+"', 1, 7), 'YYYY-MM') monthLong,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10)  then");
		sql.append(" te.CFHenhouseBreekingStock");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayHenBreekingStockQty,");
		sql.append(" ");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10)  then");
		sql.append(" te.CFCockBreekingStock");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayCockBreekingStockQty,");
		sql.append(" ");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10)  then");
		sql.append(" te.CFHenDeath");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayHenDeathQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1, 7)   then");
		sql.append(" te.CFHenDeath");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthHenDeathQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy') =");
		sql.append(" substr('"+fbizdate+"', 1, 4)then");
		sql.append(" te.CFHenDeath");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearHenDeathQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) then");
		sql.append(" te.CFCockDeath");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayCockDeathQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1, 7)   then");
		sql.append(" te.CFCockDeath");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthCockDeathQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy') =");
		sql.append(" substr('"+fbizdate+"', 1, 4)   then");
		sql.append(" te.CFCockDeath");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearCockDeathQty,           ");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) then");
		sql.append(" te.CFHenCull");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayHenCullQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1, 7) then");
		sql.append(" te.CFHenCull");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthHenCullQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy') =");
		sql.append(" substr('"+fbizdate+"', 1, 4) then");
		sql.append(" te.CFHenCull");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearHenCullQty,");
		sql.append(" ");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) then");
		sql.append(" te.CFHenBatchCull");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayHenBatchCullQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1, 7) then");
		sql.append(" te.CFHenBatchCull");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthHenBatchCullQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy') =");
		sql.append(" substr('"+fbizdate+"', 1, 4) then");
		sql.append(" te.CFHenBatchCull");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearHenBatchCullQty,           ");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10)  then");
		sql.append(" te.CFCockCull");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayCockCullQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1, 7)   then");
		sql.append(" te.CFCockCull");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthCockCullQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy') =");
		sql.append(" substr('"+fbizdate+"', 1, 4)  then");
		sql.append(" te.CFCockCull");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearCockCullQty ,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10)  then");
		sql.append(" te.CFCockBatchCull");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayCockBatchCullQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1, 7)   then");
		sql.append(" te.CFCockBatchCull");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthCockBatchCullQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy') =");
		sql.append(" substr('"+fbizdate+"', 1, 4)  then");
		sql.append(" te.CFCockBatchCull");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearCockBatchCullQty                      ");
		sql.append(" from CT_FM_LayEggDaily t");
		sql.append(" inner join CT_FM_LayEDCDE te");
		sql.append(" on te.fparentid = t.fid   ");
		sql.append(" inner join ct_fm_breedbatchentry tbe on te.cfhenhouseid = tbe.cfhenhouseid and t.cfbreedbatchid = tbe.fparentid");
		sql.append(" inner join t_org_storage sto on t.cfstoorgid = sto.fid");
		sql.append(" group by t.cfstoorgid,sto.fnumber order by sto.fnumber ");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				resultObj.put("stoOrgID",rs.getString("stoOrgID"));
				resultObj.put("farmNumber",rs.getString("farmNumber"));
				resultObj.put("farmName",rs.getString("farmName"));
				resultObj.put("dayHenBreekingStockQty",rs.getString("dayHenBreekingStockQty"));
				resultArray.add(resultObj);
			}
		} catch (Exception e) {
			resultArray.add( e.getMessage());
		}
		return resultArray.toString();
	}
	//育成场经营与死淘数据
	public static String HFRADCD(Context ctx, String paramStr) {
		StringBuffer sql=new StringBuffer();
		JSONObject resultObj=new JSONObject();
		JSONArray resultArray=new JSONArray();
		JSONObject object=JSONObject.fromObject(paramStr);
		String fbizdate=object.getString("fbizdate");//业务日期
		sql.append(" /*dialect*/");
		sql.append(" select ");
		sql.append(" t.cfstoorgid stoOrgID,");
		sql.append(" sto.fnumber farmNumber,");
		sql.append(" max(sto.fname_l2) farmName,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) and te.fseq = 1 then");
		sql.append(" t.CFCoalFual");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayCoalQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1,7) and te.fseq = 1 then");
		sql.append(" t.CFCoalFual");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthCoalQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy') =");
		sql.append(" substr('"+fbizdate+"', 1,4) and te.fseq = 1 then");
		sql.append(" t.CFCoalFual");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearCoalQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) and te.fseq = 1 then");
		sql.append(" t.CFElectricityQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayElecQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1,7) and te.fseq = 1 then");
		sql.append(" t.CFElectricityQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthElecQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy') =");
		sql.append(" substr('"+fbizdate+"', 1,4) and te.fseq = 1 then");
		sql.append(" t.CFElectricityQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearElecQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-mm-dd') =");
		sql.append(" substr('"+fbizdate+"', 1,7) || '-01' and te.fseq = 1 then");
		sql.append(" t.CFInitPersonQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthInitPersonQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1,7) and te.fseq = 1 then");
		sql.append(" t.CFEntryPersonQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthAddPersonQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1,7) and te.fseq = 1 then");
		sql.append(" t.CFLeavePersonQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthLeavePersonQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1,7) and te.fseq = 1 then");
		sql.append(" t.CFAttendPersonQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthAttendPersonQty,");
		sql.append(" add_months(to_date(substr('"+fbizdate+"', 1, 7), 'YYYY-MM'),1)-to_date(substr('"+fbizdate+"', 1, 7), 'YYYY-MM') monthLong,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) and tbe.cfchikentype = 1 then");
		sql.append(" te.CFBreekingStock");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayHenBreekingStockQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) and tbe.cfchikentype = 2 then");
		sql.append(" te.CFBreekingStock");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayCockBreekingStockQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) and tbe.cfchikentype = 1 then");
		sql.append(" te.CFDeathQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayHenDeathQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1, 7)  and  tbe.cfchikentype = 1 then");
		sql.append(" te.CFDeathQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthHenDeathQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy') =");
		sql.append(" substr('"+fbizdate+"', 1, 4) and  tbe.cfchikentype = 1 then");
		sql.append(" te.CFDeathQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearHenDeathQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10) and  tbe.cfchikentype = 2 then");
		sql.append(" te.CFDeathQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayCockDeathQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1, 7)  and  tbe.cfchikentype = 2 then");
		sql.append(" te.CFDeathQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthCockDeathQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy') =");
		sql.append(" substr('"+fbizdate+"', 1, 4) and  tbe.cfchikentype = 2 then");
		sql.append(" te.CFDeathQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearCockDeathQty,           ");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10)  and  tbe.cfchikentype = 1  then");
		sql.append(" te.CFCullQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayHenCullQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1, 7)  and  tbe.cfchikentype = 1  then");
		sql.append(" te.CFCullQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthHenCullQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy') =");
		sql.append(" substr('"+fbizdate+"', 1, 4) and   tbe.cfchikentype = 1 then");
		sql.append(" te.CFCullQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearHenCullQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM-dd') =");
		sql.append(" substr('"+fbizdate+"', 1, 10)  and  tbe.cfchikentype = 2  then");
		sql.append(" te.CFCullQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) dayCockCullQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy-MM') =");
		sql.append(" substr('"+fbizdate+"', 1, 7)  and  tbe.cfchikentype = 2  then");
		sql.append(" te.CFCullQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) monthCockCullQty,");
		sql.append(" sum(case");
		sql.append(" when to_char(t.fbizdate, 'yyyy') =");
		sql.append(" substr('"+fbizdate+"', 1, 4)  and  tbe.cfchikentype = 2 then");
		sql.append(" te.CFCullQty");
		sql.append(" else");
		sql.append(" 0");
		sql.append(" end) yearCockCullQty           ");
		sql.append(" from CT_FM_BroodDaily t");
		sql.append(" inner join CT_FM_BroodDailyAssEntry te");
		sql.append(" on te.fparentid = t.fid");
		sql.append(" inner join ct_fm_breedbatchentry tbe on te.cfhenhouseid = tbe.cfhenhouseid and t.cfbreedbatchid = tbe.fparentid");
		sql.append(" inner join t_org_storage sto on t.cfstoorgid = sto.fid");
		sql.append(" group by t.cfstoorgid,sto.fnumber order by sto.fnumber ");
		try {
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				resultObj.put("stoOrgID",rs.getString("stoOrgID"));
				resultObj.put("farmNumber",rs.getString("farmNumber"));
				resultObj.put("farmName",rs.getString("farmName"));
				resultObj.put("dayHenBreekingStockQty",rs.getString("dayHenBreekingStockQty"));
				resultArray.add(resultObj);
			}
		} catch (Exception e) {
			resultArray.add(e.getMessage());
		}
		return resultArray.toString();
	}
	
	
	
	
	 

}
