/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence;

import de.vw.mib.asl.framework.api.persistence.IAslPersistenceAsyncApi;
import de.vw.mib.asl.framework.api.persistence.PersistenceReadCallback;

public interface AslPersistenceAsyncApi
extends IAslPersistenceAsyncApi {
    default public void flushDatabase(int n, int n2) {
    }

    default public void readInt(int n, int n2, int n3, long l) {
    }

    default public void readString(int n, int n2, int n3, long l) {
    }

    default public void readByteArray(int n, int n2, int n3, long l) {
    }

    default public void readByteArray(PersistenceReadCallback persistenceReadCallback, int n, long l) {
    }

    default public void readStringArray(int n, int n2, int n3, long l) {
    }

    default public void writeInt(int n, int n2, int n3, long l, int n4) {
    }

    default public void writeString(int n, int n2, int n3, long l, String string) {
    }

    default public void writeByteArray(int n, int n2, int n3, long l, byte[] byArray) {
    }

    default public void writeStringArray(int n, long l, String[] stringArray, int n2, int n3, boolean bl) {
    }
}

