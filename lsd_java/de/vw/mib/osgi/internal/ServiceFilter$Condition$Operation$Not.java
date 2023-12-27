/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi.internal;

import de.vw.mib.osgi.internal.ServiceFilter$Condition;
import de.vw.mib.osgi.internal.ServiceFilter$Condition$Operation;
import java.util.Dictionary;

class ServiceFilter$Condition$Operation$Not
extends ServiceFilter$Condition$Operation {
    ServiceFilter$Condition$Operation$Not() {
    }

    @Override
    boolean hasDistinctServiceInterfaces() {
        return false;
    }

    @Override
    boolean isFulfilled(Dictionary dictionary) {
        return !((ServiceFilter$Condition)this.terms.get(0)).isFulfilled(dictionary);
    }

    @Override
    boolean isServiceInterfaceList() {
        return false;
    }
}

