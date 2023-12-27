/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.api.impl;

import de.vw.mib.asl.api.navigation.poi.ASLNavigationPoiAPI;
import de.vw.mib.asl.api.navigation.poi.IPersistedPoiSetup;
import de.vw.mib.asl.api.navigation.poi.IPoiOnboardSearchResultListener;
import de.vw.mib.asl.api.navigation.poi.IPoiOnlineSearchResultListener;
import de.vw.mib.asl.api.navigation.poi.online.IOnlinePoiListElement;
import de.vw.mib.asl.api.navigation.poi.online.NavigationOnlinePoiListener;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationContainer;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.poi.jpn.PoiJpnTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.DynamicPoiCategoryHandler;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractElementCommon;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiDatapool;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.PoiTargetFuelWarning;
import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery.HsmTargetBattery;
import de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.PPoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.online.OnlinePoiSDSTarget;
import de.vw.mib.asl.internal.navigation.poi.online.OnlinePoiTarget;
import de.vw.mib.asl.internal.navigation.poi.setup.HsmTargetPoiSetupFuelOptions;
import de.vw.mib.asl.internal.navigation.poi.setup.HsmTargetPoiSetupMapCategories;
import de.vw.mib.asl.internal.navigation.poi.setup.PersistedPoiSetup;
import de.vw.mib.asl.internal.navigation.poi.setup.threelevel.HsmTargetPoiSetupMapThreeLevelCategories;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.navigation.LIValueListElement;

