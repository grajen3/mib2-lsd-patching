/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor.manager;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.system.processor.manager.MenuManager;

class MenuManager$1
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ MenuManager this$0;

    MenuManager$1(MenuManager menuManager) {
        this.this$0 = menuManager;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.this$0.installDefaultMenuMode();
        factoryResetCallback.notifyResetDone();
    }
}

