/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.dispatcher;

import de.vw.mib.app.framework.AppDefinition;

public interface StatemachineEventDispatcher {
    default public void createAndSubmitBooleanValueEvent(int n, boolean bl) {
    }

    default public void createAndSubmitBooleanValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, boolean bl) {
    }

    default public void createAndSubmitContextChangeEvent(String string) {
    }

    default public void createAndSubmitDpChangedEvent(int n) {
    }

    default public void createAndSubmitDpChangedEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n) {
    }

    default public void createAndSubmitDynamicStateEvent(int n, int n2, int n3) {
    }

    default public void createAndSubmitHMIEvent(int n) {
    }

    default public void createAndSubmitHMIEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n) {
    }

    default public void createAndSubmitIntegerValueEvent(int n, int n2) {
    }

    default public void createAndSubmitIntegerValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, int n2) {
    }

    default public void createAndSubmitListItemEvent(int n, int n2, int n3, int n4, int n5, String string, long l) {
    }

    default public void createAndSubmitListItemEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, int n2, int n3, int n4, int n5, String string, long l) {
    }

    default public void createAndSubmitPointEvent(int n, int n2, int n3, int n4, int n5) {
    }

    default public void createAndSubmitPointEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, int n2, int n3, int n4, int n5) {
    }

    default public void createAndSubmitPopupViewEvent(int n, String string, int n2) {
    }

    default public void createAndSubmitPopupViewEvent(int n, String string, int n2, int n3) {
    }

    default public void createAndSubmitSpellerValueEvent(int n, String string, int n2, int n3, int n4) {
    }

    default public void createAndSubmitSpellerValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, String string, int n2, int n3, int n4) {
    }

    default public void createAndSubmitStringValueEvent(int n, String string) {
    }

    default public void createAndSubmitStringValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, String string) {
    }

    default public void createAndSubmitViewChangeEvent(int n, String string, boolean bl, int n2, int n3) {
    }
}

