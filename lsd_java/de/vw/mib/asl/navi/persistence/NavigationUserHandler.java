/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.navi.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.internal.navigation.util.PersistenceDefaults;
import de.vw.mib.asl.navi.persistence.Navigation;
import de.vw.mib.log4mib.Logger;
import java.util.Map$Entry;

class NavigationUserHandler
extends AbstractPersistenceDataHandler {
    private final Navigation handledPersistable;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$navi$persistence$NavigationUserHandler;

    NavigationUserHandler(Navigation navigation, Logger logger, PersistenceModule persistenceModule) {
        super(logger);
        if (!$assertionsDisabled && navigation == null) {
            throw new AssertionError();
        }
        this.handledPersistable = navigation;
        this.module = persistenceModule;
    }

    @Override
    public void handle(int n, boolean bl) {
        switch (n) {
            case 4: {
                this.handledPersistable.setVoiceAnouncementState(bl);
                this.markAsProcessed(n);
                break;
            }
            case 7: {
                this.handledPersistable.setGuidanceStatusLineInfo(bl);
                this.markAsProcessed(n);
                break;
            }
            case 8: {
                this.handledPersistable.setBorderChangeActive(bl);
                this.markAsProcessed(n);
                break;
            }
            case 9: {
                this.handledPersistable.setRouteOptionsAlternativeRouteCalc(bl);
                this.markAsProcessed(n);
                break;
            }
            case 12: {
                this.handledPersistable.getRouteOptionsAvoidRoadTypes().add(bl);
                this.markAsProcessed(n);
                break;
            }
            case 13: {
                this.handledPersistable.setMapMainMapShowBrandIcons(bl);
                this.markAsProcessed(n);
                break;
            }
            case 14: {
                this.handledPersistable.setMapMainMapShowFavoriteIcons(bl);
                this.markAsProcessed(n);
                break;
            }
            case 15: {
                this.handledPersistable.setMapMainLaneGuidance(bl);
                this.markAsProcessed(n);
                break;
            }
            case 16: {
                this.handledPersistable.setFuelWarinigPopup(bl);
                this.markAsProcessed(n);
                break;
            }
            case 17: {
                this.handledPersistable.setHOVUsage(bl);
                this.markAsProcessed(n);
                break;
            }
            case 18: {
                this.handledPersistable.setMainMapShowPoiIcons(bl);
                this.markAsProcessed(n);
                break;
            }
            case 23: {
                this.handledPersistable.setMainMapShowSpeedAndFlow(bl);
                this.markAsProcessed(n);
                break;
            }
            case 24: {
                this.handledPersistable.setTrafficShowFreeFlow(bl);
                this.markAsProcessed(n);
                break;
            }
            case 25: {
                this.handledPersistable.setTrafficShowCongestion(bl);
                this.markAsProcessed(n);
                break;
            }
            case 26: {
                this.handledPersistable.setTrafficShowIncidents(bl);
                this.markAsProcessed(n);
                break;
            }
            case 27: {
                this.handledPersistable.setMainMapIsKdkActive(bl);
                this.markAsProcessed(n);
                break;
            }
            case 30: {
                this.handledPersistable.setSpeedCameraWarning(bl);
                this.markAsProcessed(n);
                break;
            }
            case 32: {
                this.handledPersistable.setMainMapVisibleInKombi(bl);
                this.markAsProcessed(n);
                break;
            }
            case 36: {
                this.handledPersistable.setKdkActiveInKombiFpk(bl);
                this.markAsProcessed(n);
                break;
            }
            case 38: {
                this.handledPersistable.setPrivacyMode(bl);
                this.markAsProcessed(n);
                break;
            }
            case 39: {
                this.handledPersistable.setSplitScreenGuidanceVisibility(bl);
                this.markAsProcessed(n);
                break;
            }
            case 40: {
                this.handledPersistable.setSplitScreenNoGuidanceVisibility(bl);
                this.markAsProcessed(n);
                break;
            }
            case 43: {
                this.handledPersistable.setAudibleApproachPPOIHintStatus(bl);
                this.markAsProcessed(n);
                break;
            }
            case 56: {
                this.handledPersistable.setPnavEnabled(bl);
                this.markAsProcessed(n);
                break;
            }
            case 57: {
                this.handledPersistable.setShowSldeHelp(bl);
                this.markAsProcessed(n);
                break;
            }
            default: {
                this.logUnknownField(n, "boolean");
            }
        }
    }

    @Override
    public void handle(int n, char c2) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "char");
    }

    @Override
    public void handle(int n, byte by) {
        switch (n) {
            case 19: {
                this.handledPersistable.getHomeAddressStream().add(new Byte(by));
                this.markAsProcessed(n);
                break;
            }
            default: {
                this.logUnknownField(n, "byte");
            }
        }
    }

    @Override
    public void handle(int n, short s) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "short");
    }

    @Override
    public void handle(int n, int n2) {
        switch (n) {
            case 2: {
                this.handledPersistable.setVoiceAnouncementDuringPhoneCall(n2);
                this.markAsProcessed(n);
                break;
            }
            case 3: {
                this.handledPersistable.setVoiceAnouncementDetail(n2);
                this.markAsProcessed(n);
                break;
            }
            case 5: {
                this.handledPersistable.setTrafficSignMode(n2);
                this.markAsProcessed(n);
                break;
            }
            case 6: {
                this.handledPersistable.setGuidanceTimeFormat(n2);
                this.markAsProcessed(n);
                break;
            }
            case 10: {
                this.handledPersistable.setRouteOptionsRouteCalculationType(n2);
                this.markAsProcessed(n);
                break;
            }
            case 11: {
                this.handledPersistable.setRouteOptionsDynamicRouteCalculation(n2);
                this.markAsProcessed(n);
                break;
            }
            case 21: {
                this.handledPersistable.setMainMapOrientation(n2);
                this.markAsProcessed(n);
                break;
            }
            case 22: {
                this.handledPersistable.setMainMapTypeLast(n2);
                this.markAsProcessed(n);
                break;
            }
            case 28: {
                this.handledPersistable.setMapInMapMode(n2);
                this.markAsProcessed(n);
                break;
            }
            case 29: {
                this.handledPersistable.setMainMapAutoZoomMode(n2);
                this.markAsProcessed(n);
                break;
            }
            case 33: {
                this.handledPersistable.setMapTypeKombiFpk(n2);
                this.markAsProcessed(n);
                break;
            }
            case 34: {
                this.handledPersistable.setMapOrientationKombiFpk(n2);
                this.markAsProcessed(n);
                break;
            }
            case 35: {
                this.handledPersistable.setMapContentKombiFpk(n2);
                this.markAsProcessed(n);
                break;
            }
            case 37: {
                this.handledPersistable.setAutoZoomModeKombiFpk(n2);
                this.markAsProcessed(n);
                break;
            }
            case 41: {
                this.handledPersistable.setSplitScreenGuidanceContent(n2);
                this.markAsProcessed(n);
                break;
            }
            case 42: {
                this.handledPersistable.setSplitScreenNoGuidanceContent(n2);
                this.markAsProcessed(n);
                break;
            }
            case 44: {
                this.handledPersistable.setMainMapMapMode(n2);
                this.markAsProcessed(n);
                break;
            }
            case 48: {
                this.handledPersistable.setDayNightMainMapMode(n2);
                this.markAsProcessed(n);
                break;
            }
            case 58: {
                this.handledPersistable.setLastModeDestinationInput(n2);
                this.markAsProcessed(n);
                break;
            }
            default: {
                this.logUnknownField(n, "int");
            }
        }
    }

    @Override
    public void handle(int n, long l) {
        switch (n) {
            case 60: {
                this.handledPersistable.setLastTimeStampBeforeHmiOff(l);
                this.markAsProcessed(n);
                break;
            }
            default: {
                this.logUnknownField(n, "long");
            }
        }
    }

    @Override
    public void handle(int n, float f2) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "float");
    }

    @Override
    public void handle(int n, double d2) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "double");
    }

    @Override
    public void handle(int n, String string) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "String");
    }

    @Override
    public void handle(int n, Persistable persistable) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "Persistable");
    }

    @Override
    public void handle(int n, Map$Entry map$Entry) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "Map");
    }

    @Override
    public void handleEmptyCollection(int n) {
        switch (n) {
            case 12: {
                this.markAsProcessed(n);
                break;
            }
            case 19: {
                this.markAsProcessed(n);
                break;
            }
            default: {
                this.logUnknownField(n, "Container");
            }
        }
    }

    @Override
    protected int[] getFieldIds() {
        return new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 48, 56, 57, 58, 60};
    }

    @Override
    protected void installDefaultValue(int n) {
        switch (n) {
            case 2: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setVoiceAnouncementDuringPhoneCall(PersistenceDefaults.getHmiVoiceAnnouncementsDuringPhoneSetDefault());
                break;
            }
            case 3: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setVoiceAnouncementDetail(PersistenceDefaults.getHmiAudioAnnouncementTypeDefault());
                break;
            }
            case 4: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setVoiceAnouncementState(PersistenceDefaults.getSoundNavAnnouncementStateDefault());
                break;
            }
            case 5: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setTrafficSignMode(PersistenceDefaults.getHmiTrafficSignModeDefault());
                break;
            }
            case 6: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setGuidanceTimeFormat(PersistenceDefaults.getHmiGuidanceTimeFormatDefault());
                break;
            }
            case 7: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setGuidanceStatusLineInfo(PersistenceDefaults.getStatusLineInfoDefault());
                break;
            }
            case 8: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setBorderChangeActive(PersistenceDefaults.getBorderChangePopupActiveDefault());
                break;
            }
            case 9: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setRouteOptionsAlternativeRouteCalc(PersistenceDefaults.getRouteOptionsHmiAlternativeRouteCalculationDefault());
                break;
            }
            case 10: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setRouteOptionsRouteCalculationType(PersistenceDefaults.getRouteOptionHmiRouteCalculationTypeDefault());
                break;
            }
            case 11: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setRouteOptionsDynamicRouteCalculation(PersistenceDefaults.getRouteOptionsHmiDynamicRouteCalculationDefault());
                break;
            }
            case 12: {
                break;
            }
            case 13: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setMapMainMapShowBrandIcons(PersistenceDefaults.getMainMapShowIconsBrandsDefault());
                break;
            }
            case 14: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setMapMainMapShowFavoriteIcons(PersistenceDefaults.getMainMapShowIconsFavoritesDefault());
                break;
            }
            case 15: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setMapMainLaneGuidance(PersistenceDefaults.getLaneGuidanceDefault());
                break;
            }
            case 16: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setFuelWarinigPopup(PersistenceDefaults.getPoiFuelOptionsFuelWwarningDefault());
                break;
            }
            case 17: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setHOVUsage(PersistenceDefaults.getHOVUsageDefault());
                break;
            }
            case 18: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setMainMapShowPoiIcons(PersistenceDefaults.getMainMapShowPoiIconsDefault());
                break;
            }
            case 19: {
                break;
            }
            case 21: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setMainMapOrientation(PersistenceDefaults.getMainMapOrientationDefault());
                break;
            }
            case 22: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setMainMapTypeLast(PersistenceDefaults.getMainMapTypeLastDefault());
                break;
            }
            case 23: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setMainMapShowSpeedAndFlow(PersistenceDefaults.getMainMapShowSpeedAndFlowDefault());
                break;
            }
            case 24: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setTrafficShowFreeFlow(PersistenceDefaults.getTrafficShowFreeFlowDefault());
                break;
            }
            case 25: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setTrafficShowCongestion(PersistenceDefaults.getTrafficShowCongestionDefault());
                break;
            }
            case 26: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setTrafficShowIncidents(PersistenceDefaults.getTrafficShowIncidentsDefault());
                break;
            }
            case 27: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setMainMapIsKdkActive(PersistenceDefaults.getMainMapIsKdkActiveDefault());
                break;
            }
            case 28: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setMapInMapMode(PersistenceDefaults.getMapInMapModeDefault());
                break;
            }
            case 29: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setMainMapAutoZoomMode(PersistenceDefaults.getMainMapAutoZoomModeDefault());
                break;
            }
            case 30: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setSpeedCameraWarning(PersistenceDefaults.getSpeedCameraWarningDefault());
                break;
            }
            case 32: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setMainMapVisibleInKombi(PersistenceDefaults.getMainMapVisibleInKombiDefault());
                break;
            }
            case 33: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setMapTypeKombiFpk(PersistenceDefaults.getMapTypeKombiFpkDefault());
                break;
            }
            case 34: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setMapOrientationKombiFpk(PersistenceDefaults.getMapOrientationKombiFpkDefault());
                break;
            }
            case 35: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setMapContentKombiFpk(PersistenceDefaults.getMapContentKombiFpkDefault());
                break;
            }
            case 36: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setKdkActiveInKombiFpk(PersistenceDefaults.getKdkActiveInKombiFpkDefault());
                break;
            }
            case 37: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setAutoZoomModeKombiFpk(PersistenceDefaults.getAutoZoomModeKombiFpkDefault());
                break;
            }
            case 38: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setPrivacyMode(PersistenceDefaults.getPrivacyModeDefault());
                break;
            }
            case 39: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setSplitScreenGuidanceVisibility(PersistenceDefaults.getSplitScreenGuidanceVisibilityDefault());
                break;
            }
            case 40: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setSplitScreenNoGuidanceVisibility(PersistenceDefaults.getSplitScreenNoGuidanceVisibilityDefault());
                break;
            }
            case 41: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setSplitScreenGuidanceContent(PersistenceDefaults.getSplitScreenGuidanceContentDefault());
                break;
            }
            case 42: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setSplitScreenNoGuidanceContent(PersistenceDefaults.getSplitScreenNoGuidanceContentDefault());
                break;
            }
            case 43: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setAudibleApproachPPOIHintStatus(PersistenceDefaults.getAudibleApproachPPOIHintStatusDefault());
                break;
            }
            case 44: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setMainMapMapMode(PersistenceDefaults.getMainMapMapModeDefault());
                break;
            }
            case 48: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setDayNightMainMapMode(PersistenceDefaults.getDayNightMainMapModeDefault());
                break;
            }
            case 56: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setPnavEnabled(PersistenceDefaults.getPnavEnabledDefault());
                break;
            }
            case 57: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setShowSldeHelp(PersistenceDefaults.getShowSldeHelpDefault());
                break;
            }
            case 58: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setLastModeDestinationInput(PersistenceDefaults.getLastModeDestinationInputDefault());
                break;
            }
            case 60: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setLastTimeStampBeforeHmiOff(PersistenceDefaults.getLastTimeStampBeforeHmiOff());
                break;
            }
            default: {
                this.getLogger().warn(32).append("Cannot install default value: Unknown field ID (").append(n).append(")").log();
            }
        }
    }

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected int getPersistableId() {
        return 1;
    }

    protected boolean performValidation() {
        return true;
    }

    protected boolean invokeExternalMethods() {
        return true;
    }

    void preventUnusedModuleWarning__doNotInvoke() {
        this.module.getVersion();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$asl$navi$persistence$NavigationUserHandler == null ? (class$de$vw$mib$asl$navi$persistence$NavigationUserHandler = NavigationUserHandler.class$("de.vw.mib.asl.navi.persistence.NavigationUserHandler")) : class$de$vw$mib$asl$navi$persistence$NavigationUserHandler).desiredAssertionStatus();
    }
}

