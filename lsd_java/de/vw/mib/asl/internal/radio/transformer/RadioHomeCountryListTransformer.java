/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioCountryListCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.AbstractRadioHomeCountryListTransformer;

public class RadioHomeCountryListTransformer
extends AbstractRadioHomeCountryListTransformer
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
    public String getString(int n, Object object) {
        switch (n) {
            case 4: {
                return ((RadioCountryListCollector)object).countryRegionName;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            case 1: {
                return ((RadioCountryListCollector)object).itemEnabled;
            }
            case 3: {
                return ((RadioCountryListCollector)object).itemActivated;
            }
        }
        throw new IllegalArgumentException();
    }
}

