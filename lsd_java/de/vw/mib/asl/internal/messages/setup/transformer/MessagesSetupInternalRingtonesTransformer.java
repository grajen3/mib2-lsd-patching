/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.setup.transformer;

import generated.de.vw.mib.asl.internal.messages.setup.transformer.AbstractMessagesSetupInternalRingtonesTransformer;

public class MessagesSetupInternalRingtonesTransformer
extends AbstractMessagesSetupInternalRingtonesTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        Boolean bl = (Boolean)object;
        switch (n) {
            case 0: {
                return bl;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

