/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.DynamicImage;

class DynamicImage$1
implements Runnable {
    private final /* synthetic */ DynamicImage this$0;

    DynamicImage$1(DynamicImage dynamicImage) {
        this.this$0 = dynamicImage;
    }

    @Override
    public void run() {
        this.this$0.setInternalStateFlag(15, false);
        this.this$0.validate();
    }
}

