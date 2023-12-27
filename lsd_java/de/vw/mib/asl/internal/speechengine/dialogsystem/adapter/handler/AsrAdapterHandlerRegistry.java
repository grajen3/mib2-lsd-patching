/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler;

import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AdapterHandlerRegistry;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsrDeviceFailureHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsrLanguageChangeHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsrStartupHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.GrammarHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.GroupItemRequestHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.RecognitionHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.SwapHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.VdeCapabilityHandler;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.speechrec.GrammarInfo;
import org.dsi.ifc.speechrec.GrammarStateInfo;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.VDECapabilities;

public class AsrAdapterHandlerRegistry
extends AdapterHandlerRegistry {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrStartupHandler;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$SwapHandler;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GrammarHandler;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$VdeCapabilityHandler;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrLanguageChangeHandler;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GroupItemRequestHandler;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrDeviceFailureHandler;

    public void dsiSpeechRecResponseInit(int n) {
        List list = this.getHandlerList(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrStartupHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrStartupHandler = AsrAdapterHandlerRegistry.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsrStartupHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrStartupHandler);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            ((AsrStartupHandler)list.get(i2)).responseInit(n);
        }
    }

    public void dsiSpeechRecResponseStartRecognition(int n) {
        List list = this.getHandlerList(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler = AsrAdapterHandlerRegistry.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.RecognitionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            ((RecognitionHandler)list.get(i2)).responseStartRecognition(n);
        }
    }

    public void dsiSpeechRecResponseWaitForResults(int n, NBestList nBestList) {
        List list = this.getHandlerList(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler = AsrAdapterHandlerRegistry.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.RecognitionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            ((RecognitionHandler)list.get(i2)).responseWaitForResults(n, nBestList);
        }
    }

    public void dsiSpeechRecUpdateRecognizerState(int n) {
        List list = this.getHandlerList(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler = AsrAdapterHandlerRegistry.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.RecognitionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            ((RecognitionHandler)list.get(i2)).updateRecognizerState(n);
        }
    }

    public void dsiSpeechRecUpdateSdsAvailability(int n) {
        List list = this.getHandlerList(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$SwapHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$SwapHandler = AsrAdapterHandlerRegistry.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.SwapHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$SwapHandler);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            ((SwapHandler)list.get(i2)).setSdsAvailability(n);
        }
    }

    public void dsiSpeechRecResponseLoadGrammar(int n, GrammarInfo[] grammarInfoArray) {
        List list = this.getHandlerList(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GrammarHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GrammarHandler = AsrAdapterHandlerRegistry.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.GrammarHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GrammarHandler);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            ((GrammarHandler)list.get(i2)).responseLoadGrammar(n, grammarInfoArray);
        }
    }

    public void dsiSpeechRecResponseUnloadGrammar(int n, GrammarInfo[] grammarInfoArray) {
        List list = this.getHandlerList(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GrammarHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GrammarHandler = AsrAdapterHandlerRegistry.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.GrammarHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GrammarHandler);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            ((GrammarHandler)list.get(i2)).responseUnloadGrammar(n, grammarInfoArray);
        }
    }

    public void dsiSpeechUpdateGrammarState(GrammarStateInfo grammarStateInfo) {
        List list = this.getHandlerList(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GrammarHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GrammarHandler = AsrAdapterHandlerRegistry.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.GrammarHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GrammarHandler);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            ((GrammarHandler)list.get(i2)).updateGrammarState(grammarStateInfo);
        }
    }

    public void dsiSpeechRecResponseRequestVDECapabilities(int n, VDECapabilities vDECapabilities) {
        List list = this.getHandlerList(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$VdeCapabilityHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$VdeCapabilityHandler = AsrAdapterHandlerRegistry.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.VdeCapabilityHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$VdeCapabilityHandler);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            ((VdeCapabilityHandler)list.get(i2)).responseRequestVDECapabilities(n, vDECapabilities);
        }
    }

    public void dsiSpeechRecResponseSetLanguage(int n) {
        List list = this.getHandlerList(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrLanguageChangeHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrLanguageChangeHandler = AsrAdapterHandlerRegistry.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsrLanguageChangeHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrLanguageChangeHandler);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            ((AsrLanguageChangeHandler)list.get(i2)).responseSetLanguage(n);
        }
    }

    public void dsiSpeechRecUpdateAvailableLanguages(String[] stringArray) {
        List list = this.getHandlerList(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrLanguageChangeHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrLanguageChangeHandler = AsrAdapterHandlerRegistry.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsrLanguageChangeHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrLanguageChangeHandler);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            ((AsrLanguageChangeHandler)list.get(i2)).updateAvailableLanguages(stringArray);
        }
    }

    public void dsiSpeechRecResponseRequestGraphemicGroupAsNBestList(int n, NBestList nBestList) {
        List list = this.getHandlerList(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GroupItemRequestHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GroupItemRequestHandler = AsrAdapterHandlerRegistry.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.GroupItemRequestHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GroupItemRequestHandler);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            ((GroupItemRequestHandler)list.get(i2)).responseRequestGraphemicGroupAsNBestList(n, nBestList);
        }
    }

    public void dsiSpeechRecUpdateFailure(boolean bl) {
        List list = this.getHandlerList(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrDeviceFailureHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrDeviceFailureHandler = AsrAdapterHandlerRegistry.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsrDeviceFailureHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrDeviceFailureHandler);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ((AsrDeviceFailureHandler)iterator.next()).dsiSpeechRecUpdateFailure();
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

