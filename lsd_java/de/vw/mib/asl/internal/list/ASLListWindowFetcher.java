/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list;

import de.vw.mib.asl.internal.list.ASLList;

public interface ASLListWindowFetcher {
    default public void fetchFirstItems(ASLList aSLList) {
    }

    default public void fetchWindow(ASLList aSLList, int n, Object object, int n2) {
    }
}

