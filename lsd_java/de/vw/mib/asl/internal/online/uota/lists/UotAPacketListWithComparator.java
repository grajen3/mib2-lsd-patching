/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.uota.lists;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.common.uota.OnlineUotAPackage;
import de.vw.mib.asl.internal.online.uota.lists.PacketList;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import java.util.Comparator;
import java.util.TreeSet;

public class UotAPacketListWithComparator
implements PacketList {
    private final String _classname = super.getClass().getName();
    private int _instanceID;
    private TreeSet _packetList;

    public UotAPacketListWithComparator(int n, Comparator comparator) {
        this._instanceID = n;
        this._packetList = new TreeSet(comparator);
    }

    public int getInstanceID() {
        return this._instanceID;
    }

    @Override
    public OnlineUotAPackage[] getPacketList() {
        return (OnlineUotAPackage[])this._packetList.toArray(new OnlineUotAPackage[this._packetList.size()]);
    }

    @Override
    public OnlineUotAPackage getPacketWithIndex(int n) {
        if (!this._packetList.isEmpty() && n < this._packetList.size()) {
            return ((OnlineUotAPackage[])this._packetList.toArray(new OnlineUotAPackage[this._packetList.size()]))[n];
        }
        return null;
    }

    @Override
    public int getPacketListSize() {
        return this._packetList.size();
    }

    @Override
    public boolean checkIfPacketInList(OnlineUotAPackage onlineUotAPackage) {
        if (onlineUotAPackage != null && !this._packetList.isEmpty()) {
            return this._packetList.contains(onlineUotAPackage);
        }
        return false;
    }

    @Override
    public void clearPacketList() {
        this._packetList.clear();
    }

    @Override
    public void updatePacketList(OnlineUotAPackage[] onlineUotAPackageArray) {
        if (!Util.isNullOrEmpty(onlineUotAPackageArray)) {
            for (int i2 = 0; i2 < onlineUotAPackageArray.length; ++i2) {
                this._packetList.add(onlineUotAPackageArray[i2]);
            }
        }
    }

    @Override
    public void addPacket(OnlineUotAPackage onlineUotAPackage) {
        if (onlineUotAPackage != null) {
            this._packetList.add(onlineUotAPackage);
        }
    }

    @Override
    public boolean removePacket(OnlineUotAPackage onlineUotAPackage) {
        if (onlineUotAPackage != null) {
            return this._packetList.remove(onlineUotAPackage);
        }
        return false;
    }

    @Override
    public void updatePacketState(int n, int n2) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(".updatePacketState()-> STARTED").log();
        }
        if (!this._packetList.isEmpty() && this._packetList.size() > n) {
            object = this.getPacketWithIndex(n);
            ((OnlineUotAPackage)object).setPackageEnabled(n2 == 1);
            if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(this._classname).append(".updatePacketState()-> ENDED").log();
            }
        }
    }
}

