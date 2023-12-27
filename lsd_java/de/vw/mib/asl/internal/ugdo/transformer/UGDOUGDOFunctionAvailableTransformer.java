/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ugdo.transformer;

import de.vw.mib.asl.internal.ugdo.transformer.UgdoFunctionCollector;
import generated.de.vw.mib.asl.internal.ugdo.transformer.AbstractUGDOUGDOFunctionAvailableTransformer;

public class UGDOUGDOFunctionAvailableTransformer
extends AbstractUGDOUGDOFunctionAvailableTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            case 0: {
                return ((UgdoFunctionCollector)object).functionAvailable;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain boolean values.");
    }

    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 1: {
                return ((UgdoFunctionCollector)object).functionReason;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain integer values.");
    }
}

