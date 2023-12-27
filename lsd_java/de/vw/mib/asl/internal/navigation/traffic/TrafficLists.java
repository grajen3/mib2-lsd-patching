/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.ASLListDataUpdateListener;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.traffic.TrafficDualListHandler;
import de.vw.mib.asl.internal.navigation.traffic.TrafficLists$IconUpdateListener;
import de.vw.mib.asl.internal.navigation.traffic.TrafficTargetHSM;
import de.vw.mib.asl.internal.navigation.traffic.transformer.TrafficMessageCollector;
import de.vw.mib.asl.internal.navigation.traffic.transformer.TrafficMessageFormatter;
import de.vw.mib.asl.internal.navigation.traffic.transformer.TrafficMessageIcon;
import de.vw.mib.properties.values.FixFormatterFieldData;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.traffic.transformer.NavigationTrafficTMCMessageDetailCollector;
import generated.de.vw.mib.asl.internal.navigation.traffic.transformer.NavigationTrafficTMCXUrgentMessageCollector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public class TrafficLists {
    private final IExtLogger logger;
    private final GenericASLList tmcOverviewList;
    private final GenericASLList tmcInfoList;
    private final GenericASLList tmcMessageDetailList;
    private final GenericASLList tmcXUrgentMessageList;
    final ArrayList undisclosedIcons = new ArrayList();

    TrafficLists(TrafficTargetHSM trafficTargetHSM) {
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16, "[TrafficLists]");
        this.tmcOverviewList = ListManager.getGenericASLList(1017);
        this.tmcOverviewList.addASLListDataUpdateListener((ASLListDataUpdateListener)ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAsyncServiceFactory().create(new TrafficLists$IconUpdateListener(this)));
        this.tmcOverviewList.addListViewListener(new TrafficDualListHandler());
        this.tmcInfoList = ListManager.getGenericASLList(743);
        this.tmcMessageDetailList = ListManager.getGenericASLList(1016);
        this.tmcXUrgentMessageList = ListManager.getGenericASLList(2471);
    }

    TrafficMessageCollector getCollectorOfOverviewListMessageIndex(int n) {
        return (TrafficMessageCollector)this.getTmcOverviewList().getRowItem(n);
    }

    NavigationTrafficTMCXUrgentMessageCollector getXUrgentMessageCollector() {
        return (NavigationTrafficTMCXUrgentMessageCollector)this.tmcXUrgentMessageList.getRowItem(0);
    }

    NavigationTrafficTMCMessageDetailCollector getTrafficMessageDetailCollector() {
        return (NavigationTrafficTMCMessageDetailCollector)this.tmcMessageDetailList.getRowItem(0);
    }

    GenericASLList getTmcInfoList() {
        return this.tmcInfoList;
    }

    GenericASLList getTmcMessageDetailList() {
        return this.tmcMessageDetailList;
    }

    GenericASLList getTmcOverviewList() {
        return this.tmcOverviewList;
    }

    void updateXUrgentMessageDetails(TmcListElement tmcListElement, boolean bl, int n) {
        FixFormatterFieldData fixFormatterFieldData;
        if (tmcListElement == null || tmcListElement.message == null) {
            return;
        }
        TmcMessage tmcMessage = tmcListElement.message;
        NavigationTrafficTMCXUrgentMessageCollector navigationTrafficTMCXUrgentMessageCollector = this.getXUrgentMessageCollector();
        String string = TrafficMessageFormatter.getTimeFormatString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string);
        Date date = new Date(tmcMessage.timeStamp * 0);
        navigationTrafficTMCXUrgentMessageCollector.navigation_traffic_tmcx_urgent_message_time = simpleDateFormat.format(date);
        simpleDateFormat.applyPattern("dd.MM.yyyy");
        navigationTrafficTMCXUrgentMessageCollector.navigation_traffic_tmcx_urgent_message_id = n;
        navigationTrafficTMCXUrgentMessageCollector.navigation_traffic_tmcx_urgent_message_is_on_route = bl;
        navigationTrafficTMCXUrgentMessageCollector.navigation_traffic_tmcx_urgent_message_details_for_fix_formatter = fixFormatterFieldData = TrafficMessageFormatter.prepareFixFormatterDetailViewData(tmcMessage);
        this.tmcXUrgentMessageList.updateListItem(0, navigationTrafficTMCXUrgentMessageCollector);
    }

    void updateTrafficMessageDetails(TmcListElement tmcListElement, TrafficMessageIcon trafficMessageIcon, boolean bl, int n) {
        FixFormatterFieldData fixFormatterFieldData;
        if (tmcListElement == null || tmcListElement.message == null) {
            return;
        }
        TmcMessage tmcMessage = tmcListElement.message;
        NavigationTrafficTMCMessageDetailCollector navigationTrafficTMCMessageDetailCollector = this.getTrafficMessageDetailCollector();
        navigationTrafficTMCMessageDetailCollector.navigation_traffic_tmc_message_detail_station = tmcMessage.providerName;
        String string = TrafficMessageFormatter.getTimeFormatString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string);
        Date date = new Date(tmcMessage.timeStamp * 0);
        navigationTrafficTMCMessageDetailCollector.navigation_traffic_tmc_message_detail_time = simpleDateFormat.format(date);
        simpleDateFormat.applyPattern("dd.MM.yyyy");
        navigationTrafficTMCMessageDetailCollector.navigation_traffic_tmc_message_detail_id = n;
        navigationTrafficTMCMessageDetailCollector.navigation_traffic_selected_tmc_message_detail_map_available = !this.isTmcMessageAreaType(tmcMessage);
        navigationTrafficTMCMessageDetailCollector.navigation_traffic_tmc_message_detail_icon = trafficMessageIcon.iconDescriptor.getResourceLocator();
        navigationTrafficTMCMessageDetailCollector.navigation_traffic_selected_tmc_message_detail_on_route = bl;
        navigationTrafficTMCMessageDetailCollector.navigation_traffic_tmc_message_detail_address_details_for_fix_formatter = fixFormatterFieldData = TrafficMessageFormatter.prepareFixFormatterDetailViewData(tmcMessage);
        this.tmcMessageDetailList.updateListItem(0, navigationTrafficTMCMessageDetailCollector);
    }

    private boolean isTmcMessageAreaType(TmcMessage tmcMessage) {
        boolean bl;
        boolean bl2 = tmcMessage.directionOfRoad1 != null && tmcMessage.directionOfRoad1.length() > 0;
        boolean bl3 = tmcMessage.directionOfRoad2 != null && tmcMessage.directionOfRoad2.length() > 0;
        boolean bl4 = tmcMessage.startLocation != null && tmcMessage.startLocation.length() > 0;
        boolean bl5 = bl = tmcMessage.endLocation != null && tmcMessage.endLocation.length() > 0;
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(105)) {
            return tmcMessage.isArea || !tmcMessage.isArea && !bl3 && bl4 ^ bl;
        }
        return tmcMessage.isArea || !tmcMessage.isArea && !bl2 && !bl3 && bl4 && !bl;
    }

    void updateTrafficeMessageListDetailIcon(TrafficMessageIcon trafficMessageIcon) {
        NavigationTrafficTMCMessageDetailCollector navigationTrafficTMCMessageDetailCollector = this.getTrafficMessageDetailCollector();
        if (trafficMessageIcon.tmcElement_uID == (long)navigationTrafficTMCMessageDetailCollector.navigation_traffic_tmc_message_detail_id) {
            navigationTrafficTMCMessageDetailCollector.navigation_traffic_tmc_message_detail_icon = trafficMessageIcon.iconDescriptor.getResourceLocator();
            this.tmcMessageDetailList.updateListItem(0, navigationTrafficTMCMessageDetailCollector);
        }
    }

    void updateOverviewListSize(int n) {
        this.tmcOverviewList.setSize(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void resetOverviewList() {
        this.logger.trace("resetOverviewList()");
        this.tmcOverviewList.setSize(0);
        this.tmcOverviewList.disableWindowing();
        ArrayList arrayList = this.undisclosedIcons;
        synchronized (arrayList) {
            this.undisclosedIcons.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void insertResourceLocatorIntoOverviewList(TrafficMessageIcon trafficMessageIcon) {
        if (this.tmcOverviewList == null) {
            this.logger.trace("tmcOverviewList null!!");
            return;
        }
        if (!this.insertResourceLocatorIntoOverviewList_intern(trafficMessageIcon)) {
            ArrayList arrayList = this.undisclosedIcons;
            synchronized (arrayList) {
                this.undisclosedIcons.add(trafficMessageIcon);
            }
        }
    }

    boolean insertResourceLocatorIntoOverviewList_intern(TrafficMessageIcon trafficMessageIcon) {
        TrafficMessageCollector trafficMessageCollector = (TrafficMessageCollector)this.tmcOverviewList.getListItemByIdCacheOnly(trafficMessageIcon.tmcElement_uID);
        if (trafficMessageCollector == null) {
            if (this.logger.isTraceEnabled()) {
                this.logger.makeTrace().append("collector is null, id=").append(trafficMessageIcon.tmcElement_uID).log();
            }
            return false;
        }
        if (this.logger.isTraceEnabled()) {
            if (trafficMessageIcon.isRoadIconDescriptor) {
                this.logger.makeTrace().append("insertResourceLocatorIntoOverviewList-Rd Desc uID=").append(trafficMessageIcon.tmcElement_uID).append(", rLocator.url=").append(trafficMessageIcon.roadIconDescriptor.getResourceLocator().url).append(", rLocator.id=").append(trafficMessageIcon.roadIconDescriptor.getResourceLocator().id).log();
            } else {
                this.logger.makeTrace().append("insertResourceLocatorIntoOverviewList() Event Desc uID=").append(trafficMessageIcon.tmcElement_uID).append(", rLocator.url=").append(trafficMessageIcon.iconDescriptor.getResourceLocator().url).append(", rLocator.id=").append(trafficMessageIcon.iconDescriptor.getResourceLocator().id).log();
            }
        }
        if (trafficMessageIcon.isRoadIconDescriptor) {
            trafficMessageCollector.trafficMessageIcon.roadIconDescriptor = trafficMessageIcon.roadIconDescriptor;
            if (this.logger.isTraceEnabled()) {
                this.logger.makeTrace().append("insertResourceLocatorIntoOverviewList() Rd Desc Index=").append(trafficMessageCollector.index).log();
            }
        } else {
            trafficMessageCollector.trafficMessageIcon.iconDescriptor = trafficMessageIcon.iconDescriptor;
            if (this.logger.isTraceEnabled()) {
                this.logger.makeTrace().append("insertResourceLocatorIntoOverviewList() Event Desc Index=").append(trafficMessageCollector.index).log();
            }
            this.updateTrafficeMessageListDetailIcon(trafficMessageIcon);
        }
        this.tmcOverviewList.updateListItem(trafficMessageCollector.index, trafficMessageCollector);
        return true;
    }
}

