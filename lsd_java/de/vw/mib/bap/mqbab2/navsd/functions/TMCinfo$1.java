/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import java.util.LinkedHashMap;
import java.util.Map$Entry;

final class TMCinfo$1
extends LinkedHashMap {
    private static final long serialVersionUID;

    TMCinfo$1() {
    }

    @Override
    protected boolean removeEldestEntry(Map$Entry map$Entry) {
        return this.size() > 20;
    }
}

