/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.streamsink.states;

import de.vw.mib.asl.internal.mostkombi.common.api.adaption.asl.AdaptationService;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementDelegate;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapDelegate;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapService;
import de.vw.mib.asl.internal.mostkombi.streamsink.states.StreamSinkHsmContext;
import de.vw.mib.asl.internal.mostkombi.streamsink.states.StreamSinkState;
import de.vw.mib.genericevents.hsm.HsmState;

public class WaitForServices
extends StreamSinkState
implements DisplayManagementDelegate,
NavigationMapDelegate {
    private boolean _delegateInitialized;
    private DisplayManagementService _displayManagementService;
    private NavigationMapService _navigationMapService;
    private AdaptationService _adaptationService;
    private static final int[] DISPLAY_MANAGEMENT_SERVICES = new int[]{976363520};
    private static final int[] NAVIGATION_MAP_SERVICES = new int[]{485494784, -385679232};
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$streamsink$states$WaitForServices;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService;

    public WaitForServices(StreamSinkHsmContext streamSinkHsmContext, HsmState hsmState) {
        super(streamSinkHsmContext, (class$de$vw$mib$asl$internal$mostkombi$streamsink$states$WaitForServices == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$states$WaitForServices = WaitForServices.class$("de.vw.mib.asl.internal.mostkombi.streamsink.states.WaitForServices")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$states$WaitForServices).getName(), hsmState);
    }

    private boolean isDelegateInitialized() {
        return this._delegateInitialized;
    }

    private void setDelegateInitialized(boolean bl) {
        this._delegateInitialized = bl;
    }

    private DisplayManagementService getDisplayManagementService() {
        if (this._displayManagementService == null) {
            this._displayManagementService = (DisplayManagementService)this.getContextDelegate().getServiceProvider().getService(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService = WaitForServices.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService);
        }
        return this._displayManagementService;
    }

    private NavigationMapService getNavigationMapService() {
        if (this._navigationMapService == null) {
            this._navigationMapService = (NavigationMapService)this.getContextDelegate().getServiceProvider().getService(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService = WaitForServices.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService);
        }
        return this._navigationMapService;
    }

    private AdaptationService getAdaptationService() {
        if (this._adaptationService == null) {
            this._adaptationService = (AdaptationService)this.getContextDelegate().getServiceProvider().getService(this, class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService == null ? (class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService = WaitForServices.class$("de.vw.mib.asl.internal.mostkombi.common.api.adaption.asl.AdaptationService")) : class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService);
        }
        return this._adaptationService;
    }

    private void _checkServiceStates() {
        boolean bl = this.getHsmContext().getGfxState() == 1;
        bl &= this.getDisplayManagementService().getKombiDisplay() != -2;
        bl &= this.getAdaptationService().getMostCapabilityForMap() == 2;
        if (bl &= this.getNavigationMapService().getKombiMapStatus() == 2 || this.getAdaptationService().isNavigationMapSwitchSupported() && this.getNavigationMapService().isNavigationServiceStateFullyOperable() && this.getNavigationMapService().getNavigationMapServiceState() == 10) {
            if (!this.isDelegateInitialized()) {
                this.getContextDelegate().initialize();
                this.setDelegateInitialized(true);
            }
            this.goToState(this.getHsmContext().getRunningState());
        } else if (this.getHsmContext().getGfxState() == 0 && this.getAdaptationService().isNavigationMapSwitchSupported() && this.getNavigationMapService().getMapSwitchState() == 5) {
            this.getNavigationMapService().failedToPerformMapSwitch();
        }
    }

    @Override
    protected void stateEntry() {
        this.getContextDelegate().getServiceProvider().registerServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService = WaitForServices.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService, DISPLAY_MANAGEMENT_SERVICES);
        this.getContextDelegate().getServiceProvider().registerServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService = WaitForServices.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService, NAVIGATION_MAP_SERVICES);
        this.setDelegateInitialized(false);
    }

    @Override
    protected void stateStart() {
        this._checkServiceStates();
    }

    @Override
    protected void stateExit() {
        this.getContextDelegate().getServiceProvider().removeServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService = WaitForServices.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService, DISPLAY_MANAGEMENT_SERVICES);
        this.getContextDelegate().getServiceProvider().removeServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService = WaitForServices.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService, NAVIGATION_MAP_SERVICES);
    }

    @Override
    public void updateDisplayManagement(DisplayManagementService displayManagementService, int n) {
        this._checkServiceStates();
    }

    @Override
    public void updateNavigationMap(NavigationMapService navigationMapService, int n) {
        this._checkServiceStates();
    }

    @Override
    public void dsiKOMOGfxStreamSinkUpdateGfxState(int n, int n2) {
        super.dsiKOMOGfxStreamSinkUpdateGfxState(n, n2);
        this._checkServiceStates();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

