/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic;

import de.vw.mib.asl.internal.navigation.traffic.TrafficDataPool$Holder;
import de.vw.mib.asl.internal.navigation.traffic.TrafficMessageInfo;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.tmc.TmcMessage;

public class TrafficDataPool {
    private TrafficMessageInfo trafficMessageInfoCurrent;
    private final List navigationGuidanceReRouteTmcMessages;
    private final List navigationGuidanceReRouteTmcMessagesUIDs;
    private final List overviewListMessageUIDs = new ArrayList();
    private final List urgentMessages;
    private final List urgentMessagesReadUIDs;
    private boolean isMessagesListLoading = false;
    private boolean isPopUpTimerRunning = false;
    private int currentMessageFilter = 0;

    static TrafficDataPool getInstance() {
        return TrafficDataPool$Holder.INSTANCE;
    }

    TrafficDataPool() {
        this.navigationGuidanceReRouteTmcMessages = new ArrayList();
        this.navigationGuidanceReRouteTmcMessagesUIDs = new ArrayList();
        this.urgentMessages = new ArrayList();
        this.urgentMessagesReadUIDs = new ArrayList();
    }

    List getNavigationGuidanceReRouteTmcMessages() {
        return this.navigationGuidanceReRouteTmcMessages;
    }

    List getNavigationGuidanceReRouteTmcMessagesUIDs() {
        return this.navigationGuidanceReRouteTmcMessagesUIDs;
    }

    List getOverviewListMessageUIDs() {
        return this.overviewListMessageUIDs;
    }

    TrafficMessageInfo getTrafficMessageInfoCurrent() {
        return this.trafficMessageInfoCurrent;
    }

    List getUrgentMessages() {
        return this.urgentMessages;
    }

    List getUrgentMessagesReadUIDs() {
        return this.urgentMessagesReadUIDs;
    }

    void setTrafficMessageInfoCurrent(TrafficMessageInfo trafficMessageInfo) {
        this.trafficMessageInfoCurrent = trafficMessageInfo;
    }

    void urgentMessagesRemoveMessagesRead() {
        int n = 0;
        while (n < this.urgentMessages.size()) {
            TmcMessage tmcMessage = (TmcMessage)this.urgentMessages.get(n);
            if (this.urgentMessagesReadUIDs.contains(new Long(tmcMessage.messageID))) {
                this.urgentMessages.remove(n);
                continue;
            }
            ++n;
        }
    }

    void resetTrafficMessageInfoCurrent() {
        if (this.trafficMessageInfoCurrent != null) {
            this.trafficMessageInfoCurrent.resetValue();
        }
    }

    boolean isMessagesListLoading() {
        return this.isMessagesListLoading;
    }

    void setMessagesListLoading(boolean bl) {
        this.isMessagesListLoading = bl;
    }

    boolean isPopUpTimerRunning() {
        return this.isPopUpTimerRunning;
    }

    void setPopUpTimerRunning(boolean bl) {
        this.isPopUpTimerRunning = bl;
    }

    public int getCurrentMessageFilter() {
        return this.currentMessageFilter;
    }

    public void setCurrentMessageFilter(int n) {
        this.currentMessageFilter = n;
    }
}

