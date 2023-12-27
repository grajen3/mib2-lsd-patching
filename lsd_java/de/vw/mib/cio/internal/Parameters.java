/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.internal;

import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioPayload;
import de.vw.mib.collections.ObjectLongMap;
import de.vw.mib.collections.ObjectLongMap$Entry;
import de.vw.mib.collections.ObjectLongOptHashMap;
import de.vw.mib.util.StringBuilder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;

final class Parameters
implements CioActionParameters,
CioPayload {
    private final Map objectValues = new HashMap();
    private final ObjectLongMap primitiveValues = new ObjectLongOptHashMap();

    Parameters() {
    }

    @Override
    public boolean getBoolean(String string) {
        if (!this.hasPrimitiveValue(string)) {
            return false;
        }
        long l = this.primitiveValues.get(string);
        return l != 0L;
    }

    @Override
    public CioIntent getCioIntent(String string) {
        if (!this.hasCioIntentValue(string)) {
            return null;
        }
        return (CioIntent)this.objectValues.get(string);
    }

    @Override
    public float getFloat(String string) {
        if (!this.hasPrimitiveValue(string)) {
            return 0.0f;
        }
        long l = this.primitiveValues.get(string);
        return Float.intBitsToFloat((int)l);
    }

    @Override
    public int getInt(String string) {
        if (!this.hasPrimitiveValue(string)) {
            return 0;
        }
        long l = this.primitiveValues.get(string);
        return (int)l;
    }

    @Override
    public long getLong(String string) {
        if (!this.hasPrimitiveValue(string)) {
            return 0L;
        }
        long l = this.primitiveValues.get(string);
        return l;
    }

    @Override
    public Object getObject(String string) {
        if (!this.hasObjectValue(string)) {
            return null;
        }
        return this.objectValues.get(string);
    }

    @Override
    public String getString(String string) {
        if (!this.hasStringValue(string)) {
            return null;
        }
        return (String)this.objectValues.get(string);
    }

    @Override
    public boolean hasValue(String string) {
        if (this.hasPrimitiveValue(string)) {
            return true;
        }
        return this.hasObjectValue(string);
    }

    public String toString() {
        Object object;
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = this.primitiveValues.entryIterator();
        while (iterator.hasNext()) {
            object = (ObjectLongMap$Entry)iterator.next();
            stringBuilder.append(object.getKey()).append("=").append(object.getValue());
            if (!iterator.hasNext()) continue;
            stringBuilder.append(", ");
        }
        iterator = this.objectValues.entrySet().iterator();
        while (iterator.hasNext()) {
            object = (Map$Entry)iterator.next();
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(object.getKey()).append("=").append(object.getValue());
        }
        return stringBuilder.toString();
    }

    void setBoolean(String string, boolean bl) {
        this.primitiveValues.put(string, bl ? 1L : 0L);
    }

    void setCioIntent(String string, CioIntent cioIntent) {
        this.objectValues.put(string, cioIntent);
    }

    void setFloat(String string, float f2) {
        this.primitiveValues.put(string, Float.floatToIntBits(f2));
    }

    void setInt(String string, int n) {
        this.primitiveValues.put(string, n);
    }

    void setLong(String string, long l) {
        this.primitiveValues.put(string, l);
    }

    void setObject(String string, Object object) {
        this.objectValues.put(string, object);
    }

    void setString(String string, String string2) {
        this.objectValues.put(string, string2);
    }

    private boolean hasCioIntentValue(String string) {
        if (!this.hasObjectValue(string)) {
            return false;
        }
        return this.objectValues.get(string) instanceof CioIntent;
    }

    private boolean hasPrimitiveValue(String string) {
        return this.primitiveValues.containsKey(string);
    }

    private boolean hasObjectValue(String string) {
        return this.objectValues.containsKey(string);
    }

    private boolean hasStringValue(String string) {
        if (!this.hasObjectValue(string)) {
            return false;
        }
        return this.objectValues.get(string) instanceof String;
    }
}

