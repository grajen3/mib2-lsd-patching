/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.diag.info;

import de.esolutions.fw.comm.agent.diag.AbstractInfoBase;
import de.esolutions.fw.comm.agent.service.Stub;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import java.lang.reflect.Field;

public class StubInfo
extends AbstractInfoBase {
    public final ServiceInstanceID svcID;
    public final String svcClass;
    public final String svcWorker;
    public final short peerProxyID;
    public final short peerAgentID;
    public final int callsTotal;
    public final int callsPending;
    public final int callsError;
    public final int latencyMin;
    public final int latencyMax;
    public final int latencyAvg;
    public final int durationMin;
    public final int durationMax;
    public final int durationAvg;

    public StubInfo(Stub stub) {
        super(stub.getStubID());
        IService iService = stub.getService();
        this.svcID = iService.getInstanceID();
        this.svcClass = super.getClass().getName();
        this.svcWorker = super.getClass().getName();
        this.peerProxyID = stub.getRemoteProxyID();
        this.peerAgentID = stub.getRemoteAgentID();
        this.callsTotal = stub.getTotalCalls();
        this.callsPending = stub.getPendingCalls();
        this.callsError = stub.getErrorCalls();
        int[] nArray = stub.getInvocationLatency();
        this.latencyMin = nArray[0];
        this.latencyMax = nArray[1];
        this.latencyAvg = nArray[2];
        int[] nArray2 = stub.getInvocationDuration();
        this.durationMin = nArray2[0];
        this.durationMax = nArray2[1];
        this.durationAvg = nArray2[2];
    }

    @Override
    protected Object fieldValueToObject(Field field) {
        if (field == null) {
            return null;
        }
        String string = field.getName();
        if (string.equals("callsTotal") && this.callsTotal == 0 || string.equals("callsPending") && this.callsPending == 0 || string.equals("callsError") && this.callsError == 0 || string.equals("latencyMin") && this.latencyMin == -129 || string.equals("latencyMax") && this.latencyMin == -129 || string.equals("latencyAvg") && this.latencyMin == -129 || string.equals("durationMin") && this.durationMin == -129 || string.equals("durationMax") && this.durationMin == -129 || string.equals("durationAvg") && this.durationMin == -129) {
            return null;
        }
        return super.fieldValueToObject(field);
    }

    @Override
    public ServiceInstanceID getServiceInstanceID() {
        return this.svcID;
    }
}

