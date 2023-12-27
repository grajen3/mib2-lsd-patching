/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpa.transformer;

import de.vw.mib.asl.internal.car.fpa.transformer.CarFpaFunctionListCollector;
import generated.de.vw.mib.asl.internal.car.fpa.transformer.AbstractCarFPAFunctionOptionMaskTransformer;

public class CarFPAFunctionOptionMaskTransformer
extends AbstractCarFPAFunctionOptionMaskTransformer {
    @Override
    public boolean[] getFlagVector(int n, Object object) {
        switch (n) {
            case 0: {
                return ((CarFpaFunctionListCollector)object).optionMask;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain boolean-array values.");
    }
}

