/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice;

import de.esolutions.fw.comm.asi.online.coreservice.ExtOnlineCoreServiceReply;
import de.esolutions.fw.comm.asi.online.coreservice.KeyValPair;
import de.esolutions.fw.comm.asi.online.coreservice.RequestDescriptor;

public interface ExtOnlineCoreServiceS {
    default public void init(String string, ExtOnlineCoreServiceReply extOnlineCoreServiceReply) {
    }

    default public void onlineRequest(RequestDescriptor requestDescriptor, int n, KeyValPair[] keyValPairArray, KeyValPair[] keyValPairArray2, byte[] byArray, ExtOnlineCoreServiceReply extOnlineCoreServiceReply) {
    }

    default public void requestUpdateKeyStore(ExtOnlineCoreServiceReply extOnlineCoreServiceReply) {
    }

    default public void registerForCredentialUpdates(int[] nArray, ExtOnlineCoreServiceReply extOnlineCoreServiceReply) {
    }

    default public void registerForLicenseUpdates(String[] stringArray, ExtOnlineCoreServiceReply extOnlineCoreServiceReply) {
    }
}

