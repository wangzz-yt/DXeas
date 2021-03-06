package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class JournalTimesFarmToFarmEntryCollection extends AbstractObjectCollection 
{
    public JournalTimesFarmToFarmEntryCollection()
    {
        super(JournalTimesFarmToFarmEntryInfo.class);
    }
    public boolean add(JournalTimesFarmToFarmEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(JournalTimesFarmToFarmEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(JournalTimesFarmToFarmEntryInfo item)
    {
        return removeObject(item);
    }
    public JournalTimesFarmToFarmEntryInfo get(int index)
    {
        return(JournalTimesFarmToFarmEntryInfo)getObject(index);
    }
    public JournalTimesFarmToFarmEntryInfo get(Object key)
    {
        return(JournalTimesFarmToFarmEntryInfo)getObject(key);
    }
    public void set(int index, JournalTimesFarmToFarmEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(JournalTimesFarmToFarmEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(JournalTimesFarmToFarmEntryInfo item)
    {
        return super.indexOf(item);
    }
}