/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.tts;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.tts.DynamicTTSPromptPart;
import org.dsi.ifc.tts.LanguageVoiceInfo;
import org.dsi.ifc.tts.TTSPrompt;

public final class DSITTSTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_DYNAMICTTSPROMPTPART;
    private static final int ID_LANGUAGEVOICEINFO;
    private static final int ID_TTSPROMPT;
    static /* synthetic */ Class class$org$dsi$ifc$tts$DynamicTTSPromptPart;
    static /* synthetic */ Class class$org$dsi$ifc$tts$LanguageVoiceInfo;
    static /* synthetic */ Class class$org$dsi$ifc$tts$TTSPrompt;

    public DSITTSTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tts$DynamicTTSPromptPart == null ? (class$org$dsi$ifc$tts$DynamicTTSPromptPart = DSITTSTracer.class$("org.dsi.ifc.tts.DynamicTTSPromptPart")) : class$org$dsi$ifc$tts$DynamicTTSPromptPart, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tts$LanguageVoiceInfo == null ? (class$org$dsi$ifc$tts$LanguageVoiceInfo = DSITTSTracer.class$("org.dsi.ifc.tts.LanguageVoiceInfo")) : class$org$dsi$ifc$tts$LanguageVoiceInfo, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tts$TTSPrompt == null ? (class$org$dsi$ifc$tts$TTSPrompt = DSITTSTracer.class$("org.dsi.ifc.tts.TTSPrompt")) : class$org$dsi$ifc$tts$TTSPrompt, 3);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceDynamicTTSPromptPart(printWriter, (DynamicTTSPromptPart)object);
                break;
            }
            case 2: {
                this.traceLanguageVoiceInfo(printWriter, (LanguageVoiceInfo)object);
                break;
            }
            case 3: {
                this.traceTTSPrompt(printWriter, (TTSPrompt)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceDynamicTTSPromptPart(PrintWriter printWriter, DynamicTTSPromptPart dynamicTTSPromptPart) {
        if (dynamicTTSPromptPart == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dynamicTTSPromptPart.key);
        printWriter.print(dynamicTTSPromptPart.value);
        printWriter.print(dynamicTTSPromptPart.alternativeText);
    }

    private void traceLanguageVoiceInfo(PrintWriter printWriter, LanguageVoiceInfo languageVoiceInfo) {
        int n;
        int n2;
        if (languageVoiceInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(languageVoiceInfo.language);
        if (languageVoiceInfo.voiceIDs == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = languageVoiceInfo.voiceIDs.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(languageVoiceInfo.voiceIDs[n]);
            }
        }
        if (languageVoiceInfo.voiceNames == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = languageVoiceInfo.voiceNames.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(languageVoiceInfo.voiceNames[n]);
            }
        }
    }

    private void traceTTSPrompt(PrintWriter printWriter, TTSPrompt tTSPrompt) {
        int n;
        int n2;
        if (tTSPrompt == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tTSPrompt.promptType);
        if (tTSPrompt.promptPartTexts == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = tTSPrompt.promptPartTexts.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(tTSPrompt.promptPartTexts[n]);
            }
        }
        if (tTSPrompt.promptPartIds == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = tTSPrompt.promptPartIds.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(tTSPrompt.promptPartIds[n]);
            }
        }
        if (tTSPrompt.dynamicParts == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = tTSPrompt.dynamicParts.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, tTSPrompt.dynamicParts[n]);
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

