/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.asl.internal.navigation.api.impl.data;

import de.vw.mib.asl.api.navigation.data.ASLNavigationDataList;
import de.vw.mib.asl.api.navigation.data.ASLNavigationDataMap;
import de.vw.mib.asl.internal.navigation.api.impl.data.ASLNavigationDataContainerImpl;
import de.vw.mib.asl.internal.navigation.api.impl.data.ASLNavigationDataListImpl;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class ASLNavigationDataMapImpl
extends ASLNavigationDataContainerImpl
implements ASLNavigationDataMap {
    private final Hashtable mapData = new Hashtable();

    public void addSubMapInternal(String string, ASLNavigationDataMap aSLNavigationDataMap) {
        this.mapData.put(string, aSLNavigationDataMap);
    }

    @Override
    public void clear() {
        this.mapData.clear();
    }

    @Override
    public boolean isEmpty() {
        return this.mapData.isEmpty();
    }

    @Override
    public int size() {
        return this.mapData.size();
    }

    @Override
    public boolean containsKey(String string) {
        return this.mapData.containsKey(string);
    }

    @Override
    public Object removeKey(String string) {
        return this.mapData.remove(string);
    }

    @Override
    public Enumeration keys() {
        return this.mapData.keys();
    }

    @Override
    public ASLNavigationDataMap getASLNavigationMap(String string) {
        Object object = this.mapData.get(string);
        if (object == null) {
            object = new ASLNavigationDataMapImpl();
            this.mapData.put(string, object);
        }
        return object instanceof ASLNavigationDataMap ? (ASLNavigationDataMap)object : null;
    }

    @Override
    public void setBoolean(String string, boolean bl) {
        this.mapData.put(string, bl);
    }

    @Override
    public boolean getBoolean(String string) {
        Object object = this.mapData.get(string);
        if (object == null) {
            return false;
        }
        if (object instanceof Boolean) {
            return (Boolean)object;
        }
        if (object instanceof String) {
            return Boolean.getBoolean((String)object);
        }
        if (object instanceof Number) {
            return ((Number)object).longValue() != 0L;
        }
        return false;
    }

    @Override
    public void setInt(String string, int n) {
        this.mapData.put(string, new Integer(n));
    }

    @Override
    public int getInt(String string) {
        Object object = this.mapData.get(string);
        if (object instanceof Number) {
            return ((Number)object).intValue();
        }
        return 0;
    }

    @Override
    public void setIntArray(String string, int[] nArray) {
        if (nArray == null) {
            this.mapData.remove(string);
        } else {
            this.mapData.put(string, nArray);
        }
    }

    @Override
    public int[] getIntArray(String string) {
        Object object = this.mapData.get(string);
        if (object instanceof int[]) {
            return (int[])object;
        }
        return new int[0];
    }

    @Override
    public void setString(String string, String string2) {
        if (string2 == null) {
            this.mapData.remove(string);
        } else {
            this.mapData.put(string, string2);
        }
    }

    @Override
    public String getString(String string) {
        Object object = this.mapData.get(string);
        if (object instanceof String) {
            return (String)object;
        }
        return "";
    }

    @Override
    public byte[] getByteArray(String string) {
        Object object = this.mapData.get(string);
        if (object instanceof byte[]) {
            return (byte[])object;
        }
        return new byte[0];
    }

    @Override
    public void setByteArray(String string, byte[] byArray) {
        if (byArray == null) {
            this.mapData.remove(string);
        } else {
            this.mapData.put(string, byArray);
        }
    }

    @Override
    public void setByte(String string, byte by) {
        this.mapData.put(string, new Byte(by));
    }

    @Override
    public byte getByte(String string) {
        Object object = this.mapData.get(string);
        if (object instanceof Number) {
            return ((Number)object).byteValue();
        }
        return 0;
    }

    @Override
    public void setChar(String string, char c2) {
        this.mapData.put(string, new Character(c2));
    }

    @Override
    public char getChar(String string) {
        Object object = this.mapData.get(string);
        if (object instanceof Character) {
            return ((Character)object).charValue();
        }
        return '\u0000';
    }

    @Override
    public void setDouble(String string, double d2) {
        this.mapData.put(string, new Double(d2));
    }

    @Override
    public double getDouble(String string) {
        Object object = this.mapData.get(string);
        if (object instanceof Number) {
            return ((Number)object).doubleValue();
        }
        return 0.0;
    }

    @Override
    public void setFloat(String string, float f2) {
        this.mapData.put(string, new Float(f2));
    }

    @Override
    public float getFloat(String string) {
        Object object = this.mapData.get(string);
        if (object instanceof Number) {
            return ((Number)object).floatValue();
        }
        return 0.0f;
    }

    @Override
    public void setLong(String string, long l) {
        this.mapData.put(string, new Long(l));
    }

    @Override
    public long getLong(String string) {
        Object object = this.mapData.get(string);
        if (object instanceof Number) {
            return ((Number)object).longValue();
        }
        return 0L;
    }

    @Override
    public void setShort(String string, short s) {
        this.mapData.put(string, new Short(s));
    }

    @Override
    public short getShort(String string) {
        Object object = this.mapData.get(string);
        if (object instanceof Number) {
            return ((Number)object).shortValue();
        }
        return 0;
    }

    public String toString() {
        return this.mapData.toString();
    }

    @Override
    public ASLNavigationDataList getASLNavigationList(String string) {
        Object object = this.mapData.get(string);
        if (object == null) {
            object = new ASLNavigationDataListImpl();
            this.mapData.put(string, object);
        }
        return object instanceof ASLNavigationDataList ? (ASLNavigationDataList)object : null;
    }

    @Override
    public void setObject(String string, Object object) {
        this.mapData.put(string, object);
    }

    @Override
    public Object getObject(String string) {
        return this.mapData.get(string);
    }

    @Override
    public boolean containsKey(Object object) {
        return this.mapData.containsKey(object);
    }

    @Override
    public boolean containsValue(Object object) {
        return this.mapData.containsValue(object);
    }

    @Override
    public Set entrySet() {
        return this.mapData.entrySet();
    }

    @Override
    public Object get(Object object) {
        return this.mapData.get(object);
    }

    @Override
    public Set keySet() {
        return this.mapData.keySet();
    }

    @Override
    public Object put(Object object, Object object2) {
        return this.mapData.put(object, object2);
    }

    @Override
    public void putAll(Map map) {
        this.mapData.putAll(map);
    }

    @Override
    public Object remove(Object object) {
        return this.mapData.remove(object);
    }

    @Override
    public Collection values() {
        return this.mapData.values();
    }
}

