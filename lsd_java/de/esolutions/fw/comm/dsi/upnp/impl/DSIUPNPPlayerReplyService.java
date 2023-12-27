/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.upnp.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.upnp.DSIUPNPPlayerReply;
import de.esolutions.fw.comm.dsi.upnp.impl.DeviceInfoSerializer;
import de.esolutions.fw.comm.dsi.upnp.impl.EntryInfoSerializer;
import de.esolutions.fw.comm.dsi.upnp.impl.PlaybackModeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.upnp.DeviceInfo;
import org.dsi.ifc.upnp.EntryInfo;
import org.dsi.ifc.upnp.PlaybackMode;

public class DSIUPNPPlayerReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.upnp.DSIUPNPPlayer");
    private static int dynamicHandle = 0;
    private DSIUPNPPlayerReply p_DSIUPNPPlayerReply;

    public DSIUPNPPlayerReplyService(DSIUPNPPlayerReply dSIUPNPPlayerReply) {
        super(new ServiceInstanceID("b2460ea2-323f-538a-8290-4872acffc102", DSIUPNPPlayerReplyService.nextDynamicHandle(), "d60ab136-6c8a-5316-86b9-edfdbaa8b238", "dsi.upnp.DSIUPNPPlayer"));
        this.p_DSIUPNPPlayerReply = dSIUPNPPlayerReply;
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
                case 20: {
                    String string = iDeserializer.getOptionalString();
                    PlaybackMode[] playbackModeArray = PlaybackModeSerializer.getOptionalPlaybackModeVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIUPNPPlayerReply.updatePlaybackModeList(string, playbackModeArray, n);
                    break;
                }
                case 19: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIUPNPPlayerReply.updatePlaybackMode(string, n, n2);
                    break;
                }
                case 21: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIUPNPPlayerReply.updatePlaybackState(string, n, n3);
                    break;
                }
                case 18: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIUPNPPlayerReply.updatePlayPosition(string, string2, n, n4, n5);
                    break;
                }
                case 16: {
                    String string = iDeserializer.getOptionalString();
                    EntryInfo entryInfo = EntryInfoSerializer.getOptionalEntryInfo(iDeserializer);
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIUPNPPlayerReply.updateDetailInfo(string, entryInfo, resourceLocator, n);
                    break;
                }
                case 17: {
                    DeviceInfo[] deviceInfoArray = DeviceInfoSerializer.getOptionalDeviceInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIUPNPPlayerReply.updateDeviceList(deviceInfoArray, n);
                    break;
                }
                case 22: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIUPNPPlayerReply.updateVolume(string, n, n6);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIUPNPPlayerReply.asyncException(n, string, n7);
                    break;
                }
                case 23: {
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    this.p_DSIUPNPPlayerReply.yyIndication(string, string3);
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

