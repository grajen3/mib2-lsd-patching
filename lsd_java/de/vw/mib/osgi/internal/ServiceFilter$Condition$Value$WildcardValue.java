/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi.internal;

import de.vw.mib.osgi.internal.ServiceFilter$Condition$Value;
import org.osgi.framework.InvalidSyntaxException;

class ServiceFilter$Condition$Value$WildcardValue
extends ServiceFilter$Condition$Value {
    private String prefix;
    private String suffix;

    ServiceFilter$Condition$Value$WildcardValue(String string, String string2) {
        super(null);
        int n = string2.indexOf(42);
        this.prefix = string2.substring(0, n);
        this.suffix = string2.substring(n + 1);
        if (this.suffix.indexOf(42) != -1) {
            throw new InvalidSyntaxException("filter syntax invalid: only one wildcard symbol allowed per value", string);
        }
    }

    @Override
    boolean isEquals(String string) {
        if (string == null) {
            return false;
        }
        return string.length() >= this.prefix.length() + this.suffix.length() && string.startsWith(this.prefix) && string.endsWith(this.suffix);
    }

    public String toString() {
        return new StringBuffer().append(this.prefix).append(this.suffix).toString();
    }
}

