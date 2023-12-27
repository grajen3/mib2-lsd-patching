/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice;

import de.esolutions.fw.comm.asi.online.coreservice.KeyValPair;
import de.esolutions.fw.comm.asi.online.coreservice.License;
import de.esolutions.fw.comm.asi.online.coreservice.Result;

public interface ExtOnlineCoreServiceReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void initResponse(int n) {
    }

    default public void enableApplication() {
    }

    default public void disableApplication() {
    }

    default public void onlineResponse(int n, KeyValPair[] keyValPairArray) {
    }

    default public void dataResponse(int n, byte[] byArray) {
    }

    default public void finalResponse(int n, Result result) {
    }

    default public void keyStoreChanged() {
    }

    default public void updateCredentials(int n, int n2, String string, String string2, String string3) {
    }

    default public void updateLicense(int n, License[] licenseArray) {
    }
}

