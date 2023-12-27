/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.settings;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.tvtuner.accessor.TVTunerObjectAccessor;
import de.vw.mib.asl.internal.tvtuner.collector.TVSetupAudioChannelListCollector;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerHelper;
import de.vw.mib.asl.internal.tvtuner.settings.TVTunerAbstractSettings;
import edu.emory.mathcs.backport.java.util.Arrays;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.tvtuner.transformer.TVTunerCASInformationCollector;
import org.dsi.ifc.tvtuner.AudioChannel;

public class TVTunerSettings
extends TVTunerAbstractSettings {
    private int[] currentSupportedTVNormAreas = null;
    private int currentActiveTVNormArea = 0;
    private int aspectRatioMode = 0;
    private AudioChannel[] availableAudioChannels = null;
    private boolean visualAudioShowPictures = false;
    private boolean showEWSMessages = true;
    private boolean serviceLinking = false;
    private int casStatus = -1;
    private int tvNormForLater = -1;

    public void updateTVNormAreasList(int[] nArray) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerSettings#updateTVNormAreasList called - tvNormList = ").append(Arrays.toString(nArray)).toString());
        }
        this.currentSupportedTVNormAreas = new int[nArray.length + 1];
        this.currentSupportedTVNormAreas[0] = 0;
        for (int i2 = 1; i2 < this.currentSupportedTVNormAreas.length; ++i2) {
            this.currentSupportedTVNormAreas[i2] = nArray[i2 - 1];
        }
        ListManager.getGenericASLList(2415).updateList(TVTunerHelper.convertInt2IntegerArray(this.currentSupportedTVNormAreas));
        if (this.tvNormForLater != -1) {
            this.updateTVNormArea(this.tvNormForLater);
        }
    }

    public void updateTVNormArea(int n) {
        if (this.currentSupportedTVNormAreas == null) {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace("TVTunerSettings#updateTVNormArea called - no tv norm areas available yet - save tv norm for later");
            }
            this.tvNormForLater = n;
            return;
        }
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerSettings#updateTVNormArea called - tvNormArea = ").append(n).toString());
        }
        this.currentActiveTVNormArea = n;
        this.tvNormForLater = -1;
        int n2 = 0;
        if (this.currentActiveTVNormArea != 254) {
            for (int i2 = 0; i2 < this.currentSupportedTVNormAreas.length; ++i2) {
                if (this.currentActiveTVNormArea != this.currentSupportedTVNormAreas[i2]) continue;
                n2 = i2;
                if (!TVTunerHelper.isTraceEnabled()) break;
                TVTunerHelper.trace(new StringBuffer().append("TVTunerSettings#updateTVNormArea - set the tvNormAreaListIndex to ").append(n2).toString());
                break;
            }
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(2399, n2);
        ServiceManager.aslPropertyManager.valueChangedInteger(2416, this.currentActiveTVNormArea == 254 ? 0 : this.currentActiveTVNormArea);
        TVTunerObjectAccessor.getTvTunerDB().getTvPersistable().persistNormArea(n2);
    }

    public void setSelectedTVNorm(int n) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerSettings#setSelectedTVNorm called - index = ").append(n).toString());
        }
        int n2 = 0;
        if (n == 0) {
            n2 = 254;
        } else {
            if (this.currentSupportedTVNormAreas == null || this.currentSupportedTVNormAreas.length == 0 || n > this.currentSupportedTVNormAreas.length - 1) {
                if (TVTunerHelper.isTraceEnabled()) {
                    TVTunerHelper.trace("TVTunerSettings#setSelectedTVNorm - can't set norm area, list ist null, empty or to small");
                }
                return;
            }
            n2 = this.currentSupportedTVNormAreas[n];
        }
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerSettings#setSelectedTVNorm - set tvnorm ").append(n2).append(" to DSI").toString());
        }
        TVTunerObjectAccessor.getTargetTVTunerDSI().getDSITVTuner().setNormArea(n2);
    }

    public void setServiceLinking(boolean bl) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerSettings#setServiceLinking called - serviceLinkingState = ").append(bl).toString());
        }
        TVTunerObjectAccessor.getTargetTVTunerDSI().getDSITVTuner().enableServiceLinking(bl);
    }

    public void updateServiceLinkingState(boolean bl) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerSettings#updateServiceLinking called - serviceLinkingState = ").append(bl).toString());
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(2517, bl);
        TVTunerObjectAccessor.getTvTunerDB().getTvPersistable().persistServiceLinkingActive(bl);
        this.serviceLinking = bl;
    }

    public void setTVNormAreaSublist(int[] nArray) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerSettings#setTVNormAreaSublist called - set sublist ").append(Arrays.toString(nArray)).toString());
        }
        TVTunerObjectAccessor.getTargetTVTunerDSI().getDSITVTuner().setNormAreaSubList(nArray);
    }

    public void setSubtitleState(boolean bl) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerSettings#setSubtitle called - subtitleState = ").append(bl).toString());
        }
        TVTunerObjectAccessor.getTargetTVTunerDSI().getDSITVTuner().enableSubtitle(bl);
    }

    public void updateSubtitleState(boolean bl) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerSettings#updateSubtitleState called - subtitleState = ").append(bl).toString());
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(2740, bl);
        TVTunerObjectAccessor.getTvTunerDB().getTvPersistable().persistSubtitleActive(bl);
    }

    public void setAspectRatioMode(int n, boolean bl) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerSettings#setAspectRatioMode called - aspectRatioMode = ").append(n).toString());
        }
        this.aspectRatioMode = n;
        ServiceManager.aslPropertyManager.valueChangedInteger(2733, n);
        this.updateAspectRatio(TVTunerObjectAccessor.getTVInfo().getVideoFormat());
        if (!bl) {
            TVTunerObjectAccessor.getTvTunerDB().getTvPersistable().persistAspectRatio(n);
        }
    }

    public void updateAspectRatio(int n) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerSettings#updateAspectRatio called - videoFormat = ").append(n).toString());
        }
        int n2 = 0;
        switch (this.aspectRatioMode) {
            case 0: {
                n2 = n;
                break;
            }
            case 1: {
                n2 = 0;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            default: {
                if (!TVTunerHelper.isTraceEnabled()) break;
                TVTunerHelper.trace(new StringBuffer().append("TVTunerSettings#updateAspectRatio - aspectRatioMode ").append(this.aspectRatioMode).append(" is unknown").toString());
            }
        }
        if (TVTunerObjectAccessor.getTvAvSourceHandler().getActiveSource() == 0) {
            ServiceManager.aslPropertyManager.valueChangedInteger(-1102305792, n2);
        }
        TVTunerObjectAccessor.getTileService().updateTVVideoFormat(n2);
    }

    public void updateAvailableAudioChannels(AudioChannel[] audioChannelArray) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerSettings#updateAvailableAudioChannels called - number of channels = ").append(audioChannelArray.length).toString());
        }
        this.availableAudioChannels = audioChannelArray;
        Object[] objectArray = new TVSetupAudioChannelListCollector[this.availableAudioChannels.length];
        for (int i2 = 0; i2 < this.availableAudioChannels.length; ++i2) {
            objectArray[i2] = new TVSetupAudioChannelListCollector(this.availableAudioChannels[i2].getAudioLanguage().toLowerCase(), this.availableAudioChannels[i2].audioFormat, this.availableAudioChannels[i2].audioDescription);
        }
        ListManager.getGenericASLList(2922).updateList(objectArray);
    }

    public void setAudioChannel(int n) {
        int n2 = this.availableAudioChannels[n].getChannelID();
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerSettings#setAudioChannel called - selected audio channel id = ").append(n2).toString());
        }
        TVTunerObjectAccessor.getTargetTVTunerDSI().getDSITVTuner().setAudioChannel(n2);
    }

    public void updateSelectedAudioChannel(int n) {
        if (this.availableAudioChannels == null) {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace("TVTunerSettings#updateSelectedAudioChannel called - no audiochannels available yet - do nothing");
            }
            return;
        }
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerSettings#updateSelectedAudioChannel called - selected audio channel id = ").append(n).toString());
        }
        int n2 = -1;
        for (int i2 = 0; i2 < this.availableAudioChannels.length; ++i2) {
            if (this.availableAudioChannels[i2].getChannelID() != n) continue;
            n2 = i2;
            break;
        }
        if (n2 != -1) {
            ServiceManager.aslPropertyManager.valueChangedInteger(2817, n2);
        } else if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerSettings#updateSelectedAudioChannel - selected audio with channel id = ").append(n).append(" not present in channellist").toString());
        }
        TVTunerObjectAccessor.getTvTunerDB().getTvPersistable().persistLastAudioChannel(n);
    }

    public void updateCASInfo(String string, boolean bl) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TVTunerSettings#updateCASInfo called");
            TVTunerHelper.trace(new StringBuffer().append("TVTunerSettings#updateCASInfo - casInfoText = ").append(string).toString());
            TVTunerHelper.trace(new StringBuffer().append("TVTunerSettings#updateCASInfo - permanentCASID = ").append(bl).toString());
        }
        Object[] objectArray = new TVTunerCASInformationCollector[]{new TVTunerCASInformationCollector()};
        objectArray[0].tvtuner_cas_information_text = string;
        objectArray[0].tvtuner_cas_permanent_id = bl;
        ListManager.getGenericASLList(2935).updateList(objectArray);
    }

    public boolean isVisualAudioShowPictures() {
        return this.visualAudioShowPictures;
    }

    public void setVisualAudioShowPictures(boolean bl, boolean bl2) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerSettings#setVisualAudioShowPictures called = visualAudioShowPictures = ").append(bl).toString());
        }
        this.visualAudioShowPictures = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(3012, bl);
        if (!bl2) {
            TVTunerObjectAccessor.getTvTunerDB().getTvPersistable().persistVisualAudioShowPictures(bl);
        }
    }

    public void setShowEWSMessages(boolean bl, boolean bl2) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerSettings#setShowEWSMessages called = showEWS = ").append(bl).toString());
        }
        this.showEWSMessages = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(-1186191872, this.showEWSMessages);
        if (!bl2) {
            TVTunerObjectAccessor.getTvTunerDB().getTvPersistable().persistShowEWSMessageOption(bl);
        }
    }

    public void setTMAspectRatio() {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TVTunerSettings#setTMAspectRatio called");
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(-1102305792, 2);
    }

    public void updateBrowserListSortState(int n) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerSettings#updateBrowserListSortState called - selected browserlistsorting mode = ").append(n).toString());
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(-1253300736, n);
    }

    public boolean isServiceLinking() {
        return this.serviceLinking;
    }

    public boolean isShowEWSMessages() {
        return this.showEWSMessages;
    }

    public int getCasStatus() {
        return this.casStatus;
    }

    public void setCasStatus(int n) {
        this.casStatus = n;
    }
}

