/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4;

import de.esolutions.fw.comm.core.IEnum;

public interface ServiceReason
extends IEnum {
    public static final int NORMAL_OPERATION;
    public static final int DUPLICATE_INSTANCEID;
    public static final int INVALID_INSTANCEID;
    public static final int CONNECTION_LOST;
    public static final int INTERFACE_KEY_MISMATCH;
    public static final int OOM;
    public static final int SERVICE_NOT_AVAILABLE;
    public static final int FACTORY_NOT_FOUND;
    public static final int ID_POOL_EXHAUSTED;
    public static final int OBJECT_IS_DEAD;
    public static final int PROXY_IS_INVALID;
    public static final int INVALID_AGENT_ID;
    public static final int AGENT_IN_SHUTDOWN;
    public static final int INTERNAL_ERROR;
}

