/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.teleprompter;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.speechengine.teleprompter.TeleprompterManager;
import de.vw.mib.asl.api.speechengine.teleprompter.TeleprompterStateConsumer;
import de.vw.mib.asl.internal.speechgeneral.events.framework.EventDispatcher;
import de.vw.mib.asl.internal.speechgeneral.events.framework.EventHandler;
import de.vw.mib.asl.internal.speechgeneral.utils.SpeechGeneralLogger;
import de.vw.mib.genericevents.EventGeneric;

public class TeleprompterStateHandler
implements TeleprompterStateConsumer,
EventHandler {
    private SpeechGeneralLogger logger = new SpeechGeneralLogger("[TeleprompterStateHandler] ", 4096);
    private final TeleprompterManager teleprompterManager;
    private final ASLPropertyManager aslPropertyManager;
    public static final int TOGGLE_TELE_PROMPTER_EVENT;

    public TeleprompterStateHandler(TeleprompterManager teleprompterManager, ASLPropertyManager aSLPropertyManager, EventDispatcher eventDispatcher) {
        this.teleprompterManager = teleprompterManager;
        this.aslPropertyManager = aSLPropertyManager;
        this.teleprompterManager.register(this);
        eventDispatcher.registerHandler(this);
    }

    public void toggleTeleprompterState() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("toggle teleprompter after button press").log();
        }
        this.teleprompterManager.toggle();
    }

    @Override
    public void onTeleprompterStateChanged(int n) {
        if (n == 0) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("show teleprompter").log();
            }
            this.aslPropertyManager.valueChangedInteger(335228928, 0);
        } else {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("hide teleprompter").log();
            }
            this.aslPropertyManager.valueChangedInteger(335228928, 1);
        }
    }

    @Override
    public int[] getHandleEvents() {
        return new int[]{315895872};
    }

    @Override
    public void handleEvent(EventGeneric eventGeneric) {
        if (eventGeneric.getReceiverEventId() == 315895872) {
            this.toggleTeleprompterState();
        }
    }
}

