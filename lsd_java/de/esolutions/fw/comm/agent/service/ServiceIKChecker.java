/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.service;

import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.ServiceUUID;

public class ServiceIKChecker {
    private final boolean ignoreIK;

    public ServiceIKChecker(boolean bl) {
        this.ignoreIK = bl;
    }

    public boolean isCompatible(String string, ServiceInstanceID serviceInstanceID, ServiceInstanceID serviceInstanceID2) {
        return this.isCompatible(string, serviceInstanceID, serviceInstanceID2, null);
    }

    public boolean isCompatible(String string, ServiceInstanceID serviceInstanceID, ServiceInstanceID serviceInstanceID2, Boolean bl) {
        ServiceUUID serviceUUID;
        int n;
        ServiceUUID serviceUUID2;
        if (serviceInstanceID == null) {
            CommAgentTracing.IKCHECKER.log((short)2, "%1: no mine service ID!", (Object)string);
            return false;
        }
        if (serviceInstanceID2 == null) {
            CommAgentTracing.IKCHECKER.log((short)2, "%1: no other service ID!", (Object)string);
            return false;
        }
        ServiceUUID serviceUUID3 = serviceInstanceID.getServiceUUID();
        if (!serviceUUID3.equals(serviceUUID2 = serviceInstanceID2.getServiceUUID())) {
            CommAgentTracing.IKCHECKER.log((short)2, "%1: service UUID mismatch: %2 != %3!", (Object)string, (Object)serviceUUID3, (Object)serviceUUID2);
            return false;
        }
        int n2 = serviceInstanceID.getHandle();
        if (n2 != (n = serviceInstanceID2.getHandle())) {
            CommAgentTracing.IKCHECKER.log((short)2, "%1: service handle mismatch: %2 != %3!", (Object)string, (Object)new Integer(n2), (Object)new Integer(n));
            return false;
        }
        ServiceUUID serviceUUID4 = serviceInstanceID.getInterfaceKey();
        if (serviceUUID4.equals(serviceUUID = serviceInstanceID2.getInterfaceKey())) {
            CommAgentTracing.IKCHECKER.log((short)2, "%1: full match with IK: %2 == %3!", (Object)string, (Object)serviceInstanceID, (Object)serviceInstanceID2);
            return true;
        }
        if (serviceUUID4.isZero() || serviceUUID.isZero()) {
            CommAgentTracing.IKCHECKER.log((short)2, "%1: match with zero IK: %2 == %3", (Object)string, (Object)serviceInstanceID, (Object)serviceInstanceID2);
            return true;
        }
        boolean bl2 = this.ignoreIK;
        if (bl != null) {
            boolean bl3 = bl2 = bl == false;
        }
        if (bl2) {
            CommAgentTracing.IKCHECKER.log((short)3, "%1: IK mismatch (IGNORED): %2 =! %3!", (Object)string, (Object)serviceInstanceID, (Object)serviceInstanceID2);
            return true;
        }
        CommAgentTracing.IKCHECKER.log((short)2, "%1: IK mismatch (failed): %2 =! %3!", (Object)string, (Object)serviceInstanceID, (Object)serviceInstanceID2);
        return false;
    }

    public boolean isEquals(ServiceInstanceID serviceInstanceID, ServiceInstanceID serviceInstanceID2) {
        if (serviceInstanceID == null || serviceInstanceID2 == null) {
            return false;
        }
        return serviceInstanceID.getServiceUUID().equals(serviceInstanceID2.getServiceUUID()) && serviceInstanceID.getInterfaceKey().equals(serviceInstanceID2.getInterfaceKey()) && serviceInstanceID.getHandle() == serviceInstanceID2.getHandle();
    }
}

