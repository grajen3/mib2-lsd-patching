/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.controller;

import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.genericevents.EventGeneric;

public class OnboardPOIEnterPOIController
implements ModelEventConsumer,
RecognizedEventConsumer {
    public static final int RESUME_CMD_ENTER_POI;
    public static final int CMD_DLG_ENTER_POI_AGAIN;
    public static final int CMD_DLG_STATE_AGAIN_NBEST_POI;

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1640043: {
                this.onEnterPOI();
                break;
            }
            default: {
                AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", unhandle generic event ").append(n).toString());
            }
        }
    }

    @Override
    public void onRecognizedEvent(int n) {
        if (n == -1579076800 || n == -1545522368) {
            this.onEnterPOIAgain();
        } else {
            AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", unhandle recognition event ").append(n).toString());
        }
    }

    private void onEnterPOI() {
        Framework.fireUIEvent(-385338368);
    }

    public static void enterPOIs() {
        Framework.fireEvent(1795561728);
    }

    private void onEnterPOIAgain() {
        this.notifyEnterPOIAgain();
    }

    private void notifyEnterPOIAgain() {
        Framework.fireUIEvent(-368561152);
    }
}

