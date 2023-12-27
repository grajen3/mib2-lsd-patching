/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.popup;

import de.vw.mib.desktop.internal.popup.DynamicStateData;

class DynamicStateData$1
implements Runnable {
    private int internalSequenceNr;
    private final /* synthetic */ DynamicStateData this$0;

    DynamicStateData$1(DynamicStateData dynamicStateData) {
        this.this$0 = dynamicStateData;
        this.internalSequenceNr = this.this$0.sequenceNr;
    }

    @Override
    public void run() {
        this.this$0.doTimeout(this.internalSequenceNr);
    }
}

