/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.list;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogManager;
import de.vw.mib.asl.internal.speechgeneral.events.framework.EventDispatcher;
import de.vw.mib.asl.internal.speechgeneral.events.framework.EventHandler;
import de.vw.mib.genericevents.EventGeneric;

public class ListHandler
implements EventHandler {
    private final DialogManager dialogManager;

    public ListHandler(DialogManager dialogManager, EventDispatcher eventDispatcher) {
        this.dialogManager = dialogManager;
        eventDispatcher.registerHandler(this);
    }

    @Override
    public int[] getHandleEvents() {
        return new int[]{500445248};
    }

    @Override
    public void handleEvent(EventGeneric eventGeneric) {
        if (eventGeneric.getReceiverEventId() == 500445248) {
            this.dialogManager.pauseSession();
        }
    }
}

