/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.persistence.IPersistenceAReply;
import de.esolutions.fw.comm.persistence.PartitionHandle;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$1;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$10;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$11;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$12;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$13;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$14;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$15;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$16;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$17;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$18;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$19;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$2;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$20;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$21;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$22;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$23;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$24;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$25;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$3;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$4;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$5;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$6;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$7;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$8;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyProxy$9;

public class IPersistenceAReplyProxy
implements IPersistenceAReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.persistence.IPersistenceA");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public IPersistenceAReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("f4ac6df9-a35a-4f1c-a334-9c2890a41c09", -1, "21034d62-3469-5d3a-b904-de8a9709a4ed", "persistence.IPersistenceA");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void openResult(long l, String string, PartitionHandle partitionHandle, int n) {
        IPersistenceAReplyProxy$1 iPersistenceAReplyProxy$1 = new IPersistenceAReplyProxy$1(this, l, string, partitionHandle, n);
        this.proxy.remoteCallMethod((short)74, iPersistenceAReplyProxy$1);
    }

    @Override
    public void openResult(String string, String string2, PartitionHandle partitionHandle, int n) {
        IPersistenceAReplyProxy$2 iPersistenceAReplyProxy$2 = new IPersistenceAReplyProxy$2(this, string, string2, partitionHandle, n);
        this.proxy.remoteCallMethod((short)73, iPersistenceAReplyProxy$2);
    }

    @Override
    public void closeResult(PartitionHandle partitionHandle, int n) {
        IPersistenceAReplyProxy$3 iPersistenceAReplyProxy$3 = new IPersistenceAReplyProxy$3(this, partitionHandle, n);
        this.proxy.remoteCallMethod((short)54, iPersistenceAReplyProxy$3);
    }

    @Override
    public void versionResult(long l, String string, int n) {
        IPersistenceAReplyProxy$4 iPersistenceAReplyProxy$4 = new IPersistenceAReplyProxy$4(this, l, string, n);
        this.proxy.remoteCallMethod((short)83, iPersistenceAReplyProxy$4);
    }

    @Override
    public void versionResult(String string, String string2, int n) {
        IPersistenceAReplyProxy$5 iPersistenceAReplyProxy$5 = new IPersistenceAReplyProxy$5(this, string, string2, n);
        this.proxy.remoteCallMethod((short)82, iPersistenceAReplyProxy$5);
    }

    @Override
    public void purgeResult(long l, int n) {
        IPersistenceAReplyProxy$6 iPersistenceAReplyProxy$6 = new IPersistenceAReplyProxy$6(this, l, n);
        this.proxy.remoteCallMethod((short)76, iPersistenceAReplyProxy$6);
    }

    @Override
    public void purgeResult(String string, int n) {
        IPersistenceAReplyProxy$7 iPersistenceAReplyProxy$7 = new IPersistenceAReplyProxy$7(this, string, n);
        this.proxy.remoteCallMethod((short)75, iPersistenceAReplyProxy$7);
    }

    @Override
    public void beginTransactionResult(PartitionHandle partitionHandle, int n) {
        IPersistenceAReplyProxy$8 iPersistenceAReplyProxy$8 = new IPersistenceAReplyProxy$8(this, partitionHandle, n);
        this.proxy.remoteCallMethod((short)52, iPersistenceAReplyProxy$8);
    }

    @Override
    public void endTransactionResult(PartitionHandle partitionHandle, int n) {
        IPersistenceAReplyProxy$9 iPersistenceAReplyProxy$9 = new IPersistenceAReplyProxy$9(this, partitionHandle, n);
        this.proxy.remoteCallMethod((short)57, iPersistenceAReplyProxy$9);
    }

    @Override
    public void flushResult(PartitionHandle partitionHandle, int n) {
        IPersistenceAReplyProxy$10 iPersistenceAReplyProxy$10 = new IPersistenceAReplyProxy$10(this, partitionHandle, n);
        this.proxy.remoteCallMethod((short)59, iPersistenceAReplyProxy$10);
    }

    @Override
    public void existsResult(PartitionHandle partitionHandle, long l, int n) {
        IPersistenceAReplyProxy$11 iPersistenceAReplyProxy$11 = new IPersistenceAReplyProxy$11(this, partitionHandle, l, n);
        this.proxy.remoteCallMethod((short)58, iPersistenceAReplyProxy$11);
    }

    @Override
    public void removeResult(PartitionHandle partitionHandle, long l, int n) {
        IPersistenceAReplyProxy$12 iPersistenceAReplyProxy$12 = new IPersistenceAReplyProxy$12(this, partitionHandle, l, n);
        this.proxy.remoteCallMethod((short)77, iPersistenceAReplyProxy$12);
    }

    @Override
    public void getIntResult(PartitionHandle partitionHandle, long l, long l2, int n) {
        IPersistenceAReplyProxy$13 iPersistenceAReplyProxy$13 = new IPersistenceAReplyProxy$13(this, partitionHandle, l, l2, n);
        this.proxy.remoteCallMethod((short)65, iPersistenceAReplyProxy$13);
    }

    @Override
    public void getIntsResult(PartitionHandle partitionHandle, long[] lArray, long[] lArray2, int[] nArray) {
        IPersistenceAReplyProxy$14 iPersistenceAReplyProxy$14 = new IPersistenceAReplyProxy$14(this, partitionHandle, lArray, lArray2, nArray);
        this.proxy.remoteCallMethod((short)67, iPersistenceAReplyProxy$14);
    }

    @Override
    public void getStringResult(PartitionHandle partitionHandle, long l, String string, int n) {
        IPersistenceAReplyProxy$15 iPersistenceAReplyProxy$15 = new IPersistenceAReplyProxy$15(this, partitionHandle, l, string, n);
        this.proxy.remoteCallMethod((short)69, iPersistenceAReplyProxy$15);
    }

    @Override
    public void getStringsResult(PartitionHandle partitionHandle, long[] lArray, String[] stringArray, int[] nArray) {
        IPersistenceAReplyProxy$16 iPersistenceAReplyProxy$16 = new IPersistenceAReplyProxy$16(this, partitionHandle, lArray, stringArray, nArray);
        this.proxy.remoteCallMethod((short)71, iPersistenceAReplyProxy$16);
    }

    @Override
    public void getBlobResult(PartitionHandle partitionHandle, long l, short[] sArray, int n) {
        IPersistenceAReplyProxy$17 iPersistenceAReplyProxy$17 = new IPersistenceAReplyProxy$17(this, partitionHandle, l, sArray, n);
        this.proxy.remoteCallMethod((short)61, iPersistenceAReplyProxy$17);
    }

    @Override
    public void getBlobsResult(PartitionHandle partitionHandle, long[] lArray, short[][] sArray, int[] nArray) {
        IPersistenceAReplyProxy$18 iPersistenceAReplyProxy$18 = new IPersistenceAReplyProxy$18(this, partitionHandle, lArray, sArray, nArray);
        this.proxy.remoteCallMethod((short)63, iPersistenceAReplyProxy$18);
    }

    @Override
    public void setResult(PartitionHandle partitionHandle, long l, int n) {
        IPersistenceAReplyProxy$19 iPersistenceAReplyProxy$19 = new IPersistenceAReplyProxy$19(this, partitionHandle, l, n);
        this.proxy.remoteCallMethod((short)78, iPersistenceAReplyProxy$19);
    }

    @Override
    public void unsubscribeResult(PartitionHandle partitionHandle, long[] lArray, int[] nArray) {
        IPersistenceAReplyProxy$20 iPersistenceAReplyProxy$20 = new IPersistenceAReplyProxy$20(this, partitionHandle, lArray, nArray);
        this.proxy.remoteCallMethod((short)81, iPersistenceAReplyProxy$20);
    }

    @Override
    public void stringValues(PartitionHandle partitionHandle, long[] lArray, String[] stringArray, int[] nArray) {
        IPersistenceAReplyProxy$21 iPersistenceAReplyProxy$21 = new IPersistenceAReplyProxy$21(this, partitionHandle, lArray, stringArray, nArray);
        this.proxy.remoteCallMethod((short)79, iPersistenceAReplyProxy$21);
    }

    @Override
    public void intValues(PartitionHandle partitionHandle, long[] lArray, long[] lArray2, int[] nArray) {
        IPersistenceAReplyProxy$22 iPersistenceAReplyProxy$22 = new IPersistenceAReplyProxy$22(this, partitionHandle, lArray, lArray2, nArray);
        this.proxy.remoteCallMethod((short)72, iPersistenceAReplyProxy$22);
    }

    @Override
    public void blobValues(PartitionHandle partitionHandle, long[] lArray, short[][] sArray, int[] nArray) {
        IPersistenceAReplyProxy$23 iPersistenceAReplyProxy$23 = new IPersistenceAReplyProxy$23(this, partitionHandle, lArray, sArray, nArray);
        this.proxy.remoteCallMethod((short)53, iPersistenceAReplyProxy$23);
    }

    @Override
    public void convertResult(long l, String string, String string2, PartitionHandle partitionHandle, int n) {
        IPersistenceAReplyProxy$24 iPersistenceAReplyProxy$24 = new IPersistenceAReplyProxy$24(this, l, string, string2, partitionHandle, n);
        this.proxy.remoteCallMethod((short)56, iPersistenceAReplyProxy$24);
    }

    @Override
    public void convertResult(String string, String string2, String string3, PartitionHandle partitionHandle, int n) {
        IPersistenceAReplyProxy$25 iPersistenceAReplyProxy$25 = new IPersistenceAReplyProxy$25(this, string, string2, string3, partitionHandle, n);
        this.proxy.remoteCallMethod((short)55, iPersistenceAReplyProxy$25);
    }
}

