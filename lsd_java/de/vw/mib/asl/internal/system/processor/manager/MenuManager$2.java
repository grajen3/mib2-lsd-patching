/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor.manager;

import de.vw.mib.asl.internal.system.processor.manager.MenuManager;
import de.vw.mib.configuration.NvListener;

class MenuManager$2
implements NvListener {
    private final /* synthetic */ MenuManager this$0;

    MenuManager$2(MenuManager menuManager) {
        this.this$0 = menuManager;
    }

    @Override
    public void notifyNvListener(int n) {
        this.this$0.updateMenuModeToSkinRestrictions();
        this.this$0.updateMenuModeAvailability();
    }
}

