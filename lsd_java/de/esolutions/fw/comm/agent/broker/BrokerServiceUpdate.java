/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.broker;

import de.esolutions.fw.comm.core.ServiceInstanceID;

public class BrokerServiceUpdate {
    public static final int SERVICE_REGISTERED;
    public static final int SERVICE_UNREGISTERED;
    public static final int SERVICE_NOT_REGISTERED;
    public static final int NORMAL_OPERATION;
    public static final int DUPLICATE_INSTANCED;
    public static final int INVALID_INSTANCEID;
    public static final int CONNECTION_LOST;
    private final int action;
    private final int reason;
    private final ServiceInstanceID instanceID;
    private final short agent;
    public static final String[] actionNames;
    public static final String[] reasonNames;

    public BrokerServiceUpdate(int n, int n2, ServiceInstanceID serviceInstanceID, short s) {
        this.action = n;
        this.reason = n2;
        this.instanceID = serviceInstanceID;
        this.agent = s;
    }

    public int getAction() {
        return this.action;
    }

    public int getReason() {
        return this.reason;
    }

    public ServiceInstanceID getInstanceID() {
        return this.instanceID;
    }

    public short getAgent() {
        return this.agent;
    }

    static {
        actionNames = new String[]{"registered", "unregistered", "NOT FOUND"};
        reasonNames = new String[]{"normal", "duplicate", "invalid", "connection-lost"};
    }
}

