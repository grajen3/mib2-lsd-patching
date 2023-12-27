/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.uota.states;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.uota.UotAFactory;
import de.vw.mib.asl.internal.online.uota.common.UotAUtils;
import de.vw.mib.asl.internal.online.uota.sequence.UotAPacketController;
import de.vw.mib.asl.internal.online.uota.states.UotATarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.Util;
import org.dsi.ifc.uota.DSIUotA;
import org.dsi.ifc.uota.PackageInfo;

public class UotAStateActiveSWDL
extends AbstractHsmState {
    private final UotATarget _target;
    private final String _classname = super.getClass().getName();

    public UotAStateActiveSWDL(UotATarget uotATarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = uotATarget;
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".UotAStateActiveSWDL()").log();
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
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append("->STARTED").log();
                break;
            }
            case 4: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append("->EXITED").log();
                break;
            }
            case 1075041833: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.ENTER_ONLINE_SWDL)").log();
                break;
            }
            case 100002: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(UotAConstants.EV_UOTA_INSTALLATION_STATUS)").log();
                }
                int n = eventGeneric.getInt(0);
                this.getPacketController().handleSequence(n, -1);
                if (!this.getTarget().getPropertyManager().isPPOIConfigurationOnly()) break;
                this._target.getPropertyManager().setDownloadState(0);
                this.getTarget().getPropertyManager().setPacketCategory(0);
                if (this.getTarget().getPropertyManager().isUotAServiceReady()) {
                    this.trans(this.getTarget().getStateActive());
                    break;
                }
                this.trans(this.getTarget().getStateNotActive());
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
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiUotAUpdateServcieReady(int n, boolean bl, int n2) {
        UotAFactory.getSessionManager().setSessionID(n);
        this.getTarget().updateUOTAServiceStatus(bl);
        if (bl && !this.getTarget().getPropertyManager().isUotAServiceReady()) {
            this.getTarget().getPropertyManager().setUotAServiceReady(bl);
        }
    }

    public void dsiUotAUpdateDownloadState(int n, int n2, int n3) {
        block15: {
            this._target.getPropertyManager().setDownloadState(n2);
            if (n != UotAFactory.getSessionManager().getSessionID()) {
                UotAFactory.getErrorHandler().sendResultFailure(2);
                try {
                    if (this.getTarget().getPropertyManager().isUotAServiceReady()) {
                        this.trans(this.getTarget().getStateActive());
                        break block15;
                    }
                    this.trans(this.getTarget().getStateNotActive());
                }
                catch (Exception exception) {
                    this.getTarget().error(exception);
                }
            } else {
                switch (n2) {
                    case 0: {
                        this.getTarget().getPropertyManager().setPacketCategory(0);
                        try {
                            if (this.getTarget().getPropertyManager().isUotAServiceReady()) {
                                if (UotAFactory.getNavigationGuidanceService(this._target).isRgActive() && !this._target.getPropertyManager().isNaviDestinationsSetForLater() && !this._target.getPropertyManager().isNaviDestinationsTillNextRevision()) {
                                    this.getPacketController().requestForCurrentDestinationPackets();
                                }
                                this.trans(this.getTarget().getStateActive());
                                break;
                            }
                            this.trans(this.getTarget().getStateNotActive());
                        }
                        catch (Exception exception) {
                            this.getTarget().error(exception);
                        }
                        break;
                    }
                    case 2: {
                        this.getTarget().getPropertyManager().setPacketCategory(1);
                        DSIUotA dSIUotA = this.getTarget().getDSIUotA();
                        if (dSIUotA == null) break;
                        dSIUotA.getAttribute(UotAFactory.getSessionManager().getSessionID(), 1);
                        break;
                    }
                    case 4: {
                        this.getTarget().getPropertyManager().setPacketCategory(1);
                        ServiceManager.aslPropertyManager.valueChangedInteger(1107104512, 1);
                        break;
                    }
                    case 1: {
                        break;
                    }
                }
            }
        }
    }

    public void dsiUotAUpdateDownloadProgress(int n, int n2, int n3, String string, int n4) {
        block6: {
            if (this.getTarget().getPropertyManager().getDownloadState() == 1) {
                this.getTarget().getPropertyManager().setPacketCategory(0);
                try {
                    if (this.getTarget().getPropertyManager().isUotAServiceReady()) {
                        this.getPacketController().handleSequence(917, -1);
                        ServiceManager.aslPropertyManager.valueChangedInteger(1107104512, 1);
                        this.trans(this.getTarget().getStateActiveDownload());
                        break block6;
                    }
                    this.trans(this.getTarget().getStateNotActive());
                }
                catch (Exception exception) {
                    this.getTarget().error(exception);
                }
            } else if (this.getTarget().getPropertyManager().getDownloadState() == 4) {
                int n5 = UotAUtils.getIndex(string);
                this.getPacketController().handleSequence(902, n5);
                this.getPacketController().handleSequence(912, 0);
                this.getTarget().getPropertyManager().setProgress(n2, n3, string);
            }
        }
    }

    public void dsiUotAUpdatePackagesAvailable(int n, int n2) {
    }

    public void dsiUotAGetUpdatePackages(int n, int n2, PackageInfo[] packageInfoArray, int[] nArray) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".dsiUotAGetUpdatePackages()").log();
        }
        if (this.getPacketController().indicationForAvailablePackets(n, n2, packageInfoArray, nArray) && this.getTarget().getPropertyManager().getDownloadState() != 2) {
            if (this.getTarget().getPropertyManager().isUotAServiceReady()) {
                try {
                    this.trans(this.getTarget().getStateActive());
                }
                catch (Exception exception) {
                    this.getTarget().error(exception);
                }
            } else {
                try {
                    this.trans(this.getTarget().getStateNotActive());
                }
                catch (Exception exception) {
                    this.getTarget().error(exception);
                }
            }
        }
    }

    public void dsiUotAToggleSelection(int n, int n2, int[] nArray) {
        this.getPacketController().handleSequence(908, this.getTarget().getPropertyManager().getCurrentPacket().getIndex());
        if (this.getTarget().getPropertyManager().isPPOIConfigurationOnly() && this.getTarget().getPropertyManager().getCurrentSequence() != null) {
            try {
                if (this.getTarget().getPropertyManager().isUotAServiceReady()) {
                    this.getPacketController().requestForAvailablePackets();
                    this.trans(this.getTarget().getStateActive());
                } else {
                    this.trans(this.getTarget().getStateNotActive());
                }
            }
            catch (Exception exception) {
                this.getTarget().error(exception);
            }
        }
    }

    public void dsiUotAStartDownload(int n, int n2) {
        this.getPacketController().handleSequence(908, this.getTarget().getPropertyManager().getCurrentPacket().getIndex());
        if (this.getTarget().getPropertyManager().isPPOIConfigurationOnly() && this.getTarget().getPropertyManager().getCurrentSequence() != null) {
            try {
                if (this.getTarget().getPropertyManager().isUotAServiceReady()) {
                    this.getPacketController().requestForAvailablePackets();
                    this.trans(this.getTarget().getStateActive());
                } else {
                    this.trans(this.getTarget().getStateNotActive());
                }
            }
            catch (Exception exception) {
                this.getTarget().error(exception);
            }
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
                if (!this.getTarget().getPropertyManager().isPPOIConfigurationOnly() || this.getTarget().getPropertyManager().getCurrentSequence() == null) break;
                try {
                    if (this.getTarget().getPropertyManager().isUotAServiceReady()) {
                        this.getPacketController().requestForAvailablePackets();
                        this.trans(this.getTarget().getStateActive());
                        break;
                    }
                    this.trans(this.getTarget().getStateNotActive());
                }
                catch (Exception exception) {
                    this.getTarget().error(exception);
                }
                break;
            }
            case 1: {
                this.getPacketController().notifyResetDone();
                try {
                    this.trans(this.getTarget().getStateActive());
                }
                catch (Exception exception) {
                    this.getTarget().error(exception);
                }
                break;
            }
            case 4: {
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(238962944);
                eventGeneric.setBoolean(0, !Util.isNullOrEmpty(string) && string.equalsIgnoreCase("succ"));
                this.getTarget().sendSafe(eventGeneric);
                try {
                    if (this.getTarget().getPropertyManager().isUotAServiceReady()) {
                        this.trans(this.getTarget().getStateActive());
                        break;
                    }
                    this.trans(this.getTarget().getStateNotActive());
                }
                catch (Exception exception) {
                    this.getTarget().error(exception);
                }
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
                this.getPacketController().handleSequence(912, 0);
            } else {
                UotAFactory.getErrorHandler().sendResultFailure(2);
                this.getPacketController().handleSequence(914, this.getTarget().getPropertyManager().getCurrentPacket().getIndex());
            }
        } else {
            this.getPacketController().handleSequence(914, this.getTarget().getPropertyManager().getCurrentPacket().getIndex());
            this.getTarget().info().append(this._classname).append(new StringBuffer().append(".responseAttribute(").append(n2).append(")-> resulted in error state").toString()).log();
        }
    }

    public void dsiUotACustomerDownloadFinished(int n, int n2) {
        if (!UotAFactory.getErrorHandler().checkUotAResult(n2)) {
            this.getTarget().info().append(this._classname).append(new StringBuffer().append(".dsiUotACustomerDownloadFinished(").append(n2).append(")-> resulted in error state").toString()).log();
        }
    }
}

