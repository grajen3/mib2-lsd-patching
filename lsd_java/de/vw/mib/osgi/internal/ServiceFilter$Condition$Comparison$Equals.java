/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi.internal;

import de.vw.mib.osgi.internal.ServiceFilter$Condition$Comparison;
import java.util.Dictionary;

class ServiceFilter$Condition$Comparison$Equals
extends ServiceFilter$Condition$Comparison {
    ServiceFilter$Condition$Comparison$Equals() {
    }

    @Override
    boolean isFulfilled(Dictionary dictionary) {
        if (this.isObjectClassProp) {
            String[] stringArray = (String[])dictionary.get(this.property);
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                if (!this.value.isEquals(stringArray[i2])) continue;
                return true;
            }
            return false;
        }
        Object object = dictionary.get(this.property);
        if (object == null) {
            return false;
        }
        return this.value.isEquals(object.toString());
    }
}

