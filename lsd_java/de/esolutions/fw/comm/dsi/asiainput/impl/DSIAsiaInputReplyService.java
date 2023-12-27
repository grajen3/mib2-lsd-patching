/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.asiainput.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.asiainput.DSIAsiaInputReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIAsiaInputReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.asiainput.DSIAsiaInput");
    private static int dynamicHandle = 0;
    private DSIAsiaInputReply p_DSIAsiaInputReply;

    public DSIAsiaInputReplyService(DSIAsiaInputReply dSIAsiaInputReply) {
        super(new ServiceInstanceID("fbfa7ec2-cf7e-5410-bf3b-2435ecaa2283", DSIAsiaInputReplyService.nextDynamicHandle(), "5629fd5e-f29a-577a-b6bd-f10203c96186", "dsi.asiainput.DSIAsiaInput"));
        this.p_DSIAsiaInputReply = dSIAsiaInputReply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 28: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAsiaInputReply.initialized(n);
                    break;
                }
                case 24: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIAsiaInputReply.getVersionInfo(string, string2);
                    break;
                }
                case 5: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAsiaInputReply.builtCandidates(n);
                    break;
                }
                case 20: {
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIAsiaInputReply.getSpelling(string);
                    break;
                }
                case 13: {
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    this.p_DSIAsiaInputReply.getCandidates(stringArray);
                    break;
                }
                case 34: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIAsiaInputReply.selectedCandidate(n, n2);
                    break;
                }
                case 26: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAsiaInputReply.indicateErrorStatus(n);
                    break;
                }
                case 25: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAsiaInputReply.indicateDataInvalidated(n);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIAsiaInputReply.getIntParameter(n, n3);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSIAsiaInputReply.getBooleanParameter(n, bl);
                    break;
                }
                case 40: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIAsiaInputReply.setIntParameterResult(n, n4, n5);
                    break;
                }
                case 38: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIAsiaInputReply.setBooleanParameterResult(n, bl, n6);
                    break;
                }
                case 46: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIAsiaInputReply.setStringParameterResult(n, string, n7);
                    break;
                }
                case 22: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIAsiaInputReply.getStringParameter(n, string);
                    break;
                }
                case 36: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAsiaInputReply.setAdditionalWordDatabasesResult(n);
                    break;
                }
                case 48: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIAsiaInputReply.setUserDatabaseStateResult(n, n8, n9);
                    break;
                }
                case 32: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAsiaInputReply.resetToFactorySettingsResult(n);
                    break;
                }
                case 17: {
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIAsiaInputReply.getSegmentation(string);
                    break;
                }
                case 52: {
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIAsiaInputReply.responseSegmentationForTruffles(string);
                    break;
                }
                case 3: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIAsiaInputReply.asyncException(n, string, n10);
                    break;
                }
                case 49: {
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    this.p_DSIAsiaInputReply.yyIndication(string, string3);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}

