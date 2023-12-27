/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal;

import de.vw.mib.asl.framework.api.persistence.PersistenceNamespace;

public final class PrivateUtil {
    private PrivateUtil() {
    }

    public static int getIndexOfNamespaceInArray(int n) {
        int n2 = -1;
        for (int i2 = 0; i2 < PersistenceNamespace.NAMESPACEIDS.length; ++i2) {
            if (PersistenceNamespace.NAMESPACEIDS[i2] != n) continue;
            n2 = i2;
            break;
        }
        return n2;
    }

    public static int getIndexOfDiagNamespaceInArray(int n) {
        int n2 = -1;
        for (int i2 = 0; i2 < PersistenceNamespace.DIAG_NAMESPACEIDS.length; ++i2) {
            if (PersistenceNamespace.DIAG_NAMESPACEIDS[i2] != n) continue;
            n2 = i2;
            break;
        }
        return n2;
    }

    public static long getKeyOfNamespaceByIndex(int n, int n2) {
        return PersistenceNamespace.NAMESPACES[n][n2][1];
    }

    public static int getTypeOfKeyInNamespace(int n, int n2) {
        return PersistenceNamespace.NAMESPACES[n][n2][0];
    }

    public static int getNumberOfNamespaces() {
        return PersistenceNamespace.NAMESPACES.length;
    }

    public static int getNumberOfKeysInNamespace(int n) {
        if (n >= 0 && n < PersistenceNamespace.NAMESPACES.length) {
            return PersistenceNamespace.NAMESPACES[n].length;
        }
        return -1;
    }
}

