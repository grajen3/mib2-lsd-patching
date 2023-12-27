/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.radio.transformer.DABAdditionalServicesListCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.AbstractRadioDABAdditionalServicesListTransformer;

public class RadioDABAdditionalServicesListTransformer
extends AbstractRadioDABAdditionalServicesListTransformer
implements ItemTransformer {
    static final long INVALID_LONG_ATTRIBUTE;

    @Override
    public String getString(int n, Object object) {
        DABAdditionalServicesListCollector dABAdditionalServicesListCollector = (DABAdditionalServicesListCollector)object;
        switch (n) {
            case 1: {
                return dABAdditionalServicesListCollector.getName();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public long getLong(int n, Object object) {
        return 0L;
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        DABAdditionalServicesListCollector dABAdditionalServicesListCollector = (DABAdditionalServicesListCollector)object;
        switch (n) {
            case 2: {
                return dABAdditionalServicesListCollector.supportsSlideshow();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        DABAdditionalServicesListCollector dABAdditionalServicesListCollector = (DABAdditionalServicesListCollector)object;
        switch (n) {
            case 3: {
                return dABAdditionalServicesListCollector.getCurrentReceptionState();
            }
        }
        throw new IllegalArgumentException();
    }
}

