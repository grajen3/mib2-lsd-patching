/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.db;

import de.vw.mib.asl.framework.internal.persistence.internal.db.AbstractRecord;
import de.vw.mib.asl.framework.internal.persistence.internal.dsi.ApiPersDsi;
import de.vw.mib.genericevents.EventGeneric;

final class RecordString
extends AbstractRecord {
    private final String mData;

    RecordString(int n, long l, String string) {
        super(n, l);
        this.mData = string;
    }

    @Override
    public void setDataInEvent(EventGeneric eventGeneric) {
        eventGeneric.setString(2, this.mData);
    }

    @Override
    public byte getType() {
        return 2;
    }

    @Override
    public void writeToDsi(int n, long l) {
        ApiPersDsi.writeString(n, l, this.mData);
    }

    @Override
    public String dataString() {
        StringBuffer stringBuffer = new StringBuffer(10 + (this.mData == null ? 5 : this.mData.length()));
        stringBuffer.append("[value=");
        stringBuffer.append(this.mData);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override
    public String getTypeString() {
        return "String";
    }

    public String toString() {
        return new StringBuffer().append(this.getTypeString()).append(": ").append(this.mData).toString();
    }

    @Override
    public int hashCode() {
        int n = super.hashCode();
        n = 31 * n + this.mData.hashCode();
        return n;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object) && object instanceof RecordString) {
            RecordString recordString = (RecordString)object;
            return this.mData.equals(recordString.mData);
        }
        return false;
    }

    @Override
    public String getString() {
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
    public String[] getStringArray() {
        return null;
    }
}

