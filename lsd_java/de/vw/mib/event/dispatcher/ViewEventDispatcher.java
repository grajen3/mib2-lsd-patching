/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.dispatcher;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.event.HMIEvent;

public interface ViewEventDispatcher
extends de.vw.mib.event.dispatcher.apps.ViewEventDispatcher {
    default public void createAndSubmitBooleanValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, boolean bl) {
    }

    default public void createAndSubmitHMIEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n) {
    }

    default public void createAndSubmitIntegerValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, int n2) {
    }

    default public void createAndSubmitListItemEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, int n2, int n3, int n4, int n5, String string, long l) {
    }

    default public void createAndSubmitPointEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, int n2, int n3, int n4, int n5) {
    }

    default public void createAndSubmitSpellerValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, String string, int n2, int n3, int n4) {
    }

    default public void createAndSubmitStringValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, String string) {
    }

    default public void submitEvent(HMIEvent hMIEvent) {
    }
}

