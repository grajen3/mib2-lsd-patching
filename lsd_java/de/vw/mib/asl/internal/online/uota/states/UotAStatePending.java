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
import org.dsi.ifc.uota.PackageInfo;

public class UotAStatePending
extends AbstractHsmState {
    private final UotATarget _target;
    private final String _classname = super.getClass().getName();

    public UotAStatePending(UotATarget uotATarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = uotATarget;
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".UotAStatePending()").log();
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
                int n = eventGeneric.getInt(0);
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineSetter.SET_ONLINE_AVAILABLE_SERVER_LIST) index=").append(n).log();
                break;
            }
            case 1075041830: {
                int n = eventGeneric.getInt(0);
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineSetter.SET_ONLINE_UPDATE_PACKAGE_LIST) index=").append(n).log();
                break;
            }
            case 1075041831: {
                int n = eventGeneric.getInt(0);
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineSetter.SET_ONLINE_UPDATE_PACKAGE_LIST_ABORT) index=").append(n).log();
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
                if (UotAFactory.getPropertyManager().isUotAServiceReady()) break;
                UotAFactory.getErrorHandler().sendResultFailure(1);
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
            if (this._target.getPropertyManager().getDownloadState() == 1 || this._target.getPropertyManager().getDownloadState() == 4) {
                try {
                    this.trans(this.getTarget().getStateActiveDownload());
                }
                catch (Exception exception) {
                    this.getTarget().error(exception);
                }
            }
        }
    }

    public void dsiUotAUpdateDownloadState(int n, int n2, int n3) {
        this.getPacketController().handleSequence(909, n2);
        if (n2 != 1 || n2 != 2) {
            try {
                this.trans(this.getTarget().getStateActive());
            }
            catch (Exception exception) {
                this.getTarget().error(exception);
            }
        }
    }

    public void dsiUotAUpdateDownloadProgress(int n, int n2, int n3, String string, int n4) {
    }

    public void dsiUotAUpdatePackagesAvailable(int n, int n2) {
        this.getPacketController().handleSequence(901, n);
    }

    public void dsiUotAGetUpdatePackages(int n, int n2, PackageInfo[] packageInfoArray, int[] nArray) {
        if (this.getPacketController().updateToActualPackets(n, n2, packageInfoArray, nArray)) {
            if (this.getTarget().getPropertyManager().getDownloadState() == 1 && this.getTarget().getPropertyManager().isUotAServiceReady() || this.getTarget().getPropertyManager().getDownloadState() == 4) {
                ServiceManager.aslPropertyManager.valueChangedInteger(1107104512, 1);
                try {
                    this.trans(this.getTarget().getStateActiveDownload());
                }
                catch (Exception exception) {
                    this.getTarget().error(exception);
                }
            } else if (this.getTarget().getPropertyManager().getDownloadState() == 2) {
                try {
                    this.trans(this.getTarget().getStateActiveSWDL());
                }
                catch (Exception exception) {
                    this.getTarget().error(exception);
                }
            }
        } else if (this.getTarget().getPropertyManager().isUotAServiceReady()) {
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

    public void dsiUotAToggleSelection(int n, int n2, int[] nArray) {
    }

    public void dsiUotAStartDownload(int n, int n2) {
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
    }

    public void dsiUotAFeatureResult(String string, int n, boolean bl) {
    }
}

