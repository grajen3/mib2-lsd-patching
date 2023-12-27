/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.events.commands;

import de.vw.mib.asl.internal.speechgeneral.events.framework.EventDispatcher;
import de.vw.mib.asl.internal.speechgeneral.events.framework.EventHandler;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.genericevents.EventGeneric;

public class RequestVisibilityAction
implements EventHandler {
    public static final int REQUEST_VISIBILITY;
    private final CioDictionary cioDictionary;
    private final CioDispatcher cioDispatcher;

    public RequestVisibilityAction(CioDictionary cioDictionary, CioDispatcher cioDispatcher, EventDispatcher eventDispatcher) {
        this.cioDictionary = cioDictionary;
        this.cioDispatcher = cioDispatcher;
        eventDispatcher.registerHandler(this);
    }

    protected void onAction() {
        CioIntent cioIntent = this.cioDictionary.getCioIntent("ShowContent", "HMI_SPEECHGENERAL");
        this.cioDispatcher.dispatch(cioIntent);
    }

    @Override
    public int[] getHandleEvents() {
        return new int[]{416559168};
    }

    @Override
    public void handleEvent(EventGeneric eventGeneric) {
        if (eventGeneric.getReceiverEventId() == 416559168) {
            this.onAction();
        }
    }
}

