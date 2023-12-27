/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons;

import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;

public class ObjMapper {
    private String name;
    private Map map = new HashMap();
    private Object defKey;
    private Object defValue;
    public boolean hasDefault = false;
    public static final boolean DEBUG;

    public ObjMapper(String string) {
        this.name = string;
        this.defValue = null;
        this.hasDefault = false;
    }

    public Iterator getIterator() {
        return this.map.entrySet().iterator();
    }

    public void setDefault(Object object, Object object2) {
        this.defValue = object2;
        this.defKey = object;
        this.hasDefault = true;
    }

    public String getName() {
        return this.name;
    }

    private String instanceName() {
        return new StringBuffer().append("ObjMapper[").append(this.name).append("]").toString();
    }

    public boolean isKey(int n) {
        Integer n2 = new Integer(n);
        return this.isKey(n2);
    }

    public boolean isKey(Object object) {
        boolean bl = this.map.containsKey(object);
        return bl;
    }

    public Object getValue(int n) {
        Integer n2 = new Integer(n);
        return this.getValue(n2);
    }

    public Object getValue(Object object) {
        Object object2 = null;
        if (this.map.containsKey(object)) {
            object2 = this.map.get(object);
        } else if (this.hasDefault) {
            object2 = this.defValue;
        } else {
            object2 = null;
            throw new IndexOutOfBoundsException(new StringBuffer().append(this.instanceName()).append(" key [").append(object).append("] not in ObjMapper").toString());
        }
        return object2;
    }

    public Object getKey(Object object) {
        Object object2 = null;
        if (this.map.containsValue(object)) {
            Set set = this.map.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map$Entry map$Entry = (Map$Entry)iterator.next();
                if (!object.equals(map$Entry.getValue())) continue;
                object2 = map$Entry.getKey();
            }
        } else if (this.hasDefault) {
            object2 = this.defValue;
        } else {
            object2 = null;
            throw new IndexOutOfBoundsException(new StringBuffer().append(this.instanceName()).append(" value [").append(object).append("] not in ObjMapper").toString());
        }
        return object2;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append(new StringBuffer().append(this.instanceName()).append("(size=").append(this.map.size()).append(", ").toString());
        if (this.hasDefault) {
            buffer.append(new StringBuffer().append("Default(").append(this.defKey.toString()).append(",").append(this.defValue.toString()).append("),").toString());
        } else {
            buffer.append("no defaultVal - throws exceptions");
        }
        buffer.append(" data:");
        buffer.append(this.map.toString());
        return buffer.toString();
    }

    public void add(Object object, Object object2) {
        if (!this.map.containsKey(object)) {
            this.map.put(object, object2);
        }
    }

    public int numEntries() {
        return this.map.size();
    }
}

