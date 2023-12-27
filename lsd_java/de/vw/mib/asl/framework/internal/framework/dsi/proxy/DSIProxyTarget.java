/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.proxy;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyInterceptor;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIProxyException;
import de.vw.mib.asl.framework.internal.framework.dsi.ext.api.ComplexAnalyzer;
import de.vw.mib.asl.framework.internal.framework.dsi.proxy.InvocationItem;
import de.vw.mib.asl.framework.internal.framework.dsi.proxy.NotificationDatapool;
import de.vw.mib.asl.framework.internal.framework.dsi.skeleton.DSISkeletonTarget;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Cfg$C;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Cfg$PT;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Cfg$U;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Constants;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Utils;
import de.vw.mib.collections.ObjectObjectMap;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.pool.PoorMansPool;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import org.dsi.ifc.base.DSIListener;

public final class DSIProxyTarget
extends AbstractASLTarget {
    private static final Object[] EMPTY_ARRAY = new Object[0];
    private static final int PROXY_QUEUE_WARN_ITEMS_COUNT;
    private final DSISkeletonTarget skeletonTarget;
    private final CowArray serviceStateListeners = new CowArray();
    private final CowArray[] specificServiceStateListeners = new CowArray[176];
    private final CowArray[] serviceInterceptors = new CowArray[176];
    private final IntObjectMap[] targetResponseListeners = new IntObjectMap[176];
    private final BitSet registeredDSIServices = new BitSet();
    private final InvocationItem[] invocationQueue = new InvocationItem[176];
    private Thread aslThread;
    private static final int EV_SERVICE_REGISTERED;
    private static final int PARAM_SERVICE_REGISTERED__TYPE_IDX;
    private static final int PARAM_SERVICE_REGISTERED__INST_ID;
    private static final int EV_SERVICE_UNREGISTERED;
    private static final int PARAM_SERVICE_UNREGISTERED__TYPE_IDX;
    private static final int PARAM_SERVICE_UNREGISTERED__INST_ID;
    private static final int EV_NOTIFICATION_INVOCATION;
    private static final int PARAM_NOTIFICATION_INVOCATION__TYPE_IDX;
    private static final int PARAM_NOTIFICATION_INVOCATION__INST_ID;
    private static final int PARAM_NOTIFICATION_INVOCATION__METHOD_ID;
    private static final int PARAM_NOTIFICATION_INVOCATION__ARGS;
    private static final int EV_RESPONSE_INVOCATION;
    private static final int PARAM_RESPONSE_INVOCATION__TYPE_IDX;
    private static final int PARAM_RESPONSE_INVOCATION__INST_ID;
    private static final int PARAM_RESPONSE_INVOCATION__METHOD_ID;
    private static final int PARAM_RESPONSE_INVOCATION__ARGS;
    private static final int EV_NOTIFICATION_TRIGGER;
    private static final int PARAM_NOTIFICATION_TRIGGER__TYPE_IDX;
    private static final int PARAM_NOTIFICATION_TRIGGER__INST_ID;
    private static final int PARAM_NOTIFICATION_TRIGGER__LISTENER;
    private static final int PARAM_NOTIFICATION_TRIGGER__ATTRS;
    private static final int EV_CHECK_REQUEST_TIMEOUTS;
    private static final long REQUEST_TIMEOUT_PERIOD;
    private static final String SET_NOTIFICATION_NAME;
    private static final String CLEAR_NOTIFICATION_NAME;
    private static final Class[] PARAMS_NOTIF_ALL;
    private static final Class[] PARAMS_NOTIF_ONE;
    private static final Class[] PARAMS_NOTIF_SOME;
    private boolean handleInvokeInvokedFlag = false;
    private int handleInvokeServiceTypeIdx;
    private int handleInvokeInstanceId;
    private Method handleInvokeMethod;
    private final BitSet[] skeletonNotificationMasks = new BitSet[176];
    private final ObjectObjectMap[] listenerNotificationMasks = new ObjectObjectMap[176];
    private static final int ASYNC_EXC_P_RT_POS;
    private static final String TIMEOUT_MESSAGE;
    private final IntSet timedOutRequestIdxs = new IntOptHashSet();
    private final ComplexAnalyzer[] SYNC_CMP_ANALYZER_PROXY_MX = new ComplexAnalyzer[176];
    private final IntSet[] unexpectedResponsesPassingSets = new IntOptHashSet[176];
    private final IntObjectMap[] SYNC_SEQ_TRACKERS = new IntObjectMap[176];
    private static final int SYNC_SEQ_TRACKER_COUNT_SLOT;
    private static final int ARRAYLIST_POOL_MAX_ELEMENTS;
    private static final PoorMansPool ARRAYLIST_POOL;
    private static final int ARRAYLIST_POOL_ELEMENT_SIZE;
    private static final int BITSET_POOL_MAX;
    private static final PoorMansPool BITSET_POOL;
    private static final int INVOCATION_POOL_MAX;
    private static final PoorMansPool INVOCATION_POOL;
    private static final int OBJECT_BLOCK_SIZE;
    private static final int OBJECT_BLOCK_MASK;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class array$I;
    static /* synthetic */ Class class$java$lang$Integer;

    public static EventGeneric createServiceRegisteredEvent(int n, int n2) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverTargetId(560271616);
        eventGeneric.setReceiverEventId(-1585053440);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        return eventGeneric;
    }

    public static EventGeneric createServiceUnregisteredEvent(int n, int n2) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverTargetId(560271616);
        eventGeneric.setReceiverEventId(-1568276224);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        return eventGeneric;
    }

    public static EventGeneric createNotificationInvocationEvent(int n, int n2, int n3, Object[] objectArray) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverTargetId(560271616);
        eventGeneric.setReceiverEventId(-1551499008);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setInt(2, n3);
        eventGeneric.setObject(3, objectArray);
        return eventGeneric;
    }

    public static EventGeneric createResponseInvocationEvent(int n, int n2, int n3, Object[] objectArray) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverTargetId(560271616);
        eventGeneric.setReceiverEventId(-1534721792);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setInt(2, n3);
        eventGeneric.setObject(3, objectArray);
        return eventGeneric;
    }

    public DSIProxyTarget(DSISkeletonTarget dSISkeletonTarget) {
        super(dSISkeletonTarget.getMainObject(), 560271616, "hsmtask");
        this.skeletonTarget = dSISkeletonTarget;
        this.startTimer(-1501167360, (long)0, true);
        if (this.getEventDispatcher().getTask("hsmtask").isInCurrentMIBThread()) {
            this.aslThread = Thread.currentThread();
        }
    }

    public void startPeer() {
    }

    public void addServiceStateListener(DSIServiceStateListener dSIServiceStateListener) {
        this.serviceStateListeners.addIfNotAlreadyIn(dSIServiceStateListener);
        for (int i2 = 0; i2 < RuntimeGeneratedConstants.SERVICE_TS_NS.length; ++i2) {
            for (int i3 = 0; i3 < RuntimeGeneratedConstants.INST_NMBS[i2]; ++i3) {
                if (!this.registeredDSIServices.get(Utils.getInstDepObjIdx(i2, i3))) continue;
                dSIServiceStateListener.registered(RuntimeGeneratedConstants.SERVICE_TS_NS[i2], i3);
            }
        }
    }

    public void addServiceStateListener(int n, int n2, DSIServiceStateListener dSIServiceStateListener) {
        int n3 = Utils.getInstDepObjIdx(n, n2);
        DSIProxyTarget.addIndexedCowArrayObject(this.specificServiceStateListeners, n3, dSIServiceStateListener);
        if (this.registeredDSIServices.get(n3)) {
            dSIServiceStateListener.registered(RuntimeGeneratedConstants.SERVICE_TS_NS[n], n2);
        }
    }

    public void removeServiceStateListener(DSIServiceStateListener dSIServiceStateListener) {
        this.serviceStateListeners.remove(dSIServiceStateListener);
    }

    public void removeServiceStateListener(int n, int n2, DSIServiceStateListener dSIServiceStateListener) {
        int n3 = Utils.getInstDepObjIdx(n, n2);
        DSIProxyTarget.removeIndexedCowArrayObject(this.specificServiceStateListeners, n3, dSIServiceStateListener);
    }

    public void addServiceInterceptor(int n, int n2, DSIProxyInterceptor dSIProxyInterceptor) {
        int n3 = Utils.getInstDepObjIdx(n, n2);
        DSIProxyTarget.addIndexedCowArrayObject(this.serviceInterceptors, n3, dSIProxyInterceptor);
    }

    public void removeServiceInterceptor(int n, int n2, DSIProxyInterceptor dSIProxyInterceptor) {
        int n3 = Utils.getInstDepObjIdx(n, n2);
        DSIProxyTarget.removeIndexedCowArrayObject(this.serviceInterceptors, n3, dSIProxyInterceptor);
    }

    public void addResponseListener(int n, int n2, int n3, DSIListener dSIListener) {
        int n4 = Utils.getInstDepObjIdx(n, n2);
        DSIProxyTarget.addTargetMapCowArrayObject(this.targetResponseListeners, n4, n3, dSIListener);
    }

    public void removeResponseListener(int n, int n2, int n3, DSIListener dSIListener) {
        int n4 = Utils.getInstDepObjIdx(n, n2);
        DSIProxyTarget.removeTargetMapCowArrayObject(this.targetResponseListeners, n4, n3, dSIListener);
    }

    private static void addIndexedCowArrayObject(CowArray[] cowArrayArray, int n, Object object) {
        CowArray cowArray = cowArrayArray[n];
        if (null == cowArray) {
            cowArrayArray[n] = cowArray = new CowArray();
        }
        cowArray.addIfNotAlreadyIn(object);
    }

    private static void removeIndexedCowArrayObject(CowArray[] cowArrayArray, int n, Object object) {
        CowArray cowArray = cowArrayArray[n];
        if (null != cowArray) {
            cowArray.remove(object);
        }
    }

    private static void addTargetMapCowArrayObject(IntObjectMap[] intObjectMapArray, int n, int n2, Object object) {
        CowArray cowArray;
        IntObjectMap intObjectMap = intObjectMapArray[n];
        if (null == intObjectMap) {
            intObjectMapArray[n] = intObjectMap = new IntObjectOptHashMap();
        }
        if (null == (cowArray = (CowArray)intObjectMap.get(n2))) {
            cowArray = new CowArray();
            intObjectMap.put(n2, cowArray);
        }
        cowArray.addIfNotAlreadyIn(object);
    }

    private static void removeTargetMapCowArrayObject(IntObjectMap[] intObjectMapArray, int n, int n2, Object object) {
        CowArray cowArray;
        IntObjectMap intObjectMap = intObjectMapArray[n];
        if (null != intObjectMap && null != (cowArray = (CowArray)intObjectMap.get(n2))) {
            cowArray.remove(object);
        }
    }

    private Object[] getSpecificServiceStateListeners(int n) {
        CowArray cowArray = this.specificServiceStateListeners[n];
        return null != cowArray ? cowArray.getArray() : EMPTY_ARRAY;
    }

    private Object[] getServiceInterceptors(int n) {
        CowArray cowArray = this.serviceInterceptors[n];
        return null != cowArray ? cowArray.getArray() : EMPTY_ARRAY;
    }

    private void getTargetResponseListeners(ArrayList arrayList, int n, int n2) {
        IntObjectMap intObjectMap = this.targetResponseListeners[n];
        if (null != intObjectMap && !intObjectMap.isEmpty()) {
            if (-2 == n2) {
                CowArray cowArray;
                Object[] objectArray = intObjectMap.valuesToArray(DSIProxyTarget.borrowObjectBlock(intObjectMap.size()));
                for (int i2 = 0; i2 < objectArray.length && null != (cowArray = (CowArray)objectArray[i2]); ++i2) {
                    DSIProxyTarget.addAll(arrayList, cowArray);
                }
                DSIProxyTarget.release(objectArray);
            } else {
                DSIProxyTarget.addAll(arrayList, (CowArray)intObjectMap.get(n2));
            }
        }
    }

    private static void addAll(List list, CowArray cowArray) {
        if (null != cowArray) {
            Object[] objectArray = cowArray.getArray();
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                list.add(objectArray[i2]);
            }
        }
    }

    public boolean clearPendingResponses(int n, int n2, String string) {
        int n3;
        int n4;
        boolean bl = false;
        int n5 = Utils.getInstDepObjIdx(n, n2);
        IntObjectMap intObjectMap = Constants.PROXY_PENDIG_CS[n5];
        if (null != intObjectMap && !intObjectMap.isEmpty() && 0 <= (n4 = Cfg$PT.getSyncRequestIndex(n, n3 = ServiceManager.reflectionFactory.getServicesMmao(n).getIndex(RuntimeGeneratedConstants.SERVICE_TS_NS[n], string)))) {
            int n6;
            int[] nArray = Cfg$PT.getSyncResponses(n, n4);
            byte by = Cfg$PT.getRequestType(n, n3);
            ArrayList arrayList = DSIProxyTarget.borrowArrayList();
            switch (by) {
                case 2: 
                case 4: 
                case 5: {
                    for (n6 = 0; n6 < nArray.length; ++n6) {
                        InvocationItem invocationItem = (InvocationItem)intObjectMap.remove(nArray[n6]);
                        if (invocationItem == null) continue;
                        arrayList.add(invocationItem);
                    }
                    break;
                }
                case 3: {
                    int[] nArray2 = this.getSyncSequenceTrack(n, n2, n3);
                    for (int i2 = 0; i2 < nArray.length; ++i2) {
                        InvocationItem invocationItem;
                        if (DSIProxyTarget.isSequenceResponseArrived(nArray[i2], nArray2) || (invocationItem = (InvocationItem)intObjectMap.remove(nArray[i2])) == null) continue;
                        arrayList.add(invocationItem);
                    }
                    this.resetSyncSequenceTrack(n, n2, n3);
                    break;
                }
                default: {
                    LogMessage logMessage = this.fatal().append("The method ");
                    Utils.appendInstanceMethod(logMessage, RuntimeGeneratedConstants.SERVICE_TS_NS[n], n2, string);
                    logMessage.append(" cannot be assigned to one specific sync case.").log();
                }
            }
            n6 = arrayList.size();
            boolean bl2 = bl = 0 < n6;
            if (bl) {
                LogMessage logMessage = this.warn().append("Removed ");
                for (int i3 = 0; i3 < n6; ++i3) {
                    InvocationItem invocationItem = (InvocationItem)arrayList.get(i3);
                    if (0 != i3) {
                        logMessage.append(", ");
                    }
                    logMessage.append("\"").append(Cfg$U.getListenerSyncMethodName(n, n4, invocationItem.syncRespIdx)).append("\"");
                    DSIProxyTarget.release(invocationItem);
                }
                logMessage.append(" from pending responses queue of ");
                Utils.appendInstance(logMessage, RuntimeGeneratedConstants.SERVICE_TS_NS[n], n2);
                logMessage.log();
                this.callQueue(n, n2);
            }
            DSIProxyTarget.release(arrayList);
        }
        return bl;
    }

    public boolean clearWaitingRequests(int n, int n2, String string) {
        boolean bl = false;
        int n3 = Utils.getInstDepObjIdx(n, n2);
        InvocationItem invocationItem = this.invocationQueue[n3];
        if (invocationItem != null) {
            String string2 = RuntimeGeneratedConstants.SERVICE_TS_NS[n];
            int n4 = ServiceManager.reflectionFactory.getServicesMmao(n).getIndex(string2, string);
            int n5 = Cfg$PT.getSyncRequestIndex(n, n4);
            InvocationItem invocationItem2 = null;
            InvocationItem invocationItem3 = null;
            while (invocationItem != null) {
                if (invocationItem.syncReqIdx == n5) {
                    Object object;
                    bl = true;
                    if (this.isTraceEnabled()) {
                        object = this.trace().append("Removed request from waiting queue: ");
                        Utils.appendInstanceMethod((LogMessage)object, string2, n2, string);
                        Utils.appendArgs((LogMessage)object, invocationItem.args);
                        object.log();
                    }
                    object = invocationItem;
                    invocationItem = invocationItem.next;
                    DSIProxyTarget.release((InvocationItem)object);
                    continue;
                }
                if (null != invocationItem3) {
                    invocationItem3.next = invocationItem;
                    invocationItem3 = invocationItem;
                    invocationItem = invocationItem.next;
                    continue;
                }
                invocationItem2 = invocationItem3 = invocationItem;
                invocationItem = invocationItem.next;
            }
            if (null != invocationItem3) {
                invocationItem3.next = null;
            }
            this.invocationQueue[n3] = invocationItem2;
        }
        return bl;
    }

    public void setUnexpectedResponsePassing(int n, int n2, String string, boolean bl) {
        if (!Cfg$PT.isNonSyncService(n)) {
            String string2 = RuntimeGeneratedConstants.SERVICE_TS_NS[n];
            int n3 = ServiceManager.reflectionFactory.getServicesMmao(n).getIndex(string2, string);
            int n4 = Cfg$PT.getSyncRequestIndex(n, n3);
            if (0 <= n4) {
                int[] nArray = Cfg$PT.getSyncResponses(n, n4);
                LogMessage logMessage = this.warn().append(bl ? "Enabled" : "Disabled").append(" passing of unexpected responses for ");
                Utils.appendInstanceMethod(logMessage, string2, n2, string).append(": { ");
                IntSet intSet = this.accessUnexpectedResponsePassingSet(n, n2);
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    if (0 < i2) {
                        logMessage.append(", ");
                    }
                    logMessage.append("\"").append(Cfg$U.getListenerSyncMethodName(n, n4, i2)).append("\"");
                    if (bl) {
                        intSet.add(nArray[i2]);
                        continue;
                    }
                    intSet.remove(nArray[i2]);
                }
                logMessage.append(" }").log();
            }
        }
    }

    @Override
    public int getClassifier() {
        return 0x1008000;
    }

    @Override
    public int getSubClassifier() {
        return 8;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 100001: {
                this.onServiceRegistered(eventGeneric);
                break;
            }
            case 100002: {
                this.onServiceUnregistered(eventGeneric);
                break;
            }
            case 100003: {
                this.onNotificationInvocation(eventGeneric);
                break;
            }
            case 100004: {
                this.onResponseInvocation(eventGeneric);
                break;
            }
            case 100006: {
                this.onCheckRequestTimeouts();
                break;
            }
            case 100005: {
                this.onNotificationDatapoolTrigger(eventGeneric);
                break;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void handlerInvoke(int n, int n2, int n3, Method method, int n4, Object[] objectArray) {
        try {
            StringBuffer stringBuffer;
            if (null == method) {
                throw new NullPointerException("method");
            }
            if (null == this.aslThread && this.getEventDispatcher().getTask("hsmtask").isInCurrentMIBThread()) {
                this.aslThread = Thread.currentThread();
            }
            if (null != this.aslThread && this.aslThread != Thread.currentThread()) {
                stringBuffer = new StringBuffer();
                stringBuffer.append("Invocation of DSIProxy in wrong thread! ");
                Utils.appendInstanceMethod(stringBuffer, RuntimeGeneratedConstants.SERVICE_TS_NS[n], n2, method.getName());
                stringBuffer.append(". Execution will continue ...");
                this.error(new DSIProxyException(stringBuffer.toString()));
            } else if (this.handleInvokeInvokedFlag) {
                stringBuffer = new StringBuffer();
                stringBuffer.append("Multiple invocation of 'handlerInvoke' method. This call: ");
                Utils.appendInstanceMethod(stringBuffer, RuntimeGeneratedConstants.SERVICE_TS_NS[n], n2, method.getName());
                stringBuffer.append(". Running call: ");
                Utils.appendInstanceMethod(stringBuffer, RuntimeGeneratedConstants.SERVICE_TS_NS[this.handleInvokeServiceTypeIdx], this.handleInvokeInstanceId, this.handleInvokeMethod.getName());
                stringBuffer.append(". Execution will continue ...");
                this.error(new DSIProxyException(stringBuffer.toString()));
            } else {
                this.handleInvokeServiceTypeIdx = n;
                this.handleInvokeInstanceId = n2;
                this.handleInvokeMethod = method;
                this.handleInvokeInvokedFlag = true;
            }
            int n5 = Utils.getInstDepObjIdx(n, n2);
            String string = RuntimeGeneratedConstants.SERVICE_TS_NS[n];
            if (!this.registeredDSIServices.get(n5)) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("The DSI service instance is not available: ");
                Utils.appendInstanceMethod(stringBuffer2, string, n2, method.getName());
                this.error(new DSIProxyException(stringBuffer2.toString()));
            } else {
                String string2 = method.getName().intern();
                if (n4 == -1) {
                    n4 = ServiceManager.reflectionFactory.getServicesMmao(n).getIndex(string, string2, method.getParameterTypes());
                }
                Utils.putRuntimeServiceMethodName(n, n4, string2);
                int n6 = Cfg$PT.getSyncRequestIndex(n, n4);
                if (string2 == SET_NOTIFICATION_NAME || string2 == CLEAR_NOTIFICATION_NAME) {
                    this.handleChangeNotification(n, n2, n3, string2, n4, objectArray);
                } else if (n6 < 0) {
                    this.handleNonSyncInvoke(n, n2, n3, string2, n4, objectArray);
                } else {
                    this.handleSyncInvoke(n, n2, n3, n4, n6, objectArray);
                }
            }
        }
        finally {
            this.handleInvokeInvokedFlag = false;
            DSIProxyTarget.release(objectArray);
        }
    }

    private void handleNonSyncInvoke(int n, int n2, int n3, String string, int n4, Object[] objectArray) {
        this.invokeService(n3, n4, n, n2, objectArray);
    }

    private void handleSyncInvoke(int n, int n2, int n3, int n4, int n5, Object[] objectArray) {
        int[] nArray;
        int n6 = Utils.getInstDepObjIdx(n, n2);
        if (!DSIProxyTarget.isBlocked(n6, nArray = Cfg$PT.getSyncResponses(n, n5))) {
            long l = Utils.currentTimeMillis();
            DSIProxyTarget.addPending(n6, nArray, n3, n5, l);
            boolean bl = this.invokeService(n3, n4, n, n2, objectArray);
            if (!bl) {
                DSIProxyTarget.removePending(n6, nArray);
            }
        } else {
            InvocationItem invocationItem = DSIProxyTarget.borrowInvocationItem();
            invocationItem.syncReqIdx = n5;
            invocationItem.args = DSIProxyTarget.copy(objectArray);
            invocationItem.targetId = n3;
            InvocationItem invocationItem2 = this.invocationQueue[n6];
            if (null == invocationItem2) {
                this.invocationQueue[n6] = invocationItem;
            } else {
                int n7 = 1;
                while (invocationItem2.next != null) {
                    invocationItem2 = invocationItem2.next;
                    ++n7;
                }
                invocationItem2.next = invocationItem;
                if (n7 >= 15) {
                    LogMessage logMessage = this.warn().append("Request queue for ");
                    Utils.appendInstance(logMessage, RuntimeGeneratedConstants.SERVICE_TS_NS[n], n2);
                    logMessage.append(" contains ").append(n7).append(" waiting entries.").log();
                }
            }
        }
    }

    private void handleChangeNotification(int n, int n2, int n3, String string, int n4, Object[] objectArray) {
        Object[] objectArray2 = SET_NOTIFICATION_NAME == string ? this.prepareSetNotification(n, n2, objectArray) : this.prepareClearNotification(n, n2, objectArray);
        if (null != objectArray2) {
            Class[] classArray = DSIProxyTarget.getNotificationParamTypes(objectArray2);
            n4 = ServiceManager.reflectionFactory.getServicesMmao(n).getIndex(RuntimeGeneratedConstants.SERVICE_TS_NS[n], string, classArray);
            Utils.putRuntimeServiceMethodName(n, n4, string);
            this.invokeService(n3, n4, n, n2, objectArray2);
            DSIProxyTarget.release(objectArray2);
        }
    }

    private static Class[] getNotificationParamTypes(Object[] objectArray) {
        Class[] classArray = null == objectArray || 0 == objectArray.length ? null : (1 == objectArray.length ? PARAMS_NOTIF_ALL : (null != objectArray[0] && (class$java$lang$Integer == null ? (class$java$lang$Integer = DSIProxyTarget.class$("java.lang.Integer")) : class$java$lang$Integer) == objectArray[0].getClass() ? PARAMS_NOTIF_ONE : PARAMS_NOTIF_SOME));
        return classArray;
    }

    private BitSet getSkeletonNotificationMask(int n) {
        BitSet bitSet = this.skeletonNotificationMasks[n];
        if (bitSet == null) {
            this.skeletonNotificationMasks[n] = bitSet = DSIProxyTarget.borrowBitSet();
        }
        return bitSet;
    }

    private void removeSkeletonNotificationMask(int n) {
        BitSet bitSet = this.skeletonNotificationMasks[n];
        if (null != bitSet) {
            DSIProxyTarget.release(bitSet);
            this.skeletonNotificationMasks[n] = null;
        }
    }

    private BitSet getListenerNotificationMask(int n, DSIListener dSIListener, boolean bl) {
        BitSet bitSet = null;
        ObjectObjectMap objectObjectMap = this.listenerNotificationMasks[n];
        if (null == objectObjectMap && bl) {
            this.listenerNotificationMasks[n] = objectObjectMap = new ObjectObjectOptHashMap();
        }
        if (null != objectObjectMap && null == (bitSet = (BitSet)objectObjectMap.get(dSIListener)) && bl) {
            bitSet = DSIProxyTarget.borrowBitSet();
            objectObjectMap.put(dSIListener, bitSet);
        }
        return bitSet;
    }

    private void removeListenerNotificationMasks(int n) {
        ObjectObjectMap objectObjectMap = this.listenerNotificationMasks[n];
        if (null != objectObjectMap && !objectObjectMap.isEmpty()) {
            BitSet bitSet;
            Object[] objectArray = objectObjectMap.valuesToArray(DSIProxyTarget.borrowObjectBlock(objectObjectMap.size()));
            for (int i2 = 0; i2 < objectArray.length && null != (bitSet = (BitSet)objectArray[i2]); ++i2) {
                DSIProxyTarget.release(bitSet);
            }
            DSIProxyTarget.release(objectArray);
            objectObjectMap.clear();
        }
    }

    private void removeListenerNotificationMask(int n, DSIListener dSIListener) {
        ObjectObjectMap objectObjectMap = this.listenerNotificationMasks[n];
        if (null != objectObjectMap) {
            BitSet bitSet = (BitSet)objectObjectMap.remove(dSIListener);
            DSIProxyTarget.release(bitSet);
        }
    }

    private static Object[] bitsToNotificationArgs(BitSet bitSet, DSIListener dSIListener, int[] nArray) {
        Object[] objectArray;
        int n = bitSet.cardinality();
        if (nArray.length == n) {
            objectArray = DSIProxyTarget.borrowObjectArray(1);
        } else {
            objectArray = DSIProxyTarget.borrowObjectArray(2);
            int[] nArray2 = new int[n];
            int n2 = 0;
            int n3 = 0;
            while (0 <= (n2 = bitSet.nextSetBit(n2))) {
                nArray2[n3++] = nArray[n2++];
            }
            objectArray[0] = nArray2;
        }
        objectArray[objectArray.length - 1] = dSIListener;
        return objectArray;
    }

    private static void notificationArgsToBits(BitSet bitSet, Object[] objectArray, int[] nArray) {
        bitSet.clear();
        if (objectArray.length == 1) {
            bitSet.set(0, nArray.length);
        } else if (objectArray[0].getClass() == (class$java$lang$Integer == null ? (class$java$lang$Integer = DSIProxyTarget.class$("java.lang.Integer")) : class$java$lang$Integer)) {
            int n = (Integer)objectArray[0];
            int n2 = Utils.getNotificationAttrIndex(n, nArray);
            bitSet.set(n2);
        } else {
            int[] nArray2 = (int[])objectArray[0];
            for (int i2 = 0; i2 < nArray2.length; ++i2) {
                int n = Utils.getNotificationAttrIndex(nArray2[i2], nArray);
                bitSet.set(n);
            }
        }
    }

    private Object[] prepareClearNotification(int n, int n2, Object[] objectArray) {
        Object[] objectArray2;
        int n3 = Utils.getInstDepObjIdx(n, n2);
        int[] nArray = Cfg$PT.getNotificationAttrs(n);
        DSIListener dSIListener = (DSIListener)objectArray[objectArray.length - 1];
        BitSet bitSet = this.getListenerNotificationMask(n3, dSIListener, false);
        if (null == bitSet) {
            objectArray2 = null;
        } else {
            BitSet bitSet2 = DSIProxyTarget.borrowBitSet();
            DSIProxyTarget.notificationArgsToBits(bitSet2, objectArray, nArray);
            bitSet2.and(bitSet);
            if (bitSet2.isEmpty()) {
                objectArray2 = null;
            } else {
                bitSet.andNot(bitSet2);
                if (bitSet.isEmpty()) {
                    this.removeListenerNotificationMask(n3, dSIListener);
                }
                BitSet bitSet3 = this.getSkeletonNotificationMask(n3);
                this.mergeListenerMasks(bitSet2, n3);
                bitSet2.xor(bitSet3);
                if (bitSet2.isEmpty()) {
                    objectArray2 = null;
                } else {
                    bitSet3.andNot(bitSet2);
                    objectArray2 = DSIProxyTarget.bitsToNotificationArgs(bitSet2, this.skeletonTarget.getNotificationListener(n, n2), nArray);
                    NotificationDatapool.cleanup(n, n2, objectArray2);
                }
            }
            DSIProxyTarget.release(bitSet2);
        }
        return objectArray2;
    }

    private Object[] prepareSetNotification(int n, int n2, Object[] objectArray) {
        Object[] objectArray2;
        int[] nArray = Cfg$PT.getNotificationAttrs(n);
        BitSet bitSet = DSIProxyTarget.borrowBitSet();
        DSIProxyTarget.notificationArgsToBits(bitSet, objectArray, nArray);
        if (bitSet.isEmpty()) {
            objectArray2 = null;
        } else {
            int n3 = Utils.getInstDepObjIdx(n, n2);
            DSIListener dSIListener = (DSIListener)objectArray[objectArray.length - 1];
            this.getListenerNotificationMask(n3, dSIListener, true).or(bitSet);
            BitSet bitSet2 = DSIProxyTarget.borrowBitSet();
            bitSet2.xor(bitSet);
            Object object = this.getSkeletonNotificationMask(n3);
            bitSet2.andNot((BitSet)object);
            if (bitSet2.isEmpty()) {
                objectArray2 = null;
            } else {
                ((BitSet)object).or(bitSet2);
                objectArray2 = DSIProxyTarget.bitsToNotificationArgs(bitSet2, this.skeletonTarget.getNotificationListener(n, n2), nArray);
            }
            DSIProxyTarget.release(bitSet2);
            bitSet2 = DSIProxyTarget.borrowBitSet();
            NotificationDatapool.getAvailable(bitSet2, n, n2);
            bitSet2.and(bitSet);
            if (bitSet2.isEmpty()) {
                DSIProxyTarget.release(bitSet2);
            } else {
                object = ServiceManager.mGenericEventFactory.newEvent();
                ((EventGeneric)object).setInt(0, n);
                ((EventGeneric)object).setInt(1, n2);
                ((EventGeneric)object).setObject(2, dSIListener);
                ((EventGeneric)object).setObject(3, bitSet2);
                this.triggerMe((EventGeneric)object, -1517944576);
            }
        }
        DSIProxyTarget.release(bitSet);
        return objectArray2;
    }

    private void mergeListenerMasks(BitSet bitSet, int n) {
        bitSet.clear();
        ObjectObjectMap objectObjectMap = this.listenerNotificationMasks[n];
        if (null != objectObjectMap && 0 < objectObjectMap.size()) {
            BitSet[] bitSetArray = (BitSet[])objectObjectMap.valuesToArray(new BitSet[objectObjectMap.size()]);
            for (int i2 = 0; i2 < bitSetArray.length; ++i2) {
                bitSet.or(bitSetArray[i2]);
            }
        }
    }

    private void onServiceRegistered(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        int n3 = Utils.getInstDepObjIdx(n, n2);
        this.registeredDSIServices.set(n3);
        String string = RuntimeGeneratedConstants.SERVICE_TS_NS[n];
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace().append("The service ");
            Utils.appendInstance(logMessage, string, n2);
            logMessage.append(" was registered.").log();
        }
        this.notifyRegistered(this.getSpecificServiceStateListeners(n3), string, n2);
        this.notifyRegistered(this.serviceStateListeners.getArray(), string, n2);
    }

    private void notifyRegistered(Object[] objectArray, String string, int n) {
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            try {
                ((DSIServiceStateListener)objectArray[i2]).registered(string, n);
                continue;
            }
            catch (Throwable throwable) {
                this.error().append("DSIServiceStateListener call failed").attachThrowable(throwable).log();
            }
        }
    }

    private void onServiceUnregistered(EventGeneric eventGeneric) {
        Object object;
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        int n3 = Utils.getInstDepObjIdx(n, n2);
        this.registeredDSIServices.clear(n3);
        String string = RuntimeGeneratedConstants.SERVICE_TS_NS[n];
        LogMessage logMessage = this.warn().append("The service ");
        Utils.appendInstance(logMessage, string, n2);
        logMessage.append(" was unregistered.").log();
        this.removeListenerNotificationMasks(n3);
        this.removeSkeletonNotificationMask(n3);
        NotificationDatapool.cleanup(n, n2);
        InvocationItem invocationItem = this.invocationQueue[n3];
        while (invocationItem != null) {
            object = invocationItem;
            invocationItem = invocationItem.next;
            DSIProxyTarget.release((InvocationItem)object);
        }
        this.invocationQueue[n3] = null;
        object = Constants.PROXY_PENDIG_CS[n3];
        if (object != null) {
            InvocationItem[] invocationItemArray = (InvocationItem[])object.valuesToArray(new InvocationItem[object.size()]);
            object.clear();
            for (int i2 = 0; i2 < invocationItemArray.length; ++i2) {
                if (invocationItemArray[i2] == null) continue;
                DSIProxyTarget.release(invocationItemArray[i2]);
            }
        }
        this.notifiyUnregistered(this.getSpecificServiceStateListeners(n3), string, n2);
        this.notifiyUnregistered(this.serviceStateListeners.getArray(), string, n2);
    }

    private void notifiyUnregistered(Object[] objectArray, String string, int n) {
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            try {
                ((DSIServiceStateListener)objectArray[i2]).unregistered(string, n);
                continue;
            }
            catch (Throwable throwable) {
                this.error().append("DSIServiceStateListener call failed").attachThrowable(throwable).log();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onNotificationInvocation(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(2);
        Object[] objectArray = (Object[])eventGeneric.getObject(3);
        try {
            int n4 = Cfg$PT.getNotificationIndex(n, n3);
            if (0 > n4) {
                this.error().append("The method (id=").append(n3).append(", name=\"").append(Utils.getRuntimeListenerMethodName(n, n3)).append("\")").append(" on ").append(RuntimeGeneratedConstants.LISTENER_TS_NS[n]).append(" is not an update method.").log();
            } else {
                Object object;
                int n5 = Utils.getInstDepObjIdx(n, n2);
                if (Cfg$PT.isComplexService(n)) {
                    object = this.getComplexAnalyzer(n, n2);
                    if (object == null) {
                        this.error().append("No complex analyzer found for ").append(RuntimeGeneratedConstants.SERVICE_TS_NS[n]).append(" service.").log();
                    } else {
                        this.invokeSafe(ServiceManager.reflectionFactory.getListenersMmao(n), n3, object, objectArray);
                    }
                }
                if (this.getSkeletonNotificationMask(n5).get(n4)) {
                    object = NotificationDatapool.update(n, n2, n4, DSIProxyTarget.copy(objectArray));
                    DSIProxyTarget.release(object);
                }
                if (null != (object = this.listenerNotificationMasks[n5]) && !object.isEmpty()) {
                    Object object2;
                    ArrayList arrayList = DSIProxyTarget.borrowArrayList();
                    Object[] objectArray2 = object.keysToArray(DSIProxyTarget.borrowObjectBlock(object.size()));
                    for (int i2 = 0; i2 < objectArray2.length && null != (object2 = objectArray2[i2]); ++i2) {
                        if (!((BitSet)object.get(object2)).get(n4)) continue;
                        arrayList.add(object2);
                    }
                    DSIProxyTarget.release(objectArray2);
                    if (0 < arrayList.size()) {
                        this.invokeAll(ServiceManager.reflectionFactory.getListenersMmao(n), n3, arrayList, objectArray);
                    }
                    DSIProxyTarget.release(arrayList);
                }
            }
        }
        finally {
            DSIProxyTarget.release(objectArray);
        }
    }

    private void invokeAll(MultipleMethodAccessibleObject multipleMethodAccessibleObject, int n, List list, Object[] objectArray) {
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = list.get(i2);
            this.invokeSafe(multipleMethodAccessibleObject, n, object, objectArray);
        }
    }

    private void invokeSafe(MultipleMethodAccessibleObject multipleMethodAccessibleObject, int n, Object object, Object[] objectArray) {
        try {
            multipleMethodAccessibleObject.invoke(n, object, objectArray);
        }
        catch (InvocationTargetException invocationTargetException) {
            this.error(invocationTargetException.getTargetException());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onResponseInvocation(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(2);
        Object[] objectArray = (Object[])eventGeneric.getObject(3);
        boolean bl = false;
        int n4 = -2;
        try {
            boolean bl2;
            if (Cfg$PT.isNonSyncService(n)) {
                bl2 = true;
            } else {
                Object object;
                IntObjectMap intObjectMap = Constants.PROXY_PENDIG_CS[Utils.getInstDepObjIdx(n, n2)];
                if (intObjectMap != null) {
                    int n5;
                    if (n3 == Cfg$C.getListenerAsyncExceptionId(n)) {
                        int n6 = (Integer)objectArray[2];
                        n5 = Cfg$PT.getSyncRequestIndexByRT(n, n6);
                        if (0 <= n5) {
                            bl = true;
                            n4 = this.asyncExcHandler(n5, n, n2, intObjectMap);
                        }
                    } else {
                        InvocationItem invocationItem = (InvocationItem)intObjectMap.get(n3);
                        if (invocationItem != null) {
                            bl = true;
                            n5 = Cfg$PT.getSyncRequests(n)[invocationItem.syncReqIdx];
                            object = Cfg$PT.getSyncResponses(n, invocationItem.syncReqIdx);
                            byte by = Cfg$PT.getRequestType(n, n5);
                            n4 = invocationItem.targetId;
                            switch (by) {
                                case 2: {
                                    DSIProxyTarget.simpleSyncResHandler(intObjectMap, n3);
                                    break;
                                }
                                case 4: {
                                    DSIProxyTarget.choiceSyncResHandler(intObjectMap, (int[])object);
                                    break;
                                }
                                case 3: {
                                    this.sequenceSyncResHandler(intObjectMap, n3, n5, n, n2, (int[])object);
                                    break;
                                }
                                case 5: {
                                    this.complexSyncResHandler(n, n2, objectArray, n5, n3, (int[])object, intObjectMap);
                                    break;
                                }
                                default: {
                                    this.error().append("The method (id=").append(n5).append(", name=\"").append(Utils.getRuntimeServiceMethodName(n, n5)).append("\")").append(" from service ").append(RuntimeGeneratedConstants.SERVICE_TS_NS[n]).append(" could not be assigned to a specific response case.").log();
                                }
                            }
                        }
                    }
                }
                if (n4 != -2 || Cfg$PT.isIndication(n, n3)) {
                    bl2 = true;
                } else {
                    bl2 = this.isUnexpectedResponsePassingActive(n, n2, n3);
                    String string = Utils.getRuntimeListenerMethodName(n, n3);
                    String string2 = RuntimeGeneratedConstants.LISTENER_TS_NS[n];
                    if (Cfg$PT.isNotification(n, n3)) {
                        object = this.error();
                        object.append("The method ");
                        Utils.appendInstanceMethod((LogMessage)object, string2, n2, string);
                        object.append(" is not a response, but an update method.").log();
                    } else {
                        object = bl2 ? this.warn() : this.error();
                        object.append("The method ");
                        Utils.appendInstanceMethod((LogMessage)object, string2, n2, string);
                        object.append(" is unexpected");
                        object.append(bl2 ? ", but will be processed." : " and will be discarded.").log();
                    }
                }
            }
            if (bl2) {
                this.invokeResponseListeners(n4, n, n2, n3, objectArray);
                if (bl) {
                    this.callQueue(n, n2);
                }
            }
        }
        finally {
            DSIProxyTarget.release(objectArray);
        }
    }

    private int asyncExcHandler(int n, int n2, int n3, IntObjectMap intObjectMap) {
        int n4 = -2;
        int n5 = Cfg$PT.getSyncRequests(n2)[n];
        int[] nArray = Cfg$PT.getSyncResponses(n2, n);
        byte by = Cfg$PT.getRequestType(n2, n5);
        switch (by) {
            case 2: 
            case 4: 
            case 5: {
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    InvocationItem invocationItem = (InvocationItem)intObjectMap.remove(nArray[i2]);
                    if (invocationItem == null) continue;
                    n4 = invocationItem.targetId;
                    DSIProxyTarget.release(invocationItem);
                }
                break;
            }
            case 3: {
                int[] nArray2 = this.getSyncSequenceTrack(n2, n3, n5);
                for (int i3 = 0; i3 < nArray.length; ++i3) {
                    InvocationItem invocationItem;
                    if (DSIProxyTarget.isSequenceResponseArrived(nArray[i3], nArray2) || (invocationItem = (InvocationItem)intObjectMap.remove(nArray[i3])) == null) continue;
                    n4 = invocationItem.targetId;
                    DSIProxyTarget.release(invocationItem);
                }
                this.resetSyncSequenceTrack(n2, n3, n5);
                break;
            }
            default: {
                this.error().append("The method (id=").append(n5).append(", name=\"").append(Utils.getRuntimeServiceMethodName(n2, n5)).append("\")").append(" from service ").append(RuntimeGeneratedConstants.SERVICE_TS_NS[n2]).append(" could not be assigned to a specific response case.").log();
            }
        }
        return n4;
    }

    private static void simpleSyncResHandler(IntObjectMap intObjectMap, int n) {
        InvocationItem invocationItem = (InvocationItem)intObjectMap.remove(n);
        DSIProxyTarget.release(invocationItem);
    }

    private static void choiceSyncResHandler(IntObjectMap intObjectMap, int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            InvocationItem invocationItem = (InvocationItem)intObjectMap.remove(nArray[i2]);
            DSIProxyTarget.release(invocationItem);
        }
    }

    private void sequenceSyncResHandler(IntObjectMap intObjectMap, int n, int n2, int n3, int n4, int[] nArray) {
        boolean bl;
        InvocationItem invocationItem = (InvocationItem)intObjectMap.remove(n);
        DSIProxyTarget.release(invocationItem);
        int[] nArray2 = this.getSyncSequenceTrack(n3, n4, n2);
        int n5 = nArray2[0];
        nArray2[++n5] = n;
        nArray2[0] = n5;
        boolean bl2 = bl = n5 == nArray.length;
        if (bl) {
            this.resetSyncSequenceTrack(n3, n4, n2);
        }
    }

    private void complexSyncResHandler(int n, int n2, Object[] objectArray, int n3, int n4, int[] nArray, IntObjectMap intObjectMap) {
        ComplexAnalyzer complexAnalyzer = this.getComplexAnalyzer(n, n2);
        if (complexAnalyzer == null) {
            this.error().append("No complex analyzer found for ").append(RuntimeGeneratedConstants.SERVICE_TS_NS[n]).append(" service.").log();
        } else {
            complexAnalyzer.setPrecondition(n3);
            this.invokeSafe(ServiceManager.reflectionFactory.getListenersMmao(n), n4, complexAnalyzer, objectArray);
            if (complexAnalyzer.isFinished()) {
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    InvocationItem invocationItem = (InvocationItem)intObjectMap.remove(nArray[i2]);
                    DSIProxyTarget.release(invocationItem);
                }
            }
        }
    }

    private void invokeResponseListeners(int n, int n2, int n3, int n4, Object[] objectArray) {
        int n5 = Utils.getInstDepObjIdx(n2, n3);
        ArrayList arrayList = DSIProxyTarget.borrowArrayList();
        this.getTargetResponseListeners(arrayList, n5, n);
        if (0 < arrayList.size()) {
            this.invokeAll(ServiceManager.reflectionFactory.getListenersMmao(n2), n4, arrayList, objectArray);
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace().append("No response listener registered: ");
            Utils.appendInstanceMethod(logMessage, RuntimeGeneratedConstants.LISTENER_TS_NS[n2], n3, Utils.getRuntimeListenerMethodName(n2, n4));
            Utils.appendTargetId(logMessage, n).log();
        }
        DSIProxyTarget.release(arrayList);
    }

    private void onCheckRequestTimeouts() {
        for (int i2 = 0; i2 < RuntimeGeneratedConstants.SERVICE_TS_NS.length; ++i2) {
            this.syncTimeoutsTypeHandler(i2);
        }
    }

    private void syncTimeoutsTypeHandler(int n) {
        int[] nArray = Cfg$PT.getSyncRequestTimeouts(n);
        if (0 < nArray.length) {
            int n2 = RuntimeGeneratedConstants.INST_NMBS[n];
            for (int i2 = 0; i2 < n2; ++i2) {
                int n3 = Utils.getInstDepObjIdx(n, i2);
                IntObjectMap intObjectMap = Constants.PROXY_PENDIG_CS[n3];
                this.timedOutRequestIdxs.clear();
                DSIProxyTarget.collectTimedOutRequestIdxs(this.timedOutRequestIdxs, intObjectMap, nArray);
                if (this.timedOutRequestIdxs.isEmpty()) continue;
                IntIterator intIterator = this.timedOutRequestIdxs.iterator();
                while (intIterator.hasNext()) {
                    int n4 = intIterator.next();
                    this.handleTimedOutRequest(intObjectMap, n, i2, n4, nArray[n4]);
                }
                this.callQueue(n, i2);
            }
        }
    }

    private static void collectTimedOutRequestIdxs(IntSet intSet, IntObjectMap intObjectMap, int[] nArray) {
        if (null != intObjectMap && !intObjectMap.isEmpty()) {
            InvocationItem invocationItem;
            Object[] objectArray = intObjectMap.valuesToArray(DSIProxyTarget.borrowObjectBlock(intObjectMap.size()));
            long l = Utils.currentTimeMillis();
            for (int i2 = 0; i2 < objectArray.length && null != (invocationItem = (InvocationItem)objectArray[i2]); ++i2) {
                int n = nArray[invocationItem.syncReqIdx];
                if (0 >= n || (long)n >= l - invocationItem.reqTs) continue;
                intSet.add(invocationItem.syncReqIdx);
            }
            DSIProxyTarget.release(objectArray);
        }
    }

    private void handleTimedOutRequest(IntObjectMap intObjectMap, int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7 = Cfg$PT.getSyncRequests(n)[n3];
        byte by = Cfg$PT.getRequestType(n, n7);
        int[] nArray = Cfg$PT.getSyncResponses(n, n3);
        int n8 = -2;
        LogMessage logMessage = this.error().append("DSI timeout occurred.").append(" timeout=").append(n4).append("ms, ").append("request=");
        Utils.appendInstanceMethod(logMessage, RuntimeGeneratedConstants.SERVICE_TS_NS[n], n2, Cfg$U.getServiceSyncMethodName(n, n3));
        logMessage.append(": ");
        switch (by) {
            case 2: {
                logMessage.append("\"").append(Cfg$U.getListenerSyncMethodName(n, n3, 0)).append("\" did not arrive.");
                n8 = DSIProxyTarget.determinePendingResponseTargetId(intObjectMap, nArray[0]);
                DSIProxyTarget.clearPending(intObjectMap, nArray[0]);
                break;
            }
            case 4: {
                logMessage.append("None of CHOICE(");
                for (n6 = 0; n6 < nArray.length; ++n6) {
                    if (0 < n6) {
                        logMessage.append(", ");
                    }
                    logMessage.append("\"").append(Cfg$U.getListenerSyncMethodName(n, n3, n6)).append("\"");
                    if (n8 == -2) {
                        n8 = DSIProxyTarget.determinePendingResponseTargetId(intObjectMap, nArray[n6]);
                    }
                    DSIProxyTarget.clearPending(intObjectMap, nArray[n6]);
                }
                logMessage.append(") did arrive.");
                break;
            }
            case 3: {
                int[] nArray2 = this.getSyncSequenceTrack(n, n2, n7);
                n5 = 1;
                logMessage.append("SEQUENCE part (");
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    if (DSIProxyTarget.isSequenceResponseArrived(nArray[i2], nArray2)) continue;
                    if (n5 == 0) {
                        logMessage.append(", ");
                    } else {
                        n5 = 0;
                    }
                    logMessage.append("\"").append(Cfg$U.getListenerSyncMethodName(n, n3, i2)).append("\"");
                    if (n8 == -2) {
                        n8 = DSIProxyTarget.determinePendingResponseTargetId(intObjectMap, nArray[i2]);
                    }
                    DSIProxyTarget.clearPending(intObjectMap, nArray[i2]);
                }
                logMessage.append(") did not arrive.");
                this.resetSyncSequenceTrack(n, n2, n7);
                break;
            }
            case 5: {
                logMessage.append("At least one of COMPLEX(");
                for (int i3 = 0; i3 < nArray.length; ++i3) {
                    if (0 < i3) {
                        logMessage.append(", ");
                    }
                    logMessage.append("\"").append(Cfg$U.getListenerSyncMethodName(n, n3, i3)).append("\"");
                    if (n8 == -2) {
                        n8 = DSIProxyTarget.determinePendingResponseTargetId(intObjectMap, nArray[i3]);
                    }
                    DSIProxyTarget.clearPending(intObjectMap, nArray[i3]);
                }
                logMessage.append(") did not arrive.");
                break;
            }
        }
        logMessage.log();
        if (-2 != n8) {
            n6 = Cfg$PT.getRTBySyncRequestIdx(n, n3);
            n5 = Utils.getInstDepObjIdx(n, n2);
            ArrayList arrayList = DSIProxyTarget.borrowArrayList();
            this.getTargetResponseListeners(arrayList, n5, n8);
            int n9 = arrayList.size();
            for (int i4 = 0; i4 < n9; ++i4) {
                try {
                    DSIListener dSIListener = (DSIListener)arrayList.get(i4);
                    dSIListener.asyncException(8304, "DSI timeout occurred.", n6);
                    continue;
                }
                catch (Exception exception) {
                    this.error(exception);
                }
            }
            DSIProxyTarget.release(arrayList);
        }
    }

    private static int determinePendingResponseTargetId(IntObjectMap intObjectMap, int n) {
        InvocationItem invocationItem = (InvocationItem)intObjectMap.get(n);
        return null != invocationItem ? invocationItem.targetId : -2;
    }

    private static void clearPending(IntObjectMap intObjectMap, int n) {
        InvocationItem invocationItem = (InvocationItem)intObjectMap.remove(n);
        DSIProxyTarget.release(invocationItem);
    }

    private void onNotificationDatapoolTrigger(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        DSIListener dSIListener = (DSIListener)eventGeneric.getObject(2);
        BitSet bitSet = (BitSet)eventGeneric.getObject(3);
        NotificationDatapool.trigger(n, n2, dSIListener, bitSet);
        DSIProxyTarget.release(bitSet);
    }

    private static boolean isBlocked(int n, int[] nArray) {
        boolean bl = false;
        IntObjectMap intObjectMap = Constants.PROXY_PENDIG_CS[n];
        if (null != intObjectMap && !intObjectMap.isEmpty()) {
            for (int i2 = 0; !bl && i2 < nArray.length; ++i2) {
                bl = intObjectMap.containsKey(nArray[i2]);
            }
        }
        return bl;
    }

    private static void addPending(int n, int[] nArray, int n2, int n3, long l) {
        IntObjectMap intObjectMap = Constants.PROXY_PENDIG_CS[n];
        if (null == intObjectMap) {
            Constants.PROXY_PENDIG_CS[n] = intObjectMap = new IntObjectOptHashMap().synchronize();
        }
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            InvocationItem invocationItem = DSIProxyTarget.borrowInvocationItem();
            invocationItem.syncReqIdx = n3;
            invocationItem.targetId = n2;
            invocationItem.reqTs = l;
            invocationItem.syncRespIdx = i2;
            intObjectMap.put(nArray[i2], invocationItem);
        }
    }

    private static void removePending(int n, int[] nArray) {
        IntObjectMap intObjectMap = Constants.PROXY_PENDIG_CS[n];
        if (null != intObjectMap) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                InvocationItem invocationItem = (InvocationItem)intObjectMap.remove(nArray[i2]);
                DSIProxyTarget.release(invocationItem);
            }
        }
    }

    private void callQueue(int n, int n2) {
        int n3 = Utils.getInstDepObjIdx(n, n2);
        InvocationItem invocationItem = this.invocationQueue[n3];
        InvocationItem invocationItem2 = null;
        InvocationItem invocationItem3 = null;
        while (invocationItem != null) {
            int n4 = Cfg$PT.getSyncRequests(n)[invocationItem.syncReqIdx];
            int[] nArray = Cfg$PT.getSyncResponses(n, invocationItem.syncReqIdx);
            if (!DSIProxyTarget.isBlocked(n3, nArray)) {
                long l = Utils.currentTimeMillis();
                DSIProxyTarget.addPending(n3, nArray, invocationItem.targetId, invocationItem.syncReqIdx, l);
                boolean bl = this.invokeService(invocationItem.targetId, n4, n, n2, invocationItem.args);
                if (!bl) {
                    DSIProxyTarget.removePending(n3, nArray);
                }
                InvocationItem invocationItem4 = invocationItem;
                invocationItem = invocationItem.next;
                DSIProxyTarget.release(invocationItem4);
                continue;
            }
            if (null != invocationItem3) {
                invocationItem3.next = invocationItem;
                invocationItem3 = invocationItem;
                invocationItem = invocationItem.next;
                continue;
            }
            invocationItem2 = invocationItem3 = invocationItem;
            invocationItem = invocationItem.next;
        }
        if (null != invocationItem3) {
            invocationItem3.next = null;
        }
        this.invocationQueue[n3] = invocationItem2;
    }

    private ComplexAnalyzer getComplexAnalyzer(int n, int n2) {
        int n3 = Utils.getInstDepObjIdx(n, n2);
        ComplexAnalyzer complexAnalyzer = this.SYNC_CMP_ANALYZER_PROXY_MX[n3];
        if (complexAnalyzer == null) {
            try {
                complexAnalyzer = (ComplexAnalyzer)ServiceManager.reflectionFactory.getSyncCmpAnalyzersMcao().newInstance(Cfg$PT.getComplexAnalyzerConstructor(n), Constants.Z_ARGS);
            }
            catch (InvocationTargetException invocationTargetException) {
                this.error(invocationTargetException.getTargetException());
            }
            this.SYNC_CMP_ANALYZER_PROXY_MX[n3] = complexAnalyzer;
        }
        return complexAnalyzer;
    }

    private IntSet accessUnexpectedResponsePassingSet(int n, int n2) {
        int n3 = Utils.getInstDepObjIdx(n, n2);
        IntSet intSet = this.unexpectedResponsesPassingSets[n3];
        if (null == intSet) {
            this.unexpectedResponsesPassingSets[n3] = intSet = new IntOptHashSet();
        }
        return intSet;
    }

    private boolean isUnexpectedResponsePassingActive(int n, int n2, int n3) {
        int n4 = Utils.getInstDepObjIdx(n, n2);
        IntSet intSet = this.unexpectedResponsesPassingSets[n4];
        return null != intSet && intSet.contains(n3);
    }

    private int[] getSyncSequenceTrack(int n, int n2, int n3) {
        int[] nArray;
        int n4 = Utils.getInstDepObjIdx(n, n2);
        IntObjectMap intObjectMap = this.SYNC_SEQ_TRACKERS[n4];
        if (intObjectMap == null) {
            this.SYNC_SEQ_TRACKERS[n4] = intObjectMap = new IntObjectOptHashMap();
        }
        if (null == (nArray = (int[])intObjectMap.get(n3))) {
            int n5 = Cfg$PT.getSyncRequestIndex(n, n3);
            nArray = new int[Cfg$PT.getSyncResponses(n, n5).length + 1];
            intObjectMap.put(n3, nArray);
        }
        return nArray;
    }

    private void resetSyncSequenceTrack(int n, int n2, int n3) {
        int n4 = Utils.getInstDepObjIdx(n, n2);
        int[] nArray = (int[])DSIProxyTarget.getSafe(this.SYNC_SEQ_TRACKERS[n4], n3);
        if (null != nArray) {
            Arrays.fill(nArray, -1);
            nArray[0] = 0;
        }
    }

    private static boolean isSequenceResponseArrived(int n, int[] nArray) {
        int n2;
        boolean bl = false;
        for (int i2 = n2 = nArray[0]; i2 > 0 && !bl; --i2) {
            bl = n == nArray[i2];
        }
        return bl;
    }

    private static Object getSafe(IntObjectMap intObjectMap, int n) {
        return null != intObjectMap ? intObjectMap.get(n) : null;
    }

    private boolean invokeService(int n, int n2, int n3, int n4, Object[] objectArray) {
        boolean bl;
        Object[] objectArray2 = this.getServiceInterceptors(Utils.getInstDepObjIdx(n3, n4));
        if (0 < objectArray2.length) {
            bl = this.invokeServiceWrapped(n, n2, n3, n4, objectArray, objectArray2);
        } else {
            this.invokeServiceDirect(n, n2, n3, n4, objectArray);
            bl = true;
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean invokeServiceWrapped(int n, int n2, int n3, int n4, Object[] objectArray, Object[] objectArray2) {
        String string = RuntimeGeneratedConstants.SERVICE_TS_NS[n3];
        boolean bl = Utils.before(objectArray2, string, n4, n2, objectArray);
        if (bl) {
            Object[] objectArray3 = DSIProxyTarget.copy(objectArray);
            try {
                this.invokeServiceDirect(n, n2, n3, n4, objectArray);
                Utils.after(objectArray2, string, n4, n2, objectArray3);
            }
            finally {
                DSIProxyTarget.release(objectArray3);
            }
        }
        return bl;
    }

    private void invokeServiceDirect(int n, int n2, int n3, int n4, Object[] objectArray) {
        try {
            Utils.debugInvokeService(n, n3, n4, n2, objectArray);
            this.skeletonTarget.serviceInvoke(n, n2, n3, n4, objectArray);
        }
        catch (Throwable throwable) {
            this.error(throwable);
        }
    }

    private static ArrayList borrowArrayList() {
        ArrayList arrayList = (ArrayList)ARRAYLIST_POOL.borrow();
        if (null == arrayList) {
            arrayList = new ArrayList(20);
        }
        return arrayList;
    }

    private static void release(ArrayList arrayList) {
        if (null != arrayList) {
            arrayList.clear();
            if (20 >= arrayList.size()) {
                ARRAYLIST_POOL.release(arrayList);
            }
        }
    }

    private static BitSet borrowBitSet() {
        BitSet bitSet = (BitSet)BITSET_POOL.borrow();
        if (null == bitSet) {
            bitSet = new BitSet();
        } else {
            bitSet.clear();
        }
        return bitSet;
    }

    private static void release(BitSet bitSet) {
        if (null != bitSet) {
            BITSET_POOL.release(bitSet);
        }
    }

    private static InvocationItem borrowInvocationItem() {
        InvocationItem invocationItem = (InvocationItem)INVOCATION_POOL.borrow();
        if (null == invocationItem) {
            invocationItem = new InvocationItem();
        }
        return invocationItem;
    }

    private static void release(InvocationItem invocationItem) {
        if (null != invocationItem) {
            DSIProxyTarget.release(invocationItem.args);
            invocationItem.reset();
            INVOCATION_POOL.release(invocationItem);
        }
    }

    private static Object[] borrowObjectArray(int n) {
        return Constants.PROXY_OAP.borrowArray(n);
    }

    private static void release(Object[] objectArray) {
        if (null != objectArray) {
            Constants.PROXY_OAP.returnArray(objectArray);
        }
    }

    private static Object[] copy(Object[] objectArray) {
        Object[] objectArray2 = DSIProxyTarget.borrowObjectArray(objectArray.length);
        System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, objectArray.length);
        return objectArray2;
    }

    private static Object[] borrowObjectBlock(int n) {
        return DSIProxyTarget.borrowObjectArray(n + 31 & 0xFFFFFFE0);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        SET_NOTIFICATION_NAME = "setNotification".intern();
        CLEAR_NOTIFICATION_NAME = "clearNotification".intern();
        PARAMS_NOTIF_ALL = new Class[]{class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = DSIProxyTarget.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener};
        PARAMS_NOTIF_ONE = new Class[]{Integer.TYPE, class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = DSIProxyTarget.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener};
        PARAMS_NOTIF_SOME = new Class[]{array$I == null ? (array$I = DSIProxyTarget.class$("[I")) : array$I, class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = DSIProxyTarget.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener};
        ARRAYLIST_POOL = new PoorMansPool("DSIProxy.ArrayList", 10);
        BITSET_POOL = new PoorMansPool("DSIProxy.BitSet", 10);
        INVOCATION_POOL = new PoorMansPool("DSIProxy.InvocationItem", 20);
    }
}

