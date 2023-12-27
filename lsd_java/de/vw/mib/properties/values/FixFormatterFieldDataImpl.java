/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.properties.values;

import de.vw.mib.properties.values.FixFormatterFieldData;
import java.util.HashMap;
import java.util.Set;

public final class FixFormatterFieldDataImpl
implements FixFormatterFieldData {
    private final HashMap fieldData = new HashMap();

    @Override
    public boolean contains(String string) {
        return this.fieldData.containsKey(string);
    }

    @Override
    public Boolean getBoolean(String string) {
        return (Boolean)this.fieldData.get(string);
    }

    @Override
    public Integer getInt(String string) {
        return (Integer)this.fieldData.get(string);
    }

    @Override
    public Long getLong(String string) {
        return (Long)this.fieldData.get(string);
    }

    @Override
    public String getString(String string) {
        Object object = this.fieldData.get(string);
        return object != null ? String.valueOf(object) : null;
    }

    @Override
    public int[][] get2dIntArray(String string) {
        return (int[][])this.fieldData.get(string);
    }

    @Override
    public Set keySet() {
        return this.fieldData.keySet();
    }

    public void put(String string, boolean bl) {
        this.fieldData.put(string, bl);
    }

    public void put(String string, int n) {
        this.fieldData.put(string, new Integer(n));
    }

    public void put(String string, long l) {
        this.fieldData.put(string, new Long(l));
    }

    public void put(String string, String string2) {
        this.fieldData.put(string, string2);
    }

    public void put2dIntArray(String string, int[][] nArray) {
        this.fieldData.put(string, nArray);
    }
}

