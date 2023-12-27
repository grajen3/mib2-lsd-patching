/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.tourimport.states;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.internal.online.tourimport.TourImportFactory;
import de.vw.mib.asl.internal.online.tourimport.common.TourImportPropertyManager;
import de.vw.mib.asl.internal.online.tourimport.states.TourImportTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;

public class TourImportStateActiveIdle
extends AbstractHsmState {
    private final TourImportTarget _target;
    private final String _classname = super.getClass().getName();

    public TourImportStateActiveIdle(TourImportTarget tourImportTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = tourImportTarget;
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".TourImportStateActiveIdle()").log();
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
                TourImportFactory.getImportPropertyManager().setDownloadAllowed(true);
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
            case 100003: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(EV_ONLINE_SERVICES_TOUR_IMPORT_START_DOWNLOAD)").log();
                }
                int n = 0;
                try {
                    n = TourImportFactory.getNaviServices().getTourMemoryCapacity();
                }
                catch (NavigationServiceException navigationServiceException) {
                    this.getTarget().error(navigationServiceException);
                }
                if (n > 0) {
                    this.getPropertyManager().setRequestedTours(n);
                    this.getTarget().getDSITourImport().startTourDownload(n);
                    this.trans(this.getTarget().getDownloadActiveState());
                    break;
                }
                try {
                    TourImportFactory.getNaviServices().importToursFromGpx("");
                }
                catch (NavigationServiceException navigationServiceException) {
                    this.getTarget().error(navigationServiceException);
                }
                break;
            }
            case 100004: {
                this.getTarget().getDSITourImport().dismissTourDownload();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiOnlineTourImportIndicateToursAvailable(int n) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".dsiOnlineTourImportIndicateToursAvailable()").log();
        }
        this.getPropertyManager().setToursAvailable(n);
        try {
            TourImportFactory.getNaviServices().toursAvailable(n);
        }
        catch (NavigationServiceException navigationServiceException) {
            this.getTarget().error(navigationServiceException);
        }
        try {
            this.trans(this.getTarget().getActiveState());
        }
        catch (Exception exception) {
            this.getTarget().error(exception);
        }
    }

    public void dsiOnlineTourImportResponseTourDownload(int n) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".dsiOnlineTourImportResponseTourDownload()").log();
        }
        switch (n) {
            case 1: {
                break;
            }
            case 3: 
            case 4: {
                try {
                    TourImportFactory.getNaviServices().importToursFromGpx("");
                    TourImportFactory.getImportPropertyManager().setRequestedTours(0);
                }
                catch (NavigationServiceException navigationServiceException) {
                    this.getTarget().error(navigationServiceException);
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
    }
}

