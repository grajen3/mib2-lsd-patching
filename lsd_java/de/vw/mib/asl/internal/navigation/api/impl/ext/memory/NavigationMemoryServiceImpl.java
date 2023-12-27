/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.memory;

import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.guidance.IOnlineTourImportListener;
import de.vw.mib.asl.api.navigation.locationinput.ASLNavigationLocationinputFactory;
import de.vw.mib.asl.api.navigation.memory.ASLNavigationMemoryFactory;
import de.vw.mib.asl.api.navigation.memory.IUpdateListener;
import de.vw.mib.asl.api.navigation.memory.NavigationMemoryListener;
import de.vw.mib.asl.api.navigation.memory.NavigationMemoryService;
import de.vw.mib.asl.api.navigation.memory.SetHomeAddressToCcpCallback;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationLocationHelper;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavigationListElementImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavigationLocationImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.NavigationExtServiceImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.memory.NavigationMemoryServiceImpl$1;
import de.vw.mib.asl.internal.navigation.api.impl.ext.memory.NavigationMemoryServiceImpl$2;
import de.vw.mib.asl.internal.navigation.api.impl.ext.memory.NavigationMemoryServiceImpl$3;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdDmLastDestinationsGet;
import de.vw.mib.asl.internal.navigation.util.WeakIdentityHashSet;
import java.util.Iterator;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.navigation.NavRmRouteListArrayData;
import org.dsi.ifc.organizer.AdbViewSize;

