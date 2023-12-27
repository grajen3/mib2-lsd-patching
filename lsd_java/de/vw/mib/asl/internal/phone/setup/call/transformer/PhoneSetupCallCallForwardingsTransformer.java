/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.setup.call.transformer;

import de.vw.mib.asl.internal.phone.setup.call.transformer.PhoneSetupCallCallForwardingsCollector;
import generated.de.vw.mib.asl.internal.phone.setup.call.transformer.AbstractPhoneSetupCallCallForwardingsTransformer;

public class PhoneSetupCallCallForwardingsTransformer
extends AbstractPhoneSetupCallCallForwardingsTransformer {
    @Override
    public String getString(int n, Object object) {
        PhoneSetupCallCallForwardingsCollector phoneSetupCallCallForwardingsCollector = (PhoneSetupCallCallForwardingsCollector)object;
        switch (n) {
            case 1: {
                return phoneSetupCallCallForwardingsCollector.number;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public int getInt(int n, Object object) {
        PhoneSetupCallCallForwardingsCollector phoneSetupCallCallForwardingsCollector = (PhoneSetupCallCallForwardingsCollector)object;
        switch (n) {
            case 0: {
                return phoneSetupCallCallForwardingsCollector.id;
            }
            case 2: {
                return phoneSetupCallCallForwardingsCollector.state;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

