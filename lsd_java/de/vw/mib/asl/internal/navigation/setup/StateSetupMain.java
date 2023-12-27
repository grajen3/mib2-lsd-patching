/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.setup;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.factoryreset.FactoryResetParticipantWithCallback;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForFullFactoryReset;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForResetNavigation;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.setup.HsmTargetSetup;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.navigation.NavDataBase;

public class StateSetupMain
extends AbstractHsmState
implements TargetForFullFactoryReset,
TargetForResetNavigation {
    private final HsmTargetSetup myTarget;
    private FactoryResetParticipantWithCallback fullFactoryResetParticipant;
    private FactoryResetParticipantWithCallback navigationResetParticipant;

    StateSetupMain(HsmTargetSetup hsmTargetSetup, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = hsmTargetSetup;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        this.myTarget.traceState(this, new StringBuffer().append("handle(...): StateSetupMain: ").append(eventGeneric.getReceiverEventId()).toString());
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.myTarget.traceState(this, "HSM_ENTRY");
                if (this.fullFactoryResetParticipant == null) {
                    this.fullFactoryResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForFullFactoryResetAndAddToService(this);
                }
                if (this.navigationResetParticipant != null) break;
                this.navigationResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForNavigationDomainAndAddToService(this);
                break;
            }
            case 3: {
                this.myTarget.traceState(this, "HSM_START");
                break;
            }
            case 4: {
                this.myTarget.traceState(this, "HSM_EXIT");
                if (this.fullFactoryResetParticipant != null) {
                    ASLNavigationUtilFactory.getNavigationUtilApi().removeFullFactoryResetParticipantFromService(this.fullFactoryResetParticipant);
                    this.fullFactoryResetParticipant = null;
                }
                if (this.navigationResetParticipant == null) break;
                ASLNavigationUtilFactory.getNavigationUtilApi().removeNavigationResetParticipantFromService(this.navigationResetParticipant);
                this.navigationResetParticipant = null;
                break;
            }
            case 1074841922: {
                this.myTarget.traceState(this, "DELETE_MEMORY_WAYPOINT_MEM");
                this.myTarget.deleteMemoryWaypointMemory();
                break;
            }
            case 1073742543: {
                this.myTarget.traceState(this, "DELETE_MEMORY_BLOCKINGS");
                this.myTarget.deleteMemoryBlocking();
                break;
            }
            case 1073742544: {
                this.myTarget.traceState(this, "DELETE_MEMORY_CITIES");
                this.myTarget.deleteMemoryLastCitiesAndStreets();
                try {
                    this.myTarget.deleteShieldHistory();
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
                break;
            }
            case 1073742547: {
                this.myTarget.traceState(this, "DELETE_MEMORY_HOME");
                try {
                    this.myTarget.deleteShieldHistory();
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
                try {
                    this.myTarget.deleteMemoryHomeLocation();
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
                break;
            }
            case 1073742548: {
                this.myTarget.traceState(this, "DELETE_MEMORY_LAST_DEST");
                this.myTarget.deleteMemoryLastDestinations();
                break;
            }
            case 1073742545: {
                this.myTarget.traceState(this, "DELETE_MEMORY_DEST_MEM");
                this.deleteMemoryDestinationMemory();
                break;
            }
            case 1073742546: {
                this.myTarget.traceState(this, "DELETE_MEMORY_FLAG_DEST");
                this.myTarget.deleteMemoryFlagDestination();
                break;
            }
            case 1073742549: {
                this.myTarget.traceState(this, "DELETE_MEMORY_TOUR_MEM");
                this.myTarget.deleteMemoryTour();
                break;
            }
            case 1074841921: {
                this.myTarget.traceState(this, "DELETE_MEMORY_ONLINE_DEST");
                this.deleteMemoryOnlineDestinations();
                break;
            }
            case 1073742528: {
                this.myTarget.traceState(this, "DELETE_PERSONAL_POI_DATABASE");
                this.deletePersonalPoiDatabase();
                break;
            }
            case 1073742555: {
                this.myTarget.traceState(this, "GUIDANCE_DEMO_MODE_TOGGLE");
                this.toggleDemoMode();
                break;
            }
            case 1073742562: {
                this.myTarget.traceState(this, "TIME_DISPLAY_SET");
                this.setTimeDisplay(eventGeneric.getInt(0));
                break;
            }
            case 1073742564: {
                this.myTarget.traceState(this, "TOGGLE_BORDER_CROSSING_HINT");
                this.toggleBorderCrossingHint();
                break;
            }
            case 1073742567: {
                this.myTarget.traceState(this, "TOGGLE_STATUS_LINE_INFORMATION");
                this.toggleStatusLineInfo();
                break;
            }
            case 1073742569: {
                this.myTarget.traceState(this, "TRAFFIC_SIGN_ANNOUNCEMENT_TYPE_SET");
                this.setTrafficSignMode(eventGeneric.getInt(0));
                break;
            }
            case 1073742610: {
                this.myTarget.traceState(this, "TOGGLE_ACOUSTIC_TRAFFIC_JAM_WARNING");
                this.toggleAcousticTrafficJamWarning();
                break;
            }
            case 1073742541: {
                this.myTarget.traceState(this, "AUDIO_VOICE_ANNOUNCEMENTS_TYPE_SET");
                this.myTarget.setAudioVoiceAnnnouncementType(eventGeneric.getInt(0), true);
                break;
            }
            case 1073742274: {
                this.myTarget.traceState(this, "SET_VOICE_GUIDANCE_STATUS");
                this.setBapVoiceGuidanceStatus(eventGeneric.getInt(0));
                break;
            }
            case 1073742570: {
                this.myTarget.traceState(this, "VOICE_ANNOUNCEMENTS_SET");
                this.setVoiceAnnouncementDuringPhone(eventGeneric.getInt(0), true);
                break;
            }
            case 1073742563: {
                this.myTarget.traceState(this, "TOGGLE_APPROACH_SPECIAL_PLACES_HINT");
                this.toggleApproachPPOIHint();
                break;
            }
            case 1073743106: {
                this.myTarget.traceState(this, "TOGGLE_NAV_VOLUME_DURING_PHONE_CALL");
                this.handleVoiceAnnouncementDuringPhoneByAudio();
                break;
            }
            case 1073742557: {
                this.myTarget.traceState(this, "NAME_REPRESENTATION_SET");
                this.handleContactsNameRepresentationSet(eventGeneric);
                break;
            }
            case 1073744070: {
                this.myTarget.traceState(this, "SET_GEO_COORDINATES_DIRECTION_STRINGS");
                this.handleGeoCoordinateDirectionStringSet(eventGeneric);
                break;
            }
            case 1074841888: {
                this.myTarget.traceState(this, "TOGGLE_SPEED_CAMERA_WARNING");
                this.toggleSpeedCameraWarning();
                break;
            }
            case 4300004: {
                if (eventGeneric.getBoolean(0)) break;
                this.myTarget.traceState(this, "ASL_SYSTEM_SET_CLAMP15_OFF");
                if (!this.myTarget.GUIDANCE_OPTIONS.isDemoMode()) break;
                this.setDemoMode(false);
                break;
            }
            case 4300048: {
                this.myTarget.traceState(this, "ASL_SYSTEM_DISTANCEUNIT_CHANGED");
                int n = eventGeneric.getInt(0);
                this.myTarget.setDsiDistanceUnit(n);
                break;
            }
            default: {
                hsmState = this.myTarget.getWorkStateParent();
            }
        }
        return hsmState;
    }

    private void handleGeoCoordinateDirectionStringSet(EventGeneric eventGeneric) {
        String string = eventGeneric.getString(0);
        String string2 = eventGeneric.getString(1);
        String string3 = eventGeneric.getString(2);
        String string4 = eventGeneric.getString(3);
        if (this.myTarget.isTraceEnabled()) {
            LogMessage logMessage = this.myTarget.trace();
            logMessage.append("ASL_NAVIGATION_SET_GEO_COORDINATES_DIRECTION_STRINGS came with N:").append(string).append(" E:").append(string2).append(" S:").append(string3).append(" W:").append(string4).log();
        }
    }

    private void handleContactsNameRepresentationSet(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = this.convertContactsNameRepresentationFromSetterToGetter(n);
        this.setContactsNameRepresentation(n2);
    }

    private void setContactsNameRepresentation(int n) {
        if (n == 0) {
            this.myTarget.dsiAdbSetupService.setSortOrder(3);
        } else if (n == 1) {
            this.myTarget.dsiAdbSetupService.setSortOrder(2);
        } else {
            this.myTarget.trace("Navi-Setup: Set contacts sort order to somethink wrong");
        }
    }

    private int convertContactsNameRepresentationFromSetterToGetter(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        this.myTarget.error("Navi-Setup#convertContactsNameRepresentationFromSetterToGetter Set contacts sort order to somethink wrong");
        return 0;
    }

    private void deleteMemoryDestinationMemory() {
        this.myTarget.dsiAdbEditService.deleteEntries(new long[]{-1L}, 6, 1);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvAddressBookEntryChanged(this.myTarget, null);
    }

    private void deleteMemoryOnlineDestinations() {
        this.myTarget.dsiAdbEditService.deleteEntries(new long[]{-1L}, 18, 1);
    }

    public void dsiAdbEditDeleteEntriesResult(int n) {
        if (n == 0) {
            ServiceManager.aslPropertyManager.valueChangedInteger(2762, 0);
            ASLNavigationMapFactory.getNavigationMapApi().sendEvAddressBookEntryChanged(this.myTarget, null);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(2762, 1);
        }
    }

    private void deletePersonalPoiDatabase() {
        if (this.myTarget.currentlyInstalledPPois == null || this.myTarget.currentlyInstalledPPois.length <= 0) {
            this.myTarget.trace("Somebody tried to delete a PPOI, but no PPOI was installed.");
        } else {
            for (int i2 = 0; i2 < this.myTarget.currentlyInstalledPPois.length; ++i2) {
                NavDataBase navDataBase = this.myTarget.currentlyInstalledPPois[i2];
                String string = navDataBase.path;
                if (string != null) {
                    this.myTarget.dsiNavigationService.deletePersonalPOIDataBases(new String[]{string});
                    continue;
                }
                this.myTarget.trace("There was PPOI installed, with path == emtpyString");
            }
        }
    }

    private void toggleDemoMode() {
        this.myTarget.traceState(this, "toggleDemoMode()");
        boolean bl = !this.myTarget.GUIDANCE_OPTIONS.isDemoMode();
        this.setDemoMode(bl);
    }

    private void setDemoMode(boolean bl) {
        INavGateway iNavGateway;
        this.myTarget.traceState(this, "setDemoMode()");
        this.myTarget.GUIDANCE_OPTIONS.setDemoMode(bl);
        ServiceManager.aslPropertyManager.valueChangedBoolean(978, bl);
        ServiceManager.aslPropertyManager.valueChangedBoolean(3937, bl);
        if (!bl && (iNavGateway = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway()).isRgActive() && iNavGateway.getEtcDemoModeState()) {
            this.myTarget.sendInternalEvent(1917522944, 0x24020040);
        }
    }

    private void toggleApproachPPOIHint() {
        this.myTarget.traceState(this, "PPOIAW: StateSetupMain:  toggleApproachPPOIHint");
        boolean bl = !this.myTarget.GUIDANCE_OPTIONS.isAudibleApproachPPOIHint();
        this.myTarget.setApproachPPOIHint(bl);
    }

    private void toggleSpeedCameraWarning() {
        this.myTarget.traceState(this, "SCW: StateSetupMain:  toggleSpeedCameraWarning");
        boolean bl = !this.myTarget.GUIDANCE_OPTIONS.isSpeedCameraWarning();
        this.myTarget.setSpeedCameraWarning(bl);
    }

    private void toggleBorderCrossingHint() {
        boolean bl = !this.myTarget.GUIDANCE_OPTIONS.isBorderHint();
        this.setBorderCrossingHint(bl);
    }

    private void toggleStatusLineInfo() {
        boolean bl = !this.myTarget.GUIDANCE_OPTIONS.isStatusLineInfo();
        this.setStatusLineInfo(bl);
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().sendEvNaviMapMainGuidanceSetupStatusLineInformation(bl);
    }

    private void setBapVoiceGuidanceStatus(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 2;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            default: {
                n2 = 2;
            }
        }
        this.myTarget.setAudioVoiceAnnnouncementType(n2, true);
    }

    private void handleVoiceAnnouncementDuringPhoneByAudio() {
        this.myTarget.GUIDANCE_OPTIONS.toggleAudioDuringPhone();
        int n = this.myTarget.GUIDANCE_OPTIONS.getDpVoiceAnnouncements();
        boolean bl = this.myTarget.GUIDANCE_OPTIONS.getDpVoiceAnnouncementsBoolean();
        ServiceManager.aslPropertyManager.valueChangedInteger(977, n);
        ServiceManager.aslPropertyManager.valueChangedBoolean(1510, bl);
    }

    private void toggleAcousticTrafficJamWarning() {
        boolean bl = !this.myTarget.GUIDANCE_OPTIONS.isAcousticTrafficJamWarning();
        this.setAcousticTrafficJamWarning(bl);
    }

    private void resetAllSettings() {
        this.myTarget.trace("RESETING all navi setup settings back to factory defaults.");
        int n = ServiceManager.configManagerDiag.getNaviCommonOptionDefault(2);
        this.setTimeDisplay(n);
        this.setDemoMode(false);
        this.setBorderCrossingHint(true);
        this.setStatusLineInfo(false);
        this.setAcousticTrafficJamWarning(true);
        this.setTrafficSignMode(1);
        this.setVoiceAnnouncementDuringPhone(1, true);
        if (this.myTarget.isPPOIAWFeature()) {
            this.myTarget.setApproachPPOIHint(true);
        } else if (this.myTarget.isCHNSpeedCameraWarning()) {
            this.myTarget.setSpeedCameraWarning(true);
        }
        this.myTarget.setAudioVoiceAnnnouncementType(0, true);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainEhSetCategoryVisibilityToDefault();
        this.myTarget.resetDestInputMode();
    }

    private void setTimeDisplay(int n) {
        this.myTarget.GUIDANCE_OPTIONS.setHmiGuidanceTimeFormat(n);
        int n2 = this.myTarget.GUIDANCE_OPTIONS.getDpGuidanceTimeFormat();
        ServiceManager.aslPropertyManager.valueChangedInteger(975, n2);
        this.setTimeDisplayForBap(n);
        int n3 = n == 0 ? 1 : 0;
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1063007488);
        eventGeneric.setInt(0, n3);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    private void setTimeDisplayForBap(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(737153024, n == 0 ? 1 : 0);
    }

    private void setBorderCrossingHint(boolean bl) {
        this.myTarget.GUIDANCE_OPTIONS.setBorderHint(bl);
        ServiceManager.aslPropertyManager.valueChangedBoolean(966, this.myTarget.GUIDANCE_OPTIONS.isBorderHint());
    }

    private void setStatusLineInfo(boolean bl) {
        this.myTarget.GUIDANCE_OPTIONS.setStatusLineInfo(bl);
        ServiceManager.aslPropertyManager.valueChangedBoolean(970, this.myTarget.GUIDANCE_OPTIONS.isStatusLineInfo());
    }

    private void setTrafficSignMode(int n) {
        this.myTarget.GUIDANCE_OPTIONS.setHmiTrafficSignMode(n);
        int n2 = this.myTarget.GUIDANCE_OPTIONS.getDpTrafficSignMode();
        ServiceManager.aslPropertyManager.valueChangedInteger(976, n2);
        switch (n) {
            case 0: {
                n = 0;
                break;
            }
            case 1: {
                n = 1;
                break;
            }
            default: {
                n = 0;
            }
        }
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1264334080);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    private void setVoiceAnnouncementDuringPhone(int n, boolean bl) {
        if (bl) {
            this.myTarget.GUIDANCE_OPTIONS.setVoiceAnnouncementDuringPhone(n);
        }
        int n2 = this.myTarget.GUIDANCE_OPTIONS.getDpVoiceAnnouncements();
        boolean bl2 = this.myTarget.GUIDANCE_OPTIONS.getDpVoiceAnnouncementsBoolean();
        ServiceManager.aslPropertyManager.valueChangedInteger(977, n2);
        ServiceManager.aslPropertyManager.valueChangedBoolean(1510, bl2);
    }

    private void setAcousticTrafficJamWarning(boolean bl) {
        this.myTarget.GUIDANCE_OPTIONS.setAcousticTrafficJamWarning(bl);
        int n = this.myTarget.GUIDANCE_OPTIONS.getDsiAcousticTrafficJamWarning();
        ServiceManager.aslPropertyManager.valueChangedBoolean(1013, this.myTarget.GUIDANCE_OPTIONS.isAcousticTrafficJamWarning());
        this.myTarget.dsiTmcOnRouteService.setTmcWarningMode(n);
    }

    public void dsiNavigationEhResult(int n, int n2) {
        this.myTarget.traceState(this, new StringBuffer().append("Target Setup entered DSINAVIGATION_EHRESULT: ").append(n2).toString());
        if (n2 == 0) {
            if (this.myTarget.isPPOIAWFeature()) {
                ServiceManager.aslPropertyManager.valueChangedBoolean(965, this.myTarget.GUIDANCE_OPTIONS.isAudibleApproachPPOIHint());
            } else if (this.myTarget.isCHNSpeedCameraWarning()) {
                ServiceManager.aslPropertyManager.valueChangedBoolean(1609568256, this.myTarget.GUIDANCE_OPTIONS.isSpeedCameraWarning());
            }
        }
    }

    @Override
    public void handleFullFacotryReset() {
        this.myTarget.traceState(this, "ASL_SYSTEM_RESET_SETTINGS_FULL_FACTORY_RESET");
        this.deletePersonalPoiDatabase();
        this.fullFactoryResetParticipant.notifyResetDone();
        this.trans(this.myTarget.stateSetupResetFactorySettings);
        this.myTarget.getHsm().activateTransition();
    }

    @Override
    public void handleNavigationSettingsReset() {
        this.resetAllSettings();
        ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNavigationModel();
        this.myTarget.traceState(this, "stop a potentially active guidance");
        this.myTarget.sendInternalEvent(1917522944, 0x24020040);
        this.navigationResetParticipant.notifyResetDone();
    }
}

