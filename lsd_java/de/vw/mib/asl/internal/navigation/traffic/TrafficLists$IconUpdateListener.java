/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListDataUpdateListener;
import de.vw.mib.asl.internal.navigation.traffic.TrafficLists;
import de.vw.mib.asl.internal.navigation.traffic.transformer.TrafficMessageIcon;
import java.util.ArrayList;
import java.util.Iterator;

class TrafficLists$IconUpdateListener
implements ASLListDataUpdateListener {
    private final /* synthetic */ TrafficLists this$0;

    TrafficLists$IconUpdateListener(TrafficLists trafficLists) {
        this.this$0 = trafficLists;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyListDataUpdated(ASLList aSLList) {
        ArrayList arrayList = this.this$0.undisclosedIcons;
        synchronized (arrayList) {
            Iterator iterator = this.this$0.undisclosedIcons.iterator();
            while (iterator.hasNext()) {
                TrafficMessageIcon trafficMessageIcon = (TrafficMessageIcon)iterator.next();
                if (!this.this$0.insertResourceLocatorIntoOverviewList_intern(trafficMessageIcon)) continue;
                iterator.remove();
            }
        }
    }
}

