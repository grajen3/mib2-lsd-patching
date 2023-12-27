/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ugdo.transformer;

import de.vw.mib.asl.internal.ugdo.transformer.UGDOCollector;
import generated.de.vw.mib.asl.internal.ugdo.transformer.AbstractUGDOKeyListTransformer;

public class UGDOKeyListTransformer
extends AbstractUGDOKeyListTransformer {
    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 1: {
                return ((UGDOCollector)object).learnedState;
            }
            case 5: {
                return ((UGDOCollector)object).nameState;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain integer values.");
    }

    @Override
    public long getLong(int n, Object object) {
        switch (n) {
            case 3: {
                return (long)((UGDOCollector)object).positionLatitude;
            }
            case 4: {
                return (long)((UGDOCollector)object).PositionLongitude;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain long values.");
    }

    @Override
    public String getString(int n, Object object) {
        switch (n) {
            case 2: {
                return ((UGDOCollector)object).KeyName;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain String values.");
    }
}

