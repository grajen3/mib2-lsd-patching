/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.directory;

import de.esolutions.fw.comm.agent.diag.info.ServiceLocatorInfo;
import de.esolutions.fw.comm.agent.directory.DirectoryEntry;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public interface IServiceDirectory {
    default public void registerService(DirectoryEntry directoryEntry) {
    }

    default public void unregisterService(DirectoryEntry directoryEntry) {
    }

    default public DirectoryEntry[] locateService(ServiceInstanceID serviceInstanceID) {
    }

    default public void addEmptyService(ServiceInstanceID serviceInstanceID) {
    }

    default public DirectoryEntry[] getAllEntries() {
    }

    default public ServiceInstanceID[] getAllEmptyEntries() {
    }

    default public DirectoryEntry[] removeAllEntriesOfPeer(short s) {
    }

    default public void dumpDirectory(short s) {
    }

    default public ServiceLocatorInfo[] createServiceLocatorInfos() {
    }
}

