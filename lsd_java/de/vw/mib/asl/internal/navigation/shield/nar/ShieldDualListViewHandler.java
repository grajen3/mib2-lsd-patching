/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.shield.nar;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListViewListener;
import de.vw.mib.asl.internal.navigation.shield.nar.ShieldModelNotifier;
import de.vw.mib.asl.internal.navigation.shield.nar.TargetShield;
import de.vw.mib.asl.internal.navigation.shield.transformer.ShieldCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.dsi.ifc.global.NavLocation;

public class ShieldDualListViewHandler
implements ASLListViewListener {
    private boolean startScrollEventSent;
    private final TargetShield targetShield;
    private Integer currentStartIndex = new Integer(0);
    private Integer currentItemCount = new Integer(0);
    private int oldStartIndex = -1;
    private int oldCount = -1;
    private INavigationDP navigationDP;
    private Collection flags = new ArrayList();
    private int flagType;
    static IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "ShieldDualListViewHandler");
    Integer lock = new Integer(0);

    public ShieldDualListViewHandler(TargetShield targetShield, ShieldModelNotifier shieldModelNotifier) {
        this.targetShield = targetShield;
        shieldModelNotifier.registerDualListViewHandler(this);
        this.navigationDP = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
    }

    public Integer getCurrentStartIndex() {
        return this.currentStartIndex;
    }

    public Integer getCurrentItemCount() {
        return this.currentItemCount;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void listViewUpdated(ASLList aSLList, int n, int n2, Object[] objectArray) {
        Integer n3 = this.lock;
        synchronized (n3) {
            boolean bl;
            ShieldDualListViewHandler.printTrace(new StringBuffer(new StringBuffer().append("listViewUpdated,startindex=").append(n).append(", count=").append(n2).toString()));
            boolean bl2 = n == -1 && n2 > 0;
            boolean bl3 = bl = n == -1 && n2 == 0;
            if (bl) {
                ShieldDualListViewHandler.printTrace(new StringBuffer("listViewUpdated: list is now empty"));
                this.oldStartIndex = -1;
                this.oldCount = -1;
                this.currentStartIndex = new Integer(0);
                this.currentItemCount = new Integer(0);
            } else if (bl2) {
                if (!this.startScrollEventSent) {
                    ShieldDualListViewHandler.printTrace(new StringBuffer("listViewUpdated: starting to scroll"));
                    this.startScrollEventSent = true;
                    ServiceManager.aslPropertyManager.valueChangedBoolean(-84996096, false);
                    ServiceManager.aslPropertyManager.valueChangedBoolean(519049216, false);
                    ShieldDualListViewHandler.printTrace(new StringBuffer(new StringBuffer().append("listViewUpdated: scrolling true, startIndex=").append(n).toString()));
                    ASLNavigationMapFactory.getNavigationMapApi().sendEvListViewStartScroll();
                }
            } else {
                boolean bl4 = false;
                if (this.startScrollEventSent) {
                    ShieldDualListViewHandler.printTrace(new StringBuffer("listViewUpdated: stopped to scroll"));
                    bl4 = true;
                }
                this.startScrollEventSent = false;
                if (this.oldStartIndex != n || this.oldCount != n2 || bl4) {
                    ShieldDualListViewHandler.printTrace(new StringBuffer("listViewUpdated: getting items to be resolved"));
                    this.oldStartIndex = n;
                    this.oldCount = n2;
                    Integer n4 = this.getCurrentStartIndex();
                    synchronized (n4) {
                        this.currentStartIndex = new Integer(n);
                        this.currentItemCount = new Integer(n2);
                    }
                    this.targetShield.resolveResults(objectArray);
                } else {
                    ShieldDualListViewHandler.printTrace(new StringBuffer(new StringBuffer().append("listViewUpdated: don't resolve items. oldStartindex=").append(this.oldStartIndex).append(", newStartIndex=").append(n).append(", oldCount=").append(this.oldCount).append(", newCount=").append(n2).append(", stoppedScrolling=").append(bl4).toString()));
                }
            }
        }
    }

    public void setMapReady(boolean bl) {
        if (bl) {
            ShieldDualListViewHandler.printTrace(new StringBuffer("setMapReady, MAP_READY true, NUMBERING_ACTIVE true"));
            ServiceManager.aslPropertyManager.valueChangedBoolean(-84996096, true);
            ServiceManager.aslPropertyManager.valueChangedBoolean(519049216, true);
        } else {
            ShieldDualListViewHandler.printTrace(new StringBuffer("setMapReady, MAP_READY false, NUMBERING_ACTIVE false"));
            ServiceManager.aslPropertyManager.valueChangedBoolean(-84996096, false);
            ServiceManager.aslPropertyManager.valueChangedBoolean(519049216, false);
        }
    }

    private NavLocation[] getNavLocationsFromShieldCollectors(Collection collection) {
        NavLocation[] navLocationArray = new NavLocation[collection.size()];
        Iterator iterator = collection.iterator();
        int n = 0;
        int[][] nArray = new int[collection.size()][2];
        while (iterator.hasNext()) {
            ShieldCollector shieldCollector = (ShieldCollector)iterator.next();
            navLocationArray[n] = shieldCollector.navLocation;
            nArray[n][0] = shieldCollector.id;
            ++n;
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
        this.oldStartIndex = -1;
        this.oldCount = -1;
    }

    public void setFlags(Collection collection, boolean bl) {
        this.flags = collection;
        if (bl) {
            ShieldDualListViewHandler.printTrace(new StringBuffer(new StringBuffer().append("setFlags, setting flags for ").append(collection.size()).append(" elements of type online").toString()));
            this.flagType = 1;
        } else {
            ShieldDualListViewHandler.printTrace(new StringBuffer(new StringBuffer().append("handleAllSearchResultsResolved, setting flags for ").append(collection.size()).append(" elements of type VW").toString()));
            this.flagType = 0;
        }
    }

    public void drawFlags() {
        NavLocation[] navLocationArray = new NavLocation[]{};
        try {
            navLocationArray = this.getNavLocationsFromShieldCollectors(this.flags);
            ShieldDualListViewHandler.printTrace(new StringBuffer(new StringBuffer().append("drawFlags: flagcount=").append(navLocationArray.length).append(", startIndex=").append(this.getCurrentStartIndex()).toString()));
            ASLNavigationMapFactory.getNavigationMapApi().sendEvListViewUpdate(navLocationArray, this.flagType);
        }
        catch (Exception exception) {
            ShieldDualListViewHandler.printTrace(new StringBuffer("drawFlags: Error getting NavLocations from shield collectors (getNavLocationsFromShieldCollectors)"));
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(0x1FF01000, this.getCurrentStartIndex());
        if (this.flags.size() == 0) {
            this.setMapReady(true);
        }
    }
}

