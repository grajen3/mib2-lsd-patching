/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.tourimport.states;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.memory.NavigationMemoryService;
import de.vw.mib.asl.api.online.ASLOnlineCoreServices;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.api.online.ASLOnlineServiceListener;
import de.vw.mib.asl.internal.online.tourimport.TourImportFactory;
import de.vw.mib.asl.internal.online.tourimport.common.TourImportPropertyManager;
import de.vw.mib.asl.internal.online.tourimport.states.TourImportTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;

public class TourImportStateParent
extends AbstractHsmState
implements ASLOnlineServiceListener {
    private final TourImportTarget _target;
    private final String _classname = super.getClass().getName();

    public TourImportStateParent(TourImportTarget tourImportTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = tourImportTarget;
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".TourImportStateParent()").log();
        }
    }

    public TourImportTarget getTarget() {
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
                break;
            }
            case 3: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".handle(IdEventGeneric.HSM_START)").log();
                }
                ASLOnlineCoreServices aSLOnlineCoreServices = ASLOnlineFactory.getOnlineCoreServices();
                String string = aSLOnlineCoreServices.getServiceIDWithNumericServiceID(10);
                aSLOnlineCoreServices.registerForServiceUpdate(string, this);
                if (aSLOnlineCoreServices.isServiceAvailable(string)) {
                    this.trans(this.getTarget().getActiveIdleState());
                    break;
                }
                this.trans(this.getTarget().getNonActiveState());
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

    public void dsiOnlineTourImportIndicateTourDownloadFinished(int n, String string, String string2, int n2) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".dsiOnlineTourImportIndicateTourDownloadFinished()").log();
        }
        this.getPropertyManager().setToursAvailable(n2);
        try {
            this.trans(this.getTarget().getActiveIdleState());
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

    @Override
    public void updateServiceStatusOnChange(int n) {
        if (n == 0) {
            if (!this.getTarget().isStateActive(this.getTarget().getActiveIdleState())) {
                try {
                    int n2 = this.getPropertyManager().getToursAvailable();
                    if (ASLNavigationFactory.getNavigationApi().getNavigationServiceState() == 100) {
                        NavigationMemoryService navigationMemoryService;
                        if (this.getTarget().isTraceEnabled()) {
                            this.getTarget().trace().append(this._classname).append(".Navi service is available").log();
                        }
                        if ((navigationMemoryService = TourImportFactory.getNaviServices()) != null && n2 > 0) {
                            navigationMemoryService.toursAvailable(n2);
                        }
                    }
                    this.trans(this.getTarget().getActiveIdleState());
                    this.getTarget().getHsm().activateTransition();
                }
                catch (Exception exception) {
                    this.getTarget().error(exception);
                }
            }
        } else if (!this.getTarget().isStateActive(this.getTarget().getNonActiveState())) {
            try {
                this.trans(this.getTarget().getNonActiveState());
                this.getTarget().getHsm().activateTransition();
            }
            catch (Exception exception) {
                this.getTarget().error(exception);
            }
        }
    }
}

