/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi.internal;

import java.util.Dictionary;

abstract class ServiceFilter$Condition {
    ServiceFilter$Condition() {
    }

    abstract boolean hasDistinctServiceInterfaces() {
    }

    abstract boolean isFulfilled(Dictionary dictionary) {
    }

    abstract boolean isServiceInterfaceList() {
    }
}

