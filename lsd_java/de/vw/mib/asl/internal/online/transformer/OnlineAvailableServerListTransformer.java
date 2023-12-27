/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.transformer;

import generated.de.vw.mib.asl.internal.online.transformer.AbstractOnlineAvailableServerListTransformer;

public class OnlineAvailableServerListTransformer
extends AbstractOnlineAvailableServerListTransformer {
    @Override
    public String getString(int n, Object object) {
        String string = (String)object;
        switch (n) {
            case 0: {
                return string;
            }
        }
        throw new IllegalArgumentException();
    }
}

