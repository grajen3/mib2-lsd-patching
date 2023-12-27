/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.trafficminimap.states;

import de.vw.mib.asl.api.online.ASLOnlineServiceIdentifier;
import de.vw.mib.asl.internal.trafficminimap.states.TrafficMiniMapParentState;

class TrafficMiniMapParentState$1
implements ASLOnlineServiceIdentifier {
    private final /* synthetic */ TrafficMiniMapParentState this$0;

    TrafficMiniMapParentState$1(TrafficMiniMapParentState trafficMiniMapParentState) {
        this.this$0 = trafficMiniMapParentState;
    }

    @Override
    public boolean isServiceValid() {
        return true;
    }

    @Override
    public String getServiceidentifier() {
        return "traffic_minimap";
    }

    @Override
    public void setServiceID(String string) {
    }

    @Override
    public String getServiceID() {
        return null;
    }

    @Override
    public void setApplicationID(String string) {
    }

    @Override
    public String getApplicationID() {
        return null;
    }
}

