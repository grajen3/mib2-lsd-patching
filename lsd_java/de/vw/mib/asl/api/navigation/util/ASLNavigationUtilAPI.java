/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.util;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
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
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.properties.values.FixFormatterFieldData;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.search.SearchResult;

public interface ASLNavigationUtilAPI {
    default public ILocationWrapper getLocationWrapper() {
    }

    default public ILocationWrapper getLocationWrapper(int n, int n2) {
    }

    default public ILocationWrapper getLocationWrapper(NavLocation navLocation) {
    }

    default public ILocationWrapper getLocationWrapper(NavSegmentID navSegmentID) {
    }

    default public ILocationWrapper getLocationWrapper(PosPosition posPosition) {
    }

    default public IExtLogger getExtLogger(AbstractTarget abstractTarget, Hsm hsm) {
    }

    default public IExtLogger getExtLogger(int n, String string) {
    }

    default public IExtLogger getExtLogger(int n, String string, boolean bl) {
    }

    default public ResourceLocator resourceIdForPOIIcon(int n, int n2, int n3, CacheClient cacheClient, Object object) {
    }

    default public ResourceLocator resourceIdForPOIIconFromRawData(int n, int n2, int n3, CacheClient cacheClient, Object object) {
    }

    default public PosPosition getPosPosition() {
    }

    default public String getLanguage() {
    }

    default public double dsiToDecimal(int n) {
    }

    default public int decimalToDsi(float f2) {
    }

    default public FixFormatterFieldData prepareFixFormatterFieldData(ILocationWrapper iLocationWrapper) {
    }

    default public FixFormatterFieldData prepareFixFormatterFieldData(SearchResult searchResult) {
    }

    default public void updateNavDetailLocationGetter(NavLocation navLocation) {
    }

    default public void setDestInputLocation(NavLocation navLocation) {
    }

    default public boolean isRgActive() {
    }

    default public void resetNaviContext(String string) {
    }

    default public INavigationDP getNavigationDp() {
    }

    default public IDebugFlags getDebugFlags() {
    }

    default public ICacheHandler getCacheHandler() {
    }

    default public INavGateway getNavGateway() {
    }

    default public boolean isGatewayInstance() {
    }

    default public NavLocation constructNavLocation(double d2, double d3) {
    }

    default public NavLocation constructNavLocationDsi(int n, int n2) {
    }

    default public ILocationFormatter getLocationFormatter() {
    }

    default public NavLocation cloneLocation(NavLocation navLocation) {
    }

    default public ISpellerDataHelper getSpellerDataHelper() {
    }

    default public INaviHelper getNaviHelper() {
    }

    default public IExtLoggerHelper getExtLoggerHelper() {
    }

    default public NavLocation getFinalDestinationNavLocation() {
    }

    default public FactoryResetParticipantWithCallback createFactoryResetParticipantForFullFactoryResetAndAddToService(TargetForFullFactoryReset targetForFullFactoryReset) {
    }

    default public FactoryResetParticipantWithCallback createFactoryResetParticipantForNavigationDomainAndAddToService(TargetForResetNavigation targetForResetNavigation) {
    }

    default public void removeFullFactoryResetParticipantFromService(FactoryResetParticipantWithCallback factoryResetParticipantWithCallback) {
    }

    default public void removeNavigationResetParticipantFromService(FactoryResetParticipantWithCallback factoryResetParticipantWithCallback) {
    }

    default public AbstractResettableAslHsmTarget getTargetProfileChange() {
    }

    default public boolean isPreviousRoutePresent() {
    }
}

