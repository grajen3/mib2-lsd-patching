/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tollcollect.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.NavPriceInfoSerializer;
import de.esolutions.fw.comm.dsi.tollcollect.DSITollCollectReply;
import de.esolutions.fw.comm.dsi.tollcollect.impl.TCCardDateInformationSerializer;
import de.esolutions.fw.comm.dsi.tollcollect.impl.TCCardErrorSerializer;
import de.esolutions.fw.comm.dsi.tollcollect.impl.TCHardwareInformationSerializer;
import de.esolutions.fw.comm.dsi.tollcollect.impl.TCPaymentInfoDetailsSerializer;
import de.esolutions.fw.comm.dsi.tollcollect.impl.TCPaymentInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.NavPriceInfo;
import org.dsi.ifc.tollcollect.TCCardDateInformation;
import org.dsi.ifc.tollcollect.TCCardError;
import org.dsi.ifc.tollcollect.TCHardwareInformation;
import org.dsi.ifc.tollcollect.TCPaymentInfo;
import org.dsi.ifc.tollcollect.TCPaymentInfoDetails;

public class DSITollCollectReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.tollcollect.DSITollCollect");
    private static int dynamicHandle = 0;
    private DSITollCollectReply p_DSITollCollectReply;

    public DSITollCollectReplyService(DSITollCollectReply dSITollCollectReply) {
        super(new ServiceInstanceID("0eacb804-7004-5d94-8156-35b75f566f12", DSITollCollectReplyService.nextDynamicHandle(), "feda581a-b809-50c5-a988-b0dcfaa40fb5", "dsi.tollcollect.DSITollCollect"));
        this.p_DSITollCollectReply = dSITollCollectReply;
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
                case 15: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSITollCollectReply.updateCardState(n, n2);
                    break;
                }
                case 14: {
                    TCCardError tCCardError = TCCardErrorSerializer.getOptionalTCCardError(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITollCollectReply.updateCardError(tCCardError, n);
                    break;
                }
                case 13: {
                    TCCardDateInformation tCCardDateInformation = TCCardDateInformationSerializer.getOptionalTCCardDateInformation(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITollCollectReply.updateCardDateInformation(tCCardDateInformation, n);
                    break;
                }
                case 17: {
                    TCHardwareInformation[] tCHardwareInformationArray = TCHardwareInformationSerializer.getOptionalTCHardwareInformationVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITollCollectReply.updateHardwareInformation(tCHardwareInformationArray, n);
                    break;
                }
                case 16: {
                    NavPriceInfo navPriceInfo = NavPriceInfoSerializer.getOptionalNavPriceInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITollCollectReply.updateCurrentTollPayment(navPriceInfo, n);
                    break;
                }
                case 7: {
                    TCPaymentInfo[] tCPaymentInfoArray = TCPaymentInfoSerializer.getOptionalTCPaymentInfoVarArray(iDeserializer);
                    this.p_DSITollCollectReply.requestPaymentHistoryListResult(tCPaymentInfoArray);
                    break;
                }
                case 5: {
                    int n = iDeserializer.getInt32();
                    TCPaymentInfoDetails tCPaymentInfoDetails = TCPaymentInfoDetailsSerializer.getOptionalTCPaymentInfoDetails(iDeserializer);
                    this.p_DSITollCollectReply.requestPaymentHistoryDetailsResult(n, tCPaymentInfoDetails);
                    break;
                }
                case 9: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSITollCollectReply.setLanguageResponse(bl);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSITollCollectReply.asyncException(n, string, n3);
                    break;
                }
                case 18: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSITollCollectReply.yyIndication(string, string2);
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