public class NavigationMemoryServiceImpl
implements NavigationMemoryService,
IUpdateListener {
    static WeakIdentityHashSet serviceInstances = new WeakIdentityHashSet();
    final NavigationMemoryListener listener;
    private final NavigationExtServiceImpl navigationExtServiceImpl;
    static IOnlineTourImportListener liOnlineImportResults = new NavigationMemoryServiceImpl$1();

    static void handleAbortDownload() {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationMemoryServiceImpl navigationMemoryServiceImpl = (NavigationMemoryServiceImpl)iterator.next();
            if (navigationMemoryServiceImpl == null || navigationMemoryServiceImpl.listener == null) continue;
            try {
                navigationMemoryServiceImpl.listener.abortTourDownload();
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void notifyLastDestinations(INavigationListElement[] iNavigationListElementArray) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationMemoryServiceImpl navigationMemoryServiceImpl = (NavigationMemoryServiceImpl)iterator.next();
            if (navigationMemoryServiceImpl == null || navigationMemoryServiceImpl.listener == null) continue;
            try {
                navigationMemoryServiceImpl.listener.updateLastDestinations(iNavigationListElementArray);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void notifyTourMemoryCapacity() {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationMemoryServiceImpl navigationMemoryServiceImpl = (NavigationMemoryServiceImpl)iterator.next();
            if (navigationMemoryServiceImpl == null || navigationMemoryServiceImpl.listener == null) continue;
            try {
                navigationMemoryServiceImpl.listener.updateTourMemoryCapacity(navigationMemoryServiceImpl.getTourMemoryCapacity());
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void updateHomeAddressSetToCcpDone(boolean bl) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationMemoryServiceImpl navigationMemoryServiceImpl = (NavigationMemoryServiceImpl)iterator.next();
            if (navigationMemoryServiceImpl == null || navigationMemoryServiceImpl.listener == null) continue;
            try {
                navigationMemoryServiceImpl.listener.updateHomeAddressSetToCcpDone(bl);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void updateHomeAddressSetDone(boolean bl) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationMemoryServiceImpl navigationMemoryServiceImpl = (NavigationMemoryServiceImpl)iterator.next();
            if (navigationMemoryServiceImpl == null || navigationMemoryServiceImpl.listener == null) continue;
            try {
                navigationMemoryServiceImpl.listener.updateHomeAddressSetDone(bl);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public NavigationMemoryServiceImpl(NavigationMemoryListener navigationMemoryListener, NavigationExtServiceImpl navigationExtServiceImpl) {
        this.listener = navigationMemoryListener;
        this.navigationExtServiceImpl = navigationExtServiceImpl;
        if (navigationMemoryListener != null) {
            try {
                navigationMemoryListener.updateLastDestinations(navigationExtServiceImpl.lastDestinations);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
            try {
                navigationMemoryListener.updateTourMemoryCapacity(this.getTourMemoryCapacity());
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
        serviceInstances.add(this);
        ASLNavigationMemoryFactory.getNavigationMemoryApi().registerUpdateListener(this);
    }

    @Override
    public INavigationLocation getHomeAddress() {
        return new INavigationLocationImpl(ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup().getHomeLocation());
    }

    @Override
    public void setHomeAddress(INavigationLocation iNavigationLocation) {
        if (iNavigationLocation instanceof INavigationLocationHelper) {
            ASLNavigationLocationinputFactory.getNavigationLocationinputApi().setHomeAddress(((INavigationLocationHelper)((Object)iNavigationLocation)).getRealLocation());
        }
    }

    @Override
    public void setHomeAddressToCcp(SetHomeAddressToCcpCallback setHomeAddressToCcpCallback) {
        ASLNavigationLocationinputFactory.getNavigationLocationinputApi().setHomeAddressToCcp(setHomeAddressToCcpCallback);
    }

    @Override
    public void setHomeAddressToCcp() {
        ASLNavigationLocationinputFactory.getNavigationLocationinputApi().setHomeAddressToCcp();
    }

    @Override
    public INavigationListElement[] getLastDestinations() {
        return this.navigationExtServiceImpl.lastDestinations;
    }

    @Override
    public void getLastDestination(INavigationListElement iNavigationListElement) {
        LDListElement lDListElement;
        if (iNavigationListElement instanceof INavigationListElementImpl) {
            lDListElement = ((INavigationListElementImpl)iNavigationListElement).getLdListElement();
            if (lDListElement == null) {
                throw new NavigationServiceException(new StringBuffer().append("illegal argument: ").append(iNavigationListElement).append("not containing last destination entry").toString());
            }
        } else {
            throw new NavigationServiceException(new StringBuffer().append("illegal argument: ").append(iNavigationListElement).toString());
        }
        CmdDmLastDestinationsGet cmdDmLastDestinationsGet = new CmdDmLastDestinationsGet(this.navigationExtServiceImpl, lDListElement.id);
        cmdDmLastDestinationsGet.setBlindArgument("listener", this.listener);
        cmdDmLastDestinationsGet.setBlindArgument("req", iNavigationListElement);
        cmdDmLastDestinationsGet.execute();
    }

    @Override
    public boolean isServiceAvailable() {
        return ASLNavigationStartupFactory.getNavigationStartupApi().isNaviRunning();
    }

    @Override
    public int getTourMemoryCapacity() {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            ServiceManager.logger.trace(16384, new StringBuffer().append("getTourMemoryCapacity() - calculatedTourMemoryCapacity = ").append(ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getCalculatedTourMemoryCapacity()).append(", tourMemoryCapacity from south side = ").append(this.getTourMemoryCapacityFromSouthside()).toString());
        }
        if (ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getCalculatedTourMemoryCapacity() == null) {
            return this.getTourMemoryCapacityFromSouthside();
        }
        return ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getCalculatedTourMemoryCapacity();
    }

    protected int getTourMemoryCapacityFromSouthside() {
        NavRmRouteListArrayData navRmRouteListArrayData = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getNavRmRouteList();
        if (navRmRouteListArrayData != null && navRmRouteListArrayData.routeList != null) {
            int n = navRmRouteListArrayData.totalSlots - navRmRouteListArrayData.routeList.length;
            if (ServiceManager.logger.isTraceEnabled(16384)) {
                ServiceManager.logger.trace(16384, new StringBuffer().append("tourMemoryCapacity = ").append(n).toString());
            }
            return n;
        }
        ServiceManager.logger.warn(16384, "getTourMemoryCapacity() - routeList was null");
        return 0;
    }

    @Override
    public void importToursFromGpx(String string) {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            ServiceManager.logger.trace(16384, new StringBuffer().append("importToursFromGpx( int filename = ").append(string).append(") + ").toString());
        }
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().importToursFromGpx(string);
    }

    @Override
    public void importToursAbort() {
        throw new NavigationServiceException("not implemented");
    }

    @Override
    public void toursAvailable(int n) {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            ServiceManager.logger.trace(16384, new StringBuffer().append("updateTourMemoryCapacity( int toursAvailable = ").append(n).append(") + ").toString());
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(-1611657216, 0);
        AbstractASLHsmTarget.writeIntegerToDatapool(-1628434432, n);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setOnlineToursAvailable(n);
        if (n > 0) {
            if (this.getTourMemoryCapacity() > 0) {
                ASLNavigationGuidanceFactory.getNavigationGuidanceApi().sendEvTourModeOnlineImportAvailable();
            } else {
                ASLNavigationGuidanceFactory.getNavigationGuidanceApi().sendEvTourModeOnlineImportMemFull();
            }
        }
    }

    @Override
    public void downloadError(int n) {
        throw new NavigationServiceException("not implemented");
    }

    @Override
    public void freeService() {
        serviceInstances.remove(this);
    }

    @Override
    public void getContacts(long[] lArray, Object object) {
        ASLNavigationMemoryFactory.getNavigationMemoryApi().getOrganizerEntries(new NavigationMemoryServiceImpl$2(this), lArray, 14, object);
    }

    @Override
    public void getContactListBlock(int n, int n2, int n3, Object object) {
        ASLNavigationMemoryFactory.getNavigationMemoryApi().getOrganizerListBlock(new NavigationMemoryServiceImpl$3(this), n, n2, n3, object);
    }

    @Override
    public void invalidateContactData() {
        if (this.listener != null) {
            this.listener.invalidateContactData();
        }
    }

    @Override
    public void updateProfileDownloadState(int n, int n2, int n3) {
        if (this.listener != null) {
            try {
                this.listener.updateProfileDownloadState(n, n2, n3 == 1);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    @Override
    public void updateViewSizes(AdbViewSize adbViewSize, boolean bl) {
        if (this.listener != null && adbViewSize != null) {
            try {
                this.listener.updateViewSizes(adbViewSize.all, adbViewSize.getNavi(), adbViewSize.getPublicProfileEntries(), adbViewSize.getOnlineDestination(), bl);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    static {
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().registerListener(liOnlineImportResults);
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().registerListener(liOnlineImportResults);
    }
}

