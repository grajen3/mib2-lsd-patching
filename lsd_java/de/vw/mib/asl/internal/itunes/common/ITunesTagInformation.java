/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.itunes.common;

import de.vw.mib.asl.framework.api.persistence.Persistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.media.TagInformation;

public class ITunesTagInformation
extends TagInformation
implements Persistable {
    private String ambiguousIdentifier;

    public ITunesTagInformation(TagInformation tagInformation) {
        super(tagInformation.ambiguousTag, tagInformation.buttonPressed, tagInformation.title, tagInformation.artist, tagInformation.songID, tagInformation.stationFrequency, tagInformation.stationCallLetters, tagInformation.stationURL, tagInformation.timeStamp, tagInformation.affiliateID, tagInformation.album, tagInformation.iTunesFrontID, tagInformation.podcastFeedURL, tagInformation.genre, tagInformation.unknownData, tagInformation.programNumber);
    }

    public ITunesTagInformation(PersistenceInputStream persistenceInputStream) {
        this.fromStream(persistenceInputStream);
    }

    @Override
    public void fromStream(PersistenceInputStream persistenceInputStream) {
        this.ambiguousTag = persistenceInputStream.readBoolean();
        this.buttonPressed = persistenceInputStream.readBoolean();
        this.title = persistenceInputStream.readString();
        this.artist = persistenceInputStream.readString();
        this.songID = persistenceInputStream.readString();
        this.stationFrequency = persistenceInputStream.readString();
        this.stationCallLetters = persistenceInputStream.readString();
        this.stationURL = persistenceInputStream.readString();
        long l = persistenceInputStream.readLong();
        this.timeStamp = l <= 0L ? null : new DateTime(l);
        this.affiliateID = persistenceInputStream.readString();
        this.album = persistenceInputStream.readString();
        this.iTunesFrontID = persistenceInputStream.readInt();
        this.podcastFeedURL = persistenceInputStream.readInt();
        this.genre = persistenceInputStream.readString();
        this.unknownData = persistenceInputStream.readString();
        this.programNumber = persistenceInputStream.readInt();
        this.ambiguousIdentifier = persistenceInputStream.readString();
    }

    @Override
    public void toStream(PersistenceOutputStream persistenceOutputStream) {
        persistenceOutputStream.writeBoolean(this.ambiguousTag);
        persistenceOutputStream.writeBoolean(this.buttonPressed);
        persistenceOutputStream.writeString(this.title);
        persistenceOutputStream.writeString(this.artist);
        persistenceOutputStream.writeString(this.songID);
        persistenceOutputStream.writeString(this.stationFrequency);
        persistenceOutputStream.writeString(this.stationCallLetters);
        persistenceOutputStream.writeString(this.stationURL);
        if (null != this.timeStamp) {
            persistenceOutputStream.writeLong(this.timeStamp.getTime());
        } else {
            persistenceOutputStream.writeLong(0L);
        }
        persistenceOutputStream.writeString(this.affiliateID);
        persistenceOutputStream.writeString(this.album);
        persistenceOutputStream.writeInt(this.iTunesFrontID);
        persistenceOutputStream.writeInt(this.podcastFeedURL);
        persistenceOutputStream.writeString(this.genre);
        persistenceOutputStream.writeString(this.unknownData);
        persistenceOutputStream.writeInt(this.programNumber);
        persistenceOutputStream.writeString(this.ambiguousIdentifier);
    }

    @Override
    public void clear() {
        this.ambiguousTag = false;
        this.buttonPressed = false;
        this.title = "";
        this.artist = "";
        this.songID = "";
        this.stationFrequency = "";
        this.stationCallLetters = "";
        this.stationURL = "";
        this.timeStamp = null;
        this.affiliateID = "";
        this.album = "";
        this.iTunesFrontID = 0;
        this.podcastFeedURL = 0;
        this.genre = "";
        this.unknownData = "";
        this.programNumber = 0;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + (this.ambiguousTag ? 1231 : 1237);
        n2 = 31 * n2 + (this.buttonPressed ? 1231 : 1237);
        n2 = 31 * n2 + (this.title == null ? 0 : this.title.hashCode());
        n2 = 31 * n2 + (this.artist == null ? 0 : this.artist.hashCode());
        n2 = 31 * n2 + (this.songID == null ? 0 : this.songID.hashCode());
        n2 = 31 * n2 + (this.stationFrequency == null ? 0 : this.stationFrequency.hashCode());
        n2 = 31 * n2 + (this.stationCallLetters == null ? 0 : this.stationCallLetters.hashCode());
        n2 = 31 * n2 + (this.stationURL == null ? 0 : this.stationURL.hashCode());
        n2 = 31 * n2 + (this.timeStamp == null ? 0 : this.timeStamp.hashCode());
        n2 = 31 * n2 + (this.affiliateID == null ? 0 : this.affiliateID.hashCode());
        n2 = 31 * n2 + (this.album == null ? 0 : this.album.hashCode());
        n2 = 31 * n2 + this.iTunesFrontID;
        n2 = 31 * n2 + this.podcastFeedURL;
        n2 = 31 * n2 + (this.genre == null ? 0 : this.genre.hashCode());
        n2 = 31 * n2 + (this.unknownData == null ? 0 : this.unknownData.hashCode());
        n2 = 31 * n2 + this.programNumber;
        n2 = 31 * n2 + (this.ambiguousIdentifier == null ? 0 : this.ambiguousIdentifier.hashCode());
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        ITunesTagInformation iTunesTagInformation = (ITunesTagInformation)object;
        if (this.ambiguousTag != iTunesTagInformation.ambiguousTag) {
            return false;
        }
        if (this.buttonPressed != iTunesTagInformation.buttonPressed) {
            return false;
        }
        if (this.title == null ? iTunesTagInformation.title != null : !this.title.equals(iTunesTagInformation.title)) {
            return false;
        }
        if (this.artist == null ? iTunesTagInformation.artist != null : !this.artist.equals(iTunesTagInformation.artist)) {
            return false;
        }
        if (this.songID == null ? iTunesTagInformation.songID != null : !this.songID.equals(iTunesTagInformation.songID)) {
            return false;
        }
        if (this.stationFrequency == null ? iTunesTagInformation.stationFrequency != null : !this.stationFrequency.equals(iTunesTagInformation.stationFrequency)) {
            return false;
        }
        if (this.stationCallLetters == null ? iTunesTagInformation.stationCallLetters != null : !this.stationCallLetters.equals(iTunesTagInformation.stationCallLetters)) {
            return false;
        }
        if (this.stationURL == null ? iTunesTagInformation.stationURL != null : !this.stationURL.equals(iTunesTagInformation.stationURL)) {
            return false;
        }
        if (null != this.timeStamp && null != iTunesTagInformation.timeStamp && this.timeStamp.getTime() != iTunesTagInformation.timeStamp.getTime()) {
            return false;
        }
        if (this.affiliateID == null ? iTunesTagInformation.affiliateID != null : !this.affiliateID.equals(iTunesTagInformation.affiliateID)) {
            return false;
        }
        if (this.album == null ? iTunesTagInformation.album != null : !this.album.equals(iTunesTagInformation.album)) {
            return false;
        }
        if (this.iTunesFrontID != iTunesTagInformation.iTunesFrontID) {
            return false;
        }
        if (this.podcastFeedURL != iTunesTagInformation.podcastFeedURL) {
            return false;
        }
        if (this.genre == null ? iTunesTagInformation.genre != null : !this.genre.equals(iTunesTagInformation.genre)) {
            return false;
        }
        if (this.unknownData == null ? iTunesTagInformation.unknownData != null : !this.unknownData.equals(iTunesTagInformation.unknownData)) {
            return false;
        }
        return this.programNumber == iTunesTagInformation.programNumber;
    }

    public boolean isDuplicate(Object object) {
        if (object == null) {
            return false;
        }
        ITunesTagInformation iTunesTagInformation = (ITunesTagInformation)object;
        if (this.title == null ? iTunesTagInformation.title != null && !iTunesTagInformation.title.equals("") : !this.title.equals(iTunesTagInformation.title)) {
            return false;
        }
        if (this.artist == null ? iTunesTagInformation.artist != null && !iTunesTagInformation.artist.equals("") : !this.artist.equals(iTunesTagInformation.artist)) {
            return false;
        }
        if (this.songID == null ? iTunesTagInformation.songID != null && !iTunesTagInformation.songID.equals("") : !this.songID.equals(iTunesTagInformation.songID)) {
            return false;
        }
        if (this.album == null ? iTunesTagInformation.album != null && !iTunesTagInformation.album.equals("") : !this.album.equals(iTunesTagInformation.album)) {
            return false;
        }
        if (this.stationURL == null ? iTunesTagInformation.stationURL != null && !iTunesTagInformation.stationURL.equals("") : !this.stationURL.equals(iTunesTagInformation.stationURL)) {
            return false;
        }
        if (this.programNumber == 0) {
            return true;
        }
        if (this.stationFrequency == null ? iTunesTagInformation.stationFrequency != null && !iTunesTagInformation.stationFrequency.equals("") : !this.stationFrequency.equals(iTunesTagInformation.stationFrequency)) {
            return false;
        }
        if (this.affiliateID == null ? iTunesTagInformation.affiliateID != null && !iTunesTagInformation.affiliateID.equals("") : !this.affiliateID.equals(iTunesTagInformation.affiliateID)) {
            return false;
        }
        return this.programNumber == iTunesTagInformation.programNumber;
    }

    public boolean isValid() {
        if (this.title == null || this.title.equals("")) {
            return false;
        }
        return this.artist != null && !this.artist.equals("");
    }

    public String generateUniqueTagID() {
        String string = null;
        if (this.stationFrequency != null && !this.stationFrequency.trim().equals("")) {
            string = this.stationFrequency.trim().concat(Integer.toString(this.programNumber));
        }
        return string;
    }

    public String getAmbiguousIdentifier() {
        return this.ambiguousIdentifier;
    }

    public void setAmbiguousIdentifier(String string) {
        this.ambiguousIdentifier = string;
    }

    public String generateAmbiguousIdentifier() {
        this.ambiguousIdentifier = this.stationFrequency.concat(Integer.toString(this.programNumber)).concat(this.title).concat(this.artist);
        return this.ambiguousIdentifier;
    }
}

