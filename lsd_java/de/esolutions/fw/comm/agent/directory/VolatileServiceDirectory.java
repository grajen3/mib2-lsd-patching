/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.directory;

import de.esolutions.fw.comm.agent.diag.info.ServiceLocatorInfo;
import de.esolutions.fw.comm.agent.directory.DirectoryEntry;
import de.esolutions.fw.comm.agent.directory.IServiceDirectory;
import de.esolutions.fw.comm.agent.directory.VolatileServiceDirectory$ServiceLocator;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class VolatileServiceDirectory
implements IServiceDirectory {
    protected List serviceList = new ArrayList();

    private VolatileServiceDirectory$ServiceLocator find(ServiceInstanceID serviceInstanceID) {
        ListIterator listIterator = this.serviceList.listIterator();
        while (listIterator.hasNext()) {
            VolatileServiceDirectory$ServiceLocator volatileServiceDirectory$ServiceLocator = (VolatileServiceDirectory$ServiceLocator)listIterator.next();
            if (!volatileServiceDirectory$ServiceLocator.getServiceInstanceID().equals(serviceInstanceID)) continue;
            return volatileServiceDirectory$ServiceLocator;
        }
        return null;
    }

    @Override
    public synchronized DirectoryEntry[] locateService(ServiceInstanceID serviceInstanceID) {
        VolatileServiceDirectory$ServiceLocator volatileServiceDirectory$ServiceLocator = this.find(serviceInstanceID);
        if (volatileServiceDirectory$ServiceLocator == null) {
            CommAgentTracing.DIRECTORY.log((short)1, "locateService: %1 not found ", serviceInstanceID);
            return null;
        }
        DirectoryEntry[] directoryEntryArray = volatileServiceDirectory$ServiceLocator.getEntryList();
        CommAgentTracing.DIRECTORY.log((short)1, "locateService: service %1 found on %2", serviceInstanceID, (Object)directoryEntryArray);
        return directoryEntryArray;
    }

    @Override
    public synchronized void addEmptyService(ServiceInstanceID serviceInstanceID) {
        CommAgentTracing.DIRECTORY.log((short)1, "registerService: add empty service %1 to remember look up", serviceInstanceID);
        VolatileServiceDirectory$ServiceLocator volatileServiceDirectory$ServiceLocator = this.find(serviceInstanceID);
        if (volatileServiceDirectory$ServiceLocator == null) {
            volatileServiceDirectory$ServiceLocator = new VolatileServiceDirectory$ServiceLocator(serviceInstanceID);
            this.serviceList.add(volatileServiceDirectory$ServiceLocator);
        }
    }

    @Override
    public synchronized void registerService(DirectoryEntry directoryEntry) {
        DirectoryEntry directoryEntry2;
        ServiceInstanceID serviceInstanceID = directoryEntry.getServiceInstanceID();
        VolatileServiceDirectory$ServiceLocator volatileServiceDirectory$ServiceLocator = this.find(serviceInstanceID);
        if (volatileServiceDirectory$ServiceLocator == null) {
            volatileServiceDirectory$ServiceLocator = new VolatileServiceDirectory$ServiceLocator(serviceInstanceID);
            this.serviceList.add(volatileServiceDirectory$ServiceLocator);
        }
        if ((directoryEntry2 = volatileServiceDirectory$ServiceLocator.findSame(directoryEntry)) == null) {
            volatileServiceDirectory$ServiceLocator.addEntry(directoryEntry);
            CommAgentTracing.DIRECTORY.log((short)1, "registerService: %1", directoryEntry);
        }
    }

    @Override
    public synchronized void unregisterService(DirectoryEntry directoryEntry) {
        ServiceInstanceID serviceInstanceID = directoryEntry.getServiceInstanceID();
        VolatileServiceDirectory$ServiceLocator volatileServiceDirectory$ServiceLocator = this.find(serviceInstanceID);
        if (volatileServiceDirectory$ServiceLocator != null) {
            volatileServiceDirectory$ServiceLocator.removeEntry(directoryEntry);
            if (volatileServiceDirectory$ServiceLocator.isEmpty()) {
                this.serviceList.remove(volatileServiceDirectory$ServiceLocator);
            }
            CommAgentTracing.DIRECTORY.log((short)1, "unregisterService: %1", directoryEntry);
        }
    }

    @Override
    public synchronized DirectoryEntry[] getAllEntries() {
        Object[] objectArray;
        ArrayList arrayList = new ArrayList();
        ListIterator listIterator = this.serviceList.listIterator();
        while (listIterator.hasNext()) {
            objectArray = (Object[])listIterator.next();
            DirectoryEntry[] directoryEntryArray = objectArray.getEntryList();
            if (directoryEntryArray == null) continue;
            for (int i2 = 0; i2 < directoryEntryArray.length; ++i2) {
                arrayList.add(directoryEntryArray[i2]);
            }
        }
        objectArray = new DirectoryEntry[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    @Override
    public synchronized DirectoryEntry[] removeAllEntriesOfPeer(short s) {
        Object[] objectArray;
        ArrayList arrayList = new ArrayList();
        ListIterator listIterator = this.serviceList.listIterator();
        while (listIterator.hasNext()) {
            objectArray = (Object[])listIterator.next();
            DirectoryEntry[] directoryEntryArray = objectArray.getEntryList();
            if (directoryEntryArray == null) continue;
            DirectoryEntry directoryEntry = null;
            for (int i2 = 0; i2 < directoryEntryArray.length; ++i2) {
                if (directoryEntryArray[i2].getAgentID() != s) continue;
                directoryEntry = directoryEntryArray[i2];
                break;
            }
            if (directoryEntry == null) continue;
            objectArray.removeEntry(directoryEntry);
            arrayList.add(directoryEntry);
            if (!objectArray.isEmpty()) continue;
            listIterator.remove();
        }
        objectArray = new DirectoryEntry[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    @Override
    public synchronized ServiceInstanceID[] getAllEmptyEntries() {
        Object[] objectArray;
        ArrayList arrayList = new ArrayList();
        ListIterator listIterator = this.serviceList.listIterator();
        while (listIterator.hasNext()) {
            objectArray = (Object[])listIterator.next();
            if (!objectArray.isEmpty()) continue;
            arrayList.add(objectArray.getServiceInstanceID());
        }
        objectArray = new ServiceInstanceID[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    @Override
    public synchronized void dumpDirectory(short s) {
        ListIterator listIterator = this.serviceList.listIterator();
        while (listIterator.hasNext()) {
            VolatileServiceDirectory$ServiceLocator volatileServiceDirectory$ServiceLocator = (VolatileServiceDirectory$ServiceLocator)listIterator.next();
            ServiceInstanceID serviceInstanceID = volatileServiceDirectory$ServiceLocator.getServiceInstanceID();
            DirectoryEntry[] directoryEntryArray = volatileServiceDirectory$ServiceLocator.getEntryList();
            if (directoryEntryArray == null) continue;
            for (int i2 = 0; i2 < directoryEntryArray.length; ++i2) {
                short s2 = directoryEntryArray[i2].getAgentID();
                if (s2 == 0) {
                    s2 = s;
                }
                CommAgentTracing.COMM.log((short)2, "on='%1' event='interface-status' interface='%2:%3' home='%4' ", new Short(s), (Object)serviceInstanceID.getServiceUUID(), (Object)new Integer(serviceInstanceID.getHandle()), (Object)new Short(s2));
            }
        }
    }

    @Override
    public ServiceLocatorInfo[] createServiceLocatorInfos() {
        DirectoryEntry[] directoryEntryArray = this.getAllEntries();
        if (directoryEntryArray == null) {
            return null;
        }
        int n = directoryEntryArray.length;
        ServiceLocatorInfo[] serviceLocatorInfoArray = new ServiceLocatorInfo[n];
        for (int i2 = 0; i2 < n; ++i2) {
            serviceLocatorInfoArray[i2] = new ServiceLocatorInfo(i2, directoryEntryArray[i2]);
        }
        return serviceLocatorInfoArray;
    }
}

