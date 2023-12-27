/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.getinfoforscreenposition;

import de.vw.mib.genericevents.AbstractTarget;
import java.util.ArrayList;
import java.util.List;

public class DSIMapViewerGetInfoForScreenPositionDatapool {
    private final List requests = new ArrayList();
    private final int serviceInstanceId;
    private AbstractTarget targetCurrentRequest;

    public DSIMapViewerGetInfoForScreenPositionDatapool(int n) {
        this.serviceInstanceId = n;
    }

    public List getRequests() {
        return this.requests;
    }

    public int getServiceInstanceId() {
        return this.serviceInstanceId;
    }

    public AbstractTarget getTargetCurrentRequest() {
        return this.targetCurrentRequest;
    }

    public void setTargetCurrentRequest(AbstractTarget abstractTarget) {
        this.targetCurrentRequest = abstractTarget;
    }
}

