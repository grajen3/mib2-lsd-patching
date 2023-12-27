/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.clients;

import de.vw.mib.asl.api.devicehandling.ASLDeviceHandlingFactory;
import de.vw.mib.asl.api.devicehandling.clients.AbstractDeviceList;
import de.vw.mib.asl.api.devicehandling.clients.DeviceAslList;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;
import de.vw.mib.asl.api.devicehandling.clients.MediaListObserver;
import de.vw.mib.asl.internal.media.sourcehandling.MediaAsiFilter;
import de.vw.mib.asl.internal.media.sourcehandling.MediaDeviceFilter;
import de.vw.mib.asl.internal.media.sourcehandling.MediaHasFilter;
import de.vw.mib.asl.internal.media.sourcehandling.clients.AslDeviceIdDeterminator;
import de.vw.mib.asl.internal.media.sourcehandling.clients.CircularLinkingAslList;
import de.vw.mib.asl.internal.media.sourcehandling.clients.DeviceAsiList;
import de.vw.mib.asl.internal.media.sourcehandling.clients.DeviceHasList;
import de.vw.mib.asl.internal.media.sourcehandling.clients.DeviceNameProvider;
import de.vw.mib.asl.internal.media.sourcehandling.clients.DiskChangerSlotList;
import de.vw.mib.asl.internal.media.sourcehandling.clients.MediaDevices;
import de.vw.mib.asl.internal.media.sourcehandling.clients.MediaListObservers$1;
import de.vw.mib.asl.internal.media.sourcehandling.clients.MediaListObservers$2;
import de.vw.mib.asl.internal.media.sourcehandling.clients.MediumPlayedDetector;
import de.vw.mib.asl.internal.media.sourcehandling.clients.SourceStateUpdater;
import de.vw.mib.asl.internal.media.sourcehandling.controller.SourceIconController;
import java.util.ArrayList;
import java.util.Arrays;

public final class MediaListObservers {
    private final MediaDeviceFilter deviceFilter;
    private final MediaDevices mediaDevices;
    private final DeviceFilter listedDeviceFilter;
    private final DeviceFilter USB_FILTER = new MediaListObservers$1(this);
    private final MediumPlayedDetector mediumPlayedDetector;
    private final DeviceAslList availableAudioSources;
    private final DeviceAslList availableBrowsingSources;
    private final DeviceAslList availableImportSources;
    private final DeviceHasList deviceHasList;
    private final DeviceAsiList deviceAsiList;
    private DiskChangerSlotList diskChangerSlotList;
    private final AbstractDeviceList sourceStateUpdater;

    public MediaDevices getMediaDevices() {
        return this.mediaDevices;
    }

    public DeviceFilter getDeviceFilter() {
        return this.listedDeviceFilter;
    }

    public MediaListObservers() {
        this.deviceFilter = new MediaDeviceFilter();
        this.mediaDevices = new MediaDevices(this.deviceFilter);
        this.listedDeviceFilter = new MediaListObservers$2(this);
        this.mediumPlayedDetector = new MediumPlayedDetector(this.listedDeviceFilter);
        this.availableAudioSources = new CircularLinkingAslList(SourceIconController.getInstance(), 56, this.listedDeviceFilter);
        this.availableBrowsingSources = new DeviceAslList(2354, this.listedDeviceFilter);
        this.availableImportSources = new DeviceAslList(57, DeviceFilter.REMOVABLE);
        this.deviceHasList = new DeviceHasList(new MediaHasFilter());
        this.deviceAsiList = new DeviceAsiList(new MediaAsiFilter());
        this.diskChangerSlotList = new DiskChangerSlotList();
        this.sourceStateUpdater = new SourceStateUpdater(this.listedDeviceFilter);
    }

    public void register(MediaDevices mediaDevices, MediaListObserver[] mediaListObserverArray) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(mediaDevices);
        arrayList.add(new AslDeviceIdDeterminator(this.listedDeviceFilter));
        arrayList.add(new DeviceNameProvider());
        arrayList.add(this.availableAudioSources);
        arrayList.add(this.mediumPlayedDetector);
        arrayList.addAll(Arrays.asList(mediaListObserverArray));
        arrayList.add(this.availableImportSources);
        arrayList.add(this.availableBrowsingSources);
        arrayList.add(this.deviceHasList);
        arrayList.add(this.deviceAsiList);
        arrayList.add(this.diskChangerSlotList);
        arrayList.add(this.sourceStateUpdater);
        arrayList.add(new DeviceAslList(995888128, this.USB_FILTER));
        ASLDeviceHandlingFactory.getDeviceHandlingApi().registerAll(arrayList);
    }

    public void updateLists(boolean bl) {
        this.availableAudioSources.updateList(bl);
        this.availableBrowsingSources.updateList(bl);
        this.availableImportSources.updateList(bl);
        this.deviceHasList.updateList();
        this.deviceAsiList.updateList();
        this.sourceStateUpdater.updateList(bl);
    }

    static /* synthetic */ MediaDeviceFilter access$000(MediaListObservers mediaListObservers) {
        return mediaListObservers.deviceFilter;
    }
}

