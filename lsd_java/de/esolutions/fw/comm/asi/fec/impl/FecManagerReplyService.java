/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.FecManagerReply;
import de.esolutions.fw.comm.asi.fec.SFecDetails;
import de.esolutions.fw.comm.asi.fec.SFecHistory;
import de.esolutions.fw.comm.asi.fec.SFecImportStatus;
import de.esolutions.fw.comm.asi.fec.impl.SFecDetailsSerializer;
import de.esolutions.fw.comm.asi.fec.impl.SFecHistorySerializer;
import de.esolutions.fw.comm.asi.fec.impl.SFecImportStatusSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class FecManagerReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.fec.FecManager");
    private static int dynamicHandle = 0;
    private FecManagerReply p_FecManagerReply;

    public FecManagerReplyService(FecManagerReply fecManagerReply) {
        super(new ServiceInstanceID("7b2f491d-eea1-4197-9124-469efe2453d2", FecManagerReplyService.nextDynamicHandle(), "8db34658-32cf-5a16-a3fd-9571af38a1d3", "asi.fec.FecManager"));
        this.p_FecManagerReply = fecManagerReply;
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
                case 1: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_FecManagerReply.checkDataSignature(string, bl);
                    break;
                }
                case 15: {
                    SFecDetails sFecDetails = SFecDetailsSerializer.getOptionalSFecDetails(iDeserializer);
                    this.p_FecManagerReply.fecDetails(sFecDetails);
                    break;
                }
                case 13: {
                    int n = iDeserializer.getInt32();
                    SFecImportStatus[] sFecImportStatusArray = SFecImportStatusSerializer.getOptionalSFecImportStatusVarArray(iDeserializer);
                    this.p_FecManagerReply.importFecs(n, sFecImportStatusArray);
                    break;
                }
                case 6: {
                    int n = iDeserializer.getInt32();
                    this.p_FecManagerReply.exportCCD(n);
                    break;
                }
                case 11: {
                    SFecHistory[] sFecHistoryArray = SFecHistorySerializer.getOptionalSFecHistoryVarArray(iDeserializer);
                    this.p_FecManagerReply.getHistory(sFecHistoryArray);
                    break;
                }
                case 4: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_FecManagerReply.encryptFile(string, n);
                    break;
                }
                case 2: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_FecManagerReply.decryptFile(string, n);
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

