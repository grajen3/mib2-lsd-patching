/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.motorwayinfo.transformer;

import de.vw.mib.util.StringBuilder;

public class TmcMessageAheadDataCollector
implements Comparable {
    public long id = 0L;
    public long distance = 0L;
    public long dtm = 0L;
    public int resourceId = 0;
    public int destinationIndex = 0;

    public int hashCode() {
        int n = 31;
        int n2 = 17;
        n2 = 31 * n2 + (int)(this.id ^ this.id >>> 32);
        n2 = 31 * n2 + (int)(this.dtm ^ this.dtm >>> 32);
        return n2;
    }

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
        TmcMessageAheadDataCollector tmcMessageAheadDataCollector = (TmcMessageAheadDataCollector)object;
        return this.id == tmcMessageAheadDataCollector.id;
    }

    @Override
    public int compareTo(Object object) {
        TmcMessageAheadDataCollector tmcMessageAheadDataCollector = (TmcMessageAheadDataCollector)object;
        if (this.dtm < tmcMessageAheadDataCollector.dtm) {
            return -1;
        }
        return 1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("TmcMessageAheadDataCollector [dtm=");
        stringBuilder.append(this.dtm);
        stringBuilder.append(", distance=");
        stringBuilder.append(this.distance);
        stringBuilder.append(", messageId=");
        stringBuilder.append(this.id);
        stringBuilder.append(", resourceId=");
        stringBuilder.append(this.resourceId);
        stringBuilder.append(", destinationIndex=");
        stringBuilder.append(this.destinationIndex);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

