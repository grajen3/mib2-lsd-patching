/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioTIMListCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.AbstractRadioTMListTransformer;

public class RadioTMListTransformer
extends AbstractRadioTMListTransformer
implements ItemTransformer {
    @Override
    public int getInt(int n, Object object) {
        RadioTIMListCollector radioTIMListCollector = (RadioTIMListCollector)object;
        switch (n) {
            case 3: {
                return radioTIMListCollector.getMessage().recordTimeDay;
            }
            case 4: {
                return radioTIMListCollector.getMessage().recordTimeMonth;
            }
            case 5: {
                return radioTIMListCollector.getMessage().recordTimeYear;
            }
            case 6: {
                return radioTIMListCollector.getMessage().lengthMinutes * 1625948160 + radioTIMListCollector.getMessage().lengthSeconds * 1000;
            }
            case 1: {
                return radioTIMListCollector.getMessage().recordTimeHour;
            }
            case 2: {
                return radioTIMListCollector.getMessage().recordTimeMinutes;
            }
            case 7: {
                return radioTIMListCollector.getMessage().getMessageID();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        RadioTIMListCollector radioTIMListCollector = (RadioTIMListCollector)object;
        switch (n) {
            case 0: {
                return radioTIMListCollector.getMessage().name;
            }
        }
        throw new IllegalArgumentException();
    }
}

