/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.clients;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.Medium;
import de.vw.mib.asl.api.devicehandling.clients.AbstractDeviceList;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;
import de.vw.mib.asl.api.media.services.sources.medialist.MediaIndicationListener;
import de.vw.mib.asl.api.media.services.sources.medialist.MediaIndicationService;
import de.vw.mib.asl.api.media.services.sources.medialist.MediaListListener;
import de.vw.mib.asl.api.media.services.sources.medialist.MediaListService;
import de.vw.mib.asl.api.media.services.sources.medialist.MountPointListener;
import de.vw.mib.asl.api.media.services.sources.medialist.Source;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.media.api.impl.MountPointListenerAdapter;
import de.vw.mib.asl.internal.media.sourcehandling.clients.SourceStateUpdater$1;
import de.vw.mib.asl.internal.media.sourcehandling.clients.SourceStateUpdater$2;
import de.vw.mib.asl.internal.media.sourcehandling.clients.SourceStateUpdater$BooleanWrapper;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.collections.ints.IntOptHashSet;
import java.util.ArrayList;
import java.util.Iterator;

public class SourceStateUpdater
extends AbstractDeviceList
implements MediaListService,
MediaIndicationService {
    private final ArrayList result = new ArrayList();
    private boolean registered = false;
    private final SourceStateUpdater$BooleanWrapper activeMediaWrapper = new SourceStateUpdater$BooleanWrapper(this);
    private final ArrayList statusObservers = new ArrayList();
    private final ArrayList indicationListeners = new ArrayList();
    static /* synthetic */ Class class$de$vw$mib$asl$api$media$services$sources$medialist$MediaListService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$media$services$sources$medialist$MediaIndicationService;

    SourceStateUpdater(DeviceFilter deviceFilter) {
        super(deviceFilter);
    }

    @Override
    protected void updateList(Device[] deviceArray, boolean bl) {
        Object object;
        this.activeMediaWrapper.setValue(bl);
        this.result.clear();
        for (int i2 = 0; i2 < deviceArray.length; ++i2) {
            this.result.add(MediaCollector.createSourceState(deviceArray[i2].getMainMedium()));
        }
        Iterator iterator = this.statusObservers.iterator();
        while (iterator.hasNext()) {
            object = (MediaListListener)iterator.next();
            object.updateSources(this.result);
        }
        for (int i3 = 0; i3 < deviceArray.length; ++i3) {
            object = deviceArray[i3].getMainMedium();
            Source source = MediaCollector.createSourceState((Medium)object, ((Medium)object).getCurrentState());
            Source source2 = MediaCollector.createSourceState((Medium)object, ((Medium)object).getPreviousState());
            for (int i4 = 0; i4 < this.indicationListeners.size(); ++i4) {
                ((MediaIndicationListener)this.indicationListeners.get(i4)).onSourceChanged(source, source2);
            }
        }
        if (!this.registered) {
            ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$api$media$services$sources$medialist$MediaListService == null ? (class$de$vw$mib$asl$api$media$services$sources$medialist$MediaListService = SourceStateUpdater.class$("de.vw.mib.asl.api.media.services.sources.medialist.MediaListService")) : class$de$vw$mib$asl$api$media$services$sources$medialist$MediaListService, this);
            ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$api$media$services$sources$medialist$MediaIndicationService == null ? (class$de$vw$mib$asl$api$media$services$sources$medialist$MediaIndicationService = SourceStateUpdater.class$("de.vw.mib.asl.api.media.services.sources.medialist.MediaIndicationService")) : class$de$vw$mib$asl$api$media$services$sources$medialist$MediaIndicationService, this);
            this.registered = true;
        }
    }

    @Override
    public void addSourceStateListener(MediaListListener mediaListListener) {
        mediaListListener = (MediaListListener)ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAsyncServiceFactory().create(mediaListListener);
        if (!this.result.isEmpty()) {
            mediaListListener.updateSources(this.result);
        }
        this.statusObservers.add(mediaListListener);
    }

    @Override
    public void registerMediaIndicationListener(MediaIndicationListener mediaIndicationListener) {
        mediaIndicationListener = (MediaIndicationListener)ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAsyncServiceFactory().create(mediaIndicationListener);
        for (int i2 = 0; i2 < this.result.size(); ++i2) {
            mediaIndicationListener.onSourceChanged((Source)this.result.get(i2), null);
        }
        this.indicationListeners.add(mediaIndicationListener);
    }

    @Override
    public void registerSystemIndicationListener(MediaIndicationListener mediaIndicationListener) {
        this.registerMediaIndicationListener(this.filterInsertionStatus(this.filterDeviceType(new int[]{2}, mediaIndicationListener)));
    }

    @Override
    public MediaIndicationListener filterDeviceType(int[] nArray, MediaIndicationListener mediaIndicationListener) {
        IntOptHashSet intOptHashSet = new IntOptHashSet(nArray.length);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            intOptHashSet.add(nArray[i2]);
        }
        return new SourceStateUpdater$1(this, intOptHashSet, mediaIndicationListener);
    }

    @Override
    public MediaIndicationListener filterInsertionStatus(MediaIndicationListener mediaIndicationListener) {
        return new SourceStateUpdater$2(this, mediaIndicationListener);
    }

    @Override
    public void registerMountPointListenerSD(MountPointListener mountPointListener, int n) {
        this.registerMediaIndicationListener(new MountPointListenerAdapter(1, n, mountPointListener));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ SourceStateUpdater$BooleanWrapper access$000(SourceStateUpdater sourceStateUpdater) {
        return sourceStateUpdater.activeMediaWrapper;
    }
}

