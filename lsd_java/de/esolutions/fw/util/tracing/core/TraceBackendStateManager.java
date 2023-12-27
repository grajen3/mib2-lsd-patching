/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.core;

import de.esolutions.fw.util.commons.pool.ShortPool;
import de.esolutions.fw.util.tracing.backend.ITraceBackend;
import de.esolutions.fw.util.tracing.core.TraceBackendState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class TraceBackendStateManager {
    private ShortPool backends;
    private List connected;
    private Map mapToState;
    private int counter;
    private int decodeFlagCounter;

    public TraceBackendStateManager(short s) {
        this.backends = new ShortPool(s);
        this.connected = new ArrayList();
        this.counter = 0;
        this.decodeFlagCounter = 0;
        this.mapToState = new HashMap();
    }

    public boolean hasConnectedBackends() {
        return !this.connected.isEmpty();
    }

    public short createBackend(ITraceBackend iTraceBackend, String string) {
        TraceBackendState traceBackendState = new TraceBackendState(iTraceBackend, string);
        short s = this.backends.add(traceBackendState);
        traceBackendState.setId(s);
        this.mapToState.put(iTraceBackend, traceBackendState);
        ++this.counter;
        return s;
    }

    public boolean removeBackend(short s) {
        ITraceBackend iTraceBackend = this.getBackend(s);
        if (iTraceBackend == null) {
            return false;
        }
        this.mapToState.remove(iTraceBackend);
        this.backends.remove(s);
        --this.counter;
        return true;
    }

    public short findBackend(ITraceBackend iTraceBackend) {
        TraceBackendState traceBackendState = (TraceBackendState)this.mapToState.get(iTraceBackend);
        if (traceBackendState == null) {
            return -1;
        }
        return traceBackendState.getId();
    }

    public ITraceBackend getBackend(short s) {
        TraceBackendState traceBackendState = (TraceBackendState)this.backends.getObject(s);
        if (traceBackendState == null) {
            return null;
        }
        return traceBackendState.getBackend();
    }

    public TraceBackendState getBackendState(short s) {
        return (TraceBackendState)this.backends.getObject(s);
    }

    public boolean setConnected(short s) {
        TraceBackendState traceBackendState = (TraceBackendState)this.backends.getObject(s);
        if (traceBackendState == null) {
            return false;
        }
        if (!traceBackendState.isConnected()) {
            traceBackendState.setConnected(true);
            this.connected.add(new Short(s));
            int n = traceBackendState.getFlags();
            if ((n & 1) == 1) {
                ++this.decodeFlagCounter;
            }
            return true;
        }
        return false;
    }

    public boolean setDisconnected(short s) {
        TraceBackendState traceBackendState = (TraceBackendState)this.backends.getObject(s);
        if (traceBackendState == null) {
            return false;
        }
        if (traceBackendState.isConnected()) {
            traceBackendState.setConnected(false);
            this.connected.remove(new Short(s));
            int n = traceBackendState.getFlags();
            if ((n & 1) == 1) {
                --this.decodeFlagCounter;
            }
            return true;
        }
        return false;
    }

    public boolean isConnected(short s) {
        TraceBackendState traceBackendState = (TraceBackendState)this.backends.getObject(s);
        if (traceBackendState == null) {
            return false;
        }
        return traceBackendState.isConnected();
    }

    public short[] getAllBackendIds() {
        return this.backends.getUsedIDs();
    }

    public short[] getAllConnectedBackendIds() {
        int n = this.connected.size();
        short[] sArray = new short[n];
        ListIterator listIterator = this.connected.listIterator();
        int n2 = 0;
        while (listIterator.hasNext()) {
            Short s = (Short)listIterator.next();
            sArray[n2++] = s;
        }
        return sArray;
    }

    public boolean areAllConnected() {
        return this.counter == this.connected.size();
    }

    public short[] getBackendIds() {
        return this.backends.getUsedIDs();
    }

    public int getDecodeFlagCounter() {
        return this.decodeFlagCounter;
    }
}

