/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swdlprogress.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.swdlprogress.DSISwdlProgressReply;
import de.esolutions.fw.comm.dsi.swdlprogress.impl.DeviceOverviewProgressSerializer;
import de.esolutions.fw.comm.dsi.swdlprogress.impl.GeneralProgressSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.swdlprogress.DeviceOverviewProgress;
import org.dsi.ifc.swdlprogress.GeneralProgress;

public class DSISwdlProgressReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.swdlprogress.DSISwdlProgress");
    private static int dynamicHandle = 0;
    private DSISwdlProgressReply p_DSISwdlProgressReply;

    public DSISwdlProgressReplyService(DSISwdlProgressReply dSISwdlProgressReply) {
        super(new ServiceInstanceID("3503d547-697f-53c6-9dc6-9aa9d8c5e20a", DSISwdlProgressReplyService.nextDynamicHandle(), "672abe51-3beb-5644-9610-3ea590ee4d91", "dsi.swdlprogress.DSISwdlProgress"));
        this.p_DSISwdlProgressReply = dSISwdlProgressReply;
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
                case 16: {
                    GeneralProgress generalProgress = GeneralProgressSerializer.getOptionalGeneralProgress(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSISwdlProgressReply.updateGeneralProgress(generalProgress, n);
                    break;
                }
                case 15: {
                    DeviceOverviewProgress[] deviceOverviewProgressArray = DeviceOverviewProgressSerializer.getOptionalDeviceOverviewProgressVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSISwdlProgressReply.updateDevicesOverviewProgress(deviceOverviewProgressArray, n);
                    break;
                }
                case 19: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSISwdlProgressReply.updateTriggerPanel(n, n2);
                    break;
                }
                case 17: {
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSISwdlProgressReply.updateLostDevices(stringArray, n);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSISwdlProgressReply.updateOverviewStatus(n, n3);
                    break;
                }
                case 14: {
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSISwdlProgressReply.updateActiveDevices(stringArray, n);
                    break;
                }
                case 6: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    short s2 = iDeserializer.getInt16();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSISwdlProgressReply.getStaticProgressDetails(n, n4, s2, string);
                    break;
                }
                case 4: {
                    int n = iDeserializer.getInt32();
                    byte by = iDeserializer.getInt8();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSISwdlProgressReply.getDynamicProgressDetails(n, by, string);
                    break;
                }
                case 10: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    byte by = iDeserializer.getInt8();
                    int n5 = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSISwdlProgressReply.indicatePopUp(n, string, by, n5, n6, string2);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSISwdlProgressReply.indicateDismissPopUp(n, string);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSISwdlProgressReply.asyncException(n, string, n7);
                    break;
                }
                case 20: {
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    this.p_DSISwdlProgressReply.yyIndication(string, string3);
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

