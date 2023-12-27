/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import de.vw.mib.asl.internal.radio.transformer.DABServiceListItemInfoCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.AbstractRadioDABServiceListItemInfoTransformer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.ServiceInfo;

public class RadioDABServiceListItemInfoTransformer
extends AbstractRadioDABServiceListItemInfoTransformer
implements ItemTransformer {
    static final int INVALID_LONG_ATTRIBUTE;

    @Override
    public boolean getBoolean(int n, Object object) {
        DABServiceListItemInfoCollector dABServiceListItemInfoCollector = (DABServiceListItemInfoCollector)object;
        switch (n) {
            case 2: {
                return false;
            }
            case 1: {
                return dABServiceListItemInfoCollector.isSlsAvailable();
            }
            case 9: {
                return dABServiceListItemInfoCollector.getTpState();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        DABServiceListItemInfoCollector dABServiceListItemInfoCollector = (DABServiceListItemInfoCollector)object;
        switch (n) {
            case 8: {
                return 0;
            }
            case 10: {
                return dABServiceListItemInfoCollector.getState();
            }
            case 11: {
                return dABServiceListItemInfoCollector.getAdditionalServiceState();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        DABServiceListItemInfoCollector dABServiceListItemInfoCollector = (DABServiceListItemInfoCollector)object;
        if (dABServiceListItemInfoCollector == null) {
            return "";
        }
        switch (n) {
            case 4: {
                if (dABServiceListItemInfoCollector.getName() == null) {
                    return "";
                }
                return dABServiceListItemInfoCollector.getName();
            }
            case 0: {
                if (dABServiceListItemInfoCollector.getAutocompare() > 0) {
                    return new StringBuffer().append(String.valueOf(dABServiceListItemInfoCollector.getAutocompare())).append(" ").toString();
                }
                return "";
            }
            case 6: {
                return dABServiceListItemInfoCollector.getName();
            }
            case 5: {
                return dABServiceListItemInfoCollector.getShortName();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public long getLong(int n, Object object) {
        DABServiceListItemInfoCollector dABServiceListItemInfoCollector = (DABServiceListItemInfoCollector)object;
        if (dABServiceListItemInfoCollector == null) {
            return -1L;
        }
        ServiceInfo serviceInfo = dABServiceListItemInfoCollector.getService();
        if (serviceInfo == null) {
            return -1L;
        }
        switch (n) {
            case 7: {
                return DabTunerState.calcServiceId(serviceInfo);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        switch (n) {
            case 3: {
                return null;
            }
        }
        throw new IllegalArgumentException();
    }
}

