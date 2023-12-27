/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.database;

import de.vw.mib.asl.internal.radio.sdars.database.AslPool;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.asl.internal.radio.sdars.database.ObjectCompare;
import de.vw.mib.asl.internal.radio.sdars.debug.namedb.NameDb;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;
import edu.emory.mathcs.backport.java.util.Arrays;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.StationInfo;

final class AslPoolRecord
implements IAslPoolRecord {
    private static final int MAX_TO_DISPLAY;
    private final AslPool mPool;
    private final int mType;
    private final String mName;
    private final int mKey;
    private int mCount = 0;
    private Object mData;
    private Object[] mDataArray;
    private long mHash = 0L;
    private boolean mEnableNotificationWithoutChange = false;
    private int mNameDbType = 0;

    public AslPoolRecord(AslPool aslPool, int n, int n2, String string) {
        this.mPool = aslPool;
        this.mKey = n;
        this.mType = n2;
        this.mName = string;
    }

    private boolean checkType(int n) {
        if (this.mType == n) {
            return true;
        }
        LogMessage logMessage = SatDb.getInstance().getLogHandler().logError();
        if (logMessage != null) {
            logMessage.append("Error accessing database value: AccessType=").append(n).append(" Key=").append(this.mName).log();
        }
        return false;
    }

    private void setData(Object object) {
        LogMessage logMessage;
        ++this.mCount;
        this.mData = object;
        if (this.mKey != 125 && (logMessage = this.mPool.getLogHandler().getLogMsg()) != null) {
            String string = object == null ? "" : object.toString();
            logMessage.append("DB  ").append(this.mName).append(" = ").append(string);
            if (object != null && this.mType == 1 && this.mNameDbType > 0) {
                String string2;
                int n = (Integer)object;
                NameDb nameDb = this.mPool.getNameDb();
                if (nameDb != null && (string2 = nameDb.getName(this.mNameDbType, n)).length() > 0) {
                    logMessage.append(' ');
                    logMessage.append(string2);
                }
            }
            logMessage.append(" x").append(this.mCount).log();
        }
        if (this.mCount > 1) {
            this.mPool.notifyUpdate(this.mKey, this);
        }
    }

    private void setDataArray(Object[] objectArray) {
        ++this.mCount;
        this.mDataArray = objectArray;
        LogMessage logMessage = this.mPool.getLogHandler().getLogMsg();
        if (logMessage != null) {
            logMessage.append("DB  ").append(this.mName).append(" = ");
            if (objectArray == null) {
                logMessage.append("null");
            } else {
                logMessage.append('[');
                logMessage.append(objectArray.length);
                logMessage.append(']');
                int n = Math.min(objectArray.length, 5);
                for (int i2 = 0; i2 < n; ++i2) {
                    if (i2 > 0) {
                        logMessage.append(", ");
                    }
                    if (objectArray[i2] == null) {
                        logMessage.append("null");
                        continue;
                    }
                    logMessage.append(objectArray[i2].toString());
                }
                if (objectArray.length > 5) {
                    logMessage.append('(');
                    logMessage.append(objectArray.length - 5);
                    logMessage.append("more)");
                }
            }
            logMessage.append(" x").append(this.mCount).log();
        }
        if (this.mCount > 1) {
            this.mPool.notifyUpdate(this.mKey, this);
        }
    }

    void set(AslPoolRecord aslPoolRecord) {
        if (aslPoolRecord.mType == this.mType) {
            switch (this.mType) {
                case 2: {
                    this.setBoolean(aslPoolRecord.getBoolean());
                    break;
                }
                case 7: {
                    this.setCategory(aslPoolRecord.getCategory());
                    break;
                }
                case 6: {
                    this.setChannel(aslPoolRecord.getChannel());
                    break;
                }
                case 1: {
                    this.setInt(aslPoolRecord.getInt());
                    break;
                }
                case 8: {
                    this.setLong(aslPoolRecord.getLong());
                    break;
                }
                case 5: {
                    this.setRadioText(aslPoolRecord.getRadioText());
                    break;
                }
                case 9: {
                    this.setResourceLocator(aslPoolRecord.getResourceLocator());
                    break;
                }
                case 4: {
                    this.setShort(aslPoolRecord.getShort());
                    break;
                }
                case 3: {
                    this.setString(aslPoolRecord.getString());
                    break;
                }
                case 10: {
                    this.setObject(aslPoolRecord.getObject());
                    break;
                }
                case 11: {
                    this.setObjectArray(aslPoolRecord.getObjectArray());
                    break;
                }
            }
        }
    }

    @Override
    public void enableNotificationsWithoutChange() {
        this.mEnableNotificationWithoutChange = true;
    }

    @Override
    public void setNameDbType(int n) {
        this.mNameDbType = n;
    }

    @Override
    public int getType() {
        return this.mType;
    }

    @Override
    public String getName() {
        return this.mName;
    }

    @Override
    public int getUpdateCount() {
        return this.mCount;
    }

    @Override
    public int getInt() {
        return this.getInt(0);
    }

    @Override
    public int getInt(int n) {
        if (this.checkType(1) && this.mData != null) {
            return (Integer)this.mData;
        }
        return n;
    }

    @Override
    public boolean setInt(int n) {
        if (this.checkType(1)) {
            Integer n2 = new Integer(n);
            if (this.mCount == 0 || this.mEnableNotificationWithoutChange || this.mData == null || !this.mData.equals(n2)) {
                this.setData(n2);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean incInt() {
        if (this.checkType(1)) {
            int n = this.mData == null ? 0 : (Integer)this.mData;
            this.setData(new Integer(n + 1));
            return true;
        }
        return false;
    }

    @Override
    public boolean decInt() {
        if (this.checkType(1)) {
            int n = this.mData == null ? 0 : (Integer)this.mData;
            this.setData(new Integer(n + 1));
            return true;
        }
        return false;
    }

    @Override
    public short getShort() {
        return this.getShort((short)0);
    }

    @Override
    public short getShort(short s) {
        if (this.checkType(4) && this.mData != null) {
            return (Short)this.mData;
        }
        return s;
    }

    @Override
    public boolean setShort(short s) {
        if (this.checkType(4)) {
            Short s2 = new Short(s);
            if (this.mCount == 0 || this.mEnableNotificationWithoutChange || this.mData == null || !this.mData.equals(s2)) {
                this.setData(s2);
                return true;
            }
        }
        return false;
    }

    @Override
    public long getLong(long l) {
        if (this.checkType(8) && this.mData != null) {
            return (Long)this.mData;
        }
        return l;
    }

    @Override
    public long getLong() {
        return this.getLong(0L);
    }

    @Override
    public boolean setLong(long l) {
        if (this.checkType(8)) {
            Long l2 = new Long(l);
            if (this.mCount == 0 || this.mEnableNotificationWithoutChange || this.mData == null || !this.mData.equals(l2)) {
                this.setData(l2);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean getBoolean() {
        return this.getBoolean(false);
    }

    @Override
    public boolean getBoolean(boolean bl) {
        if (this.checkType(2) && this.mData != null) {
            return (Boolean)this.mData;
        }
        return bl;
    }

    @Override
    public boolean setBoolean(boolean bl) {
        if (this.checkType(2)) {
            Boolean bl2 = new Boolean(bl);
            if (this.mCount == 0 || this.mEnableNotificationWithoutChange || this.mData == null || !this.mData.equals(bl2)) {
                this.setData(bl2);
                return true;
            }
        }
        return false;
    }

    @Override
    public String getString() {
        return this.getString("");
    }

    @Override
    public String getString(String string) {
        if (this.checkType(3) && this.mData != null) {
            return (String)this.mData;
        }
        return string;
    }

    @Override
    public boolean setString(String string) {
        if (this.checkType(3) && (this.mCount == 0 || this.mEnableNotificationWithoutChange || this.mData == null || !this.mData.equals(string))) {
            this.setData(string);
            return true;
        }
        return false;
    }

    @Override
    public RadioText getRadioText() {
        if (this.checkType(5) && this.mData != null) {
            return (RadioText)this.mData;
        }
        return null;
    }

    @Override
    public boolean setRadioText(RadioText radioText) {
        if (this.checkType(5)) {
            long l = ObjectCompare.calcHash(radioText);
            if (this.mCount == 0 || this.mEnableNotificationWithoutChange || this.mHash != l) {
                this.setData(radioText);
                this.mHash = l;
                return true;
            }
        }
        return false;
    }

    @Override
    public StationInfo getChannel() {
        if (this.checkType(6) && this.mData != null) {
            return (StationInfo)this.mData;
        }
        return null;
    }

    @Override
    public boolean setChannel(StationInfo stationInfo) {
        if (this.checkType(6)) {
            long l = ObjectCompare.calcHash(SatDb.getInstance().getImageDb(), stationInfo);
            if (this.mCount == 0 || this.mEnableNotificationWithoutChange || this.mHash != l) {
                this.setData(stationInfo);
                this.mHash = l;
                return true;
            }
        }
        return false;
    }

    @Override
    public CategoryInfo getCategory() {
        if (this.checkType(7) && this.mData != null) {
            return (CategoryInfo)this.mData;
        }
        return null;
    }

    @Override
    public boolean setCategory(CategoryInfo categoryInfo) {
        if (this.checkType(7)) {
            long l = ObjectCompare.calcHash(categoryInfo);
            if (this.mCount == 0 || this.mEnableNotificationWithoutChange || this.mHash != l) {
                this.setData(categoryInfo);
                this.mHash = l;
                return true;
            }
        }
        return false;
    }

    @Override
    public ResourceLocator getResourceLocator() {
        if (this.checkType(9) && this.mData != null) {
            return (ResourceLocator)this.mData;
        }
        return null;
    }

    @Override
    public boolean setResourceLocator(ResourceLocator resourceLocator) {
        if (this.checkType(9)) {
            long l = ObjectCompare.calcHash(resourceLocator);
            if (this.mCount == 0 || this.mEnableNotificationWithoutChange || this.mHash != l) {
                this.setData(resourceLocator);
                this.mHash = l;
                return true;
            }
        }
        return false;
    }

    @Override
    public EventGeneric getEvent() {
        if (this.checkType(12) && this.mData != null) {
            return (EventGeneric)this.mData;
        }
        return null;
    }

    @Override
    public boolean setEvent(EventGeneric eventGeneric) {
        if (this.checkType(12) && (this.mCount == 0 || this.mEnableNotificationWithoutChange || this.mData != eventGeneric)) {
            this.setData(eventGeneric);
            return true;
        }
        return false;
    }

    @Override
    public Object getObject() {
        if (this.checkType(10) && this.mData != null) {
            return this.mData;
        }
        return null;
    }

    @Override
    public boolean setObject(Object object) {
        if (this.checkType(10) && (this.mCount == 0 || this.mEnableNotificationWithoutChange || this.mData == null && object != null || this.mData != null && object == null || this.mData != null && !this.mData.equals(object))) {
            this.setData(object);
            return true;
        }
        return false;
    }

    @Override
    public Object[] getObjectArray() {
        if (this.checkType(11) && this.mDataArray != null) {
            return this.mDataArray;
        }
        return null;
    }

    @Override
    public boolean setObjectArray(Object[] objectArray) {
        if (this.checkType(11) && (this.mCount == 0 || this.mEnableNotificationWithoutChange || !Arrays.equals(this.mDataArray, objectArray))) {
            this.setDataArray(objectArray);
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(this.mName);
        stringBuffer.append("=");
        String string = this.getValueString();
        stringBuffer.append(string);
        return stringBuffer.toString();
    }

    @Override
    public void notifyUpdate() {
        this.mPool.notifyUpdate(this.mKey, this);
    }

    public String getValueString() {
        switch (this.mType) {
            case 11: {
                StringBuffer stringBuffer = new StringBuffer(300);
                if (this.mDataArray == null) {
                    stringBuffer.append("null");
                } else {
                    stringBuffer.append('[');
                    stringBuffer.append(this.mDataArray.length);
                    stringBuffer.append(']');
                    int n = Math.min(this.mDataArray.length, 5);
                    for (int i2 = 0; i2 < n; ++i2) {
                        if (i2 > 0) {
                            stringBuffer.append(", ");
                        }
                        if (this.mDataArray[i2] == null) {
                            stringBuffer.append("null");
                            continue;
                        }
                        stringBuffer.append(this.mDataArray[i2].toString());
                    }
                    if (this.mDataArray.length > 5) {
                        stringBuffer.append('(');
                        stringBuffer.append(this.mDataArray.length - 5);
                        stringBuffer.append("more)");
                    }
                }
                stringBuffer.append(" x");
                stringBuffer.append(this.mCount);
                return stringBuffer.toString();
            }
        }
        return this.mData == null ? "null" : this.mData.toString();
    }
}

