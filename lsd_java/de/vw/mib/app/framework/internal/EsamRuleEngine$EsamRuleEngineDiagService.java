/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

interface EsamRuleEngine$EsamRuleEngineDiagService {
    default public void onEsamVisibilityDenied(String string, String string2, String string3) {
    }

    default public void onEsamVisibilityDenied(String string, String string2, String string3, String string4) {
    }

    default public void onEsamVisibilityGranted(String string, String string2) {
    }

    default public void onEsamVisibilityRelease(String string, String string2) {
    }

    default public void onEsamVisibilityRequest(String string, String string2) {
    }

    default public void onEsamVisibilityRevoked(String string, String string2, String string3, String string4) {
    }

    default public void onHideAllEsamMembersRequest(String string, String string2) {
    }
}

