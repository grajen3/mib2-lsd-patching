/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.homescreen.HomeScreenPages;
import de.vw.mib.asl.api.homescreen.HomeScreenPages$Page;
import de.vw.mib.asl.api.homescreen.HomescreenPageListener;
import de.vw.mib.asl.internal.homescreen.HomeScreenServices;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenPagesImpl$ModelListener;
import de.vw.mib.asl.internal.impl.homescreen.PageUtil;
import de.vw.mib.asl.internal.impl.homescreen.util.Preconditions;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.GenericEvents;
import edu.emory.mathcs.backport.java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;

public class HomeScreenPagesImpl
implements HomeScreenPages {
    private HomeScreenPages$Page activePage = HomeScreenPages$Page.NON;
    private final HomeScreenServices services;
    private final Set listeners = Collections.newSetFromMap(new IdentityHashMap());

    public HomeScreenPagesImpl(HomeScreenServices homeScreenServices) {
        Preconditions.checkArgumentNotNull(homeScreenServices, "Argument >services< must not be null!");
        this.services = homeScreenServices;
        this.registerDisplayPageListener(homeScreenServices);
    }

    @Override
    public HomeScreenPages$Page getActivePage() {
        return this.activePage;
    }

    @Override
    public void activatePage(HomeScreenPages$Page homeScreenPages$Page) {
        this.setDatapoolToPage(homeScreenPages$Page);
        this.setPage(homeScreenPages$Page);
    }

    void setDatapoolToPage(HomeScreenPages$Page homeScreenPages$Page) {
        int n = PageUtil.getPropertyValue(homeScreenPages$Page);
        ASLPropertyManager aSLPropertyManager = this.services.getASLPropertyManager();
        aSLPropertyManager.valueChangedInteger(-1293202944, n);
    }

    private void firePageChanged(HomeScreenPages$Page homeScreenPages$Page) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            HomescreenPageListener homescreenPageListener = (HomescreenPageListener)iterator.next();
            homescreenPageListener.onHomescreenPageChanged(homeScreenPages$Page);
        }
    }

    void setPage(HomeScreenPages$Page homeScreenPages$Page) {
        if (this.activePage == homeScreenPages$Page) {
            return;
        }
        this.activePage = homeScreenPages$Page;
        this.firePageChanged(homeScreenPages$Page);
    }

    @Override
    public void addPageListener(HomescreenPageListener homescreenPageListener) {
        Preconditions.checkArgumentNotNull(homescreenPageListener, "Argument >listener< must not be null!");
        this.listeners.add(homescreenPageListener);
    }

    private void registerDisplayPageListener(HomeScreenServices homeScreenServices) {
        GenericEvents genericEvents = homeScreenServices.getGenericEvents();
        EventDispatcherHSM eventDispatcherHSM = genericEvents.getEventDispatcher();
        int n = eventDispatcherHSM.getNextTargetId();
        homeScreenServices.getServiceRegister().addObserver(-1547417024, n);
        HomeScreenPagesImpl$ModelListener homeScreenPagesImpl$ModelListener = new HomeScreenPagesImpl$ModelListener(this, n);
        try {
            genericEvents.getEventDispatcher().registerTarget(n, homeScreenPagesImpl$ModelListener, "hsmtask");
        }
        catch (Exception exception) {
            IllegalStateException illegalStateException = new IllegalStateException("Could not register ModelListener target!");
            illegalStateException.initCause(exception);
            throw illegalStateException;
        }
    }
}

