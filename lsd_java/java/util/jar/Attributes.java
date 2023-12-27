/*
 * Decompiled with CFR 0.152.
 */
package java.util.jar;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.jar.Attributes$Name;

public class Attributes
implements Cloneable,
Map {
    protected Map map;

    public Attributes() {
        this.map = new HashMap();
    }

    public Attributes(Attributes attributes) {
        this.map = (Map)((HashMap)attributes.map).clone();
    }

    public Attributes(int n) {
        this.map = new HashMap(n);
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @Override
    public boolean containsKey(Object object) {
        return this.map.containsKey(object);
    }

    @Override
    public boolean containsValue(Object object) {
        return this.map.containsValue(object);
    }

    @Override
    public Set entrySet() {
        return this.map.entrySet();
    }

    @Override
    public Object get(Object object) {
        return this.map.get(object);
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public Set keySet() {
        return this.map.keySet();
    }

    @Override
    public Object put(Object object, Object object2) {
        return this.map.put((Attributes$Name)object, (String)object2);
    }

    @Override
    public void putAll(Map map) {
        this.map.putAll((Attributes)map);
    }

    @Override
    public Object remove(Object object) {
        return this.map.remove(object);
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public Collection values() {
        return this.map.values();
    }

    public Object clone() {
        Attributes attributes;
        try {
            attributes = (Attributes)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
        attributes.map = (Map)((HashMap)this.map).clone();
        return attributes;
    }

    @Override
    public int hashCode() {
        return this.map.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Attributes) {
            return this.map.equals(((Attributes)object).map);
        }
        return false;
    }

    public String getValue(Attributes$Name attributes$Name) {
        return (String)this.map.get(attributes$Name);
    }

    public String getValue(String string) {
        return (String)this.map.get(new Attributes$Name(string));
    }

    public String putValue(String string, String string2) {
        return (String)this.map.put(new Attributes$Name(string), string2);
    }
}

