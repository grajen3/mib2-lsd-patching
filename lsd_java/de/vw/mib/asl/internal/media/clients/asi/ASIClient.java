/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.asi;

import de.esolutions.fw.comm.asi.hmisync.media.MediaActiveSourceState;
import de.esolutions.fw.comm.asi.hmisync.media.MediaPlayTime;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.vw.mib.asi.ASIPropertiesImpl;
import de.vw.mib.asi.ASIServiceProvider;
import de.vw.mib.asi.ASIServiceRegistry;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.asi.MediaASIServicesImpl;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import de.vw.mib.util.Util;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public class ASIClient
implements ServiceListener {
    private static final MediaASIServicesImpl MEDIA_ASI_SERVICES_IMPL = new MediaASIServicesImpl();
    private static ASIPropertiesImpl asiProperties = new ASIPropertiesImpl();
    static /* synthetic */ Class class$de$vw$mib$asi$ASIServiceRegistry;
    static /* synthetic */ Class class$de$vw$mib$asi$ASIServiceProvider;
    static /* synthetic */ Class class$de$vw$mib$asi$media$ASIMedia;

    public ASIClient() {
        this.registerServiceListener(ServiceManager.bundleContext);
    }

    private void registerServiceListener(BundleContext bundleContext) {
        StringBuffer stringBuffer = new StringBuffer(98);
        stringBuffer.append("(|");
        stringBuffer.append("(").append("objectClass").append("=").append((class$de$vw$mib$asi$ASIServiceRegistry == null ? (class$de$vw$mib$asi$ASIServiceRegistry = ASIClient.class$("de.vw.mib.asi.ASIServiceRegistry")) : class$de$vw$mib$asi$ASIServiceRegistry).getName()).append(")");
        stringBuffer.append("(").append("objectClass").append("=").append((class$de$vw$mib$asi$ASIServiceProvider == null ? (class$de$vw$mib$asi$ASIServiceProvider = ASIClient.class$("de.vw.mib.asi.ASIServiceProvider")) : class$de$vw$mib$asi$ASIServiceProvider).getName()).append(")");
        stringBuffer.append(")");
        String string = stringBuffer.toString();
        bundleContext.addServiceListener(this, string);
        ServiceReference[] serviceReferenceArray = bundleContext.getServiceReferences(null, string);
        for (int i2 = 0; serviceReferenceArray != null && i2 < serviceReferenceArray.length; ++i2) {
            this.serviceChanged(new ServiceEvent(1, serviceReferenceArray[i2]));
        }
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        switch (serviceEvent.getType()) {
            case 1: {
                Object object = ServiceManager.bundleContext.getService(serviceEvent.getServiceReference());
                if (object instanceof ASIServiceRegistry) {
                    ASIServiceRegistry aSIServiceRegistry = (ASIServiceRegistry)object;
                    aSIServiceRegistry.registerAllDevicesService(class$de$vw$mib$asi$media$ASIMedia == null ? (class$de$vw$mib$asi$media$ASIMedia = ASIClient.class$("de.vw.mib.asi.media.ASIMedia")) : class$de$vw$mib$asi$media$ASIMedia, 0, MEDIA_ASI_SERVICES_IMPL, asiProperties);
                    break;
                }
                if (!(object instanceof ASIServiceProvider)) break;
                ASIServiceProvider aSIServiceProvider = (ASIServiceProvider)object;
                break;
            }
        }
    }

    public static void updateActiveMedia(MediaSourceSlot mediaSourceSlot, int n) {
        if (MEDIA_ASI_SERVICES_IMPL.getASIMediaListener() != null) {
            MEDIA_ASI_SERVICES_IMPL.getASIMediaListener().updateActiveSlotState(new MediaActiveSourceState(mediaSourceSlot, n), mediaSourceSlot != null);
        }
    }

    public static void update(MediaPlayerState mediaPlayerState, int n) {
        if (Util.isBitSet(8, n)) {
            int n2 = ASIClient.convertPlayerStateASL2ASI(mediaPlayerState.getPlaybackState());
            if (MEDIA_ASI_SERVICES_IMPL.getASIMediaListener() != null) {
                MEDIA_ASI_SERVICES_IMPL.getASIMediaListener().updatePlaybackState(n2, n2 != -1);
            }
        }
        if (Util.isBitSet(1, n) && MEDIA_ASI_SERVICES_IMPL.getASIMediaListener() != null) {
            if (mediaPlayerState.getPlaybackEntry() == null || mediaPlayerState.getPlayTime() == null) {
                MEDIA_ASI_SERVICES_IMPL.getASIMediaListener().updatePlayPosition(null, false);
            } else {
                MEDIA_ASI_SERVICES_IMPL.getASIMediaListener().updatePlayPosition(new MediaPlayTime(mediaPlayerState.getPlaybackEntry().getEntryID(), mediaPlayerState.getPlayTime().getPlayTime(), mediaPlayerState.getPlayTime().getTotalTime()), true);
            }
        }
    }

    public static void updateSourceList(MediaSourceSlot[] mediaSourceSlotArray) {
        if (MEDIA_ASI_SERVICES_IMPL.getASIMediaListener() != null) {
            MEDIA_ASI_SERVICES_IMPL.getASIMediaListener().updateSourceList(mediaSourceSlotArray, true);
        }
    }

    private static int convertPlayerStateASL2ASI(int n) {
        switch (n) {
            case 0: {
                return -1;
            }
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 4;
            }
            case 4: {
                return -1;
            }
            case 5: {
                return 4;
            }
            case 6: {
                return 2;
            }
            case 7: {
                return 3;
            }
        }
        return -1;
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

