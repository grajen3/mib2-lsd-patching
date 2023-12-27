/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal;

import de.vw.mib.desktop.internal.ScreenAreaDude;
import de.vw.mib.desktop.internal.common.ServiceManager;

class ScreenAreaDude$1
implements Runnable {
    private final /* synthetic */ ScreenAreaDude this$0;

    ScreenAreaDude$1(ScreenAreaDude screenAreaDude) {
        this.this$0 = screenAreaDude;
    }

    @Override
    public void run() {
        if (this.this$0.currentViewHandler != null) {
            this.this$0.logger.warn(2).append("View ").append(this.this$0.currentViewHandler.getNameForTraces()).append(" abandoned for more than ").append(ServiceManager.configurationManager.getViewManagerWaitStateTimeout2()).append("ms!").log();
        }
    }
}

