/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.internal.ModelApiEventService;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntLongMap;
import de.vw.mib.collections.ints.IntLongOptHashMap;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.modelapi.ModelApiEvent;
import de.vw.mib.util.StringBuilder;

abstract class ModelApiEventService$BaseModelApiEvent
implements ModelApiEvent {
    private final int actionId;
    private final IntObjectMap objectValues;
    private final IntLongMap primitiveValues;
    private final IntIntMap valueTypes;
    private final /* synthetic */ ModelApiEventService this$0;

    ModelApiEventService$BaseModelApiEvent(ModelApiEventService modelApiEventService, int n) {
        this.this$0 = modelApiEventService;
        this.actionId = n;
        this.objectValues = new IntObjectOptHashMap();
        this.primitiveValues = new IntLongOptHashMap();
        this.valueTypes = new IntIntOptHashMap();
    }

    @Override
    public boolean getBoolean(int n) {
        if (!this.hasPrimitiveValue(n)) {
            return false;
        }
        long l = this.primitiveValues.get(n);
        return l != 0L;
    }

    @Override
    public float getFloat(int n) {
        if (!this.hasPrimitiveValue(n)) {
            return 0.0f;
        }
        long l = this.primitiveValues.get(n);
        return Float.intBitsToFloat((int)l);
    }

    @Override
    public int getInt(int n) {
        if (!this.hasPrimitiveValue(n)) {
            return 0;
        }
        long l = this.primitiveValues.get(n);
        return (int)l;
    }

    @Override
    public long getLong(int n) {
        if (!this.hasPrimitiveValue(n)) {
            return 0L;
        }
        long l = this.primitiveValues.get(n);
        return l;
    }

    @Override
    public Object getObject(int n) {
        if (!this.hasObjectValue(n)) {
            return null;
        }
        return this.objectValues.get(n);
    }

    @Override
    public String getString(int n) {
        if (!this.hasStringValue(n)) {
            return null;
        }
        return (String)this.objectValues.get(n);
    }

    @Override
    public int getActionId() {
        return this.actionId;
    }

    @Override
    public int getParamCount() {
        return this.primitiveValues.size() + this.objectValues.size();
    }

    @Override
    public void setBoolean(int n, boolean bl) {
        this.valueTypes.put(n, 1);
        this.primitiveValues.put(n, bl ? 1L : 0L);
    }

    @Override
    public void setFloat(int n, float f2) {
        this.valueTypes.put(n, 4);
        this.primitiveValues.put(n, Float.floatToIntBits(f2));
    }

    @Override
    public void setInt(int n, int n2) {
        this.valueTypes.put(n, 2);
        this.primitiveValues.put(n, n2);
    }

    @Override
    public void setLong(int n, long l) {
        this.valueTypes.put(n, 3);
        this.primitiveValues.put(n, l);
    }

    @Override
    public void setObject(int n, Object object) {
        this.valueTypes.put(n, 5);
        this.objectValues.put(n, object);
    }

    @Override
    public void setString(int n, String string) {
        this.valueTypes.put(n, 0);
        this.objectValues.put(n, string);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("actionId: ").append(this.actionId);
        for (int i2 = 0; i2 < this.getParamCount(); ++i2) {
            int n = this.valueTypes.get(i2);
            stringBuilder.append(", ").append(this.toString(i2, n));
        }
        return stringBuilder.toString();
    }

    abstract boolean isUnbound() {
    }

    private boolean hasPrimitiveValue(int n) {
        return this.primitiveValues.containsKey(n);
    }

    private boolean hasObjectValue(int n) {
        return this.objectValues.containsKey(n);
    }

    private boolean hasStringValue(int n) {
        if (!this.hasObjectValue(n)) {
            return false;
        }
        return this.objectValues.get(n) instanceof String;
    }

    private String toString(int n, int n2) {
        switch (n2) {
            case 1: {
                return new StringBuffer().append("").append(this.getBoolean(n)).toString();
            }
            case 4: {
                return new StringBuffer().append("").append(this.getFloat(n)).toString();
            }
            case 2: {
                return new StringBuffer().append("").append(this.getInt(n)).toString();
            }
            case 3: {
                return new StringBuffer().append("").append(this.getLong(n)).toString();
            }
            case 0: {
                return new StringBuffer().append("").append(this.getString(n)).toString();
            }
            case 5: {
                return new StringBuffer().append("").append(this.getObject(n)).toString();
            }
        }
        return "";
    }
}

