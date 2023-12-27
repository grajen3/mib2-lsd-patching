/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.call.dial.transformer;

import de.vw.mib.asl.internal.phone.call.dial.transformer.PhoneCallDialShortDialCollector;
import generated.de.vw.mib.asl.internal.phone.call.dial.transformer.AbstractPhoneCallDialShortDialTransformer;

public class PhoneCallDialShortDialTransformer
extends AbstractPhoneCallDialShortDialTransformer {
    @Override
    public int getInt(int n, Object object) {
        PhoneCallDialShortDialCollector phoneCallDialShortDialCollector = (PhoneCallDialShortDialCollector)object;
        switch (n) {
            case 0: {
                return phoneCallDialShortDialCollector.type;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

