/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.pool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class PoorMansPool {
    private static final int INIT_POOL_SIZE;
    private static final Collection INSTANCES;
    private final List items;
    private final String name;
    private final int max;
    private int hits;
    private int misses;
    private int drops;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PoorMansPool(String string, int n) {
        this.name = string;
        this.max = n;
        this.items = new ArrayList(Math.min(10, n));
        Collection collection = INSTANCES;
        synchronized (collection) {
            INSTANCES.add(this);
        }
    }

    public synchronized Object borrow() {
        Object object;
        int n = this.items.size();
        if (0 < n) {
            object = this.items.remove(--n);
            ++this.hits;
        } else {
            object = null;
            ++this.misses;
        }
        return object;
    }

    public synchronized void release(Object object) {
        if (this.items.size() < this.max) {
            this.items.add(object);
        } else {
            ++this.drops;
        }
    }

    public synchronized void clear() {
        this.items.clear();
    }

    public synchronized StringBuffer append(StringBuffer stringBuffer) {
        stringBuffer.append("PoorMansPool[");
        PoorMansPool.appendString(stringBuffer, "name", this.name);
        PoorMansPool.appendSep(stringBuffer);
        PoorMansPool.appendInt(stringBuffer, "size", this.items.size());
        PoorMansPool.appendSep(stringBuffer);
        PoorMansPool.appendInt(stringBuffer, "max", this.max);
        PoorMansPool.appendSep(stringBuffer);
        PoorMansPool.appendInt(stringBuffer, "hits", this.hits);
        PoorMansPool.appendSep(stringBuffer);
        PoorMansPool.appendInt(stringBuffer, "misses", this.misses);
        PoorMansPool.appendSep(stringBuffer);
        PoorMansPool.appendInt(stringBuffer, "drops", this.drops);
        stringBuffer.append(']');
        return stringBuffer;
    }

    public String toString() {
        return this.append(new StringBuffer(110)).toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static StringBuffer report(StringBuffer stringBuffer) {
        Collection collection = INSTANCES;
        synchronized (collection) {
            Iterator iterator = INSTANCES.iterator();
            while (iterator.hasNext()) {
                PoorMansPool poorMansPool = (PoorMansPool)iterator.next();
                poorMansPool.append(stringBuffer).append('\n');
            }
        }
        return stringBuffer;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String[] report() {
        String[] stringArray;
        Collection collection = INSTANCES;
        synchronized (collection) {
            stringArray = new String[INSTANCES.size()];
            int n = 0;
            Iterator iterator = INSTANCES.iterator();
            while (iterator.hasNext()) {
                PoorMansPool poorMansPool = (PoorMansPool)iterator.next();
                stringArray[n++] = poorMansPool.toString();
            }
        }
        return stringArray;
    }

    private static void appendSep(StringBuffer stringBuffer) {
        stringBuffer.append(", ");
    }

    private static void appendString(StringBuffer stringBuffer, String string, String string2) {
        stringBuffer.append(string).append("=\"").append(string2).append('\"');
    }

    private static void appendInt(StringBuffer stringBuffer, String string, int n) {
        stringBuffer.append(string).append('=').append(n);
    }

    static {
        INSTANCES = new ArrayList();
    }
}

