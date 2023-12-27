/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list.impl;

import de.vw.mib.asl.clientapi.list.ASLClientList;
import de.vw.mib.asl.clientapi.list.ASLClientListFactory;
import de.vw.mib.asl.clientapi.list.impl.ASLClientListImpl;
import de.vw.mib.asl.clientapi.list.impl.Services;
import de.vw.mib.list.HMIList;
import de.vw.mib.list.HMIListRegistry;

class ASLClientListFactoryImpl
implements ASLClientListFactory {
    private final Services services;
    private final HMIListRegistry listRegistry;

    ASLClientListFactoryImpl(Services services, HMIListRegistry hMIListRegistry) {
        this.services = services;
        this.listRegistry = hMIListRegistry;
    }

    @Override
    public ASLClientList createASLClientList(Object object) {
        HMIList hMIList = this.listRegistry.getHMIList(object);
        ASLClientListImpl aSLClientListImpl = new ASLClientListImpl(this.services, hMIList);
        this.listRegistry.setHMIListDataProvider(object, aSLClientListImpl.getDataProvider());
        return aSLClientListImpl;
    }
}

