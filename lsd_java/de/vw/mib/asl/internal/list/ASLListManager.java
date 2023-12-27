/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.impl.DirectWindowList;
import de.vw.mib.asl.internal.list.impl.GenericASLList;

public interface ASLListManager {
    default public GenericASLList getGenericASLList(int n) {
    }

    default public DirectWindowList getDirectWindowList(int n) {
    }

    default public ASLList getASLList(int n) {
    }
}

