/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util.api.impl;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationContainer;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilAPI;
import de.vw.mib.asl.api.navigation.util.ICacheHandler;
import de.vw.mib.asl.api.navigation.util.IDebugFlags;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.IExtLoggerHelper;
import de.vw.mib.asl.api.navigation.util.ILocationFormatter;
import de.vw.mib.asl.api.navigation.util.INaviHelper;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.api.navigation.util.ISpellerDataHelper;
import de.vw.mib.asl.api.navigation.util.factoryreset.FactoryResetParticipantWithCallback;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForFullFactoryReset;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForResetNavigation;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.ASLNavigationDP;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.HsmCacheHandler;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.gateway.NavGateway;
import de.vw.mib.asl.internal.navigation.util.ExtLoggerHelper;
import de.vw.mib.asl.internal.navigation.util.ExtLoggerImpl;
import de.vw.mib.asl.internal.navigation.util.GuidanceHelper;
import de.vw.mib.asl.internal.navigation.util.LocationFormatter;
import de.vw.mib.asl.internal.navigation.util.LocationHelper;
import de.vw.mib.asl.internal.navigation.util.LocationWrapper;
import de.vw.mib.asl.internal.navigation.util.NaviHelper;
import de.vw.mib.asl.internal.navigation.util.api.impl.CacheHandlerImpl;
import de.vw.mib.asl.internal.navigation.util.api.impl.IDebugFlagsImpl;
import de.vw.mib.asl.internal.navigation.util.api.impl.ILocationFormatterImpl;
import de.vw.mib.asl.internal.navigation.util.api.impl.ISpellerDataHelperImpl;
import de.vw.mib.asl.internal.navigation.util.factoryreset.ResetParticipantFactory;
import de.vw.mib.asl.internal.navigation.util.personalization.HsmTargetProfileChange;
import de.vw.mib.asl.internal.navigation.util.update.MapRegionalUpdateTargetHSM;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.properties.values.FixFormatterFieldData;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.search.SearchResult;

