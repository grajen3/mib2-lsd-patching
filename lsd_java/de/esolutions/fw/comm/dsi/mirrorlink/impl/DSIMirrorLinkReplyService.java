/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mirrorlink.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.mirrorlink.DSIMirrorLinkReply;
import de.esolutions.fw.comm.dsi.mirrorlink.impl.ApplicationSerializer;
import de.esolutions.fw.comm.dsi.mirrorlink.impl.DeviceSerializer;
import de.esolutions.fw.comm.dsi.mirrorlink.impl.NotificationSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.mirrorlink.Application;
import org.dsi.ifc.mirrorlink.Device;
import org.dsi.ifc.mirrorlink.Notification;

public class DSIMirrorLinkReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.mirrorlink.DSIMirrorLink");
    private static int dynamicHandle = 0;
    private DSIMirrorLinkReply p_DSIMirrorLinkReply;

    public DSIMirrorLinkReplyService(DSIMirrorLinkReply dSIMirrorLinkReply) {
        super(new ServiceInstanceID("6fc7566e-a8c2-57e2-8cf0-22c0e333afe3", DSIMirrorLinkReplyService.nextDynamicHandle(), "aeae54ea-8c0f-58f6-bd12-0a4bd5ec2950", "dsi.mirrorlink.DSIMirrorLink"));
        this.p_DSIMirrorLinkReply = dSIMirrorLinkReply;
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
                    this.p_DSIMirrorLinkReply.responseClientCapabilities(n);
                    break;
                }
                case 25: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.responseAccessMode(n, n2);
                    break;
                }
                case 31: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.responseDayNightMode(n, n3);
                    break;
                }
                case 41: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.responseUsableViewPort(n, n4, n5, n6, n7);
                    break;
                }
                case 30: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.responseContextVisible(bl, n);
                    break;
                }
                case 29: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.responseConnectDevice(n, n8);
                    break;
                }
                case 32: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.responseDisconnectDevice(n, n9);
                    break;
                }
                case 34: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.responseRotateScreen(n, n10);
                    break;
                }
                case 37: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.responseSoftKeyEvent(n, n11, n12);
                    break;
                }
                case 33: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.responseLaunchApp(n, n13);
                    break;
                }
                case 40: {
                    int n = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.responseTerminateApp(n, n14);
                    break;
                }
                case 70: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.responseSpellerResult(string, string2, bl, n);
                    break;
                }
                case 35: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.responseSendString(n);
                    break;
                }
                case 27: {
                    int n = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.responseAudioOption(n, n15);
                    break;
                }
                case 26: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    int n16 = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.responseAudioConnectionAudible(n, bl, n16);
                    break;
                }
                case 36: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.responseSendTouchEvents(n);
                    break;
                }
                case 72: {
                    Device[] deviceArray = DeviceSerializer.getOptionalDeviceVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.updateDiscoveredDevices(deviceArray, n);
                    break;
                }
                case 48: {
                    int n = iDeserializer.getInt32();
                    int n17 = iDeserializer.getInt32();
                    int n18 = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.updateDeviceConnectionStatus(n, n17, n18);
                    break;
                }
                case 49: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.updateDeviceSoftKeys(nArray, n);
                    break;
                }
                case 45: {
                    int n = iDeserializer.getInt32();
                    int n19 = iDeserializer.getInt32();
                    int n20 = iDeserializer.getInt32();
                    int n21 = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.updateApplicationStatus(n, n19, n20, n21);
                    break;
                }
                case 51: {
                    int n = iDeserializer.getInt32();
                    int n22 = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.updateScreenOrientation(n, n22);
                    break;
                }
                case 54: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n23 = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.updateShowKeyboard(n, string, n23);
                    break;
                }
                case 52: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.updateScreenOrientationAvailable(bl, n);
                    break;
                }
                case 53: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.updateScreenRotationAvailable(bl, n);
                    break;
                }
                case 46: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    int n24 = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.updateAudioConnectionRequested(n, bl, n24);
                    break;
                }
                case 68: {
                    int n = iDeserializer.getInt32();
                    int n25 = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.responseKeyboardMode(n, n25);
                    break;
                }
                case 71: {
                    int n = iDeserializer.getInt32();
                    int n26 = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.updateAvailableApplicationsList(n, n26);
                    break;
                }
                case 64: {
                    int n = iDeserializer.getInt32();
                    Application[] applicationArray = ApplicationSerializer.getOptionalApplicationVarArray(iDeserializer);
                    int n27 = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.responseAvailableApplicationsWindow(n, applicationArray, n27);
                    break;
                }
                case 74: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.updateSingleApplicationMode(bl, n);
                    break;
                }
                case 66: {
                    int n = iDeserializer.getInt32();
                    int n28 = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.responseDisplayKeyboard(n, n28);
                    break;
                }
                case 65: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.responseDismissHMIKeyboard(n);
                    break;
                }
                case 67: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.responseFactorySettings(n);
                    break;
                }
                case 73: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.updatePhoneViewAvailable(bl, n);
                    break;
                }
                case 69: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.responsePhoneView(n);
                    break;
                }
                case 75: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.updateUncertifiedContent(bl, n);
                    break;
                }
                case 77: {
                    int n = iDeserializer.getInt32();
                    int n29 = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.updateDeviceStatus(n, n29);
                    break;
                }
                case 78: {
                    int n = iDeserializer.getInt32();
                    int n30 = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.updateSWaPStatus(n, n30);
                    break;
                }
                case 81: {
                    this.p_DSIMirrorLinkReply.responseContextSwitched();
                    break;
                }
                case 87: {
                    Notification notification = NotificationSerializer.getOptionalNotification(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.updateShowNotification(notification, n);
                    break;
                }
                case 86: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.updateNotificationServiceEnabled(bl, n);
                    break;
                }
                case 85: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.updateLocationDataServicesEnabled(bl, n);
                    break;
                }
                case 88: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.updateSwitchToClientNativeUI(n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n31 = iDeserializer.getInt32();
                    this.p_DSIMirrorLinkReply.asyncException(n, string, n31);
                    break;
                }
                case 55: {
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    this.p_DSIMirrorLinkReply.yyIndication(string, string3);
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

