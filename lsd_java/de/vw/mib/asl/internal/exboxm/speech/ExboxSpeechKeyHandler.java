/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.speech;

import de.vw.mib.asl.api.system.DoublePressKeyAdapter;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.exboxm.speech.ExboxSpeechKeyHandlerListener;
import de.vw.mib.asl.internal.exboxm.util.ExboxLogger;
import de.vw.mib.asl.internal.exboxm.util.Preconditions;
import de.vw.mib.log4mib.Logger;

public class ExboxSpeechKeyHandler
extends DoublePressKeyAdapter {
    private final ExboxSpeechKeyHandlerListener exboxSpeechKeyHandlerListener;
    private ExboxLogger exboxLogger;
    public static final int[] SPEECH_ABORT_KEYS = new int[]{11, 1, 2, 3, 4, 5, 16, 13, 20, 21, 26, 18, 6, 17, 19, 23, 24, 25, 34, 33};
    static /* synthetic */ Class class$de$vw$mib$asl$internal$exboxm$speech$ExboxSpeechKeyHandler;

    public ExboxSpeechKeyHandler(ExboxSpeechKeyHandlerListener exboxSpeechKeyHandlerListener, Logger logger, Services services) {
        super(services);
        Preconditions.checkArgumentNotNull(exboxSpeechKeyHandlerListener, "The exboxSpeechKeyHandlerListener must not be null.");
        Preconditions.checkArgumentNotNull(logger, "The logger must not be null.");
        this.exboxSpeechKeyHandlerListener = exboxSpeechKeyHandlerListener;
        this.exboxLogger = new ExboxLogger(logger, class$de$vw$mib$asl$internal$exboxm$speech$ExboxSpeechKeyHandler == null ? (class$de$vw$mib$asl$internal$exboxm$speech$ExboxSpeechKeyHandler = ExboxSpeechKeyHandler.class$("de.vw.mib.asl.internal.exboxm.speech.ExboxSpeechKeyHandler")) : class$de$vw$mib$asl$internal$exboxm$speech$ExboxSpeechKeyHandler);
    }

    private boolean isAbortKey(int n) {
        for (int i2 = 0; i2 < SPEECH_ABORT_KEYS.length; ++i2) {
            if (n != SPEECH_ABORT_KEYS[i2]) continue;
            return true;
        }
        return false;
    }

    @Override
    public void onDoublePressed(int n) {
        if (n == 15) {
            this.exboxSpeechKeyHandlerListener.onSpeechKeyDoublePressed();
        } else if (!this.isAbortKey(n)) {
            this.exboxLogger.error(new StringBuffer().append("Got onDoublePressed event with unexpected keyId: ").append(n).toString());
        }
    }

    @Override
    public void onSinglePressed(int n) {
        if (this.isAbortKey(n)) {
            this.exboxSpeechKeyHandlerListener.onSpeechAbortKeyPressed();
        } else if (n == 15) {
            this.exboxSpeechKeyHandlerListener.onSpeechKeyPressed();
        } else {
            this.exboxLogger.error(new StringBuffer().append("Got onSinglePressed event with unexpected keyId: ").append(n).toString());
        }
    }

    @Override
    public void onSingleReleased(int n) {
        if (n == 15) {
            this.exboxSpeechKeyHandlerListener.onSpeechKeyReleased();
        } else if (!this.isAbortKey(n)) {
            this.exboxLogger.error(new StringBuffer().append("Got onSingleReleased event with unexpected keyId: ").append(n).toString());
        }
    }

    @Override
    public void onUltraLongPressed(int n) {
        if (n == 15) {
            this.exboxSpeechKeyHandlerListener.onSpeechKeyUltraLongPressed();
        } else if (!this.isAbortKey(n)) {
            this.exboxLogger.error(new StringBuffer().append("Got onUltraLongPressed event with unexpected keyId: ").append(n).toString());
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

