/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.asl.clientapi.impl;

import de.vw.mib.asl.clientapi.ASLClientAPIResources;
import de.vw.mib.asl.clientapi.ASLClientAPIResponse;
import de.vw.mib.asl.clientapi.impl.ASLClientAPIBridge$RequestsBridgeBase$ASLSwitch;
import de.vw.mib.asl.clientapi.impl.ASLClientAPIBridge$RequestsBridgeBase$Invocation;
import de.vw.mib.asl.clientapi.impl.ASLClientAPIBridge$RequestsBridgeBase$Queue;
import de.vw.mib.asl.clientapi.impl.ASLClientAPIBridge$RequestsBridgeBase$ResourcesBridge;
import de.vw.mib.asl.clientapi.impl.ASLClientAPIBridge$RequestsBridgeBase$ResponseProxyBase;
import de.vw.mib.asl.clientapi.impl.ASLClientAPIBridge$Services;
import de.vw.mib.asl.clientapi.impl.Clock;
import de.vw.mib.asl.clientapi.impl.ClockConsumer;
import de.vw.mib.asl.clientapi.impl.Util;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.longs.LongObjectMap;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import de.vw.mib.log4mib.ClassifiedLogger;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.threads.MIBInvoker;
import de.vw.mib.util.Boxing;
import java.util.BitSet;

