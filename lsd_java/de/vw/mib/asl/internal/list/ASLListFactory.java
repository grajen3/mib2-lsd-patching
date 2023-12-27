/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list;

import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.DirectWindowList;
import de.vw.mib.asl.internal.list.impl.GenericASLList;

public interface ASLListFactory {
    default public GenericASLList createGenericASLList(ItemTransformer itemTransformer, int n, String string, String string2) {
    }

    default public DirectWindowList createDirectWindowList(ItemTransformer itemTransformer, int n, String string, String string2) {
    }

    default public ItemTransformer getDeprecatedTransformer(int n, String string, String string2, String string3, String string4) {
    }
}

