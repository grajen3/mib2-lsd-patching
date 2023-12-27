/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.smartphoneintegration.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.smartphoneintegration.DSISmartphoneIntegrationReply;
import de.esolutions.fw.comm.dsi.smartphoneintegration.impl.DeviceSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.smartphoneintegration.Device;

public class DSISmartphoneIntegrationReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.smartphoneintegration.DSISmartphoneIntegration");
    private static int dynamicHandle = 0;
    private DSISmartphoneIntegrationReply p_DSISmartphoneIntegrationReply;

    public DSISmartphoneIntegrationReplyService(DSISmartphoneIntegrationReply dSISmartphoneIntegrationReply) {
        super(new ServiceInstanceID("b66bed86-0446-5574-bf7c-0a212b4857f5", DSISmartphoneIntegrationReplyService.nextDynamicHandle(), "c151f367-7bcf-50b9-9845-867e437d0e4f", "dsi.smartphoneintegration.DSISmartphoneIntegration"));
        this.p_DSISmartphoneIntegrationReply = dSISmartphoneIntegrationReply;
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
                case 10: {
                    Device[] deviceArray = DeviceSerializer.getOptionalDeviceVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSISmartphoneIntegrationReply.updateDiscoveredDevices(deviceArray, n);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSISmartphoneIntegrationReply.updateDeviceConnectionState(n, n2, n3, n4);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSISmartphoneIntegrationReply.responseFactorySettings(n, bl);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSISmartphoneIntegrationReply.updateSWaPStatus(n, n5);
                    break;
                }
                case 18: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSISmartphoneIntegrationReply.updateUSBResetActive(bl, n);
                    break;
                }
                case 20: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSISmartphoneIntegrationReply.updateAppConnectContextRequested(bl, n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSISmartphoneIntegrationReply.asyncException(n, string, n6);
                    break;
                }
                case 11: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSISmartphoneIntegrationReply.yyIndication(string, string2);
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

