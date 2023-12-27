/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.itunes.database;

import de.vw.mib.asl.framework.api.persistence.AbstractVersionedPersistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.itunes.common.ITunesTagInformation;
import de.vw.mib.asl.internal.itunes.database.ITunesSongSortingComparator;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.media.TagInformation;

public class ITunesDatabase
extends AbstractVersionedPersistable {
    private static final short VERSION;
    private final ObjectObjectOptHashMap mRecords = new ObjectObjectOptHashMap();
    private ITunesSongSortingComparator mComparator;
    private boolean maxTagPlusOne = false;

    public ITunesDatabase() {
    }

    public ITunesDatabase(PersistenceInputStream persistenceInputStream) {
        this.fromStream(persistenceInputStream);
    }

    public int canAdd(ITunesTagInformation iTunesTagInformation, boolean bl) {
        if (iTunesTagInformation == null || this.isInvalidTag(iTunesTagInformation)) {
            return 13;
        }
        String string = null;
        if (iTunesTagInformation.getStationFrequency() != null && !iTunesTagInformation.getStationFrequency().equals("") && Integer.parseInt(iTunesTagInformation.getStationFrequency()) > 999) {
            string = iTunesTagInformation.generateUniqueTagID();
            if (ServiceManager.logger2.isTraceEnabled(8192)) {
                ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" stored key ").append(string).log();
            }
        }
        if (string != null && (this.mRecords.containsKey(string) || this.mRecords.containsKey(string.concat(iTunesTagInformation.title))) || this.mRecords.containsKey(iTunesTagInformation.songID) || this.mRecords.containsKey(iTunesTagInformation.title) || this.mRecords.containsKey(iTunesTagInformation.artist)) {
            if (ServiceManager.logger2.isTraceEnabled(8192)) {
                ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" Key matches").log();
            }
            if (this.checkForDuplication(iTunesTagInformation, bl)) {
                if (ServiceManager.logger2.isTraceEnabled(8192)) {
                    ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" Tag already registered").log();
                }
                return 17;
            }
        }
        if (bl && this.mRecords.size() == 50) {
            if (iTunesTagInformation.buttonPressed) {
                this.maxTagPlusOne = true;
            } else if (!this.maxTagPlusOne) {
                return 0;
            }
        }
        if (bl && this.mRecords.size() >= 50) {
            return 24;
        }
        return 0;
    }

    private boolean isInvalidTag(ITunesTagInformation iTunesTagInformation) {
        return iTunesTagInformation.stationFrequency != null && Integer.parseInt(iTunesTagInformation.stationFrequency) > 999 ? null == iTunesTagInformation.title || iTunesTagInformation.title.equals("") || null == iTunesTagInformation.artist || iTunesTagInformation.artist.equals("") : null == iTunesTagInformation.songID || iTunesTagInformation.songID.equals("") || null == iTunesTagInformation.title || iTunesTagInformation.title.equals("") || null == iTunesTagInformation.artist || iTunesTagInformation.artist.equals("");
    }

    public boolean contains(String string) {
        return this.mRecords.containsKey(string);
    }

    public int add(ITunesTagInformation iTunesTagInformation) {
        int n = this.canAdd(iTunesTagInformation, true);
        if (n == 0) {
            String string = this.generateKeyWithTagInfo(iTunesTagInformation);
            if (string != null) {
                this.mRecords.put(string, iTunesTagInformation);
                if (ServiceManager.logger2.isTraceEnabled(8192)) {
                    ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" Added the tag to database").append(" KEY : ").append(string).append(" Value : ").append(iTunesTagInformation.toString()).log();
                }
            } else {
                n = 13;
                ServiceManager.logger2.error(8192).append("ITUNES : ").append(" Cannot add tag to database because generated key is NULL").log();
            }
        }
        return n;
    }

    public void readFromPersistence(ITunesTagInformation iTunesTagInformation) {
        if (iTunesTagInformation != null) {
            if (iTunesTagInformation.isValid()) {
                String string = this.generateKeyWithTagInfo(iTunesTagInformation);
                if (string != null) {
                    this.mRecords.put(string, iTunesTagInformation);
                    if (ServiceManager.logger2.isTraceEnabled(8192)) {
                        ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" Added the tag to database from persistence").append(" KEY : ").append(string).append(" Value : ").append(iTunesTagInformation.toString()).append(" Ambiguous Identifier : ").append(iTunesTagInformation.getAmbiguousIdentifier() == null ? "NULL" : iTunesTagInformation.getAmbiguousIdentifier()).log();
                    }
                } else {
                    ServiceManager.logger2.error(8192).append("ITUNES : ").append(" Cannot add tag to database because generated key is NULL").log();
                }
            } else {
                ServiceManager.logger2.error(8192).append("ITUNES : ").append(" Tag read from persistence is not a valid tag").log();
            }
        }
    }

    private String generateKeyWithTagInfo(ITunesTagInformation iTunesTagInformation) {
        String string = null;
        String string2 = null;
        if (iTunesTagInformation.getStationFrequency() != null && !iTunesTagInformation.getStationFrequency().equals("") && Integer.parseInt(iTunesTagInformation.getStationFrequency()) > 999) {
            string = string2 = iTunesTagInformation.generateUniqueTagID();
        }
        if (string == null || this.mRecords.containsKey(string)) {
            string = iTunesTagInformation.songID;
            if (string == null || string.equals("") || this.mRecords.containsKey(string)) {
                string = iTunesTagInformation.title;
            }
            if (this.mRecords.containsKey(string)) {
                string = iTunesTagInformation.artist;
            }
            if (this.mRecords.containsKey(string) && string2 != null) {
                string = string2.concat(iTunesTagInformation.title);
            }
        }
        return string;
    }

    public int size() {
        return this.mRecords.size();
    }

    public int getFreeSpace() {
        return 50 - this.mRecords.size();
    }

    public Iterator iterator() {
        return this.mRecords.values().iterator();
    }

    public boolean checkForAmbiguousTag(ITunesTagInformation iTunesTagInformation) {
        if (iTunesTagInformation != null) {
            return iTunesTagInformation.ambiguousTag;
        }
        return false;
    }

    public ITunesTagInformation getAmbiguousTag(ITunesTagInformation iTunesTagInformation) {
        if (ServiceManager.logger2.isTraceEnabled(8192)) {
            ServiceManager.logger2.trace(8192).append("ITUNES : getAmbiguousTag()->").append(iTunesTagInformation.getAmbiguousIdentifier()).log();
        }
        if (iTunesTagInformation != null) {
            Iterator iterator = this.mRecords.values().iterator();
            while (iterator.hasNext()) {
                ITunesTagInformation iTunesTagInformation2 = (ITunesTagInformation)iterator.next();
                if (!iTunesTagInformation2.ambiguousTag || (!iTunesTagInformation.buttonPressed || iTunesTagInformation2.buttonPressed) && (iTunesTagInformation.buttonPressed || !iTunesTagInformation2.buttonPressed) || iTunesTagInformation.getAmbiguousIdentifier() == null || iTunesTagInformation2.getAmbiguousIdentifier() == null || !iTunesTagInformation.getAmbiguousIdentifier().equals(iTunesTagInformation2.getAmbiguousIdentifier())) continue;
                if (ServiceManager.logger2.isTraceEnabled(8192)) {
                    ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" Ambiguous identifier ").append(iTunesTagInformation2.getAmbiguousIdentifier()).log();
                }
                return iTunesTagInformation2;
            }
        }
        return null;
    }

    public TagInformation[] getAllTags() {
        if (this.mComparator == null) {
            this.mComparator = ITunesSongSortingComparator.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.mRecords.values().iterator();
        while (iterator.hasNext()) {
            arrayList.add(iterator.next());
        }
        Object[] objectArray = (TagInformation[])arrayList.toArray(new TagInformation[arrayList.size()]);
        Arrays.sort(objectArray, this.mComparator);
        return objectArray;
    }

    public void remove(ITunesTagInformation iTunesTagInformation) {
        Iterator iterator = this.mRecords.values().iterator();
        while (iterator.hasNext()) {
            ITunesTagInformation iTunesTagInformation2 = (ITunesTagInformation)iterator.next();
            if (!iTunesTagInformation2.isDuplicate(iTunesTagInformation)) continue;
            if (ServiceManager.logger2.isTraceEnabled(8192)) {
                ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" Removed the tag").append(iTunesTagInformation2.toString()).log();
            }
            iterator.remove();
        }
        this.maxTagPlusOne = false;
    }

    public void removeAll() {
        this.clear();
        this.maxTagPlusOne = false;
    }

    public boolean checkForDuplication(ITunesTagInformation iTunesTagInformation, boolean bl) {
        Iterator iterator = this.mRecords.values().iterator();
        if (ServiceManager.logger2.isTraceEnabled(8192)) {
            ServiceManager.logger2.trace(8192).append("ITUNES : ").append("checkForDuplication - pTag = ").append(iTunesTagInformation.toString()).append(" addTag = ").append(bl).log();
        }
        while (iterator.hasNext()) {
            ITunesTagInformation iTunesTagInformation2 = (ITunesTagInformation)iterator.next();
            if (ServiceManager.logger2.isTraceEnabled(8192)) {
                ServiceManager.logger2.trace(8192).append("ITUNES : ").append("checkForDuplication - listElem = ").append(iTunesTagInformation2.toString()).log();
            }
            if (!iTunesTagInformation.isDuplicate(iTunesTagInformation2) && !this.isRadioTagDuplicate(iTunesTagInformation, iTunesTagInformation2)) continue;
            if (bl) {
                if (iTunesTagInformation.buttonPressed != iTunesTagInformation2.buttonPressed && (iTunesTagInformation.buttonPressed || !iTunesTagInformation2.buttonPressed)) continue;
                if (ServiceManager.logger2.isTraceEnabled(8192)) {
                    ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" ADDING TAG IS DUPLICATE ").log();
                }
                return true;
            }
            if (!iTunesTagInformation2.buttonPressed) continue;
            if (ServiceManager.logger2.isTraceEnabled(8192)) {
                ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" ACTIVATION TAG IS DUPLICATE ").log();
            }
            return true;
        }
        return false;
    }

    private boolean isRadioTagDuplicate(ITunesTagInformation iTunesTagInformation, ITunesTagInformation iTunesTagInformation2) {
        try {
            if (iTunesTagInformation != null && iTunesTagInformation2 != null && iTunesTagInformation.getStationFrequency() != null && !iTunesTagInformation.getStationFrequency().equals("") && null != iTunesTagInformation.songID && iTunesTagInformation.songID.equals(iTunesTagInformation2.getSongID())) {
                if (Integer.parseInt(iTunesTagInformation.getStationFrequency()) > 999) {
                    if (null != iTunesTagInformation.artist && iTunesTagInformation.artist.equals(iTunesTagInformation2.artist) && null != iTunesTagInformation.title && iTunesTagInformation.title.equals(iTunesTagInformation2.title) && null != iTunesTagInformation.album && iTunesTagInformation.album.equals(iTunesTagInformation2.album) && null != iTunesTagInformation.stationFrequency && iTunesTagInformation.stationFrequency.equals(iTunesTagInformation2.stationFrequency) && iTunesTagInformation.programNumber == iTunesTagInformation2.programNumber && null != iTunesTagInformation.stationURL && iTunesTagInformation.stationURL.equals(iTunesTagInformation2.stationURL)) {
                        if (ServiceManager.logger2.isTraceEnabled(8192)) {
                            ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" HD RADIO TAG IS DUPLICATE ").append("Tag checked for :  ").append(iTunesTagInformation.songID).append(" Existing tag : ").log();
                        }
                        return true;
                    }
                } else {
                    if (ServiceManager.logger2.isTraceEnabled(8192)) {
                        ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" SDARS TAG IS DUPLICATE ").append("Tag checked for :  ").append(iTunesTagInformation.songID).append(" Existing tag : ").append(iTunesTagInformation2.songID).log();
                    }
                    return true;
                }
            }
            return false;
        }
        catch (Exception exception) {
            ServiceManager.logger2.error(8192, "Exception in isRadioTagDuplicate() : ", exception);
            return false;
        }
    }

    @Override
    public void clear() {
        this.mRecords.clear();
    }

    @Override
    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        this.clear();
        int n = persistenceInputStream.readByte();
        for (int i2 = 0; i2 < n; ++i2) {
            ITunesTagInformation iTunesTagInformation = new ITunesTagInformation(persistenceInputStream);
            this.readFromPersistence(iTunesTagInformation);
        }
        if (ServiceManager.logger2.isTraceEnabled(8192)) {
            ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" Tags read from persistence : ").append(n).log();
        }
    }

    @Override
    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        int n = this.size();
        persistenceOutputStream.writeByte(n);
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            ITunesTagInformation iTunesTagInformation = (ITunesTagInformation)iterator.next();
            if (iTunesTagInformation == null) continue;
            iTunesTagInformation.toStream(persistenceOutputStream);
            if (!ServiceManager.logger2.isTraceEnabled(8192)) continue;
            ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" Added the tag from database to persistence").append(" Value : ").append(iTunesTagInformation.toString()).append(" Ambiguous Identifier : ").append(iTunesTagInformation.getAmbiguousIdentifier() == null ? "NULL" : iTunesTagInformation.getAmbiguousIdentifier()).log();
        }
        if (ServiceManager.logger2.isTraceEnabled(8192)) {
            ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" Tags written to persistence : ").append(n).log();
        }
    }

    @Override
    public void clearUnknownValues(short s) {
    }

    @Override
    public short[] getSupportedVersions() {
        return NO_SUPPORTED_VERSION;
    }

    @Override
    public short getVersion() {
        return 2;
    }
}

