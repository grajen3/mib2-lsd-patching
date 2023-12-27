/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.impl;

import de.vw.mib.asi.impl.ASIServiceRegistryImpl;
import de.vw.mib.asi.instance.ASIInstanceAdapter;
import de.vw.mib.asi.instance.ASIInstanceResponse;

class ASIInstanceImpl
extends ASIInstanceAdapter {
    private final ASIServiceRegistryImpl registry;

    ASIInstanceImpl(ASIServiceRegistryImpl aSIServiceRegistryImpl) {
        this.registry = aSIServiceRegistryImpl;
    }

    @Override
    public void requestInstanceId(String string, String string2, ASIInstanceResponse aSIInstanceResponse) {
        this.registry.requestASIInstanceId(string, string2, aSIInstanceResponse);
    }
}

