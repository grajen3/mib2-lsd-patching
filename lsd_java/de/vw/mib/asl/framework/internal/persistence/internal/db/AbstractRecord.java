/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.db;

import de.vw.mib.asl.framework.internal.persistence.internal.db.RecordByteArray;
import de.vw.mib.asl.framework.internal.persistence.internal.db.RecordInteger;
import de.vw.mib.asl.framework.internal.persistence.internal.db.RecordString;
import de.vw.mib.asl.framework.internal.persistence.internal.db.RecordStringArray;
import de.vw.mib.genericevents.EventGeneric;

public abstract class AbstractRecord {
    protected static final int PRIME;
    private final int mNamespace;
    private final long mKey;
    private boolean mIsValid = true;

    public AbstractRecord(int n, long l) {
        this.mNamespace = n;
        this.mKey = l;
    }

    public abstract void setDataInEvent(EventGeneric eventGeneric) {
    }

    public static AbstractRecord getDataFromEvent(EventGeneric eventGeneric, byte by) {
        switch (by) {
            case 1: {
                int n = eventGeneric.getInt(0);
                long l = eventGeneric.getLong(1);
                int n2 = eventGeneric.getInt(2);
                return AbstractRecord.createRecord(n, l, n2);
            }
            case 2: {
                int n = eventGeneric.getInt(0);
                long l = eventGeneric.getLong(1);
                String string = eventGeneric.getString(2);
                return AbstractRecord.createRecord(n, l, string);
            }
            case 4: {
                int n = eventGeneric.getInt(0);
                long l = eventGeneric.getLong(1);
                String[] stringArray = (String[])eventGeneric.getObject(2);
                return AbstractRecord.createRecord(n, l, stringArray);
            }
            case 3: {
                int n = eventGeneric.getInt(0);
                long l = eventGeneric.getLong(1);
                byte[] byArray = eventGeneric.getByteArray(2);
                return AbstractRecord.createRecord(n, l, byArray);
            }
        }
        return null;
    }

    public static AbstractRecord createRecord(int n, long l, int n2) {
        return new RecordInteger(n, l, n2);
    }

    public static AbstractRecord createRecord(int n, long l, String string) {
        return new RecordString(n, l, string);
    }

    public static AbstractRecord createRecord(int n, long l, String[] stringArray) {
        return new RecordStringArray(n, l, stringArray);
    }

    public static AbstractRecord createRecord(int n, long l, byte[] byArray) {
        return new RecordByteArray(n, l, byArray, true);
    }

    public String getLogTypeString() {
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append("[type=");
        stringBuffer.append(this.getTypeString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public abstract byte getType() {
    }

    public abstract String getTypeString() {
    }

    public abstract void writeToDsi(int n, long l) {
    }

    public abstract String dataString() {
    }

    public abstract int getInt() {
    }

    public abstract String getString() {
    }

    public abstract byte[] getByteArray() {
    }

    public abstract String[] getStringArray() {
    }

    public int getNamespace() {
        return this.mNamespace;
    }

    public long getKey() {
        return this.mKey;
    }

    public int hashCode() {
        int n = 31 + (int)(this.mKey ^ this.mKey >>> 32);
        n = 31 * n + this.mNamespace;
        n = 31 * n + this.getType();
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof AbstractRecord)) {
            return false;
        }
        AbstractRecord abstractRecord = (AbstractRecord)object;
        if (this.mKey != abstractRecord.mKey) {
            return false;
        }
        if (this.mNamespace != abstractRecord.mNamespace) {
            return false;
        }
        return this.getType() == abstractRecord.getType();
    }

    public boolean isValid() {
        return this.mIsValid;
    }

    public void setValid(boolean bl) {
        this.mIsValid = bl;
    }
}

