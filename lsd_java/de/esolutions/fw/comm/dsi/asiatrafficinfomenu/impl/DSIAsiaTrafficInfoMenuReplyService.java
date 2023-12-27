/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.asiatrafficinfomenu.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuReply;
import de.esolutions.fw.comm.dsi.asiatrafficinfomenu.impl.InterruptSerializer;
import de.esolutions.fw.comm.dsi.asiatrafficinfomenu.impl.ResourceInformationSerializer;
import de.esolutions.fw.comm.dsi.asiatrafficinfomenu.impl.TrafficInformationDetailsSerializer;
import de.esolutions.fw.comm.dsi.asiatrafficinfomenu.impl.TrafficInformationSerializer;
import de.esolutions.fw.comm.dsi.asiatrafficinfomenu.impl.TunerDataSerializer;
import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.asiatrafficinfomenu.Interrupt;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformationDetails;
import org.dsi.ifc.asiatrafficinfomenu.TunerData;
import org.dsi.ifc.global.DateTime;

public class DSIAsiaTrafficInfoMenuReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu");
    private static int dynamicHandle = 0;
    private DSIAsiaTrafficInfoMenuReply p_DSIAsiaTrafficInfoMenuReply;

    public DSIAsiaTrafficInfoMenuReplyService(DSIAsiaTrafficInfoMenuReply dSIAsiaTrafficInfoMenuReply) {
        super(new ServiceInstanceID("2866c45a-497d-5824-a58a-0208be5c1860", DSIAsiaTrafficInfoMenuReplyService.nextDynamicHandle(), "a672f7a9-52b8-5ec5-bf7e-506497f89558", "dsi.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu"));
        this.p_DSIAsiaTrafficInfoMenuReply = dSIAsiaTrafficInfoMenuReply;
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
                    Interrupt[] interruptArray = InterruptSerializer.getOptionalInterruptVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAsiaTrafficInfoMenuReply.updateActiveInterrupts(interruptArray, n);
                    break;
                }
                case 22: {
                    TrafficInformation[] trafficInformationArray = TrafficInformationSerializer.getOptionalTrafficInformationVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAsiaTrafficInfoMenuReply.updateTrafficType(trafficInformationArray, n);
                    break;
                }
                case 17: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAsiaTrafficInfoMenuReply.updatePrefecture(string, n);
                    break;
                }
                case 18: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAsiaTrafficInfoMenuReply.updateProbeDataSetting(bl, n);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIAsiaTrafficInfoMenuReply.updateFrequency(n, n2);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIAsiaTrafficInfoMenuReply.updateReceptionStatus(n, n3);
                    break;
                }
                case 20: {
                    DateTime dateTime = DateTimeSerializer.getOptionalDateTime(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAsiaTrafficInfoMenuReply.updateReceptionDate(dateTime, n);
                    break;
                }
                case 5: {
                    int n = iDeserializer.getInt32();
                    ResourceInformation resourceInformation = ResourceInformationSerializer.getOptionalResourceInformation(iDeserializer);
                    this.p_DSIAsiaTrafficInfoMenuReply.requestResourceInformationResponse(n, resourceInformation);
                    break;
                }
                case 7: {
                    int n = iDeserializer.getInt32();
                    TrafficInformationDetails[] trafficInformationDetailsArray = TrafficInformationDetailsSerializer.getOptionalTrafficInformationDetailsVarArray(iDeserializer);
                    this.p_DSIAsiaTrafficInfoMenuReply.requestTrafficInformationDetailsResponse(n, trafficInformationDetailsArray);
                    break;
                }
                case 19: {
                    TunerData[] tunerDataArray = TunerDataSerializer.getOptionalTunerDataVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAsiaTrafficInfoMenuReply.updateReceivableStations(tunerDataArray, n);
                    break;
                }
                case 9: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSIAsiaTrafficInfoMenuReply.setLanguageResponse(bl);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIAsiaTrafficInfoMenuReply.asyncException(n, string, n4);
                    break;
                }
                case 23: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIAsiaTrafficInfoMenuReply.yyIndication(string, string2);
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

