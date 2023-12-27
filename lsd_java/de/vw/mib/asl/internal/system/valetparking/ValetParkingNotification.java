/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.valetparking;

import de.vw.mib.asl.api.system.valetparking.ValetParkingListener;
import de.vw.mib.asl.internal.system.valetparking.TimeoutListener;
import de.vw.mib.asl.internal.system.valetparking.ValetParkingCallbackImpl;
import de.vw.mib.asl.internal.system.valetparking.ValetParkingNotification$1;
import de.vw.mib.asl.internal.system.valetparking.ValetParkingTransitionDoneListener;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;

class ValetParkingNotification {
    private static final String LOG_PREFIX;
    private final ArrayList callbacks = new ArrayList();
    private final Logger logger;
    private final TimeoutListener timeoutListener;
    private ValetParkingTransitionDoneListener transitionDoneListener;

    ValetParkingNotification(Map map, boolean bl, ValetParkingTransitionDoneListener valetParkingTransitionDoneListener, Logger logger) {
        if (map == null || map.isEmpty() || valetParkingTransitionDoneListener == null || logger == null) {
            throw new IllegalArgumentException("Mandatory arguments must not must not be empty.");
        }
        this.transitionDoneListener = valetParkingTransitionDoneListener;
        this.timeoutListener = this.createTimeoutListener();
        this.logger = logger;
        logger.info(2048, new StringBuffer().append("[ValetParkingNotification] Changing valet parking state to ").append(bl).append(", invoking ").append(map.size()).append(" listeners.").toString());
        this.createListenerNotification(map, bl);
    }

    TimeoutListener getTimeoutListener() {
        return this.timeoutListener;
    }

    void notifyCallbackAnswer(ValetParkingCallbackImpl valetParkingCallbackImpl, boolean bl) {
        if (valetParkingCallbackImpl == null) {
            throw new IllegalArgumentException("Callback argument must not be null.");
        }
        String string = valetParkingCallbackImpl.getListenerName();
        if (!bl) {
            this.logger.warn(2048, new StringBuffer().append("[ValetParkingNotification] Listener >").append(string).append("< returned without success.").toString());
        } else if (this.logger.isTraceEnabled(2048)) {
            this.logger.trace(2048, new StringBuffer().append("[ValetParkingNotification] Listener >").append(string).append("< returned with success.").toString());
        }
        if (!this.callbacks.remove(valetParkingCallbackImpl)) {
            throw new IllegalStateException("Unexpected callback call.");
        }
        if (this.callbacks.isEmpty()) {
            if (this.logger.isTraceEnabled(2048)) {
                this.logger.trace(2048, "[ValetParkingNotification] All listeners returned a callback.");
            }
            this.notifyListenerTransitionDone();
        }
    }

    void notifyTimeout() {
        this.invalidateCallbacksOnTimeout();
        this.notifyListenerTransitionDone();
    }

    private void createListenerNotification(Map map, boolean bl) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            String string = this.getListenerName(map$Entry);
            ValetParkingCallbackImpl valetParkingCallbackImpl = new ValetParkingCallbackImpl(string, this, this.logger);
            ValetParkingListener valetParkingListener = (ValetParkingListener)map$Entry.getValue();
            this.callbacks.add(valetParkingCallbackImpl);
            valetParkingListener.notifyValetParkingStateChanged(bl, valetParkingCallbackImpl);
        }
    }

    private TimeoutListener createTimeoutListener() {
        return new ValetParkingNotification$1(this);
    }

    private String getListenerName(Map$Entry map$Entry) {
        ValetParkingListener valetParkingListener = (ValetParkingListener)map$Entry.getKey();
        return super.getClass().getName();
    }

    private void invalidateCallbacksOnTimeout() {
        this.logger.warn(2048, new StringBuffer().append("[ValetParkingNotification] Service notification timeout reached. >").append(this.callbacks.size()).append("< listener did no callback.").toString());
        Iterator iterator = this.callbacks.iterator();
        while (iterator.hasNext()) {
            ValetParkingCallbackImpl valetParkingCallbackImpl = (ValetParkingCallbackImpl)iterator.next();
            valetParkingCallbackImpl.setInvalid();
            String string = valetParkingCallbackImpl.getListenerName();
            this.logger.warn(2048).append("[ValetParkingNotification] ").append("Valet parking listener with targetId >").append(string).append("< did not answer until timeout.").log();
        }
        this.callbacks.clear();
    }

    private void notifyListenerTransitionDone() {
        if (this.transitionDoneListener != null) {
            this.transitionDoneListener.notifyTransitionDone();
        }
        this.transitionDoneListener = null;
    }
}

