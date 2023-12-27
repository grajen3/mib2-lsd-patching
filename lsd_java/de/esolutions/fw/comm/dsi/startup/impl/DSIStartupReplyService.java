/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.startup.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.startup.DSIStartupReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIStartupReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.startup.DSIStartup");
    private static int dynamicHandle = 0;
    private DSIStartupReply p_DSIStartupReply;

    public DSIStartupReplyService(DSIStartupReply dSIStartupReply) {
        super(new ServiceInstanceID("29537988-2009-51c5-92b7-a91acc90fdcf", DSIStartupReplyService.nextDynamicHandle(), "315540c0-c0b8-557f-8f71-77bd39010efd", "dsi.startup.DSIStartup"));
        this.p_DSIStartupReply = dSIStartupReply;
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
                case 29: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusRoot(n, n2);
                    break;
                }
                case 33: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusTuner(n, n3);
                    break;
                }
                case 23: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusMedia(n, n4);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusAddressbook(n, n5);
                    break;
                }
                case 26: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusPhone(n, n6);
                    break;
                }
                case 25: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusNav(n, n7);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusInfo(n, n8);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusCar(n, n9);
                    break;
                }
                case 10: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusAudio(n, n10);
                    break;
                }
                case 30: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusSDS(n, n11);
                    break;
                }
                case 31: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusSWDL(n, n12);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusEarlyApps(n, n13);
                    break;
                }
                case 28: {
                    int n = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusPostStartup(n, n14);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusCommunication(n, n15);
                    break;
                }
                case 22: {
                    int n = iDeserializer.getInt32();
                    int n16 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusIpServices(n, n16);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getInt32();
                    int n17 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusGEMMI(n, n17);
                    break;
                }
                case 11: {
                    int n = iDeserializer.getInt32();
                    int n18 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusBapkombi(n, n18);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    int n19 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusBluetooth(n, n19);
                    break;
                }
                case 13: {
                    int n = iDeserializer.getInt32();
                    int n20 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusBrowser(n, n20);
                    break;
                }
                case 19: {
                    int n = iDeserializer.getInt32();
                    int n21 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusExplorer(n, n21);
                    break;
                }
                case 14: {
                    int n = iDeserializer.getInt32();
                    int n22 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusCalendar(n, n22);
                    break;
                }
                case 27: {
                    int n = iDeserializer.getInt32();
                    int n23 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusPictureStore(n, n23);
                    break;
                }
                case 32: {
                    int n = iDeserializer.getInt32();
                    int n24 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusStreetView(n, n24);
                    break;
                }
                case 24: {
                    int n = iDeserializer.getInt32();
                    int n25 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusMobilityHorizon(n, n25);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    int n26 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusExBoxM(n, n26);
                    break;
                }
                case 35: {
                    int n = iDeserializer.getInt32();
                    int n27 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusMirrorLink(n, n27);
                    break;
                }
                case 36: {
                    int n = iDeserializer.getInt32();
                    int n28 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusSFA(n, n28);
                    break;
                }
                case 37: {
                    int n = iDeserializer.getInt32();
                    int n29 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusSearch(n, n29);
                    break;
                }
                case 40: {
                    int n = iDeserializer.getInt32();
                    int n30 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusDiagnosis(n, n30);
                    break;
                }
                case 39: {
                    int n = iDeserializer.getInt32();
                    int n31 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusAsiaLanguageSupport(n, n31);
                    break;
                }
                case 41: {
                    int n = iDeserializer.getInt32();
                    int n32 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusExLAP(n, n32);
                    break;
                }
                case 42: {
                    int n = iDeserializer.getInt32();
                    int n33 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusTVTuner(n, n33);
                    break;
                }
                case 43: {
                    int n = iDeserializer.getInt32();
                    int n34 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusMediaOnline(n, n34);
                    break;
                }
                case 44: {
                    int n = iDeserializer.getInt32();
                    int n35 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusMediaRouter(n, n35);
                    break;
                }
                case 45: {
                    int n = iDeserializer.getInt32();
                    int n36 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusRadioDataServer(n, n36);
                    break;
                }
                case 46: {
                    int n = iDeserializer.getInt32();
                    int n37 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusSmartphoneIntegration(n, n37);
                    break;
                }
                case 47: {
                    int n = iDeserializer.getInt32();
                    int n38 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.updateDomainStatusWirelessCharger(n, n38);
                    break;
                }
                case 6: {
                    int n = iDeserializer.getInt32();
                    int n39 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.startDomain(n, n39);
                    break;
                }
                case 8: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n40 = iDeserializer.getInt32();
                    this.p_DSIStartupReply.asyncException(n, string, n40);
                    break;
                }
                case 34: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIStartupReply.yyIndication(string, string2);
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

