/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreInterfaces.adapter;

import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapter;

public interface CoreServiceAdapterRegistration {
    default public void registerAdapter(int n, int n2, CoreServiceAdapter coreServiceAdapter) {
    }

    default public void unRegisterAdapter(int n) {
    }

    default public CoreServiceAdapter[] getAdapterList() {
    }

    default public CoreServiceAdapter getMainAdapter() {
    }

    default public int getMainAdapterID() {
    }

    default public CoreServiceAdapter getAdapterWithID(int n) {
    }

    default public void isReady(int n) {
    }

    default public CoreServiceAdapter[] getAdapterListWithSupportedMethod(int n) {
    }
}

