/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.database;

import de.vw.mib.asl.internal.radio.sdars.database.AslPoolListener;
import de.vw.mib.asl.internal.radio.sdars.database.AslPoolListenerEvent;
import de.vw.mib.asl.internal.radio.sdars.database.AslPoolListenerSync;
import de.vw.mib.asl.internal.radio.sdars.database.AslPoolRecord;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolListener;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.asl.internal.radio.sdars.database.IRecordType;
import de.vw.mib.asl.internal.radio.sdars.debug.SatLogHandler;
import de.vw.mib.asl.internal.radio.sdars.debug.namedb.NameDb;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.StationInfo;

public final class AslPool
implements IAslPool,
IAslPoolListener {
    private final SatLogHandler mLogHandler;
    private final IntObjectMap mListeners;
    private final IntObjectMap mRecords;
    private NameDb mNameDb;

    public AslPool(SatLogHandler satLogHandler) {
        this.mLogHandler = satLogHandler;
        this.mListeners = new IntObjectOptHashMap(30);
        this.mRecords = new IntObjectOptHashMap(100);
        this.addListener(33, (IAslPoolListener)this);
    }

    NameDb getNameDb() {
        return this.mNameDb;
    }

    private void addListener(AslPoolListener aslPoolListener, boolean bl) {
        IAslPoolRecord iAslPoolRecord;
        int n = aslPoolListener.getKey();
        Set set = (Set)this.mListeners.get(n);
        if (set != null) {
            set.add(aslPoolListener);
        } else {
            set = new LinkedHashSet(6);
            set.add(aslPoolListener);
            this.mListeners.put(n, set);
        }
        if (bl && (iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n)) != null && iAslPoolRecord.getUpdateCount() > 1) {
            aslPoolListener.notifyUpdate(this, iAslPoolRecord);
        }
    }

    @Override
    public void addListener(int n, IAslPoolListener iAslPoolListener, boolean bl) {
        if (iAslPoolListener != null) {
            AslPoolListenerSync aslPoolListenerSync = new AslPoolListenerSync(n, iAslPoolListener);
            this.addListener(aslPoolListenerSync, bl);
        }
    }

    @Override
    public void addListener(int n, IAslPoolListener iAslPoolListener) {
        this.addListener(n, iAslPoolListener, true);
    }

    @Override
    public void addListener(int[] nArray, IAslPoolListener iAslPoolListener) {
        if (nArray != null && iAslPoolListener != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.addListener(nArray[i2], iAslPoolListener);
            }
        }
    }

    @Override
    public void addListener(int n, int n2, int n3) {
        this.addListener(n, n2, n3, true);
    }

    @Override
    public void addListener(int n, int n2, int n3, boolean bl) {
        if (n2 != 0 && n3 != 0) {
            AslPoolListenerEvent aslPoolListenerEvent = new AslPoolListenerEvent(n, n2, n3);
            this.addListener(aslPoolListenerEvent, bl);
        }
    }

    @Override
    public void removeListener(int n, IAslPoolListener iAslPoolListener) {
        Set set = (Set)this.mListeners.get(n);
        if (set == null || !set.remove(new AslPoolListenerSync(n, iAslPoolListener))) {
            // empty if block
        }
    }

    @Override
    public void removeListener(int[] nArray, IAslPoolListener iAslPoolListener) {
        if (nArray != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.removeListener(nArray[i2], iAslPoolListener);
            }
        }
    }

    @Override
    public void removeListener(int n, int n2, int n3) {
        Set set = (Set)this.mListeners.get(n);
        if (set == null || !set.remove(new AslPoolListenerEvent(n, n2, n3))) {
            // empty if block
        }
    }

    SatLogHandler getLogHandler() {
        return this.mLogHandler;
    }

    @Override
    public void notifyUpdate(int n) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            this.notifyUpdate(n, iAslPoolRecord);
        }
    }

    void notifyUpdate(int n, IAslPoolRecord iAslPoolRecord) {
        Set set = (Set)this.mListeners.get(n);
        if (set != null) {
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                AslPoolListener aslPoolListener = (AslPoolListener)iterator.next();
                aslPoolListener.notifyUpdate(this, iAslPoolRecord);
            }
        }
    }

    @Override
    public IAslPoolRecord registerRecord(int n, int n2, String string) {
        AslPoolRecord aslPoolRecord = new AslPoolRecord(this, n, n2, string);
        this.mRecords.put(n, aslPoolRecord);
        return aslPoolRecord;
    }

    @Override
    public void copy(int n, int n2) {
        AslPoolRecord aslPoolRecord;
        AslPoolRecord aslPoolRecord2 = (AslPoolRecord)this.mRecords.get(n);
        if (aslPoolRecord2 != null && (aslPoolRecord = (AslPoolRecord)this.mRecords.get(n2)) != null) {
            aslPoolRecord.set(aslPoolRecord2);
        }
    }

    @Override
    public String getTypeName(int n) {
        if (n >= 0 && n < IRecordType.NAMES.length) {
            return IRecordType.NAMES[n];
        }
        return Integer.toString(n);
    }

    public int getUpdateCount(int n) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.getUpdateCount();
        }
        return 0;
    }

    @Override
    public void enableNotificationsWithoutChange(int n) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            iAslPoolRecord.enableNotificationsWithoutChange();
        }
    }

    @Override
    public void notifyUpdate(IAslPool iAslPool, int n, IAslPoolRecord iAslPoolRecord) {
        switch (n) {
            case 33: {
                this.mNameDb = (NameDb)iAslPoolRecord.getObject();
                break;
            }
        }
    }

    @Override
    public void setNameDbType(int n, int n2) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            iAslPoolRecord.setNameDbType(n2);
        }
    }

    @Override
    public int getInt(int n) {
        return this.getInt(n, 0);
    }

    @Override
    public int getInt(int n, int n2) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.getInt(n2);
        }
        return n2;
    }

    @Override
    public boolean setInt(int n, int n2) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.setInt(n2);
        }
        return false;
    }

    @Override
    public boolean incInt(int n) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.incInt();
        }
        return false;
    }

    @Override
    public boolean decInt(int n) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.decInt();
        }
        return false;
    }

    @Override
    public short getShort(int n) {
        return this.getShort(n, (short)0);
    }

    @Override
    public short getShort(int n, short s) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.getShort(s);
        }
        return s;
    }

    @Override
    public boolean setShort(int n, short s) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.setShort(s);
        }
        return false;
    }

    @Override
    public long getLong(int n, long l) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.getLong(l);
        }
        return l;
    }

    @Override
    public long getLong(int n) {
        return this.getLong(n, 0L);
    }

    @Override
    public boolean setLong(int n, long l) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.setLong(l);
        }
        return false;
    }

    @Override
    public boolean getBoolean(int n) {
        return this.getBoolean(n, false);
    }

    @Override
    public boolean getBoolean(int n, boolean bl) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.getBoolean(bl);
        }
        return bl;
    }

    @Override
    public boolean setBoolean(int n, boolean bl) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            iAslPoolRecord.setBoolean(bl);
        }
        return false;
    }

    @Override
    public String getString(int n) {
        return this.getString(n, "");
    }

    @Override
    public String getString(int n, String string) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.getString(string);
        }
        return string;
    }

    @Override
    public boolean setString(int n, String string) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.setString(string);
        }
        return false;
    }

    @Override
    public RadioText getRadioText(int n) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.getRadioText();
        }
        return null;
    }

    @Override
    public boolean setRadioText(int n, RadioText radioText) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.setRadioText(radioText);
        }
        return false;
    }

    @Override
    public StationInfo getChannel(int n) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.getChannel();
        }
        return null;
    }

    @Override
    public boolean setChannel(int n, StationInfo stationInfo) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.setChannel(stationInfo);
        }
        return false;
    }

    @Override
    public CategoryInfo getCategory(int n) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.getCategory();
        }
        return null;
    }

    @Override
    public boolean setCategory(int n, CategoryInfo categoryInfo) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.setCategory(categoryInfo);
        }
        return false;
    }

    @Override
    public ResourceLocator getResourceLocator(int n) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.getResourceLocator();
        }
        return null;
    }

    @Override
    public boolean setResourceLocator(int n, ResourceLocator resourceLocator) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.setResourceLocator(resourceLocator);
        }
        return false;
    }

    @Override
    public EventGeneric getEvent(int n) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.getEvent();
        }
        return null;
    }

    @Override
    public boolean setEvent(int n, EventGeneric eventGeneric) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.setEvent(eventGeneric);
        }
        return false;
    }

    @Override
    public Object getObject(int n) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.getObject();
        }
        return null;
    }

    @Override
    public boolean setObject(int n, Object object) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.setObject(object);
        }
        return false;
    }

    @Override
    public Object[] getObjectArray(int n) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.getObjectArray();
        }
        return null;
    }

    @Override
    public boolean setObjectArray(int n, Object[] objectArray) {
        IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)this.mRecords.get(n);
        if (iAslPoolRecord != null) {
            return iAslPoolRecord.setObjectArray(objectArray);
        }
        return false;
    }
}

