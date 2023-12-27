/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.bordcomputer.transformer;

import de.vw.mib.asl.internal.car.bordcomputer.transformer.CarBCMenuValueHolder;
import generated.de.vw.mib.asl.internal.car.bordcomputer.transformer.AbstractCarBordComputerBCMenu2_BITransformer;

public class CarBordComputerBCMenu2_BITransformer
extends AbstractCarBordComputerBCMenu2_BITransformer {
    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 2: {
                return ((CarBCMenuValueHolder)object).itemUnit;
            }
            case 0: {
                return ((CarBCMenuValueHolder)object).value;
            }
            case 1: {
                return ((CarBCMenuValueHolder)object).valueDecimal;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain int values.");
    }
}

