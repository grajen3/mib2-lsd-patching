/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist.impl;

import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingAudioProxy;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DataMediaBrowserSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombifastlist.DataMediaBrowser;

class DSIFastListScrollingAudioProxy$1
implements ISerializable {
    private final /* synthetic */ long val$tag;
    private final /* synthetic */ int val$posY;
    private final /* synthetic */ DataMediaBrowser[] val$data;
    private final /* synthetic */ DSIFastListScrollingAudioProxy this$0;

    DSIFastListScrollingAudioProxy$1(DSIFastListScrollingAudioProxy dSIFastListScrollingAudioProxy, long l, int n, DataMediaBrowser[] dataMediaBrowserArray) {
        this.this$0 = dSIFastListScrollingAudioProxy;
        this.val$tag = l;
        this.val$posY = n;
        this.val$data = dataMediaBrowserArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt64(this.val$tag);
        iSerializer.putInt32(this.val$posY);
        DataMediaBrowserSerializer.putOptionalDataMediaBrowserVarArray(iSerializer, this.val$data);
    }
}

