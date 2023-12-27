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

public class UotAStateNotActive
extends AbstractHsmState {
    private final UotATarget _target;
    private final String _classname = super.getClass().getName();

    public UotAStateNotActive(UotATarget uotATarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = uotATarget;
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".UotAStateNotActive()").log();
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
            case 1075041834: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineSetter.SET_ONLINE_AVAILABLE_SERVER_LIST) ").log();
                break;
            }
            case 1075041830: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineSetter.SET_ONLINE_UPDATE_PACKAGE_LIST) ").log();
                break;
            }
            case 1075041831: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineSetter.SET_ONLINE_UPDATE_PACKAGE_LIST_ABORT) ").log();
                break;
            }
            case 1075041825: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineSetter.SET_SELECTED_UPDATEFOR_DOWNLOAD) ").log();
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
                ListManager.getGenericASLList(1325208320).updateList(UotAConstants.EMPTY_PACKAGE_LIST);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiUotAUpdateDownloadState(int n, int n2, int n3) {
        this.getPacketController().handleSequence(909, n2);
        if (n2 == 1 || n2 == 4) {
            try {
                this.trans(this.getTarget().getStatePending());
            }
            catch (Exception exception) {}
        } else if (n2 == 2) {
            UotAFactory.getSessionManager().setSessionID(n);
            DSIUotA dSIUotA = this.getTarget().getDSIUotA();
            if (dSIUotA != null) {
                dSIUotA.getAttribute(UotAFactory.getSessionManager().getSessionID(), 1);
            }
        }
    }

    public void dsiUotAUpdateDownloadProgress(int n, int n2, int n3, String string, int n4) {
    }

    public void dsiUotAUpdatePackagesAvailable(int n, int n2) {
        this.getPacketController().handleSequence(901, n);
    }

    public void dsiUotAGetUpdatePackages(int n, int n2, PackageInfo[] packageInfoArray, int[] nArray) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".dsiUotAGetUpdatePackages()").log();
        }
        if (n == 0) {
            if (!this.getPacketController().indicationForAvailablePackets(n, n2, packageInfoArray, nArray) && this.getTarget().getPropertyManager().isUotAServiceReady()) {
                try {
                    this.trans(this.getTarget().getStateActive());
                }
                catch (Exception exception) {
                    this.getTarget().error(exception);
                }
            }
        } else {
            this.getPacketController().responseOfAvailablePackets(n, n2, packageInfoArray, nArray);
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
                    if (!this.getTarget().getPropertyManager().isUotAServiceReady()) break;
                    this.trans(this.getTarget().getStateActive());
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
}

