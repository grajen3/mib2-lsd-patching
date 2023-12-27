/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.networking.DSIWLANReply;
import de.esolutions.fw.comm.dsi.networking.impl.DiscoveredNetworkSerializer;
import de.esolutions.fw.comm.dsi.networking.impl.NodeSerializer;
import de.esolutions.fw.comm.dsi.networking.impl.ProfileSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.networking.DiscoveredNetwork;
import org.dsi.ifc.networking.Node;
import org.dsi.ifc.networking.Profile;

public class DSIWLANReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.networking.DSIWLAN");
    private static int dynamicHandle = 0;
    private DSIWLANReply p_DSIWLANReply;

    public DSIWLANReplyService(DSIWLANReply dSIWLANReply) {
        super(new ServiceInstanceID("15f2fca3-02cf-5877-9cdc-5e1b1d2c45ee", DSIWLANReplyService.nextDynamicHandle(), "cb229820-4319-510c-aa41-f4274d5a45c4", "dsi.networking.DSIWLAN"));
        this.p_DSIWLANReply = dSIWLANReply;
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
                case 34: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIWLANReply.updateRole(n, n2);
                    break;
                }
                case 33: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIWLANReply.updateRFActive(n, n3);
                    break;
                }
                case 31: {
                    Node[] nodeArray = NodeSerializer.getOptionalNodeVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIWLANReply.updateNodeList(nodeArray, n);
                    break;
                }
                case 57: {
                    Profile profile = ProfileSerializer.getOptionalProfile(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIWLANReply.updateProfile(profile, n);
                    break;
                }
                case 38: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIWLANReply.updateWlanEnabled(bl, n);
                    break;
                }
                case 37: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIWLANReply.updateStartupState(n, n4);
                    break;
                }
                case 61: {
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    String[] stringArray2 = iDeserializer.getOptionalStringVarArray();
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIWLANReply.updateTrustedNetworks(stringArray, stringArray2, nArray, n);
                    break;
                }
                case 65: {
                    DiscoveredNetwork discoveredNetwork = DiscoveredNetworkSerializer.getOptionalDiscoveredNetwork(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIWLANReply.updateDiscoveredNetwork(discoveredNetwork, n);
                    break;
                }
                case 55: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIWLANReply.updateConnectedNetwork(string, string2, n, n5);
                    break;
                }
                case 50: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIWLANReply.responseFactoryReset(n);
                    break;
                }
                case 54: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIWLANReply.responseSetRole(n);
                    break;
                }
                case 53: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIWLANReply.responseSetRFActive(n);
                    break;
                }
                case 52: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIWLANReply.responseSetProfile(n);
                    break;
                }
                case 51: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIWLANReply.responseNetworkSearch(n, n6);
                    break;
                }
                case 46: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIWLANReply.responseAbortSearch(n);
                    break;
                }
                case 47: {
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIWLANReply.responseConnectNetwork(string, string3, n);
                    break;
                }
                case 49: {
                    String string = iDeserializer.getOptionalString();
                    String string4 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIWLANReply.responseDisconnectNetwork(string, string4, n);
                    break;
                }
                case 48: {
                    String string = iDeserializer.getOptionalString();
                    String string5 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIWLANReply.responseDeleteTrustedNetwork(string, string5, n);
                    break;
                }
                case 64: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIWLANReply.responseActivateWps(n);
                    break;
                }
                case 66: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIWLANReply.updateWPSRunning(n, n7);
                    break;
                }
                case 67: {
                    String string = iDeserializer.getOptionalString();
                    String string6 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIWLANReply.updateWPSStoppedAndConnecting(string, string6, n);
                    break;
                }
                case 2: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIWLANReply.asyncException(n, string, n8);
                    break;
                }
                case 39: {
                    String string = iDeserializer.getOptionalString();
                    String string7 = iDeserializer.getOptionalString();
                    this.p_DSIWLANReply.yyIndication(string, string7);
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

