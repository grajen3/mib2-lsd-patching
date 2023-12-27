/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.speechrec;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.speechrec.DSISpeechRecReply;
import de.esolutions.fw.comm.dsi.speechrec.impl.DSISpeechRecProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.speechrec.DSISpeechRec;
import org.dsi.ifc.speechrec.DictionaryEntry;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;
import org.osgi.framework.BundleContext;

public class DSISpeechRecProvider
extends AbstractProvider
implements DSISpeechRec {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18, 19, 20, 21, 22, 23, 24, 25, 26};
    private DSISpeechRecProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$speechrec$DSISpeechRec;

    public DSISpeechRecProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$speechrec$DSISpeechRec == null ? (class$org$dsi$ifc$speechrec$DSISpeechRec = DSISpeechRecProvider.class$("org.dsi.ifc.speechrec.DSISpeechRec")) : class$org$dsi$ifc$speechrec$DSISpeechRec).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSISpeechRecProxy(this.instance, (DSISpeechRecReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void abort() {
        try {
            this.proxy.abort();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteProfile(int n) {
        try {
            this.proxy.deleteProfile(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteVoiceTag(int n) {
        try {
            this.proxy.deleteVoiceTag(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void enableContinuousUpdate(boolean bl) {
        try {
            this.proxy.enableContinuousUpdate(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getVersion() {
        try {
            this.proxy.getVersion();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void init() {
        try {
            this.proxy.init();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void initVoiceTag(int n) {
        try {
            this.proxy.initVoiceTag(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void loadGrammar(Grammar[] grammarArray) {
        try {
            this.proxy.loadGrammar(grammarArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void loadProfile(int n) {
        try {
            this.proxy.loadProfile(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void preloadGrammar(Grammar[] grammarArray) {
        try {
            this.proxy.preloadGrammar(grammarArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void recordVoiceTag() {
        try {
            this.proxy.recordVoiceTag();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setLanguage(String string, int n) {
        try {
            this.proxy.setLanguage(string, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void shutdown() {
        try {
            this.proxy.shutdown();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void startRecognition(int n, int n2, int n3) {
        try {
            this.proxy.startRecognition(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void unloadGrammar(GrammarInfo[] grammarInfoArray) {
        try {
            this.proxy.unloadGrammar(grammarInfoArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void unloadProfile(int n) {
        try {
            this.proxy.unloadProfile(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void unpreloadGrammar(GrammarInfo[] grammarInfoArray) {
        try {
            this.proxy.unpreloadGrammar(grammarInfoArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void waitForResults() {
        try {
            this.proxy.waitForResults();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMaxCommandNBestListSize(int n) {
        try {
            this.proxy.setMaxCommandNBestListSize(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMaxSlotNBestListSize(int n) {
        try {
            this.proxy.setMaxSlotNBestListSize(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRecognitionTimeout(int n) {
        try {
            this.proxy.setRecognitionTimeout(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setUnambiguousResultThreshold(int n) {
        try {
            this.proxy.setUnambiguousResultThreshold(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setUnambiguousResultRange(int n) {
        try {
            this.proxy.setUnambiguousResultRange(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setFirstLevelSize(int n) {
        try {
            this.proxy.setFirstLevelSize(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void startPostTraining(int n) {
        try {
            this.proxy.startPostTraining(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void stopPostTraining() {
        try {
            this.proxy.stopPostTraining();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSDSAvailability() {
        try {
            this.proxy.requestSDSAvailability();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSpellingMode(int n) {
        try {
            this.proxy.setSpellingMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteLastSpellingBlock() {
        try {
            this.proxy.deleteLastSpellingBlock();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void startDialogue() {
        try {
            this.proxy.startDialogue();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void stopDialogue() {
        try {
            this.proxy.stopDialogue();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestCheckDbPartition() {
        try {
            this.proxy.requestCheckDbPartition();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestGraphemicGroupAsNBestList(int n) {
        try {
            this.proxy.requestGraphemicGroupAsNBestList(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestVDECapabilities(String string) {
        try {
            this.proxy.requestVDECapabilities(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestRestoreFactorySettings() {
        try {
            this.proxy.requestRestoreFactorySettings();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDictionary(int n, String string, String string2, DictionaryEntry[] dictionaryEntryArray) {
        try {
            this.proxy.setDictionary(n, string, string2, dictionaryEntryArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setASRParameterConfiguration(int[] nArray, int[] nArray2, int[] nArray3) {
        try {
            this.proxy.setASRParameterConfiguration(nArray, nArray2, nArray3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteLastFlexVDEPart() {
        try {
            this.proxy.deleteLastFlexVDEPart();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearFlexVDEHistory() {
        try {
            this.proxy.clearFlexVDEHistory();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int[] nArray) {
        try {
            this.proxy.setNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int n) {
        try {
            this.proxy.setNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification() {
        try {
            this.proxy.setNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int[] nArray) {
        try {
            this.proxy.clearNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int n) {
        try {
            this.proxy.clearNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification() {
        try {
            this.proxy.clearNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void yySet(String string, String string2) {
        try {
            this.proxy.yySet(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
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

