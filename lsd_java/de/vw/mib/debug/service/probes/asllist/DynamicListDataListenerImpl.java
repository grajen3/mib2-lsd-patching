/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.asllist;

import de.vw.mib.debug.service.probes.asllist.ASLListCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.list.DynamicListData;
import de.vw.mib.list.DynamicListDataDebug;
import de.vw.mib.list.DynamicListDataListener;
import de.vw.mib.log4mib.Logger;

final class DynamicListDataListenerImpl
implements DynamicListDataListener {
    private final Logger logger;
    private final DynamicListDataDebug list;
    private final int listId;
    private ProbeSystemServices probeSystemServices;

    DynamicListDataListenerImpl(DynamicListData dynamicListData, int n, Logger logger, ProbeSystemServices probeSystemServices) {
        this.logger = logger;
        this.probeSystemServices = probeSystemServices;
        this.list = (DynamicListDataDebug)((Object)dynamicListData);
        this.listId = n;
        this.initialValueUpdate();
    }

    @Override
    public void activatedIndexChanged(int n) {
    }

    @Override
    public void itemsChanged(int n, int n2) {
        this.sendRow(0, this.list.getSize());
    }

    @Override
    public void itemsInserted(int n, int n2, int n3) {
        this.sendRow(0, this.list.getSize());
    }

    @Override
    public void itemsRemoved(int n, int n2, int n3) {
        this.sendRow(0, this.list.getSize());
    }

    @Override
    public void listChanged(int n) {
        this.sendRow(0, n);
    }

    @Override
    public void listContentChanged() {
        this.sendRow(0, this.list.getSize());
    }

    @Override
    public void stringIndexChanged() {
    }

    private void sendRow(int n, int n2) {
        try {
            if (n2 == 0) {
                ASLListCodec aSLListCodec = (ASLListCodec)this.probeSystemServices.borrowCodec();
                aSLListCodec.encodeListUpdate(this.listId, 0, this.list.getRowValuesAsStrings(0), this.list.getSize());
                this.probeSystemServices.releaseCodec(aSLListCodec);
            }
            for (int i2 = n; i2 < n2; ++i2) {
                ASLListCodec aSLListCodec = (ASLListCodec)this.probeSystemServices.borrowCodec();
                aSLListCodec.encodeListUpdate(this.listId, i2, this.list.getRowValuesAsStrings(i2), this.list.getSize());
                this.probeSystemServices.releaseCodec(aSLListCodec);
            }
        }
        catch (Exception exception) {
            ASLListCodec aSLListCodec = (ASLListCodec)this.probeSystemServices.borrowCodec();
            aSLListCodec.encodeListUpdate(this.listId, -1, null, -1);
            this.probeSystemServices.releaseCodec(aSLListCodec);
            this.logger.error(4, "Error encoding AslListUpdate", exception);
        }
    }

    void initialValueUpdate() {
        this.sendRow(0, this.list.getSize());
    }
}

