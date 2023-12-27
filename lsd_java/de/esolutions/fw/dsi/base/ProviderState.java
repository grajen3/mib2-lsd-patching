/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.base;

import de.esolutions.fw.dsi.base.IProviderStateListener;
import de.esolutions.fw.dsi.tracing.Channels;
import de.esolutions.fw.util.tracing.TraceChannel;

public class ProviderState {
    public static final int DISCONNECTED;
    public static final int CONNECTING;
    public static final int CONNECTED;
    public static final int DISCONNECTING;
    public static final int CONNECTION_LOST;
    public static final int CONNECTION_FAILED;
    protected TraceChannel tracer = Channels.DSI_PROVIDER;
    private int currentState = 0;
    private IProviderStateListener listener;
    public static final String[] stateNames;

    public int getState() {
        return this.currentState;
    }

    private boolean changeState(int n) {
        boolean bl = true;
        switch (n) {
            case 0: {
                if (this.currentState == 3) break;
                bl = false;
                break;
            }
            case 1: {
                if (this.currentState == 0 || this.currentState == 5 || this.currentState == 4) break;
                bl = false;
                break;
            }
            case 5: {
                if (this.currentState == 1) break;
                bl = false;
                break;
            }
            case 2: {
                if (this.currentState == 1) break;
                bl = false;
                break;
            }
            case 3: {
                if (this.currentState == 2) break;
                bl = false;
                break;
            }
            case 4: {
                if (this.currentState == 2) break;
                bl = false;
                break;
            }
        }
        if (bl) {
            this.tracer.log((short)2, "ProviderState changed to %1, [%2 --> %1]", (Object)stateNames[n], (Object)stateNames[this.currentState]);
            this.currentState = n;
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean setState(int n) {
        boolean bl = false;
        ProviderState providerState = this;
        synchronized (providerState) {
            bl = this.changeState(n);
        }
        if (bl) {
            this.notifyStateChange(n);
            return true;
        }
        this.invalidStateChange(n);
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean startService() {
        boolean bl = false;
        ProviderState providerState = this;
        synchronized (providerState) {
            if (this.currentState == 0 || this.currentState == 4) {
                bl = this.changeState(1);
            }
        }
        if (bl) {
            this.notifyStateChange(1);
            return true;
        }
        this.invalidStateChange(1);
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean stopService() {
        boolean bl = false;
        ProviderState providerState = this;
        synchronized (providerState) {
            if (this.currentState == 2) {
                bl = this.changeState(3);
            }
        }
        if (bl) {
            this.notifyStateChange(3);
            return true;
        }
        this.invalidStateChange(3);
        return false;
    }

    public void setListener(IProviderStateListener iProviderStateListener) {
        this.listener = iProviderStateListener;
    }

    private void invalidStateChange(int n) {
        this.tracer.log((short)3, "InvalidStateChange requested, currentState = %1, requestedState = %2.", (Object)stateNames[this.currentState], (Object)stateNames[n]);
    }

    private void notifyStateChange(int n) {
        switch (this.currentState) {
            case 0: {
                this.listener.onDisconnected(null);
                break;
            }
            case 1: {
                this.listener.onConnecting(null);
                break;
            }
            case 2: {
                this.listener.onConnected(null);
                break;
            }
            case 3: {
                this.listener.onDisconnecting(null);
                break;
            }
            case 4: {
                this.listener.onConnectionLost(null);
                break;
            }
            case 5: {
                this.listener.onConnectionFailed(null);
                break;
            }
        }
    }

    static {
        stateNames = new String[]{"DISCONNECTED", "CONNECTING", "CONNECTED", "DISCONNECTING", "CONNECTION_LOST", "CONNECTION_FAILED"};
    }
}

