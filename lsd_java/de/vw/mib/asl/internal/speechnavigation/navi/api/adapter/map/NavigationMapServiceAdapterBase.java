/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.map;

import de.vw.mib.asl.api.navigation.map.NavigationMapListenerAdapter;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;

public abstract class NavigationMapServiceAdapterBase
extends NavigationMapListenerAdapter {
    private static final IntIntMap MAP_TYPES_MAPPER = new IntIntOptHashMap(3);

    @Override
    public void updateMapType(int n) {
        AppLogger.trace(this, new StringBuffer().append(".updateMapType( mapType = ").append(n).append(" )").toString());
        Framework.updateUIValue(-1878510592, MAP_TYPES_MAPPER.get(n));
    }

    static {
        MAP_TYPES_MAPPER.put(0, 0);
        MAP_TYPES_MAPPER.put(1, 0);
        MAP_TYPES_MAPPER.put(2, 1);
    }
}

