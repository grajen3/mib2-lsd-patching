/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance.routeinfo;

import de.vw.mib.asl.api.navigation.IGuidanceInfo;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.GuidanceInformationService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.NavigationGuidanceServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationModalControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.guidance.transformer.SpeechNavigationControllerGuidanceRouteInformationCollector;

public abstract class GuidanceInformationControllerBase
extends ApplicationModalControllerBase {
    private final SpeechNavigationControllerGuidanceRouteInformationCollector routeInfoCollector = new SpeechNavigationControllerGuidanceRouteInformationCollector();
    private final GuidanceInformationService guidanceInfoService = NavigationGuidanceServiceAdapter.getGuidanceInformationService();

    protected GuidanceInformationControllerBase() {
    }

    protected void updateRouteInfo() {
        IGuidanceInfo iGuidanceInfo = this.guidanceInfoService.getGuidanceInfo();
        if (iGuidanceInfo == null) {
            this.onActionFailed();
            return;
        }
        this.routeInfoCollector.speechnavigation_controller_guidance_route_information_dtd = (int)iGuidanceInfo.getDistance();
        this.routeInfoCollector.speechnavigation_controller_guidance_route_information_etad = iGuidanceInfo.getEtaDays();
        this.routeInfoCollector.speechnavigation_controller_guidance_route_information_etah = iGuidanceInfo.getEtaHours();
        this.routeInfoCollector.speechnavigation_controller_guidance_route_information_etam = iGuidanceInfo.getEtaMinutes();
        this.routeInfoCollector.speechnavigation_controller_guidance_route_information_rtt_milliseconds = (int)iGuidanceInfo.getRttMilliseconds();
        this.routeInfoCollector.speechnavigation_controller_guidance_route_information_rtth = 0;
        this.routeInfoCollector.speechnavigation_controller_guidance_route_information_rttm = 0;
        ListManager.getGenericASLList(1527264256).updateList(new SpeechNavigationControllerGuidanceRouteInformationCollector[]{this.routeInfoCollector});
        Framework.updateUIValue(1510487040, this.guidanceInfoService.getSetupOption() == 0 && this.guidanceService.isStopoverDefined());
    }

    @Override
    protected void checkPrerequisites() {
        this.checkNaviServiceAvailable();
        this.checkWayPointModeActive();
        this.checkRouteCalculationModeActive();
    }
}

