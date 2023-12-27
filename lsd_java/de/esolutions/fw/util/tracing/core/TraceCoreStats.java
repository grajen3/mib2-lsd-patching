/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.core;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.tracing.core.TraceCoreStats$Stats;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class TraceCoreStats {
    private final HashMap keyStatsMap = new HashMap();
    private final ArrayList keys = new ArrayList();
    private long seqNum;
    public static final int FLAG_NONE;
    public static final int FLAG_AVERAGE;
    public static final int FLAG_INCREMENT;
    public static final int FLAG_RESET;
    public static final int FLAG_MAX;

    public synchronized void registerKey(String string, int n) {
        TraceCoreStats$Stats traceCoreStats$Stats = new TraceCoreStats$Stats(this, n);
        this.keyStatsMap.put(string, traceCoreStats$Stats);
        this.keys.add(string);
    }

    public synchronized void updateKey(String string, int n) {
        TraceCoreStats$Stats traceCoreStats$Stats = (TraceCoreStats$Stats)this.keyStatsMap.get(string);
        if (traceCoreStats$Stats != null) {
            traceCoreStats$Stats.update(n);
        }
    }

    public synchronized String readValues() {
        Buffer buffer = new Buffer(80);
        ++this.seqNum;
        buffer.append("seq=");
        buffer.append(this.seqNum);
        Iterator iterator = this.keys.iterator();
        while (iterator.hasNext()) {
            buffer.append(";");
            String string = (String)iterator.next();
            buffer.append(string);
            buffer.append("=");
            TraceCoreStats$Stats traceCoreStats$Stats = (TraceCoreStats$Stats)this.keyStatsMap.get(string);
            if (traceCoreStats$Stats != null) {
                int n = traceCoreStats$Stats.read();
                buffer.append(n);
                continue;
            }
            buffer.append("n/a");
        }
        buffer.append(";");
        return buffer.toString();
    }
}

