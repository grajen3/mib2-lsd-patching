/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swdlselection.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.swdlselection.DSISwdlSelectionReply;
import de.esolutions.fw.comm.dsi.swdlselection.impl.LameClientSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.swdlselection.LameClient;

public class DSISwdlSelectionReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.swdlselection.DSISwdlSelection");
    private static int dynamicHandle = 0;
    private DSISwdlSelectionReply p_DSISwdlSelectionReply;

    public DSISwdlSelectionReplyService(DSISwdlSelectionReply dSISwdlSelectionReply) {
        super(new ServiceInstanceID("fb91eb47-429d-5abb-ab06-b298a7835f6d", DSISwdlSelectionReplyService.nextDynamicHandle(), "3f2a3d3c-757b-5e14-88ca-e40491368c8e", "dsi.swdlselection.DSISwdlSelection"));
        this.p_DSISwdlSelectionReply = dSISwdlSelectionReply;
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
                case 51: {
                    LameClient[] lameClientArray = LameClientSerializer.getOptionalLameClientVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSISwdlSelectionReply.updateLameClients(lameClientArray, n);
                    break;
                }
                case 50: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSISwdlSelectionReply.updateEngineering(bl, n);
                    break;
                }
                case 54: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSISwdlSelectionReply.updateUserSwdl(bl, n);
                    break;
                }
                case 52: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSISwdlSelectionReply.updateRingNotOK(bl, n);
                    break;
                }
                case 49: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSISwdlSelectionReply.updateEndDownload(bl, n);
                    break;
                }
                case 48: {
                    byte by = iDeserializer.getInt8();
                    int n = iDeserializer.getInt32();
                    this.p_DSISwdlSelectionReply.updateAvailableMedia(by, n);
                    break;
                }
                case 53: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSISwdlSelectionReply.updateUnitType(n, n2);
                    break;
                }
                case 18: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSISwdlSelectionReply.getMedia(nArray);
                    break;
                }
                case 44: {
                    String string = iDeserializer.getOptionalString();
                    this.p_DSISwdlSelectionReply.storeNfsIpAddress(string);
                    break;
                }
                case 46: {
                    String string = iDeserializer.getOptionalString();
                    this.p_DSISwdlSelectionReply.storeNfsPath(string);
                    break;
                }
                case 42: {
                    String string = iDeserializer.getOptionalString();
                    this.p_DSISwdlSelectionReply.storeFsPath(string);
                    break;
                }
                case 26: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    this.p_DSISwdlSelectionReply.setMedium(n, string, stringArray);
                    break;
                }
                case 31: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSISwdlSelectionReply.setRelease(n, string);
                    break;
                }
                case 20: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSISwdlSelectionReply.getUserDefinedAllowed(bl);
                    break;
                }
                case 32: {
                    short s2 = iDeserializer.getInt16();
                    this.p_DSISwdlSelectionReply.setTargetLanguage(s2);
                    break;
                }
                case 16: {
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    String[] stringArray2 = iDeserializer.getOptionalStringVarArray();
                    this.p_DSISwdlSelectionReply.getIncompatibleDevices(stringArray, stringArray2);
                    break;
                }
                case 37: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSISwdlSelectionReply.startVersionUpload(bl);
                    break;
                }
                case 7: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    String string = iDeserializer.getOptionalString();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSISwdlSelectionReply.checkConsistency(n, bl, string, n3);
                    break;
                }
                case 0: {
                    this.p_DSISwdlSelectionReply.abortSetMedium();
                    break;
                }
                case 2: {
                    this.p_DSISwdlSelectionReply.abortSetRelease();
                    break;
                }
                case 14: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSISwdlSelectionReply.getFinalizeTargets(nArray);
                    break;
                }
                case 22: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    long l2 = iDeserializer.getInt64();
                    long l3 = iDeserializer.getInt64();
                    this.p_DSISwdlSelectionReply.setFinalizeTarget(n, l, l2, l3);
                    break;
                }
                case 57: {
                    this.p_DSISwdlSelectionReply.enterComponentUpdateConfirmation();
                    break;
                }
                case 5: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSISwdlSelectionReply.asyncException(n, string, n4);
                    break;
                }
                case 55: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSISwdlSelectionReply.yyIndication(string, string2);
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

