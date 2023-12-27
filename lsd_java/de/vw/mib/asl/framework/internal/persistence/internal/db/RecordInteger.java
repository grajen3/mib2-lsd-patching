/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.db;

import de.vw.mib.asl.framework.internal.persistence.internal.db.AbstractRecord;
import de.vw.mib.asl.framework.internal.persistence.internal.dsi.ApiPersDsi;
import de.vw.mib.genericevents.EventGeneric;

final class RecordInteger
extends AbstractRecord {
    private final int mData;

    RecordInteger(int n, long l, int n2) {
        super(n, l);
        this.mData = n2;
    }

    @Override
    public void setDataInEvent(EventGeneric eventGeneric) {
        eventGeneric.setInt(2, this.mData);
    }

    @Override
    public byte getType() {
        return 1;
    }

    @Override
    public void writeToDsi(int n, long l) {
        ApiPersDsi.writeInt(n, l, this.mData);
    }

    @Override
    public String dataString() {
        StringBuffer stringBuffer = new StringBuffer(20);
        stringBuffer.append("[value=");
        stringBuffer.append(Integer.toString(this.mData));
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override
    public String getTypeString() {
        return "Integer";
    }

    public String toString() {
        return new StringBuffer().append(this.getTypeString()).append(": ").append(this.mData).toString();
    }

    @Override
    public int hashCode() {
        int n = super.hashCode();
        n = 31 * n + this.mData;
        return n;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object) && object instanceof RecordInteger) {
            RecordInteger recordInteger = (RecordInteger)object;
            return this.mData == recordInteger.mData;
        }
        return false;
    }

    @Override
    public int getInt() {
        return this.mData;
    }

    @Override
    public byte[] getByteArray() {
        return null;
    }

    @Override
    public String getString() {
        return null;
    }

    @Override
    public String[] getStringArray() {
        return null;
    }
}

