/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.transformer;

import de.vw.mib.asl.internal.car.fpk.usecases.content.setup.model.DisplayElement;
import generated.de.vw.mib.asl.internal.car.fpk.transformer.AbstractCarFPKAvailableContentDisplay2_1Transformer;

public class CarFPKAvailableContentDisplay2_1Transformer
extends AbstractCarFPKAvailableContentDisplay2_1Transformer {
    @Override
    public long getLong(int n, Object object) {
        return ((DisplayElement)object).aslId;
    }
}

