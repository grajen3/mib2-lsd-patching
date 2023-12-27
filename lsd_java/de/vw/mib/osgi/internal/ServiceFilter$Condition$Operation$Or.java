/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi.internal;

import de.vw.mib.osgi.internal.ServiceFilter$Condition;
import de.vw.mib.osgi.internal.ServiceFilter$Condition$Operation;
import java.util.Dictionary;

class ServiceFilter$Condition$Operation$Or
extends ServiceFilter$Condition$Operation {
    ServiceFilter$Condition$Operation$Or() {
    }

    @Override
    boolean hasDistinctServiceInterfaces() {
        int n = this.terms.size();
        for (int i2 = 0; i2 < n; ++i2) {
            if (((ServiceFilter$Condition)this.terms.get(i2)).hasDistinctServiceInterfaces()) continue;
            return false;
        }
        return true;
    }

    @Override
    boolean isFulfilled(Dictionary dictionary) {
        int n = this.terms.size();
        for (int i2 = 0; i2 < n; ++i2) {
            if (!((ServiceFilter$Condition)this.terms.get(i2)).isFulfilled(dictionary)) continue;
            return true;
        }
        return false;
    }

    @Override
    boolean isServiceInterfaceList() {
        int n = this.terms.size();
        for (int i2 = 0; i2 < n; ++i2) {
            if (((ServiceFilter$Condition)this.terms.get(i2)).isServiceInterfaceList()) continue;
            return false;
        }
        return true;
    }
}

