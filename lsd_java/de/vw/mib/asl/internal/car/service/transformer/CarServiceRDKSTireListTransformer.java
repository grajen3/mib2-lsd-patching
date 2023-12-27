/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.service.transformer;

import generated.de.vw.mib.asl.internal.car.service.transformer.AbstractCarServiceRDKSTireListTransformer;

public class CarServiceRDKSTireListTransformer
extends AbstractCarServiceRDKSTireListTransformer {
    @Override
    public String getString(int n, Object object) {
        switch (n) {
            case 0: {
                return object.toString();
            }
        }
        throw new IllegalArgumentException("The given columnID does not contains String values.");
    }
}

