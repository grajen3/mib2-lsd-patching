/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbDataResolutionReply;
import de.esolutions.fw.comm.dsi.organizer.impl.DataSetSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.organizer.DataSet;

public class DSIAdbDataResolutionReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.organizer.DSIAdbDataResolution");
    private static int dynamicHandle = 0;
    private DSIAdbDataResolutionReply p_DSIAdbDataResolutionReply;

    public DSIAdbDataResolutionReplyService(DSIAdbDataResolutionReply dSIAdbDataResolutionReply) {
        super(new ServiceInstanceID("c2865fe6-a451-5a7e-96a2-16632788603a", DSIAdbDataResolutionReplyService.nextDynamicHandle(), "bf9f1f0f-c111-50ca-b2dd-023f9c450993", "dsi.organizer.DSIAdbDataResolution"));
        this.p_DSIAdbDataResolutionReply = dSIAdbDataResolutionReply;
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
                case 13: {
                    int n = iDeserializer.getInt32();
                    DataSet[] dataSetArray = DataSetSerializer.getOptionalDataSetVarArray(iDeserializer);
                    this.p_DSIAdbDataResolutionReply.resolveMailAddressResult(n, dataSetArray);
                    break;
                }
                case 14: {
                    int n = iDeserializer.getInt32();
                    DataSet[] dataSetArray = DataSetSerializer.getOptionalDataSetVarArray(iDeserializer);
                    this.p_DSIAdbDataResolutionReply.resolvePhoneNumbersResult(n, dataSetArray);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIAdbDataResolutionReply.asyncException(n, string, n2);
                    break;
                }
                case 12: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIAdbDataResolutionReply.yyIndication(string, string2);
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

