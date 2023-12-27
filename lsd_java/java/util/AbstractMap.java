/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractMap$1;
import java.util.AbstractMap$3;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;

public abstract class AbstractMap
implements Map {
    Set keySet = null;
    Collection valuesCollection = null;

    protected AbstractMap() {
    }

    @Override
    public void clear() {
        this.entrySet().clear();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public boolean containsKey(Object var1_1) {
        block2: {
            var2_2 = this.entrySet().iterator();
            if (var1_1 == null) ** GOTO lbl9
            while (var2_2.hasNext()) {
                if (!var1_1.equals(((Map$Entry)var2_2.next()).getKey())) continue;
                return true;
            }
            break block2;
lbl-1000:
            // 1 sources

            {
                if (((Map$Entry)var2_2.next()).getKey() != null) continue;
                return true;
lbl9:
                // 2 sources

                ** while (var2_2.hasNext())
            }
        }
        return false;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public boolean containsValue(Object var1_1) {
        block2: {
            var2_2 = this.entrySet().iterator();
            if (var1_1 == null) ** GOTO lbl9
            while (var2_2.hasNext()) {
                if (!var1_1.equals(((Map$Entry)var2_2.next()).getValue())) continue;
                return true;
            }
            break block2;
lbl-1000:
            // 1 sources

            {
                if (((Map$Entry)var2_2.next()).getValue() != null) continue;
                return true;
lbl9:
                // 2 sources

                ** while (var2_2.hasNext())
            }
        }
        return false;
    }

    @Override
    public abstract Set entrySet() {
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Map) {
            Map map = (Map)object;
            if (this.size() != map.size()) {
                return false;
            }
            Set set = map.entrySet();
            Iterator iterator = this.entrySet().iterator();
            while (iterator.hasNext()) {
                if (set.contains(iterator.next())) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public Object get(Object var1_1) {
        block2: {
            var2_2 = this.entrySet().iterator();
            if (var1_1 == null) ** GOTO lbl11
            while (var2_2.hasNext()) {
                var3_3 = (Map$Entry)var2_2.next();
                if (!var1_1.equals(var3_3.getKey())) continue;
                return var3_3.getValue();
            }
            break block2;
lbl-1000:
            // 1 sources

            {
                var3_4 = (Map$Entry)var2_2.next();
                if (var3_4.getKey() != null) continue;
                return var3_4.getValue();
lbl11:
                // 2 sources

                ** while (var2_2.hasNext())
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        int n = 0;
        Iterator iterator = this.entrySet().iterator();
        while (iterator.hasNext()) {
            n += iterator.next().hashCode();
        }
        return n;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public Set keySet() {
        if (this.keySet == null) {
            this.keySet = new AbstractMap$1(this);
        }
        return this.keySet;
    }

    @Override
    public Object put(Object object, Object object2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Map map) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            this.put(map$Entry.getKey(), map$Entry.getValue());
        }
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public Object remove(Object var1_1) {
        block2: {
            var2_2 = this.entrySet().iterator();
            if (var1_1 == null) ** GOTO lbl13
            while (var2_2.hasNext()) {
                var3_3 = (Map$Entry)var2_2.next();
                if (!var1_1.equals(var3_3.getKey())) continue;
                var2_2.remove();
                return var3_3.getValue();
            }
            break block2;
lbl-1000:
            // 1 sources

            {
                var3_4 = (Map$Entry)var2_2.next();
                if (var3_4.getKey() != null) continue;
                var2_2.remove();
                return var3_4.getValue();
lbl13:
                // 2 sources

                ** while (var2_2.hasNext())
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.entrySet().size();
    }

    public String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        StringBuffer stringBuffer = new StringBuffer(this.size() * 28);
        stringBuffer.append('{');
        Iterator iterator = this.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            Object object = map$Entry.getKey();
            if (object != this) {
                stringBuffer.append(object);
            } else {
                stringBuffer.append("(this Map)");
            }
            stringBuffer.append('=');
            Object object2 = map$Entry.getValue();
            if (object2 != this) {
                stringBuffer.append(object2);
            } else {
                stringBuffer.append("(this Map)");
            }
            stringBuffer.append(", ");
        }
        if (stringBuffer.length() > 1) {
            stringBuffer.setLength(stringBuffer.length() - 2);
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override
    public Collection values() {
        if (this.valuesCollection == null) {
            this.valuesCollection = new AbstractMap$3(this);
        }
        return this.valuesCollection;
    }

    protected Object clone() {
        AbstractMap abstractMap = (AbstractMap)super.clone();
        abstractMap.keySet = null;
        abstractMap.valuesCollection = null;
        return abstractMap;
    }
}

