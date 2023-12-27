/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.controller;

import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.genericevents.EventGeneric;

public class OnlinePOIDialogController
implements ModelEventConsumer,
RecognizedEventConsumer {
    private final String logPrefix;
    public static final int RESUME_CMD_ENTER_POI_ONLINE;
    public static final int RESUME_CMD_ENTER_POI_ONLINE_NAVCHECK;
    public static final int CMD_DLG_ENTER_POI_ONLINE;

    public OnlinePOIDialogController() {
        this.logPrefix = "[SN][OnlinePOI][OnlinePOIDialogController] ";
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1640053: {
                AppLogger.trace("[SN][OnlinePOI][OnlinePOIDialogController] Starting online POI search dialog.");
                this.openDialog();
                break;
            }
            case 1640054: {
                AppLogger.trace("[SN][OnlinePOI][OnlinePOIDialogController] Starting online POI search dialog with navcheck prompt.");
                this.openDialogNavCheck();
                break;
            }
            case 1077141937: {
                AppLogger.trace("[SN][OnlinePOI][OnlinePOIDialogController] Received request for opening POI search dialog again via back command.");
                this.openDialogAgain();
                break;
            }
            default: {
                AppLogger.warn(new StringBuffer().append("[SN][OnlinePOI][OnlinePOIDialogController] received but discarded generic event with id ").append(n).append(".").toString());
            }
        }
    }

    @Override
    public void onRecognizedEvent(int n) {
        if (n == -1310641344) {
            AppLogger.trace("[SN][OnlinePOI][OnlinePOIDialogController] Received request for opening POI search dialog again.");
            this.openDialogAgain();
        } else {
            AppLogger.warn(new StringBuffer().append("[SN][OnlinePOI][OnlinePOIDialogController] received but discarded recognized event with id ").append(n).append(".").toString());
        }
    }

    private void openDialog() {
        Framework.fireUIEvent(235484160);
    }

    private void openDialogNavCheck() {
        Framework.fireUIEvent(1762210816);
    }

    private void openDialogAgain() {
        Framework.fireUIEvent(252261376);
    }
}

