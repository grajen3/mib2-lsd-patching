/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.DatapoolUpdateEvent;
import de.vw.mib.event.internal.AbstractPooledEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.InvocationContext;
import de.vw.mib.log4mib.LogMessage;
import edu.emory.mathcs.backport.java.util.Arrays;

public final class DatapoolUpdateEventImpl
extends AbstractPooledEvent
implements DatapoolUpdateEvent {
    private boolean booleanValue;
    private float floatValue;
    private int id;
    private int integerValue;
    private long longValue;
    private int type;
    private Object value;

    DatapoolUpdateEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public void backToPool() {
        this.value = null;
    }

    @Override
    public void dispatchEvent() {
        ServiceManager.datapool.consumeEvent(this);
    }

    @Override
    public boolean getBooleanValue() {
        return this.booleanValue;
    }

    @Override
    public float getFloatValue() {
        return this.floatValue;
    }

    @Override
    public int getIntegerValue() {
        return this.integerValue;
    }

    @Override
    public long getLongValue() {
        return this.longValue;
    }

    @Override
    public Object getObjectValue() {
        return this.value;
    }

    @Override
    public int getPropertyId() {
        return this.id;
    }

    @Override
    public int getType() {
        return this.type;
    }

    public String getValueAsString() {
        switch (this.type) {
            case 1: {
                return Boolean.toString(this.booleanValue);
            }
            case 0: {
                return Integer.toString(this.integerValue);
            }
            case 2: {
                if (this.value == null) {
                    return "null";
                }
                if (this.value.getClass().isArray()) {
                    if (this.value instanceof boolean[]) {
                        return Arrays.toString((boolean[])this.value);
                    }
                    if (this.value instanceof int[]) {
                        return Arrays.toString((int[])this.value);
                    }
                    if (this.value instanceof long[]) {
                        return Arrays.toString((long[])this.value);
                    }
                    if (this.value instanceof float[]) {
                        return Arrays.toString((float[])this.value);
                    }
                    return Arrays.toString((Object[])this.value);
                }
                return this.value.toString();
            }
            case 3: {
                return Long.toString(this.longValue);
            }
            case 4: {
                return Float.toString(this.floatValue);
            }
        }
        return "unknown value type";
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("DatapoolUpdateEvent - property: ").append(this.id).append(" , new value: ").append(this.getValueAsString());
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("DatapoolUpdateEvent - property: ").append(this.id).append(" , new value: ").append(this.getValueAsString());
    }

    @Override
    public void traceEnqueue(byte by) {
        this.invocationContext = InvocationContext.getCurrentInvocationContext(null);
        InvocationContext invocationContext = this.invocationContext.createSpecificBranch(this.invocationContext.getForkBranchId());
        if (InvocationContext.isActive()) {
            this.traceEvent((byte)0, by);
        }
        this.invocationContext = invocationContext;
    }

    Object getValue() {
        switch (this.type) {
            case 1: {
                return this.booleanValue;
            }
            case 0: {
                return new Integer(this.integerValue);
            }
            case 2: {
                return this.value;
            }
            case 3: {
                return new Long(this.longValue);
            }
            case 4: {
                return new Float(this.floatValue);
            }
        }
        throw new IllegalStateException("unknown DatapoolUpdateEvent type!");
    }

    void setContent(int n, boolean bl) {
        this.type = 1;
        this.id = n;
        this.booleanValue = bl;
    }

    void setContent(int n, float f2) {
        this.type = 4;
        this.id = n;
        this.floatValue = f2;
    }

    void setContent(int n, int n2) {
        this.type = 0;
        this.id = n;
        this.integerValue = n2;
    }

    void setContent(int n, long l) {
        this.type = 3;
        this.id = n;
        this.longValue = l;
    }

    void setContent(int n, Object object) {
        this.type = 2;
        this.id = n;
        this.value = object;
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

