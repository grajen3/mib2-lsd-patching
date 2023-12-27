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
import de.vw.mib.util.Util;

public class TourImportStateDownloadActive
extends AbstractHsmState {
    private final TourImportTarget _target;
    private final String _classname = super.getClass().getName();

    public TourImportStateDownloadActive(TourImportTarget tourImportTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = tourImportTarget;
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".TourImportStateDownloadActive()").log();
        }
    }

    private TourImportTarget getTarget() {
        return this._target;
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
            case 100004: {
                this.getTarget().getDSITourImport().dismissTourDownload();
                break;
            }
            case 4: {
                if (!this.getTarget().isTraceEnabled()) break;
                this.getTarget().trace().append(this._classname).append(".handle(IdEventGeneric.HSM_EXIT)").log();
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
    }

    public void dsiOnlineTourImportIndicateTourDownloadFinished(int n, String string, String string2, int n2) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".dsiOnlineTourImportIndicateTourDownloadFinished()").log();
        }
        TourImportFactory.getImportPropertyManager().setToursAvailable(n2);
        switch (n) {
            case 1: {
                break;
            }
            case 0: {
                try {
                    String string3 = "";
                    if (!Util.isNullOrEmpty(string2) && !Util.isNullOrEmpty(string)) {
                        string3 = new StringBuffer().append(string2).append(string).toString();
                    }
                    if (!Util.isNullOrEmpty(string3)) {
                        TourImportFactory.getNaviServices().importToursFromGpx(string3);
                        this.trans(this.getTarget().getExportActiveState());
                        break;
                    }
                    TourImportFactory.getNaviServices().importToursFromGpx("");
                    TourImportFactory.getImportPropertyManager().setRequestedTours(0);
                    this.trans(this.getTarget().getActiveIdleState());
                }
                catch (NavigationServiceException navigationServiceException) {
                    this.getTarget().error(navigationServiceException);
                }
                catch (Exception exception) {
                    this.getTarget().error(exception);
                }
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

