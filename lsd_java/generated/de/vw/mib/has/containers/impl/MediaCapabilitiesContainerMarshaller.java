/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.MediaCapabilitiesContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class MediaCapabilitiesContainerMarshaller
extends AbstractContainerMarshaller {
    public MediaCapabilitiesContainerMarshaller() {
        super(66);
    }

    @Override
    public HASDataContainer marshal(HASContainer hASContainer) {
        HASDataContainer hASDataContainer;
        int n = this.getMarshallerContainerId();
        if (null == hASContainer) {
            hASDataContainer = null;
        } else {
            if (n != hASContainer.getContainerId()) {
                throw HASException.wrongContainerId(n, hASContainer.getContainerId());
            }
            hASDataContainer = new HASDataContainer();
            hASDataContainer.containerId = n;
            hASDataContainer.elementId = hASContainer.getElementId();
            MediaCapabilitiesContainer mediaCapabilitiesContainer = (MediaCapabilitiesContainer)hASContainer;
            ArrayList arrayList = MediaCapabilitiesContainerMarshaller.borrowArrayList();
            if (mediaCapabilitiesContainer.isCoverArtSet()) {
                MediaCapabilitiesContainerMarshaller.add((List)arrayList, MediaCapabilitiesContainerMarshaller.createBooleanElement(152, mediaCapabilitiesContainer.getCoverArt()));
            }
            if (mediaCapabilitiesContainer.isDatabaseBrowseModeSet()) {
                MediaCapabilitiesContainerMarshaller.add((List)arrayList, MediaCapabilitiesContainerMarshaller.createBooleanElement(153, mediaCapabilitiesContainer.getDatabaseBrowseMode()));
            }
            if (mediaCapabilitiesContainer.isDetailInfoSet()) {
                MediaCapabilitiesContainerMarshaller.add((List)arrayList, MediaCapabilitiesContainerMarshaller.createBooleanElement(154, mediaCapabilitiesContainer.getDetailInfo()));
            }
            if (mediaCapabilitiesContainer.isElapsedTimeSet()) {
                MediaCapabilitiesContainerMarshaller.add((List)arrayList, MediaCapabilitiesContainerMarshaller.createBooleanElement(155, mediaCapabilitiesContainer.getElapsedTime()));
            }
            if (mediaCapabilitiesContainer.isFastBackwardSet()) {
                MediaCapabilitiesContainerMarshaller.add((List)arrayList, MediaCapabilitiesContainerMarshaller.createBooleanElement(156, mediaCapabilitiesContainer.getFastBackward()));
            }
            if (mediaCapabilitiesContainer.isFastForwardSet()) {
                MediaCapabilitiesContainerMarshaller.add((List)arrayList, MediaCapabilitiesContainerMarshaller.createBooleanElement(157, mediaCapabilitiesContainer.getFastForward()));
            }
            if (mediaCapabilitiesContainer.isPauseSet()) {
                MediaCapabilitiesContainerMarshaller.add((List)arrayList, MediaCapabilitiesContainerMarshaller.createBooleanElement(158, mediaCapabilitiesContainer.getPause()));
            }
            if (mediaCapabilitiesContainer.isPlaySet()) {
                MediaCapabilitiesContainerMarshaller.add((List)arrayList, MediaCapabilitiesContainerMarshaller.createBooleanElement(159, mediaCapabilitiesContainer.getPlay()));
            }
            if (mediaCapabilitiesContainer.isPlaybackModesSet()) {
                MediaCapabilitiesContainerMarshaller.add((List)arrayList, MediaCapabilitiesContainerMarshaller.createBooleanElement(160, mediaCapabilitiesContainer.getPlaybackModes()));
            }
            if (mediaCapabilitiesContainer.isPlayingTimeSet()) {
                MediaCapabilitiesContainerMarshaller.add((List)arrayList, MediaCapabilitiesContainerMarshaller.createBooleanElement(161, mediaCapabilitiesContainer.getPlayingTime()));
            }
            if (mediaCapabilitiesContainer.isPMLTModeSet()) {
                MediaCapabilitiesContainerMarshaller.add((List)arrayList, MediaCapabilitiesContainerMarshaller.createBooleanElement(162, mediaCapabilitiesContainer.getPMLTMode()));
            }
            if (mediaCapabilitiesContainer.isRawBrowseModeSet()) {
                MediaCapabilitiesContainerMarshaller.add((List)arrayList, MediaCapabilitiesContainerMarshaller.createBooleanElement(163, mediaCapabilitiesContainer.getRawBrowseMode()));
            }
            if (mediaCapabilitiesContainer.isSetTimePosSet()) {
                MediaCapabilitiesContainerMarshaller.add((List)arrayList, MediaCapabilitiesContainerMarshaller.createBooleanElement(164, mediaCapabilitiesContainer.getSetTimePos()));
            }
            if (mediaCapabilitiesContainer.isSkipBackwardSet()) {
                MediaCapabilitiesContainerMarshaller.add((List)arrayList, MediaCapabilitiesContainerMarshaller.createBooleanElement(165, mediaCapabilitiesContainer.getSkipBackward()));
            }
            if (mediaCapabilitiesContainer.isSkipForwardSet()) {
                MediaCapabilitiesContainerMarshaller.add((List)arrayList, MediaCapabilitiesContainerMarshaller.createBooleanElement(166, mediaCapabilitiesContainer.getSkipForward()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            MediaCapabilitiesContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setBooleanElement(HASContainer hASContainer, int n, boolean bl) {
        switch (n) {
            case 152: {
                ((MediaCapabilitiesContainer)hASContainer).setCoverArt(bl);
                break;
            }
            case 153: {
                ((MediaCapabilitiesContainer)hASContainer).setDatabaseBrowseMode(bl);
                break;
            }
            case 154: {
                ((MediaCapabilitiesContainer)hASContainer).setDetailInfo(bl);
                break;
            }
            case 155: {
                ((MediaCapabilitiesContainer)hASContainer).setElapsedTime(bl);
                break;
            }
            case 156: {
                ((MediaCapabilitiesContainer)hASContainer).setFastBackward(bl);
                break;
            }
            case 157: {
                ((MediaCapabilitiesContainer)hASContainer).setFastForward(bl);
                break;
            }
            case 158: {
                ((MediaCapabilitiesContainer)hASContainer).setPause(bl);
                break;
            }
            case 159: {
                ((MediaCapabilitiesContainer)hASContainer).setPlay(bl);
                break;
            }
            case 160: {
                ((MediaCapabilitiesContainer)hASContainer).setPlaybackModes(bl);
                break;
            }
            case 161: {
                ((MediaCapabilitiesContainer)hASContainer).setPlayingTime(bl);
                break;
            }
            case 162: {
                ((MediaCapabilitiesContainer)hASContainer).setPMLTMode(bl);
                break;
            }
            case 163: {
                ((MediaCapabilitiesContainer)hASContainer).setRawBrowseMode(bl);
                break;
            }
            case 164: {
                ((MediaCapabilitiesContainer)hASContainer).setSetTimePos(bl);
                break;
            }
            case 165: {
                ((MediaCapabilitiesContainer)hASContainer).setSkipBackward(bl);
                break;
            }
            case 166: {
                ((MediaCapabilitiesContainer)hASContainer).setSkipForward(bl);
                break;
            }
            default: {
                super.setBooleanElement(hASContainer, n, bl);
            }
        }
    }
}

