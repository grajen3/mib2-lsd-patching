/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.messenger.indicator;

import de.vw.mib.asl.api.speechengine.messenger.indicator.IndicatorStateConsumer;

public interface IndicatorStateRouter {
    default public void register(IndicatorStateConsumer indicatorStateConsumer) {
    }

    default public void unregister(IndicatorStateConsumer indicatorStateConsumer) {
    }

    default public int getIndicatorState() {
    }
}

