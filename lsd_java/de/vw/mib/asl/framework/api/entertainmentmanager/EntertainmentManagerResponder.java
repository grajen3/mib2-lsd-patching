/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.entertainmentmanager;

import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentContext;

public interface EntertainmentManagerResponder {
    default public void sendAnswerToEntertainmentManager(int n) {
    }

    default public void activated() {
    }

    default public void deactivated() {
    }

    default public void cancelled() {
    }

    default public void sourceAdded(int n) {
    }

    default public void rqIndepedentBrowsing(int n) {
    }

    default public void rqBtnDn(int n) {
    }

    default public void rqBtnUp(int n) {
    }

    default public void emptyDnUpQueue() {
    }

    default public void register(int n, boolean bl, int n2) {
    }

    default public void register2(int n, boolean bl, int n2) {
    }

    default public void register(EntertainmentContext entertainmentContext) {
    }

    default public void deregister() {
    }

    default public void exBoxRequest(int n) {
    }

    default public void weakRequest(int n) {
    }
}

