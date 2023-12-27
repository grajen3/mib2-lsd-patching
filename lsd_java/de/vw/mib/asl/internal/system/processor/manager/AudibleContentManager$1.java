/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor.manager;

import de.vw.mib.asl.framework.api.persistence2.AbstractProfileChangeHandler;
import de.vw.mib.asl.internal.system.processor.manager.AudibleContentManager;

class AudibleContentManager$1
extends AbstractProfileChangeHandler {
    private final /* synthetic */ AudibleContentManager this$0;

    AudibleContentManager$1(AudibleContentManager audibleContentManager) {
        this.this$0 = audibleContentManager;
    }

    @Override
    protected void prepareForProfileChange() {
        this.notifyReadyForProfileSwitch();
    }

    @Override
    protected void changeProfile() {
        this.this$0.loadPersistence();
        this.notifyProfileChanged(true);
    }
}

