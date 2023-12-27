/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.displaymanagement.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.displaymanagement.DSIDisplayManagementReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIDisplayManagementReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.displaymanagement.DSIDisplayManagement");
    private static int dynamicHandle = 0;
    private DSIDisplayManagementReply p_DSIDisplayManagementReply;

    public DSIDisplayManagementReplyService(DSIDisplayManagementReply dSIDisplayManagementReply) {
        super(new ServiceInstanceID("f20ac96e-5798-5645-b002-79c3f154460f", DSIDisplayManagementReplyService.nextDynamicHandle(), "0a94880b-c8d5-54ef-b374-ab6963ae14d6", "dsi.displaymanagement.DSIDisplayManagement"));
        this.p_DSIDisplayManagementReply = dSIDisplayManagementReply;
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
                case 39: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.getExtents(n, n2, n3);
                    break;
                }
                case 30: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.activeContext(n, n4, n5);
                    break;
                }
                case 33: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.fadeStarted(n, n6);
                    break;
                }
                case 32: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.fadeComplete(n, n7);
                    break;
                }
                case 38: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.getDisplayPower(n, n8);
                    break;
                }
                case 37: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.getDisplayBrightness(n, n9);
                    break;
                }
                case 34: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.getBrightness(n, n10);
                    break;
                }
                case 36: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.getContrast(n, n11);
                    break;
                }
                case 35: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.getColor(n, n12);
                    break;
                }
                case 40: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.getTint(n, n13);
                    break;
                }
                case 41: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.lockDisplayResult(n);
                    break;
                }
                case 43: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.unlockDisplayResult(n);
                    break;
                }
                case 42: {
                    int n = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    int n16 = iDeserializer.getInt32();
                    int n17 = iDeserializer.getInt32();
                    int n18 = iDeserializer.getInt32();
                    int n19 = iDeserializer.getInt32();
                    int n20 = iDeserializer.getInt32();
                    int n21 = iDeserializer.getInt32();
                    int n22 = iDeserializer.getInt32();
                    int n23 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.setCroppingResult(n, n14, n15, n16, n17, n18, n19, n20, n21, n22, n23);
                    break;
                }
                case 46: {
                    int n = iDeserializer.getInt32();
                    int n24 = iDeserializer.getInt32();
                    int n25 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.getDisplayableInfo(n, n24, n25);
                    break;
                }
                case 50: {
                    int n = iDeserializer.getInt32();
                    int n26 = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIDisplayManagementReply.takeScreenshotOnExternalStorageResult(n, n26, string);
                    break;
                }
                case 56: {
                    int n = iDeserializer.getInt32();
                    int n27 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.setDisplayTypeResult(n, n27);
                    break;
                }
                case 52: {
                    int n = iDeserializer.getInt32();
                    int n28 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.getDisplayTypeResult(n, n28);
                    break;
                }
                case 58: {
                    int n = iDeserializer.getInt32();
                    int n29 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.setUpdateRateResult(n, n29);
                    break;
                }
                case 54: {
                    int n = iDeserializer.getInt32();
                    int n30 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.getUpdateRateResult(n, n30);
                    break;
                }
                case 60: {
                    int n = iDeserializer.getInt32();
                    int n31 = iDeserializer.getInt32();
                    int n32 = iDeserializer.getInt32();
                    int n33 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.startComponentResult(n, n31, n32, n33);
                    break;
                }
                case 62: {
                    int n = iDeserializer.getInt32();
                    int n34 = iDeserializer.getInt32();
                    int n35 = iDeserializer.getInt32();
                    int n36 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.stopComponentResult(n, n34, n35, n36);
                    break;
                }
                case 72: {
                    int n = iDeserializer.getInt32();
                    int n37 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.setAnnotationDataResponse(n, n37);
                    break;
                }
                case 68: {
                    int n = iDeserializer.getInt32();
                    int n38 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.initAnnotationsResponse(n, n38);
                    break;
                }
                case 66: {
                    int n = iDeserializer.getInt32();
                    int n39 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.destroyImageDisplayableResponse(n, n39);
                    break;
                }
                case 70: {
                    int n = iDeserializer.getInt32();
                    int n40 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.requestUpdateImageDisplayableResponse(n, n40);
                    break;
                }
                case 64: {
                    int n = iDeserializer.getInt32();
                    int n41 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.createImageDisplayableResponse(n, n41);
                    break;
                }
                case 31: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n42 = iDeserializer.getInt32();
                    this.p_DSIDisplayManagementReply.asyncException(n, string, n42);
                    break;
                }
                case 44: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIDisplayManagementReply.yyIndication(string, string2);
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

