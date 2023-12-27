/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.dispatcher.apps;

import de.vw.mib.timer.Invoker;

public interface ViewEventDispatcher
extends Invoker {
    default public void createAndSubmitBooleanValueEvent(int n, boolean bl) {
    }

    default public void createAndSubmitHMIEvent(int n) {
    }

    default public void createAndSubmitIntegerValueEvent(int n, int n2) {
    }

    default public void createAndSubmitListItemEvent(int n, int n2, int n3, int n4, int n5, String string, long l) {
    }

    default public void createAndSubmitPointEvent(int n, int n2, int n3, int n4, int n5) {
    }

    default public void createAndSubmitSpellerValueEvent(int n, String string, int n2, int n3, int n4) {
    }

    default public void createAndSubmitStringValueEvent(int n, String string) {
    }
}

