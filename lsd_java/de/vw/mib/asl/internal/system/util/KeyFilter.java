/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.util;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public final class KeyFilter {
    private final int numberOfTimeSlots;
    final int lengthOfTimeSlot = Integer.getInteger("keyfilter.lengthOfTimeSlot", 1000);
    private final int thresholdKeyEventsActive4TimeSlot;
    private final int thresholdKeyEvents;
    private final int thresholdKeyEventsMax4TimeSlot;
    private int totalKeyEvents;
    private final int[] keyEventsPerTimeSlot;
    private int currTSIdx = 0;
    private boolean filterActive;
    private boolean disableKeyFilter = false;
    private static KeyFilter theKeyFilter;
    private static boolean RMA_KEY_FILTER_IS_ENABLED;
    private static int SECURITY_THRESHOLD;

    public static KeyFilter getKeyFilter() {
        return KeyFilter.getTheKeyFilter();
    }

    private KeyFilter() {
        this.numberOfTimeSlots = Integer.getInteger("keyfilter.numbertOfTimeSlots", 10);
        this.thresholdKeyEvents = Integer.getInteger("keyfilter.threshold", 20);
        this.thresholdKeyEventsMax4TimeSlot = Integer.getInteger("keyfilter.threshold", 8);
        this.keyEventsPerTimeSlot = new int[this.numberOfTimeSlots];
        this.thresholdKeyEventsActive4TimeSlot = Integer.getInteger("keyfilter.threshold4TimeSlot", 1);
        ServiceManager.eventMain.getTimerServer().restartOrStartTimedEvent(5601, -779681536, this.lengthOfTimeSlot, true);
    }

    boolean logKeyEvent() {
        if (this.disableKeyFilter) {
            return false;
        }
        ++this.totalKeyEvents;
        int n = this.currTSIdx;
        this.keyEventsPerTimeSlot[n] = this.keyEventsPerTimeSlot[n] + 1;
        if (this.keyEventsPerTimeSlot[this.currTSIdx] > SECURITY_THRESHOLD) {
            this.disableKeyFilter = true;
            ServiceManager.logger.error(2048).append("[RMA KeyFilter] filter deactivated: timer is not working").log();
        }
        boolean bl = this.filterActive;
        boolean bl2 = this.filterActive = this.totalKeyEvents > this.thresholdKeyEvents;
        if (bl != this.filterActive) {
            ServiceManager.logger.info(2048).append("[RMA KeyFilter] filter changed: ").append(this.filterActive).append(", currTSIdx = ").append(this.currTSIdx).log();
        }
        return this.needsToFilter4CurrentTS();
    }

    public void nextTS() {
        int n = this.currTSIdx < this.numberOfTimeSlots - 1 ? (this.currTSIdx = this.currTSIdx + 1) : 0;
        this.totalKeyEvents -= this.keyEventsPerTimeSlot[n];
        this.keyEventsPerTimeSlot[n] = 0;
        this.currTSIdx = n;
        boolean bl = this.filterActive;
        boolean bl2 = this.filterActive = this.totalKeyEvents > this.thresholdKeyEvents;
        if (bl != this.filterActive) {
            ServiceManager.logger.info(2048).append("[RMA KeyFilter] filter changed: ").append(this.filterActive).append(", currTSIdx = ").append(this.currTSIdx).log();
        }
    }

    private boolean needsToFilter4CurrentTS() {
        if (this.filterActive) {
            return this.keyEventsPerTimeSlot[this.currTSIdx] > this.thresholdKeyEventsActive4TimeSlot;
        }
        return this.keyEventsPerTimeSlot[this.currTSIdx] >= this.thresholdKeyEventsMax4TimeSlot;
    }

    static KeyFilter getTheKeyFilter() {
        return theKeyFilter;
    }

    static {
        SECURITY_THRESHOLD = 50;
        RMA_KEY_FILTER_IS_ENABLED = Boolean.getBoolean("keyfilter.enabled");
        if (RMA_KEY_FILTER_IS_ENABLED) {
            theKeyFilter = new KeyFilter();
        }
    }
}

