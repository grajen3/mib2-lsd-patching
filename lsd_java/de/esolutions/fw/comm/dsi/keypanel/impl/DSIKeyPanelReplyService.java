/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.keypanel.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.keypanel.DSIKeyPanelReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIKeyPanelReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.keypanel.DSIKeyPanel");
    private static int dynamicHandle = 0;
    private DSIKeyPanelReply p_DSIKeyPanelReply;

    public DSIKeyPanelReplyService(DSIKeyPanelReply dSIKeyPanelReply) {
        super(new ServiceInstanceID("5ff7918a-abb4-545e-9661-bdbeef142ed1", DSIKeyPanelReplyService.nextDynamicHandle(), "633a3b39-3b09-57ba-bc39-eebaf5ef6848", "dsi.keypanel.DSIKeyPanel"));
        this.p_DSIKeyPanelReply = dSIKeyPanelReply;
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
                case 38: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIKeyPanelReply.updateKey2(n, n2, n3, n4, n5);
                    break;
                }
                case 30: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIKeyPanelReply.updateEncoder2(n, n6, n7, n8, n9);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIKeyPanelReply.updateDisplayTurnMechStatus(n, n10);
                    break;
                }
                case 33: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n11 = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSIKeyPanelReply.updateRecognizerLanguage2(n, string, n11, n12);
                    break;
                }
                case 24: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSIKeyPanelReply.updateRecognizerMode(n, n13, n14);
                    break;
                }
                case 29: {
                    int n = iDeserializer.getInt32();
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSIKeyPanelReply.updateCharacterEvent2(n, stringArray, nArray, n15);
                    break;
                }
                case 42: {
                    int n = iDeserializer.getInt32();
                    int n16 = iDeserializer.getInt32();
                    int n17 = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    int n18 = iDeserializer.getInt32();
                    int n19 = iDeserializer.getInt32();
                    int n20 = iDeserializer.getInt32();
                    int n21 = iDeserializer.getInt32();
                    int n22 = iDeserializer.getInt32();
                    int n23 = iDeserializer.getInt32();
                    this.p_DSIKeyPanelReply.updateGesture2(n, n16, n17, bl, n18, n19, n20, n21, n22, n23);
                    break;
                }
                case 4: {
                    int n = iDeserializer.getInt32();
                    int n24 = iDeserializer.getInt32();
                    int n25 = iDeserializer.getInt32();
                    this.p_DSIKeyPanelReply.genericSettingResponse(n, n24, n25);
                    break;
                }
                case 22: {
                    int n = iDeserializer.getInt32();
                    int n26 = iDeserializer.getInt32();
                    int n27 = iDeserializer.getInt32();
                    this.p_DSIKeyPanelReply.updateProximity(n, n26, n27);
                    break;
                }
                case 46: {
                    int n = iDeserializer.getInt32();
                    int n28 = iDeserializer.getInt32();
                    int n29 = iDeserializer.getInt32();
                    int n30 = iDeserializer.getInt32();
                    int n31 = iDeserializer.getInt32();
                    int n32 = iDeserializer.getInt32();
                    int n33 = iDeserializer.getInt32();
                    int n34 = iDeserializer.getInt32();
                    int n35 = iDeserializer.getInt32();
                    int n36 = iDeserializer.getInt32();
                    this.p_DSIKeyPanelReply.updateAdvancedProximity(n, n28, n29, n30, n31, n32, n33, n34, n35, n36);
                    break;
                }
                case 5: {
                    int n = iDeserializer.getInt32();
                    int n37 = iDeserializer.getInt32();
                    int n38 = iDeserializer.getInt32();
                    this.p_DSIKeyPanelReply.lastKey(n, n37, n38);
                    break;
                }
                case 32: {
                    int n = iDeserializer.getInt32();
                    int n39 = iDeserializer.getInt32();
                    this.p_DSIKeyPanelReply.updateKeyboardType(n, n39);
                    break;
                }
                case 39: {
                    int n = iDeserializer.getInt32();
                    int n40 = iDeserializer.getInt32();
                    int n41 = iDeserializer.getInt32();
                    int n42 = iDeserializer.getInt32();
                    int n43 = iDeserializer.getInt32();
                    int n44 = iDeserializer.getInt32();
                    this.p_DSIKeyPanelReply.updateTouchSensitiveArea(n, n40, n41, n42, n43, n44);
                    break;
                }
                case 35: {
                    int n = iDeserializer.getInt32();
                    int n45 = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIKeyPanelReply.getVersionInfo(n, n45, string);
                    break;
                }
                case 43: {
                    int n = iDeserializer.getInt32();
                    int n46 = iDeserializer.getInt32();
                    int n47 = iDeserializer.getInt32();
                    this.p_DSIKeyPanelReply.updateInputPanelReady(n, n46, n47);
                    break;
                }
                case 45: {
                    int n = iDeserializer.getInt32();
                    int n48 = iDeserializer.getInt32();
                    int n49 = iDeserializer.getInt32();
                    int n50 = iDeserializer.getInt32();
                    byte[] byArray = iDeserializer.getOptionalInt8VarArray();
                    this.p_DSIKeyPanelReply.getProperty(n, n48, n49, n50, byArray);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n51 = iDeserializer.getInt32();
                    this.p_DSIKeyPanelReply.asyncException(n, string, n51);
                    break;
                }
                case 25: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIKeyPanelReply.yyIndication(string, string2);
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

