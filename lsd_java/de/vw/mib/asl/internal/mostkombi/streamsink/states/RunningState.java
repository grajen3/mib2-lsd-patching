/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.streamsink.states;

import de.vw.mib.asl.internal.mostkombi.common.api.adaption.asl.AdaptationService;
import de.vw.mib.asl.internal.mostkombi.common.sequence.Sequence;
import de.vw.mib.asl.internal.mostkombi.common.sequence.SequenceDelegate;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoDelegate;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoService;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapDelegate;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapService;
import de.vw.mib.asl.internal.mostkombi.streamsink.states.StreamSinkHsmContext;
import de.vw.mib.asl.internal.mostkombi.streamsink.states.StreamSinkState;
import de.vw.mib.genericevents.hsm.HsmState;

public class RunningState
extends StreamSinkState
implements NavigationMapDelegate,
NavInfoDelegate,
SequenceDelegate {
    private static final int[] NAVIGATION_MAP_SERVICES = NavigationMapDelegate.NAVIGATION_MAP_KOMBI_MAP_PROPERTIES;
    private static final int[] NAV_INFO_SERVICES = new int[]{39};
    private AdaptationService adaptationService;
    private NavigationMapService navigationMapService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$streamsink$states$RunningState;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService;

    public RunningState(StreamSinkHsmContext streamSinkHsmContext, HsmState hsmState) {
        super(streamSinkHsmContext, (class$de$vw$mib$asl$internal$mostkombi$streamsink$states$RunningState == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$states$RunningState = RunningState.class$("de.vw.mib.asl.internal.mostkombi.streamsink.states.RunningState")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$states$RunningState).getName(), hsmState);
    }

    private AdaptationService getAdaptationService() {
        if (this.adaptationService == null) {
            this.adaptationService = (AdaptationService)this.getContextDelegate().getServiceProvider().getService(this, class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService == null ? (class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService = RunningState.class$("de.vw.mib.asl.internal.mostkombi.common.api.adaption.asl.AdaptationService")) : class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService);
        }
        return this.adaptationService;
    }

    private NavigationMapService getNavigationMapService() {
        if (this.navigationMapService == null) {
            this.navigationMapService = (NavigationMapService)this.getContextDelegate().getServiceProvider().getService(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService = RunningState.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService);
        }
        return this.navigationMapService;
    }

    private NavInfoService getNavInfoService() {
        return (NavInfoService)this.getContextDelegate().getServiceProvider().getService(this, class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService == null ? (class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService = RunningState.class$("de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoService")) : class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService);
    }

    @Override
    protected void stateEntry() {
    }

    @Override
    protected void stateStart() {
        this.getContextDelegate().getServiceProvider().registerServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService = RunningState.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService, NAVIGATION_MAP_SERVICES);
        this.getContextDelegate().getServiceProvider().registerServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService == null ? (class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService = RunningState.class$("de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoService")) : class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService, NAV_INFO_SERVICES);
        this.getNavigationMapService().setMapSwitchPossible(true);
        if (!this.getAdaptationService().isNavigationMapSwitchSupported()) {
            this.getContextDelegate().getController().getSequence(1455166976).executeSequence();
        } else if (this.getAdaptationService().isNavigationMapSwitchSupported() && this.getNavigationMapService().getMapSwitchState() == 5 || this.getAdaptationService().isNavigationMapSwitchSupported() && this.getNavInfoService().getRouteGuidanceMode() == 3) {
            this.startSwitchingMapToKombiSequence();
        } else {
            this.getContextDelegate().getController().getSequence(1421612544).executeSequence();
        }
    }

    @Override
    protected void stateExit() {
        this.getNavigationMapService().setMapSwitchPossible(false);
        this.getContextDelegate().getServiceProvider().removeServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService = RunningState.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService, NAVIGATION_MAP_SERVICES);
        this.getContextDelegate().getServiceProvider().removeServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService == null ? (class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService = RunningState.class$("de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoService")) : class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService, NAV_INFO_SERVICES);
        this.getContextDelegate().uninitialize();
        if (this.getAdaptationService().isNavigationMapSwitchSupported()) {
            switch (this.getNavigationMapService().getMapSwitchState()) {
                case 3: 
                case 4: {
                    this.getNavigationMapService().setMapSwitchState(1);
                    break;
                }
                case 5: {
                    this.getNavigationMapService().setMapSwitchState(2);
                    break;
                }
            }
        }
    }

    @Override
    public void dsiKOMOGfxStreamSinkUpdateGfxState(int n, int n2) {
        super.dsiKOMOGfxStreamSinkUpdateGfxState(n, n2);
        if (n == 0) {
            this.getContextDelegate().getLogger().info(this.getContextDelegate().getSubClassifier(), "StreamSink becomes unavailable");
            Sequence sequence = this.getContextDelegate().getController().getSequence(1505498624);
            sequence.appendToSequence(this);
            sequence.executeSequence();
        }
    }

    @Override
    public void updateNavigationMap(NavigationMapService navigationMapService, int n) {
        switch (n) {
            case 1110044: {
                if (navigationMapService.getKombiMapStatus() == 2 || this.getAdaptationService().isNavigationMapSwitchSupported()) break;
                this.getContextDelegate().getLogger().info(this.getContextDelegate().getSubClassifier(), "Kombi map becomes unavailable");
                this.goToState(this.getHsmContext().getWaitForServicesState());
                break;
            }
            case -2147482644: {
                this.startSwitchingMapToABTSequence();
                break;
            }
            case -2147482643: {
                this.startSwitchingMapToKombiSequence();
                break;
            }
            case -2147482642: {
                if (navigationMapService.getNavigationMapServiceState() != 0 || !this.getAdaptationService().isNavigationMapSwitchSupported()) break;
                this.getContextDelegate().getLogger().info(this.getContextDelegate().getSubClassifier(), "Navigation map service becomes unavailable");
                this.goToState(this.getHsmContext().getWaitForServicesState());
                break;
            }
            case -2147482647: {
                if (navigationMapService.isNavigationServiceStateFullyOperable() || !this.getAdaptationService().isNavigationMapSwitchSupported()) break;
                this.getContextDelegate().getLogger().info(this.getContextDelegate().getSubClassifier(), "Navigation becomes unavailable");
                this.goToState(this.getHsmContext().getWaitForServicesState());
                break;
            }
        }
    }

    @Override
    public Sequence getSequence(Sequence sequence, int n) {
        return null;
    }

    @Override
    public void sequenceDone(Sequence sequence) {
        this.goToState(this.getHsmContext().getWaitForServicesState());
    }

    @Override
    public int sequenceStepFailed(Sequence sequence, int n, String string) {
        return 0;
    }

    private void startSwitchingMapToKombiSequence() {
        if (this.getAdaptationService().isNavigationMapSwitchSupported()) {
            Sequence sequence = this.getContextDelegate().getController().getSequence(1522275840);
            sequence.executeSequence();
        }
    }

    private void startSwitchingMapToABTSequence() {
        if (this.getAdaptationService().isNavigationMapSwitchSupported()) {
            Sequence sequence = this.getContextDelegate().getController().getSequence(1555830272);
            sequence.executeSequence();
        }
    }

    @Override
    public void updateNavInfo(NavInfoService navInfoService, int n, Object object) {
        if (n == 39 && navInfoService.getRouteGuidanceMode() == 3) {
            if (this.getNavigationMapService().getMapSwitchState() == 1) {
                this.startSwitchingMapToKombiSequence();
            }
        } else if (n == 39 && navInfoService.getRouteGuidanceMode() != 3 && this.getNavigationMapService().getMapSwitchState() == 2) {
            this.startSwitchingMapToABTSequence();
        }
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

