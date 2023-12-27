/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.gridmenu;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.impl.gridmenu.MainMenuTarget;

class MainMenuTarget$1
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ MainMenuTarget this$0;

    MainMenuTarget$1(MainMenuTarget mainMenuTarget) {
        this.this$0 = mainMenuTarget;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.this$0.gridMenuPersistable.resetToDefaults();
        this.this$0.reinitalizeMenu();
        factoryResetCallback.notifyResetDone();
    }
}

