/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.tourimport.states;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.internal.online.tourimport.TourImportFactory;
import de.vw.mib.asl.internal.online.tourimport.states.TourImportTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;

public class TourImportStateExportActive
extends AbstractHsmState {
    private final TourImportTarget _target;
    private final String _classname = super.getClass().getName();

    public TourImportStateExportActive(TourImportTarget tourImportTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = tourImportTarget;
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".TourImportStateExportActive()").log();
        }
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(IdEventGeneric.HSM_ENTRY)").log();
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
            case 100001: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(TourImportEvents.EV_ONLINE_SERVICES_TOUR_IMPORT_RESULT_SUMMARY_SUCCESS)").log();
                }
                this.getTarget().getDSITourImport().acknowledgeTourImport(0);
                try {
                    if (this.getTarget().isTraceEnabled()) {
                        this.getTarget().trace().append(this._classname).append(new StringBuffer().append(" Current Available tours = ").append(TourImportFactory.getImportPropertyManager().getToursAvailable()).toString()).append(new StringBuffer().append(" Requested Slots = ").append(TourImportFactory.getImportPropertyManager().getRequestedTours()).toString()).append(new StringBuffer().append(" Remaining Free Slots = ").append(TourImportFactory.getImportPropertyManager().getTourMemoryCapacity()).toString()).log();
                    }
                    int n = TourImportFactory.getImportPropertyManager().getToursAvailable() - (TourImportFactory.getImportPropertyManager().getRequestedTours() - TourImportFactory.getImportPropertyManager().getTourMemoryCapacity());
                    if (this.getTarget().isTraceEnabled()) {
                        this.getTarget().trace().append(this._classname).append(new StringBuffer().append("Tours Still Pending = ").append(n).toString()).log();
                    }
                    TourImportFactory.getNaviServices().toursAvailable(n);
                    TourImportFactory.getImportPropertyManager().setToursAvailable(n > 0 ? n : 0);
                    TourImportFactory.getImportPropertyManager().setRequestedTours(0);
                    if (n > 0) {
                        this.trans(this.getTarget().getActiveState());
                        break;
                    }
                    this.trans(this.getTarget().getActiveIdleState());
                }
                catch (NavigationServiceException navigationServiceException) {
                    this.getTarget().error(navigationServiceException);
                }
                break;
            }
            case 100002: {
                this.getTarget().getDSITourImport().acknowledgeTourImport(1);
                TourImportFactory.getImportPropertyManager().setRequestedTours(0);
                this.trans(this.getTarget().getActiveIdleState());
                break;
            }
            case 100004: {
                this.getTarget().getDSITourImport().acknowledgeTourImport(2);
                TourImportFactory.getImportPropertyManager().setRequestedTours(0);
                this.trans(this.getTarget().getActiveIdleState());
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private TourImportTarget getTarget() {
        return this._target;
    }

    public void dsiOnlineTourImportIndicateToursAvailable(int n) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".dsiOnlineTourImportIndicateToursAvailable()").log();
        }
        TourImportFactory.getImportPropertyManager().setToursAvailable(n);
    }

    public void dsiOnlineTourImportResponseTourDownload(int n) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".dsiOnlineTourImportResponseTourDownload()").log();
        }
        switch (n) {
            case 1: {
                break;
            }
            case 0: {
                break;
            }
            case 2: 
            case 3: 
            case 4: {
                try {
                    TourImportFactory.getNaviServices().importToursFromGpx("");
                    TourImportFactory.getImportPropertyManager().setRequestedTours(0);
                }
                catch (NavigationServiceException navigationServiceException) {
                    this.getTarget().error(navigationServiceException);
                }
                try {
                    this.trans(this.getTarget().getActiveIdleState());
                }
                catch (Exception exception) {
                    this.getTarget().error(exception);
                }
                break;
            }
        }
    }

    public void dsiOnlineTourImportAsyncException(int n, String string, int n2) {
        LogMessage logMessage = this.getTarget().warn();
        logMessage.append(this._classname).append(".dsiUotAAsyncException(Code=").append(n).append(", Message=").append(string).append(", Type=").append(n2).append(")").log();
        try {
            TourImportFactory.getNaviServices().importToursFromGpx("");
            TourImportFactory.getImportPropertyManager().setRequestedTours(0);
        }
        catch (NavigationServiceException navigationServiceException) {
            this.getTarget().error(navigationServiceException);
        }
        try {
            this.trans(this.getTarget().getActiveIdleState());
        }
        catch (Exception exception) {
            this.getTarget().error(exception);
        }
    }
}