public abstract class ASLClientAPIBridge$RequestsBridgeBase
implements ClockConsumer {
    protected static final int ONBLOCKED_ENQUEUE;
    protected static final int ONBLOCKED_REJECT;
    protected static final int ONBLOCKED_DROP;
    protected static final int ONFULL_REJECT;
    protected static final int ONFULL_REMOVEFIRST;
    protected static final int ONFULL_REMOVELAST;
    protected static final BitSet EMPTY_BITSET;
    private static final int MAX_SINGLEBIT_BITSET;
    private static final BitSet[] SINGLEBIT_BITSET;
    private final ClassifiedLogger clogger;
    private final ASLClientAPIResources resourcesBridge;
    private final MIBInvoker aslInvoker;
    private final Clock clock;
    private final IntObjectMap requiredResources = new IntObjectOptHashMap();
    private final BitSet lockedResources = new BitSet();
    private final BitSet explicitlyLockedResources = new BitSet();
    private final LongObjectMap runningRequests = new LongObjectOptHashMap();
    private final ASLClientAPIBridge$RequestsBridgeBase$Queue queue;

    protected static BitSet _getSingleBitBitSet(int n) {
        BitSet bitSet;
        if (n < 16) {
            bitSet = SINGLEBIT_BITSET[n];
            if (null == bitSet) {
                bitSet = new BitSet();
                bitSet.set(n);
                ASLClientAPIBridge$RequestsBridgeBase.SINGLEBIT_BITSET[n] = bitSet;
            }
        } else {
            bitSet = new BitSet();
            bitSet.set(n);
        }
        return bitSet;
    }

    protected ASLClientAPIBridge$RequestsBridgeBase(ASLClientAPIBridge$Services aSLClientAPIBridge$Services) {
        this.resourcesBridge = new ASLClientAPIBridge$RequestsBridgeBase$ResourcesBridge(this);
        this.clogger = aSLClientAPIBridge$Services.getClassifiedLogger();
        this.aslInvoker = aSLClientAPIBridge$Services.getASLInvoker();
        this.queue = new ASLClientAPIBridge$RequestsBridgeBase$Queue(this._getMaxQueueSize());
        this.clock = aSLClientAPIBridge$Services.getClock();
        this.clock.addConsumer(this);
    }

    @Override
    public void onClock(Clock clock) {
        this._flushTimeout(clock.getInterval());
    }

    protected abstract BitSet _createRequiredResources(int n) {
    }

    protected abstract ASLClientAPIBridge$RequestsBridgeBase$ResponseProxyBase _createResponseProxy(long l, ASLClientAPIResponse aSLClientAPIResponse) {
    }

    protected abstract String _getAPIName() {
    }

    protected abstract int _getMaxQueueEntries(int n) {
    }

    protected abstract int _getMaxQueueSize() {
    }

    protected abstract int _getOnBlocked(int n) {
    }

    protected abstract int _getOnFull(int n) {
    }

    protected abstract String _getRequestName(int n) {
    }

    protected abstract int _getTTL(int n) {
    }

    protected abstract void _invoke(ASLClientAPIResponse aSLClientAPIResponse, int n, Object[] objectArray) {
    }

    protected BitSet _getRequiredResources(int n) {
        BitSet bitSet = (BitSet)this.requiredResources.get(n);
        if (null == bitSet) {
            bitSet = this._createRequiredResources(n);
            this.requiredResources.put(n, bitSet);
        }
        return bitSet;
    }

    protected ASLClientAPIResources _getResourcesBridge() {
        return this.resourcesBridge;
    }

    protected void _invokeLater(ASLClientAPIResponse aSLClientAPIResponse, int n, Object[] objectArray) {
        ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation = ASLClientAPIBridge$RequestsBridgeBase$Invocation.create(aSLClientAPIResponse, n, objectArray);
        this.aslInvoker.invoke(ASLClientAPIBridge$RequestsBridgeBase$ASLSwitch.createInvocation(this, aSLClientAPIBridge$RequestsBridgeBase$Invocation));
    }

    private boolean _isRequestLocked(int n) {
        BitSet bitSet = this._getRequiredResources(n);
        return this.lockedResources.intersects(bitSet);
    }

    boolean _isResourceExplicitlyLocked(int n) {
        return this.explicitlyLockedResources.get(n);
    }

    boolean _isResourceLocked(int n) {
        return this.lockedResources.get(n);
    }

    boolean _setResourceExplicitlyLocked(int n, boolean bl) {
        boolean bl2 = this.explicitlyLockedResources.get(n);
        if (bl2 != bl) {
            this.explicitlyLockedResources.set(n, bl);
            if (bl) {
                this.lockedResources.set(n);
            } else {
                this._updateLockedResources();
            }
        }
        return bl2;
    }

    void _handleInvocation(ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation) {
        int n = aSLClientAPIBridge$RequestsBridgeBase$Invocation.getRequestId();
        if (this._isRequestLocked(n)) {
            int n2 = this._getOnBlocked(n);
            switch (n2) {
                case 0: {
                    this._enqueue(aSLClientAPIBridge$RequestsBridgeBase$Invocation);
                    break;
                }
                case 1: {
                    this._finishedSafe(aSLClientAPIBridge$RequestsBridgeBase$Invocation, 4);
                    aSLClientAPIBridge$RequestsBridgeBase$Invocation.release();
                    break;
                }
                default: {
                    aSLClientAPIBridge$RequestsBridgeBase$Invocation.release();
                    break;
                }
            }
        } else {
            this._invokeNow(aSLClientAPIBridge$RequestsBridgeBase$Invocation);
        }
    }

    private void _enqueue(ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation) {
        int n = aSLClientAPIBridge$RequestsBridgeBase$Invocation.getRequestId();
        int n2 = this._getMaxQueueEntries(n);
        if (0 == n2) {
            this._finishedSafe(aSLClientAPIBridge$RequestsBridgeBase$Invocation, 4);
            aSLClientAPIBridge$RequestsBridgeBase$Invocation.release();
        } else {
            int n3 = 0 < n2 ? this.queue.countEntries(n) : 0;
            if (-1 == n2 || n3 < n2) {
                if (this.queue.isFull()) {
                    this._finishedSafe(aSLClientAPIBridge$RequestsBridgeBase$Invocation, 6);
                    aSLClientAPIBridge$RequestsBridgeBase$Invocation.release();
                } else {
                    this.queue.add(aSLClientAPIBridge$RequestsBridgeBase$Invocation);
                }
            } else {
                int n4 = this._getOnFull(n);
                switch (n4) {
                    case 1: {
                        this.queue.removeFirst(n);
                        this.queue.add(aSLClientAPIBridge$RequestsBridgeBase$Invocation);
                        break;
                    }
                    case 2: {
                        this.queue.removeLast(n);
                        this.queue.add(aSLClientAPIBridge$RequestsBridgeBase$Invocation);
                        break;
                    }
                    default: {
                        this._finishedSafe(aSLClientAPIBridge$RequestsBridgeBase$Invocation, 6);
                        aSLClientAPIBridge$RequestsBridgeBase$Invocation.release();
                    }
                }
            }
        }
    }

    private void _invokeNow(ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation) {
        int n = aSLClientAPIBridge$RequestsBridgeBase$Invocation.getRequestId();
        long l = aSLClientAPIBridge$RequestsBridgeBase$Invocation.getCallId();
        this.lockedResources.or(this._getRequiredResources(n));
        this.runningRequests.put(l, aSLClientAPIBridge$RequestsBridgeBase$Invocation);
        aSLClientAPIBridge$RequestsBridgeBase$Invocation.setTTL(this._getTTL(n) + this.clock.getInterval() / 2);
        ASLClientAPIBridge$RequestsBridgeBase$ResponseProxyBase aSLClientAPIBridge$RequestsBridgeBase$ResponseProxyBase = this._createResponseProxy(l, aSLClientAPIBridge$RequestsBridgeBase$Invocation.getResponse());
        this._invoke(aSLClientAPIBridge$RequestsBridgeBase$ResponseProxyBase, n, aSLClientAPIBridge$RequestsBridgeBase$Invocation.getArguments());
    }

    void _handleResponseFinished(long l, int n) {
        ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation = (ASLClientAPIBridge$RequestsBridgeBase$Invocation)this.runningRequests.remove(l);
        if (null != aSLClientAPIBridge$RequestsBridgeBase$Invocation) {
            BitSet bitSet = this._getRequiredResources(aSLClientAPIBridge$RequestsBridgeBase$Invocation.getRequestId());
            if (!bitSet.isEmpty()) {
                this._updateLockedResources();
            }
            this._finishedSafe(aSLClientAPIBridge$RequestsBridgeBase$Invocation, n);
            aSLClientAPIBridge$RequestsBridgeBase$Invocation.release();
            this.aslInvoker.invoke(ASLClientAPIBridge$RequestsBridgeBase$ASLSwitch.createInvokeNext(this));
        }
    }

    void _invokeNext() {
        ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation = null;
        ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation2 = null;
        for (ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation3 = this.queue.head(); null == aSLClientAPIBridge$RequestsBridgeBase$Invocation2 && null != aSLClientAPIBridge$RequestsBridgeBase$Invocation3; aSLClientAPIBridge$RequestsBridgeBase$Invocation3 = aSLClientAPIBridge$RequestsBridgeBase$Invocation3.getNext()) {
            int n = aSLClientAPIBridge$RequestsBridgeBase$Invocation3.getRequestId();
            if (this._isRequestLocked(n)) {
                aSLClientAPIBridge$RequestsBridgeBase$Invocation = aSLClientAPIBridge$RequestsBridgeBase$Invocation3;
                continue;
            }
            aSLClientAPIBridge$RequestsBridgeBase$Invocation2 = aSLClientAPIBridge$RequestsBridgeBase$Invocation3;
        }
        if (null != aSLClientAPIBridge$RequestsBridgeBase$Invocation2) {
            this.queue.unlink(aSLClientAPIBridge$RequestsBridgeBase$Invocation, aSLClientAPIBridge$RequestsBridgeBase$Invocation2);
            this.aslInvoker.invoke(ASLClientAPIBridge$RequestsBridgeBase$ASLSwitch.createInvokeNext(this));
            this._invokeNow(aSLClientAPIBridge$RequestsBridgeBase$Invocation2);
        }
    }

    private void _updateLockedResources() {
        this.lockedResources.clear();
        this.lockedResources.or(this.explicitlyLockedResources);
        int n = this.runningRequests.size();
        if (0 < n) {
            Object[] objectArray = ASLClientAPIBridge$RequestsBridgeBase.borrowObjectArray(n);
            objectArray = this.runningRequests.valuesToArray(objectArray);
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation = (ASLClientAPIBridge$RequestsBridgeBase$Invocation)objectArray[i2];
                int n2 = aSLClientAPIBridge$RequestsBridgeBase$Invocation.getRequestId();
                this.lockedResources.or(this._getRequiredResources(n2));
            }
            ASLClientAPIBridge$RequestsBridgeBase.release(objectArray);
        }
    }

    private void _flushTimeout(int n) {
        int n2 = this.runningRequests.size();
        if (0 < n2) {
            Object[] objectArray = ASLClientAPIBridge$RequestsBridgeBase.borrowObjectArray(n2);
            objectArray = this.runningRequests.valuesToArray(objectArray);
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation = (ASLClientAPIBridge$RequestsBridgeBase$Invocation)objectArray[i2];
                if (!aSLClientAPIBridge$RequestsBridgeBase$Invocation.decreaseTTL(n)) continue;
                this.runningRequests.remove(aSLClientAPIBridge$RequestsBridgeBase$Invocation.getCallId());
                this._finishedSafe(aSLClientAPIBridge$RequestsBridgeBase$Invocation, 5);
                aSLClientAPIBridge$RequestsBridgeBase$Invocation.release();
            }
            ASLClientAPIBridge$RequestsBridgeBase.release(objectArray);
        }
    }

    private void _finishedSafe(ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation, int n) {
        try {
            aSLClientAPIBridge$RequestsBridgeBase$Invocation.getResponse()._finished(n);
        }
        catch (Exception exception) {
            LogMessage logMessage = this.clogger.error();
            logMessage.append("Error sending request _finish");
            this._appendInvocation(logMessage, aSLClientAPIBridge$RequestsBridgeBase$Invocation, true).attachThrowable(exception).log();
        }
    }

    private LogMessage _appendInvocation(LogMessage logMessage, ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation, boolean bl) {
        if (bl) {
            logMessage.append(", ");
        }
        logMessage.append("request=").append(this._getAPIName()).append(".").append(this._getRequestName(aSLClientAPIBridge$RequestsBridgeBase$Invocation.getRequestId()));
        logMessage.append("callId=").append(aSLClientAPIBridge$RequestsBridgeBase$Invocation.getCallId());
        return logMessage;
    }

    protected static Object[] borrowObjectArray(int n) {
        return Util.borrowObjectArray(n);
    }

    protected static void release(Object[] objectArray) {
        Util.release(objectArray);
    }

    protected static Boolean box(boolean bl) {
        return bl;
    }

    protected static boolean unboxBoolean(Object object) {
        return (Boolean)object;
    }

    protected static Byte box(byte by) {
        return Boxing.box(by);
    }

    protected static byte unboxByte(Object object) {
        return (Byte)object;
    }

    protected static Character box(char c2) {
        return Boxing.box(c2);
    }

    protected static char unboxChar(Object object) {
        return ((Character)object).charValue();
    }

    protected static Double box(double d2) {
        return Boxing.box(d2);
    }

    protected static double unboxDouble(Object object) {
        return (Double)object;
    }

    protected static Float box(float f2) {
        return Boxing.box(f2);
    }

    protected static float unboxFloat(Object object) {
        return ((Float)object).floatValue();
    }

    protected static Integer box(int n) {
        return Boxing.box(n);
    }

    protected static int unboxInt(Object object) {
        return (Integer)object;
    }

    protected static Long box(long l) {
        return Boxing.box(l);
    }

    protected static long unboxLong(Object object) {
        return (Long)object;
    }

    protected static Short box(short s) {
        return Boxing.box(s);
    }

    protected static short unboxShort(Object object) {
        return (Short)object;
    }

    static {
        EMPTY_BITSET = new BitSet();
        SINGLEBIT_BITSET = new BitSet[16];
    }
}

