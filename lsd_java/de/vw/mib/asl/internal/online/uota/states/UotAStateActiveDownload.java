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

public class UotAStateActiveDownload
extends AbstractHsmState {
    private final UotATarget _target;
    private final String _classname = super.getClass().getName();

    public UotAStateActiveDownload(UotATarget uotATarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = uotATarget;
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".UotAStateActiveDownload()").log();
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
                if (this._target.getPropertyManager().getDownloadState() != 4) break;
                ServiceManager.aslPropertyManager.valueChangedInteger(1107104512, 1);
                break;
            }
            case 4: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append("->EXITED").log();
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
            case 1075041833: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.ENTER_ONLINE_SWDL) -> Do Nothing").log();
                }
                ServiceManager.aslPropertyManager.valueChangedInteger(1107104512, 1);
                break;
            }
            case 1075041835: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.AVAILABLE_UPDATE_CANCELED)").log();
                }
                this.getPacketController().handleSequence(914, -1);
                break;
            }
            case 1075041860: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.ABORT_DOWNLOAD_SELECTED_PACKAGES)").log();
                }
                this.getPacketController().handleSequence(908, -1);
                this.getPacketController().handleSequence(903, 2);
                break;
            }
            case 100001: {
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
            this.getPacketController().handleSequence(909, n2);
            if (n2 == 2) {
                this._target.getPropertyManager().setTogglePacketArray(null);
                boolean bl = this._target.getPropertyManager().getCurrentPacket() != null && this._target.getPropertyManager().getCurrentPacket().getCategory().equals("ppoi");
                this.getTarget().getPropertyManager().setPacketCategory(bl ? 0 : 1);
                DSIUotA dSIUotA = this.getTarget().getDSIUotA();
                if (dSIUotA != null) {
                    dSIUotA.getAttribute(UotAFactory.getSessionManager().getSessionID(), 1);
                }
                try {
                    this.trans(this.getTarget().getStateActiveSWDL());
                }
                catch (Exception exception) {
                    this.getTarget().error(exception);
                }
            } else if (n2 == 4) {
                this.getTarget().getPropertyManager().setPacketCategory(1);
            } else if (n2 != 1) {
                this._target.getPropertyManager().setTogglePacketArray(null);
                try {
                    this.trans(this.getTarget().getStateActive());
                }
                catch (Exception exception) {
                    this.getTarget().error(exception);
                }
            }
        } else {
            UotAFactory.getErrorHandler().sendResultFailure(2);
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
    }

    public void dsiUotAGetUpdatePackages(int n, int n2, PackageInfo[] packageInfoArray, int[] nArray) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".dsiUotAGetUpdatePackages()").log();
        }
        if (this._target.getPropertyManager().getDownloadState() == 1 && n != UotAFactory.getSessionManager().getSessionID()) {
            this.getPacketController().indicationForAvailablePackets(n, n2, packageInfoArray, nArray);
        } else {
            this.getPacketController().updateToActualPackets(n, n2, packageInfoArray, nArray);
            if (this._target.getPropertyManager().getDownloadState() == 4) {
                ServiceManager.aslPropertyManager.valueChangedInteger(1107104512, 1);
            }
        }
    }

    public void dsiUotAToggleSelection(int n, int n2, int[] nArray) {
        block10: {
            if (UotAFactory.getErrorHandler().checkUotAResult(n2)) {
                if (n == UotAFactory.getSessionManager().getSessionID()) {
                    this.getTarget().getPropertyManager().setTogglePacketArray(nArray);
                    this.getPacketController().handleSequence(906, -1);
                } else {
                    UotAFactory.getErrorHandler().sendResultFailure(2);
                    this.getPacketController().handleSequence(908, this.getTarget().getPropertyManager().getCurrentPacket().getIndex());
                    if (this.getTarget().getPropertyManager().isPPOIConfigurationOnly() && this.getTarget().getPropertyManager().getCurrentSequence() != null) {
                        try {
                            if (this.getTarget().getPropertyManager().isUotAServiceReady()) {
                                this.getPacketController().requestForAvailablePackets();
                                this.trans(this.getTarget().getStateActive());
                                break block10;
                            }
                            this.trans(this.getTarget().getStateNotActive());
                        }
                        catch (Exception exception) {
                            this.getTarget().error(exception);
                        }
                    }
                }
            } else {
                try {
                    this.trans(this.getTarget().getStateActive());
                }
                catch (Exception exception) {
                    this.getTarget().error(exception);
                }
            }
        }
    }

    public void dsiUotAStartDownload(int n, int n2) {
        if (UotAFactory.getErrorHandler().checkUotAResult(n2) && n != UotAFactory.getSessionManager().getSessionID()) {
            this.getPacketController().requestForAvailablePackets();
            try {
                this.trans(this.getTarget().getStateActive());
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

    public void dsiUotAAbortDownload(int n, int n2) {
        if (UotAFactory.getErrorHandler().checkUotAResult(n2)) {
            ServiceManager.aslPropertyManager.valueChangedInteger(1107104512, 0);
            this.getTarget().getPropertyManager().setCurrentSequence(null);
            if (n != UotAFactory.getSessionManager().getSessionID()) {
                UotAFactory.getErrorHandler().sendResultFailure(2);
            } else {
                this.getPacketController().requestForAvailablePackets();
            }
        }
        try {
            this.trans(this.getTarget().getStateActive());
        }
        catch (Exception exception) {
            this.getTarget().error(exception);
        }
    }
}

