/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2;

public interface PersistenceKeyProvider {
    public static final int UNKNOWN_NAMESPACE;

    default public int[] retrieveCommonPersistableIds(int n) {
    }

    default public int[] retrieveUserSpecificPersistableIds(int n) {
    }

    default public int retrieveNamespace(String string) {
    }

    default public long retrieveVersion(int n) {
    }

    default public int[] retrieveNamespaceIds() {
    }

    default public String retrieveNamespaceName(int n) {
    }
}

