/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi.internal;

import de.vw.mib.osgi.internal.ServiceFilter$Condition;
import java.util.ArrayList;
import java.util.List;

abstract class ServiceFilter$Condition$Operation
extends ServiceFilter$Condition {
    List terms = new ArrayList();

    ServiceFilter$Condition$Operation() {
    }

    void addTerm(ServiceFilter$Condition serviceFilter$Condition) {
        this.terms.add(serviceFilter$Condition);
    }
}

