/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.speechrec.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.speechrec.DSISpeechRec;
import de.esolutions.fw.comm.dsi.speechrec.DSISpeechRecC;
import de.esolutions.fw.comm.dsi.speechrec.DSISpeechRecReply;
import de.esolutions.fw.comm.dsi.speechrec.impl.DSISpeechRecProxy$1;
import de.esolutions.fw.comm.dsi.speechrec.impl.DSISpeechRecProxy$2;
import de.esolutions.fw.comm.dsi.speechrec.impl.DSISpeechRecProxy$3;
import de.esolutions.fw.comm.dsi.speechrec.impl.DSISpeechRecProxy$4;
import de.esolutions.fw.comm.dsi.speechrec.impl.DSISpeechRecProxy$5;
import de.esolutions.fw.comm.dsi.speechrec.impl.DSISpeechRecReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.speechrec.DictionaryEntry;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;

public class DSISpeechRecProxy
implements DSISpeechRec,
DSISpeechRecC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.speechrec.DSISpeechRec");
    private Proxy proxy;

    public DSISpeechRecProxy(int n, DSISpeechRecReply dSISpeechRecReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("6a6c7d2a-c4ae-54a3-9625-90dc2f44b96b", n, "86dafd61-127e-567e-a219-d4679b2a8ee6", "dsi.speechrec.DSISpeechRec");
        DSISpeechRecReplyService dSISpeechRecReplyService = new DSISpeechRecReplyService(dSISpeechRecReply);
        this.proxy = new Proxy(serviceInstanceID, dSISpeechRecReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void abort() {
        this.proxy.remoteCallMethod((short)0, null);
    }

    @Override
    public void deleteProfile(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)38, genericSerializable);
    }

    @Override
    public void deleteVoiceTag(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void enableContinuousUpdate(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)103, genericSerializable);
    }

    @Override
    public void getVersion() {
        this.proxy.remoteCallMethod((short)6, null);
    }

    @Override
    public void init() {
        this.proxy.remoteCallMethod((short)7, null);
    }

    @Override
    public void initVoiceTag(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    @Override
    public void loadGrammar(Grammar[] grammarArray) {
        DSISpeechRecProxy$1 dSISpeechRecProxy$1 = new DSISpeechRecProxy$1(this, grammarArray);
        this.proxy.remoteCallMethod((short)39, dSISpeechRecProxy$1);
    }

    @Override
    public void loadProfile(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)40, genericSerializable);
    }

    @Override
    public void preloadGrammar(Grammar[] grammarArray) {
        DSISpeechRecProxy$2 dSISpeechRecProxy$2 = new DSISpeechRecProxy$2(this, grammarArray);
        this.proxy.remoteCallMethod((short)41, dSISpeechRecProxy$2);
    }

    @Override
    public void recordVoiceTag() {
        this.proxy.remoteCallMethod((short)11, null);
    }

    @Override
    public void setLanguage(String string, int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }

    @Override
    public void shutdown() {
        this.proxy.remoteCallMethod((short)28, null);
    }

    @Override
    public void startRecognition(int n, int n2, int n3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)120, genericSerializable);
    }

    @Override
    public void unloadGrammar(GrammarInfo[] grammarInfoArray) {
        DSISpeechRecProxy$3 dSISpeechRecProxy$3 = new DSISpeechRecProxy$3(this, grammarInfoArray);
        this.proxy.remoteCallMethod((short)34, dSISpeechRecProxy$3);
    }

    @Override
    public void unloadProfile(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)42, genericSerializable);
    }

    @Override
    public void unpreloadGrammar(GrammarInfo[] grammarInfoArray) {
        DSISpeechRecProxy$4 dSISpeechRecProxy$4 = new DSISpeechRecProxy$4(this, grammarInfoArray);
        this.proxy.remoteCallMethod((short)35, dSISpeechRecProxy$4);
    }

    @Override
    public void waitForResults() {
        this.proxy.remoteCallMethod((short)36, null);
    }

    @Override
    public void setMaxCommandNBestListSize(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    @Override
    public void setMaxSlotNBestListSize(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    @Override
    public void setRecognitionTimeout(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)23, genericSerializable);
    }

    @Override
    public void setUnambiguousResultThreshold(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)26, genericSerializable);
    }

    @Override
    public void setUnambiguousResultRange(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)25, genericSerializable);
    }

    @Override
    public void setFirstLevelSize(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    @Override
    public void startPostTraining(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)30, genericSerializable);
    }

    @Override
    public void stopPostTraining() {
        this.proxy.remoteCallMethod((short)33, null);
    }

    @Override
    public void requestSDSAvailability() {
        this.proxy.remoteCallMethod((short)13, null);
    }

    @Override
    public void setSpellingMode(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)24, genericSerializable);
    }

    @Override
    public void deleteLastSpellingBlock() {
        this.proxy.remoteCallMethod((short)4, null);
    }

    @Override
    public void startDialogue() {
        this.proxy.remoteCallMethod((short)29, null);
    }

    @Override
    public void stopDialogue() {
        this.proxy.remoteCallMethod((short)32, null);
    }

    @Override
    public void requestCheckDbPartition() {
        this.proxy.remoteCallMethod((short)104, null);
    }

    @Override
    public void requestGraphemicGroupAsNBestList(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)12, genericSerializable);
    }

    @Override
    public void requestVDECapabilities(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    @Override
    public void requestRestoreFactorySettings() {
        this.proxy.remoteCallMethod((short)43, null);
    }

    @Override
    public void setDictionary(int n, String string, String string2, DictionaryEntry[] dictionaryEntryArray) {
        DSISpeechRecProxy$5 dSISpeechRecProxy$5 = new DSISpeechRecProxy$5(this, n, string, string2, dictionaryEntryArray);
        this.proxy.remoteCallMethod((short)102, dSISpeechRecProxy$5);
    }

    @Override
    public void setASRParameterConfiguration(int[] nArray, int[] nArray2, int[] nArray3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
            genericSerializable.putOptionalInt32VarArray(nArray2);
            genericSerializable.putOptionalInt32VarArray(nArray3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)110, genericSerializable);
    }

    @Override
    public void deleteLastFlexVDEPart() {
        this.proxy.remoteCallMethod((short)114, null);
    }

    @Override
    public void clearFlexVDEHistory() {
        this.proxy.remoteCallMethod((short)113, null);
    }

    @Override
    public void setNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)21, genericSerializable);
    }

    @Override
    public void setNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)22, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)20, null);
    }

    @Override
    public void clearNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)2, genericSerializable);
    }

    @Override
    public void clearNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)1, null);
    }

    @Override
    public void yySet(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)37, genericSerializable);
    }
}

