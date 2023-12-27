/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.connectedradio.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.connectedradio.DSIHybridRadioReply;
import de.esolutions.fw.comm.dsi.connectedradio.impl.RadioStationSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.connectedradio.RadioStation;

public class DSIHybridRadioReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.connectedradio.DSIHybridRadio");
    private static int dynamicHandle = 0;
    private DSIHybridRadioReply p_DSIHybridRadioReply;

    public DSIHybridRadioReplyService(DSIHybridRadioReply dSIHybridRadioReply) {
        super(new ServiceInstanceID("32a0f709-ed6a-52b0-b853-40bb0b5c16b4", DSIHybridRadioReplyService.nextDynamicHandle(), "07a916a0-d145-57ef-879b-c9c74eefd6f2", "dsi.connectedradio.DSIHybridRadio"));
        this.p_DSIHybridRadioReply = dSIHybridRadioReply;
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
                case 7: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    RadioStation[] radioStationArray = RadioStationSerializer.getOptionalRadioStationVarArray(iDeserializer);
                    this.p_DSIHybridRadioReply.getOnlineRadioAvailabilityResult(n, n2, radioStationArray);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    RadioStation[] radioStationArray = RadioStationSerializer.getOptionalRadioStationVarArray(iDeserializer);
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIHybridRadioReply.getRadioStationLogoResult(n, n3, radioStationArray, n4);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    RadioStation[] radioStationArray = RadioStationSerializer.getOptionalRadioStationVarArray(iDeserializer);
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIHybridRadioReply.indicateRadioStationLogoResult(n, n5, radioStationArray, n6);
                    break;
                }
                case 11: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    RadioStation radioStation = RadioStationSerializer.getOptionalRadioStation(iDeserializer);
                    this.p_DSIHybridRadioReply.getStreamResult(n, n7, radioStation);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    RadioStation radioStation = RadioStationSerializer.getOptionalRadioStation(iDeserializer);
                    this.p_DSIHybridRadioReply.startSlideshowResult(n, n8, radioStation);
                    break;
                }
                case 19: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    RadioStation radioStation = RadioStationSerializer.getOptionalRadioStation(iDeserializer);
                    this.p_DSIHybridRadioReply.stopSlideshowResult(n, n9, radioStation);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    RadioStation radioStation = RadioStationSerializer.getOptionalRadioStation(iDeserializer);
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIHybridRadioReply.updateSlideshow(n, radioStation, n10);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getInt32();
                    RadioStation radioStation = RadioStationSerializer.getOptionalRadioStation(iDeserializer);
                    int n11 = iDeserializer.getInt32();
                    this.p_DSIHybridRadioReply.updateRadioText(n, radioStation, n11);
                    break;
                }
                case 2: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSIHybridRadioReply.cancelGetRadioStationLogoResult(n, n12);
                    break;
                }
                case 32: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSIHybridRadioReply.updateProfileState(n, n13, n14);
                    break;
                }
                case 25: {
                    int n = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSIHybridRadioReply.profileChanged(n, n15);
                    break;
                }
                case 26: {
                    int n = iDeserializer.getInt32();
                    int n16 = iDeserializer.getInt32();
                    int n17 = iDeserializer.getInt32();
                    this.p_DSIHybridRadioReply.profileCopied(n, n16, n17);
                    break;
                }
                case 29: {
                    int n = iDeserializer.getInt32();
                    int n18 = iDeserializer.getInt32();
                    this.p_DSIHybridRadioReply.profileReset(n, n18);
                    break;
                }
                case 31: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIHybridRadioReply.profileResetAll(n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n19 = iDeserializer.getInt32();
                    this.p_DSIHybridRadioReply.asyncException(n, string, n19);
                    break;
                }
                case 22: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIHybridRadioReply.yyIndication(string, string2);
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

