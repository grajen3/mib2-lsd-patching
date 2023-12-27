/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.media;

import de.vw.mib.bap.mqbab2.common.api.APIFactoryInterface;
import de.vw.mib.bap.mqbab2.common.api.asl.HMIRelevantASLDataPoolAdapter;
import de.vw.mib.bap.mqbab2.common.api.media.MediaService;
import de.vw.mib.bap.mqbab2.common.api.media.MediaServiceListener;
import de.vw.mib.bap.mqbab2.common.api.media.datatypes.MediaAction;
import de.vw.mib.bap.mqbab2.common.api.media.datatypes.MediaActiveTrackInfo;
import de.vw.mib.bap.mqbab2.common.api.media.datatypes.MediaBrowsedFolder;
import de.vw.mib.bap.mqbab2.common.api.media.datatypes.MediaBrowsedFolderActiveElement;
import de.vw.mib.bap.mqbab2.common.api.media.datatypes.MediaCurrentTrackInfo;
import de.vw.mib.bap.mqbab2.common.api.media.datatypes.iterator.asl.AvailableAudioSourcesASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.media.datatypes.iterator.asl.FileBrowserASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.media.datatypes.iterator.asl.FileBrowserWindowedASLDataPoolIterator;
import de.vw.mib.datapool.ASLDatapool;
import de.vw.mib.genericevents.EventGeneric;
import java.util.Iterator;
import java.util.List;

