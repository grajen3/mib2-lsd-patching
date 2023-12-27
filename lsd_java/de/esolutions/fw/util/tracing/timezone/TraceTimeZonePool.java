/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.timezone;

import de.esolutions.fw.util.tracing.timezone.TraceTimeZone;
import java.util.ArrayList;

public class TraceTimeZonePool {
    private final int size;
    private final TraceTimeZone[] zones;
    private int num;

    public TraceTimeZonePool(int n) {
        this.size = n;
        this.zones = new TraceTimeZone[n];
    }

    public synchronized int getTimeZone(String string) {
        for (int i2 = 0; i2 < this.num; ++i2) {
            if (!this.zones[i2].getName().equals(string)) continue;
            return i2;
        }
        return -1;
    }

    public synchronized TraceTimeZone addTimeZone(int n, String string, int n2) {
        if (this.num < this.size) {
            TraceTimeZone traceTimeZone;
            int n3 = this.num++;
            this.zones[n3] = traceTimeZone = new TraceTimeZone(n3, n, string, n2);
            return traceTimeZone;
        }
        return null;
    }

    public synchronized TraceTimeZone getTimeZone(int n) {
        if (n < this.num) {
            return this.zones[n];
        }
        return null;
    }

    public synchronized TraceTimeZone[] getAllTimeZonesCreatedInRange(int n, int n2) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.num; ++i2) {
            int n3 = this.zones[i2].getCreateEpoch();
            if (n3 < n || n3 > n2) continue;
            arrayList.add(this.zones[i2]);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Object[] objectArray = new TraceTimeZone[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }
}

