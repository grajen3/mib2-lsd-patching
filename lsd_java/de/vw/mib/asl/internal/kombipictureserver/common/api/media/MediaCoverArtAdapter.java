/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.api.media;

import de.vw.mib.asl.internal.kombipictureserver.common.adapter.DataPoolAdapter;
import de.vw.mib.asl.internal.kombipictureserver.common.api.media.asl.MediaCoverArtDelegate;
import de.vw.mib.asl.internal.kombipictureserver.common.api.media.asl.MediaCoverArtService;
import de.vw.mib.asl.internal.kombipictureserver.common.services.AslServiceRegistry;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;

public class MediaCoverArtAdapter
extends DataPoolAdapter
implements AslServiceRegistry,
MediaCoverArtService {
    private static final int[] MEDIA_COVER_ART_LIST_IDS = new int[]{58};
    static /* synthetic */ Class class$de$vw$mib$asl$internal$kombipictureserver$common$api$media$asl$MediaCoverArtService;

    public static Class getServiceClass() {
        return class$de$vw$mib$asl$internal$kombipictureserver$common$api$media$asl$MediaCoverArtService == null ? (class$de$vw$mib$asl$internal$kombipictureserver$common$api$media$asl$MediaCoverArtService = MediaCoverArtAdapter.class$("de.vw.mib.asl.internal.kombipictureserver.common.api.media.asl.MediaCoverArtService")) : class$de$vw$mib$asl$internal$kombipictureserver$common$api$media$asl$MediaCoverArtService;
    }

    @Override
    protected int[] getPropertyIds() {
        return null;
    }

    @Override
    protected int[] getListIds() {
        return MEDIA_COVER_ART_LIST_IDS;
    }

    @Override
    public void datapoolValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    protected void listValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredServiceDelegates(n);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                MediaCoverArtDelegate mediaCoverArtDelegate = (MediaCoverArtDelegate)iterator.next();
                mediaCoverArtDelegate.updateMediaCoverArt(this, n);
            }
        }
    }

    @Override
    public ResourceLocator getCoverArt() {
        return MediaCoverArtAdapter.getResourceLocatorListValue(58, 2);
    }

    @Override
    public boolean isCoverValid() {
        return MediaCoverArtAdapter.getBooleanListValue(58, 3);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

