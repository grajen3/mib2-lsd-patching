/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.traffic;

import de.vw.mib.asl.api.navigation.traffic.INavRectangle;
import de.vw.mib.asl.api.navigation.traffic.INavigationTunerData;
import de.vw.mib.asl.api.navigation.traffic.ITmcMessage;
import de.vw.mib.asl.api.navigation.traffic.ITrafficSource;
import de.vw.mib.asl.api.navigation.traffic.NavigationTrafficListener;
import de.vw.mib.asl.api.navigation.traffic.NavigationTrafficService;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.api.impl.ext.NavigationExtServiceImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.traffic.IResourceLocatorExternImpl;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.util.WeakIdentityHashSet;
import java.util.Iterator;
import org.dsi.ifc.global.ResourceLocator;

public class NavigationTrafficServiceImpl
implements NavigationTrafficService,
CacheClient {
    private static final int ICON_CACHE_ID_NAVIGATION_TRAFFIC_SERVICE_ICON_TYPE_TMC_ICON;
    private static final int ICON_CACHE_ID_NAVIGATION_TRAFFIC_SERVICE_ICON_TYPE_AREA_WARNING_ICON;
    private static INavigationTunerData[] myReceivableStations;
    private static boolean myReceivableStationsFlag;
    private static WeakIdentityHashSet serviceInstances;
    NavigationTrafficListener listener;
    NavigationExtServiceImpl navigationExtServiceImpl;
    static /* synthetic */ Class array$Ljava$lang$Object;

    public static void updateReceivableStations(INavigationTunerData[] iNavigationTunerDataArray, boolean bl) {
        myReceivableStations = iNavigationTunerDataArray;
        myReceivableStationsFlag = bl;
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationTrafficServiceImpl navigationTrafficServiceImpl = (NavigationTrafficServiceImpl)iterator.next();
            if (navigationTrafficServiceImpl == null || navigationTrafficServiceImpl.listener == null) continue;
            navigationTrafficServiceImpl.listener.updateReceivableStations(iNavigationTunerDataArray, bl);
        }
    }

    public NavigationTrafficServiceImpl(NavigationTrafficListener navigationTrafficListener, NavigationExtServiceImpl navigationExtServiceImpl) {
        this.listener = navigationTrafficListener;
        this.navigationExtServiceImpl = navigationExtServiceImpl;
        serviceInstances.add(this);
    }

    @Override
    public void requestReceivableStations() {
        this.listener.updateReceivableStations(myReceivableStations, myReceivableStationsFlag);
    }

    @Override
    public void freeService() {
        serviceInstances.remove(this);
    }

    public static void updateTrafficSourceInformation(ITrafficSource[] iTrafficSourceArray, boolean bl) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationTrafficServiceImpl navigationTrafficServiceImpl = (NavigationTrafficServiceImpl)iterator.next();
            if (navigationTrafficServiceImpl == null || navigationTrafficServiceImpl.listener == null) continue;
            navigationTrafficServiceImpl.listener.updateTrafficSourceInformation(iTrafficSourceArray, bl);
        }
    }

    public static void updateUrgentMessages(ITmcMessage[] iTmcMessageArray, boolean bl) {
        Iterator iterator = serviceInstances.iterator();
        if (ServiceManager.logger.isTraceEnabled(16)) {
            ServiceManager.logger.trace(16, new StringBuffer().append("updateUrgentMessages() - serviceInstances = ").append(serviceInstances.size()).toString());
        }
        while (iterator.hasNext()) {
            NavigationTrafficServiceImpl navigationTrafficServiceImpl = (NavigationTrafficServiceImpl)iterator.next();
            if (navigationTrafficServiceImpl != null && navigationTrafficServiceImpl.listener != null) {
                if (ServiceManager.logger.isTraceEnabled(16)) {
                    ServiceManager.logger.trace(16, new StringBuffer().append("calling updateUrgentMessages() with myUrgentMessages = ").append(iTmcMessageArray).append(" and valid = ").append(bl).toString());
                }
                navigationTrafficServiceImpl.listener.updateUrgentMessages(iTmcMessageArray, bl);
                continue;
            }
            if (!ServiceManager.logger.isTraceEnabled(16)) continue;
            ServiceManager.logger.trace(16, "updateUrgentMessages() - no listener registered.");
        }
    }

    public static void indicateTrafficEventNoticeMap(ITmcMessage iTmcMessage, INavRectangle iNavRectangle, int n) {
        Iterator iterator = serviceInstances.iterator();
        if (ServiceManager.logger.isTraceEnabled(16)) {
            ServiceManager.logger.trace(16, new StringBuffer().append("indicateTrafficEventNoticeMap() - serviceInstances = ").append(serviceInstances.size()).toString());
        }
        while (iterator.hasNext()) {
            NavigationTrafficServiceImpl navigationTrafficServiceImpl = (NavigationTrafficServiceImpl)iterator.next();
            if (navigationTrafficServiceImpl != null && navigationTrafficServiceImpl.listener != null) {
                if (ServiceManager.logger.isTraceEnabled(16)) {
                    ServiceManager.logger.trace(16, new StringBuffer().append("calling indicateTrafficEventNoticeMap() with myMessage = ").append(iTmcMessage).append(", myRectangle = ").append(iNavRectangle).append(" and soundID = ").append(n).toString());
                }
                navigationTrafficServiceImpl.listener.indicateTrafficEventNoticeMap(iTmcMessage, iNavRectangle, n);
                continue;
            }
            if (!ServiceManager.logger.isTraceEnabled(16)) continue;
            ServiceManager.logger.trace(16, "indicateTrafficEventNoticeMap() - no listener registered.");
        }
    }

    @Override
    public void resourceIdForTMCEventIcon(int n, int n2, int n3) {
        ResourceLocator resourceLocator = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForTMCEventIcon(n, n2, n3, this, new Object[]{new Integer(0)});
        if (resourceLocator != null) {
            this.updateNewResourceLocatorForTMCIcon(resourceLocator);
        }
    }

    @Override
    public void resourceIdForAreaWarningIcon(int n, int n2) {
        ResourceLocator resourceLocator = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForAreaWarningIcon(n, n2, this, new Object[]{new Integer(1)});
        if (resourceLocator != null) {
            this.updateNewResourceLocatorForAreaWarningIcon(resourceLocator);
        }
    }

    private void updateNewResourceLocatorForTMCIcon(ResourceLocator resourceLocator) {
        IResourceLocatorExternImpl iResourceLocatorExternImpl = new IResourceLocatorExternImpl(resourceLocator);
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationTrafficServiceImpl navigationTrafficServiceImpl = (NavigationTrafficServiceImpl)iterator.next();
            if (navigationTrafficServiceImpl == null || navigationTrafficServiceImpl.listener == null) continue;
            navigationTrafficServiceImpl.listener.updateResourceIdForTMCEventIcon(iResourceLocatorExternImpl);
        }
    }

    private void updateNewResourceLocatorForAreaWarningIcon(ResourceLocator resourceLocator) {
        IResourceLocatorExternImpl iResourceLocatorExternImpl = new IResourceLocatorExternImpl(resourceLocator);
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationTrafficServiceImpl navigationTrafficServiceImpl = (NavigationTrafficServiceImpl)iterator.next();
            if (navigationTrafficServiceImpl == null || navigationTrafficServiceImpl.listener == null) continue;
            navigationTrafficServiceImpl.listener.updateResourceIdForAreaWarningIconResult(iResourceLocatorExternImpl);
        }
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        if (object.getClass() == (array$Ljava$lang$Object == null ? (array$Ljava$lang$Object = NavigationTrafficServiceImpl.class$("[Ljava.lang.Object;")) : array$Ljava$lang$Object)) {
            Object[] objectArray = (Object[])object;
            int n = (Integer)objectArray[0];
            switch (n) {
                case 0: {
                    this.updateNewResourceLocatorForTMCIcon(resourceLocator);
                    break;
                }
                case 1: {
                    this.updateNewResourceLocatorForAreaWarningIcon(resourceLocator);
                    break;
                }
            }
        }
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
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
        myReceivableStations = new INavigationTunerData[0];
        myReceivableStationsFlag = false;
        serviceInstances = new WeakIdentityHashSet();
    }
}

