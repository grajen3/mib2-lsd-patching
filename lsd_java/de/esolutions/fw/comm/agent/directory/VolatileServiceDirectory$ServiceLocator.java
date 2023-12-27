/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.directory;

import de.esolutions.fw.comm.agent.directory.DirectoryEntry;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class VolatileServiceDirectory$ServiceLocator {
    protected List entries;
    protected ServiceInstanceID instanceID;

    public VolatileServiceDirectory$ServiceLocator(ServiceInstanceID serviceInstanceID) {
        this.instanceID = serviceInstanceID;
        this.entries = new ArrayList();
    }

    public ServiceInstanceID getServiceInstanceID() {
        return this.instanceID;
    }

    public void addEntry(DirectoryEntry directoryEntry) {
        this.entries.add(directoryEntry);
    }

    public DirectoryEntry findSame(DirectoryEntry directoryEntry) {
        ListIterator listIterator = this.entries.listIterator();
        while (listIterator.hasNext()) {
            DirectoryEntry directoryEntry2 = (DirectoryEntry)listIterator.next();
            if (!directoryEntry2.equals(directoryEntry)) continue;
            return directoryEntry2;
        }
        return null;
    }

    public void removeEntry(DirectoryEntry directoryEntry) {
        DirectoryEntry directoryEntry2 = this.findSame(directoryEntry);
        if (directoryEntry2 != null) {
            this.entries.remove(directoryEntry2);
        }
    }

    public boolean isEmpty() {
        return this.entries.isEmpty();
    }

    public DirectoryEntry[] getEntryList() {
        DirectoryEntry[] directoryEntryArray = new DirectoryEntry[this.entries.size()];
        ListIterator listIterator = this.entries.listIterator();
        int n = 0;
        while (listIterator.hasNext()) {
            DirectoryEntry directoryEntry = (DirectoryEntry)listIterator.next();
            directoryEntryArray[n++] = directoryEntry;
        }
        return directoryEntryArray;
    }
}

