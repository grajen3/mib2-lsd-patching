/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.asiainput.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.asiainput.DSIAsiaInput;
import de.esolutions.fw.comm.dsi.asiainput.DSIAsiaInputC;
import de.esolutions.fw.comm.dsi.asiainput.DSIAsiaInputReply;
import de.esolutions.fw.comm.dsi.asiainput.impl.DSIAsiaInputProxy$1;
import de.esolutions.fw.comm.dsi.asiainput.impl.DSIAsiaInputProxy$2;
import de.esolutions.fw.comm.dsi.asiainput.impl.DSIAsiaInputReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.asiainput.UserDefinedEntry;
import org.dsi.ifc.asiainput.WordDatabase;

public class DSIAsiaInputProxy
implements DSIAsiaInput,
DSIAsiaInputC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.asiainput.DSIAsiaInput");
    private Proxy proxy;

    public DSIAsiaInputProxy(int n, DSIAsiaInputReply dSIAsiaInputReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("4c5fc7c9-6af7-520c-9b29-57c1f0891366", n, "2207f979-de69-593e-b087-eb41aef88298", "dsi.asiainput.DSIAsiaInput");
        DSIAsiaInputReplyService dSIAsiaInputReplyService = new DSIAsiaInputReplyService(dSIAsiaInputReply);
        this.proxy = new Proxy(serviceInstanceID, dSIAsiaInputReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void initialize(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)27, genericSerializable);
    }

    @Override
    public void addSymbol(char c2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUChar16(c2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)0, genericSerializable);
    }

    @Override
    public void addSymbols(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)1, genericSerializable);
    }

    @Override
    public void removeSymbol() {
        this.proxy.remoteCallMethod((short)30, null);
    }

    @Override
    public void removeAllSymbols() {
        this.proxy.remoteCallMethod((short)29, null);
    }

    @Override
    public void clear() {
        this.proxy.remoteCallMethod((short)6, null);
    }

    @Override
    public void buildCandidates() {
        this.proxy.remoteCallMethod((short)4, null);
    }

    @Override
    public void getSpelling() {
        this.proxy.remoteCallMethod((short)19, null);
    }

    @Override
    public void getCandidates(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    @Override
    public void selectCandidate(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)33, genericSerializable);
    }

    @Override
    public void setBooleanParameter(int n, boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)37, genericSerializable);
    }

    @Override
    public void setIntParameter(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)39, genericSerializable);
    }

    @Override
    public void getBooleanParameter(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    @Override
    public void getIntParameter(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)15, genericSerializable);
    }

    @Override
    public void getVersionInfo() {
        this.proxy.remoteCallMethod((short)23, null);
    }

    @Override
    public void setStringParameter(int n, String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)45, genericSerializable);
    }

    @Override
    public void getStringParameter(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)21, genericSerializable);
    }

    @Override
    public void setPredictionContext(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)44, genericSerializable);
    }

    @Override
    public void clearPredictionContext() {
        this.proxy.remoteCallMethod((short)10, null);
    }

    @Override
    public void addUserDefinedEntry(UserDefinedEntry userDefinedEntry) {
        DSIAsiaInputProxy$1 dSIAsiaInputProxy$1 = new DSIAsiaInputProxy$1(this, userDefinedEntry);
        this.proxy.remoteCallMethod((short)2, dSIAsiaInputProxy$1);
    }

    @Override
    public void setAdditionalWordDatabases(WordDatabase[] wordDatabaseArray) {
        DSIAsiaInputProxy$2 dSIAsiaInputProxy$2 = new DSIAsiaInputProxy$2(this, wordDatabaseArray);
        this.proxy.remoteCallMethod((short)35, dSIAsiaInputProxy$2);
    }

    @Override
    public void setUserDatabaseState(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)47, genericSerializable);
    }

    @Override
    public void resetToFactorySettings() {
        this.proxy.remoteCallMethod((short)31, null);
    }

    @Override
    public void getSegmentation(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }

    @Override
    public void requestSegmentationForTruffles(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)51, genericSerializable);
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
        this.proxy.remoteCallMethod((short)42, genericSerializable);
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
        this.proxy.remoteCallMethod((short)43, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)41, null);
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
        this.proxy.remoteCallMethod((short)8, genericSerializable);
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
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)7, null);
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
        this.proxy.remoteCallMethod((short)50, genericSerializable);
    }
}

