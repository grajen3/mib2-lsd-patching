/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.proximity;

import de.vw.mib.asl.internal.system.proximity.component.DefaultProximityUserInteractionComponent;
import de.vw.mib.asl.internal.system.proximity.filter.PauseProximityFilter;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.proximation.ProximityInstaller;

public class ProximityInstallerImpl
implements ProximityInstaller {
    static int INTERNAL_INTERACTION_TYPE_OTHER = 0;
    static int INTERNAL_INTERACTION_TYPE_VIEW_CHANGE = 1;
    private final IntObjectMap mapInteractionTypeToComponent;
    private final PauseProximityFilter pauseFilter;
    private final Logger logger;
    private IntIntMap mapReasonToPauseCount = new IntIntOptHashMap();
    private boolean pauseValue;

    public ProximityInstallerImpl(IntObjectMap intObjectMap, PauseProximityFilter pauseProximityFilter, Logger logger) {
        this.mapInteractionTypeToComponent = intObjectMap;
        this.pauseFilter = pauseProximityFilter;
        this.logger = logger;
    }

    @Override
    public void pauseProximity(int n, boolean bl) {
        boolean bl2;
        this.verifyReason(n);
        boolean bl3 = bl2 = !this.pauseValue && bl;
        if (!this.checkIsPaused() || bl2) {
            this.pauseValue = bl;
            this.pauseFilter.pause(bl);
        }
        this.increatePauseCount(n);
    }

    @Override
    public void resumeProximity(int n) {
        this.verifyReason(n);
        if (this.mapReasonToPauseCount.get(n) == 0) {
            this.warn(new StringBuffer().append("Proximity was not paused before for reason ").append(n).toString());
        } else {
            this.decreasePauseCount(n);
            this.resumeProximity();
        }
    }

    @Override
    public void resetProximityPause(int n) {
        this.verifyReason(n);
        if (this.checkIsPaused()) {
            this.resetPauseCount(n);
            this.resumeProximity();
        }
    }

    @Override
    public void processUserInteraction() {
        this.processUserInteraction(INTERNAL_INTERACTION_TYPE_OTHER);
    }

    @Override
    public void processUserInteraction(int n) {
        if (!this.mapInteractionTypeToComponent.containsKey(n)) {
            throw new IllegalArgumentException(new StringBuffer().append("User interaction type ").append(n).append(" is not supported.").toString());
        }
        DefaultProximityUserInteractionComponent defaultProximityUserInteractionComponent = (DefaultProximityUserInteractionComponent)this.mapInteractionTypeToComponent.get(n);
        defaultProximityUserInteractionComponent.processUserInteraction();
    }

    private void resumeProximity() {
        if (!this.checkIsPaused()) {
            this.pauseFilter.resume();
        }
    }

    private void increatePauseCount(int n) {
        this.mapReasonToPauseCount.put(n, this.mapReasonToPauseCount.get(n) + 1);
    }

    private void decreasePauseCount(int n) {
        this.mapReasonToPauseCount.put(n, this.mapReasonToPauseCount.get(n) - 1);
    }

    private void resetPauseCount(int n) {
        this.mapReasonToPauseCount.put(n, 0);
    }

    private void verifyReason(int n) {
        if (n < 0 || n > 2) {
            throw new IllegalArgumentException(new StringBuffer().append("Illegal reason: ").append(n).toString());
        }
    }

    private boolean checkIsPaused() {
        boolean bl = false;
        IntIterator intIterator = this.mapReasonToPauseCount.valueIterator();
        while (intIterator.hasNext()) {
            bl |= intIterator.next() > 0;
        }
        return bl;
    }

    private void warn(String string) {
        this.logger.warn(2048, string);
    }
}

