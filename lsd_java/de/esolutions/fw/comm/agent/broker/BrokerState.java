/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.broker;

import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;

public class BrokerState {
    public static final int DISCONNECTED;
    public static final int CONNECTING;
    public static final int SETTING_UP;
    public static final int WAITING_FOR_ALIVE;
    public static final int OPERATIONAL;
    public static final int PERM_ERROR;
    public static final int SHUTTING_DOWN;
    private final String[] names = new String[]{"DISCONNECTED", "CONNECTING", "SETTING_UP", "WAITING_FOR_ALIVE", "OPERATIONAL", "PERM_ERROR", "SHUTTING_DOWN"};
    private int state = 0;
    private String errorString;

    public synchronized int getState() {
        return this.state;
    }

    public synchronized String getStateName() {
        return this.names[this.state];
    }

    public synchronized boolean setState(int n, int n2) {
        CommAgentTracing.BROKER.log((short)0, "BrokerState, setState: %1 -> %2, this=%3 ", (Object)this.names[n2], (Object)this.names[n], (Object)this.names[this.state]);
        if (this.state != n2) {
            return false;
        }
        if (n >= 0 && n <= 7) {
            this.state = n;
            return true;
        }
        return false;
    }

    public synchronized void setErrorState(boolean bl, String string) {
        int n = bl ? 5 : 0;
        CommAgentTracing.BROKER.log((short)0, "BrokerState, setState: %1 -> %2, [Error] ", (Object)this.names[this.state], (Object)this.names[n]);
        this.state = n;
        this.errorString = string;
    }

    public synchronized String getErrorString() {
        return this.errorString;
    }

    public synchronized String toString() {
        if (this.errorString != null) {
            return new StringBuffer().append(this.names[this.state]).append(": ").append(this.errorString).toString();
        }
        return this.names[this.state];
    }
}

