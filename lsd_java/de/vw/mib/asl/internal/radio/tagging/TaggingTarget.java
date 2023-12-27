/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.tagging;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.amfm.presets.SelectedStationHighlighting;
import de.vw.mib.asl.internal.radio.amfm.util.AMFMMath;
import de.vw.mib.asl.internal.radio.sdars.database.AslPool;
import de.vw.mib.asl.internal.radio.sdars.helper.PreviewHandler;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.media.TagInformation;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.StationInfo;

final class TaggingTarget
extends AbstractTarget {
    private final HsmTarget mTarget;
    private boolean tagActivationPending = false;
    private boolean stationChanged = false;
    private boolean tagButtonEnabled = false;
    private boolean taggingAmbiguousZoneSongStart = false;
    private String mITunesSXMURL = "";
    private String mAffiliateID = "";
    private TagInformation iTagInfo;
    private StationInfo mSDARSStation;

    TaggingTarget(HsmTarget hsmTarget) {
        super(hsmTarget.getMainObject());
        this.mTarget = hsmTarget;
        String string = this.getEventDispatcher().getTaskId(hsmTarget.getTargetId());
        this.getEventDispatcher().registerTarget(this, string);
    }

    @Override
    public int getClassifier() {
        return 1;
    }

    @Override
    public int getSubClassifier() {
        return 128;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 8: {
                this.addObserver(557853696);
                this.addObserver(-509739008);
                this.addObserver(-536608704);
                this.addObserver(-1643904960);
                this.addObserver(-1627127744);
                this.addObserver(-385613760);
                this.addObserver(-771489728);
                this.addObserver(1963196480);
                this.addObserver(1979973696);
                this.addObserver(0x77040040);
                this.addObserver(2013528128);
                this.addObserver(-660733952);
                this.addObserver(-425852928);
                break;
            }
            case 9: {
                this.removeObserver(557853696);
                this.removeObserver(-509739008);
                this.removeObserver(-425852928);
                this.removeObserver(-536608704);
                this.removeObserver(-1643904960);
                this.removeObserver(-1627127744);
                this.removeObserver(-385613760);
                this.removeObserver(-771489728);
                this.removeObserver(1963196480);
                this.removeObserver(1979973696);
                this.removeObserver(0x77040040);
                this.removeObserver(2013528128);
                break;
            }
            case 2900001: {
                if (RadioData.getAmfmDatabase().getTaggingInstance() > -1) break;
                this.requestInstance();
                break;
            }
            case 40673: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(" ASL_ITUNES_RESPONSE_INSTANCE ").log();
                }
                String string = eventGeneric.getString(0);
                int n = eventGeneric.getInt(1);
                if (!string.equals("RADIO") || n == 13) break;
                RadioData.getAmfmDatabase().setTaggingInstance(n);
                this.loadTagDatabase();
                break;
            }
            case 40664: {
                int n;
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(" ITUNES_NOTIFY_DATABASE_LOADED ").log();
                }
                if ((n = eventGeneric.getInt(0)) != RadioData.getAmfmDatabase().getTaggingInstance()) break;
                if (RadioCurrentWaveband.isSdars()) {
                    this.prepareRadioTextITag(false);
                    break;
                }
                if (!RadioCurrentWaveband.isFm() && !RadioCurrentWaveband.isAm()) break;
                this.prepareHDStationITag(RadioData.getAmfmDatabase().getCurrentHDStation());
                break;
            }
            case 0x400004E0: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(" ASL_RADIO_STORE_HD_RADIO_SONG_TAG ").append("ADD Event received from Model ").log();
                }
                TagInformation tagInformation = null;
                TagInformation tagInformation2 = null;
                if (RadioCurrentWaveband.isSdars()) {
                    RadioUtil.traceSdars("+ASL_RADIO_STORE_HD_RADIO_SONG_TAG");
                    SatDb satDb = SatDb.getInstance();
                    StationInfo stationInfo = satDb.getPool().getChannel(23);
                    if (stationInfo != null) {
                        int n = stationInfo.getSID();
                        RadioText radioText = satDb.getRadioTextHandler().get(n);
                        if (radioText != null) {
                            tagInformation = this.prepareTag(radioText, true);
                        }
                    }
                    if (tagInformation == null) break;
                    RadioServiceManager.getServiceManager().setTaggingSatChannel(stationInfo);
                    this.addTag(tagInformation, tagInformation2);
                    break;
                }
                if (!RadioCurrentWaveband.isFm() && !RadioCurrentWaveband.isAm()) break;
                if (this.getTimerServer().isTimerActive(this.getTargetId(), -1568276224)) {
                    this.taggingAmbiguousZoneSongStart = true;
                }
                this.enableTagButton(false);
                this.startTimer(-1585053440, (long)0, false);
                break;
            }
            case 1073743006: {
                if (RadioCurrentWaveband.isSdars()) {
                    RadioUtil.traceSdars("+ASL_RADIO_DELETE_SONG_TAG");
                }
                int n = eventGeneric.getInt(0);
                this.removeTag(n);
                break;
            }
            case 1073743007: {
                if (RadioCurrentWaveband.isSdars()) {
                    RadioUtil.traceSdars("+ASL_RADIO_DELETE_SONG_TAGS");
                }
                this.removeAllTags();
                if (RadioCurrentWaveband.isSdars()) {
                    this.prepareRadioTextITag(false);
                    break;
                }
                if (!RadioCurrentWaveband.isFm() && !RadioCurrentWaveband.isAm()) break;
                this.prepareHDStationITag(RadioData.getAmfmDatabase().getCurrentHDStation());
                break;
            }
            case 100001: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(" EV_TAGGING_ADD_TAG ").append(" in case of HD Sending Adding tag request after 10 seconds ").log();
                }
                if (this.taggingAmbiguousZoneSongStart) {
                    this.prepareAndAddAmbiguousTag(RadioData.getAmfmDatabase().getCurrentHDStation(), RadioData.getAmfmDatabase().getPreviousHDStation());
                    this.taggingAmbiguousZoneSongStart = false;
                    break;
                }
                if (this.tagActivationPending) {
                    HdStationInfo hdStationInfo = this.isHdStationValidForTagging(RadioData.getAmfmDatabase().getCurrentHDStation()) ? RadioData.getAmfmDatabase().getCurrentHDStation() : null;
                    this.prepareAndAddAmbiguousTag(RadioData.getAmfmDatabase().getPreviousHDStation(), hdStationInfo);
                    this.tagActivationPending = false;
                    break;
                }
                this.prepareAndAddAmbiguousTag(RadioData.getAmfmDatabase().getCurrentHDStation(), null);
                break;
            }
            case 40678: {
                TagInformation tagInformation;
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(" ASL_ITUNES_TAG_ADDED_RESPONSE ").append("Adding Tag is finished ").log();
                }
                if (!RadioCurrentWaveband.isFm() && !RadioCurrentWaveband.isAm() || (tagInformation = this.prepareTag(RadioData.getAmfmDatabase().getCurrentHDStation(), false, false)) == null) break;
                this.sendTagForActivation(tagInformation);
                break;
            }
            case 100003: {
                this.prepareRadioTextITag(false);
                break;
            }
        }
    }

    TagInformation getEmptyTagInformation() {
        if (this.iTagInfo == null) {
            this.iTagInfo = new TagInformation(false, false, "", "", "", null, "", "", null, "", "", 0, 0, "", "", 0);
        }
        return this.iTagInfo;
    }

    protected void prepareRadioTextITag(StationInfo stationInfo) {
        this.mSDARSStation = stationInfo;
        this.prepareRadioTextITag(true);
    }

    protected void prepareRadioTextITag(boolean bl) {
        SatDb satDb;
        PreviewHandler previewHandler;
        StationInfo stationInfo;
        StationInfo stationInfo2;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(" prepareRadioTextITag ").log();
        }
        if (RadioCurrentWaveband.isSdars() && (stationInfo2 = (stationInfo = (previewHandler = (satDb = SatDb.getInstance()).getPreviewHandler()).getPreviewChannel()) != null ? stationInfo : satDb.getPool().getChannel(23)) != null) {
            int n = stationInfo2.getSID();
            RadioText radioText = SatDb.getInstance().getRadioTextHandler().get(n);
            if (radioText != null) {
                TagInformation tagInformation;
                if (bl) {
                    if (this.mSDARSStation != null && this.mSDARSStation.stationNumber != 0 && radioText.longArtistName.equals("") && radioText.longProgramTitle.equals("")) {
                        this.startTimer(-1551499008, (long)0, false);
                    }
                    this.sendTagForActivation(this.getEmptyTagInformation());
                    return;
                }
                if (this.getTimerServer().isTimerActive(this.getTargetId(), -1551499008) && !radioText.longArtistName.equals("") && !radioText.longProgramTitle.equals("")) {
                    this.stopTimer(-1551499008);
                }
                if (radioText != null && (tagInformation = this.prepareTag(radioText, false)) != null) {
                    this.sendTagForActivation(tagInformation);
                }
            }
        }
    }

    void prepareHDStationITag(HdStationInfo hdStationInfo) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(" prepareHDStationITag ").log();
        }
        if (hdStationInfo != null) {
            if (this.getTimerServer().isTimerActive(this.getTargetId(), -1585053440)) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append("Activation of tag is set to pending because of adding tag is in process ").log();
                }
                HdStationInfo hdStationInfo2 = RadioData.getAmfmDatabase().getPreviousHDStation();
                if (hdStationInfo.frequency != hdStationInfo2.frequency || hdStationInfo.serviceId != hdStationInfo2.serviceId) {
                    this.stopTimer(-1585053440);
                    this.prepareAndAddAmbiguousTag(hdStationInfo2, null);
                } else {
                    this.tagActivationPending = true;
                }
            } else {
                TagInformation tagInformation = this.prepareTag(hdStationInfo, false, false);
                if (tagInformation != null) {
                    this.sendTagForActivation(tagInformation);
                }
            }
        }
    }

    protected void prepareHdStationInfoForITag(HdStationInfo hdStationInfo, boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(" Tagging Target : prepareHdStationInfoForITag ").log();
        }
        if (hdStationInfo != null) {
            if (this.isStationChanged()) {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(" prepareHdStationInfoForITag :  Station changed ").log();
                }
                this.setStationChanged(false);
                if (this.getTimerServer().isTimerActive(this.getTargetId(), -1568276224)) {
                    this.stopTimer(-1568276224);
                }
                if (this.getTimerServer().isTimerActive(this.getTargetId(), -1585053440)) {
                    this.stopTimer(-1585053440);
                    this.prepareAndAddAmbiguousTag(RadioData.getAmfmDatabase().getPreviousHDStation(), null);
                    this.taggingAmbiguousZoneSongStart = false;
                    this.tagActivationPending = false;
                    return;
                }
                TagInformation tagInformation = this.prepareTag(hdStationInfo, false, false);
                if (tagInformation != null) {
                    this.sendTagForActivation(tagInformation);
                }
            } else {
                if (bl) {
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append(" prepareHdStationInfoForITag :  HD Station info changed ").log();
                    }
                    this.startTimer(-1568276224, (long)0, false);
                }
                if (this.getTimerServer().isTimerActive(this.getTargetId(), -1585053440)) {
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append(" prepareHdStationInfoForITag :  Tag received while adding tag is in process ").log();
                    }
                    this.tagActivationPending = true;
                    return;
                }
                TagInformation tagInformation = this.prepareTag(hdStationInfo, false, false);
                if (tagInformation != null) {
                    this.sendTagForActivation(tagInformation);
                }
            }
        }
    }

    protected void requestTaggingInstance(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("TaggingTarget - requestTaggingInstance() - instanceNotAvailable = ").append(bl).log();
        }
        if (bl) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("requesting new instance number for tagging ").log();
            }
            this.requestInstance();
        } else {
            this.loadTagDatabase();
        }
    }

    boolean isStationChanged() {
        return this.stationChanged;
    }

    protected void setStationChanged(boolean bl) {
        this.stationChanged = bl;
    }

    public void stopAmbiguousTagging() {
        this.stopTimer(-1585053440);
        this.stopTimer(-1568276224);
        if (this.isTagButtonEnabled()) {
            this.enableTagButton(false);
        }
    }

    TagInformation prepareTag(HdStationInfo hdStationInfo, boolean bl, boolean bl2) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("Prepare TagInformation with HD Station ").log();
        }
        TagInformation tagInformation = null;
        AmFmStation amFmStation = null;
        if (hdStationInfo != null) {
            Object object;
            if (RadioCurrentWaveband.isAm()) {
                amFmStation = RadioData.getAmfmDatabase().getAslStationListAM().getByFrequencyAndSubChannel(hdStationInfo.getFrequency(), hdStationInfo.getServiceId());
            } else if (RadioCurrentWaveband.isFm()) {
                amFmStation = RadioData.getAmfmDatabase().getAslStationListFM().getByFrequencyAndSubChannel(hdStationInfo.getFrequency(), hdStationInfo.getServiceId());
            }
            if (amFmStation == null || amFmStation.getShortNameHD().length() <= 0) {
                object = SelectedStationHighlighting.getTunedStationByApplication();
                amFmStation = !HsmTarget.waitingForUpdateSelectedStation && SelectedStationHighlighting.getStationSelectionIsActive() && null != object ? new AmFmStation((AmFmStation)object) : RadioData.getAmfmDatabase().getCurrentStation();
            }
            tagInformation = new TagInformation();
            tagInformation.ambiguousTag = bl;
            tagInformation.buttonPressed = bl2;
            tagInformation.title = null != hdStationInfo.songTitle ? (hdStationInfo.songTitle.trim().equals("") ? null : hdStationInfo.songTitle.trim()) : null;
            tagInformation.artist = null != hdStationInfo.artistName ? (hdStationInfo.artistName.trim().equals("") ? null : hdStationInfo.artistName.trim()) : null;
            tagInformation.songID = null != hdStationInfo.iTunesID ? (hdStationInfo.iTunesID.trim().equals("") ? null : hdStationInfo.iTunesID.trim()) : null;
            object = Integer.toString(hdStationInfo.frequency);
            Object object2 = tagInformation.stationFrequency = ((String)object).equals("0") ? null : object;
            tagInformation.stationCallLetters = amFmStation != null ? (amFmStation.getShortNameHD().trim().equals("") ? null : amFmStation.getShortNameHD().trim()) : null;
            tagInformation.stationURL = null == hdStationInfo.stationURL || hdStationInfo.stationURL.trim().equals("") ? null : hdStationInfo.stationURL.trim();
            tagInformation.timeStamp = null;
            tagInformation.affiliateID = null != hdStationInfo.affiliateID ? (hdStationInfo.affiliateID.trim().equals("") ? null : hdStationInfo.affiliateID.trim()) : null;
            tagInformation.album = null != hdStationInfo.albumTitle ? (hdStationInfo.albumTitle.trim().equals("") ? null : hdStationInfo.albumTitle.trim()) : null;
            tagInformation.iTunesFrontID = hdStationInfo.iTunesFrontID;
            tagInformation.podcastFeedURL = hdStationInfo.podcastFeedURL;
            tagInformation.genre = null != hdStationInfo.genre ? (hdStationInfo.genre.trim().equals("") ? null : hdStationInfo.genre.trim()) : null;
            tagInformation.unknownData = null != hdStationInfo.unknownData ? (hdStationInfo.unknownData.trim().equals("") ? null : hdStationInfo.unknownData.trim()) : null;
            tagInformation.programNumber = hdStationInfo.serviceId == 0 ? 0 : AMFMMath.log2(hdStationInfo.serviceId) + 1;
        }
        return tagInformation;
    }

    TagInformation prepareTag(RadioText radioText, boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("Prepare TagInformation with RadioText ").log();
        }
        TagInformation tagInformation = null;
        if (radioText != null && this.mSDARSStation != null) {
            tagInformation = new TagInformation();
            tagInformation.ambiguousTag = false;
            tagInformation.buttonPressed = bl;
            String string = null;
            String string2 = "";
            if (null != radioText.getLongProgramTitle()) {
                string2 = radioText.getLongProgramTitle().trim();
            }
            String string3 = "";
            if (null != radioText.getShortProgramTitle()) {
                string3 = radioText.getShortProgramTitle().trim();
            }
            if (!string2.equals("")) {
                string = string2;
            } else if (!string3.equals("")) {
                string = string3;
            }
            tagInformation.title = string;
            String string4 = null;
            String string5 = "";
            if (null != radioText.getLongArtistName()) {
                string5 = radioText.getLongArtistName().trim();
            }
            String string6 = "";
            if (null != radioText.getShortArtistName()) {
                string6 = radioText.getShortArtistName().trim();
            }
            if (!string5.equals("")) {
                string4 = string5;
            } else if (!string6.equals("")) {
                string4 = string6;
            }
            tagInformation.artist = string4;
            tagInformation.songID = radioText.getITunesID() == 0 ? null : Integer.toString(radioText.getITunesID()).trim();
            StationInfo stationInfo = SatDb.getInstance().getPool().getChannel(15);
            String string7 = null;
            if (null != stationInfo) {
                string7 = Short.toString(stationInfo.getStationNumber());
            }
            tagInformation.stationFrequency = string7;
            String string8 = null;
            String string9 = "";
            if (null != this.mSDARSStation.getFullLabel()) {
                string9 = this.mSDARSStation.getFullLabel().trim();
            }
            String string10 = "";
            if (null != this.mSDARSStation.getShortLabel()) {
                string10 = this.mSDARSStation.getShortLabel().trim();
            }
            if (!string9.equals("")) {
                string8 = string9;
            } else if (!string10.equals("")) {
                string8 = string10;
            }
            tagInformation.stationCallLetters = string8;
            tagInformation.stationURL = null == this.mITunesSXMURL || this.mITunesSXMURL.trim().equals("") ? null : this.mITunesSXMURL.trim();
            AslPool aslPool = SatDb.getInstance().getPool();
            long l = aslPool.getLong(66);
            long l2 = aslPool.getLong(67);
            long l3 = l - l2;
            long l4 = ASLSystemFactory.getSystemApi().getCurrentTimestamp();
            long l5 = l4 + l3;
            DateTime dateTime = new DateTime(l5);
            tagInformation.timeStamp = dateTime.getTime() <= 0L ? null : dateTime;
            tagInformation.affiliateID = this.mAffiliateID.trim().equals("") ? null : this.mAffiliateID.trim();
            tagInformation.album = radioText.getComposer().trim().equals("") ? null : radioText.getComposer().trim();
            tagInformation.iTunesFrontID = 0;
            tagInformation.podcastFeedURL = 0;
            tagInformation.genre = null;
            tagInformation.unknownData = null;
            tagInformation.programNumber = 0;
        }
        return tagInformation;
    }

    void prepareAndAddAmbiguousTag(HdStationInfo hdStationInfo, HdStationInfo hdStationInfo2) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("prepareAndAddAmbiguousTag").log();
        }
        TagInformation tagInformation = null;
        TagInformation tagInformation2 = null;
        boolean bl = false;
        if (hdStationInfo != null) {
            if (hdStationInfo2 != null && this.isHdStationValidForTagging(hdStationInfo2) && !hdStationInfo.getSongTitle().equals(hdStationInfo2.getSongTitle()) && !hdStationInfo.getArtistName().equals(hdStationInfo2.getArtistName())) {
                bl = true;
                tagInformation2 = this.prepareTag(hdStationInfo2, bl, false);
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append("Tagging Target ").append("Ambiguous Tag : ").append(tagInformation2.toString()).log();
                }
            }
            tagInformation = this.prepareTag(hdStationInfo, bl, true);
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("Tagging Target ").append("Actual Tag : ").append(tagInformation.toString()).log();
            }
        }
        RadioServiceManager.getServiceManager().setTaggingFMHDStationInfo(hdStationInfo);
        this.addTag(tagInformation, tagInformation2);
    }

    void loadTagDatabase() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("Sending load Tag database Event ").log();
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-576847872);
        eventGeneric.setInt(0, RadioData.getAmfmDatabase().getTaggingInstance());
        this.mTarget.sendSafe(eventGeneric);
    }

    void sendTagForActivation(TagInformation tagInformation) {
        if (null == tagInformation) {
            ServiceManager.logger.error(128).append("TaggingTarget - sendTagForActivation() - null == tagInfo").log();
            return;
        }
        if (null == RadioData.getAmfmDatabase()) {
            ServiceManager.logger.error(128).append("TaggingTarget - sendTagForActivation() - null == RadioData.mAmfmDatabase").log();
            return;
        }
        int n = RadioData.getAmfmDatabase().getTaggingInstance();
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("TaggingTarget - sendTagForActivation() - taggingInstance = ").append(n).log();
        }
        if (n > -1) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-459407360);
            eventGeneric.setInt(0, n);
            eventGeneric.setObject(1, tagInformation);
            this.mTarget.sendSafe(eventGeneric);
        }
    }

    void addTag(TagInformation tagInformation, TagInformation tagInformation2) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("Sending add Tag Event ").log();
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-560070656);
        eventGeneric.setInt(0, RadioData.getAmfmDatabase().getTaggingInstance());
        eventGeneric.setObject(1, tagInformation);
        eventGeneric.setObject(2, tagInformation2);
        this.mTarget.sendSafe(eventGeneric);
    }

    void removeTag(int n) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("Sending Remove Tag Event ").log();
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-476184576);
        eventGeneric.setInt(0, RadioData.getAmfmDatabase().getTaggingInstance());
        eventGeneric.setInt(1, n);
        eventGeneric.setObject(2, null);
        this.mTarget.sendSafe(eventGeneric);
    }

    void removeAllTags() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("Sending Remove all tags Event ").log();
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-492961792);
        eventGeneric.setInt(0, RadioData.getAmfmDatabase().getTaggingInstance());
        this.mTarget.sendSafe(eventGeneric);
    }

    void requestInstance() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("Sending Request instance Event ").log();
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-526516224);
        eventGeneric.setString(0, "RADIO");
        this.mTarget.sendSafe(eventGeneric);
    }

    void resetInstance() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("Sending Reset instance Event ").log();
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-409075712);
        eventGeneric.setInt(0, RadioData.getAmfmDatabase().getTaggingInstance());
        this.mTarget.sendSafe(eventGeneric);
    }

    void enableTagButton(boolean bl) {
        this.tagButtonEnabled = bl;
        AmFmFactory.getAslAmfmModelController().enableTaggingButton(bl);
    }

    boolean isTagButtonEnabled() {
        return this.tagButtonEnabled;
    }

    boolean isHdStationValidForTagging(HdStationInfo hdStationInfo) {
        return hdStationInfo != null && !hdStationInfo.songTitle.equals("") && !hdStationInfo.artistName.equals("");
    }

    protected void setSXMTagInformation(String string, String string2) {
        this.mITunesSXMURL = string;
        this.mAffiliateID = string2;
    }
}

