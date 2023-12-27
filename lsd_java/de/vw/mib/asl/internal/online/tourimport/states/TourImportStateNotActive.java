/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.tourimport.states;

import de.vw.mib.asl.internal.online.tourimport.TourImportFactory;
import de.vw.mib.asl.internal.online.tourimport.common.TourImportPropertyManager;
import de.vw.mib.asl.internal.online.tourimport.states.TourImportTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class TourImportStateNotActive
extends AbstractHsmState {
    private final TourImportTarget _target;
    private final String _classname = super.getClass().getName();

    public TourImportStateNotActive(TourImportTarget tourImportTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = tourImportTarget;
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".TourImportStateNotActive()").log();
        }
    }

    private TourImportTarget getTarget() {
        return this._target;
    }

    TourImportPropertyManager getPropertyManager() {
        return TourImportFactory.getImportPropertyManager();
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(IdEventGeneric.HSM_ENTRY)").log();
                }
                TourImportFactory.getImportPropertyManager().setDownloadAllowed(false);
                break;
            }
            case 3: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(IdEventGeneric.HSM_START)").log();
                break;
            }
            case 4: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(IdEventGeneric.HSM_EXIT)").log();
                break;
            }
            case 100005: {
                this.trans(this.getTarget().getActiveIdleState());
                break;
            }
            case 100003: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(EV_ONLINE_SERVICES_TOUR_IMPORT_START_DOWNLOAD)").log();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiOnlineTourImportIndicateTourDownloadFinished(int n, String string, String string2, int n2) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().warn().append(this._classname).append(".dsiOnlineTourImportIndicateTourDownloadFinished()").log();
        }
    }

    public void dsiOnlineTourImportIndicateToursAvailable(int n) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".dsiOnlineTourImportIndicateToursAvailable()").log();
        }
        this.getPropertyManager().setToursAvailable(n);
    }

    public void dsiOnlineTourImportResponseTourDownload(int n) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".dsiOnlineTourImportResponseTourDownload()").log();
        }
    }
}

