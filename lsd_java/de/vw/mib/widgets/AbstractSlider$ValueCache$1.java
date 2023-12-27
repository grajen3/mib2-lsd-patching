/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.AbstractSlider$ValueCache;

class AbstractSlider$ValueCache$1
implements Runnable {
    private final /* synthetic */ AbstractSlider$ValueCache this$1;

    AbstractSlider$ValueCache$1(AbstractSlider$ValueCache abstractSlider$ValueCache) {
        this.this$1 = abstractSlider$ValueCache;
    }

    @Override
    public void run() {
        AbstractSlider$ValueCache.access$000(this.this$1).trace(", valueChangeShadowTimer.run() -> stopValueChangeShadowTimer()");
        this.this$1.stopValueChangeShadowTimer(true);
    }
}

