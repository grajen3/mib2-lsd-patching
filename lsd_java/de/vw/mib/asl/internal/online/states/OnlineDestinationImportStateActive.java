/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.states;

import de.vw.mib.asl.api.online.ASLOnlineCoreServices;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.api.online.ASLOnlineServiceListener;
import de.vw.mib.asl.internal.online.OnlineDestinationImportController;
import de.vw.mib.asl.internal.online.OnlineDestinationImportManager;
import de.vw.mib.asl.internal.online.states.OnlineDestinationImportTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.online.PortalADBEntry;

public class OnlineDestinationImportStateActive
extends AbstractHsmState
implements ASLOnlineServiceListener {
    private final OnlineDestinationImportTarget _target;
    private final String _classname = super.getClass().getName();

    public OnlineDestinationImportStateActive(OnlineDestinationImportTarget onlineDestinationImportTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = onlineDestinationImportTarget;
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".OnlineDestinationImportStateActive()").log();
        }
    }

    private OnlineDestinationImportTarget getTarget() {
        return this._target;
    }

    OnlineDestinationImportController getController() {
        return OnlineDestinationImportManager.getOnlineDestinationImportController();
    }

    @Override
    public void updateServiceStatusOnChange(int n) {
        if (n == 0 && this.getController().getAutomaticDestinationImportProcess() != 2) {
            if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace().append(this._classname).append(" start destination import on life cycle startup").log();
            }
            this.getController().callForAutomaticDestinationImportonStartup();
        }
        this.getController().setServiceStatus(n);
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
                    this.getTarget().trace().append(this._classname).append(".handle(IdEventGeneric.HSM_START)").log();
                }
                ASLOnlineCoreServices aSLOnlineCoreServices = ASLOnlineFactory.getOnlineCoreServices();
                aSLOnlineCoreServices.registerForServiceUpdate(aSLOnlineCoreServices.getServiceIDWithNumericServiceID(9), this);
                break;
            }
            case 4: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(IdEventGeneric.HSM_EXIT)").log();
                break;
            }
            case 1075041832: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.START_DOWNLOAD_DESTINATION)").log();
                }
                if (!this.getController().isDownloadStateActive()) {
                    this.getController().startDownloadDestinations(false);
                    break;
                }
                this.getTarget().info().append(this._classname).append(" DESTINATION IMPORT IN PPROGRESS ").log();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiDestinationImportDownloadAddressListResult(PortalADBEntry[] portalADBEntryArray, int n, int n2) {
        this.getController().responseDownloadAddressListResult(portalADBEntryArray, n, n2);
    }

    public void dsiDestinationImportStopActionResult(int n) {
        this.getController().responseStopActionResult(n);
    }

    public void dsiDestinationImportUpdateEntries(int n, int n2) {
        if (n2 == 1) {
            this.getController().updateEntries(n);
        }
    }

    public void dsiDestinationImportAsyncException(int n, String string, int n2) {
        LogMessage logMessage = this.getTarget().warn();
        logMessage.append(this._classname).append(".dsiDestinationImportAsyncException(Code=").append(n).append(", Message=").append(string).append(", Type=").append(n2).append(")").log();
        this.getController().errorHandling(n, n2);
    }
}

