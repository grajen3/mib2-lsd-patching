/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.api.adapter;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbpq.ServiceManager;

public final class BAPDataPoolValueAdapter {
    public static final int BAPDATATYPE_INT8_DATATYPE;
    public static final int BAPDATATYPE_INT16_DATATYPE;
    public static final int BAPDATATYPE_INT32_DATATYPE;
    public static final int BAPDATATYPE_BYTESEQUENCE_DATATYPE;
    public static final int BAPFNCT_TYPE_PROPERTY;
    public static final int BAPFNCT_TYPE_ARRAY;
    public static final int BAPFNCT_TYPE_METHOD;
    private final int fctID;
    private final int dataType;
    private final int fctType;
    private final String valueName;
    private BAPEntity currentValue;
    private BAPEntity lastSendValue;
    private BAPEntity queuedValue;
    private Object initData;

    BAPDataPoolValueAdapter(int n, int n2, int n3, String string) {
        this.fctID = n;
        this.dataType = n2;
        this.fctType = n3;
        this.valueName = string;
        this.currentValue = null;
        this.lastSendValue = null;
        this.queuedValue = null;
        this.initData = null;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(this.valueName);
        stringBuffer.append(": ");
        stringBuffer.append(String.valueOf(this.currentValue));
        return stringBuffer.toString();
    }

    void setInitData(Object object) {
        this.initData = object;
    }

    public Object getInitData() {
        return this.initData;
    }

    public void clearInitializer() {
        this.initData = null;
    }

    public int getDataType() {
        return this.dataType;
    }

    public String getValueName() {
        return this.valueName;
    }

    public int getFctID() {
        return this.fctID;
    }

    public int getFctType() {
        return this.fctType;
    }

    public BAPEntity getValueToTransmit() {
        BAPEntity bAPEntity = this.currentValue;
        if (this.currentValue != null) {
            if (this.lastSendValue != null) {
                this.setQueuedValue(this.lastSendValue);
            }
            this.lastSendValue = this.currentValue;
            this.currentValue = null;
        }
        return bAPEntity;
    }

    public void setCurrentValue(BAPEntity bAPEntity) {
        if (this.currentValue != null) {
            this.setQueuedValue(this.currentValue);
        }
        this.currentValue = bAPEntity;
    }

    public BAPEntity getLastValidValue() {
        return this.currentValue == null ? this.lastSendValue : this.currentValue;
    }

    public void setQueuedValue(BAPEntity bAPEntity) {
        this.queuedValue = bAPEntity;
    }

    public BAPEntity getQueuedValue() {
        return this.queuedValue;
    }

    public void restoreLastValue() {
        if (this.currentValue == null) {
            this.currentValue = this.lastSendValue;
            this.lastSendValue = null;
        }
    }

    public Object nativeDataValue(BAPEntity bAPEntity) {
        Object object;
        switch (this.getDataType()) {
            case 3: {
                object = ServiceManager.serviceManager.bitStreamTransformer.toByteArray(bAPEntity);
                break;
            }
            case 2: {
                object = new Integer(ServiceManager.serviceManager.bitStreamTransformer.toInteger(bAPEntity, 32));
                break;
            }
            case 1: {
                object = new Integer(ServiceManager.serviceManager.bitStreamTransformer.toInteger(bAPEntity, 16));
                break;
            }
            case 0: {
                object = new Integer(ServiceManager.serviceManager.bitStreamTransformer.toInteger(bAPEntity, 8));
                break;
            }
            default: {
                object = null;
            }
        }
        return object;
    }
}

