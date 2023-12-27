/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.caching;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslTarget;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconDescriptor;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map$Entry;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.DSIIconExtractor;
import org.dsi.ifc.iconhandling.TextRenderingInfo;

public final class HsmCacheHandler
extends AbstractResettableAslTarget
implements DSIServiceStateListener {
    private static final int DEBUG_SERVICE_PRINT_CACHE;
    private static final int DEBUG_SERVICE_DELETE_CACHE;
    private static final int TIMOUT_FOR_ICON_REQUEST;
    private static final String EOL;
    private static final IExtLogger LOGGER;
    public static final int EV_INTERNAL_HANDLE;
    public static final int EV_INTERNAL_TIMER;
    private static Hashtable cache;
    private static LinkedList pending;
    private IconKey pendingRequestKey = null;
    private DSIIconExtractor dsiIconExtractor;
    private static HsmCacheHandler myTargetInstance;
    private boolean wasServiceStateListenerRegistered = false;
    private DSIListener dsiIconExtractorListener;
    static /* synthetic */ Class class$org$dsi$ifc$iconhandling$DSIIconExtractor;
    static /* synthetic */ Class class$org$dsi$ifc$iconhandling$DSIIconExtractorListener;

    public HsmCacheHandler(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        if (!this.wasServiceStateListenerRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            dSIProxy.addServiceStateListener(class$org$dsi$ifc$iconhandling$DSIIconExtractor == null ? (class$org$dsi$ifc$iconhandling$DSIIconExtractor = HsmCacheHandler.class$("org.dsi.ifc.iconhandling.DSIIconExtractor")) : class$org$dsi$ifc$iconhandling$DSIIconExtractor, this);
            this.wasServiceStateListenerRegistered = true;
        }
    }

    @Override
    public void registered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$iconhandling$DSIIconExtractor == null ? (class$org$dsi$ifc$iconhandling$DSIIconExtractor = HsmCacheHandler.class$("org.dsi.ifc.iconhandling.DSIIconExtractor")) : class$org$dsi$ifc$iconhandling$DSIIconExtractor).getName().intern() && !this.isFirstStartupDone) {
            this.isFirstStartupDone = true;
            this.trace(new StringBuffer().append("dsiServiceStateRegistered").append(string).append("(").append(n).append(")").toString());
            this.initDsiIconExtractor();
        }
    }

    public void initDsiIconExtractor() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiIconExtractor = (DSIIconExtractor)dSIProxy.getService(this, class$org$dsi$ifc$iconhandling$DSIIconExtractor == null ? (class$org$dsi$ifc$iconhandling$DSIIconExtractor = HsmCacheHandler.class$("org.dsi.ifc.iconhandling.DSIIconExtractor")) : class$org$dsi$ifc$iconhandling$DSIIconExtractor);
        this.dsiIconExtractorListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$iconhandling$DSIIconExtractorListener == null ? (class$org$dsi$ifc$iconhandling$DSIIconExtractorListener = HsmCacheHandler.class$("org.dsi.ifc.iconhandling.DSIIconExtractorListener")) : class$org$dsi$ifc$iconhandling$DSIIconExtractorListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$iconhandling$DSIIconExtractorListener == null ? (class$org$dsi$ifc$iconhandling$DSIIconExtractorListener = HsmCacheHandler.class$("org.dsi.ifc.iconhandling.DSIIconExtractorListener")) : class$org$dsi$ifc$iconhandling$DSIIconExtractorListener, this.dsiIconExtractorListener);
    }

    private void checkPendingRequests() {
        Object object;
        try {
            this.stopTimer(92733696);
        }
        catch (Exception exception) {
            // empty catch block
        }
        Object object2 = pending.iterator();
        while (object2.hasNext()) {
            object = (IconKey)object2.next();
            if (!cache.containsKey(object)) continue;
            try {
                if (((IconKey)object).client != null) {
                    ((IconKey)object).client.handleIconCacheUpdate((IconKey)object, ((IconDescriptor)cache.get(object)).getResourceLocator(), ((IconKey)object).arg);
                }
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
            object2.remove();
        }
        if (this.dsiIconExtractor != null) {
            try {
                if (!pending.isEmpty() && this.pendingRequestKey == null) {
                    object2 = (IconKey)pending.removeFirst();
                    switch (((IconKey)object2).type) {
                        case 2000: {
                            this.dsiIconExtractor.resourceIdForTMCEventIcon(((IconKey)object2).k0, ((IconKey)object2).k1, ((IconKey)object2).k2);
                            this.pendingRequestKey = object2;
                            break;
                        }
                        case 2008: {
                            this.dsiIconExtractor.resourceIdForAdditionalIcon(((IconKey)object2).k0, ((IconKey)object2).k1, ((IconKey)object2).k2);
                            this.pendingRequestKey = object2;
                            break;
                        }
                        case 2024: {
                            this.dsiIconExtractor.resourceIdForAdditionalTurnListIcon(((IconKey)object2).k0, ((IconKey)object2).k1, ((IconKey)object2).k2, ((IconKey)object2).k3);
                            this.pendingRequestKey = object2;
                            break;
                        }
                        case 2009: {
                            this.dsiIconExtractor.resourceIdForCountryIcon(((IconKey)object2).k0, ((IconKey)object2).k1);
                            this.pendingRequestKey = object2;
                            break;
                        }
                        case 2001: {
                            this.dsiIconExtractor.resourceIdForPOIIcon(((IconKey)object2).k0, ((IconKey)object2).k1, ((IconKey)object2).k2);
                            this.pendingRequestKey = object2;
                            break;
                        }
                        case 2026: {
                            this.dsiIconExtractor.resourceIdForPOIIconFromRawData(((IconKey)object2).k0, ((IconKey)object2).k1, ((IconKey)object2).k2);
                            this.pendingRequestKey = object2;
                            break;
                        }
                        case 2004: {
                            this.dsiIconExtractor.resourceIdForRoadClassIcon(((IconKey)object2).k0, ((IconKey)object2).k1, ((IconKey)object2).k2);
                            this.pendingRequestKey = object2;
                            break;
                        }
                        case 2003: {
                            this.dsiIconExtractor.resourceIdForTargetIcon(((IconKey)object2).k0, ((IconKey)object2).k1);
                            this.pendingRequestKey = object2;
                            break;
                        }
                        case 2005: {
                            this.dsiIconExtractor.resourceIdForTrafficRegulationIcon(((IconKey)object2).k0, ((IconKey)object2).k1, ((IconKey)object2).k2);
                            this.pendingRequestKey = object2;
                            break;
                        }
                        case 2023: {
                            this.dsiIconExtractor.resourceIdForAreaWarningIcon(((IconKey)object2).k0, ((IconKey)object2).k1);
                            this.pendingRequestKey = object2;
                            break;
                        }
                        case 2002: {
                            this.dsiIconExtractor.renderingInformationForRoadIcon(((IconKey)object2).k0, ((IconKey)object2).k1, ((IconKey)object2).k2);
                            this.pendingRequestKey = object2;
                            break;
                        }
                        case 2006: {
                            this.dsiIconExtractor.renderingInformationForExitIcon(((IconKey)object2).k0, ((IconKey)object2).k1, ((IconKey)object2).k2);
                            this.pendingRequestKey = object2;
                            break;
                        }
                        default: {
                            object = LOGGER.makeError();
                            object.append("Wrong Icon Key type received, key=");
                            object.append(((IconKey)object2).toString());
                            object.log();
                            this.pendingRequestKey = null;
                            break;
                        }
                    }
                }
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        } else {
            object2 = LOGGER.makeWarn();
            object2.append("DSIIconExtractor not yet registered ( dsiIconExtractor == null )");
            object2.log();
        }
        if (this.pendingRequestKey != null) {
            this.startTimer(92733696, (long)0, false);
        }
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                break;
            }
            case 101001: {
                if (this.isTraceEnabled()) {
                    this.trace("Target HsmCacheHandler entered NAVI_TARGET_GO_ON.");
                }
                if (this.getServiceRegister().existService(-532541696)) {
                    this.addObserver(-532541696);
                }
                if (this.getServiceRegister().existService(-515764480)) {
                    this.addObserver(-515764480);
                }
                myTargetInstance = this;
                break;
            }
            case 100100: {
                break;
            }
            case 100101: {
                if (LOGGER.isTraceEnabled()) {
                    LogMessage logMessage = LOGGER.makeError();
                    logMessage.append("received HsmCacheHandler.EV_INTERNAL_TIMER. Setting pendingRequest to null");
                    logMessage.log();
                }
                this.pendingRequestKey = null;
                break;
            }
            case 1000160: {
                if (LOGGER.isTraceEnabled()) {
                    LogMessage logMessage = LOGGER.makeTrace();
                    logMessage.append(" received DEBUG_SERVICE_DELETE_CACHE. Deleting IconCache Content.");
                    logMessage.log();
                }
                cache.clear();
                break;
            }
            case 1000161: {
                if (!LOGGER.isTraceEnabled()) break;
                LogMessage logMessage = LOGGER.makeTrace();
                logMessage.append(" received DEBUG_SERVICE_PRINT_CACHE. Printing IconCache Content.").append(EOL);
                if (cache.isEmpty()) {
                    logMessage.append(" IconCache is empty!");
                } else {
                    Iterator iterator = cache.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Object object = iterator.next();
                        Map$Entry map$Entry = (Map$Entry)object;
                        if (map$Entry.getKey() != null) {
                            logMessage.append(((IconKey)map$Entry.getKey()).toString());
                        } else {
                            logMessage.append("Key: null");
                        }
                        logMessage.append("=");
                        if (map$Entry.getValue() != null && map$Entry.getValue() instanceof IconDescriptor) {
                            IconDescriptor iconDescriptor = (IconDescriptor)map$Entry.getValue();
                            if (iconDescriptor.getResourceLocator() != null) {
                                logMessage.append(iconDescriptor.getResourceLocator().toString());
                            } else {
                                logMessage.append("ResourceLocator: null");
                            }
                        }
                        logMessage.append(EOL);
                    }
                }
                logMessage.log();
                break;
            }
        }
        this.checkPendingRequests();
    }

    public void dsiIconExtractorResourceIdForTMCEventIcon(ResourceLocator resourceLocator) {
        this.handleDsiIconExtractor(resourceLocator, null, 2000);
    }

    public void dsiIconExtractorResourceIdForAdditionalIcon(ResourceLocator resourceLocator) {
        this.handleDsiIconExtractor(resourceLocator, null, 2008);
    }

    public void dsiIconExtractorRenderingInformationForExitIcon(ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo) {
        this.handleDsiIconExtractor(resourceLocator, textRenderingInfo, 2006);
    }

    public void dsiIconExtractorResourceIdForAdditionalTurnListIconResult(ResourceLocator resourceLocator) {
        this.handleDsiIconExtractor(resourceLocator, null, 2024);
    }

    public void dsiIconExtractorResourceIdForCountryIcon(ResourceLocator resourceLocator) {
        this.handleDsiIconExtractor(resourceLocator, null, 2009);
    }

    public void dsiIconExtractorResourceIdForPOIIcon(ResourceLocator resourceLocator) {
        this.handleDsiIconExtractor(resourceLocator, null, 2001);
    }

    public void dsiIconExtractorResourceIdForPOIIconFromRawDataResult(ResourceLocator resourceLocator) {
        this.handleDsiIconExtractor(resourceLocator, null, 2026);
    }

    public void dsiIconExtractorResourceIdForRoadClassIcon(ResourceLocator resourceLocator) {
        this.handleDsiIconExtractor(resourceLocator, null, 2004);
    }

    public void dsiIconExtractorResourceIdForTargetIcon(ResourceLocator resourceLocator) {
        this.handleDsiIconExtractor(resourceLocator, null, 2003);
    }

    public void dsiIconExtractorResourceIdForTrafficRegulationIcon(ResourceLocator resourceLocator) {
        this.handleDsiIconExtractor(resourceLocator, null, 2005);
    }

    public void dsiIconExtractorResourceIdForAreaWarningIconResult(ResourceLocator resourceLocator) {
        this.handleDsiIconExtractor(resourceLocator, null, 2023);
    }

    public void dsiIconExtractorRenderingInformationForRoadIcon(ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo) {
        TextRenderingInfo textRenderingInfo2 = textRenderingInfo;
        if (null == textRenderingInfo2) {
            textRenderingInfo2 = new TextRenderingInfo();
        }
        this.handleDsiIconExtractor(resourceLocator, textRenderingInfo2, 2002);
    }

    private void handleDsiIconExtractor(ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo, int n) {
        this.stopTimer(92733696);
        if (this.pendingRequestKey != null && this.pendingRequestKey.type == n) {
            if (resourceLocator == null) {
                if (this.pendingRequestKey.client == null) {
                    resourceLocator = new ResourceLocator();
                } else {
                    try {
                        resourceLocator = this.pendingRequestKey.client.getDefaultIcon();
                    }
                    catch (Exception exception) {
                        ServiceManager.errorHandler.handleError(exception);
                        resourceLocator = new ResourceLocator();
                    }
                }
            }
            if (LOGGER.isTraceEnabled()) {
                LogMessage logMessage = LOGGER.makeTrace();
                logMessage.append(" Adding ResourceLocator into HashMap. pendingRequestKey/resourceLocator");
                logMessage.append(this.pendingRequestKey.toString()).append("/").append(resourceLocator != null ? resourceLocator.toString() : "null");
                logMessage.log();
            }
            cache.put(this.pendingRequestKey, new IconDescriptor(resourceLocator, textRenderingInfo));
            try {
                this.pendingRequestKey.client.handleIconCacheUpdate(this.pendingRequestKey, resourceLocator, this.pendingRequestKey.arg);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        } else {
            LogMessage logMessage = LOGGER.makeError();
            logMessage.append(" Did not add ResourceLocator into HashMap. pendingRequestKey/resourceLocator ");
            logMessage.append(this.pendingRequestKey).append("/").append(resourceLocator).append(" ").append(n).append(" != ").append(this.pendingRequestKey != null ? this.pendingRequestKey.type : 0);
            logMessage.log();
        }
        this.pendingRequestKey = null;
        this.checkPendingRequests();
    }

    public void dsiIconExtractorAsyncException(int n, String string, int n2) {
        LOGGER.makeError().append("dsiIconExtractorAsyncException() - errorCode=").append(n).append(", errorMessage=").append(string).append(", requestType=").append(n2).log();
        this.pendingRequestKey = null;
    }

    private static ResourceLocator resolveResourceLocator(IconKey iconKey) {
        if (cache.containsKey(iconKey)) {
            return ((IconDescriptor)cache.get(iconKey)).getResourceLocator();
        }
        if (LOGGER.isTraceEnabled()) {
            LogMessage logMessage = LOGGER.makeTrace();
            logMessage.append("Key is not in cache. Queuing request: ");
            if (iconKey != null) {
                logMessage.append(iconKey.toString());
            } else {
                logMessage.append("null");
            }
            logMessage.log();
        }
        pending.add(iconKey);
        if (myTargetInstance != null) {
            try {
                myTargetInstance.triggerMe(75956480);
            }
            catch (GenericEventException genericEventException) {
                ServiceManager.logger.error(16384, genericEventException.toString());
            }
        }
        if (iconKey == null || iconKey.client == null) {
            return null;
        }
        try {
            return iconKey.client.getDefaultIcon();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    private static IconDescriptor resolveResourceLocatorTextInfo(IconKey iconKey) {
        if (cache.containsKey(iconKey)) {
            return (IconDescriptor)cache.get(iconKey);
        }
        pending.add(iconKey);
        if (myTargetInstance != null) {
            try {
                myTargetInstance.triggerMe(75956480);
            }
            catch (GenericEventException genericEventException) {
                ServiceManager.logger.error(16384, genericEventException.toString());
            }
        }
        try {
            return new IconDescriptor(iconKey.client.getDefaultIcon(), new TextRenderingInfo());
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public static TextRenderingInfo getTextRenderingInfo(IconKey iconKey) {
        if (cache.containsKey(iconKey)) {
            return ((IconDescriptor)cache.get(iconKey)).getTextRenderingInfo();
        }
        return null;
    }

    public static ResourceLocator resourceIdForTMCEventIcon(int n, int n2, int n3, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resolveResourceLocator(new IconKey(2000, n, n2, n3, cacheClient, object));
    }

    public static ResourceLocator resourceIdForAdditionalIcon(int n, int n2, int n3, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resolveResourceLocator(new IconKey(2008, n, n2, n3, cacheClient, object));
    }

    public static ResourceLocator resourceIdForAdditionalTurnlistIcon(int n, int n2, int n3, int n4, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resolveResourceLocator(new IconKey(2024, n, n2, n3, n4, cacheClient, object));
    }

    public static ResourceLocator resourceIdForCountryIcon(int n, int n2, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resolveResourceLocator(new IconKey(2009, n, n2, 0, cacheClient, object));
    }

    public static ResourceLocator resourceIdForPOIIcon(int n, int n2, int n3, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resolveResourceLocator(new IconKey(2001, n, n2, n3, cacheClient, object));
    }

    public static ResourceLocator resourceIdForPOIIconFromRawData(int n, int n2, int n3, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resolveResourceLocator(new IconKey(2026, n, n2, n3, cacheClient, object));
    }

    public static ResourceLocator resourceIdForRoadClassIcon(int n, int n2, int n3, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resolveResourceLocator(new IconKey(2004, n, n2, n3, cacheClient, object));
    }

    public static ResourceLocator resourceIdForTargetIcon(int n, int n2, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resolveResourceLocator(new IconKey(2003, n, n2, 0, cacheClient, object));
    }

    public static ResourceLocator resourceIdForTrafficRegulationIcon(int n, int n2, int n3, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resolveResourceLocator(new IconKey(2005, n, n2, n3, cacheClient, object));
    }

    public static ResourceLocator resourceIdForAreaWarningIcon(int n, int n2, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resolveResourceLocator(new IconKey(2023, n, n2, cacheClient, object));
    }

    public static IconDescriptor resourceIdForRoadIcon(int n, int n2, int n3, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resolveResourceLocatorTextInfo(new IconKey(2002, n, n2, n3, cacheClient, object));
    }

    public static IconDescriptor resourceIdForExitIcon(int n, int n2, int n3, CacheClient cacheClient, Object object) {
        return HsmCacheHandler.resolveResourceLocatorTextInfo(new IconKey(2006, n, n2, n3, cacheClient, object));
    }

    @Override
    public void unregistered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$iconhandling$DSIIconExtractor == null ? (class$org$dsi$ifc$iconhandling$DSIIconExtractor = HsmCacheHandler.class$("org.dsi.ifc.iconhandling.DSIIconExtractor")) : class$org$dsi$ifc$iconhandling$DSIIconExtractor).getName().intern()) {
            if (this.isTraceEnabled()) {
                this.trace().append("HsmCacheHandler tries to unregister from ").append(string).append("...").log();
            }
            try {
                if (this.dsiIconExtractorListener != null) {
                    DSIProxyFactory.getDSIProxyAPI().getDSIProxy().removeResponseListener(this, class$org$dsi$ifc$iconhandling$DSIIconExtractorListener == null ? (class$org$dsi$ifc$iconhandling$DSIIconExtractorListener = HsmCacheHandler.class$("org.dsi.ifc.iconhandling.DSIIconExtractorListener")) : class$org$dsi$ifc$iconhandling$DSIIconExtractorListener, this.dsiIconExtractorListener);
                    this.dsiIconExtractorListener = null;
                }
                this.stopTimer(92733696);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleDsiError(exception);
            }
        }
    }

    public static void clearCache() {
        if (myTargetInstance != null) {
            try {
                myTargetInstance.triggerMe(-532541696);
            }
            catch (GenericEventException genericEventException) {
                ServiceManager.logger.error(16384, genericEventException.toString());
            }
        }
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$iconhandling$DSIIconExtractor == null ? (class$org$dsi$ifc$iconhandling$DSIIconExtractor = HsmCacheHandler.class$("org.dsi.ifc.iconhandling.DSIIconExtractor")) : class$org$dsi$ifc$iconhandling$DSIIconExtractor).getName(), 0)) {
            if (this.isTraceEnabled()) {
                this.trace("HsmCacheHandler: resetting values after DSI restart");
            }
            this.initLocalVariables();
            this.initDsiIconExtractor();
        } else if (this.isTraceEnabled()) {
            this.trace("HsmCacheHandler: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initLocalVariables() {
        this.pendingRequestKey = null;
        cache.clear();
        this.startTimer(92733696, (long)0, false);
    }

    @Override
    public int getSubClassifier() {
        return 16384;
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
        EOL = System.getProperty("line.separator");
        LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[HsmCacheHandler]");
        cache = new Hashtable();
        pending = new LinkedList();
        myTargetInstance = null;
    }
}

