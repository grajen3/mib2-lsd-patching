/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.uota.states;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.uota.UotAFactory;
import de.vw.mib.asl.internal.online.uota.common.UotAConstants;
import de.vw.mib.asl.internal.online.uota.common.UotAUtils;
import de.vw.mib.asl.internal.online.uota.sequence.UotAPacketController;
import de.vw.mib.asl.internal.online.uota.states.UotATarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.uota.DSIUotA;
import org.dsi.ifc.uota.PackageInfo;

public class UotAStateActive
extends AbstractHsmState {
    private final UotATarget _target;
    private final String _classname = super.getClass().getName();

    public UotAStateActive(UotATarget uotATarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = uotATarget;
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".UotAStateActive()").log();
        }
    }

    private UotATarget getTarget() {
        return this._target;
    }

    private UotAPacketController getPacketController() {
        return UotAFactory.getPacketController(this.getTarget());
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                break;
            }
            case 3: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append("->STARTED").log();
                }
                ServiceManager.aslPropertyManager.valueChangedInteger(1107104512, 0);
                break;
            }
            case 4: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append("->EXITED").log();
                break;
            }
            case 1075041834: {
                int n = eventGeneric.getInt(0);
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineSetter.SET_ONLINE_AVAILABLE_SERVER_LIST) index=").append(n).log();
                break;
            }
            case 1075041830: {
                int n = eventGeneric.getInt(0);
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineSetter.SET_ONLINE_UPDATE_PACKAGE_LIST) index=").append(n).log();
                }
                this.getPacketController().handleSequence(905, n);
                break;
            }
            case 1075041831: {
                int n = eventGeneric.getInt(0);
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineSetter.SET_ONLINE_UPDATE_PACKAGE_LIST_ABORT) index=").append(n).log();
                }
                this.getPacketController().handleSequence(908, n);
                break;
            }
            case 1075041825: {
                int n = eventGeneric.getInt(0);
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineSetter.SET_SELECTED_UPDATEFOR_DOWNLOAD) index=").append(n).log();
                break;
            }
            case 1075041829: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineSetter.TOGGLE_AUTOMATIC_DOWNLOAD_OF_UPDATES_ACTIVATION)").log();
                break;
            }
            case 1075041833: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.ENTER_ONLINE_SWDL)").log();
                }
                this.getPacketController().requestForAvailablePackets();
                break;
            }
            case 1075041835: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.AVAILABLE_UPDATE_CANCELED)").log();
                }
                this.getPacketController().handleSequence(914, -1);
                break;
            }
            case 1075041837: {
                int n = eventGeneric.getInt(0);
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.SET_CURRENT_SELECTED_PACKAGE_LIST_ITEM)").log();
                }
                this.getPacketController().handleSequence(900, n);
                break;
            }
            case 1075041852: {
                int n = eventGeneric.getInt(0);
                this.getPacketController().activateFilterBasedList(n);
                break;
            }
            case 1075041853: {
                boolean bl = eventGeneric.getBoolean(0);
                this.getPacketController().handleSequence(903, bl ? 1 : 2);
                break;
            }
            case 1075041855: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.START_DOWNLOAD_SELECTED_PACKAGES)").log();
                }
                this.getPacketController().handleSequence(907, -1);
                break;
            }
            case 1075041863: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.PREPARE_DOWNLOAD_SELECTED_PACKAGES)").log();
                }
                this.getPacketController().handleSequence(905, -1);
                break;
            }
            case 1075041857: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.SET_ONLINE_DOWNLOAD_MAIN_PACKAGE_FOR_SUB_PACKAGE)").log();
                }
                ListManager.getGenericASLList(1341985536).updateList(UotAConstants.EMPTY_PACKAGE_LIST);
                int n = eventGeneric.getInt(0);
                this.getPacketController().handleSequence(904, n);
                break;
            }
            case 1075041858: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.TOGGLE_ONLINE_DOWNLOAD_PACKAGE_MAIN_STATE_ACTIVATED)").log();
                }
                int n = eventGeneric.getInt(0);
                this.getTarget().getPropertyManager().setTogglePacketIndex(n);
                this.getPacketController().handleSequence(903, 3);
                break;
            }
            case 1075041859: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.TOGGLE_ONLINE_DOWNLOAD_PACKAGE_SUB_STATE_ACTIVATED)").log();
                }
                int n = eventGeneric.getInt(0);
                this.getTarget().getPropertyManager().setTogglePacketIndex(n);
                this.getPacketController().handleSequence(903, 4);
                break;
            }
            case 1075041860: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.ABORT_DOWNLOAD_SELECTED_PACKAGES)").log();
                }
                this.getTarget().getPropertyManager().setCurrentSequence(null);
                this.getPacketController().handleSequence(908, -1);
                this.getPacketController().handleSequence(903, 2);
                break;
            }
            case 100001: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(UotAConstants.EV_UOTA_GUIDANCE_STARTED)").log();
                }
                if (!this.getTarget().getPropertyManager().isUotAServiceReady() || this.getTarget().getPropertyManager().isPPOIConfigurationOnly()) break;
                this.getPacketController().handleSequence(903, 2);
                this.getPacketController().requestForCurrentDestinationPackets();
                this.getTarget().getPropertyManager().setNaviDestinationsForLater(false);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiUotAUpdateDownloadState(int n, int n2, int n3) {
        if (n == UotAFactory.getSessionManager().getSessionID()) {
            DSIUotA dSIUotA;
            this.getPacketController().handleSequence(909, n2);
            if (n2 == 1) {
                try {
                    this.trans(this.getTarget().getStateActiveDownload());
                }
                catch (Exception exception) {
                    this.getTarget().error(exception);
                }
            } else if (n2 == 2 && (dSIUotA = this.getTarget().getDSIUotA()) != null) {
                dSIUotA.getAttribute(UotAFactory.getSessionManager().getSessionID(), 1);
            }
        } else {
            UotAFactory.getErrorHandler().sendResultFailure(2);
            this.getPacketController().handleSequence(908, this.getTarget().getPropertyManager().getCurrentPacket().getIndex());
        }
    }

    public void dsiUotAUpdateDownloadProgress(int n, int n2, int n3, String string, int n4) {
        if (n == UotAFactory.getSessionManager().getSessionID()) {
            if (!Util.isNullOrEmpty(string) && !UotAUtils.compare(string, this.getTarget().getPropertyManager().getDownloadInfo())) {
                int n5 = UotAUtils.getIndex(string);
                this.getPacketController().handleSequence(916, n5);
            }
            this.getTarget().getPropertyManager().setProgress(n2, n3, string);
            this.getPacketController().handleSequence(910, n2);
        } else {
            UotAFactory.getErrorHandler().sendResultFailure(2);
            this.getPacketController().handleSequence(908, this.getTarget().getPropertyManager().getCurrentPacket().getIndex());
        }
    }

    public void dsiUotAUpdatePackagesAvailable(int n, int n2) {
        this.getPacketController().handleSequence(901, n);
    }

    public void dsiUotAGetUpdatePackages(int n, int n2, PackageInfo[] packageInfoArray, int[] nArray) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".dsiUotAGetUpdatePackages()").log();
        }
        if (n != UotAFactory.getSessionManager().getSessionID()) {
            if (this.getTarget().getPropertyManager().isNavDBConfigurationOnly()) {
                this.getPacketController().indicationForAvailablePackets(n, n2, packageInfoArray, nArray);
                if (UotAFactory.getPacketListController().getMainPacketList() != null && UotAFactory.getPacketListController().getMainPacketList().getPacketListSize() > 0) {
                    ListManager.getGenericASLList(1325208320).updateList(UotAFactory.getPacketListController().getMainPacketList() != null ? (UotAFactory.getPacketListController().getMainPacketList().getPacketList() != null ? UotAFactory.getPacketListController().getMainPacketList().getPacketList() : UotAConstants.EMPTY_PACKAGE_LIST) : UotAConstants.EMPTY_PACKAGE_LIST);
                    ListManager.getGenericASLList(1375539968).updateList(UotAFactory.getPacketListController().getCurrentlySelectedPackets(UotAFactory.getPacketListController().getToggledPackets(this._target.getPropertyManager().getTogglePacketArray())));
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1207767808);
                }
            }
        } else {
            this.getPacketController().responseOfAvailablePackets(n, n2, packageInfoArray, nArray);
        }
    }

    public void dsiUotAToggleSelection(int n, int n2, int[] nArray) {
        if (UotAFactory.getErrorHandler().checkUotAResult(n2)) {
            if (n == UotAFactory.getSessionManager().getSessionID()) {
                this.getTarget().getPropertyManager().setTogglePacketArray(nArray);
                this.getPacketController().handleSequence(906, -1);
            } else {
                UotAFactory.getErrorHandler().sendResultFailure(2);
                this.getPacketController().handleSequence(908, this.getTarget().getPropertyManager().getCurrentPacket().getIndex());
            }
        }
    }

    public void dsiUotAStartDownload(int n, int n2) {
        if (UotAFactory.getErrorHandler().checkUotAResult(n2) && n != UotAFactory.getSessionManager().getSessionID()) {
            UotAFactory.getErrorHandler().sendResultFailure(2);
            this.getPacketController().handleSequence(908, this.getTarget().getPropertyManager().getCurrentPacket().getIndex());
        }
    }

    public void dsiUotATriggerAction(int n, int n2, int n3, String string) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(new StringBuffer().append("triggerActionResponse(").append(n).append(", ").append(n2).append(", ").append(n3).append(")").toString()).log();
        }
        switch (n3) {
            case 6: {
                if (UotAFactory.getErrorHandler().checkUotAResult(n2)) {
                    if (Util.isNullOrEmpty(string)) break;
                    int n4 = UotAUtils.getIndex(string);
                    this.getPacketController().handleSequence(916, n4);
                    this.getPacketController().handleSequence(912, n4);
                    try {
                        this.trans(this.getTarget().getStateActiveSWDL());
                    }
                    catch (Exception exception) {
                        this.getTarget().error(exception);
                    }
                    break;
                }
                this.getPacketController().handleSequence(908, 0);
                break;
            }
            case 1: {
                this.getPacketController().notifyResetDone();
                break;
            }
            case 4: {
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(238962944);
                eventGeneric.setBoolean(0, !Util.isNullOrEmpty(string) && string.equalsIgnoreCase("succ"));
                this.getTarget().sendSafe(eventGeneric);
                break;
            }
        }
    }

    public void dsiUotAAttributeResult(int n, int n2, int n3, String string) {
        if (UotAFactory.getErrorHandler().checkUotAResult(n2)) {
            if (n == UotAFactory.getSessionManager().getSessionID()) {
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(87968000);
                eventGeneric.setString(0, string);
                eventGeneric.setInt(1, this.getTarget().getPropertyManager().getPacketCategory());
                this.getTarget().sendSafe(eventGeneric);
                this.getPacketController().handleSequence(902, 0);
                this.getPacketController().handleSequence(912, 0);
                try {
                    this.trans(this.getTarget().getStateActiveSWDL());
                }
                catch (Exception exception) {
                    this.getTarget().error(exception);
                }
            } else {
                UotAFactory.getErrorHandler().sendResultFailure(2);
                this.getPacketController().handleSequence(914, this.getTarget().getPropertyManager().getCurrentPacket().getIndex());
            }
        } else {
            this.getPacketController().handleSequence(914, this.getTarget().getPropertyManager().getCurrentPacket().getIndex());
            this.getTarget().info().append(this._classname).append(new StringBuffer().append(".responseAttribute(").append(n2).append(")-> resulted in error state").toString()).log();
        }
    }

    public void dsiUotAFeatureResult(String string, int n, boolean bl) {
    }

    public void dsiUotACustomerDownloadFinished(int n, int n2) {
        block7: {
            if (UotAFactory.getErrorHandler().checkUotAResult(n2)) {
                if (n == UotAFactory.getSessionManager().getSessionID()) {
                    try {
                        if (this.getTarget().getPropertyManager().isUotAServiceReady()) {
                            this.getPacketController().requestForAvailablePackets();
                            this.trans(this.getTarget().getStateActive());
                            break block7;
                        }
                        this.trans(this.getTarget().getStateNotActive());
                    }
                    catch (Exception exception) {
                        this.getTarget().error(exception);
                    }
                } else {
                    UotAFactory.getErrorHandler().sendResultFailure(2);
                }
            } else {
                this.getTarget().info().append(this._classname).append(new StringBuffer().append(".customerDownloadFinished(").append(n2).append(")-> resulted in error state").toString()).log();
            }
        }
    }

    public void dsiUotAGetUpdatePackagesForDestinations(int n, int n2, PackageInfo[] packageInfoArray, int[] nArray) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".dsiUotAGetUpdatePackagesForDestinations()").log();
        }
        this.getPacketController().responseOfCurrentDestinationPackets(n, n2, packageInfoArray, nArray);
    }
}

