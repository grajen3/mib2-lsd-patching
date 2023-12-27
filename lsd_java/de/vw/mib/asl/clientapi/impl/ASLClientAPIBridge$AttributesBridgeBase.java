/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.impl;

import de.vw.mib.asl.clientapi.ASLClientAPIAttributes;
import de.vw.mib.asl.clientapi.ASLClientAPIListener;
import de.vw.mib.asl.clientapi.impl.ASLClientAPIBridge$AttributesBridgeBase$Subscriptions;
import de.vw.mib.collections.copyonwrite.CowArray;
import java.util.HashMap;
import java.util.Map;

public abstract class ASLClientAPIBridge$AttributesBridgeBase
implements ASLClientAPIAttributes {
    private final Map subscriptions = new HashMap();
    private final CowArray subscribers = new CowArray();

    protected ASLClientAPIBridge$AttributesBridgeBase() {
    }

    @Override
    public synchronized void subscribe(ASLClientAPIListener aSLClientAPIListener, int n) {
        this.subscribers.addIfNotAlreadyIn(aSLClientAPIListener);
        this.accessSubscriptions(aSLClientAPIListener).subscribe(n);
    }

    @Override
    public synchronized void subscribeAll(ASLClientAPIListener aSLClientAPIListener) {
        this.subscribers.addIfNotAlreadyIn(aSLClientAPIListener);
        this.accessSubscriptions(aSLClientAPIListener).subscribeAll();
    }

    @Override
    public synchronized void unsubscribe(ASLClientAPIListener aSLClientAPIListener, int n) {
        ASLClientAPIBridge$AttributesBridgeBase$Subscriptions aSLClientAPIBridge$AttributesBridgeBase$Subscriptions = this.getSubscriptions(aSLClientAPIListener);
        if (null != aSLClientAPIBridge$AttributesBridgeBase$Subscriptions) {
            aSLClientAPIBridge$AttributesBridgeBase$Subscriptions.unsubscribe(n);
            if (aSLClientAPIBridge$AttributesBridgeBase$Subscriptions.isEmpty()) {
                this.unsubscribeAll(aSLClientAPIListener);
            }
        }
    }

    @Override
    public synchronized void unsubscribeAll(ASLClientAPIListener aSLClientAPIListener) {
        this.subscribers.remove(aSLClientAPIListener);
        this.subscriptions.remove(aSLClientAPIListener);
    }

    protected abstract void fireUpdate(ASLClientAPIListener aSLClientAPIListener, int n) {
    }

    protected void notifySubscribers(int n) {
        Object[] objectArray = this.subscribers.getArray();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            ASLClientAPIListener aSLClientAPIListener = (ASLClientAPIListener)objectArray[i2];
            ASLClientAPIBridge$AttributesBridgeBase$Subscriptions aSLClientAPIBridge$AttributesBridgeBase$Subscriptions = this.getSubscriptions(aSLClientAPIListener);
            if (null == aSLClientAPIBridge$AttributesBridgeBase$Subscriptions || !aSLClientAPIBridge$AttributesBridgeBase$Subscriptions.isSubscribing(n)) continue;
            this.fireUpdate(aSLClientAPIListener, n);
        }
    }

    protected boolean isSubscribing(ASLClientAPIListener aSLClientAPIListener, int n) {
        ASLClientAPIBridge$AttributesBridgeBase$Subscriptions aSLClientAPIBridge$AttributesBridgeBase$Subscriptions = this.getSubscriptions(aSLClientAPIListener);
        return null != aSLClientAPIBridge$AttributesBridgeBase$Subscriptions && aSLClientAPIBridge$AttributesBridgeBase$Subscriptions.isSubscribing(n);
    }

    private ASLClientAPIBridge$AttributesBridgeBase$Subscriptions getSubscriptions(ASLClientAPIListener aSLClientAPIListener) {
        return (ASLClientAPIBridge$AttributesBridgeBase$Subscriptions)this.subscriptions.get(aSLClientAPIListener);
    }

    private ASLClientAPIBridge$AttributesBridgeBase$Subscriptions accessSubscriptions(ASLClientAPIListener aSLClientAPIListener) {
        ASLClientAPIBridge$AttributesBridgeBase$Subscriptions aSLClientAPIBridge$AttributesBridgeBase$Subscriptions = (ASLClientAPIBridge$AttributesBridgeBase$Subscriptions)this.subscriptions.get(aSLClientAPIListener);
        if (null == aSLClientAPIBridge$AttributesBridgeBase$Subscriptions) {
            aSLClientAPIBridge$AttributesBridgeBase$Subscriptions = new ASLClientAPIBridge$AttributesBridgeBase$Subscriptions();
            this.subscriptions.put(aSLClientAPIListener, aSLClientAPIBridge$AttributesBridgeBase$Subscriptions);
        }
        return aSLClientAPIBridge$AttributesBridgeBase$Subscriptions;
    }
}

