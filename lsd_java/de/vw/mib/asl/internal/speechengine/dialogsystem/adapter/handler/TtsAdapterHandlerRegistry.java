/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler;

import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AdapterHandlerRegistry;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsLanguageChangeHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsStartupHandler;
import java.util.List;
import org.dsi.ifc.tts.LanguageVoiceInfo;

public class TtsAdapterHandlerRegistry
extends AdapterHandlerRegistry {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsStartupHandler;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsLanguageChangeHandler;

    public void dsiTtsResponseInit(short s, int n) {
        List list = this.getHandlerList(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsStartupHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsStartupHandler = TtsAdapterHandlerRegistry.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsStartupHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsStartupHandler);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            TtsStartupHandler ttsStartupHandler = (TtsStartupHandler)list.get(i2);
            if (s != ttsStartupHandler.getSourceId()) continue;
            ttsStartupHandler.responseInit(s, n);
        }
    }

    public void dsiTtsResponsePlayTone(short s, int n) {
        List list = this.getHandlerList(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler = TtsAdapterHandlerRegistry.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            TtsHandler ttsHandler = (TtsHandler)list.get(i2);
            if (s != ttsHandler.getSourceId()) continue;
            ttsHandler.responsePlayTone(s, n);
        }
    }

    public void dsiTtsResponseSpeakPrompt(short s, int n) {
        List list = this.getHandlerList(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler = TtsAdapterHandlerRegistry.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            TtsHandler ttsHandler = (TtsHandler)list.get(i2);
            if (s != ttsHandler.getSourceId()) continue;
            ttsHandler.responseSpeakPrompt(s, n);
        }
    }

    public void dsiTtsResponseAudioTrigger(short s, int n) {
        List list = this.getHandlerList(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler = TtsAdapterHandlerRegistry.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            TtsHandler ttsHandler = (TtsHandler)list.get(i2);
            if (s != ttsHandler.getSourceId()) continue;
            ttsHandler.responseAudioTrigger(s, n);
        }
    }

    public void dsiTtsUpdateAudioRequest(int n, int n2) {
        List list = this.getHandlerList(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler = TtsAdapterHandlerRegistry.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            TtsHandler ttsHandler = (TtsHandler)list.get(i2);
            if (n2 != 1) continue;
            ttsHandler.updateAudioRequest(n, n2);
        }
    }

    public void dsiTtsResponseSetLanguage(short s, int n) {
        List list = this.getHandlerList(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsLanguageChangeHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsLanguageChangeHandler = TtsAdapterHandlerRegistry.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsLanguageChangeHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsLanguageChangeHandler);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            TtsLanguageChangeHandler ttsLanguageChangeHandler = (TtsLanguageChangeHandler)list.get(i2);
            ttsLanguageChangeHandler.responseSetLanguage(s, n);
        }
    }

    public void dsiTtsUpdateAvailableLanguages(LanguageVoiceInfo[] languageVoiceInfoArray, int n) {
        if (n == 1) {
            List list = this.getHandlerList(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsLanguageChangeHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsLanguageChangeHandler = TtsAdapterHandlerRegistry.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsLanguageChangeHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsLanguageChangeHandler);
            for (int i2 = 0; i2 < list.size(); ++i2) {
                TtsLanguageChangeHandler ttsLanguageChangeHandler = (TtsLanguageChangeHandler)list.get(i2);
                ttsLanguageChangeHandler.updateAvailableLanguages(languageVoiceInfoArray);
            }
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

