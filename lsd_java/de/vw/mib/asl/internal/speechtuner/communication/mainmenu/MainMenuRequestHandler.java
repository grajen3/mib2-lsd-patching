/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.communication.mainmenu;

import de.vw.mib.asl.api.speechengine.contexts.SpeechContextEmpty;
import de.vw.mib.asl.internal.speechtuner.controller.ShowRadioAction;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerLogger;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;

public class MainMenuRequestHandler
extends SpeechContextEmpty {
    private static final String LOGGER_PREFIX;
    protected SpeechTunerServiceManager serviceManager;
    protected SpeechTunerLogger logger;
    private final ShowRadioAction showRadioAction;

    public MainMenuRequestHandler(SpeechTunerServiceManager speechTunerServiceManager, ShowRadioAction showRadioAction) {
        this.serviceManager = speechTunerServiceManager;
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[MainMenuRequestHandler] ");
        this.showRadioAction = showRadioAction;
    }

    @Override
    public void enterMainView() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("will show radio use case teleprompter now which has been triggered by a different context");
        }
        this.showRadioAction.triggerManually();
    }

    @Override
    public int getSpeechContextId() {
        return 5;
    }
}

