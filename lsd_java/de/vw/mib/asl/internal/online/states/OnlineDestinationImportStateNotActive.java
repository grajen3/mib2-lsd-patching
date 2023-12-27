/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.states;

import de.vw.mib.asl.internal.online.OnlineDestinationImportController;
import de.vw.mib.asl.internal.online.OnlineDestinationImportManager;
import de.vw.mib.asl.internal.online.states.OnlineDestinationImportTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class OnlineDestinationImportStateNotActive
extends AbstractHsmState {
    private final OnlineDestinationImportTarget _target;
    private final String _classname = super.getClass().getName();

    public OnlineDestinationImportStateNotActive(OnlineDestinationImportTarget onlineDestinationImportTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = onlineDestinationImportTarget;
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".OnlineDestinationImportStateNotActive()").log();
        }
    }

    private OnlineDestinationImportTarget getTarget() {
        return this._target;
    }

    private OnlineDestinationImportController getController() {
        return OnlineDestinationImportManager.getOnlineDestinationImportController();
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
                this.trans(this.getTarget().getActiveState());
                break;
            }
            case 4: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(IdEventGeneric.HSM_EXIT)").log();
                break;
            }
            case 1075041832: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(ASLOnlineServiceConstants.START_DOWNLOAD_DESTINATION)").log();
                break;
            }
            case 100001: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(OnlineDestinationImportEvents.EV_ONLINE_SERVICES_DESTINATION_IMPORT_RESULT_SUMMARY)").log();
                }
                if (OnlineDestinationImportManager.getNaviServices() != null) {
                    int n;
                    int n2 = this.getController().getEntriesSucceeded();
                    int n3 = this.getController().getEntriesFailed();
                    int n4 = n = (this.getController().getContactCapacity() == 0 || this.getController().isContactCapacityFull()) && this.getController().getNumberEntriesRemaining() == 0 ? 1 : this.getController().getNumberEntriesRemaining();
                    if (this.getTarget().isTraceEnabled()) {
                        this.getTarget().trace().append(this._classname).append(new StringBuffer().append("-> success = ").append(n2).append(" failed = ").append(n3).append(" remaining = ").append(n).toString()).log();
                    }
                    OnlineDestinationImportManager.getNaviServices().importContactSummary(n2, n3, n, this.getController().getimportContactResult());
                    this.getController().reset();
                    break;
                }
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append("Navi Services interface not yet started").log();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

