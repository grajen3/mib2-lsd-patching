/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListViewListener;
import de.vw.mib.asl.internal.navigation.poi.transformer.PoiResultListCollector;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.global.NavLocation;

public class OnboardPoiDualListViewHandler
implements ASLListViewListener {
    private static boolean startScrollEventSent;
    private static Integer currentStartIndex;
    private static Integer currentItemCount;
    private static int oldStartIndex;
    private static int oldCount;
    private INavigationDP navigationDP;
    private static boolean forceItemsRedraw;
    static IExtLogger logger;
    Integer lock = new Integer(0);

    public OnboardPoiDualListViewHandler() {
        ListManager.getGenericASLList(946).addListViewListener(this);
        this.navigationDP = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
    }

    public Integer getCurrentStartIndex() {
        return currentStartIndex;
    }

    public Integer getCurrentItemCount() {
        return currentItemCount;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void listViewUpdated(ASLList aSLList, int n, int n2, Object[] objectArray) {
        Integer n3 = this.lock;
        synchronized (n3) {
            boolean bl;
            OnboardPoiDualListViewHandler.printTrace(new StringBuffer(new StringBuffer().append("listViewUpdated,startindex=").append(n).append(", count=").append(n2).toString()));
            boolean bl2 = n == -1 && n2 > 0;
            boolean bl3 = bl = n == -1 && n2 == 0;
            if (bl) {
                OnboardPoiDualListViewHandler.printTrace(new StringBuffer("listViewUpdated: list is now empty"));
                oldStartIndex = -1;
                oldCount = -1;
                currentStartIndex = new Integer(0);
                currentItemCount = new Integer(0);
            } else if (bl2) {
                if (!startScrollEventSent) {
                    OnboardPoiDualListViewHandler.printTrace(new StringBuffer("listViewUpdated: starting to scroll"));
                    startScrollEventSent = true;
                    this.setMapReady(false);
                    OnboardPoiDualListViewHandler.printTrace(new StringBuffer(new StringBuffer().append("listViewUpdated: scrolling true, startIndex=").append(n).toString()));
                    ASLNavigationMapFactory.getNavigationMapApi().sendEvListViewStartScroll();
                }
            } else {
                boolean bl4 = false;
                if (startScrollEventSent) {
                    OnboardPoiDualListViewHandler.printTrace(new StringBuffer("listViewUpdated: stopped to scroll"));
                    bl4 = true;
                }
                startScrollEventSent = false;
                if (oldStartIndex != n || oldCount != n2 || bl4 || forceItemsRedraw && 0 == currentStartIndex) {
                    OnboardPoiDualListViewHandler.printTrace(new StringBuffer("listViewUpdated: getting items to be resolved"));
                    oldStartIndex = n;
                    oldCount = n2;
                    forceItemsRedraw = false;
                    Integer n4 = this.getCurrentStartIndex();
                    synchronized (n4) {
                        currentStartIndex = new Integer(n);
                        currentItemCount = new Integer(n2);
                    }
                    this.setFlags(objectArray);
                    this.setMapReady(true);
                } else {
                    OnboardPoiDualListViewHandler.printTrace(new StringBuffer(new StringBuffer().append("listViewUpdated: don't resolve items. oldStartindex=").append(oldStartIndex).append(", newStartIndex=").append(n).append(", oldCount=").append(oldCount).append(", newCount=").append(n2).append(", stoppedScrolling=").append(bl4).toString()));
                }
            }
        }
    }

    public void setFlags(Object[] objectArray) {
        NavLocation[] navLocationArray = new NavLocation[]{};
        try {
            navLocationArray = this.getNavLocationsFromPoiResultListCollectors(objectArray);
            OnboardPoiDualListViewHandler.printTrace(new StringBuffer(new StringBuffer().append("setFlags: flagcount=").append(navLocationArray.length).append(", startIndex=").append(this.getCurrentStartIndex()).toString()));
            ASLNavigationMapFactory.getNavigationMapApi().sendEvListViewUpdate(navLocationArray, 0);
            ServiceManager.aslPropertyManager.valueChangedInteger(0x1FF01000, this.getCurrentStartIndex());
        }
        catch (Exception exception) {
            OnboardPoiDualListViewHandler.printTrace(new StringBuffer("setFlags: Error getting NavLocations from POI Result List Collectors (getNavLocationsFromPoiResultListCollectors)"));
        }
    }

    public void setMapReady(boolean bl) {
        if (bl) {
            OnboardPoiDualListViewHandler.printTrace(new StringBuffer("setMapReady, MAP_READY true, NUMBERING_ACTIVE true"));
            ServiceManager.aslPropertyManager.valueChangedBoolean(-84996096, true);
            ServiceManager.aslPropertyManager.valueChangedBoolean(519049216, true);
        } else {
            OnboardPoiDualListViewHandler.printTrace(new StringBuffer("setMapReady, MAP_READY false, NUMBERING_ACTIVE false"));
            ServiceManager.aslPropertyManager.valueChangedBoolean(-84996096, false);
            ServiceManager.aslPropertyManager.valueChangedBoolean(519049216, false);
        }
    }

    private NavLocation[] getNavLocationsFromPoiResultListCollectors(Object[] objectArray) {
        NavLocation[] navLocationArray = new NavLocation[objectArray.length];
        int[][] nArray = new int[objectArray.length][2];
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            PoiResultListCollector poiResultListCollector = (PoiResultListCollector)objectArray[i2];
            navLocationArray[i2] = poiResultListCollector.poiNavLocation;
            nArray[i2][0] = poiResultListCollector.listIndex;
        }
        this.navigationDP.storeVisibleLocationIDs(nArray);
        return navLocationArray;
    }

    static void printTrace(StringBuffer stringBuffer) {
        if (logger.isTraceEnabled()) {
            logger.makeTrace().append(stringBuffer.toString()).log();
        }
    }

    public void resetStartIndex() {
        oldStartIndex = -1;
        oldCount = -1;
    }

    public void setForceRedraw() {
        forceItemsRedraw = true;
        OnboardPoiDualListViewHandler.printTrace(new StringBuffer("setForceRedraw: force map PINs redraw "));
    }

    static {
        currentStartIndex = new Integer(0);
        currentItemCount = new Integer(0);
        oldStartIndex = -1;
        oldCount = -1;
        forceItemsRedraw = false;
        logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "OnboardPoiDualListViewHandler");
    }
}

