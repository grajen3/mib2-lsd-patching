/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.impl;

import java.util.BitSet;

class ASLClientAPIBridge$AttributesBridgeBase$Subscriptions {
    private final BitSet attrs = new BitSet();
    private boolean all;

    ASLClientAPIBridge$AttributesBridgeBase$Subscriptions() {
    }

    void subscribe(int n) {
        this.attrs.set(n, !this.all);
    }

    void subscribeAll() {
        this.all = true;
        this.attrs.clear();
    }

    void unsubscribe(int n) {
        this.attrs.set(n, this.all);
    }

    boolean isEmpty() {
        return !this.all && this.attrs.isEmpty();
    }

    boolean isSubscribing(int n) {
        return this.all ^ this.attrs.get(n);
    }
}

