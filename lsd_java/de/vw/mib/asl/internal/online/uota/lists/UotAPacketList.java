/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.uota.lists;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.common.uota.OnlineUotAPackage;
import de.vw.mib.asl.internal.online.uota.lists.PacketList;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import java.lang.reflect.Array;

public class UotAPacketList
implements PacketList {
    private final String _classname = super.getClass().getName();
    private int _instanceID;
    private OnlineUotAPackage[] _packetList;

    public UotAPacketList(int n) {
        this._instanceID = n;
    }

    public int getInstanceID() {
        return this._instanceID;
    }

    @Override
    public OnlineUotAPackage[] getPacketList() {
        return this._packetList;
    }

    @Override
    public OnlineUotAPackage getPacketWithIndex(int n) {
        if (!Util.isNullOrEmpty(this._packetList) && n < this._packetList.length) {
            return this._packetList[n] != null ? this._packetList[n] : null;
        }
        return null;
    }

    @Override
    public int getPacketListSize() {
        if (!Util.isNullOrEmpty(this._packetList)) {
            return this._packetList.length;
        }
        return 0;
    }

    @Override
    public boolean checkIfPacketInList(OnlineUotAPackage onlineUotAPackage) {
        if (onlineUotAPackage != null && !Util.isNullOrEmpty(this._packetList)) {
            for (int i2 = 0; i2 < this._packetList.length; ++i2) {
                if (!onlineUotAPackage.getSymbolicName().equals(this._packetList[i2].getSymbolicName())) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clearPacketList() {
        this._packetList = null;
    }

    @Override
    public void updatePacketList(OnlineUotAPackage[] onlineUotAPackageArray) {
        this._packetList = onlineUotAPackageArray;
    }

    @Override
    public void addPacket(OnlineUotAPackage onlineUotAPackage) {
        if (onlineUotAPackage != null) {
            if (!Util.isNullOrEmpty(this._packetList)) {
                int n = this._packetList.length;
                Object object = Array.newInstance(super.getClass().getComponentType(), n);
                System.arraycopy((Object)this._packetList, 0, object, 0, n);
                this._packetList = new OnlineUotAPackage[n + 1];
                System.arraycopy(object, 0, (Object)this._packetList, 0, n);
                this._packetList[n] = onlineUotAPackage;
            } else {
                this._packetList = new OnlineUotAPackage[1];
                this._packetList[0] = onlineUotAPackage;
            }
        }
    }

    @Override
    public boolean removePacket(OnlineUotAPackage onlineUotAPackage) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".removePacket()-> STARTED").log();
        }
        if (onlineUotAPackage != null && !Util.isNullOrEmpty(this._packetList)) {
            for (int i2 = 0; i2 < this._packetList.length; ++i2) {
                if (!onlineUotAPackage.getSymbolicName().equals(this._packetList[i2].getSymbolicName())) continue;
                int n = this._packetList.length;
                if (i2 < 0 || i2 >= n) {
                    throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(i2).append(", Length: ").append(n).toString());
                }
                Object object = Array.newInstance(super.getClass().getComponentType(), n - 1);
                System.arraycopy((Object)this._packetList, 0, object, 0, i2);
                if (i2 < n - 1) {
                    System.arraycopy((Object)this._packetList, i2 + 1, object, i2, n - i2 - 1);
                }
                this._packetList = (OnlineUotAPackage[])object;
                break;
            }
            if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(this._classname).append(".removePacket()-> ENDED").log();
            }
        }
        return false;
    }

    @Override
    public void updatePacketState(int n, int n2) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".updatePacketState()-> STARTED").log();
        }
        if (!Util.isNullOrEmpty(this._packetList)) {
            int n3 = this._packetList.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                if (n2 == 1) {
                    this._packetList[i2].setPackageEnabled(i2 == n);
                    continue;
                }
                this._packetList[i2].setPackageEnabled(true);
            }
            if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(this._classname).append(".updatePacketState()-> ENDED").log();
            }
        }
    }
}

