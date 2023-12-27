/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts.config;

import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsLanguageChangeHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.DialogSystemConfigCallback;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts.TtsController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.util.Mappings$TtsSourceIds;
import de.vw.mib.asl.internal.speechengine.task.AbstractTask;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.tts.LanguageVoiceInfo;

public class SetTtsLanguage
extends AbstractTask
implements TtsLanguageChangeHandler {
    private static final int TRACE_CLASS;
    private final TtsController ttsController;
    private final String languageCode;
    private final int skinId;
    private final short sourceId;
    private final int voiceId;
    private final int promptMode;
    private final int transactionId;
    private final DialogSystemConfigCallback callbackListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsLanguageChangeHandler;

    public SetTtsLanguage(Logger logger, TtsController ttsController, String string, int n, int n2, int n3, int n4, DialogSystemConfigCallback dialogSystemConfigCallback) {
        super(logger);
        this.ttsController = ttsController;
        this.languageCode = string;
        this.skinId = n;
        this.voiceId = n2;
        this.promptMode = n3;
        this.transactionId = n4;
        this.callbackListener = dialogSystemConfigCallback;
        this.sourceId = Mappings$TtsSourceIds.getSourceIdByInstanceId(this.ttsController.getInstanceId());
    }

    @Override
    public void execute() {
        this.ttsController.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsLanguageChangeHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsLanguageChangeHandler = SetTtsLanguage.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsLanguageChangeHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsLanguageChangeHandler, this);
        this.ttsController.getTts().setLanguage(this.sourceId, this.languageCode, this.skinId, this.voiceId, this.promptMode);
    }

    @Override
    public void terminate() {
        this.ttsController.getHandlerRegistry().removeHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsLanguageChangeHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsLanguageChangeHandler = SetTtsLanguage.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsLanguageChangeHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsLanguageChangeHandler, this);
    }

    @Override
    public void abort() {
    }

    @Override
    public void responseSetLanguage(short s, int n) {
        boolean bl;
        if (s != this.sourceId) {
            return;
        }
        boolean bl2 = bl = n == 0;
        if (!bl) {
            this.taskLogger.error(4096, new StringBuffer().append("Error (will be ignored) in response of DSITTSListener#responseSetLanguage: ").append(n).toString());
        }
        if (this.callbackListener != null) {
            this.callbackListener.setLanguageCallback(this.transactionId, bl);
        }
        this.notifyFinishedSuccessful();
    }

    @Override
    public void updateAvailableLanguages(LanguageVoiceInfo[] languageVoiceInfoArray) {
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

