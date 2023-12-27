/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.timer.Timer;
import de.vw.mib.widgets.AbstractSlider;
import de.vw.mib.widgets.AbstractSlider$ValueCache$1;
import de.vw.mib.widgets.internal.ServiceManager;

class AbstractSlider$ValueCache {
    private static final String TIMER_NAME;
    private Timer valueChangeShadowTimer;
    private int cacheValue;
    private final /* synthetic */ AbstractSlider this$0;

    public AbstractSlider$ValueCache(AbstractSlider abstractSlider) {
        this.this$0 = abstractSlider;
    }

    public void setValue(int n) {
        this.this$0.trace(new StringBuffer().append(" - ValueCache.setValue();; newCacheValue: ").append(n).append(", oldCacheValue: ").append(this.cacheValue).toString());
        this.cacheValue = n;
    }

    public boolean isShadowEnabled() {
        return this.valueChangeShadowTimer != null;
    }

    void startValueChangeShadowTimer() {
        int n;
        if (this.isShadowEnabled()) {
            this.stopValueChangeShadowTimer(false);
        }
        if (!this.isShadowEnabled() && (n = this.this$0.getValueChangeTimer()) > 0) {
            this.valueChangeShadowTimer = ServiceManager.timerManager.createTimer("AbstractSlider.ValueCache.ShadowTimer", n, false, new AbstractSlider$ValueCache$1(this), ServiceManager.eventDispatcher);
            this.valueChangeShadowTimer.start();
        }
    }

    void stopValueChangeShadowTimer(boolean bl) {
        if (this.valueChangeShadowTimer != null) {
            this.valueChangeShadowTimer.stop();
            this.valueChangeShadowTimer = null;
        }
        this.this$0.trace(new StringBuffer().append(" - ValueCache.stopValueChangeShadowTimer(), cacheValue: ").append(this.cacheValue).append(", currentOldSliderValue: ").append(this.this$0.get_value()).append(", propagateLastCacheValue: ").append(bl).toString());
        if (bl) {
            this.this$0.set_value(this.cacheValue);
        }
    }

    static /* synthetic */ AbstractSlider access$000(AbstractSlider$ValueCache abstractSlider$ValueCache) {
        return abstractSlider$ValueCache.this$0;
    }
}

