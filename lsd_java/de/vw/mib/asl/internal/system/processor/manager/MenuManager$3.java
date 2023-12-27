/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor.manager;

import de.vw.mib.asl.framework.api.persistence2.AbstractProfileChangeHandler;
import de.vw.mib.asl.internal.system.processor.manager.MenuManager;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceService;

class MenuManager$3
extends AbstractProfileChangeHandler {
    private final /* synthetic */ SystemCommonPersistenceService val$persistenceService;
    private final /* synthetic */ MenuManager this$0;

    MenuManager$3(MenuManager menuManager, SystemCommonPersistenceService systemCommonPersistenceService) {
        this.this$0 = menuManager;
        this.val$persistenceService = systemCommonPersistenceService;
    }

    @Override
    protected void prepareForProfileChange() {
        this.notifyReadyForProfileSwitch();
    }

    @Override
    protected void changeProfile() {
        this.this$0.loadPersistence(this.val$persistenceService);
        this.notifyProfileChanged(true);
    }
}