public class ASLNavigationPoiAPIImpl
implements ASLNavigationPoiAPI,
ASLNavigationContainer {
    static IntObjectOptHashMap dynPoiServiceIds = new IntObjectOptHashMap();
    private boolean isNavMultiLevelPoi4Map = ServiceManager.configManagerDiag.isFeatureFlagSet(152);
    private OnlinePoiTarget onlinePoiTarget;
    private PoiHsmTarget poiTarget;
    private PPoiHsmTarget personalPoiTarget;
    private String lastServiceIdString;

    public ASLNavigationPoiAPIImpl() {
        ASLNavigationStartupFactory.getNavigationStartupApi().registerContainer(this);
    }

    @Override
    public void createTargets() {
        GenericEvents genericEvents = ServiceManager.eventMain;
        String string = "hsmtask";
        this.poiTarget = new PoiHsmTarget(genericEvents, 1598755840, string);
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(2, this.poiTarget);
        this.personalPoiTarget = new PPoiHsmTarget(genericEvents, -632613888, string);
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(2, this.personalPoiTarget);
        if (this.isNavMultiLevelPoi4Map) {
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(1, new HsmTargetPoiSetupMapThreeLevelCategories(genericEvents, 1699419136, string));
        } else {
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(1, new HsmTargetPoiSetupMapCategories(genericEvents, 1699419136, string));
        }
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new HsmTargetPoiSetupFuelOptions(genericEvents, 2102072320, string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new HsmTargetBattery(genericEvents, -1857350656, string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new PoiTargetFuelWarning(genericEvents, -1253370880, string));
        this.onlinePoiTarget = new OnlinePoiTarget(genericEvents, -1807019008, string);
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, this.onlinePoiTarget);
        OnlinePoiSDSTarget onlinePoiSDSTarget = new OnlinePoiSDSTarget(genericEvents, -850717696, string);
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, onlinePoiSDSTarget);
        PoiJpnTarget poiJpnTarget = new PoiJpnTarget(genericEvents, -783608832, string);
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, poiJpnTarget);
    }

    @Override
    public IPersistedPoiSetup getPoiSetup() {
        return PersistedPoiSetup.getInstance();
    }

    @Override
    public void reloadTopPois(int n) {
        String string = ServiceManager.configManagerDiag.getPureVariant();
        if (!string.startsWith("PREMIUM_")) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(n, 1598755840, -1786248960);
            try {
                ServiceManager.eventMain.getEventDispatcher().send(eventGeneric);
            }
            catch (GenericEventException genericEventException) {
                ServiceManager.logger.error(2).attachThrowable(genericEventException).log();
            }
        }
    }

    @Override
    public boolean isValidOnlinePoiCategory(int n) {
        return DynamicPoiCategoryHandler.isValidOnlinePoiCategory(n);
    }

    @Override
    public void registerPoiOnlineSearchResultListener(IPoiOnlineSearchResultListener iPoiOnlineSearchResultListener) {
        OnlinePoiSDSTarget.registerPoiOnlineSearchResultListener(iPoiOnlineSearchResultListener);
    }

    @Override
    public void unregisterPoiOnlineSearchResultListener(IPoiOnlineSearchResultListener iPoiOnlineSearchResultListener) {
        OnlinePoiSDSTarget.unregisterPoiOnlineSearchResultListener(iPoiOnlineSearchResultListener);
    }

    @Override
    public void startVoiceOnlinePoiSearch() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1589103360);
        eventGeneric.setReceiverTargetId(-850717696);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void getValueListBlock(int n, int n2) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setReceiverEventId(-1572326144);
        eventGeneric.setReceiverTargetId(-850717696);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public boolean isOnlinePoiReady() {
        return OnlinePoiSDSTarget.isOnlinePoiReady() && OnlinePoiTarget.isOnlinePoiReady();
    }

    @Override
    public void stopOnlinePoiSearch() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1555548928);
        eventGeneric.setReceiverTargetId(-850717696);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void resolveOnlineEntry(IOnlinePoiListElement iOnlinePoiListElement) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setObject(0, iOnlinePoiListElement);
        eventGeneric.setReceiverEventId(-1538771712);
        eventGeneric.setReceiverTargetId(-850717696);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void startOnboardPoiSearch(long l, int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setLong(0, l);
        eventGeneric.setInt(1, n);
        eventGeneric.setReceiverEventId(29954112);
        eventGeneric.setReceiverTargetId(1598755840);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void getOnboardValueListBlock(int n, int n2) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setReceiverEventId(-1521994496);
        eventGeneric.setReceiverTargetId(1598755840);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void registerPoiOnboardSearchResultListener(IPoiOnboardSearchResultListener iPoiOnboardSearchResultListener) {
        PoiHsmTarget.registerPoiOnboardSearchResultListener(iPoiOnboardSearchResultListener);
    }

    @Override
    public void unregisterPoiOnboardSearchResultListener(IPoiOnboardSearchResultListener iPoiOnboardSearchResultListener) {
        PoiHsmTarget.unregisterPoiOnboardSearchResultListener(iPoiOnboardSearchResultListener);
    }

    @Override
    public long[] getTopPoiCategoryUids() {
        return PoiDatapool.getInstance().getTopPoiCategoryUids();
    }

    @Override
    public void selectOnboardEntry(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        eventGeneric.setReceiverEventId(-1505217280);
        eventGeneric.setReceiverTargetId(1598755840);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public int calculateOnboardDirectionIndex(LIValueListElement lIValueListElement) {
        return PoiAbstractElementCommon.calculateDirectionIndex(lIValueListElement);
    }

    @Override
    public int calculateOnboardDistance(LIValueListElement lIValueListElement) {
        return PoiAbstractElementCommon.calculateDistance(lIValueListElement);
    }

    @Override
    public void updateSearchLocation() {
        if (this.onlinePoiTarget != null) {
            this.onlinePoiTarget.updateSearchPosition();
        }
    }

    @Override
    public void dynPoi2Service(int n, NavigationOnlinePoiListener navigationOnlinePoiListener) {
        if (!ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("DynpoiDsiRequest")) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setReceiverEventId(-1471662848);
            eventGeneric.setReceiverTargetId(-1807019008);
            eventGeneric.setInt(0, n);
            eventGeneric.setObject(1, navigationOnlinePoiListener);
            ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        } else {
            String string = (String)dynPoiServiceIds.get(n);
            navigationOnlinePoiListener.updateDynPoi2ServiceID(n, string);
        }
    }

    @Override
    public void initXt9Finished() {
        if (this.onlinePoiTarget != null) {
            this.onlinePoiTarget.initXt9Finished();
        }
    }

    @Override
    public void initXt9OnboardFinished() {
        if (this.poiTarget != null) {
            this.poiTarget.initXt9OnboardFinished();
        }
    }

    @Override
    public String getSelectedOnlinePoiUrl() {
        if (this.onlinePoiTarget != null) {
            return this.onlinePoiTarget.getSelectedOnlinePoiUrl();
        }
        return "";
    }

    @Override
    public String getLastServiceIdString() {
        return this.lastServiceIdString;
    }

    @Override
    public void setLastServiceIdString(String string) {
        this.lastServiceIdString = string;
    }

    static {
        dynPoiServiceIds.put(1, "gasstations_v1");
        dynPoiServiceIds.put(2, "parkinfo_v1");
        dynPoiServiceIds.put(3, "fpi_v2");
        dynPoiServiceIds.put(4, "poi-echarge");
        dynPoiServiceIds.put(5, "poi-echarge");
        dynPoiServiceIds.put(6, "poi-echarge");
    }
}

