/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.communication.mainmenu;

import de.vw.mib.asl.api.speechengine.contexts.SpeechContextEmpty;
import de.vw.mib.asl.internal.speechphone.controller.SimpleCheckedPhoneAction;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;

public class MainMenuRequestHandler
extends SpeechContextEmpty {
    private final SpeechPhoneLogger2 logger;
    private SimpleCheckedPhoneAction globalCommandAction;

    public MainMenuRequestHandler(ServiceFunctions serviceFunctions, SimpleCheckedPhoneAction simpleCheckedPhoneAction) {
        this.globalCommandAction = simpleCheckedPhoneAction;
        this.logger = serviceFunctions.createLogger("MainMenuRequestHandler");
    }

    @Override
    public void enterMainView() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("will show phone use case teleprompter now which has been triggered by a different context");
        }
        this.globalCommandAction.triggerManually();
    }

    @Override
    public int getSpeechContextId() {
        return 4;
    }
}

