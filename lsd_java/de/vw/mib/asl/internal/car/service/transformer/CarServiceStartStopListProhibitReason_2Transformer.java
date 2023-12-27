/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.service.transformer;

import generated.de.vw.mib.asl.internal.car.service.transformer.AbstractCarServiceStartStopListProhibitReason_2Transformer;

public class CarServiceStartStopListProhibitReason_2Transformer
extends AbstractCarServiceStartStopListProhibitReason_2Transformer {
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

