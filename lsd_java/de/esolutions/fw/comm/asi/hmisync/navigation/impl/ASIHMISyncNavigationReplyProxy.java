/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation.impl;

import de.esolutions.fw.comm.asi.hmisync.navigation.ASIHMISyncNavigationReply;
import de.esolutions.fw.comm.asi.hmisync.navigation.CarPosition;
import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;
import de.esolutions.fw.comm.asi.hmisync.navigation.NextDestinationInfo;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationReplyProxy$1;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationReplyProxy$10;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationReplyProxy$2;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationReplyProxy$3;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationReplyProxy$4;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationReplyProxy$5;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationReplyProxy$6;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationReplyProxy$7;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationReplyProxy$8;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationReplyProxy$9;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ASIHMISyncNavigationReplyProxy
implements ASIHMISyncNavigationReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.navigation.ASIHMISyncNavigation");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public ASIHMISyncNavigationReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("8d39242f-638c-434c-a3c2-23fe7dad4907", -1, "85677657-50cb-53c6-b534-c27796d5fb16", "asi.hmisync.navigation.ASIHMISyncNavigation");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void startGuidanceToDestinationsResult(int n) {
        ASIHMISyncNavigationReplyProxy$1 aSIHMISyncNavigationReplyProxy$1 = new ASIHMISyncNavigationReplyProxy$1(this, n);
        this.proxy.remoteCallMethod((short)9, aSIHMISyncNavigationReplyProxy$1);
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
        ASIHMISyncNavigationReplyProxy$2 aSIHMISyncNavigationReplyProxy$2 = new ASIHMISyncNavigationReplyProxy$2(this, string, bl);
        this.proxy.remoteCallMethod((short)10, aSIHMISyncNavigationReplyProxy$2);
    }

    @Override
    public void updateRequestIDs(short[] sArray, boolean bl) {
        ASIHMISyncNavigationReplyProxy$3 aSIHMISyncNavigationReplyProxy$3 = new ASIHMISyncNavigationReplyProxy$3(this, sArray, bl);
        this.proxy.remoteCallMethod((short)19, aSIHMISyncNavigationReplyProxy$3);
    }

    @Override
    public void updateReplyIDs(short[] sArray, boolean bl) {
        ASIHMISyncNavigationReplyProxy$4 aSIHMISyncNavigationReplyProxy$4 = new ASIHMISyncNavigationReplyProxy$4(this, sArray, bl);
        this.proxy.remoteCallMethod((short)18, aSIHMISyncNavigationReplyProxy$4);
    }

    @Override
    public void updateRouteGuidanceActive(boolean bl, boolean bl2) {
        ASIHMISyncNavigationReplyProxy$5 aSIHMISyncNavigationReplyProxy$5 = new ASIHMISyncNavigationReplyProxy$5(this, bl, bl2);
        this.proxy.remoteCallMethod((short)16, aSIHMISyncNavigationReplyProxy$5);
    }

    @Override
    public void updateCarPosition(CarPosition carPosition, boolean bl) {
        ASIHMISyncNavigationReplyProxy$6 aSIHMISyncNavigationReplyProxy$6 = new ASIHMISyncNavigationReplyProxy$6(this, carPosition, bl);
        this.proxy.remoteCallMethod((short)11, aSIHMISyncNavigationReplyProxy$6);
    }

    @Override
    public void updateDestinationInfo(DestinationInfo[] destinationInfoArray, boolean bl) {
        ASIHMISyncNavigationReplyProxy$7 aSIHMISyncNavigationReplyProxy$7 = new ASIHMISyncNavigationReplyProxy$7(this, destinationInfoArray, bl);
        this.proxy.remoteCallMethod((short)12, aSIHMISyncNavigationReplyProxy$7);
    }

    @Override
    public void updateDestinationsForGuidance(DestinationInfo[] destinationInfoArray, boolean bl) {
        ASIHMISyncNavigationReplyProxy$8 aSIHMISyncNavigationReplyProxy$8 = new ASIHMISyncNavigationReplyProxy$8(this, destinationInfoArray, bl);
        this.proxy.remoteCallMethod((short)13, aSIHMISyncNavigationReplyProxy$8);
    }

    @Override
    public void updateNextDestinationInfo(NextDestinationInfo nextDestinationInfo, boolean bl) {
        ASIHMISyncNavigationReplyProxy$9 aSIHMISyncNavigationReplyProxy$9 = new ASIHMISyncNavigationReplyProxy$9(this, nextDestinationInfo, bl);
        this.proxy.remoteCallMethod((short)15, aSIHMISyncNavigationReplyProxy$9);
    }

    @Override
    public void updateNightDesignRequested(boolean bl, boolean bl2) {
        ASIHMISyncNavigationReplyProxy$10 aSIHMISyncNavigationReplyProxy$10 = new ASIHMISyncNavigationReplyProxy$10(this, bl, bl2);
        this.proxy.remoteCallMethod((short)17, aSIHMISyncNavigationReplyProxy$10);
    }
}

