/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.clients;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.Devices;
import de.vw.mib.asl.api.devicehandling.clients.MediaListObserver;
import de.vw.mib.asl.internal.media.common.HASUtil;
import de.vw.mib.asl.internal.media.sourcehandling.MediaHasFilter;
import de.vw.mib.asl.internal.media.sourcehandling.state.DeviceCollector;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.collections.SortedList;
import de.vw.mib.has.HAS;
import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASEngineAPI;
import de.vw.mib.has.HASFactory;
import generated.de.vw.mib.has.containers.MediaCapabilitiesContainer;
import generated.de.vw.mib.has.containers.MediaSourceStateContainer;
import generated.de.vw.mib.has.containers.MediaSourcesContainer;
import generated.de.vw.mib.has.contexts.media.MediaProperties;
import java.util.Comparator;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.MediaCapabilities;

public class DeviceHasList
implements MediaListObserver,
Comparator {
    private final MediaHasFilter hasFilter;
    private final MediaProperties mHASProperties;
    private final MediaSourcesContainer mMediaSourcesContainer;
    private final HASFactory factory;
    private Devices devices;

    public DeviceHasList(MediaHasFilter mediaHasFilter) {
        this.hasFilter = mediaHasFilter;
        HASEngineAPI hASEngineAPI = HAS.getInstance().getEngine();
        HASContext hASContext = hASEngineAPI.getRegistry().getContextByName("Media");
        this.mHASProperties = (MediaProperties)hASContext.getPropertiesImpl();
        this.factory = HAS.getInstance().getFactory();
        this.mMediaSourcesContainer = (MediaSourcesContainer)this.factory.createContainer(33);
    }

    @Override
    public void onUpdate(Devices devices) {
        this.devices = devices;
        this.updateAvailableMediaSources(devices);
    }

    private void updateAvailableMediaSources(Devices devices) {
        if (devices == null) {
            return;
        }
        SortedList sortedList = new SortedList(this);
        for (int i2 = 0; i2 < devices.count(); ++i2) {
            Device device = devices.get(i2);
            if (!this.hasFilter.passes(device)) continue;
            DeviceCollector deviceCollector = DeviceCollector.get(device);
            MediaSourceStateContainer mediaSourceStateContainer = (MediaSourceStateContainer)this.factory.createContainer(32);
            mediaSourceStateContainer.setSource(HASUtil.convertASLDeviceId2HAS(deviceCollector.getAslDeviceID()));
            mediaSourceStateContainer.setState(this.getSourceState(deviceCollector));
            MediaCollector mediaCollector = deviceCollector.getMainPartition();
            if (mediaCollector != null) {
                mediaSourceStateContainer.setCapabilities(this.createCapabilities(mediaCollector.getMediaCaps(), mediaCollector.getPlayerCapabilities()));
                mediaSourceStateContainer.setDatabaseSynced(mediaCollector.isContentModeReadyToUse(true));
            }
            sortedList.add(mediaSourceStateContainer);
        }
        this.mMediaSourcesContainer.setSources((MediaSourceStateContainer[])sortedList.toArray(new MediaSourceStateContainer[sortedList.size()]));
        this.mHASProperties.updateAvailableMediaSources(this.mMediaSourcesContainer);
    }

    private MediaCapabilitiesContainer createCapabilities(MediaCapabilities mediaCapabilities, Capabilities capabilities) {
        MediaCapabilitiesContainer mediaCapabilitiesContainer = (MediaCapabilitiesContainer)this.factory.createContainer(66);
        if (mediaCapabilities != null) {
            mediaCapabilitiesContainer.setCoverArt(mediaCapabilities.playerCoverArt);
            mediaCapabilitiesContainer.setDatabaseBrowseMode(mediaCapabilities.contentBrowser);
            mediaCapabilitiesContainer.setPlaybackModes(mediaCapabilities.playbackModes);
            mediaCapabilitiesContainer.setRawBrowseMode(mediaCapabilities.rawBrowser);
        }
        if (capabilities != null) {
            mediaCapabilitiesContainer.setDetailInfo(capabilities.detailInfos);
            mediaCapabilitiesContainer.setElapsedTime(capabilities.playTime);
            mediaCapabilitiesContainer.setFastBackward(capabilities.fastBwd);
            mediaCapabilitiesContainer.setFastForward(capabilities.fastFwd);
            mediaCapabilitiesContainer.setPause(capabilities.pause);
            mediaCapabilitiesContainer.setPlay(capabilities.resume);
            mediaCapabilitiesContainer.setPlayingTime(capabilities.totalPlaytime);
            mediaCapabilitiesContainer.setPMLTMode(capabilities.playSimilarEntries);
            mediaCapabilitiesContainer.setSetTimePos(capabilities.setTimePos);
            mediaCapabilitiesContainer.setSkipBackward(capabilities.skipBwd);
            mediaCapabilitiesContainer.setSkipForward(capabilities.skipFwd);
        }
        return mediaCapabilitiesContainer;
    }

    public void updateList() {
        this.updateAvailableMediaSources(this.devices);
    }

    private int getSourceState(DeviceCollector deviceCollector) {
        if (deviceCollector.isDeviceActive()) {
            return 2;
        }
        if (!deviceCollector.isDevicePlayable() || !deviceCollector.isDeviceInValidState()) {
            return 5;
        }
        if (deviceCollector.isUserAvailable()) {
            return 1;
        }
        return 4;
    }

    @Override
    public int compare(Object object, Object object2) {
        if (object == object2) {
            return 0;
        }
        MediaSourceStateContainer mediaSourceStateContainer = (MediaSourceStateContainer)object;
        MediaSourceStateContainer mediaSourceStateContainer2 = (MediaSourceStateContainer)object2;
        return mediaSourceStateContainer.getSource() - mediaSourceStateContainer2.getSource();
    }
}

