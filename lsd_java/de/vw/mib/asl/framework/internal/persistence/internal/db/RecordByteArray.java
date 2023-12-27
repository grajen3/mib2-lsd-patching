/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.db;

import de.vw.mib.asl.framework.internal.framework.util.LogUtil;
import de.vw.mib.asl.framework.internal.persistence.internal.db.AbstractRecord;
import de.vw.mib.asl.framework.internal.persistence.internal.db.Compression;
import de.vw.mib.asl.framework.internal.persistence.internal.dsi.ApiPersDsi;
import de.vw.mib.genericevents.EventGeneric;
import java.util.Arrays;

public final class RecordByteArray
extends AbstractRecord {
    private final byte[] mData;
    private final boolean mCompressionEnabled;

    public RecordByteArray(int n, long l, byte[] byArray, boolean bl) {
        super(n, l);
        this.mCompressionEnabled = bl;
        this.mData = Compression.isCompressed(byArray) ? Compression.uncompress(byArray) : (Compression.isAdler(byArray) ? Compression.removeAdler(byArray) : byArray);
        if (this.mData == null) {
            this.setValid(false);
        }
    }

    public boolean isCompressionEnabled() {
        return this.mCompressionEnabled;
    }

    @Override
    public void setDataInEvent(EventGeneric eventGeneric) {
        eventGeneric.setByteArray(2, this.mData);
    }

    @Override
    public byte getType() {
        return 3;
    }

    @Override
    public void writeToDsi(int n, long l) {
        if (this.mCompressionEnabled) {
            byte[] byArray = Compression.compress(this.mData);
            if (byArray.length != this.mData.length) {
                ApiPersDsi.writeBuffer(n, l, byArray);
            } else {
                byArray = Compression.addAdler(this.mData);
                ApiPersDsi.writeBuffer(n, l, byArray);
            }
        } else {
            ApiPersDsi.writeBuffer(n, l, this.mData);
        }
    }

    @Override
    public String dataString() {
        if (this.mData == null) {
            return "null";
        }
        StringBuffer stringBuffer = new StringBuffer(24);
        stringBuffer.append("[value.length=");
        stringBuffer.append(String.valueOf(this.mData.length));
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override
    public String getTypeString() {
        return "byte[]";
    }

    public String toString() {
        return new StringBuffer().append(this.getTypeString()).append(": ").append(LogUtil.toString(this.mData, 400, true)).toString();
    }

    @Override
    public byte[] getByteArray() {
        return this.mData;
    }

    @Override
    public int getInt() {
        return 0;
    }

    @Override
    public String getString() {
        return null;
    }

    @Override
    public String[] getStringArray() {
        return null;
    }

    private static int hashCode(byte[] byArray) {
        if (byArray == null) {
            return 0;
        }
        int n = 1;
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            n = 31 * n + byArray[i2];
        }
        return n;
    }

    @Override
    public int hashCode() {
        int n = super.hashCode();
        n = 31 * n + RecordByteArray.hashCode(this.mData);
        return n;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        RecordByteArray recordByteArray = (RecordByteArray)object;
        return Arrays.equals(this.mData, recordByteArray.mData);
    }
}

