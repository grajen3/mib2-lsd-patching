/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.service.transformer;

import generated.de.vw.mib.asl.internal.car.service.transformer.AbstractCarServiceStartStopListProhibitReason_1Transformer;

public class CarServiceStartStopListProhibitReason_1Transformer
extends AbstractCarServiceStartStopListProhibitReason_1Transformer {
    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 0: {
                return (Integer)object;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contains Integer values.");
    }
}

