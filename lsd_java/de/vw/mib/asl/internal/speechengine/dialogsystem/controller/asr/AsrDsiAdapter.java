/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyAdapterFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.DSIAdapter;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AdapterHandlerRegistry;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsrAdapterHandlerRegistry;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.speechrec.DSISpeechRec;
import org.dsi.ifc.speechrec.GrammarInfo;
import org.dsi.ifc.speechrec.GrammarStateInfo;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.VDECapabilities;

public class AsrDsiAdapter
extends AbstractTarget
implements DSIAdapter {
    private static final String TRACE_PREFIX;
    private static final int TRACE_CLASSIFIER;
    private Logger logger;
    private DSISpeechRec dsiSpeechRec;
    private DSIListener dsiSpeechRecListener;
    private AsrAdapterHandlerRegistry asrAdapterHandlerReg;
    static /* synthetic */ Class class$org$dsi$ifc$speechrec$DSISpeechRec;
    static /* synthetic */ Class class$org$dsi$ifc$speechrec$DSISpeechRecListener;

    public AsrDsiAdapter(GenericEvents genericEvents, String string, Logger logger, AsrAdapterHandlerRegistry asrAdapterHandlerRegistry) {
        super(genericEvents, string);
        this.logger = logger;
        this.asrAdapterHandlerReg = asrAdapterHandlerRegistry;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
    }

    @Override
    public int getDefaultTargetId() {
        return 361830400;
    }

    @Override
    public DSIBase getDSIProxy() {
        return this.dsiSpeechRec;
    }

    @Override
    public void initDSIProxy() {
        this.logger.trace(512, "[AsrDsiAdapter]: initProxy");
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        DSIProxyAdapterFactory dSIProxyAdapterFactory = dSIProxy.getAdapterFactory();
        this.dsiSpeechRec = (DSISpeechRec)dSIProxy.getService(this, class$org$dsi$ifc$speechrec$DSISpeechRec == null ? (class$org$dsi$ifc$speechrec$DSISpeechRec = AsrDsiAdapter.class$("org.dsi.ifc.speechrec.DSISpeechRec")) : class$org$dsi$ifc$speechrec$DSISpeechRec);
        this.dsiSpeechRecListener = dSIProxyAdapterFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$speechrec$DSISpeechRecListener == null ? (class$org$dsi$ifc$speechrec$DSISpeechRecListener = AsrDsiAdapter.class$("org.dsi.ifc.speechrec.DSISpeechRecListener")) : class$org$dsi$ifc$speechrec$DSISpeechRecListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$speechrec$DSISpeechRecListener == null ? (class$org$dsi$ifc$speechrec$DSISpeechRecListener = AsrDsiAdapter.class$("org.dsi.ifc.speechrec.DSISpeechRecListener")) : class$org$dsi$ifc$speechrec$DSISpeechRecListener, this.dsiSpeechRecListener);
        this.dsiSpeechRec.setNotification(this.getNotificationAttributes(), this.dsiSpeechRecListener);
    }

    @Override
    public void uninitDSIProxy() {
        this.dsiSpeechRec = null;
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        dSIProxy.removeResponseListener(this, class$org$dsi$ifc$speechrec$DSISpeechRecListener == null ? (class$org$dsi$ifc$speechrec$DSISpeechRecListener = AsrDsiAdapter.class$("org.dsi.ifc.speechrec.DSISpeechRecListener")) : class$org$dsi$ifc$speechrec$DSISpeechRecListener, this.dsiSpeechRecListener);
    }

    @Override
    public int getInstanceId() {
        return 0;
    }

    @Override
    public void trackSwapState() {
        this.dsiSpeechRec.setNotification(16, this.dsiSpeechRecListener);
    }

    @Override
    public AdapterHandlerRegistry getAdapterHandlerRegistry() {
        return this.asrAdapterHandlerReg;
    }

    private int[] getNotificationAttributes() {
        int[] nArray = new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 21, 23};
        return nArray;
    }

    public void dsiSpeechRecResponseInit(int n) {
        this.logger.info(512, "[AsrDsiAdapter]: responseInit");
        this.asrAdapterHandlerReg.dsiSpeechRecResponseInit(n);
    }

    public void dsiSpeechRecResponseStartRecognition(int n) {
        this.logger.trace(512, "[AsrDsiAdapter]: responseStartRecognition");
        this.asrAdapterHandlerReg.dsiSpeechRecResponseStartRecognition(n);
    }

    public void dsiSpeechRecResponseWaitForResults(int n, NBestList nBestList) {
        this.logger.trace(512, "[AsrDsiAdapter]: responseWaitForResults");
        this.asrAdapterHandlerReg.dsiSpeechRecResponseWaitForResults(n, nBestList);
    }

    public void dsiSpeechRecUpdateRecognizerState(int n, int n2) {
        if (this.logger.isTraceEnabled(512)) {
            LogMessage logMessage = this.logger.trace(512);
            logMessage.append("[AsrDsiAdapter]: ");
            logMessage.append("updateRecognizerState(");
            logMessage.append(n);
            logMessage.append(" )");
            logMessage.log();
        }
        this.asrAdapterHandlerReg.dsiSpeechRecUpdateRecognizerState(n);
    }

    public void dsiSpeechRecUpdateSDSAvailability(int n, int n2) {
        this.logger.info(512, new StringBuffer().append("[AsrDsiAdapter]: dsiSpeechRecUpdateSDSAvailability(sdsAvailability=").append(n).append(", valid=").append(n2).append(")").toString());
        this.asrAdapterHandlerReg.dsiSpeechRecUpdateSdsAvailability(n);
    }

    public void dsiSpeechRecUpdateGrammarState(GrammarStateInfo grammarStateInfo, int n) {
        if (this.logger.isTraceEnabled(512)) {
            LogMessage logMessage = this.logger.trace(512);
            logMessage.append("[AsrDsiAdapter]: ");
            logMessage.append("updateGrammarState(");
            logMessage.append(grammarStateInfo);
            logMessage.append(" )");
            logMessage.log();
        }
        this.asrAdapterHandlerReg.dsiSpeechUpdateGrammarState(grammarStateInfo);
    }

    public void dsiSpeechRecUpdateFailure(boolean bl, int n) {
        if (bl && 1 == n) {
            LogMessage logMessage = this.logger.error(512);
            logMessage.append("[AsrDsiAdapter]: ");
            logMessage.append("updateFailure( true, valid) ");
            logMessage.log();
            this.asrAdapterHandlerReg.dsiSpeechRecUpdateFailure(bl);
        }
    }

    public void dsiSpeechRecResponseRequestSDSAvailability(int n, int n2) {
        this.logger.info(512, new StringBuffer().append("[AsrDsiAdapter]: dsiSpeechRecResponseRequestSdsAvailability(sdsAvailability=").append(n).append(", replyCode=").append(n2).append(")").toString());
        this.asrAdapterHandlerReg.dsiSpeechRecUpdateSdsAvailability(n);
    }

    public void dsiSpeechRecResponseUnloadGrammar(int n, GrammarInfo[] grammarInfoArray) {
        this.logger.trace(512, "dsiSpeechRecResponseUnloadGrammar");
        this.asrAdapterHandlerReg.dsiSpeechRecResponseUnloadGrammar(n, grammarInfoArray);
    }

    public void dsiSpeechRecResponseLoadGrammar(int n, GrammarInfo[] grammarInfoArray) {
        this.logger.trace(512, "dsiSpeechRecResponseLoadGrammar");
        this.asrAdapterHandlerReg.dsiSpeechRecResponseLoadGrammar(n, grammarInfoArray);
    }

    public void dsiSpeechRecResponseRequestVDECapabilities(int n, VDECapabilities vDECapabilities) {
        this.logger.trace(512, "dsiSpeechRecResponseRequestVDECapabilities");
        this.asrAdapterHandlerReg.dsiSpeechRecResponseRequestVDECapabilities(n, vDECapabilities);
    }

    public void dsiSpeechRecResponseSetLanguage(int n) {
        this.logger.trace(512, "dsiSpeechRecResponseSetLanguage");
        this.asrAdapterHandlerReg.dsiSpeechRecResponseSetLanguage(n);
    }

    public void dsiSpeechRecUpdateAvailableLanguages(String[] stringArray, int n) {
        this.logger.trace(512, "dsiSpeechRecUpdateAvailableLanguages");
        if (n == 1) {
            this.asrAdapterHandlerReg.dsiSpeechRecUpdateAvailableLanguages(stringArray);
        }
    }

    public void dsiSpeechRecAsyncException(int n, String string, int n2) {
        this.asrAdapterHandlerReg.asyncException(n, string, n2);
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

