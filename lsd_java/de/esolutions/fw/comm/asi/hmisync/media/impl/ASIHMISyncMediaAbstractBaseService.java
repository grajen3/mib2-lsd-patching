/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaReply;
import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaS;
import de.esolutions.fw.comm.asi.hmisync.media.MediaActiveSourceState;
import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaI18NString;
import de.esolutions.fw.comm.asi.hmisync.media.MediaPlayTime;
import de.esolutions.fw.comm.asi.hmisync.media.MediaPlaylistState;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaAbstractBaseService$AttributesBitMapProvider;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncMediaAbstractBaseService
implements ASIHMISyncMediaS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.media.ASIHMISyncMedia");
    private static final int attributesCount;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private short[] RequestIDs;
    private boolean RequestIDs_valid = false;
    private short[] ReplyIDs;
    private boolean ReplyIDs_valid = false;
    private MediaSourceSlot[] SourceList;
    private boolean SourceList_valid = false;
    private MediaActiveSourceState ActiveSlotState;
    private boolean ActiveSlotState_valid = false;
    private int PlaybackState;
    private boolean PlaybackState_valid = false;
    private MediaPlaylistState ListState;
    private boolean ListState_valid = false;
    private int PlayerCapabilities;
    private boolean PlayerCapabilities_valid = false;
    private boolean Mix;
    private boolean Mix_valid = false;
    private boolean RepeatTitle;
    private boolean RepeatTitle_valid = false;
    private int RepeatState;
    private boolean RepeatState_valid = false;
    private int ShuffleState;
    private boolean ShuffleState_valid = false;
    private MediaEntry PlayingTrack;
    private boolean PlayingTrack_valid = false;
    private MediaPlayTime PlayPosition;
    private boolean PlayPosition_valid = false;
    private MediaEntry[] PlaybackFolder;
    private boolean PlaybackFolder_valid = false;
    private int PlaybackPossible;
    private boolean PlaybackPossible_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
    }

    public static MediaSourceSlot copyMediaSourceSlot(MediaSourceSlot mediaSourceSlot) {
        if (mediaSourceSlot == null) {
            return null;
        }
        MediaSourceSlot mediaSourceSlot2 = new MediaSourceSlot();
        mediaSourceSlot2.source = mediaSourceSlot.source;
        mediaSourceSlot2.slotIdx = mediaSourceSlot.slotIdx;
        mediaSourceSlot2.mediaType = mediaSourceSlot.mediaType;
        mediaSourceSlot2.deviceIdx = mediaSourceSlot.deviceIdx;
        mediaSourceSlot2.state = mediaSourceSlot.state;
        mediaSourceSlot2.flags = mediaSourceSlot.flags;
        mediaSourceSlot2.name = ASIHMISyncMediaAbstractBaseService.copyString(mediaSourceSlot.name);
        return mediaSourceSlot2;
    }

    public static MediaActiveSourceState copyMediaActiveSourceState(MediaActiveSourceState mediaActiveSourceState) {
        if (mediaActiveSourceState == null) {
            return null;
        }
        MediaActiveSourceState mediaActiveSourceState2 = new MediaActiveSourceState();
        mediaActiveSourceState2.slot = ASIHMISyncMediaAbstractBaseService.copyMediaSourceSlot(mediaActiveSourceState.slot);
        mediaActiveSourceState2.state = mediaActiveSourceState.state;
        return mediaActiveSourceState2;
    }

    public static MediaPlaylistState copyMediaPlaylistState(MediaPlaylistState mediaPlaylistState) {
        if (mediaPlaylistState == null) {
            return null;
        }
        MediaPlaylistState mediaPlaylistState2 = new MediaPlaylistState();
        mediaPlaylistState2.flags = mediaPlaylistState.flags;
        mediaPlaylistState2.id = mediaPlaylistState.id;
        mediaPlaylistState2.size = mediaPlaylistState.size;
        return mediaPlaylistState2;
    }

    public static MediaEntry copyMediaEntry(MediaEntry mediaEntry) {
        if (mediaEntry == null) {
            return null;
        }
        MediaEntry mediaEntry2 = new MediaEntry();
        mediaEntry2.id = mediaEntry.id;
        mediaEntry2.type = mediaEntry.type;
        mediaEntry2.title = ASIHMISyncMediaAbstractBaseService.copyMediaI18NString(mediaEntry.title);
        mediaEntry2.artist = ASIHMISyncMediaAbstractBaseService.copyMediaI18NString(mediaEntry.artist);
        mediaEntry2.artistID = mediaEntry.artistID;
        mediaEntry2.album = ASIHMISyncMediaAbstractBaseService.copyMediaI18NString(mediaEntry.album);
        mediaEntry2.albumID = mediaEntry.albumID;
        mediaEntry2.genreID = mediaEntry.genreID;
        mediaEntry2.coverUrl = ASIHMISyncMediaAbstractBaseService.copyString(mediaEntry.coverUrl);
        return mediaEntry2;
    }

    public static MediaI18NString copyMediaI18NString(MediaI18NString mediaI18NString) {
        if (mediaI18NString == null) {
            return null;
        }
        MediaI18NString mediaI18NString2 = new MediaI18NString();
        mediaI18NString2.i18nKey = mediaI18NString.i18nKey;
        mediaI18NString2.name = ASIHMISyncMediaAbstractBaseService.copyString(mediaI18NString.name);
        return mediaI18NString2;
    }

    public static MediaPlayTime copyMediaPlayTime(MediaPlayTime mediaPlayTime) {
        if (mediaPlayTime == null) {
            return null;
        }
        MediaPlayTime mediaPlayTime2 = new MediaPlayTime();
        mediaPlayTime2.id = mediaPlayTime.id;
        mediaPlayTime2.time = mediaPlayTime.time;
        mediaPlayTime2.totalTime = mediaPlayTime.totalTime;
        return mediaPlayTime2;
    }

    public ASIHMISyncMediaAbstractBaseService() {
        ASIHMISyncMediaAbstractBaseService$AttributesBitMapProvider aSIHMISyncMediaAbstractBaseService$AttributesBitMapProvider = new ASIHMISyncMediaAbstractBaseService$AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncMedia", aSIHMISyncMediaAbstractBaseService$AttributesBitMapProvider);
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncMediaReply);
        this.sendAttributeUpdate(l, aSIHMISyncMediaReply);
    }

    @Override
    public synchronized void setNotification(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.baseService.setNotification(aSIHMISyncMediaReply);
        this.sendAttributeUpdate(aSIHMISyncMediaReply);
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncMediaReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncMediaReply);
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncMediaReply);
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.baseService.clearNotification(aSIHMISyncMediaReply);
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncMediaReply);
    }

    private void sendAttributeUpdate(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        try {
            aSIHMISyncMediaReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncMediaReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncMediaReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            aSIHMISyncMediaReply.updateSourceList(this.SourceList, this.SourceList_valid);
            aSIHMISyncMediaReply.updateActiveSlotState(this.ActiveSlotState, this.ActiveSlotState_valid);
            aSIHMISyncMediaReply.updatePlaybackState(this.PlaybackState, this.PlaybackState_valid);
            aSIHMISyncMediaReply.updateListState(this.ListState, this.ListState_valid);
            aSIHMISyncMediaReply.updatePlayerCapabilities(this.PlayerCapabilities, this.PlayerCapabilities_valid);
            aSIHMISyncMediaReply.updateMix(this.Mix, this.Mix_valid);
            aSIHMISyncMediaReply.updateRepeatTitle(this.RepeatTitle, this.RepeatTitle_valid);
            aSIHMISyncMediaReply.updateRepeatState(this.RepeatState, this.RepeatState_valid);
            aSIHMISyncMediaReply.updateShuffleState(this.ShuffleState, this.ShuffleState_valid);
            aSIHMISyncMediaReply.updatePlayingTrack(this.PlayingTrack, this.PlayingTrack_valid);
            aSIHMISyncMediaReply.updatePlayPosition(this.PlayPosition, this.PlayPosition_valid);
            aSIHMISyncMediaReply.updatePlaybackFolder(this.PlaybackFolder, this.PlaybackFolder_valid);
            aSIHMISyncMediaReply.updatePlaybackPossible(this.PlaybackPossible, this.PlaybackPossible_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncMediaReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        try {
            if (l == 0) {
                aSIHMISyncMediaReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 0) {
                aSIHMISyncMediaReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 0) {
                aSIHMISyncMediaReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            } else if (l == 0) {
                aSIHMISyncMediaReply.updateSourceList(this.SourceList, this.SourceList_valid);
            } else if (l == 0) {
                aSIHMISyncMediaReply.updateActiveSlotState(this.ActiveSlotState, this.ActiveSlotState_valid);
            } else if (l == 0) {
                aSIHMISyncMediaReply.updatePlaybackState(this.PlaybackState, this.PlaybackState_valid);
            } else if (l == 0) {
                aSIHMISyncMediaReply.updateListState(this.ListState, this.ListState_valid);
            } else if (l == 0) {
                aSIHMISyncMediaReply.updatePlayerCapabilities(this.PlayerCapabilities, this.PlayerCapabilities_valid);
            } else if (l == 0) {
                aSIHMISyncMediaReply.updateMix(this.Mix, this.Mix_valid);
            } else if (l == 0) {
                aSIHMISyncMediaReply.updateRepeatTitle(this.RepeatTitle, this.RepeatTitle_valid);
            } else if (l == 0) {
                aSIHMISyncMediaReply.updateRepeatState(this.RepeatState, this.RepeatState_valid);
            } else if (l == 0) {
                aSIHMISyncMediaReply.updateShuffleState(this.ShuffleState, this.ShuffleState_valid);
            } else if (l == 0) {
                aSIHMISyncMediaReply.updatePlayingTrack(this.PlayingTrack, this.PlayingTrack_valid);
            } else if (l == 0) {
                aSIHMISyncMediaReply.updatePlayPosition(this.PlayPosition, this.PlayPosition_valid);
            } else if (l == 0) {
                aSIHMISyncMediaReply.updatePlaybackFolder(this.PlaybackFolder, this.PlaybackFolder_valid);
            } else if (l == 0) {
                aSIHMISyncMediaReply.updatePlaybackPossible(this.PlaybackPossible, this.PlaybackPossible_valid);
            } else {
                System.out.println("unexpected");
            }
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    public void updateASIVersion(String string) {
        this.updateASIVersion(string, true);
    }

    public void updateASIVersion(String string, boolean bl) {
        this.ASIVersion = ASIHMISyncMediaAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(21);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updateASIVersion(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateRequestIDs(short[] sArray) {
        this.updateRequestIDs(sArray, true);
    }

    public void updateRequestIDs(short[] sArray, boolean bl) {
        if (sArray != null) {
            this.RequestIDs = new short[sArray.length];
            System.arraycopy((Object)sArray, 0, (Object)this.RequestIDs, 0, sArray.length);
        } else {
            this.RequestIDs = null;
        }
        this.RequestIDs_valid = bl;
        List list = this.baseService.getNotifications(32);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updateRequestIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateReplyIDs(short[] sArray) {
        this.updateReplyIDs(sArray, true);
    }

    public void updateReplyIDs(short[] sArray, boolean bl) {
        if (sArray != null) {
            this.ReplyIDs = new short[sArray.length];
            System.arraycopy((Object)sArray, 0, (Object)this.ReplyIDs, 0, sArray.length);
        } else {
            this.ReplyIDs = null;
        }
        this.ReplyIDs_valid = bl;
        List list = this.baseService.getNotifications(31);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateSourceList(MediaSourceSlot[] mediaSourceSlotArray) {
        this.updateSourceList(mediaSourceSlotArray, true);
    }

    public void updateSourceList(MediaSourceSlot[] mediaSourceSlotArray, boolean bl) {
        if (mediaSourceSlotArray != null) {
            this.SourceList = new MediaSourceSlot[mediaSourceSlotArray.length];
            for (int i2 = 0; i2 < mediaSourceSlotArray.length; ++i2) {
                this.SourceList[i2] = ASIHMISyncMediaAbstractBaseService.copyMediaSourceSlot(mediaSourceSlotArray[i2]);
            }
        } else {
            this.SourceList = null;
        }
        this.SourceList_valid = bl;
        List list = this.baseService.getNotifications(30);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updateSourceList(mediaSourceSlotArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateActiveSlotState(MediaActiveSourceState mediaActiveSourceState) {
        this.updateActiveSlotState(mediaActiveSourceState, true);
    }

    public void updateActiveSlotState(MediaActiveSourceState mediaActiveSourceState, boolean bl) {
        this.ActiveSlotState = ASIHMISyncMediaAbstractBaseService.copyMediaActiveSourceState(mediaActiveSourceState);
        this.ActiveSlotState_valid = bl;
        List list = this.baseService.getNotifications(22);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updateActiveSlotState(mediaActiveSourceState, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updatePlaybackState(int n) {
        this.updatePlaybackState(n, true);
    }

    public void updatePlaybackState(int n, boolean bl) {
        this.PlaybackState = n;
        this.PlaybackState_valid = bl;
        List list = this.baseService.getNotifications(27);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updatePlaybackState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateListState(MediaPlaylistState mediaPlaylistState) {
        this.updateListState(mediaPlaylistState, true);
    }

    public void updateListState(MediaPlaylistState mediaPlaylistState, boolean bl) {
        this.ListState = ASIHMISyncMediaAbstractBaseService.copyMediaPlaylistState(mediaPlaylistState);
        this.ListState_valid = bl;
        List list = this.baseService.getNotifications(23);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updateListState(mediaPlaylistState, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updatePlayerCapabilities(int n) {
        this.updatePlayerCapabilities(n, true);
    }

    public void updatePlayerCapabilities(int n, boolean bl) {
        this.PlayerCapabilities = n;
        this.PlayerCapabilities_valid = bl;
        List list = this.baseService.getNotifications(38);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updatePlayerCapabilities(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateMix(boolean bl) {
        this.updateMix(bl, true);
    }

    public void updateMix(boolean bl, boolean bl2) {
        this.Mix = bl;
        this.Mix_valid = bl2;
        List list = this.baseService.getNotifications(24);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updateMix(bl, bl2);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateRepeatTitle(boolean bl) {
        this.updateRepeatTitle(bl, true);
    }

    public void updateRepeatTitle(boolean bl, boolean bl2) {
        this.RepeatTitle = bl;
        this.RepeatTitle_valid = bl2;
        List list = this.baseService.getNotifications(29);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updateRepeatTitle(bl, bl2);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateRepeatState(int n) {
        this.updateRepeatState(n, true);
    }

    public void updateRepeatState(int n, boolean bl) {
        this.RepeatState = n;
        this.RepeatState_valid = bl;
        List list = this.baseService.getNotifications(41);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updateRepeatState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateShuffleState(int n) {
        this.updateShuffleState(n, true);
    }

    public void updateShuffleState(int n, boolean bl) {
        this.ShuffleState = n;
        this.ShuffleState_valid = bl;
        List list = this.baseService.getNotifications(42);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updateShuffleState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updatePlayingTrack(MediaEntry mediaEntry) {
        this.updatePlayingTrack(mediaEntry, true);
    }

    public void updatePlayingTrack(MediaEntry mediaEntry, boolean bl) {
        this.PlayingTrack = ASIHMISyncMediaAbstractBaseService.copyMediaEntry(mediaEntry);
        this.PlayingTrack_valid = bl;
        List list = this.baseService.getNotifications(28);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updatePlayingTrack(mediaEntry, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updatePlayPosition(MediaPlayTime mediaPlayTime) {
        this.updatePlayPosition(mediaPlayTime, true);
    }

    public void updatePlayPosition(MediaPlayTime mediaPlayTime, boolean bl) {
        this.PlayPosition = ASIHMISyncMediaAbstractBaseService.copyMediaPlayTime(mediaPlayTime);
        this.PlayPosition_valid = bl;
        List list = this.baseService.getNotifications(25);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updatePlayPosition(mediaPlayTime, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updatePlaybackFolder(MediaEntry[] mediaEntryArray) {
        this.updatePlaybackFolder(mediaEntryArray, true);
    }

    public void updatePlaybackFolder(MediaEntry[] mediaEntryArray, boolean bl) {
        if (mediaEntryArray != null) {
            this.PlaybackFolder = new MediaEntry[mediaEntryArray.length];
            for (int i2 = 0; i2 < mediaEntryArray.length; ++i2) {
                this.PlaybackFolder[i2] = ASIHMISyncMediaAbstractBaseService.copyMediaEntry(mediaEntryArray[i2]);
            }
        } else {
            this.PlaybackFolder = null;
        }
        this.PlaybackFolder_valid = bl;
        List list = this.baseService.getNotifications(26);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updatePlaybackFolder(mediaEntryArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updatePlaybackPossible(int n) {
        this.updatePlaybackPossible(n, true);
    }

    public void updatePlaybackPossible(int n, boolean bl) {
        this.PlaybackPossible = n;
        this.PlaybackPossible_valid = bl;
        List list = this.baseService.getNotifications(37);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = (ASIHMISyncMediaReply)iterator.next();
            try {
                aSIHMISyncMediaReply.updatePlaybackPossible(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }
}

