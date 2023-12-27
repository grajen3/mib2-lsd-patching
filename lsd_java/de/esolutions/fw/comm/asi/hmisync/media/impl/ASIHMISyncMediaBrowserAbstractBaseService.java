/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaBrowserReply;
import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaBrowserS;
import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaI18NString;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserAbstractBaseService$AttributesBitMapProvider;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncMediaBrowserAbstractBaseService
implements ASIHMISyncMediaBrowserS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.media.ASIHMISyncMediaBrowser");
    private static final int attributesCount;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private short[] RequestIDs;
    private boolean RequestIDs_valid = false;
    private short[] ReplyIDs;
    private boolean ReplyIDs_valid = false;
    private MediaSourceSlot ActiveSlot;
    private boolean ActiveSlot_valid = false;
    private int BrowseMode;
    private boolean BrowseMode_valid = false;
    private boolean DatabaseMode;
    private boolean DatabaseMode_valid = false;
    private boolean RawMode;
    private boolean RawMode_valid = false;
    private MediaEntry[] BrowseFolder;
    private boolean BrowseFolder_valid = false;
    private int ListSize;
    private boolean ListSize_valid = false;
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
        mediaSourceSlot2.name = ASIHMISyncMediaBrowserAbstractBaseService.copyString(mediaSourceSlot.name);
        return mediaSourceSlot2;
    }

    public static MediaEntry copyMediaEntry(MediaEntry mediaEntry) {
        if (mediaEntry == null) {
            return null;
        }
        MediaEntry mediaEntry2 = new MediaEntry();
        mediaEntry2.id = mediaEntry.id;
        mediaEntry2.type = mediaEntry.type;
        mediaEntry2.title = ASIHMISyncMediaBrowserAbstractBaseService.copyMediaI18NString(mediaEntry.title);
        mediaEntry2.artist = ASIHMISyncMediaBrowserAbstractBaseService.copyMediaI18NString(mediaEntry.artist);
        mediaEntry2.artistID = mediaEntry.artistID;
        mediaEntry2.album = ASIHMISyncMediaBrowserAbstractBaseService.copyMediaI18NString(mediaEntry.album);
        mediaEntry2.albumID = mediaEntry.albumID;
        mediaEntry2.genreID = mediaEntry.genreID;
        mediaEntry2.coverUrl = ASIHMISyncMediaBrowserAbstractBaseService.copyString(mediaEntry.coverUrl);
        return mediaEntry2;
    }

    public static MediaI18NString copyMediaI18NString(MediaI18NString mediaI18NString) {
        if (mediaI18NString == null) {
            return null;
        }
        MediaI18NString mediaI18NString2 = new MediaI18NString();
        mediaI18NString2.i18nKey = mediaI18NString.i18nKey;
        mediaI18NString2.name = ASIHMISyncMediaBrowserAbstractBaseService.copyString(mediaI18NString.name);
        return mediaI18NString2;
    }

    public ASIHMISyncMediaBrowserAbstractBaseService() {
        ASIHMISyncMediaBrowserAbstractBaseService$AttributesBitMapProvider aSIHMISyncMediaBrowserAbstractBaseService$AttributesBitMapProvider = new ASIHMISyncMediaBrowserAbstractBaseService$AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncMediaBrowser", aSIHMISyncMediaBrowserAbstractBaseService$AttributesBitMapProvider);
    }

    @Override
    public synchronized void setNotification(long l, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncMediaBrowserReply);
        this.sendAttributeUpdate(l, aSIHMISyncMediaBrowserReply);
    }

    @Override
    public synchronized void setNotification(ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        this.baseService.setNotification(aSIHMISyncMediaBrowserReply);
        this.sendAttributeUpdate(aSIHMISyncMediaBrowserReply);
    }

    @Override
    public synchronized void setNotification(long[] lArray, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncMediaBrowserReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncMediaBrowserReply);
    }

    @Override
    public synchronized void clearNotification(long l, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncMediaBrowserReply);
    }

    @Override
    public synchronized void clearNotification(ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        this.baseService.clearNotification(aSIHMISyncMediaBrowserReply);
    }

    @Override
    public synchronized void clearNotification(long[] lArray, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncMediaBrowserReply);
    }

    private void sendAttributeUpdate(ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        try {
            aSIHMISyncMediaBrowserReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncMediaBrowserReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncMediaBrowserReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            aSIHMISyncMediaBrowserReply.updateActiveSlot(this.ActiveSlot, this.ActiveSlot_valid);
            aSIHMISyncMediaBrowserReply.updateBrowseMode(this.BrowseMode, this.BrowseMode_valid);
            aSIHMISyncMediaBrowserReply.updateDatabaseMode(this.DatabaseMode, this.DatabaseMode_valid);
            aSIHMISyncMediaBrowserReply.updateRawMode(this.RawMode, this.RawMode_valid);
            aSIHMISyncMediaBrowserReply.updateBrowseFolder(this.BrowseFolder, this.BrowseFolder_valid);
            aSIHMISyncMediaBrowserReply.updateListSize(this.ListSize, this.ListSize_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncMediaBrowserReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        try {
            if (l == 0) {
                aSIHMISyncMediaBrowserReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 0) {
                aSIHMISyncMediaBrowserReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 0) {
                aSIHMISyncMediaBrowserReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            } else if (l == 0) {
                aSIHMISyncMediaBrowserReply.updateActiveSlot(this.ActiveSlot, this.ActiveSlot_valid);
            } else if (l == 0) {
                aSIHMISyncMediaBrowserReply.updateBrowseMode(this.BrowseMode, this.BrowseMode_valid);
            } else if (l == 0) {
                aSIHMISyncMediaBrowserReply.updateDatabaseMode(this.DatabaseMode, this.DatabaseMode_valid);
            } else if (l == 0) {
                aSIHMISyncMediaBrowserReply.updateRawMode(this.RawMode, this.RawMode_valid);
            } else if (l == 0) {
                aSIHMISyncMediaBrowserReply.updateBrowseFolder(this.BrowseFolder, this.BrowseFolder_valid);
            } else if (l == 0) {
                aSIHMISyncMediaBrowserReply.updateListSize(this.ListSize, this.ListSize_valid);
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
        this.ASIVersion = ASIHMISyncMediaBrowserAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(15);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply = (ASIHMISyncMediaBrowserReply)iterator.next();
            try {
                aSIHMISyncMediaBrowserReply.updateASIVersion(string, bl);
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
        List list = this.baseService.getNotifications(23);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply = (ASIHMISyncMediaBrowserReply)iterator.next();
            try {
                aSIHMISyncMediaBrowserReply.updateRequestIDs(sArray, bl);
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
        List list = this.baseService.getNotifications(22);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply = (ASIHMISyncMediaBrowserReply)iterator.next();
            try {
                aSIHMISyncMediaBrowserReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateActiveSlot(MediaSourceSlot mediaSourceSlot) {
        this.updateActiveSlot(mediaSourceSlot, true);
    }

    public void updateActiveSlot(MediaSourceSlot mediaSourceSlot, boolean bl) {
        this.ActiveSlot = ASIHMISyncMediaBrowserAbstractBaseService.copyMediaSourceSlot(mediaSourceSlot);
        this.ActiveSlot_valid = bl;
        List list = this.baseService.getNotifications(16);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply = (ASIHMISyncMediaBrowserReply)iterator.next();
            try {
                aSIHMISyncMediaBrowserReply.updateActiveSlot(mediaSourceSlot, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBrowseMode(int n) {
        this.updateBrowseMode(n, true);
    }

    public void updateBrowseMode(int n, boolean bl) {
        this.BrowseMode = n;
        this.BrowseMode_valid = bl;
        List list = this.baseService.getNotifications(18);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply = (ASIHMISyncMediaBrowserReply)iterator.next();
            try {
                aSIHMISyncMediaBrowserReply.updateBrowseMode(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateDatabaseMode(boolean bl) {
        this.updateDatabaseMode(bl, true);
    }

    public void updateDatabaseMode(boolean bl, boolean bl2) {
        this.DatabaseMode = bl;
        this.DatabaseMode_valid = bl2;
        List list = this.baseService.getNotifications(19);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply = (ASIHMISyncMediaBrowserReply)iterator.next();
            try {
                aSIHMISyncMediaBrowserReply.updateDatabaseMode(bl, bl2);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateRawMode(boolean bl) {
        this.updateRawMode(bl, true);
    }

    public void updateRawMode(boolean bl, boolean bl2) {
        this.RawMode = bl;
        this.RawMode_valid = bl2;
        List list = this.baseService.getNotifications(21);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply = (ASIHMISyncMediaBrowserReply)iterator.next();
            try {
                aSIHMISyncMediaBrowserReply.updateRawMode(bl, bl2);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBrowseFolder(MediaEntry[] mediaEntryArray) {
        this.updateBrowseFolder(mediaEntryArray, true);
    }

    public void updateBrowseFolder(MediaEntry[] mediaEntryArray, boolean bl) {
        if (mediaEntryArray != null) {
            this.BrowseFolder = new MediaEntry[mediaEntryArray.length];
            for (int i2 = 0; i2 < mediaEntryArray.length; ++i2) {
                this.BrowseFolder[i2] = ASIHMISyncMediaBrowserAbstractBaseService.copyMediaEntry(mediaEntryArray[i2]);
            }
        } else {
            this.BrowseFolder = null;
        }
        this.BrowseFolder_valid = bl;
        List list = this.baseService.getNotifications(17);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply = (ASIHMISyncMediaBrowserReply)iterator.next();
            try {
                aSIHMISyncMediaBrowserReply.updateBrowseFolder(mediaEntryArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateListSize(int n) {
        this.updateListSize(n, true);
    }

    public void updateListSize(int n, boolean bl) {
        this.ListSize = n;
        this.ListSize_valid = bl;
        List list = this.baseService.getNotifications(20);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply = (ASIHMISyncMediaBrowserReply)iterator.next();
            try {
                aSIHMISyncMediaBrowserReply.updateListSize(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }
}