public class ASLNavigationUtilAPIImpl
implements ASLNavigationUtilAPI,
ASLNavigationContainer {
    ISpellerDataHelper mySpellerDataHelper = new ISpellerDataHelperImpl();
    private HsmTargetProfileChange targetProfileChange;
    private IDebugFlags flags = new IDebugFlagsImpl();
    ICacheHandler cacheHandler = new CacheHandlerImpl();
    ILocationFormatter myLocationFormatter = new ILocationFormatterImpl();

    public ASLNavigationUtilAPIImpl() {
        ASLNavigationStartupFactory.getNavigationStartupApi().registerContainer(this);
    }

    @Override
    public ILocationWrapper getLocationWrapper() {
        return new LocationWrapper();
    }

    @Override
    public ILocationWrapper getLocationWrapper(int n, int n2) {
        return new LocationWrapper(n, n2);
    }

    @Override
    public ILocationWrapper getLocationWrapper(NavLocation navLocation) {
        return new LocationWrapper(navLocation);
    }

    @Override
    public ILocationWrapper getLocationWrapper(NavSegmentID navSegmentID) {
        return new LocationWrapper(navSegmentID);
    }

    @Override
    public ILocationWrapper getLocationWrapper(PosPosition posPosition) {
        return new LocationWrapper(posPosition);
    }

    @Override
    public IExtLogger getExtLogger(AbstractTarget abstractTarget, Hsm hsm) {
        return new ExtLoggerImpl(abstractTarget, hsm);
    }

    @Override
    public IExtLogger getExtLogger(int n, String string) {
        return new ExtLoggerImpl(n, string);
    }

    @Override
    public IExtLogger getExtLogger(int n, String string, boolean bl) {
        return new ExtLoggerImpl(n, string, bl);
    }

    @Override
    public PosPosition getPosPosition() {
        return NavGateway.getInstance().getSoPosPosition();
    }

    @Override
    public String getLanguage() {
        return NavGateway.getInstance().getLanguage();
    }

    @Override
    public FixFormatterFieldData prepareFixFormatterFieldData(ILocationWrapper iLocationWrapper) {
        return LocationFormatter.prepareFixFormatterFieldData(iLocationWrapper);
    }

    @Override
    public void setDestInputLocation(NavLocation navLocation) {
        ASLNavigationDP.getInstance().setDestInputLocation(navLocation);
    }

    @Override
    public boolean isRgActive() {
        return NavGateway.getInstance().isRgActive();
    }

    @Override
    public FixFormatterFieldData prepareFixFormatterFieldData(SearchResult searchResult) {
        return LocationFormatter.prepareFixFormatterFieldData(searchResult);
    }

    @Override
    public void updateNavDetailLocationGetter(NavLocation navLocation) {
        LocationFormatter.updateNavDetailLocationGetter(navLocation);
    }

    @Override
    public INavigationDP getNavigationDp() {
        return ASLNavigationDP.getInstance();
    }

    @Override
    public IDebugFlags getDebugFlags() {
        return this.flags;
    }

    @Override
    public ICacheHandler getCacheHandler() {
        return this.cacheHandler;
    }

    @Override
    public INavGateway getNavGateway() {
        return NavGateway.getInstance();
    }

    @Override
    public boolean isGatewayInstance() {
        return NavGateway.isInstance();
    }

    @Override
    public NavLocation constructNavLocation(double d2, double d3) {
        return new LocationWrapper(NaviHelper.getInstance().decimalToDsi(d2), NaviHelper.getInstance().decimalToDsi(d3)).getLocation();
    }

    @Override
    public ILocationFormatter getLocationFormatter() {
        return this.myLocationFormatter;
    }

    @Override
    public ISpellerDataHelper getSpellerDataHelper() {
        return this.mySpellerDataHelper;
    }

    @Override
    public NavLocation cloneLocation(NavLocation navLocation) {
        return LocationHelper.cloneLocation(navLocation);
    }

    @Override
    public INaviHelper getNaviHelper() {
        return NaviHelper.getInstance();
    }

    @Override
    public IExtLoggerHelper getExtLoggerHelper() {
        return ExtLoggerHelper.getInstance();
    }

    @Override
    public NavLocation getFinalDestinationNavLocation() {
        return GuidanceHelper.getFinalDestinationNavLocation();
    }

    @Override
    public void createTargets() {
        GenericEvents genericEvents = ServiceManager.eventMain;
        String string = "hsmtask";
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(0, new HsmCacheHandler(genericEvents, 1967854592, string));
        this.targetProfileChange = new HsmTargetProfileChange(genericEvents, -833940480, string);
        this.targetProfileChange.triggerMe(106);
        this.targetProfileChange.triggerMe(-1987444480);
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(75)) {
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(0, new MapRegionalUpdateTargetHSM(genericEvents, -766831616, string));
        }
    }

    @Override
    public ResourceLocator resourceIdForPOIIcon(int n, int n2, int n3, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resourceIdForPOIIcon(n, n2, n3, cacheClient, object);
    }

    @Override
    public ResourceLocator resourceIdForPOIIconFromRawData(int n, int n2, int n3, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resourceIdForPOIIconFromRawData(n, n2, n3, cacheClient, object);
    }

    @Override
    public double dsiToDecimal(int n) {
        return this.getNaviHelper().dsiToDecimal(n);
    }

    @Override
    public int decimalToDsi(float f2) {
        return this.getNaviHelper().decimalToDsi(f2);
    }

    @Override
    public void resetNaviContext(String string) {
        this.getNaviHelper().resetNaviContext(string);
    }

    @Override
    public FactoryResetParticipantWithCallback createFactoryResetParticipantForFullFactoryResetAndAddToService(TargetForFullFactoryReset targetForFullFactoryReset) {
        ResetParticipantFactory resetParticipantFactory = ResetParticipantFactory.getInstance();
        return resetParticipantFactory.createFactoryResetParticipantForFullFactoryResetAndAddToService(targetForFullFactoryReset);
    }

    @Override
    public FactoryResetParticipantWithCallback createFactoryResetParticipantForNavigationDomainAndAddToService(TargetForResetNavigation targetForResetNavigation) {
        ResetParticipantFactory resetParticipantFactory = ResetParticipantFactory.getInstance();
        return resetParticipantFactory.createFactoryResetParticipantForNavigationDomainAndAddToService(targetForResetNavigation);
    }

    @Override
    public void removeFullFactoryResetParticipantFromService(FactoryResetParticipantWithCallback factoryResetParticipantWithCallback) {
        ResetParticipantFactory resetParticipantFactory = ResetParticipantFactory.getInstance();
        resetParticipantFactory.removeFullFactoryResetParticipantFromService(factoryResetParticipantWithCallback);
    }

    @Override
    public void removeNavigationResetParticipantFromService(FactoryResetParticipantWithCallback factoryResetParticipantWithCallback) {
        ResetParticipantFactory resetParticipantFactory = ResetParticipantFactory.getInstance();
        resetParticipantFactory.removeNavigationResetParticipantFromService(factoryResetParticipantWithCallback);
    }

    @Override
    public NavLocation constructNavLocationDsi(int n, int n2) {
        return new LocationWrapper(n, n2).getLocation();
    }

    @Override
    public AbstractResettableAslHsmTarget getTargetProfileChange() {
        return this.targetProfileChange;
    }

    @Override
    public boolean isPreviousRoutePresent() {
        return this.targetProfileChange.isPreviousRoutePresent();
    }
}

