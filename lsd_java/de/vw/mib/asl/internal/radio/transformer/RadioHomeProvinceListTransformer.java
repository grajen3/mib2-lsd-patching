/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioCountryListCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.AbstractRadioHomeProvinceListTransformer;

public class RadioHomeProvinceListTransformer
extends AbstractRadioHomeProvinceListTransformer
implements ItemTransformer {
    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 0: {
                return ((RadioCountryListCollector)object).countryId;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        return false;
    }
}