public class MediaASLDataAdapter
extends HMIRelevantASLDataPoolAdapter
implements MediaService,
MediaCurrentTrackInfo,
MediaActiveTrackInfo,
MediaAction,
MediaBrowsedFolder,
MediaBrowsedFolderActiveElement {
    private APIFactoryInterface apiFactory;
    private static final int[] MEDIA_ASL_PROPERTY_IDS_TO_LISTEN_TO = new int[]{8, 9, 6, 3520, 124, 125, 138, 152, 492571648, 542903296, 2849, 50, 85, 45, 44, 41, 46, 55, 54, 29, 30, 7, 11, 2735, 17, 2734, 777784320, 3678, 2781};
    private static final int[] MEDIA_ASL_LIST_ITEM_IDS_TO_LISTEN_TO = new int[]{58, 526126080, 3834, 3831, 509348864, 56, 3829};
    private static final int[] MEDIA_HMI_EVENT_IDS_TO_LISTEN_TO = new int[]{430, 556};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$common$api$media$MediaService;

    public MediaASLDataAdapter(APIFactoryInterface aPIFactoryInterface, ASLDatapool aSLDatapool) {
        super(aSLDatapool);
        this.apiFactory = aPIFactoryInterface;
        this.apiFactory.getHMIEventService().addHMIEventListener(this, MEDIA_HMI_EVENT_IDS_TO_LISTEN_TO);
    }

    protected APIFactoryInterface getAPIFactory() {
        return this.apiFactory;
    }

    public static Class getServiceClass() {
        return class$de$vw$mib$bap$mqbab2$common$api$media$MediaService == null ? (class$de$vw$mib$bap$mqbab2$common$api$media$MediaService = MediaASLDataAdapter.class$("de.vw.mib.bap.mqbab2.common.api.media.MediaService")) : class$de$vw$mib$bap$mqbab2$common$api$media$MediaService;
    }

    @Override
    public int getCurrentAudioSource() {
        return this.getDataPool().getInteger(8, 0);
    }

    @Override
    public int getCurrrentAudioSourceState() {
        return this.getDataPool().getInteger(9, 0);
    }

    @Override
    public boolean getWlanDeviceConnected() {
        return this.getDataPool().getBoolean(945556480, false);
    }

    @Override
    public int getCurrentTrackNumber() {
        return MediaASLDataAdapter.getIntegerListValue(58, 7);
    }

    @Override
    public String getCurrentTrackTitle() {
        return MediaASLDataAdapter.getStringListValue(58, 5);
    }

    @Override
    public String getCurrentTrackArtist() {
        return MediaASLDataAdapter.getStringListValue(58, 1);
    }

    @Override
    public String getCurrentTrackAlbum() {
        return MediaASLDataAdapter.getStringListValue(58, 0);
    }

    @Override
    public String getCurrentTrackFilename() {
        return MediaASLDataAdapter.getStringListValue(58, 8);
    }

    @Override
    public MediaCurrentTrackInfo getCurrentTrackInfo() {
        return this;
    }

    @Override
    public int getActiveTrackAbsolutePosition() {
        return MediaASLDataAdapter.getIntegerListValue(526126080, 2);
    }

    @Override
    public long getActiveTrackEntryId() {
        return MediaASLDataAdapter.getLongListValue(526126080, 1);
    }

    @Override
    public int getActiveTrackContentType() {
        return MediaASLDataAdapter.getIntegerListValue(526126080, 0);
    }

    @Override
    public MediaActiveTrackInfo getActiveTrackInfo() {
        return this;
    }

    @Override
    public int getCDMediumType() {
        return this.getDataPool().getInteger(6, 0);
    }

    @Override
    public int getCDContentType() {
        return this.getDataPool().getInteger(3520, 0);
    }

    @Override
    public int getDvdChapter() {
        return this.getDataPool().getInteger(124, 3);
    }

    @Override
    public int getDvdChapterCount() {
        return this.getDataPool().getInteger(125, 0);
    }

    @Override
    public boolean isDvdMainMenuActive() {
        return this.getDataPool().getBoolean(138, false);
    }

    @Override
    public boolean isDVDRegionCodeMismatched() {
        return this.getDataPool().getBoolean(152, false);
    }

    @Override
    public boolean isBapMediaBrowserAvailable() {
        return this.getDataPool().getBoolean(492571648, false);
    }

    @Override
    public int getBapMediaBrowserState() {
        return this.getDataPool().getInteger(542903296, -1);
    }

    @Override
    public String getCurrentlyPlayedFolderName() {
        return this.getDataPool().getString(2849, "");
    }

    @Override
    public boolean isRepeatSupported() {
        return this.getDataPool().getBoolean(50, false);
    }

    @Override
    public boolean isRepeatActive() {
        return this.getDataPool().getInteger(85, 0) != 0;
    }

    @Override
    public int getRepeatMode() {
        return this.getDataPool().getInteger(85, 0);
    }

    @Override
    public boolean isMixSupported() {
        return this.getDataPool().getBoolean(45, false);
    }

    @Override
    public boolean isMixActive() {
        return this.getDataPool().getBoolean(44, false);
    }

    @Override
    public boolean areSubfoldersIncluded() {
        return this.getDataPool().getBoolean(41, true);
    }

    @Override
    public boolean isPlayMoreLikeThisActive() {
        return this.getDataPool().getBoolean(46, false);
    }

    @Override
    public boolean isSkipForwardSupported() {
        return this.getDataPool().getBoolean(55, false);
    }

    @Override
    public boolean isSkipBackwardSupported() {
        return this.getDataPool().getBoolean(54, false);
    }

    @Override
    public int getPlayerState() {
        return this.getDataPool().getInteger(29, 0);
    }

    @Override
    public int getRemoteControlPlayerState() {
        return this.getDataPool().getInteger(30, 0);
    }

    @Override
    public int getConnectedMitsumiAdapter() {
        return this.getDataPool().getInteger(7, 0);
    }

    @Override
    public int getCurrentImportSource() {
        return this.getDataPool().getInteger(11, 0);
    }

    @Override
    public int getCurrentImportState() {
        return this.getDataPool().getInteger(2735, 0);
    }

    @Override
    public int getCurrentImportProgress() {
        return this.getDataPool().getInteger(17, 0);
    }

    @Override
    public int getJukeboxDeletionState() {
        return this.getDataPool().getInteger(2734, 0);
    }

    @Override
    public int getCurrentActionStatus() {
        return MediaASLDataAdapter.getIntegerListValue(3834, 0);
    }

    @Override
    public int getCurrentActionType() {
        return MediaASLDataAdapter.getIntegerListValue(3834, 1);
    }

    @Override
    public MediaAction getCurrentAction() {
        return this;
    }

    @Override
    public int getBrowsedFolderLevel() {
        return MediaASLDataAdapter.getIntegerListValue(3831, 2);
    }

    @Override
    public long getBrowsedFolderEntryId() {
        return MediaASLDataAdapter.getLongListValue(3831, 7);
    }

    @Override
    public int getBrowsedFolderContentType() {
        return MediaASLDataAdapter.getIntegerListValue(3831, 6);
    }

    @Override
    public String getBrowsedFolderName() {
        return MediaASLDataAdapter.getStringListValue(3831, 0);
    }

    @Override
    public MediaBrowsedFolder getCurrentlyBrowsedFolder() {
        return this;
    }

    @Override
    public int getBrowsedFolderActiveElementAbsolutePosition() {
        return MediaASLDataAdapter.getIntegerListValue(509348864, 2);
    }

    @Override
    public long getBrowsedFolderActiveElementEntryId() {
        return MediaASLDataAdapter.getLongListValue(509348864, 0);
    }

    @Override
    public int getBrowsedFolderActiveElementContentType() {
        return MediaASLDataAdapter.getIntegerListValue(509348864, 1);
    }

    @Override
    public MediaBrowsedFolderActiveElement getBrowsedFolderActiveElement() {
        return this;
    }

    @Override
    public Iterator getFileBrowser() {
        return new FileBrowserASLDataPoolIterator();
    }

    @Override
    public Iterator getWindowedFileBrowser(int[] nArray) {
        return new FileBrowserWindowedASLDataPoolIterator(nArray);
    }

    @Override
    public boolean isDatabaseBrowsingActive() {
        return this.getDataPool().getBoolean(777784320, false);
    }

    @Override
    public boolean isSecondUSBSocketAvailable() {
        return this.getDataPool().getBoolean(3678, false);
    }

    @Override
    public boolean isMetaInfoRequestSupported() {
        return this.getDataPool().getBoolean(2781, false);
    }

    @Override
    public Iterator getAvailableAudioSources() {
        return new AvailableAudioSourcesASLDataPoolIterator();
    }

    @Override
    public int getBapContentTypeForActiveTrack(int n) {
        int n2;
        switch (n) {
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    @Override
    public int getPlayEntryContentTypeForFileBrowserContentType(int n) {
        int n2;
        switch (n) {
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            case 5: {
                n2 = 5;
                break;
            }
            case 6: {
                n2 = 6;
                break;
            }
            case 7: {
                n2 = 7;
                break;
            }
            case 8: {
                n2 = 8;
                break;
            }
            case 9: {
                n2 = 9;
                break;
            }
            case 10: {
                n2 = 10;
                break;
            }
            case 11: {
                n2 = 11;
                break;
            }
            case 13: {
                n2 = 12;
                break;
            }
            case 14: {
                n2 = 13;
                break;
            }
            case 15: {
                n2 = 14;
                break;
            }
            case 16: {
                n2 = 15;
                break;
            }
            case 17: {
                n2 = 16;
                break;
            }
            case 18: {
                n2 = 17;
                break;
            }
            case 19: {
                n2 = 18;
                break;
            }
            case 20: {
                n2 = 19;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    @Override
    public int getFolderContentTypeForFilerBrowserContentType(int n) {
        int n2;
        switch (n) {
            case 4: {
                n2 = 1;
                break;
            }
            case 5: {
                n2 = 2;
                break;
            }
            case 6: {
                n2 = 3;
                break;
            }
            case 7: {
                n2 = 4;
                break;
            }
            case 8: {
                n2 = 5;
                break;
            }
            case 9: {
                n2 = 6;
                break;
            }
            case 10: {
                n2 = 7;
                break;
            }
            case 11: {
                n2 = 8;
                break;
            }
            case 13: {
                n2 = 9;
                break;
            }
            case 14: {
                n2 = 10;
                break;
            }
            case 15: {
                n2 = 11;
                break;
            }
            case 16: {
                n2 = 12;
                break;
            }
            case 17: {
                n2 = 13;
                break;
            }
            case 18: {
                n2 = 14;
                break;
            }
            case 19: {
                n2 = 15;
                break;
            }
            case 20: {
                n2 = 16;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    @Override
    public int getBapContentTypeForBrowsedFolderActiveElement(int n) {
        int n2;
        switch (n) {
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            case 5: {
                n2 = 5;
                break;
            }
            case 6: {
                n2 = 6;
                break;
            }
            case 7: {
                n2 = 7;
                break;
            }
            case 8: {
                n2 = 8;
                break;
            }
            case 9: {
                n2 = 9;
                break;
            }
            case 10: {
                n2 = 10;
                break;
            }
            case 11: {
                n2 = 11;
                break;
            }
            case 12: {
                n2 = 13;
                break;
            }
            case 13: {
                n2 = 14;
                break;
            }
            case 14: {
                n2 = 15;
                break;
            }
            case 15: {
                n2 = 16;
                break;
            }
            case 16: {
                n2 = 17;
                break;
            }
            case 17: {
                n2 = 18;
                break;
            }
            case 18: {
                n2 = 19;
                break;
            }
            case 19: {
                n2 = 20;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    @Override
    public int getBapContentTypeForBrowsedFolder(int n) {
        int n2;
        switch (n) {
            case 1: {
                n2 = 4;
                break;
            }
            case 2: {
                n2 = 5;
                break;
            }
            case 3: {
                n2 = 6;
                break;
            }
            case 4: {
                n2 = 7;
                break;
            }
            case 5: {
                n2 = 8;
                break;
            }
            case 6: {
                n2 = 9;
                break;
            }
            case 7: {
                n2 = 10;
                break;
            }
            case 8: {
                n2 = 11;
                break;
            }
            case 9: {
                n2 = 13;
                break;
            }
            case 10: {
                n2 = 14;
                break;
            }
            case 11: {
                n2 = 15;
                break;
            }
            case 12: {
                n2 = 16;
                break;
            }
            case 13: {
                n2 = 17;
                break;
            }
            case 14: {
                n2 = 18;
                break;
            }
            case 15: {
                n2 = 19;
                break;
            }
            case 16: {
                n2 = 20;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    @Override
    public void toggleSubfolderInclusionState() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(520093760);
    }

    @Override
    public void startFastForward() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(385876032);
        this.getAPIFactory().getSpeechService().performingBAPAction(2);
    }

    @Override
    public void startFastRewind() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(402653248);
        this.getAPIFactory().getSpeechService().performingBAPAction(2);
    }

    @Override
    public void stopFastForward() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(419430464);
        this.getAPIFactory().getSpeechService().performingBAPAction(2);
    }

    @Override
    public void stopFastRewind() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(436207680);
        this.getAPIFactory().getSpeechService().performingBAPAction(2);
    }

    @Override
    public void activateAudioSourceByID(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(0x2000040, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(0);
    }

    @Override
    public void skipForwardWithCounter(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(705298496, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(2);
    }

    @Override
    public void skipBackwardWithCounter(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setBoolean(0, true);
        eventGeneric.setInt(1, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(688521280, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(2);
    }

    @Override
    public void activateNextDVDChapter() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(1660944448);
        this.getAPIFactory().getSpeechService().performingBAPAction(2);
    }

    @Override
    public void activatePreviousDVDChapter() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(1694498880);
        this.getAPIFactory().getSpeechService().performingBAPAction(2);
    }

    @Override
    public void activateSelectedDVDMenuItem() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(1728053312);
        this.getAPIFactory().getSpeechService().performingBAPAction(2);
    }

    @Override
    public void setRepeatMode(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(1056964672, eventGeneric);
    }

    @Override
    public void setMixMode(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(989855808, eventGeneric);
    }

    @Override
    public void setPlayMoreLikeThisState(boolean bl) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setBoolean(0, bl);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(1023410240, eventGeneric);
    }

    @Override
    public void startBrowsingSourceById(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-938868672, eventGeneric);
    }

    @Override
    public void openFolderEntry(long l, int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setLong(0, l);
        eventGeneric.setInt(1, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(238357568, eventGeneric);
    }

    @Override
    public void moveFolderLevelUp(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-905314240, eventGeneric);
    }

    @Override
    public void triggerFollowMode() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-888537024);
    }

    @Override
    public void playFileEntry(long l, int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setLong(0, l);
        eventGeneric.setInt(1, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(255134784, eventGeneric);
    }

    @Override
    public void setPlayerPaused() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(288689216);
    }

    @Override
    public void datapoolValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredServiceDelegates(n);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                MediaServiceListener mediaServiceListener = (MediaServiceListener)iterator.next();
                mediaServiceListener.updateMediaData(this, n);
            }
        }
    }

    @Override
    protected int[] getPropertyIds() {
        return MEDIA_ASL_PROPERTY_IDS_TO_LISTEN_TO;
    }

    @Override
    protected int[] getListIds() {
        return MEDIA_ASL_LIST_ITEM_IDS_TO_LISTEN_TO;
    }

    @Override
    protected void listValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    public void addMediaServiceListener(MediaServiceListener mediaServiceListener, int[] nArray) {
        this.registerServiceListener((Object)mediaServiceListener, nArray);
    }

    @Override
    public void removeMediaServiceListener(MediaServiceListener mediaServiceListener, int[] nArray) {
        this.removeServiceListener(mediaServiceListener, nArray);
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

