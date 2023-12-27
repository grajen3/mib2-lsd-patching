/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.db;

import de.vw.mib.asl.framework.internal.persistence.internal.db.AbstractRecord;
import de.vw.mib.asl.framework.internal.persistence.internal.dsi.ApiPersDsi;
import de.vw.mib.genericevents.EventGeneric;
import edu.emory.mathcs.backport.java.util.Arrays;

final class RecordStringArray
extends AbstractRecord {
    private final String[] mData;

    RecordStringArray(int n, long l, String[] stringArray) {
        super(n, l);
        this.mData = stringArray;
    }

    @Override
    public void setDataInEvent(EventGeneric eventGeneric) {
        eventGeneric.setObject(2, this.mData);
    }

    @Override
    public byte getType() {
        return 4;
    }

    @Override
    public void writeToDsi(int n, long l) {
        ApiPersDsi.writeStringArray(n, l, this.mData);
    }

    @Override
    public String dataString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("[value={");
        if (this.mData == null) {
            stringBuffer.append("null");
        } else {
            stringBuffer.append("length=");
            stringBuffer.append(this.mData.length);
            stringBuffer.append(":");
            for (int i2 = 0; i2 < this.mData.length; ++i2) {
                if (i2 > 0) {
                    stringBuffer.append(',');
                }
                stringBuffer.append(this.mData[i2]);
            }
        }
        stringBuffer.append("}]");
        return stringBuffer.toString();
    }

    @Override
    public String getTypeString() {
        return "StringArray";
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("StringArray: ");
        stringBuffer.append(this.dataString());
        return stringBuffer.toString();
    }

    @Override
    public int hashCode() {
        int n = super.hashCode();
        if (this.mData != null) {
            n = 31 * n + this.mData.length;
            for (int i2 = 0; i2 < this.mData.length; ++i2) {
                n = 31 * n + this.mData[i2].hashCode();
            }
        }
        return n;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object) && object instanceof RecordStringArray) {
            RecordStringArray recordStringArray = (RecordStringArray)object;
            if (this.mData == null) {
                return recordStringArray.mData == null;
            }
            if (recordStringArray.mData == null) {
                return false;
            }
            if (this.mData.length != recordStringArray.mData.length) {
                return false;
            }
            return Arrays.equals(this.mData, recordStringArray.mData);
        }
        return false;
    }

    @Override
    public String[] getStringArray() {
        return this.mData;
    }

    @Override
    public byte[] getByteArray() {
        return null;
    }

    @Override
    public int getInt() {
        return 0;
    }

    @Override
    public String getString() {
        return null;
    }
}

