/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.api.navigation.splitscreen.ASLNavigationSplitscreenFactory;
import de.vw.mib.asl.api.navigation.splitscreen.SplitscreenConfigManager;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.factoryreset.FactoryResetParticipantWithCallback;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForResetNavigation;
import de.vw.mib.asl.internal.navigation.splitscreen.SplitScreenTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.BapTurnToInfo;
import org.dsi.ifc.navigation.DistanceToNextManeuver;
import org.dsi.ifc.navigation.PosPosition;

public class SplitscreenStateWork
extends AbstractHsmState
implements TargetForResetNavigation {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[SplitscreenStateWork]");
    private SplitScreenTargetHSM target;
    private FactoryResetParticipantWithCallback navigationResetParticipant;

    public SplitscreenStateWork(SplitScreenTargetHSM splitScreenTargetHSM, String string, HsmState hsmState) {
        super(splitScreenTargetHSM.getHsm(), string, hsmState);
        this.target = splitScreenTargetHSM;
    }

    public HsmState dsiNavigationUpdateBapTurnToInfo(BapTurnToInfo[] bapTurnToInfoArray, int n) {
        this.logger.trace("dsiNavigationUpdateBapTurnToInfo()");
        if (bapTurnToInfoArray == null || bapTurnToInfoArray.length == 0) {
            return null;
        }
        this.target.notifierModel.updateCollectorSymbol(bapTurnToInfoArray);
        return null;
    }

    public HsmState dsiNavigationUpdateDistanceToNextManeuver(DistanceToNextManeuver distanceToNextManeuver, int n) {
        this.logger.trace("dsiNavigationUpdateDistanceToNextManeuver()");
        this.target.notifierModel.updateCollectorSymbol(distanceToNextManeuver);
        return null;
    }

    public HsmState dsiNavigationUpdateSoPosPosition(PosPosition posPosition, int n) {
        this.logger.trace("dsiNavigationUpdateSoPosPosition()");
        int n2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateHeadingValue(posPosition.directionAngle, 11.25);
        this.target.notifierModel.updateCollectorCompassDataRotation(n2);
        this.target.getInternalAPINotifier().sendEvSplitScreenCompassDirectionUpdate(n2);
        this.target.notifierModel.updateCollectorGPSViewer(posPosition);
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPositionDescription();
        navLocation.latitude = posPosition.getLatitude();
        navLocation.longitude = posPosition.getLongitude();
        this.target.notifierModel.updateCollectorLocation(navLocation);
        this.sendEventAltitudeChanged(posPosition);
        this.target.getInternalAPINotifier().sendEvSplitScreenPositionUpdate(posPosition);
        return null;
    }

    public void dsiNavigationUpdateSoPosPositionDescription(NavLocation navLocation, boolean bl, int n) {
        this.logger.trace("dsiNavigationUpdateSoPosPositionDescription()");
        this.updateLocation(navLocation);
        this.target.getInternalAPINotifier().sendEvSplitScreenLocationUpdate(navLocation);
    }

    private void updateLocation(NavLocation navLocation) {
        this.target.notifierModel.updateCollectorLocation(navLocation);
        this.target.notifierModel.updateCollectorStreetData(navLocation);
    }

    private void sendEventAltitudeChanged(PosPosition posPosition) {
        this.logger.trace("sendEventAltitudeChanged()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1474376448);
        eventGeneric.setInt(0, posPosition.height);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 1073742393: {
                this.handleSetCurrentContentG(eventGeneric);
                break;
            }
            case 1073742394: {
                this.handleSetCurrentContentNG(eventGeneric);
                break;
            }
            case 1073742395: {
                this.handleToggleSplitScreenG();
                break;
            }
            case 1073742396: {
                this.handleToggleSplitScreenNG();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.target.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(): receiverEventId: ").append(eventGeneric.getReceiverEventId()).append(", Params: ").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
        if (this.navigationResetParticipant == null) {
            this.navigationResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForNavigationDomainAndAddToService(this);
        }
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        if (this.navigationResetParticipant != null) {
            ASLNavigationUtilFactory.getNavigationUtilApi().removeNavigationResetParticipantFromService(this.navigationResetParticipant);
            this.navigationResetParticipant = null;
        }
    }

    private void handleSetCurrentContentG(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleSetCurrentContentG(content=").append(n).append(")").log();
        }
        this.target.datapool.setSplitScreenContentGuidance(n);
        this.target.notifierModel.notifySplitScreenContentChanged(n);
        this.notifyManeuverViewVisible();
    }

    private void handleSetCurrentContentNG(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleSetCurrentContentNG(content=").append(n).append(")").log();
        }
        this.target.datapool.setSplitScreenContentNoGuidance(n);
        this.target.notifierModel.notifySplitscreenNoGuidanceContentChanged(n);
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.notifyManeuverViewVisible();
    }

    private void handleToggleSplitScreenG() {
        this.logger.trace("handleToggleSplitScreenG()");
        boolean bl = !this.target.datapool.isSplitScreenGuidance();
        this.target.datapool.setSplitScreenGuidance(bl);
        this.target.notifierModel.notifySplitScreenGuidanceChanged(bl);
        this.notifyManeuverViewVisible();
    }

    private void handleToggleSplitScreenNG() {
        boolean bl;
        this.logger.trace("handleToggleSplitScreenNG()");
        boolean bl2 = bl = !this.target.datapool.isSplitScreenNoGuidance();
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("splitScreenNG=").append(bl).log();
        }
        this.target.datapool.setSplitScreenNoGuidance(bl);
        this.target.notifierModel.notifySplitscreenNoGuidanceChanged(bl);
    }

    private void notifyManeuverViewVisible() {
        if (this.target.datapool.isSplitScreenGuidance() && this.target.datapool.getSplitScreenContentGuidance() == 5) {
            ASLNavigationSplitscreenFactory.getNavigationSplitscreenApi().sendEvSplitScreenManeuverviewActive(true);
        } else {
            ASLNavigationSplitscreenFactory.getNavigationSplitscreenApi().sendEvSplitScreenManeuverviewActive(false);
        }
    }

    @Override
    public void handleNavigationSettingsReset() {
        this.logger.trace("handleNavigationSettingsReset()");
        this.target.datapool.setSplitScreenGuidance(SplitscreenConfigManager.HMI_SPLIT_SCREEN_GUIDANCE_ENABLED);
        this.target.datapool.setSplitScreenNoGuidance(SplitscreenConfigManager.HMI_SPLIT_SCREEN_NO_GUIDANCE_ENABLED);
        this.target.datapool.setSplitScreenContentGuidance(SplitscreenConfigManager.HMI_SPLIT_SCREEN_GUIDANCE_CONTENT);
        this.target.datapool.setSplitScreenContentNoGuidance(SplitscreenConfigManager.HMI_SPLIT_SCREEN_NO_GUIDANCE_CONTENT);
        this.target.notifyModel();
        this.notifyManeuverViewVisible();
        this.navigationResetParticipant.notifyResetDone();
    }
}

