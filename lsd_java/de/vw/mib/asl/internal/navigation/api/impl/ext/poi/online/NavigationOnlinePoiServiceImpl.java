/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.poi.online;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.poi.ASLNavigationPoiFactory;
import de.vw.mib.asl.api.navigation.poi.IPoiOnlineSearchResultListener;
import de.vw.mib.asl.api.navigation.poi.online.IOnlinePoiListElement;
import de.vw.mib.asl.api.navigation.poi.online.NavigationOnlinePoiListener;
import de.vw.mib.asl.api.navigation.poi.online.NavigationOnlinePoiService;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavServiceLockable;
import de.vw.mib.asl.internal.navigation.api.impl.ext.NavigationExtServiceImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.poi.online.NavigationOnlinePoiServiceImpl$1;
import de.vw.mib.asl.internal.navigation.util.WeakIdentityHashSet;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;

public class NavigationOnlinePoiServiceImpl
implements NavigationOnlinePoiService,
INavServiceLockable {
    static WeakIdentityHashSet serviceInstances = new WeakIdentityHashSet();
    private static final int DEFAULT_TIMEOUT;
    NavigationOnlinePoiListener listener;
    NavigationExtServiceImpl navigationExtServiceImpl;
    static IPoiOnlineSearchResultListener liResults;

    public NavigationOnlinePoiServiceImpl(NavigationOnlinePoiListener navigationOnlinePoiListener, NavigationExtServiceImpl navigationExtServiceImpl) {
        this.listener = navigationOnlinePoiListener;
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
        if (!this.isServiceReady()) {
            throw new NavigationServiceException("online service not ready!!!");
        }
        this.navigationExtServiceImpl.acquireLocationinputLock(20000, this, false);
    }

    @Override
    public void weakLock() {
        this.weakLockInput();
    }

    @Override
    public void weakLockInput() {
        if (!this.isServiceReady()) {
            throw new NavigationServiceException("online service not ready!!!");
        }
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
    public void startVoicePoiSearch() {
        this.navigationExtServiceImpl.checkLockLocationInput(this);
        ASLNavigationPoiFactory.getNavigationPoiApi().startVoiceOnlinePoiSearch();
    }

    @Override
    public void getValueListBlock(int n, int n2) {
        this.navigationExtServiceImpl.checkLockLocationInput(this);
        ASLNavigationPoiFactory.getNavigationPoiApi().getValueListBlock(n, n2);
    }

    @Override
    public void stopPoiSearch() {
        this.navigationExtServiceImpl.checkLockLocationInput(this);
        ASLNavigationPoiFactory.getNavigationPoiApi().stopOnlinePoiSearch();
    }

    @Override
    public void resolveEntry(IOnlinePoiListElement iOnlinePoiListElement) {
        this.navigationExtServiceImpl.checkLockLocationInput(this);
        ASLNavigationPoiFactory.getNavigationPoiApi().resolveOnlineEntry(iOnlinePoiListElement);
    }

    @Override
    public void dynPoi2Service(int n) {
        ASLNavigationPoiFactory.getNavigationPoiApi().dynPoi2Service(n, this.listener);
    }

    @Override
    public boolean isServiceReady() {
        return ASLNavigationPoiFactory.getNavigationPoiApi().isOnlinePoiReady();
    }

    static {
        liResults = new NavigationOnlinePoiServiceImpl$1();
        ASLNavigationPoiFactory.getNavigationPoiApi().registerPoiOnlineSearchResultListener(liResults);
    }
}

