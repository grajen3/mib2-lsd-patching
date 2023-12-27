/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.event;

public interface OutEventListener {
    default public void outHMIEventFired(String string) {
    }

    default public void outIntegerEventFired(String string, int n) {
    }

    default public void outBooleanEventFired(String string, boolean bl) {
    }

    default public void outStringEventFired(String string, String string2) {
    }

    default public void outPointEventFired(String string, int n, int n2, int n3, int n4) {
    }

    default public void outListItemEventFired(String string, int n, int n2, int n3, int n4, String string2, long l) {
    }

    default public void outSpellerEventFired(String string, String string2, int n, int n2, int n3) {
    }
}

