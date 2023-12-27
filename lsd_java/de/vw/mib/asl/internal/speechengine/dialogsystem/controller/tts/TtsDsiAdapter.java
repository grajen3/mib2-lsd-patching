/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyAdapterFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.DSIAdapter;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AdapterHandlerRegistry;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsAdapterHandlerRegistry;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tts.DSITTS;
import org.dsi.ifc.tts.LanguageVoiceInfo;

public class TtsDsiAdapter
extends AbstractTarget
implements DSIAdapter {
    private final String TRACE_PREFIX;
    private static final int TRACE_CLASS;
    private Logger logger;
    private DSITTS dsiTts;
    private DSIListener dsiTtsListener;
    private final TtsAdapterHandlerRegistry ttsAdapterHandlerReg;
    private final int dsiInstanceId;
    static /* synthetic */ Class class$org$dsi$ifc$tts$DSITTS;
    static /* synthetic */ Class class$org$dsi$ifc$tts$DSITTSListener;

    public TtsDsiAdapter(GenericEvents genericEvents, String string, Logger logger, TtsAdapterHandlerRegistry ttsAdapterHandlerRegistry, int n, int n2) {
        super(genericEvents, n2, string);
        this.logger = logger;
        this.ttsAdapterHandlerReg = ttsAdapterHandlerRegistry;
        this.dsiInstanceId = n;
        this.TRACE_PREFIX = new StringBuffer().append("[TtsDsiAdapter[").append(this.dsiInstanceId).append("]]: ").toString();
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
    }

    @Override
    public int getDefaultTargetId() {
        return 0;
    }

    @Override
    public DSIBase getDSIProxy() {
        return this.dsiTts;
    }

    @Override
    public void initDSIProxy() {
        this.logger.trace(1024, new StringBuffer().append(this.TRACE_PREFIX).append("initProxy").toString());
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        DSIProxyAdapterFactory dSIProxyAdapterFactory = dSIProxy.getAdapterFactory();
        this.dsiTts = (DSITTS)dSIProxy.getService(this, class$org$dsi$ifc$tts$DSITTS == null ? (class$org$dsi$ifc$tts$DSITTS = TtsDsiAdapter.class$("org.dsi.ifc.tts.DSITTS")) : class$org$dsi$ifc$tts$DSITTS, this.dsiInstanceId);
        this.dsiTtsListener = dSIProxyAdapterFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$tts$DSITTSListener == null ? (class$org$dsi$ifc$tts$DSITTSListener = TtsDsiAdapter.class$("org.dsi.ifc.tts.DSITTSListener")) : class$org$dsi$ifc$tts$DSITTSListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$tts$DSITTSListener == null ? (class$org$dsi$ifc$tts$DSITTSListener = TtsDsiAdapter.class$("org.dsi.ifc.tts.DSITTSListener")) : class$org$dsi$ifc$tts$DSITTSListener, this.dsiInstanceId, this.dsiTtsListener);
        this.dsiTts.setNotification(this.dsiTtsListener);
    }

    @Override
    public void uninitDSIProxy() {
        this.dsiTts = null;
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        dSIProxy.removeResponseListener(this, class$org$dsi$ifc$tts$DSITTSListener == null ? (class$org$dsi$ifc$tts$DSITTSListener = TtsDsiAdapter.class$("org.dsi.ifc.tts.DSITTSListener")) : class$org$dsi$ifc$tts$DSITTSListener, this.dsiInstanceId, this.dsiTtsListener);
    }

    @Override
    public int getInstanceId() {
        return this.dsiInstanceId;
    }

    @Override
    public void trackSwapState() {
    }

    @Override
    public AdapterHandlerRegistry getAdapterHandlerRegistry() {
        return this.ttsAdapterHandlerReg;
    }

    public void dsiTTSResponseInit(short s, int n) {
        if (this.logger.isTraceEnabled(1024)) {
            LogMessage logMessage = this.logger.trace(1024);
            logMessage.append(this.TRACE_PREFIX);
            logMessage.append("responseInit( ");
            logMessage.append(n);
            logMessage.append(" )");
            logMessage.log();
        }
        this.ttsAdapterHandlerReg.dsiTtsResponseInit(s, n);
    }

    public void dsiTTSResponsePlayTone(short s, int n) {
        if (this.logger.isTraceEnabled(1024)) {
            LogMessage logMessage = this.logger.trace(1024);
            logMessage.append(this.TRACE_PREFIX);
            logMessage.append("responsePlayTone( ");
            logMessage.append(n);
            logMessage.append(" )");
            logMessage.log();
        }
        this.ttsAdapterHandlerReg.dsiTtsResponsePlayTone(s, n);
    }

    public void dsiTTSResponseSpeakPrompt(short s, int n) {
        if (this.logger.isTraceEnabled(1024)) {
            LogMessage logMessage = this.logger.trace(1024);
            logMessage.append(this.TRACE_PREFIX);
            logMessage.append("responseSpeakPrompt( ");
            logMessage.append(n);
            logMessage.append(" )");
            logMessage.log();
        }
        this.ttsAdapterHandlerReg.dsiTtsResponseSpeakPrompt(s, n);
    }

    public void dsiTTSResponseAudioTrigger(short s, int n) {
        if (this.logger.isTraceEnabled(1024)) {
            LogMessage logMessage = this.logger.trace(1024);
            logMessage.append(this.TRACE_PREFIX);
            logMessage.append("responseAudioTrigger( ");
            logMessage.append(n);
            logMessage.append(" )");
            logMessage.log();
        }
        this.ttsAdapterHandlerReg.dsiTtsResponseAudioTrigger(s, n);
    }

    public void dsiTTSUpdateAudioRequest(int n, int n2) {
        if (this.logger.isTraceEnabled(1024)) {
            LogMessage logMessage = this.logger.trace(1024);
            logMessage.append(this.TRACE_PREFIX);
            logMessage.append("updateAudioRequest( ");
            logMessage.append(n);
            logMessage.append(" )");
            logMessage.log();
        }
        this.ttsAdapterHandlerReg.dsiTtsUpdateAudioRequest(n, n2);
    }

    public void dsiTTSResponseSetLanguage(short s, int n) {
        if (this.logger.isTraceEnabled(1024)) {
            LogMessage logMessage = this.logger.trace(1024);
            logMessage.append(this.TRACE_PREFIX);
            logMessage.append("responseSetLanguage( ");
            logMessage.append(n);
            logMessage.append(" )");
            logMessage.log();
        }
        this.ttsAdapterHandlerReg.dsiTtsResponseSetLanguage(s, n);
    }

    public void dsiTTSUpdateAvailableLanguages(LanguageVoiceInfo[] languageVoiceInfoArray, int n) {
        if (this.logger.isTraceEnabled(1024)) {
            LogMessage logMessage = this.logger.trace(1024);
            logMessage.append(this.TRACE_PREFIX);
            logMessage.append("updateAvailableLanguages( ");
            logMessage.append(languageVoiceInfoArray);
            logMessage.append(" )");
            logMessage.log();
        }
        this.ttsAdapterHandlerReg.dsiTtsUpdateAvailableLanguages(languageVoiceInfoArray, n);
    }

    public void dsiTTSAsyncException(int n, String string, int n2) {
        this.ttsAdapterHandlerReg.asyncException(n, string, n2);
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

