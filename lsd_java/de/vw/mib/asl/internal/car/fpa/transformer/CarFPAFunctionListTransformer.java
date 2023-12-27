/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpa.transformer;

import de.vw.mib.asl.internal.car.fpa.transformer.CarFpaFunctionListCollector;
import generated.de.vw.mib.asl.internal.car.fpa.transformer.AbstractCarFPAFunctionListTransformer;

public class CarFPAFunctionListTransformer
extends AbstractCarFPAFunctionListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            case 0: {
                return ((CarFpaFunctionListCollector)object).isFunctionAvailable;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain boolean values.");
    }
}

