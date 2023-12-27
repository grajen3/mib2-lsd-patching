/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework;

import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

public class GenericCollector {
    IntObjectOptHashMap data = new IntObjectOptHashMap();

    public GenericCollector() {
    }

    public GenericCollector(int[] nArray, Object[] objectArray) {
        for (int i2 = 0; i2 < nArray.length && i2 < objectArray.length; ++i2) {
            this.data.put(nArray[i2], objectArray[i2]);
        }
    }

    public GenericCollector(Object[] objectArray) {
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            this.data.put(i2, objectArray[i2]);
        }
    }

    public void setStringItem(int n, String string) {
        this.data.put(n, string);
    }

    public String getStringItem(int n) {
        Object object = this.data.get(n);
        if (object != null && object instanceof String) {
            return (String)object;
        }
        return "";
    }

    public void setIntItem(int n, int n2) {
        this.data.put(n, new Integer(n2));
    }

    public int getIntItem(int n) {
        Object object = this.data.get(n);
        if (object != null && object instanceof Number) {
            return ((Number)object).intValue();
        }
        return 0;
    }

    public void setLongItem(int n, long l) {
        this.data.put(n, new Long(l));
    }

    public long getLongItem(int n) {
        Object object = this.data.get(n);
        if (object != null && object instanceof Number) {
            return ((Number)object).longValue();
        }
        return 0L;
    }

    public String toString() {
        return new StringBuffer().append("<").append(super.getClass().getName()).append(" ").append(this.data.toString()).append(">").toString();
    }

    public GenericCollector copy() {
        GenericCollector genericCollector = new GenericCollector();
        IntIterator intIterator = this.data.keySet().iterator();
        while (intIterator.hasNext()) {
            int n = intIterator.next();
            Object object = this.data.get(n);
            genericCollector.data.put(n, object);
        }
        return genericCollector;
    }
}

