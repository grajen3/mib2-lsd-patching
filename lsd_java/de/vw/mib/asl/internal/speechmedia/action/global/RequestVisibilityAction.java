/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.action.global;

import de.vw.mib.asl.internal.speechmedia.action.Action;
import de.vw.mib.asl.internal.speechmedia.utils.SpeechMediaServiceManager;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.genericevents.EventGeneric;

public class RequestVisibilityAction
implements Action {
    private static final int REQUEST_VISIBILITY;
    private final CioDictionary cioDictionary;
    private final CioDispatcher cioDispatcher;

    public RequestVisibilityAction(SpeechMediaServiceManager speechMediaServiceManager) {
        this.cioDictionary = speechMediaServiceManager.getCioDictionary();
        this.cioDispatcher = speechMediaServiceManager.getCioDispatcher();
    }

    @Override
    public void onRecognizedEvent(int n) {
        if (n == -916835776) {
            this.onAction();
        }
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        if (n == -916835776) {
            this.onAction();
        }
    }

    protected void onAction() {
        CioIntent cioIntent = this.cioDictionary.getCioIntent("ShowContent", "HMI_SPEECHMEDIA");
        this.cioDispatcher.dispatch(cioIntent);
    }

    @Override
    public int getDownEvent() {
        return -916835776;
    }
}

