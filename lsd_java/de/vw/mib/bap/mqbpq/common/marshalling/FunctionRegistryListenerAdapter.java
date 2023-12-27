/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.marshalling;

import de.vw.mib.asl.api.bap.dispatcher.BAPDispatcher;
import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.marshalling.BAPIndicationMarshaller;

public class FunctionRegistryListenerAdapter
implements ArrayListener,
MethodListener,
PropertyListener {
    private int _fctID;
    private final int _lsgID;
    private final BAPDispatcher _bapDispatcher;
    private static final int OPERATION_CODE_ERROR;
    private static final int OPERATION_CODE_STATUS_PROPERTY;
    private static final int OPERATION_CODE_STATUS_ARRAY;
    private static final int OPERATION_CODE_STATUS_ACK;
    private static final int OPERATION_CODE_RESULT;
    private static final int OPERATION_CODE_CHANGED;

    public FunctionRegistryListenerAdapter(int n, BAPDispatcher bAPDispatcher) {
        this._lsgID = n;
        this._bapDispatcher = bAPDispatcher;
    }

    private BAPDispatcher getBapDispatcher() {
        return this._bapDispatcher;
    }

    private void setFctID(int n) {
        this._fctID = n;
    }

    protected int getFctID() {
        return this._fctID;
    }

    private int getLsgID() {
        return this._lsgID;
    }

    public FunctionRegistryListenerAdapter getFunctionRegistryListenerAdapter(int n) {
        this.setFctID(n);
        FunctionRegistryListenerAdapter functionRegistryListenerAdapter = this;
        return functionRegistryListenerAdapter;
    }

    public static boolean isReportOperationCode(int n) {
        boolean bl;
        switch (n) {
            case 1: 
            case 4: 
            case 5: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    public static boolean demarshallTransmitData(BAPIndicationMarshaller bAPIndicationMarshaller, int n, int n2, Object object) {
        boolean bl;
        switch (n2) {
            case 0: {
                bAPIndicationMarshaller.error(n, (Integer)object);
                bl = true;
                break;
            }
            case 1: 
            case 2: {
                bAPIndicationMarshaller.statusEntity(n, (BAPEntity)object);
                bl = true;
                break;
            }
            case 3: {
                bAPIndicationMarshaller.statusAckEntity(n, (BAPEntity)object);
                bl = true;
                break;
            }
            case 4: {
                bAPIndicationMarshaller.resultEntity(n, (BAPEntity)object);
                bl = true;
                break;
            }
            case 5: {
                bAPIndicationMarshaller.changedEntity(n, (BAPEntity)object);
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
        this.getBapDispatcher().transmitData(this.getLsgID(), this.getFctID(), 0, new Integer(n));
    }

    @Override
    public boolean statusProperty(BAPEntity bAPEntity, Property property) {
        this.getBapDispatcher().transmitData(this.getLsgID(), this.getFctID(), 1, bAPEntity);
        return false;
    }

    @Override
    public boolean statusAckProperty(BAPEntity bAPEntity, Property property) {
        this.getBapDispatcher().transmitData(this.getLsgID(), this.getFctID(), 3, bAPEntity);
        return false;
    }

    @Override
    public void result(BAPEntity bAPEntity, Method method) {
        this.getBapDispatcher().transmitData(this.getLsgID(), this.getFctID(), 4, bAPEntity);
    }

    @Override
    public void statusArray(BAPStatusArray bAPStatusArray, Array array) {
        this.getBapDispatcher().transmitData(this.getLsgID(), this.getFctID(), 2, bAPStatusArray);
    }

    @Override
    public void changedArray(BAPChangedArray bAPChangedArray, Array array) {
        this.getBapDispatcher().transmitData(this.getLsgID(), this.getFctID(), 5, bAPChangedArray);
    }
}

