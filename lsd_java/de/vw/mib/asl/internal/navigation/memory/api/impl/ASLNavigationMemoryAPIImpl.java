/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.api.impl;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.memory.ASLNavigationMemoryAPI;
import de.vw.mib.asl.api.navigation.memory.IEntriesResultListener;
import de.vw.mib.asl.api.navigation.memory.IListResultListener;
import de.vw.mib.asl.api.navigation.memory.ITbmResultListener;
import de.vw.mib.asl.api.navigation.memory.IUpdateListener;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationContainer;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupFactory;
import de.vw.mib.asl.api.navigation.startup.NaviResettableAslTargetDelegator;
import de.vw.mib.asl.api.navigation.startup.NaviTargetDelegator;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.memory.MemoryFormatter;
import de.vw.mib.asl.internal.navigation.memory.NavMemoryDataRetriver;
import de.vw.mib.asl.internal.navigation.memory.NavMemoryListHandler;
import de.vw.mib.asl.internal.navigation.memory.TargetASLNaviContactsNBestListAdditionalDataHandling;
import de.vw.mib.asl.internal.navigation.memory.TargetAdbEdit;
import de.vw.mib.asl.internal.navigation.memory.TargetLastDestListFetcher;
import de.vw.mib.asl.internal.navigation.memory.TargetNavMemLoadEntry;
import de.vw.mib.asl.internal.navigation.memory.sd.TargetMemorySdGpsPictures;
import de.vw.mib.asl.internal.navigation.memory.sd.TargetMemorySdVCard;
import de.vw.mib.asl.internal.navigation.memory.search.HsmTargetMemorySearch;
import de.vw.mib.asl.internal.navigation.util.WeakIdentityHashSet;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.StringBuilder;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.memory.transformer.NavigationMemoryDestMemOnlineImportCollector;
import generated.de.vw.mib.asl.internal.navigation.memory.transformer.NavigationMemoryDestinationDetailsCollector;
import java.util.Iterator;
import org.dsi.ifc.navigation.TryBestMatchData;
import org.dsi.ifc.organizer.AdbViewSize;

public class ASLNavigationMemoryAPIImpl
implements ASLNavigationMemoryAPI,
ASLNavigationContainer {
    private static IExtLogger LOGGER = null;
    private static WeakIdentityHashSet updateListeners = new WeakIdentityHashSet();
    private static AdbViewSize lastViewSize = null;

    public static void notifyInvalidateContactData() {
        Iterator iterator = updateListeners.iterator();
        while (iterator.hasNext()) {
            try {
                IUpdateListener iUpdateListener = (IUpdateListener)iterator.next();
                iUpdateListener.invalidateContactData();
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void notifyUpdateViewSizes(AdbViewSize adbViewSize, int n) {
        Iterator iterator = updateListeners.iterator();
        lastViewSize = adbViewSize;
        while (iterator.hasNext()) {
            try {
                IUpdateListener iUpdateListener = (IUpdateListener)iterator.next();
                iUpdateListener.updateViewSizes(adbViewSize, n == 1);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void notifyProfileDownloadState(int n, int n2, int n3) {
        Iterator iterator = updateListeners.iterator();
        while (iterator.hasNext()) {
            try {
                IUpdateListener iUpdateListener = (IUpdateListener)iterator.next();
                iUpdateListener.updateProfileDownloadState(n, n2, n3);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public ASLNavigationMemoryAPIImpl() {
        ASLNavigationStartupFactory.getNavigationStartupApi().registerContainer(this);
    }

    @Override
    public void createTargets() {
        GenericEvents genericEvents = ServiceManager.eventMain;
        String string = "hsmtask";
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NaviTargetDelegator(new HsmTargetMemorySearch(genericEvents, 1850414080, string), string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NaviResettableAslTargetDelegator(new TargetLastDestListFetcher(genericEvents, 2051740672, string), string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NaviResettableAslTargetDelegator(new TargetAdbEdit(genericEvents, 2068517888, string), string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NavMemoryListHandler(genericEvents, -1052044288, string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NaviResettableAslTargetDelegator(new TargetNavMemLoadEntry(genericEvents, -1890905088, string), string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new TargetASLNaviContactsNBestListAdditionalDataHandling(genericEvents, -1974791168, string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NaviTargetDelegator(new TargetMemorySdVCard(genericEvents, -2142563328, string), string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NaviResettableAslTargetDelegator(new TargetMemorySdGpsPictures(genericEvents, 2118849536, string), string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NaviResettableAslTargetDelegator(new NavMemoryDataRetriver(genericEvents, -867494912, string), string));
    }

    @Override
    public void setDestinationDetails(ILocationWrapper iLocationWrapper, String string) {
        NavigationMemoryDestinationDetailsCollector navigationMemoryDestinationDetailsCollector = MemoryFormatter.createMemoryDestinationDetails(iLocationWrapper, string);
        ListManager.getGenericASLList(910).updateList(new Object[]{navigationMemoryDestinationDetailsCollector});
    }

    @Override
    public void importContactSummary(int n, int n2, int n3, int n4) {
        if (n4 == 1) {
            this.logger().trace(new StringBuilder("ImportContactSummary (success/failed/pending): ").append(n).append("/").append(n2).append("/").append(n3).toString());
            GenericASLList genericASLList = ListManager.getGenericASLList(-118550528);
            NavigationMemoryDestMemOnlineImportCollector navigationMemoryDestMemOnlineImportCollector = (NavigationMemoryDestMemOnlineImportCollector)genericASLList.getRowItemCacheOnly(0);
            if (navigationMemoryDestMemOnlineImportCollector == null) {
                navigationMemoryDestMemOnlineImportCollector = new NavigationMemoryDestMemOnlineImportCollector();
            }
            navigationMemoryDestMemOnlineImportCollector.navigation_memory_dest_mem_online_import_number_imported = n;
            navigationMemoryDestMemOnlineImportCollector.navigation_memory_dest_mem_online_import_number_total = n + n2 + n3;
            genericASLList.updateListItem(0, navigationMemoryDestMemOnlineImportCollector);
            if (n + n2 + n3 == 0) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-168882176);
            } else if (n2 + n3 == 0) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-219213824);
            } else if (n == 0) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-185659392);
            } else {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-202436608);
            }
        } else {
            this.logger().trace("ImportContactSummary Error signaled");
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-152104960);
        }
    }

    private IExtLogger logger() {
        if (LOGGER == null) {
            LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[ASLNavigationMemoryAPIImpl]");
        }
        return LOGGER;
    }

    @Override
    public void getOrganizerListBlock(IListResultListener iListResultListener, int n, int n2, int n3, Object object) {
        NavMemoryDataRetriver.INSTANCE.getListBlock(iListResultListener, n, n2, n3, object);
    }

    @Override
    public void getOrganizerEntries(IEntriesResultListener iEntriesResultListener, long[] lArray, int n, Object object) {
        NavMemoryDataRetriver.INSTANCE.getEntries(iEntriesResultListener, lArray, n, object);
    }

    @Override
    public void tryBestMatch(ITbmResultListener iTbmResultListener, TryBestMatchData tryBestMatchData, Object object) {
        NavMemoryDataRetriver.INSTANCE.tryBestMatch(iTbmResultListener, tryBestMatchData, object);
    }

    @Override
    public void registerUpdateListener(IUpdateListener iUpdateListener) {
        updateListeners.add(iUpdateListener);
        try {
            iUpdateListener.updateViewSizes(lastViewSize, lastViewSize != null);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void unregisterUpdateListener(IUpdateListener iUpdateListener) {
        updateListeners.remove(iUpdateListener);
    }
}

