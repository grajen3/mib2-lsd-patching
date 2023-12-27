/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.radio.RadioDabTraceUtil;
import de.vw.mib.asl.internal.radio.transformer.DABStationListInfoCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.AbstractRadioDABStationListInfoTransformer;

public class RadioDABStationListInfoTransformer
extends AbstractRadioDABStationListInfoTransformer
implements ItemTransformer {
    static final long INVALID_LONG_ATTRIBUTE;

    @Override
    public boolean getBoolean(int n, Object object) {
        DABStationListInfoCollector dABStationListInfoCollector = (DABStationListInfoCollector)object;
        switch (n) {
            case 4: {
                return dABStationListInfoCollector.getTPState();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        DABStationListInfoCollector dABStationListInfoCollector = (DABStationListInfoCollector)object;
        if (dABStationListInfoCollector == null) {
            RadioDabTraceUtil.errorLogDab(new StringBuffer().append("RadioDABStationListInfoTransformer.getInt() columnID: ").append(n).append(" object is null").toString());
            return -1;
        }
        switch (n) {
            case 2: {
                return dABStationListInfoCollector.getReceptionState();
            }
            case 3: {
                return dABStationListInfoCollector.getEnsembleState();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        DABStationListInfoCollector dABStationListInfoCollector = (DABStationListInfoCollector)object;
        switch (n) {
            case 0: {
                return dABStationListInfoCollector == null ? "null" : dABStationListInfoCollector.getName();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public long getLong(int n, Object object) {
        DABStationListInfoCollector dABStationListInfoCollector = (DABStationListInfoCollector)object;
        switch (n) {
            case 1: {
                return dABStationListInfoCollector.getEnsembleId();
            }
        }
        return 0L;
    }
}

