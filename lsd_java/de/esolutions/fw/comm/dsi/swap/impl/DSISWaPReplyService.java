/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swap.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.swap.DSISWaPReply;
import de.esolutions.fw.comm.dsi.swap.impl.ConfigInfoSerializer;
import de.esolutions.fw.comm.dsi.swap.impl.SFscDetailsSerializer;
import de.esolutions.fw.comm.dsi.swap.impl.SFscHistorySerializer;
import de.esolutions.fw.comm.dsi.swap.impl.SFscImportStatusSerializer;
import de.esolutions.fw.comm.dsi.swap.impl.SFscStatusSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.swap.ConfigInfo;
import org.dsi.ifc.swap.SFscDetails;
import org.dsi.ifc.swap.SFscHistory;
import org.dsi.ifc.swap.SFscImportStatus;
import org.dsi.ifc.swap.SFscStatus;

public class DSISWaPReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.swap.DSISWaP");
    private static int dynamicHandle = 0;
    private DSISWaPReply p_DSISWaPReply;

    public DSISWaPReplyService(DSISWaPReply dSISWaPReply) {
        super(new ServiceInstanceID("5d89d8f3-07c4-5d00-9db7-32c55c981f43", DSISWaPReplyService.nextDynamicHandle(), "cbe65faa-96b7-5ffd-b8c1-9f9ade45b142", "dsi.swap.DSISWaP"));
        this.p_DSISWaPReply = dSISWaPReply;
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
                case 35: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSISWaPReply.updateSoftwareEnabling(nArray, n);
                    break;
                }
                case 33: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSISWaPReply.updateIllegalFSCs(nArray, n);
                    break;
                }
                case 28: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSISWaPReply.updateAreFSCsSigned(bl, n);
                    break;
                }
                case 34: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSISWaPReply.updateLimitedLifetime(bl, n);
                    break;
                }
                case 29: {
                    ConfigInfo configInfo = ConfigInfoSerializer.getOptionalConfigInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSISWaPReply.updateConfigCheck(configInfo, n);
                    break;
                }
                case 31: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSISWaPReply.updateConfigPrepare(string, n);
                    break;
                }
                case 30: {
                    ConfigInfo configInfo = ConfigInfoSerializer.getOptionalConfigInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSISWaPReply.updateConfigFinalize(configInfo, n);
                    break;
                }
                case 40: {
                    SFscStatus[] sFscStatusArray = SFscStatusSerializer.getOptionalSFscStatusVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSISWaPReply.updateFscList(sFscStatusArray, n);
                    break;
                }
                case 10: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSISWaPReply.encryptFile(string, n);
                    break;
                }
                case 1: {
                    boolean bl = iDeserializer.getBool();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSISWaPReply.checkSignature(bl, string);
                    break;
                }
                case 20: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSISWaPReply.getPublicKey(sArray, bl);
                    break;
                }
                case 4: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSISWaPReply.checkSingleFsc(n, n2);
                    break;
                }
                case 8: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSISWaPReply.decryptFile(string, n);
                    break;
                }
                case 43: {
                    SFscDetails sFscDetails = SFscDetailsSerializer.getOptionalSFscDetails(iDeserializer);
                    this.p_DSISWaPReply.getFscDetail(sFscDetails);
                    break;
                }
                case 41: {
                    int n = iDeserializer.getInt32();
                    SFscImportStatus sFscImportStatus = SFscImportStatusSerializer.getOptionalSFscImportStatus(iDeserializer);
                    this.p_DSISWaPReply.importFSCs(n, sFscImportStatus);
                    break;
                }
                case 42: {
                    int n = iDeserializer.getInt32();
                    SFscImportStatus[] sFscImportStatusArray = SFscImportStatusSerializer.getOptionalSFscImportStatusVarArray(iDeserializer);
                    this.p_DSISWaPReply.importFSCsList(n, sFscImportStatusArray);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISWaPReply.exportCCD(n);
                    break;
                }
                case 17: {
                    SFscHistory sFscHistory = SFscHistorySerializer.getOptionalSFscHistory(iDeserializer);
                    this.p_DSISWaPReply.getHistory(sFscHistory);
                    break;
                }
                case 18: {
                    SFscHistory[] sFscHistoryArray = SFscHistorySerializer.getOptionalSFscHistoryVarArray(iDeserializer);
                    this.p_DSISWaPReply.getHistoryList(sFscHistoryArray);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSISWaPReply.asyncException(n, string, n3);
                    break;
                }
                case 36: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSISWaPReply.yyIndication(string, string2);
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

