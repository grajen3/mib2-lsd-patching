/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.controller;

import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.genericevents.EventGeneric;

public class RequestVisibilityAction
implements RecognizedEventConsumer,
ModelEventConsumer {
    public static final int REQUEST_VISIBILITY;
    private final CioDictionary cioDictionary;
    private final CioDispatcher cioDispatcher;

    public RequestVisibilityAction(CioDictionary cioDictionary, CioDispatcher cioDispatcher) {
        this.cioDictionary = cioDictionary;
        this.cioDispatcher = cioDispatcher;
    }

    @Override
    public void onRecognizedEvent(int n) {
        if (n == -470075072) {
            this.onAction();
        }
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        if (n == -470075072) {
            this.onAction();
        }
    }

    protected void onAction() {
        CioIntent cioIntent = this.cioDictionary.getCioIntent("ShowContent", "HMI_SPEECHTUNER");
        this.cioDispatcher.dispatch(cioIntent);
    }

    public int getDownEvent() {
        return -470075072;
    }
}

