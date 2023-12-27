/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.TrafficDualListViewConfiguration;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListViewListener;
import de.vw.mib.asl.internal.navigation.traffic.transformer.TrafficMessageCollector;

public class TrafficDualListHandler
implements ASLListViewListener {
    private boolean startScrollEventSent;

    @Override
    public void listViewUpdated(ASLList aSLList, int n, int n2, Object[] objectArray) {
        ServiceManager.logger.trace(16384).append("TrafficDualListHandler.listViewUpdated()").log();
        boolean bl = n == -1 && n2 > 0;
        ServiceManager.aslPropertyManager.valueChangedBoolean(519049216, !bl);
        if (!bl) {
            ServiceManager.logger.trace(16384).append("TrafficDualListHandler: scrolling inactive").append(n2).log();
            this.startScrollEventSent = false;
            long[] lArray = this.extractMessagIdsFromTmcListElement(aSLList, objectArray);
            TrafficDualListViewConfiguration trafficDualListViewConfiguration = new TrafficDualListViewConfiguration(lArray, true, true);
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapShowTMCDualList(trafficDualListViewConfiguration);
            ServiceManager.aslPropertyManager.valueChangedInteger(0x1FF01000, n);
        } else if (!this.startScrollEventSent) {
            ServiceManager.logger.trace(16384).append("TrafficDualListHandler: scrolling active").append(n2).log();
            this.startScrollEventSent = true;
            ASLNavigationMapFactory.getNavigationMapApi().sendEvListViewStartScroll();
        } else {
            ServiceManager.logger.warn(16384).append("TrafficDualListHandler: undefined state scrollingActive and startScrollEbentSent was true!").append(n2).log();
        }
    }

    private long[] extractMessagIdsFromTmcListElement(ASLList aSLList, Object[] objectArray) {
        long[] lArray = new long[objectArray.length];
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            Object object = objectArray[i2];
            if (!aSLList.isValidItem(object)) continue;
            lArray[i2] = this.getTrafficMessageIdFromListItem(object);
        }
        return lArray;
    }

    private long getTrafficMessageIdFromListItem(Object object) {
        ServiceManager.logger.trace(16384).append("TrafficDualListHandler.getTrafficMessageIdFromListItem()").log();
        if (object != null && object instanceof TrafficMessageCollector) {
            TrafficMessageCollector trafficMessageCollector = (TrafficMessageCollector)object;
            return this.getIdOrZeroIfAreaMessage(trafficMessageCollector);
        }
        ServiceManager.logger.error(16384).append("TrafficDualListHandler: listItem was null or not instance of TmcListElement").append("The listItem object: ").append(object).log();
        return Long.MIN_VALUE;
    }

    private long getIdOrZeroIfAreaMessage(TrafficMessageCollector trafficMessageCollector) {
        if (trafficMessageCollector.tmcListElement == null || trafficMessageCollector.tmcListElement.getMessage() == null) {
            ServiceManager.logger.error(16384).append("TrafficDualListHandler: message or list element was null").log();
            return Long.MIN_VALUE;
        }
        if (trafficMessageCollector.tmcListElement.getMessage().isArea) {
            return 0L;
        }
        return trafficMessageCollector.tmcListElement.getUID();
    }
}

