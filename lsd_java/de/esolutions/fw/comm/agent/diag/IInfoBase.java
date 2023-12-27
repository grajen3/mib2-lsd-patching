/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.diag;

import de.esolutions.fw.comm.agent.diag.InfoEntry;
import de.esolutions.fw.comm.agent.diag.InfoStream;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public interface IInfoBase {
    default public int getID() {
    }

    default public long getTimeStamp() {
    }

    default public String getSimpleClassName() {
    }

    default public InfoEntry[] getEntries() {
    }

    default public InfoEntry[] getSortedEntries() {
    }

    default public ServiceInstanceID getServiceInstanceID() {
    }

    default public void write(InfoStream infoStream) {
    }
}

