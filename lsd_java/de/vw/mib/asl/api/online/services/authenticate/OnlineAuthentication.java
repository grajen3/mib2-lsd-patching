/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.online.services.authenticate;

import de.vw.mib.asl.api.online.services.authenticate.OnlineAuthenticationListener;

public interface OnlineAuthentication {
    default public String getMainUserEnrolled() {
    }

    default public void setSPIN(String string, String string2, OnlineAuthenticationListener onlineAuthenticationListener) {
    }

    default public void calculateSpinHash(String string, String string2, String string3, String string4, int n, OnlineAuthenticationListener onlineAuthenticationListener) {
    }

    default public void register(String string, OnlineAuthenticationListener onlineAuthenticationListener) {
    }

    default public void unregister(String string, OnlineAuthenticationListener onlineAuthenticationListener) {
    }

    default public void registerForMainUserEnrollment(OnlineAuthenticationListener onlineAuthenticationListener) {
    }

    default public void unRegisterForMainUserEnrollment(OnlineAuthenticationListener onlineAuthenticationListener) {
    }

    default public String getMainUserName() {
    }
}

