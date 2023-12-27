/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.directory;

import de.esolutions.fw.comm.agent.directory.DirectoryEntry;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public interface IServiceQueryReply {
    public static final int OK;
    public static final int SERVICE_NOT_FOUND;
    public static final int QUERY_TIME_OUT;

    default public void serviceQueryResult(ServiceInstanceID serviceInstanceID, DirectoryEntry[] directoryEntryArray) {
    }

    default public void serviceQueryFailed(ServiceInstanceID serviceInstanceID, int n) {
    }
}

