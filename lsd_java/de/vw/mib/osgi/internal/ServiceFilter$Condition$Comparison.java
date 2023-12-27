/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi.internal;

import de.vw.mib.osgi.internal.ServiceFilter$Condition;
import de.vw.mib.osgi.internal.ServiceFilter$Condition$Value;
import de.vw.mib.osgi.internal.ServiceFilter$Condition$Value$WildcardValue;

abstract class ServiceFilter$Condition$Comparison
extends ServiceFilter$Condition {
    boolean isDistinctObjectClassProp = false;
    boolean isObjectClassProp = false;
    String property;
    ServiceFilter$Condition$Value value;

    ServiceFilter$Condition$Comparison() {
    }

    String getServiceInterface() {
        if (this.isDistinctObjectClassProp) {
            return this.value.getServiceName();
        }
        return null;
    }

    @Override
    boolean hasDistinctServiceInterfaces() {
        return this.isDistinctObjectClassProp;
    }

    @Override
    boolean isServiceInterfaceList() {
        return this.isDistinctObjectClassProp;
    }

    void setProperty(String string) {
        this.property = string;
        if (this.property.equals("objectClass")) {
            this.isObjectClassProp = true;
            this.isDistinctObjectClassProp = true;
        }
    }

    void setValue(ServiceFilter$Condition$Value serviceFilter$Condition$Value) {
        this.value = serviceFilter$Condition$Value;
        if (this.value instanceof ServiceFilter$Condition$Value$WildcardValue) {
            this.isDistinctObjectClassProp = false;
        }
    }
}

