/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.poi.onboard;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.poi.ASLNavigationPoiAPI;
import de.vw.mib.asl.api.navigation.poi.ASLNavigationPoiFactory;
import de.vw.mib.asl.api.navigation.poi.IPoiOnboardSearchResultListener;
import de.vw.mib.asl.api.navigation.poi.onboard.IOnboardPoiListElement;
import de.vw.mib.asl.api.navigation.poi.onboard.NavigationOnboardPoiListener;
import de.vw.mib.asl.api.navigation.poi.onboard.NavigationOnboardPoiService;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavServiceLockable;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavigationLocationImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.NavigationExtServiceImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.poi.onboard.IOnboardPoiListElementImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.poi.onboard.NavigationOnboardPoiServiceImpl$1;
import de.vw.mib.asl.internal.navigation.api.impl.ext.poi.onboard.NavigationOnboardPoiServiceImpl$2;
import de.vw.mib.asl.internal.navigation.util.WeakIdentityHashSet;
import java.util.Iterator;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.ValueListStatus;

public class NavigationOnboardPoiServiceImpl
implements NavigationOnboardPoiService,
INavServiceLockable {
    static WeakIdentityHashSet serviceInstances = new WeakIdentityHashSet();
    private static final int DEFAULT_TIMEOUT;
    NavigationOnboardPoiListener listener;
    NavigationExtServiceImpl navigationExtServiceImpl;
    static IPoiOnboardSearchResultListener liResults;

    static void notifyPoiResult(NavLocation navLocation) {
        block1: {
            NavigationOnboardPoiListener navigationOnboardPoiListener;
            Iterator iterator = serviceInstances.iterator();
            if (!iterator.hasNext()) break block1;
            NavigationOnboardPoiServiceImpl navigationOnboardPoiServiceImpl = (NavigationOnboardPoiServiceImpl)iterator.next();
            if (navigationOnboardPoiServiceImpl.navigationExtServiceImpl.locationInputLockOwner instanceof NavigationOnboardPoiServiceImpl && (navigationOnboardPoiListener = ((NavigationOnboardPoiServiceImpl)navigationOnboardPoiServiceImpl.navigationExtServiceImpl.locationInputLockOwner).listener) != null) {
                navigationOnboardPoiListener.resolveEntryResult(new INavigationLocationImpl(navLocation));
            }
        }
    }

    static void notifyPoiSearchStatus(ValueListStatus valueListStatus) {
        block1: {
            NavigationOnboardPoiListener navigationOnboardPoiListener;
            Iterator iterator = serviceInstances.iterator();
            if (!iterator.hasNext()) break block1;
            NavigationOnboardPoiServiceImpl navigationOnboardPoiServiceImpl = (NavigationOnboardPoiServiceImpl)iterator.next();
            if (navigationOnboardPoiServiceImpl.navigationExtServiceImpl.locationInputLockOwner instanceof NavigationOnboardPoiServiceImpl && (navigationOnboardPoiListener = ((NavigationOnboardPoiServiceImpl)navigationOnboardPoiServiceImpl.navigationExtServiceImpl.locationInputLockOwner).listener) != null) {
                navigationOnboardPoiListener.updateSearchStatus(valueListStatus.status, valueListStatus.numberOfAvailableItems, valueListStatus.distance);
            }
        }
    }

    static void notifyPoiValueList(LIValueList lIValueList, int n) {
        block2: {
            NavigationOnboardPoiListener navigationOnboardPoiListener;
            Iterator iterator = serviceInstances.iterator();
            ASLNavigationPoiAPI aSLNavigationPoiAPI = ASLNavigationPoiFactory.getNavigationPoiApi();
            if (!iterator.hasNext()) break block2;
            NavigationOnboardPoiServiceImpl navigationOnboardPoiServiceImpl = (NavigationOnboardPoiServiceImpl)iterator.next();
            if (navigationOnboardPoiServiceImpl.navigationExtServiceImpl.locationInputLockOwner instanceof NavigationOnboardPoiServiceImpl && (navigationOnboardPoiListener = ((NavigationOnboardPoiServiceImpl)navigationOnboardPoiServiceImpl.navigationExtServiceImpl.locationInputLockOwner).listener) != null && lIValueList != null && lIValueList.list != null) {
                IOnboardPoiListElement[] iOnboardPoiListElementArray = new IOnboardPoiListElement[lIValueList.list.length];
                for (int i2 = 0; i2 < lIValueList.list.length; ++i2) {
                    iOnboardPoiListElementArray[i2] = new IOnboardPoiListElementImpl(lIValueList.list[i2], aSLNavigationPoiAPI.calculateOnboardDistance(lIValueList.list[i2]), aSLNavigationPoiAPI.calculateOnboardDirectionIndex(lIValueList.list[i2]));
                    ((IOnboardPoiListElementImpl)iOnboardPoiListElementArray[i2]).image = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(lIValueList.list[i2].iconIndex, lIValueList.list[i2].subIconIndex, 0, new NavigationOnboardPoiServiceImpl$2(navigationOnboardPoiListener), iOnboardPoiListElementArray[i2]);
                }
                navigationOnboardPoiListener.valueListBlock(iOnboardPoiListElementArray, n);
            }
        }
    }

    public NavigationOnboardPoiServiceImpl(NavigationOnboardPoiListener navigationOnboardPoiListener, NavigationExtServiceImpl navigationExtServiceImpl) {
        this.listener = navigationOnboardPoiListener;
        this.navigationExtServiceImpl = navigationExtServiceImpl;
        serviceInstances.add(this);
    }

    @Override
    public void freeService() {
        serviceInstances.remove(this);
    }

    public void notifyInputState(NavLocation navLocation, int[] nArray, boolean bl, boolean bl2) {
    }

    public void notifyValueList(LIValueList lIValueList, long l) {
    }

    @Override
    public void updateLock(boolean bl) {
        try {
            this.listener.updateLock(bl);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void lock() {
        this.lockInput();
    }

    @Override
    public void lockInput() {
        this.navigationExtServiceImpl.acquireLocationinputLock(20000, this, false);
    }

    @Override
    public void weakLock() {
        this.weakLockInput();
    }

    @Override
    public void weakLockInput() {
        this.navigationExtServiceImpl.acquireLocationinputLock(20000, this, true);
    }

    @Override
    public void unlock() {
        this.unlockInput();
    }

    @Override
    public void unlockInput() {
        this.navigationExtServiceImpl.releaseLocationinputLock(this);
    }

    @Override
    public void getValueListBlock(int n, int n2) {
        this.navigationExtServiceImpl.checkLockLocationInput(this);
        ASLNavigationPoiFactory.getNavigationPoiApi().getOnboardValueListBlock(n, n2);
    }

    @Override
    public void stopPoiSearch() {
        this.navigationExtServiceImpl.checkLockLocationInput(this);
        throw new NavigationServiceException("not implemented");
    }

    @Override
    public void resolveEntry(IOnboardPoiListElement iOnboardPoiListElement) {
        this.navigationExtServiceImpl.checkLockLocationInput(this);
        ASLNavigationPoiFactory.getNavigationPoiApi().selectOnboardEntry(iOnboardPoiListElement.getIndex());
    }

    @Override
    public void startPoiSearch(long l, int n) {
        this.navigationExtServiceImpl.checkLockLocationInput(this);
        ASLNavigationPoiFactory.getNavigationPoiApi().startOnboardPoiSearch(l, n);
    }

    @Override
    public long[] getTopPoiCategoryUids() {
        return ASLNavigationPoiFactory.getNavigationPoiApi().getTopPoiCategoryUids();
    }

    static {
        liResults = new NavigationOnboardPoiServiceImpl$1();
        ASLNavigationPoiFactory.getNavigationPoiApi().registerPoiOnboardSearchResultListener(liResults);
    }
}

