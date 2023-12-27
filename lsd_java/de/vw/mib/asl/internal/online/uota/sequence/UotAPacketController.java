/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.uota.sequence;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.common.uota.OnlineUotAPackage;
import de.vw.mib.asl.internal.online.uota.UotAFactory;
import de.vw.mib.asl.internal.online.uota.common.UotAConstants;
import de.vw.mib.asl.internal.online.uota.common.UotAUtils;
import de.vw.mib.asl.internal.online.uota.lists.PacketList;
import de.vw.mib.asl.internal.online.uota.sequence.UotADownload;
import de.vw.mib.asl.internal.online.uota.sequence.UotAInstallation;
import de.vw.mib.asl.internal.online.uota.states.UotATarget;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.uota.DSIUotA;
import org.dsi.ifc.uota.PackageInfo;

public class UotAPacketController
extends AbstractFactoryResetParticipant {
    private final String _classname = super.getClass().getName();
    private final UotATarget _target;
    private FactoryResetCallback _resetCallback;
    private boolean _packageListLoading;

    public UotAPacketController(UotATarget uotATarget) {
        this._target = uotATarget;
    }

    private int getSessionID() {
        return UotAFactory.getSessionManager().getSessionID();
    }

    private boolean isSessionValid() {
        return this.getSessionID() != -1;
    }

    public boolean getPackageListLoading() {
        return this._packageListLoading;
    }

    public void handleFactoryReset() {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".handleFactoryReset()-> STARTED").log();
        }
        if (this._target.getDSIUotA() != null) {
            this._target.getDSIUotA().triggerAction(this.getSessionID(), 1, "");
        }
        this.notifyResetDone();
        if (this._target.getPropertyManager().getCurrentSequence() != null) {
            this._target.getPropertyManager().getCurrentSequence().stop();
        }
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".handleFactoryReset()-> ENDED").log();
        }
    }

    public void activateFilterBasedList(int n) {
        if (this._packageListLoading) {
            this._packageListLoading = false;
            ServiceManager.aslPropertyManager.valueChangedBoolean(1073550080, false);
        }
        this.handleSequence(903, 2);
        UotAFactory.getPacketListController().setCurrentFilter(n);
        ListManager.getGenericASLList(1325208320).updateList(UotAFactory.getPacketListController().getMainPacketList() != null ? (UotAFactory.getPacketListController().getMainPacketList().getPacketList() != null ? UotAFactory.getPacketListController().getMainPacketList().getPacketList() : UotAConstants.EMPTY_PACKAGE_LIST) : UotAConstants.EMPTY_PACKAGE_LIST);
        ServiceManager.aslPropertyManager.valueChangedInteger(1291653888, UotAFactory.getPacketListController().getCurrentFilter());
    }

    public void requestForCurrentDestinationPackets() {
        Object[] objectArray;
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".requestForCurrentDestinationPackets()").log();
        }
        if (!Util.isNullOrEmpty(objectArray = UotAFactory.getNavigationGuidanceService(this._target).getCurrentRoute().getRoutelist())) {
            int n = objectArray.length;
            NavLocationWgs84[] navLocationWgs84Array = new NavLocationWgs84[n];
            for (int i2 = 0; i2 < n; ++i2) {
                if (objectArray[i2] == null) continue;
                int n2 = UotAUtils.convertToWgs84(objectArray[i2].getLatitude());
                int n3 = UotAUtils.convertToWgs84(objectArray[i2].getLongitude());
                navLocationWgs84Array[i2] = new NavLocationWgs84(n3, n2);
            }
            if (this._target.getDSIUotA() != null) {
                this._target.getDSIUotA().getUpdatePackagesForDestinations(this.getSessionID(), navLocationWgs84Array, 0);
            }
        }
    }

    public void requestForAvailablePackets() {
        if (!UotAFactory.getSessionManager().checkForRequestPending(1003)) {
            if (this._target.isTraceEnabled()) {
                this._target.trace().append(this._classname).append(".requestForAvailablePackets()-> STARTED").log();
            }
            this._packageListLoading = true;
            ServiceManager.aslPropertyManager.valueChangedBoolean(1073550080, true);
            ListManager.getGenericASLList(1325208320).updateList(UotAConstants.EMPTY_PACKAGE_LIST);
            ListManager.getGenericASLList(1341985536).updateList(UotAConstants.EMPTY_PACKAGE_LIST);
            ListManager.getGenericASLList(1358762752).updateList(UotAFactory.getPacketListController().getCurrentlyDownloadingPackets(null));
            ListManager.getGenericASLList(1375539968).updateList(UotAFactory.getPacketListController().getCurrentlySelectedPackets(null));
            if (this.isSessionValid()) {
                DSIUotA dSIUotA = this._target.getDSIUotA();
                if (dSIUotA != null) {
                    String string = null;
                    if (!Util.isNullOrEmpty(this._target.getPropertyManager().getServerList())) {
                        string = this._target.getPropertyManager().getServerList()[0];
                    }
                    UotAFactory.getSessionManager().executedRequestWithSession(this.getSessionID(), 1003, this._target.getPropertyManager().isPPOIConfigurationOnly());
                    dSIUotA.getUpdatePackages(this.getSessionID(), string, UotAFactory.getPacketListController().getCurrentFilterString(this._target.getPropertyManager().getCurrentConfiguration()));
                    if (this._target.isTraceEnabled()) {
                        this._target.trace().append(this._classname).append(".requestForAvailablePackets()-> ENDED").log();
                    }
                }
            } else {
                this._packageListLoading = false;
                ServiceManager.aslPropertyManager.valueChangedBoolean(1073550080, false);
                UotAFactory.getErrorHandler().sendResultFailure(2);
                this._target.warn().append(this._classname).append(".requestForAvailablePackets() SessionID is invalid -> FAILED").log();
            }
        } else if (!this._packageListLoading) {
            this._packageListLoading = true;
            ServiceManager.aslPropertyManager.valueChangedBoolean(1073550080, true);
        }
    }

    public void responseOfCurrentDestinationPackets(int n, int n2, PackageInfo[] packageInfoArray, int[] nArray) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".responseOfCurrentDestinationPackets( SessionID = ").append(n).append(", result = ").append(n2).append(")").append("-> STARTED").toString()).log();
        }
        if (UotAFactory.getErrorHandler().checkUotAResult(n2)) {
            if (n == this.getSessionID()) {
                String string = !Util.isNullOrEmpty(this._target.getPropertyManager().getServerList()) ? this._target.getPropertyManager().getServerList()[0] : null;
                UotAFactory.getPacketListController().updatePacketList(packageInfoArray, nArray, string);
                this._target.getPropertyManager().setTogglePacketArray(nArray);
                UotAFactory.getPacketListController().setCurrentFilter(3);
                ServiceManager.aslPropertyManager.valueChangedInteger(1291653888, UotAFactory.getPacketListController().getCurrentFilter());
                UotAFactory.getPacketListController().handleDownloadPacketList(5, -1);
                PacketList packetList = UotAFactory.getPacketListController().getToggledPackets(this._target.getPropertyManager().getTogglePacketArray());
                if (packetList != null && packetList.getPacketListSize() > 0) {
                    if (this._target.isTraceEnabled()) {
                        this._target.trace().append(this._classname).append(".responseOfCurrentDestinationPackets() --> Map Update is available for Destination").log();
                    }
                    Object[] objectArray = UotAFactory.getPacketListController().getCurrentlySelectedPackets(packetList);
                    ListManager.getGenericASLList(1325208320).updateList(UotAFactory.getPacketListController().getMainPacketList() != null ? (UotAFactory.getPacketListController().getMainPacketList().getPacketList() != null ? UotAFactory.getPacketListController().getMainPacketList().getPacketList() : UotAConstants.EMPTY_PACKAGE_LIST) : UotAConstants.EMPTY_PACKAGE_LIST);
                    ListManager.getGenericASLList(1375539968).updateList(objectArray);
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1224545024);
                }
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append(this._classname).append(".responseOfCurrentDestinationPackets()-> ENDED").log();
                }
            } else {
                UotAFactory.getErrorHandler().sendResultFailure(2);
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append(this._classname).append(".responseOfCurrentDestinationPackets()-> FAILED").log();
                }
            }
        }
        this._packageListLoading = false;
        ServiceManager.aslPropertyManager.valueChangedBoolean(1073550080, false);
    }

    public void responseOfAvailablePackets(int n, int n2, PackageInfo[] packageInfoArray, int[] nArray) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".responseOfAvailablePackets( SessionID = ").append(n).append(", result = ").append(n2).append(")").append("-> STARTED").toString()).log();
        }
        if (UotAFactory.getSessionManager().checkToResetRequest(n, 1003) && UotAFactory.getErrorHandler().checkUotAResult(n2)) {
            if (n == this.getSessionID()) {
                String string = !Util.isNullOrEmpty(this._target.getPropertyManager().getServerList()) ? this._target.getPropertyManager().getServerList()[0] : null;
                UotAFactory.getPacketListController().updatePacketList(packageInfoArray, nArray, string);
                ListManager.getGenericASLList(1325208320).updateList(UotAFactory.getPacketListController().getMainPacketList() != null ? (!Util.isNullOrEmpty(UotAFactory.getPacketListController().getMainPacketList().getPacketList()) ? UotAFactory.getPacketListController().getMainPacketList().getPacketList() : UotAConstants.EMPTY_PACKAGE_LIST) : UotAConstants.EMPTY_PACKAGE_LIST);
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append(this._classname).append(".responseOfAvailablePackets()-> ENDED").log();
                }
            } else {
                UotAFactory.getErrorHandler().sendResultFailure(2);
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append(this._classname).append(".responseOfAvailablePackets()-> FAILED").log();
                }
            }
        }
        this._packageListLoading = false;
        ServiceManager.aslPropertyManager.valueChangedBoolean(1073550080, false);
    }

    public boolean indicationForAvailablePackets(int n, int n2, PackageInfo[] packageInfoArray, int[] nArray) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".indicationForAvailablePackets( sessionID = ").append(n).append(", result = ").append(n2).append(")").append("-> STARTED").toString()).log();
        }
        if (UotAFactory.getErrorHandler().checkUotAResult(n2)) {
            String string;
            String string2 = string = !Util.isNullOrEmpty(this._target.getPropertyManager().getServerList()) ? this._target.getPropertyManager().getServerList()[0] : null;
            if (UotAFactory.getPacketListController().updatePacketList(packageInfoArray, nArray, string)) {
                Object[] objectArray;
                Object[] objectArray2 = UotAFactory.getPacketListController().getMainPacketList() != null ? (UotAFactory.getPacketListController().getMainPacketList().getPacketList() != null ? UotAFactory.getPacketListController().getMainPacketList().getPacketList() : UotAConstants.EMPTY_PACKAGE_LIST) : (objectArray = UotAConstants.EMPTY_PACKAGE_LIST);
                if (!Util.isNullOrEmpty(objectArray)) {
                    ListManager.getGenericASLList(1325208320).updateList(objectArray);
                    if (this._target.isTraceEnabled()) {
                        this._target.trace().append(this._classname).append(".indicationForAvailablePackets()-> ENDED").log();
                    }
                    return true;
                }
            }
        } else {
            this._target.getPropertyManager().setDownloadState(0);
        }
        this._target.info().append(this._classname).append(".indicationForAvailablePackets()-> FAILED").log();
        return false;
    }

    public boolean updateToActualPackets(int n, int n2, PackageInfo[] packageInfoArray, int[] nArray) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".updateToActualPackets( sessionID = ").append(n).append(", result = ").append(n2).append(")").append("-> STARTED").toString()).log();
        }
        if (UotAFactory.getErrorHandler().checkUotAResult(n2) && !Util.isNullOrEmpty(packageInfoArray)) {
            String string;
            String string2 = string = !Util.isNullOrEmpty(this._target.getPropertyManager().getServerList()) ? this._target.getPropertyManager().getServerList()[0] : null;
            if (UotAFactory.getPacketListController().updatePacketList(packageInfoArray, nArray, string)) {
                UotADownload uotADownload = null;
                uotADownload = packageInfoArray.length == 1 ? new UotADownload(this._target, UotAFactory.getPacketListController().getCurrentPacketList().getPacketWithIndex(0)) : new UotADownload(this._target, UotAFactory.getPacketListController().getCompletePacketList().getPacketList());
                this._target.getPropertyManager().setCurrentSequence(uotADownload);
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append(this._classname).append(".updateToActualPackets()-> ENDED").log();
                }
                return true;
            }
        }
        this._target.info().append(this._classname).append(".updateToActualPackets()-> FAILED").log();
        return false;
    }

    public void handleSequence(int n, int n2) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".handleSequence(").append(n).append(",").append(n2).append(")").toString()).log();
        }
        switch (n) {
            case 900: {
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append("PACKET_NAME").log();
                }
                if (UotAFactory.getPacketListController().getCurrentPacketList() == null || Util.isNullOrEmpty(UotAFactory.getPacketListController().getCurrentPacketList().getPacketList())) break;
                String string = UotAFactory.getPacketListController().getCurrentPacketList().getPacketWithIndex(n2) != null ? UotAFactory.getPacketListController().getCurrentPacketList().getPacketWithIndex(n2).getLabel() : "";
                ServiceManager.aslPropertyManager.valueChangedString(855446272, string);
                break;
            }
            case 901: {
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append("DOWNLOAD_START").log();
                }
                ServiceManager.aslPropertyManager.valueChangedInteger(1409094400, n2);
                this._target.getPropertyManager().setPacketCount(n2);
                break;
            }
            case 902: {
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append("SET_CURRENT_PACKET").log();
                }
                OnlineUotAPackage onlineUotAPackage = UotAFactory.getPacketListController().getCompletePacketList().getPacketWithIndex(n2);
                if (UotAFactory.getPacketListController().getCurrentPacketList() != null && !Util.isNullOrEmpty(UotAFactory.getPacketListController().getCurrentPacketList().getPacketList())) {
                    onlineUotAPackage = UotAFactory.getPacketListController().getCurrentPacketList().getPacketWithIndex(n2);
                }
                this._target.getPropertyManager().setCurrentPacket(onlineUotAPackage);
                break;
            }
            case 907: {
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append("DOWNLOAD_START").log();
                }
                if (UotAFactory.getPacketListController().getCurrentPacketList() == null || Util.isNullOrEmpty(UotAFactory.getPacketListController().getCurrentPacketList().getPacketList()) || n2 >= 0) break;
                Object[] objectArray = UotAFactory.getPacketListController().getDownloadPacketList().getPacketList();
                if (!Util.isNullOrEmpty(objectArray)) {
                    UotADownload uotADownload = null;
                    if (this._target.getPropertyManager().isPPOIConfigurationOnly() || objectArray.length == 1 && objectArray[0] != null) {
                        int n3 = UotAFactory.getPacketListController().getPacketIndexFromCompleteList((OnlineUotAPackage)objectArray[0]);
                        ((OnlineUotAPackage)objectArray[0]).setIndex(n3 != -1 ? n3 : 0);
                        this._target.getPropertyManager().setCurrentPacket((OnlineUotAPackage)objectArray[0]);
                        uotADownload = new UotADownload(this._target, (OnlineUotAPackage)objectArray[0]);
                    } else {
                        uotADownload = new UotADownload(this._target, (OnlineUotAPackage[])objectArray);
                    }
                    this._target.getPropertyManager().setCurrentSequence(uotADownload);
                    this._target.getPropertyManager().getCurrentSequence().start();
                    break;
                }
                if (!this._target.isTraceEnabled()) break;
                this._target.trace().append("DOWNLOAD_START --> No packets available for download").log();
                break;
            }
            case 917: {
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append("DOWNLOAD_RESTART").log();
                }
                if (UotAFactory.getPacketListController().getCurrentPacketList() == null || Util.isNullOrEmpty(UotAFactory.getPacketListController().getCurrentPacketList().getPacketList()) || n2 >= 0) break;
                Object[] objectArray = UotAFactory.getPacketListController().getDownloadPacketList().getPacketList();
                if (!Util.isNullOrEmpty(objectArray)) {
                    UotADownload uotADownload = null;
                    if (this._target.getPropertyManager().isPPOIConfigurationOnly() || objectArray.length == 1 && objectArray[0] != null) {
                        int n4 = UotAFactory.getPacketListController().getPacketIndexFromCompleteList((OnlineUotAPackage)objectArray[0]);
                        ((OnlineUotAPackage)objectArray[0]).setIndex(n4 != -1 ? n4 : 0);
                        this._target.getPropertyManager().setCurrentPacket((OnlineUotAPackage)objectArray[0]);
                        uotADownload = new UotADownload(this._target, (OnlineUotAPackage)objectArray[0]);
                    } else {
                        uotADownload = new UotADownload(this._target, (OnlineUotAPackage[])objectArray);
                    }
                    this._target.getPropertyManager().setCurrentSequence(uotADownload);
                    break;
                }
                if (!this._target.isTraceEnabled()) break;
                this._target.trace().append("DOWNLOAD_RESTART --> No packets available for download").log();
                break;
            }
            case 905: {
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append("DOWNLOAD_PREPARE").log();
                }
                if (UotAFactory.getPacketListController().getCurrentPacketList() == null || Util.isNullOrEmpty(UotAFactory.getPacketListController().getCurrentPacketList().getPacketList()) || n2 >= 0) break;
                Object[] objectArray = UotAFactory.getPacketListController().getDownloadPacketList().getPacketList();
                if (!Util.isNullOrEmpty(objectArray)) {
                    DSIUotA dSIUotA = this._target.getDSIUotA();
                    if (dSIUotA == null) break;
                    if (this._target.getPropertyManager().isPPOIConfigurationOnly() || objectArray.length == 1 && objectArray[0] != null) {
                        int n5 = UotAFactory.getPacketListController().getPacketIndexFromCompleteList((OnlineUotAPackage)objectArray[0]);
                        ((OnlineUotAPackage)objectArray[0]).setIndex(n5 != -1 ? n5 : 0);
                        this._target.getPropertyManager().setCurrentPacket((OnlineUotAPackage)objectArray[0]);
                        dSIUotA.toggleSelection(UotAFactory.getSessionManager().getSessionID(), this._target.getPropertyManager().getCurrentPacket().getIndex());
                        break;
                    }
                    dSIUotA.setSelection(UotAFactory.getSessionManager().getSessionID(), UotAFactory.getPacketListController().getSelectedDownloadListIndexArray());
                    break;
                }
                if (!this._target.isTraceEnabled()) break;
                this._target.trace().append("DOWNLOAD_PREPARE --> No packets available for download").log();
                break;
            }
            case 906: {
                PacketList packetList;
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append("DOWNLOAD_TOGGLE").log();
                }
                if ((packetList = UotAFactory.getPacketListController().getToggledPackets(this._target.getPropertyManager().getTogglePacketArray())).getPacketList() == null) break;
                ListManager.getGenericASLList(1375539968).updateList(UotAFactory.getPacketListController().getCurrentlySelectedPackets(UotAFactory.getPacketListController().getToggledPackets(this._target.getPropertyManager().getTogglePacketArray())));
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1291653888);
                break;
            }
            case 908: {
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append("DOWNLOAD_CANCEL").log();
                }
                if (this._target.getPropertyManager().getCurrentSequence() != null) {
                    this._target.getPropertyManager().getCurrentSequence().stop();
                    break;
                }
                PacketList packetList = UotAFactory.getPacketListController().getToggledPackets(this._target.getPropertyManager().getTogglePacketArray());
                DSIUotA dSIUotA = this._target.getDSIUotA();
                if (dSIUotA == null) break;
                if (packetList != null && packetList.getPacketListSize() > 1) {
                    dSIUotA.setSelection(UotAFactory.getSessionManager().getSessionID(), UotAFactory.getPacketListController().resetSelection(this._target.getPropertyManager().getTogglePacketArray()));
                    break;
                }
                int n6 = UotAFactory.getPacketListController().getSelectedPacketIndex(this._target.getPropertyManager().getTogglePacketArray());
                if (n6 <= -1 || this._target.getPropertyManager().isPPOIConfigurationOnly()) break;
                dSIUotA.toggleSelection(UotAFactory.getSessionManager().getSessionID(), n6);
                break;
            }
            case 909: {
                this._target.getPropertyManager().setDownloadState(n2);
                if (this._target.getPropertyManager().getCurrentPacket() == null || this._target.getPropertyManager().getCurrentSequence() == null) break;
                this._target.getPropertyManager().getCurrentSequence().process(909);
                break;
            }
            case 910: {
                if (this._target.getPropertyManager().getCurrentPacket() == null || this._target.getPropertyManager().getCurrentSequence() == null) break;
                this._target.getPropertyManager().getCurrentSequence().process(910);
                break;
            }
            case 911: {
                UotAInstallation uotAInstallation = new UotAInstallation(this._target, this._target.getPropertyManager().getCurrentPacket());
                this._target.getPropertyManager().setCurrentSequence(uotAInstallation);
                this._target.getPropertyManager().getCurrentSequence().start();
                break;
            }
            case 912: {
                UotAInstallation uotAInstallation = new UotAInstallation(this._target, this._target.getPropertyManager().getCurrentPacket());
                this._target.getPropertyManager().setCurrentSequence(uotAInstallation);
                this._target.getPropertyManager().getCurrentSequence().process(912);
                break;
            }
            case 913: 
            case 914: 
            case 915: {
                if (this._target.getPropertyManager().getCurrentSequence() != null) {
                    this._target.getPropertyManager().getCurrentSequence().finish(n);
                }
                this._target.getPropertyManager().setCurrentSequence(null);
                this._target.getPropertyManager().setCurrentPacket(null);
                break;
            }
            case 916: {
                Object[] objectArray;
                OnlineUotAPackage onlineUotAPackage;
                if (UotAFactory.getPacketListController().getCompletePacketList() == null || Util.isNullOrEmpty(UotAFactory.getPacketListController().getCompletePacketList().getPacketList()) || (onlineUotAPackage = UotAFactory.getPacketListController().getCompletePacketList().getPacketWithIndex(n2)) == null) break;
                this._target.getPropertyManager().setCurrentPacket(onlineUotAPackage);
                onlineUotAPackage.setIndex(n2);
                Object[] objectArray2 = UotAFactory.getPacketListController().getMainPacketList() != null ? (UotAFactory.getPacketListController().getMainPacketList().getPacketList() != null ? UotAFactory.getPacketListController().getMainPacketList().getPacketList() : UotAConstants.EMPTY_PACKAGE_LIST) : (objectArray = UotAConstants.EMPTY_PACKAGE_LIST);
                if (Util.isNullOrEmpty(objectArray)) break;
                ListManager.getGenericASLList(1325208320).updateList(objectArray);
                break;
            }
            case 904: {
                ListManager.getGenericASLList(1341985536).updateList(null);
                break;
            }
            case 903: {
                UotAFactory.getPacketListController().handleDownloadPacketList(n2, this._target.getPropertyManager().getTogglePacketIndex());
                ListManager.getGenericASLList(1325208320).updateList(UotAFactory.getPacketListController().getMainPacketList() != null ? (!Util.isNullOrEmpty(UotAFactory.getPacketListController().getMainPacketList().getPacketList()) ? UotAFactory.getPacketListController().getMainPacketList().getPacketList() : UotAConstants.EMPTY_PACKAGE_LIST) : UotAConstants.EMPTY_PACKAGE_LIST);
                ListManager.getGenericASLList(1375539968).updateList(UotAFactory.getPacketListController().getCurrentlySelectedPackets(UotAFactory.getPacketListController().getDownloadPacketList()));
                break;
            }
        }
    }

    public void timeOutError(int n, int n2) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".timeOutError(").append(n).append(", ").append(n2).append(")").toString()).log();
        }
        if (n == 8304) {
            switch (n2) {
                case 1002: {
                    break;
                }
                case 1003: {
                    ListManager.getGenericASLList(1325208320).updateList(UotAConstants.EMPTY_PACKAGE_LIST);
                    this._packageListLoading = false;
                    ServiceManager.aslPropertyManager.valueChangedBoolean(1073550080, false);
                    UotAFactory.getSessionManager().setRequest(0);
                    break;
                }
                case 1005: {
                    this._target.getPropertyManager().getCurrentSequence().stop();
                    break;
                }
                case 1006: {
                    this._target.getPropertyManager().getCurrentSequence().stop();
                    break;
                }
                case 1007: {
                    break;
                }
                case 1008: {
                    this.notifyResetDone();
                    break;
                }
                case 1009: {
                    this._target.getPropertyManager().getCurrentSequence().finish(914);
                    break;
                }
                case 1010: {
                    break;
                }
                case 1011: {
                    break;
                }
                case 1012: {
                    break;
                }
                case 1013: {
                    break;
                }
                case 1014: {
                    break;
                }
            }
        } else {
            switch (n) {
                case 8300: {
                    break;
                }
                case 8301: {
                    break;
                }
                case 8302: {
                    break;
                }
                case 8303: {
                    break;
                }
                case 8305: {
                    break;
                }
                case 10001: {
                    break;
                }
            }
        }
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        if (factoryResetCallback != null) {
            this._resetCallback = factoryResetCallback;
            this.handleFactoryReset();
        }
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    public void notifyResetDone() {
        if (this._resetCallback != null) {
            this._resetCallback.notifyResetDone();
        }
    }
}

