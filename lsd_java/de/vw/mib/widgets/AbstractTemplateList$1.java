/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.AbstractTemplateList;

class AbstractTemplateList$1
implements Runnable {
    private final /* synthetic */ AbstractTemplateList this$0;

    AbstractTemplateList$1(AbstractTemplateList abstractTemplateList) {
        this.this$0 = abstractTemplateList;
    }

    @Override
    public void run() {
        this.this$0.followModeTimerRunning = false;
        this.this$0.invalidateList(16);
    }
}

