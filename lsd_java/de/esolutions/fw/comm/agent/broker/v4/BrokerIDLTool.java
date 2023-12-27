/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.broker.v4;

import de.esolutions.fw.comm.comm.broker.v4.InstanceID;
import de.esolutions.fw.comm.comm.broker.v4.UUID844412Blob;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.ServiceUUID;
import de.esolutions.fw.comm.core.UUID;

public class BrokerIDLTool {
    public static InstanceID convertInstanceIDToIDL(ServiceInstanceID serviceInstanceID) {
        int n;
        byte[] byArray = serviceInstanceID.getServiceUUID().getUUID().getRawBytes();
        byte[] byArray2 = serviceInstanceID.getInterfaceKey().getUUID().getRawBytes();
        short[] sArray = new short[byArray.length];
        short[] sArray2 = new short[byArray2.length];
        for (n = 0; n < byArray.length; ++n) {
            sArray[n] = (short)(byArray[n] & 0xFF);
        }
        for (n = 0; n < byArray2.length; ++n) {
            sArray2[n] = (short)(byArray2[n] & 0xFF);
        }
        n = serviceInstanceID.getHandle();
        long l = (long)n & 0;
        UUID844412Blob uUID844412Blob = new UUID844412Blob(sArray);
        UUID844412Blob uUID844412Blob2 = new UUID844412Blob(sArray2);
        return new InstanceID(uUID844412Blob, l, uUID844412Blob2);
    }

    public static ServiceInstanceID convertInstanceIDFromIDL(InstanceID instanceID) {
        int n;
        short[] sArray = instanceID.id.bytes;
        short[] sArray2 = instanceID.key.bytes;
        byte[] byArray = new byte[sArray.length];
        byte[] byArray2 = new byte[sArray2.length];
        for (n = 0; n < sArray.length; ++n) {
            byArray[n] = (byte)(sArray[n] & 0xFF);
        }
        for (n = 0; n < sArray2.length; ++n) {
            byArray2[n] = (byte)(sArray2[n] & 0xFF);
        }
        n = (int)(instanceID.handle & 0xFFFFFFFFFFFFFFFFL);
        ServiceUUID serviceUUID = new ServiceUUID(new UUID(byArray));
        ServiceUUID serviceUUID2 = new ServiceUUID(new UUID(byArray2));
        return new ServiceInstanceID(serviceUUID, n, serviceUUID2);
    }

    public static void main(String[] stringArray) {
        int n = 41943424;
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID(new ServiceUUID("8d4f7cec-be0c-49b7-b1b6-1e3e4c26b847"), n, new ServiceUUID("8935d19b-313a-5d23-bf1f-64bc869ad545"));
        System.out.println(serviceInstanceID);
        InstanceID instanceID = BrokerIDLTool.convertInstanceIDToIDL(serviceInstanceID);
        System.out.println(new StringBuffer().append("handle ").append(Long.toHexString(instanceID.getHandle())).toString());
        ServiceInstanceID serviceInstanceID2 = BrokerIDLTool.convertInstanceIDFromIDL(instanceID);
        System.out.println(serviceInstanceID2);
    }
}

