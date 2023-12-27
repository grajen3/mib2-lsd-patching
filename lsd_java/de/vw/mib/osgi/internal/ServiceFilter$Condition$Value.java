/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi.internal;

class ServiceFilter$Condition$Value {
    private final String serviceName;

    ServiceFilter$Condition$Value(String string) {
        this.serviceName = string;
    }

    String getServiceName() {
        return this.serviceName;
    }

    boolean isEquals(String string) {
        if (string == null) {
            return false;
        }
        return string.equals(this.serviceName);
    }
}

