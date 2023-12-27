/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IPersonalNaviPersistence;
import de.vw.mib.asl.api.navigation.util.ReloadPersistedDataListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.ASLNavigationDP;
import de.vw.mib.asl.internal.navigation.gateway.AbstractNavGatewayListener;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdNavLocationToStream;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStreamToNavLocation;
import de.vw.mib.asl.navi.persistence.Navigation;
import de.vw.mib.collections.booleans.BooleanArrayList;
import de.vw.mib.collections.ints.IntArrayList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;

public final class IPersonalNaviPersistenceImpl
extends AbstractNavGatewayListener
implements IPersonalNaviPersistence,
ReloadPersistedDataListener {
    private final int HOME_DEST_LOCATION;
    private static IPersonalNaviPersistenceImpl INSTANCE;
    private ASLNavigationDP navDp;
    private Map pendingCommands;
    private NavLocation homeDestLocation;
    private boolean persistenceLocked;

    private IPersonalNaviPersistenceImpl(ASLNavigationDP aSLNavigationDP) {
        this.HOME_DEST_LOCATION = 1;
        this.navDp = aSLNavigationDP;
        this.pendingCommands = new HashMap();
        this.persistenceLocked = false;
        this.startReloadOfHomeLocation();
    }

    public static IPersonalNaviPersistence getInstance(ASLNavigationDP aSLNavigationDP) {
        if (INSTANCE == null) {
            INSTANCE = new IPersonalNaviPersistenceImpl(aSLNavigationDP);
            aSLNavigationDP.addReloadPersistedDataListener(INSTANCE);
        }
        if (!IPersonalNaviPersistenceImpl.INSTANCE.navDp.equals(aSLNavigationDP)) {
            INSTANCE.setAslNavigationDp(aSLNavigationDP);
        }
        return INSTANCE;
    }

    private void setAslNavigationDp(ASLNavigationDP aSLNavigationDP) {
        this.navDp = aSLNavigationDP;
        this.startReloadOfHomeLocation();
    }

    @Override
    public void lockPersitence() {
        this.persistenceLocked = true;
    }

    @Override
    public void unlockPersitence() {
        this.persistenceLocked = false;
    }

    @Override
    public void setHomeDestLocation(NavLocation navLocation) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setHomeDestLocation will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().getHomeAddressStream().clear();
        if (navLocation == null) {
            this.homeDestLocation = null;
        } else {
            this.homeDestLocation = navLocation;
            CmdNavLocationToStream cmdNavLocationToStream = new CmdNavLocationToStream(this, 0, navLocation);
            this.pendingCommands.put(cmdNavLocationToStream, new Integer(1));
            cmdNavLocationToStream.execute();
        }
    }

    @Override
    public NavLocation getHomeDestLocation(NavLocation navLocation) {
        if (this.homeDestLocation == null) {
            return navLocation;
        }
        return this.homeDestLocation;
    }

    @Override
    public void handleCommandCmdNavLocationToStream(CmdNavLocationToStream cmdNavLocationToStream) {
        Integer n = (Integer)this.pendingCommands.get(cmdNavLocationToStream);
        if (n != null) {
            if (cmdNavLocationToStream.isResultSuccess()) {
                switch (n) {
                    case 1: {
                        this.setLocationByteArrayToHomeAddress(cmdNavLocationToStream.getStreamOfLocation());
                        break;
                    }
                }
            }
            this.pendingCommands.remove(cmdNavLocationToStream);
        }
    }

    private void setLocationByteArrayToHomeAddress(byte[] byArray) {
        List list = this.byteArrayAsListOfByteObjects(byArray);
        this.getMyPersonalNaviPersistence().getHomeAddressStream().addAll(list);
        this.sendHomeAddressChangedEvent();
    }

    private List byteArrayAsListOfByteObjects(byte[] byArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            arrayList.add(new Byte(byArray[i2]));
        }
        return arrayList;
    }

    @Override
    public void handleCommandCmdStreamToNavLocation(CmdStreamToNavLocation cmdStreamToNavLocation) {
        Integer n = (Integer)this.pendingCommands.get(cmdStreamToNavLocation);
        if (n != null) {
            if (cmdStreamToNavLocation.isResultSuccess()) {
                switch (n) {
                    case 1: {
                        this.homeDestLocation = cmdStreamToNavLocation.getLocationToStream();
                        this.setHomeDestLocationInModel();
                        this.sendHomeAddressChangedEvent();
                        break;
                    }
                }
            }
            this.pendingCommands.remove(cmdStreamToNavLocation);
        }
    }

    private void setHomeDestLocationInModel() {
        ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().fillHomeAddressGetter(this.homeDestLocation);
    }

    @Override
    public void reloadPersistedData() {
        this.startReloadOfHomeLocation();
    }

    private void startReloadOfHomeLocation() {
        this.homeDestLocation = null;
        List list = this.getMyPersonalNaviPersistence().getHomeAddressStream();
        if (!list.isEmpty()) {
            byte[] byArray = this.convertListOfByteObjectstoByteArray(list);
            CmdStreamToNavLocation cmdStreamToNavLocation = new CmdStreamToNavLocation(this, 0, byArray);
            this.pendingCommands.put(cmdStreamToNavLocation, new Integer(1));
            cmdStreamToNavLocation.execute();
        } else {
            this.setHomeDestLocationInModel();
            this.sendHomeAddressChangedEvent();
        }
    }

    private byte[] convertListOfByteObjectstoByteArray(Collection collection) {
        Object[] objectArray = collection.toArray();
        int n = objectArray.length;
        byte[] byArray = new byte[n];
        for (int i2 = 0; i2 < n; ++i2) {
            if (objectArray[i2] == null) continue;
            byArray[i2] = ((Number)objectArray[i2]).byteValue();
        }
        return byArray;
    }

    private void sendHomeAddressChangedEvent() {
        ASLNavigationMapFactory.getNavigationMapApi().sendEvDestInputHomeLocationChanged();
    }

    @Override
    public void setVoiceAnouncementState(boolean bl) {
        this.getMyPersonalNaviPersistence().setVoiceAnouncementState(bl);
    }

    private Navigation getMyPersonalNaviPersistence() {
        return this.navDp.getMyPersonalNaviPersistence();
    }

    @Override
    public void setVoiceAnouncementDuringPhoneCall(int n) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setVoiceAnouncementDuringPhoneCall will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setVoiceAnouncementDuringPhoneCall(n);
    }

    @Override
    public void setVoiceAnouncementDetail(int n) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setVoiceAnouncementDetail will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setVoiceAnouncementDetail(n);
    }

    @Override
    public void setTrafficSignMode(int n) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setTrafficSignMode will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setTrafficSignMode(n);
    }

    @Override
    public void setRouteOptionsRouteCalculationType(int n) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setRouteOptionsRouteCalculationType will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setRouteOptionsRouteCalculationType(n);
    }

    @Override
    public void setRouteOptionsDynamicRouteCalculation(int n) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setRouteOptionsDynamicRouteCalculation will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setRouteOptionsDynamicRouteCalculation(n);
    }

    @Override
    public void setRouteOptionsAlternativeRouteCalc(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setRouteOptionsAlternativeRouteCalc will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setRouteOptionsAlternativeRouteCalc(bl);
    }

    @Override
    public void setMapMainMapShowFavoriteIcons(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setMapMainMapShowFavoriteIcons will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setMapMainMapShowFavoriteIcons(bl);
    }

    @Override
    public void setMapMainMapShowBrandIcons(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setMapMainMapShowBrandIcons will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setMapMainMapShowBrandIcons(bl);
    }

    @Override
    public void setMapMainLaneGuidance(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setMapMainLaneGuidance will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setMapMainLaneGuidance(bl);
    }

    @Override
    public void setGuidanceTimeFormat(int n) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setGuidanceTimeFormat will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setGuidanceTimeFormat(n);
    }

    @Override
    public void setGuidanceStatusLineInfo(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setGuidanceStatusLineInfo will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setGuidanceStatusLineInfo(bl);
    }

    @Override
    public void setFuelWarinigPopup(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setFuelWarinigPopup will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setFuelWarinigPopup(bl);
    }

    @Override
    public void setBorderChangeActive(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setBorderChangeActive will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setBorderChangeActive(bl);
    }

    @Override
    public boolean isVoiceAnouncementState() {
        return this.getMyPersonalNaviPersistence().isVoiceAnouncementState();
    }

    @Override
    public boolean isRouteOptionsAlternativeRouteCalc() {
        return this.getMyPersonalNaviPersistence().isRouteOptionsAlternativeRouteCalc();
    }

    @Override
    public boolean isMapMainMapShowFavoriteIcons() {
        return this.getMyPersonalNaviPersistence().isMapMainMapShowFavoriteIcons();
    }

    @Override
    public boolean isMapMainMapShowBrandIcons() {
        return this.getMyPersonalNaviPersistence().isMapMainMapShowBrandIcons();
    }

    @Override
    public boolean isMapMainLaneGuidance() {
        return this.getMyPersonalNaviPersistence().isMapMainLaneGuidance();
    }

    @Override
    public boolean isGuidanceStatusLineInfo() {
        return this.getMyPersonalNaviPersistence().isGuidanceStatusLineInfo();
    }

    @Override
    public boolean isFuelWarinigPopup() {
        return this.getMyPersonalNaviPersistence().isFuelWarinigPopup();
    }

    @Override
    public boolean isBorderChangeActive() {
        return this.getMyPersonalNaviPersistence().isBorderChangeActive();
    }

    @Override
    public int getVoiceAnouncementDuringPhoneCall() {
        return this.getMyPersonalNaviPersistence().getVoiceAnouncementDuringPhoneCall();
    }

    @Override
    public int getVoiceAnouncementDetail() {
        return this.getMyPersonalNaviPersistence().getVoiceAnouncementDetail();
    }

    @Override
    public int getTrafficSignMode() {
        return this.getMyPersonalNaviPersistence().getTrafficSignMode();
    }

    @Override
    public IntArrayList getRouteOptionsVignetteAvailableCountryIds() {
        return this.getMyPersonalNaviPersistence().getRouteOptionsVignetteAvailableCountryIds();
    }

    @Override
    public int getRouteOptionsRouteCalculationType() {
        return this.getMyPersonalNaviPersistence().getRouteOptionsRouteCalculationType();
    }

    @Override
    public int getRouteOptionsDynamicRouteCalculation() {
        return this.getMyPersonalNaviPersistence().getRouteOptionsDynamicRouteCalculation();
    }

    @Override
    public BooleanArrayList getRouteOptionsAvoidRoadTypes() {
        return this.getMyPersonalNaviPersistence().getRouteOptionsAvoidRoadTypes();
    }

    @Override
    public int getGuidanceTimeFormat() {
        return this.getMyPersonalNaviPersistence().getGuidanceTimeFormat();
    }

    @Override
    public void resetToDefaults() {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for resetToDefaults will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().resetToDefaults();
    }

    @Override
    public boolean isHOVUsage() {
        return this.getMyPersonalNaviPersistence().isHOVUsage();
    }

    @Override
    public void setHOVUsage(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setHOVUsage will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setHOVUsage(bl);
    }

    @Override
    public boolean isMainMapShowPoiIcons() {
        return this.getMyPersonalNaviPersistence().isMainMapShowPoiIcons();
    }

    @Override
    public void setMainMapShowPoiIcons(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setMainMapShowPoiIcons will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setMainMapShowPoiIcons(bl);
    }

    @Override
    public void setMainMapOrientation(int n) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setMainMapOrientation will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setMainMapOrientation(n);
    }

    @Override
    public int getMainMapOrientation() {
        return this.getMyPersonalNaviPersistence().getMainMapOrientation();
    }

    @Override
    public void setMainMapTypeLast(int n) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setMainMapTypeLast will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setMainMapTypeLast(n);
    }

    @Override
    public int getMainMapTypeLast() {
        return this.getMyPersonalNaviPersistence().getMainMapTypeLast();
    }

    @Override
    public void setMainMapShowSpeedAndFlow(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setMainMapShowSpeedAndFlow will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setMainMapShowSpeedAndFlow(bl);
    }

    @Override
    public boolean getMainMapShowSpeedAndFlow() {
        return this.getMyPersonalNaviPersistence().isMainMapShowSpeedAndFlow();
    }

    @Override
    public void setTrafficShowFreeFlow(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setTrafficShowFreeFlow will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setTrafficShowFreeFlow(bl);
    }

    @Override
    public boolean getTrafficShowFreeFlow() {
        return this.getMyPersonalNaviPersistence().isTrafficShowFreeFlow();
    }

    @Override
    public void setTrafficShowCongestion(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setTrafficShowCongestion will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setTrafficShowCongestion(bl);
    }

    @Override
    public boolean getTrafficShowCongestion() {
        return this.getMyPersonalNaviPersistence().isTrafficShowCongestion();
    }

    @Override
    public void setTrafficShowIncidents(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setTrafficShowIncidents will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setTrafficShowIncidents(bl);
    }

    @Override
    public boolean getTrafficShowIncidents() {
        return this.getMyPersonalNaviPersistence().isTrafficShowIncidents();
    }

    @Override
    public boolean isKDK() {
        return this.getMyPersonalNaviPersistence().isMainMapIsKdkActive();
    }

    @Override
    public void setKDK(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setKDK will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setMainMapIsKdkActive(bl);
    }

    @Override
    public void setMapInMapMode(int n) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setMapInMapMode will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setMapInMapMode(n);
    }

    @Override
    public int getMapInMapMode() {
        return this.getMyPersonalNaviPersistence().getMapInMapMode();
    }

    @Override
    public int getMainMapAutoZoomMode() {
        return this.getMyPersonalNaviPersistence().getMainMapAutoZoomMode();
    }

    @Override
    public void setMainMapAutoZoomMode(int n) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setMainMapAutoZoomMode will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setMainMapAutoZoomMode(n);
    }

    @Override
    public boolean isSpeedCameraWarning() {
        return this.getMyPersonalNaviPersistence().isSpeedCameraWarning();
    }

    @Override
    public void setSpeedCameraWarning(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setSpeedCameraWarning will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setSpeedCameraWarning(bl);
    }

    @Override
    public void setMainMapVisibleInKombi(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setMainMapVisibleInKombi will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setMainMapVisibleInKombi(bl);
    }

    @Override
    public boolean isMapVisibleInKombi() {
        return this.getMyPersonalNaviPersistence().isMainMapVisibleInKombi();
    }

    @Override
    public void setMapTypeKombiFpk(int n) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setMapTypeKombiFpk will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setMapTypeKombiFpk(n);
    }

    @Override
    public int getMapTypeKombiFpk() {
        return this.getMyPersonalNaviPersistence().getMapTypeKombiFpk();
    }

    @Override
    public void setMapOrientationKombiFpk(int n) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setMapOrientationKombiFpk will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setMapOrientationKombiFpk(n);
    }

    @Override
    public int getMapOrientationKombiFpk() {
        return this.getMyPersonalNaviPersistence().getMapOrientationKombiFpk();
    }

    @Override
    public void setMapContentKombiFpk(int n) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setMapContentKombiFpk will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setMapContentKombiFpk(n);
    }

    @Override
    public int getMapContentKombiFpk() {
        return this.getMyPersonalNaviPersistence().getMapContentKombiFpk();
    }

    @Override
    public void setKdkActiveInKombiFpk(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setKdkActiveInKombiFpk will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setKdkActiveInKombiFpk(bl);
    }

    @Override
    public boolean isKdkActiveInKombiFpk() {
        return this.getMyPersonalNaviPersistence().isKdkActiveInKombiFpk();
    }

    @Override
    public void setAutoZoomModeKombiFpk(int n) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setAutoZoomModeKombiFpk will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setAutoZoomModeKombiFpk(n);
    }

    @Override
    public int getAutoZoomModeKombiFpk() {
        return this.getMyPersonalNaviPersistence().getAutoZoomModeKombiFpk();
    }

    @Override
    public void setPrivacyMode(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setPrivacyMode will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setPrivacyMode(bl);
    }

    @Override
    public boolean isPrivacyMode() {
        return this.getMyPersonalNaviPersistence().isPrivacyMode();
    }

    @Override
    public void setSplitScreenGuidanceVisibility(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setSplitScreenGuidanceVisibility will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setSplitScreenGuidanceVisibility(bl);
    }

    @Override
    public boolean isSplitScreenGuidanceVisible() {
        return this.getMyPersonalNaviPersistence().isSplitScreenGuidanceVisibility();
    }

    @Override
    public void setSplitScreenNoGuidanceVisibility(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setSplitScreenNoGuidanceVisibility will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setSplitScreenNoGuidanceVisibility(bl);
    }

    @Override
    public boolean isSplitScreenNoGuidanceVisible() {
        return this.getMyPersonalNaviPersistence().isSplitScreenNoGuidanceVisibility();
    }

    @Override
    public void setSplitScreenGuidanceContent(int n) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setSplitScreenGuidanceContent will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setSplitScreenGuidanceContent(n);
    }

    @Override
    public int getSplitScreenGuidanceContent() {
        return this.getMyPersonalNaviPersistence().getSplitScreenGuidanceContent();
    }

    @Override
    public void setSplitScreenNoGuidanceContent(int n) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setSplitScreenNoGuidanceContent will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setSplitScreenNoGuidanceContent(n);
    }

    @Override
    public int getSplitScreenNoGuidanceContent() {
        return this.getMyPersonalNaviPersistence().getSplitScreenNoGuidanceContent();
    }

    @Override
    public boolean isAudibleApproachPPOIHintStatus() {
        return this.getMyPersonalNaviPersistence().isAudibleApproachPPOIHintStatus();
    }

    @Override
    public void setAudibleApproachPPOIHintStatus(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setAudibleApproachPPOIHintStatus will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setAudibleApproachPPOIHintStatus(bl);
    }

    @Override
    public int getMainMapMapMode() {
        return this.getMyPersonalNaviPersistence().getMainMapMapMode();
    }

    @Override
    public void setMainMapMode(int n) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setMainMapMode will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setMainMapMapMode(n);
    }

    @Override
    public void setOnlineToursAvailable(int n) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setOnlineToursAvailable will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setOnlineToursAvailable(n);
    }

    @Override
    public int getOnlineToursAvailable() {
        return this.getMyPersonalNaviPersistence().getOnlineToursAvailable();
    }

    @Override
    public void setRouteOptionsSeasonalRestrictions(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setRouteOptionsSeasonalRestrictions will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setSeasonalRestrictions(bl);
    }

    @Override
    public boolean isSeasonalRestrictions() {
        return this.getMyPersonalNaviPersistence().isSeasonalRestrictions();
    }

    @Override
    public void setRouteOptionsStatisticalData(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setRouteOptionsStatisticalData will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setStatisticalData(bl);
    }

    @Override
    public boolean isStatisticalData() {
        return this.getMyPersonalNaviPersistence().isStatisticalData();
    }

    @Override
    public int getDayNightMainMapMode() {
        return this.getMyPersonalNaviPersistence().getDayNightMainMapMode();
    }

    @Override
    public void setDayNightMainMapMode(int n) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setDayNightMainMapMode will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setDayNightMainMapMode(n);
    }

    @Override
    public boolean isMergingTraffic() {
        return this.getMyPersonalNaviPersistence().isMergingTraffic();
    }

    @Override
    public void setMergingTraffic(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setMergingTraffic will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setMergingTraffic(bl);
    }

    @Override
    public boolean isReduceLane() {
        return this.getMyPersonalNaviPersistence().isReduceLane();
    }

    @Override
    public void setReduceLane(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setReduceLane will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setReduceLane(bl);
    }

    @Override
    public boolean isRailwayCrossing() {
        return this.getMyPersonalNaviPersistence().isRailwayCrossing();
    }

    @Override
    public void setRailwayCrossing(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for railwayCrossing will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setRailwayCrossing(bl);
    }

    @Override
    public int getSpeedCameraWarningType() {
        return this.getMyPersonalNaviPersistence().getSpeedCameraWarningType();
    }

    @Override
    public void setSpeedCameraWarningType(int n) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setSpeedCameraWarningType will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setSpeedCameraWarningType(n);
    }

    @Override
    public boolean isPnavEnabled() {
        return this.getMyPersonalNaviPersistence().isPnavEnabled();
    }

    @Override
    public void setPnavEnabled(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setPnavEnabled will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setPnavEnabled(bl);
    }

    @Override
    public boolean isShowSldeHelp() {
        return this.getMyPersonalNaviPersistence().isShowSldeHelp();
    }

    @Override
    public void setShowSldeHelp(boolean bl) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setShowSldeHelp will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setShowSldeHelp(bl);
    }

    @Override
    public int getLastModeDestinationInput() {
        return this.getMyPersonalNaviPersistence().getLastModeDestinationInput();
    }

    @Override
    public void setLastModeDestinationInput(int n) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setLastModeDestinationInput will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setLastModeDestinationInput(n);
    }

    @Override
    public void setLastTimeStampBeforeHmiOff(long l) {
        if (this.persistenceLocked) {
            ServiceManager.logger.warn(16384, "[IPersonalNaviPersistenceImpl] Persistence locked due to running profile change. Changes for setLastTimeStampBeforeHmiOff will not be persisted and discarded!");
            return;
        }
        this.getMyPersonalNaviPersistence().setLastTimeStampBeforeHmiOff(l);
    }

    @Override
    public long getLastTimeStampBeforeHmiOff() {
        return this.getMyPersonalNaviPersistence().getLastTimeStampBeforeHmiOff();
    }
}

