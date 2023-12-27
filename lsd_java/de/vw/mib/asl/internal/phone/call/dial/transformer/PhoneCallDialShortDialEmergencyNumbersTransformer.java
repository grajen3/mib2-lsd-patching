/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.call.dial.transformer;

import de.vw.mib.asl.internal.phone.call.dial.transformer.PhoneCallDialShortDialEmergencyNumbersCollector;
import generated.de.vw.mib.asl.internal.phone.call.dial.transformer.AbstractPhoneCallDialShortDialEmergencyNumbersTransformer;

public class PhoneCallDialShortDialEmergencyNumbersTransformer
extends AbstractPhoneCallDialShortDialEmergencyNumbersTransformer {
    @Override
    public String getString(int n, Object object) {
        PhoneCallDialShortDialEmergencyNumbersCollector phoneCallDialShortDialEmergencyNumbersCollector = (PhoneCallDialShortDialEmergencyNumbersCollector)object;
        switch (n) {
            case 0: {
                return phoneCallDialShortDialEmergencyNumbersCollector.shortDialEmergencyNumbers;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

