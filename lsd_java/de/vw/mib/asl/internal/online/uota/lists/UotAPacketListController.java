/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.uota.lists;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.common.uota.OnlineUotAPackage;
import de.vw.mib.asl.internal.online.uota.common.UotAPacketComparator;
import de.vw.mib.asl.internal.online.uota.lists.PacketList;
import de.vw.mib.asl.internal.online.uota.lists.UotAPacketList;
import de.vw.mib.asl.internal.online.uota.lists.UotAPacketListWithComparator;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.online.transformer.OnlineOnlDowPacCurDow1310032Collector;
import generated.de.vw.mib.asl.internal.online.transformer.OnlineOnlineDownloadPackageCurrentlySelectedCollector;
import java.util.Arrays;
import org.dsi.ifc.uota.PackageInfo;

public class UotAPacketListController
extends AbstractFactoryResetParticipant {
    private final String _classname = super.getClass().getName();
    private int _currentFilter = 0;
    private OnlineUotAPackage _currentPacket;
    private PacketList _currentList;
    private PacketList _completeList;
    private PacketList _allPacketList;
    private PacketList _favoriteList;
    private PacketList _ppoiList;
    private PacketList _navDataList;
    private PacketList _mainPacketList;
    private PacketList _subPacketList;
    private PacketList _downloadPacketList;

    private void updateLists(OnlineUotAPackage[] onlineUotAPackageArray) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".updateLists()-> STARTED").log();
        }
        if (!Util.isNullOrEmpty(onlineUotAPackageArray)) {
            this._completeList = new UotAPacketList(8);
            this._allPacketList = new UotAPacketListWithComparator(0, new UotAPacketComparator());
            this._favoriteList = new UotAPacketListWithComparator(1, new UotAPacketComparator());
            this._ppoiList = new UotAPacketListWithComparator(2, new UotAPacketComparator());
            this._navDataList = new UotAPacketListWithComparator(3, new UotAPacketComparator());
            if (this._completeList != null) {
                this._completeList.updatePacketList(onlineUotAPackageArray);
            }
            for (int i2 = 0; i2 < onlineUotAPackageArray.length; ++i2) {
                if (onlineUotAPackageArray[i2].getType() == 1 || Util.isBitSet(2, onlineUotAPackageArray[i2].getSelectedState()) || Util.isBitSet(8, onlineUotAPackageArray[i2].getSelectedState())) continue;
                if (Util.isNullOrEmpty(onlineUotAPackageArray[i2].getExtras()) || onlineUotAPackageArray[i2].getExtras().length >= 2 && !Util.isNullOrEmpty(onlineUotAPackageArray[i2].getExtras()[1]) && onlineUotAPackageArray[i2].getExtras()[1].equalsIgnoreCase("1")) {
                    this._allPacketList.addPacket(onlineUotAPackageArray[i2]);
                }
                if (onlineUotAPackageArray[i2].getCategory().equals("ppoi")) {
                    this._ppoiList.addPacket(onlineUotAPackageArray[i2]);
                    onlineUotAPackageArray[i2].setPacketType(1);
                } else if (onlineUotAPackageArray[i2].getCategory().equals("navdata") && (Util.isNullOrEmpty(onlineUotAPackageArray[i2].getExtras()) || onlineUotAPackageArray[i2].getExtras().length >= 2 && !Util.isNullOrEmpty(onlineUotAPackageArray[i2].getExtras()[1]) && onlineUotAPackageArray[i2].getExtras()[1].equalsIgnoreCase("1"))) {
                    this._navDataList.addPacket(onlineUotAPackageArray[i2]);
                    onlineUotAPackageArray[i2].setPacketType(2);
                }
                if (onlineUotAPackageArray[i2].getPriority() > 2000 || onlineUotAPackageArray[i2].getPriority() < 900 || !Util.isNullOrEmpty(onlineUotAPackageArray[i2].getExtras()) && (onlineUotAPackageArray[i2].getExtras().length < 2 || Util.isNullOrEmpty(onlineUotAPackageArray[i2].getExtras()[1]) || !onlineUotAPackageArray[i2].getExtras()[1].equalsIgnoreCase("1"))) continue;
                this._favoriteList.addPacket(onlineUotAPackageArray[i2]);
            }
            if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(this._classname).append(".updateLists()-> ENDED").log();
            }
        }
    }

    public boolean updatePacketList(PackageInfo[] packageInfoArray, int[] nArray, String string) {
        LogMessage logMessage;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".updatePacketList()-> STARTED").log();
        }
        this.clearLists();
        if (!Util.isNullOrEmpty(packageInfoArray) && !Util.isNullOrEmpty(nArray)) {
            OnlineUotAPackage[] onlineUotAPackageArray;
            int n = packageInfoArray.length;
            if (ServiceManager.logger2.isTraceEnabled(16384)) {
                onlineUotAPackageArray = ServiceManager.logger2.trace(16384);
                onlineUotAPackageArray.append(this._classname).append(new StringBuffer().append(".updatePacketList() complete list count = ").append(n).toString()).log();
            }
            ServiceManager.aslPropertyManager.valueChangedInteger(1409094400, n);
            onlineUotAPackageArray = new OnlineUotAPackage[n];
            for (int i2 = 0; i2 < packageInfoArray.length; ++i2) {
                onlineUotAPackageArray[i2] = new OnlineUotAPackage(packageInfoArray[i2], string, nArray[i2]);
            }
            this.updateLists(onlineUotAPackageArray);
            this.setCurrentFilter(this.getCurrentFilter());
            if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage2 = ServiceManager.logger2.trace(16384);
                logMessage2.append(this._classname).append(".updatePacketList()-> ENDED").log();
            }
            return true;
        }
        logMessage = ServiceManager.logger2.info(16384);
        logMessage.append(this._classname).append(".updatePacketList()-> FAILED").log();
        return false;
    }

    public OnlineUotAPackage[] getPacketListWithCategory(int n) {
        switch (n) {
            case 8: {
                return this._completeList != null ? this._completeList.getPacketList() : null;
            }
            case 0: {
                return this._allPacketList != null ? this._allPacketList.getPacketList() : null;
            }
            case 1: {
                return this._favoriteList != null ? this._favoriteList.getPacketList() : null;
            }
            case 2: {
                return this._ppoiList != null ? this._ppoiList.getPacketList() : null;
            }
            case 3: {
                return this._navDataList != null ? this._navDataList.getPacketList() : null;
            }
        }
        return null;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
    }

    public void clearLists() {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".clearLists()").log();
        }
        this._currentPacket = null;
        if (this._completeList != null) {
            this._completeList.clearPacketList();
            this._completeList = null;
        }
        if (this._allPacketList != null) {
            this._allPacketList.clearPacketList();
            this._allPacketList = null;
        }
        if (this._favoriteList != null) {
            this._favoriteList.clearPacketList();
            this._favoriteList = null;
        }
        if (this._ppoiList != null) {
            this._ppoiList.clearPacketList();
            this._ppoiList = null;
        }
        if (this._navDataList != null) {
            this._navDataList.clearPacketList();
            this._navDataList = null;
        }
        if (this._mainPacketList != null) {
            this._mainPacketList.clearPacketList();
            this._mainPacketList = null;
        }
        if (this._subPacketList != null) {
            this._subPacketList.clearPacketList();
            this._subPacketList = null;
        }
    }

    public OnlineUotAPackage[] buildMainPacketList(PacketList packetList, OnlineUotAPackage[] onlineUotAPackageArray) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(".buildMainPacketList()-> STARTED").log();
        }
        object = null;
        if (packetList != null && packetList.getPacketListSize() > 0) {
            object = packetList;
        } else if (!Util.isNullOrEmpty(onlineUotAPackageArray)) {
            object = new UotAPacketList(7);
            object.updatePacketList(onlineUotAPackageArray);
        }
        this._mainPacketList = new UotAPacketList(4);
        if (object != null && object.getPacketListSize() > 0) {
            int n = object.getPacketList().length;
            int n2 = 0;
            for (int i2 = 0; i2 < n; ++i2) {
                object.getPacketList()[i2].setIndex(n2);
                object.getPacketList()[i2].setHasSubPackages(false);
                this._mainPacketList.addPacket(object.getPacketList()[i2]);
                ++n2;
            }
        }
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".buildMainPacketList() --> Available main packets = ").append(this._mainPacketList.getPacketListSize()).toString()).log();
        }
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".buildMainPacketList()-> ENDED").log();
        }
        return this._mainPacketList.getPacketList();
    }

    public OnlineUotAPackage[] getSubPacketList(OnlineUotAPackage onlineUotAPackage) {
        this._currentPacket = onlineUotAPackage;
        this._subPacketList = null;
        if (this._currentPacket != null && this.getCurrentPacketList() != null && this.getCurrentPacketList().getPacketListSize() > 0) {
            this._subPacketList = new UotAPacketList(5);
            int n = this.getCurrentPacketList().getPacketList().length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (Util.isNullOrEmpty(this.getCurrentPacketList().getPacketList()[i2].getHierarchyInfo()) || this.getCurrentPacketList().getPacketList()[i2].getHierarchyInfo().length <= 3 || Util.isNullOrEmpty(this._currentPacket.getHierarchyInfo()) || !this.getCurrentPacketList().getPacketList()[i2].getHierarchyInfo()[1].equals(this._currentPacket.getHierarchyInfo()[1])) continue;
                this._subPacketList.addPacket(this.getCurrentPacketList().getPacketList()[i2]);
            }
            return this._subPacketList.getPacketList();
        }
        return null;
    }

    public OnlineUotAPackage[] getSubPacketList(String string) {
        this._subPacketList = null;
        if (!Util.isNullOrEmpty(string) && this.getCurrentPacketList() != null && this.getCurrentPacketList().getPacketListSize() > 0) {
            this._subPacketList = new UotAPacketList(5);
            int n = this.getCurrentPacketList().getPacketList().length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (Util.isNullOrEmpty(this.getCurrentPacketList().getPacketList()[i2].getHierarchyInfo()) || !Arrays.asList(this.getCurrentPacketList().getPacketList()[i2].getHierarchyInfo()).contains(string)) continue;
                this._subPacketList.addPacket(this.getCurrentPacketList().getPacketList()[i2]);
            }
            return this._subPacketList.getPacketList();
        }
        return null;
    }

    public boolean hasSubPacketList(OnlineUotAPackage onlineUotAPackage) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".hasSubPacketList()").log();
        }
        if (onlineUotAPackage != null && this.getCurrentPacketList() != null && this.getCurrentPacketList().getPacketListSize() > 0) {
            int n = this.getCurrentPacketList().getPacketList().length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (Util.isNullOrEmpty(this.getCurrentPacketList().getPacketList()[i2].getHierarchyInfo()) || this.getCurrentPacketList().getPacketList()[i2].getHierarchyInfo().length <= 3 || Util.isNullOrEmpty(onlineUotAPackage.getHierarchyInfo()) || !this.getCurrentPacketList().getPacketList()[i2].getHierarchyInfo()[1].equals(onlineUotAPackage.getHierarchyInfo()[1])) continue;
                return true;
            }
        }
        return false;
    }

    public boolean hasSubPacketList(String string) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".hasSubPacketList(").append(Util.isNullOrEmpty(string) ? "NULL" : string).append(")").toString()).log();
        }
        if (!Util.isNullOrEmpty(string) && this.getCurrentPacketList() != null && this.getCurrentPacketList().getPacketListSize() > 0) {
            int n = this.getCurrentPacketList().getPacketList().length;
            int n2 = 0;
            block0: for (int i2 = 0; i2 < n; ++i2) {
                if (Util.isNullOrEmpty(this.getCurrentPacketList().getPacketList()[i2].getHierarchyInfo()) || this.getCurrentPacketList().getPacketList()[i2].getHierarchyInfo().length <= 1) continue;
                int n3 = this.getCurrentPacketList().getPacketList()[i2].getHierarchyInfo().length;
                for (int i3 = 0; i3 < n3; ++i3) {
                    if (!this.getCurrentPacketList().getPacketList()[i2].getHierarchyInfo()[i3].equalsIgnoreCase(string)) continue;
                    ++n2;
                    continue block0;
                }
            }
            if (n2 > 1) {
                return true;
            }
        }
        return false;
    }

    public void handleDownloadPacketList(int n, int n2) {
        if (this._currentList != null && this._currentList.getPacketListSize() > 0) {
            int n3;
            switch (n) {
                case 1: {
                    int n4;
                    n3 = this._currentList.getPacketListSize();
                    for (n4 = 0; n4 < n3; ++n4) {
                        this._currentList.getPacketList()[n4].setSelectionType(1);
                        this._currentList.getPacketList()[n4].setSelectedState(Util.setBit(1, this._currentList.getPacketList()[n4].getSelectedState()));
                    }
                    break;
                }
                case 2: {
                    int n4;
                    n3 = this._currentList.getPacketListSize();
                    for (n4 = 0; n4 < n3; ++n4) {
                        this._currentList.getPacketList()[n4].setSelectionType(0);
                        this._currentList.getPacketList()[n4].setSelectedState(Util.unsetBit(1, this._mainPacketList.getPacketList()[n4].getSelectedState()));
                    }
                    break;
                }
                case 3: {
                    boolean bl;
                    int n4;
                    if (this._mainPacketList == null) break;
                    n3 = this._mainPacketList.getPacketListSize();
                    for (n4 = 0; n4 < n3; ++n4) {
                        if (n4 != n2) continue;
                        bl = this._mainPacketList.getPacketList()[n4].getSelectionType() == 1;
                        this._mainPacketList.getPacketList()[n4].setSelectionType(bl ? 0 : 1);
                        this._mainPacketList.getPacketList()[n4].setSelectedState(bl ? Util.unsetBit(1, this._mainPacketList.getPacketList()[n4].getSelectedState()) : Util.setBit(1, this._mainPacketList.getPacketList()[n4].getSelectedState()));
                        this._currentPacket = this._mainPacketList.getPacketList()[n4];
                    }
                    break;
                }
                case 4: {
                    boolean bl;
                    int n4;
                    if (this._subPacketList == null) break;
                    n3 = this._subPacketList.getPacketListSize();
                    for (n4 = 0; n4 < n3; ++n4) {
                        if (n4 != n2) continue;
                        bl = this._subPacketList.getPacketList()[n4].getSelectionType() == 1;
                        this._subPacketList.getPacketList()[n4].setSelectionType(bl ? 0 : 1);
                        this._subPacketList.getPacketList()[n4].setSelectedState(bl ? Util.unsetBit(1, this._subPacketList.getPacketList()[n4].getSelectedState()) : Util.setBit(1, this._subPacketList.getPacketList()[n4].getSelectedState()));
                        this._currentPacket.setSelectionType(bl ? 0 : 2);
                        this._currentPacket.setSelectedState(bl ? Util.unsetBit(1, this._currentPacket.getSelectedState()) : Util.setBit(1, this._currentPacket.getSelectedState()));
                    }
                    break;
                }
                case 5: {
                    int n4;
                    if (this._mainPacketList == null || this._mainPacketList.getPacketListSize() <= 0) break;
                    n3 = this._mainPacketList.getPacketListSize();
                    for (n4 = 0; n4 < n3; ++n4) {
                        if (!Util.isBitSet(1, this._mainPacketList.getPacketList()[n4].getSelectedState())) continue;
                        this._mainPacketList.getPacketList()[n4].setSelectionType(1);
                    }
                    break;
                }
            }
            if (this.getCurrentPacketListElements() != null) {
                this._downloadPacketList = new UotAPacketList(6);
                for (n3 = 0; n3 < this.getCurrentPacketListElements().length; ++n3) {
                    if (this.getCurrentPacketListElements()[n3].getSelectionType() == 0) continue;
                    this._downloadPacketList.addPacket(this.getCurrentPacketListElements()[n3]);
                }
            }
        }
    }

    public PacketList getToggledPackets(int[] nArray) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".getToggledPackets(").append(Util.isNullOrEmpty(nArray) ? 0 : nArray.length).append(")").toString()).log();
        }
        object = null;
        if (!Util.isNullOrEmpty(nArray) && this.getCompletePacketList() != null && this.getCompletePacketList().getPacketListSize() >= nArray.length) {
            object = new UotAPacketList(7);
            for (int i2 = 0; i2 < this.getCompletePacketList().getPacketListSize(); ++i2) {
                if (!Util.isBitSet(1, nArray[i2])) continue;
                object.addPacket(this.getCompletePacketList().getPacketList()[i2]);
            }
        }
        return object;
    }

    public int[] getSelectedDownloadListIndexArray() {
        int[] nArray = null;
        if (this._downloadPacketList != null && this._downloadPacketList.getPacketListSize() > 0 && this._completeList != null) {
            nArray = new int[this._completeList.getPacketListSize()];
            for (int i2 = 0; i2 < this._completeList.getPacketListSize(); ++i2) {
                nArray[i2] = this._completeList.getPacketList()[i2].getSelectedState();
            }
            return nArray;
        }
        return null;
    }

    public OnlineOnlineDownloadPackageCurrentlySelectedCollector[] getCurrentlySelectedPackets(PacketList packetList) {
        OnlineOnlineDownloadPackageCurrentlySelectedCollector[] onlineOnlineDownloadPackageCurrentlySelectedCollectorArray = new OnlineOnlineDownloadPackageCurrentlySelectedCollector[]{new OnlineOnlineDownloadPackageCurrentlySelectedCollector()};
        if (packetList != null && packetList.getPacketListSize() > 0) {
            if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(this._classname).append(new StringBuffer().append(".getCurrentlySelectedPackets(NumPackets = ").append(packetList.getPacketListSize()).append(")").toString()).log();
            }
            long l = 0L;
            int n = packetList.getPacketListSize();
            for (int i2 = 0; i2 < n; ++i2) {
                l += packetList.getPacketList()[i2].getSize();
            }
            onlineOnlineDownloadPackageCurrentlySelectedCollectorArray[0].online_online_download_package_currently_selected_amount = this.getDownloadPacketList().getPacketListSize();
            onlineOnlineDownloadPackageCurrentlySelectedCollectorArray[0].online_online_download_package_currently_selected_size = l / 0;
            if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(this._classname).append(new StringBuffer().append(".getCurrentlySelectedPackets(NumPackets = ").append(onlineOnlineDownloadPackageCurrentlySelectedCollectorArray[0].online_online_download_package_currently_selected_amount).append("Size = ").append(onlineOnlineDownloadPackageCurrentlySelectedCollectorArray[0].online_online_download_package_currently_selected_size).append(")").toString()).log();
            }
        }
        return onlineOnlineDownloadPackageCurrentlySelectedCollectorArray;
    }

    public OnlineOnlDowPacCurDow1310032Collector[] getCurrentlyDownloadingPackets(OnlineUotAPackage onlineUotAPackage) {
        OnlineOnlDowPacCurDow1310032Collector[] onlineOnlDowPacCurDow1310032CollectorArray = new OnlineOnlDowPacCurDow1310032Collector[]{new OnlineOnlDowPacCurDow1310032Collector()};
        if (onlineUotAPackage != null) {
            onlineOnlDowPacCurDow1310032CollectorArray[0].online_online_download_package_currently_downloading_name = onlineUotAPackage.getLabel();
            onlineOnlDowPacCurDow1310032CollectorArray[0].online_online_download_package_currently_downloading_progress = onlineUotAPackage.getProgressState();
            if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(new StringBuffer().append("Packet = ").append(onlineUotAPackage.getLabel()).append(", Progress = ").append(onlineUotAPackage.getProgressState()).toString()).log();
            }
        }
        return onlineOnlDowPacCurDow1310032CollectorArray;
    }

    public int getPacketIndexFromCompleteList(OnlineUotAPackage onlineUotAPackage) {
        if (onlineUotAPackage != null && this.getCompletePacketList() != null && !Util.isNullOrEmpty(this.getCompletePacketList().getPacketList())) {
            int n = this.getCompletePacketList().getPacketListSize();
            for (int i2 = 0; i2 < n; ++i2) {
                if (!onlineUotAPackage.getLabel().equals(this.getCompletePacketList().getPacketList()[i2].getLabel()) || !Util.isNullOrEmpty(this.getCompletePacketList().getPacketList()[i2].getExtras()) && (this.getCompletePacketList().getPacketList()[i2].getExtras().length < 2 || Util.isNullOrEmpty(this.getCompletePacketList().getPacketList()[i2].getExtras()[1]) || !this.getCompletePacketList().getPacketList()[i2].getExtras()[1].equalsIgnoreCase("1"))) continue;
                return i2;
            }
        }
        ServiceManager.logger2.warn(16384).append(this._classname).append(".getPacketIndexFromCompleteList()--> packet not available in list").log();
        return -1;
    }

    public PacketList getCurrentPacketList() {
        return this._currentList;
    }

    public OnlineUotAPackage[] getCurrentPacketListElements() {
        return this._currentList != null ? this._currentList.getPacketList() : null;
    }

    public PacketList getCompletePacketList() {
        return this._completeList;
    }

    public int getCurrentFilter() {
        return this._currentFilter;
    }

    public void setCurrentFilter(int n) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".setCurrentFilter( filter = ").append(n).append(")").toString()).log();
        }
        this._currentFilter = n;
        switch (this._currentFilter) {
            case 0: {
                this._currentList = this._allPacketList;
                break;
            }
            case 1: {
                this._currentList = this._favoriteList;
                break;
            }
            case 2: {
                this._currentList = this._ppoiList;
                break;
            }
            case 3: {
                this._currentList = this._navDataList;
                break;
            }
            default: {
                this._currentList = this._allPacketList;
            }
        }
        this.buildMainPacketList(this._currentList, null);
    }

    public String getCurrentFilterString(int n) {
        String string = "";
        block0 : switch (this._currentFilter) {
            case 2: {
                switch (n) {
                    case 2: 
                    case 3: {
                        string = "navdata,ppoi";
                        break block0;
                    }
                }
                string = "ppoi";
                break;
            }
            default: {
                string = "navdata,ppoi";
            }
        }
        return string;
    }

    public OnlineUotAPackage getCurrentSelectedPacket() {
        return this._currentPacket;
    }

    public PacketList getMainPacketList() {
        return this._mainPacketList;
    }

    public PacketList getSubPacketList() {
        return this._subPacketList;
    }

    public PacketList getDownloadPacketList() {
        return this._downloadPacketList;
    }

    public int[] resetSelection(int[] nArray) {
        if (!Util.isNullOrEmpty(nArray)) {
            int n = nArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!Util.isBitSet(1, nArray[i2]) || this.getCompletePacketList().getPacketList()[i2].getType() != 0) continue;
                nArray[i2] = Util.unsetBit(1, nArray[i2]);
            }
        }
        return nArray;
    }

    public int getSelectedPacketIndex(int[] nArray) {
        if (!Util.isNullOrEmpty(nArray) && this.getCompletePacketList().getPacketListSize() >= nArray.length) {
            int n = nArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!Util.isBitSet(1, nArray[i2]) || this.getCompletePacketList().getPacketList()[i2].getType() != 0) continue;
                return i2;
            }
        }
        return -1;
    }
}

