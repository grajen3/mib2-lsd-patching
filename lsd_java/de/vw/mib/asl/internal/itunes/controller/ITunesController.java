/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.itunes.controller;

import de.vw.mib.asl.api.itunes.model.CurrentSongTagCollector;
import de.vw.mib.asl.api.radio.ASLRadioFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.itunes.ITunesHandler;
import de.vw.mib.asl.internal.itunes.common.ITunesTagInformation;
import de.vw.mib.asl.internal.itunes.controller.ITunesManager;
import de.vw.mib.asl.internal.itunes.database.ITunesDatabase;
import de.vw.mib.asl.internal.itunes.database.ITunesDatabaseCollector;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.genericevents.EventGeneric;
import java.util.Iterator;
import org.dsi.ifc.media.TagInformation;

public class ITunesController
extends ITunesManager {
    private static int numInstances = 0;
    private ITunesTagInformation transferedTag = null;
    private ITunesTagInformation ambiguousTag = null;
    private ITunesDatabase currentInstance = null;
    private int currentInstanceNumber = 0;
    private boolean tagSentDirectly = false;
    private boolean firstTagAfterStartupOrAfterDeviceConnected = false;
    private boolean tagTransferToDeviceStarted = false;
    private int deviceConnectedStatus = 0;
    private int tagsCount = 0;

    public ITunesController() {
        ServiceManager.persistence.registerSharedPersistable(this.getInfoPersistence());
        ServiceManager.persistence.loadPersistable(5019, 0, this.getInfoPersistence());
        ServiceManager.persistence.registerSharedPersistable(this.getDatabaseCollector());
        ServiceManager.persistence.loadPersistable(5019, 0, this.getDatabaseCollector());
    }

    public void createInstanceWithID(String string) {
        this.getInfoPersistence().addInstance(numInstances, string);
        ++numInstances;
    }

    public int checkAndReturnInstance(String string) {
        if (string != null && !string.trim().equals("")) {
            if (this.getInfoPersistence().getInstanceContextMap().containsValue(string)) {
                IntIterator intIterator = this.getInfoPersistence().getInstanceContextMap().keySet().iterator();
                while (intIterator.hasNext()) {
                    int n = intIterator.next();
                    if (!string.equals(this.getInfoPersistence().getInstanceContextMap().get(n))) continue;
                    return n;
                }
            } else {
                this.createInstanceWithID(string);
                return numInstances - 1;
            }
        }
        return 13;
    }

    public int getNumInstances() {
        if (numInstances == 0) {
            numInstances = this.getInfoPersistence().getInstanceContextMap().size();
        }
        return numInstances;
    }

    public int getCurrentInstance() {
        return this.currentInstanceNumber;
    }

    public void loadItunesDatabase(int n) {
        ITunesDatabaseCollector iTunesDatabaseCollector = this.getDatabaseCollector();
        if (!iTunesDatabaseCollector.contains(n)) {
            if (ServiceManager.logger2.isTraceEnabled(8192)) {
                ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" Database does not have the following instance ").log();
            }
            this.createNewInstance(n);
        }
        int n2 = iTunesDatabaseCollector.get(n).size();
        int n3 = iTunesDatabaseCollector.get(n).getFreeSpace();
        this.getModelController().updateTaggingStatistics(n2, n3);
        this.getModelController().updateTaggingList(iTunesDatabaseCollector.get(n).getAllTags());
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-660733952);
        eventGeneric.setInt(0, n);
        ITunesHandler.getTarget().sendSafe(eventGeneric);
    }

    private void createNewInstance(int n) {
        this.getDatabaseCollector().add(n, new ITunesDatabase());
    }

    public boolean transferTag(TagInformation tagInformation) {
        if (ServiceManager.logger2.isTraceEnabled(8192)) {
            ServiceManager.logger2.trace(8192).append("ITUNES : ").append("transferTag : ").log();
        }
        if (ITunesHandler.getTarget().getDSIRadioTagging() != null) {
            ITunesHandler.getTarget().getDSIRadioTagging().tagSong(tagInformation);
            return true;
        }
        return false;
    }

    public boolean transferAmbigousTag(TagInformation tagInformation, TagInformation tagInformation2) {
        if (ServiceManager.logger2.isTraceEnabled(8192)) {
            ServiceManager.logger2.trace(8192).append("ITUNES : ").append("transferAmbigousTag : ").log();
        }
        if (ITunesHandler.getTarget().getDSIRadioTagging() != null) {
            ITunesHandler.getTarget().getDSIRadioTagging().tagAmbiguousSong(tagInformation, tagInformation2);
            return true;
        }
        return false;
    }

    public void transferedTagResult(int n) {
        int n2 = 0;
        if (n == 0) {
            if (this.isTagTransferToDeviceStarted()) {
                this.getModelController().updateTagCountTransferedSuccessfully(++this.tagsCount);
            }
            if (this.ambiguousTag != null) {
                if (ServiceManager.logger2.isTraceEnabled(8192)) {
                    ServiceManager.logger2.trace(8192).append("ITUNES :").append(" Transfered Ambiguous tag : ").append(this.ambiguousTag.toString()).log();
                }
                this.currentInstance.remove(this.ambiguousTag);
                this.ambiguousTag = null;
                this.getDatabaseCollector().markDirty(true);
                this.getModelController().updateTagCountTransferedSuccessfully(++this.tagsCount);
            }
            if (this.transferedTag != null) {
                if (ServiceManager.logger2.isTraceEnabled(8192)) {
                    ServiceManager.logger2.trace(8192).append("ITUNES :").append(" Transfered tag : ").append(this.transferedTag.toString()).log();
                }
                this.currentInstance.remove(this.transferedTag);
                this.transferedTag = null;
                this.getDatabaseCollector().markDirty(true);
                if (!this.sendExistingTagsToDevice() && this.checkForNextInstances()) {
                    this.sendExistingTagsToDevice();
                }
                this.getModelController().updateTaggingList(this.currentInstance.getAllTags());
            }
            if (this.tagSentDirectly) {
                n2 = 20;
                this.tagSentDirectly = false;
                if (!ASLRadioFactory.getRadioApi().isTaggedStationChanged()) {
                    if (ServiceManager.logger2.isTraceEnabled(8192)) {
                        ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" TransferedTagResult ").log();
                    }
                    this.getModelController().updateTaggingResult(0);
                } else if (ServiceManager.logger2.isTraceEnabled(8192)) {
                    ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" TransferedTagResult: but station changed").log();
                }
            }
        } else {
            if (ServiceManager.logger2.isTraceEnabled(8192)) {
                ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" Error condition while transfering tags : ").append(n).log();
            }
            if (!this.isTagTransferToDeviceStarted()) {
                int n3 = this.addTag(this.transferedTag, this.ambiguousTag, this.currentInstanceNumber);
                n2 = n3 != 0 || n3 != 18 ? 22 : 26;
                this.ambiguousTag = null;
                this.transferedTag = null;
            } else {
                this.getModelController().updateTagCountTransferedSuccessfully(this.tagsCount);
                n2 = n == 2 ? 22 : 23;
                this.setTagTransferToDeviceStarted(false);
            }
        }
        this.getModelController().updateResultToHMI(n2);
    }

    public boolean checkForTagsAvailability() {
        if (ServiceManager.logger2.isTraceEnabled(8192)) {
            ServiceManager.logger2.trace(8192).append("ITUNES :").append("Check for tags  Availability").log();
        }
        if (this.getDatabaseCollector().size() > 0) {
            IntIterator intIterator = this.getDatabaseCollector().keyIterator();
            while (intIterator.hasNext()) {
                int n = intIterator.next();
                this.currentInstance = this.getDatabaseCollector().get(n);
                if (ServiceManager.logger2.isTraceEnabled(8192)) {
                    ServiceManager.logger2.trace(8192).append("ITUNES :").append("current instance-> ").append(n).append(" TAGS = ").append(this.currentInstance.size()).log();
                }
                if (this.currentInstance.size() <= 0) continue;
                this.currentInstanceNumber = n;
                return true;
            }
        }
        return false;
    }

    public boolean checkForNextInstances() {
        int n = this.currentInstanceNumber;
        if (numInstances > 0 && ++n < numInstances) {
            this.currentInstance = this.getDatabaseCollector().get(n);
            this.currentInstanceNumber = n;
            return true;
        }
        return false;
    }

    public boolean sendExistingTagsToDevice() {
        Iterator iterator;
        if (ServiceManager.logger2.isTraceEnabled(8192)) {
            ServiceManager.logger2.trace(8192).append("ITUNES :").append("Send existing  tags to the device").log();
        }
        if ((iterator = this.currentInstance.iterator()).hasNext()) {
            ITunesTagInformation iTunesTagInformation;
            if (!this.isTagTransferToDeviceStarted()) {
                this.setTagTransferToDeviceStarted(true);
                this.getModelController().updateResultToHMI(21);
                this.getModelController().updateTaggingStatistics(this.currentInstance.size(), this.currentInstance.getFreeSpace());
                this.getModelController().updateTagCountTransferedSuccessfully(this.tagsCount);
            }
            if (this.currentInstance.checkForAmbiguousTag(iTunesTagInformation = (ITunesTagInformation)iterator.next())) {
                ITunesTagInformation iTunesTagInformation2 = this.currentInstance.getAmbiguousTag(iTunesTagInformation);
                if (iTunesTagInformation2 != null) {
                    if (iTunesTagInformation.ambiguousTag && iTunesTagInformation.buttonPressed) {
                        this.transferedTag = iTunesTagInformation;
                        this.ambiguousTag = iTunesTagInformation2;
                    } else {
                        this.transferedTag = iTunesTagInformation2;
                        this.ambiguousTag = iTunesTagInformation;
                    }
                    if (ServiceManager.logger2.isTraceEnabled(8192)) {
                        ServiceManager.logger2.trace(8192).append("ITUNES :").append("transfering ambiguous tags to the device-> Tag1 : ").append(this.transferedTag.toString()).append(" Tag2 : ").append(this.ambiguousTag.toString()).log();
                    }
                    this.transferAmbigousTag(this.transferedTag, this.ambiguousTag);
                    return true;
                }
                ServiceManager.logger2.error(8192).append("ITUNES :").append("Existing tag is ambiguous but second tag is not available").log();
                iTunesTagInformation.ambiguousTag = false;
            }
            this.transferedTag = iTunesTagInformation;
            this.transferTag(this.transferedTag);
            return true;
        }
        if (this.isTagTransferToDeviceStarted()) {
            this.getModelController().updateTagCountTransferedSuccessfully(this.tagsCount);
            this.getModelController().updateTaggingStatistics(this.currentInstance.size(), this.currentInstance.getFreeSpace());
            this.getModelController().updateResultToHMI(29);
            this.setTagTransferToDeviceStarted(false);
        }
        return false;
    }

    public boolean isTagTransferToDeviceStarted() {
        return this.tagTransferToDeviceStarted;
    }

    public void setTagTransferToDeviceStarted(boolean bl) {
        if (ServiceManager.logger2.isTraceEnabled(8192)) {
            ServiceManager.logger2.trace(8192).append("setTagTransferToDeviceStarted : ").append(bl).log();
        }
        this.tagTransferToDeviceStarted = bl;
        if (!this.tagTransferToDeviceStarted) {
            this.tagsCount = 0;
            if (ServiceManager.logger2.isTraceEnabled(8192)) {
                ServiceManager.logger2.trace(8192).append("tagsCount is to : ").append(this.tagsCount).log();
            }
        }
    }

    public void handleTags(TagInformation tagInformation, TagInformation tagInformation2, int n, boolean bl) {
        if (ServiceManager.logger2.isTraceEnabled(8192)) {
            ServiceManager.logger2.trace(8192).append("ITUNES :").append("handleTags").log();
        }
        boolean bl2 = false;
        boolean bl3 = false;
        if (bl) {
            if (tagInformation2 != null && !new ITunesTagInformation(tagInformation2).isValid()) {
                tagInformation2 = null;
                if (tagInformation.ambiguousTag) {
                    tagInformation.ambiguousTag = false;
                }
            }
            this.sendTagToDevice(tagInformation, tagInformation2);
        } else {
            if (tagInformation != null) {
                ITunesDatabase iTunesDatabase = this.getDatabaseCollector().get(n);
                bl2 = iTunesDatabase.checkForDuplication(new ITunesTagInformation(tagInformation), true);
                if (tagInformation2 != null) {
                    ITunesTagInformation iTunesTagInformation = new ITunesTagInformation(tagInformation2);
                    if (iTunesTagInformation.isValid()) {
                        bl3 = iTunesDatabase.checkForDuplication(iTunesTagInformation, true);
                    }
                    if (!bl2 && bl3) {
                        tagInformation.ambiguousTag = false;
                        tagInformation2 = null;
                    } else if (bl2 && (bl3 || !bl3)) {
                        tagInformation = null;
                        tagInformation2 = null;
                    }
                }
            }
            this.addTag(tagInformation, tagInformation2, n);
        }
    }

    private void sendTagToDevice(TagInformation tagInformation, TagInformation tagInformation2) {
        if (ServiceManager.logger2.isTraceEnabled(8192)) {
            ServiceManager.logger2.trace(8192).append("ITUNES :").append("sendTagToDevice").log();
        }
        if (tagInformation != null) {
            if (tagInformation2 != null) {
                this.transferAmbigousTag(tagInformation, tagInformation2);
            } else {
                this.transferTag(tagInformation);
            }
            this.tagSentDirectly = true;
        }
        this.sendTagAddedResponse();
    }

    private int addTag(TagInformation tagInformation, TagInformation tagInformation2, int n) {
        if (ServiceManager.logger2.isTraceEnabled(8192)) {
            ServiceManager.logger2.trace(8192).append("ITUNES : ").append("Add Tag").log();
        }
        int n2 = 13;
        if (tagInformation != null) {
            ITunesTagInformation iTunesTagInformation = new ITunesTagInformation(tagInformation);
            if (tagInformation2 != null) {
                ITunesTagInformation iTunesTagInformation2 = new ITunesTagInformation(tagInformation2);
                iTunesTagInformation2.setAmbiguousIdentifier(iTunesTagInformation.generateAmbiguousIdentifier());
                n2 = this.addToTagList(iTunesTagInformation2, n);
            }
            if (n2 == 17) {
                tagInformation.ambiguousTag = false;
            }
            n2 = this.addToTagList(iTunesTagInformation, n);
        }
        this.sendTagAddedResponse();
        return n2;
    }

    private int addToTagList(ITunesTagInformation iTunesTagInformation, int n) {
        if (ServiceManager.logger2.isTraceEnabled(8192)) {
            ServiceManager.logger2.trace(8192).append("ITUNES : ").append("Add Tag to list : ").append(iTunesTagInformation.toString()).log();
        }
        if (ServiceManager.logger2.isTraceEnabled(8192)) {
            ServiceManager.logger2.trace(8192).append("ITUNES : ").append("Added Tag ambiguous identifier : ").append(iTunesTagInformation.getAmbiguousIdentifier()).log();
        }
        int n2 = 13;
        ITunesDatabase iTunesDatabase = this.getDatabaseCollector().get(n);
        if (iTunesDatabase == null) {
            return n2;
        }
        n2 = iTunesDatabase.add(iTunesTagInformation);
        if (n2 == 0) {
            this.getModelController().updateTaggingStatistics(iTunesDatabase.size(), iTunesDatabase.getFreeSpace());
            this.getModelController().updateTaggingList(iTunesDatabase.getAllTags());
            this.getDatabaseCollector().markDirty(true);
            n2 = 18;
        }
        if (iTunesTagInformation.buttonPressed) {
            this.getModelController().updateTaggingResult(n2);
        }
        if (this.getDeviceConnectedStatus() == 2 || this.getDeviceConnectedStatus() == 3) {
            if (ServiceManager.logger2.isTraceEnabled(8192)) {
                ServiceManager.logger2.trace(8192).append("Device not supported situation ").log();
            }
            if (n2 == 0) {
                this.getModelController().updateResultToHMI(26);
            } else if (n2 == 24) {
                this.getModelController().updateResultToHMI(24);
            }
        }
        return n2;
    }

    public void sendAllTags(int n) {
        ITunesDatabase iTunesDatabase = this.getDatabaseCollector().get(n);
        if (iTunesDatabase == null) {
            return;
        }
        TagInformation[] tagInformationArray = iTunesDatabase.getAllTags();
        this.getModelController().updateTaggingList(tagInformationArray);
    }

    public int removeTagWithTagInfo(TagInformation tagInformation, int n) {
        ITunesDatabase iTunesDatabase = this.getDatabaseCollector().get(n);
        if (iTunesDatabase == null) {
            return 13;
        }
        if (tagInformation != null) {
            iTunesDatabase.remove(new ITunesTagInformation(tagInformation));
            int n2 = iTunesDatabase.size();
            int n3 = iTunesDatabase.getFreeSpace();
            this.getModelController().updateTaggingStatistics(n2, n3);
            this.getModelController().updateTaggingList(iTunesDatabase.getAllTags());
            this.getDatabaseCollector().markDirty(true);
        }
        return 0;
    }

    public int removeAllTags(int n) {
        ITunesDatabase iTunesDatabase = this.getDatabaseCollector().get(n);
        if (iTunesDatabase == null) {
            return 13;
        }
        if (iTunesDatabase.size() > 0) {
            iTunesDatabase.removeAll();
            int n2 = iTunesDatabase.size();
            int n3 = iTunesDatabase.getFreeSpace();
            this.getModelController().updateTaggingStatistics(n2, n3);
            this.getModelController().updateTaggingList(iTunesDatabase.getAllTags());
            this.getDatabaseCollector().markDirty(true);
        }
        return 0;
    }

    public int removeTag(TagInformation tagInformation, int n, int n2) {
        int n3 = 13;
        if (tagInformation != null) {
            n3 = this.removeTagWithTagInfo(tagInformation, n2);
        } else if (n > -1) {
            n3 = this.removeTagWithIndex(n, n2);
        }
        return n3;
    }

    private int removeTagWithIndex(int n, int n2) {
        int n3 = 13;
        ITunesDatabase iTunesDatabase = this.getDatabaseCollector().get(n2);
        if (iTunesDatabase == null) {
            return n3;
        }
        TagInformation[] tagInformationArray = iTunesDatabase.getAllTags();
        CurrentSongTagCollector currentSongTagCollector = this.getModelController().getSongTagWithIndex(n);
        for (int i2 = 0; i2 < tagInformationArray.length; ++i2) {
            if (!currentSongTagCollector.mArtist.equals(tagInformationArray[i2].artist) || !currentSongTagCollector.mTitle.equals(tagInformationArray[i2].title)) continue;
            iTunesDatabase.remove(new ITunesTagInformation(tagInformationArray[i2]));
            int n4 = iTunesDatabase.size();
            int n5 = iTunesDatabase.getFreeSpace();
            this.getModelController().updateTaggingStatistics(n4, n5);
            this.getModelController().updateTaggingList(iTunesDatabase.getAllTags());
            this.getDatabaseCollector().markDirty(true);
        }
        return n3;
    }

    public void sendNextInstanceNumberResponse(String string) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-509739008);
        eventGeneric.setString(0, string);
        eventGeneric.setInt(1, this.checkAndReturnInstance(string));
        ITunesHandler.getTarget().sendSafe(eventGeneric);
    }

    public void sendTagAddedResponse() {
        if (this.isFirstTagAfterStartupOrAfterDeviceConnected()) {
            this.getModelController().updateResultToHMI(27);
            this.setFirstTagAfterStartupOrAfterDeviceConnected(false);
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-425852928);
        ITunesHandler.getTarget().sendSafe(eventGeneric);
    }

    public boolean isFirstTagAfterStartupOrAfterDeviceConnected() {
        return this.firstTagAfterStartupOrAfterDeviceConnected;
    }

    public void setFirstTagAfterStartupOrAfterDeviceConnected(boolean bl) {
        this.firstTagAfterStartupOrAfterDeviceConnected = bl;
    }

    public void checkIfTaggable(int n, TagInformation tagInformation) {
        ITunesDatabase iTunesDatabase = this.getDatabaseCollector().get(n);
        if (iTunesDatabase != null) {
            this.getModelController().enableTaggingButton(true);
            this.getModelController().taggingPossible(iTunesDatabase.canAdd(new ITunesTagInformation(tagInformation), false));
        }
    }

    public void resetAll() {
        int n = this.getNumInstances();
        if (n > 0) {
            for (int i2 = 0; i2 < n; ++i2) {
                this.resetSettings(i2);
            }
        }
    }

    public void resetSettings(int n) {
        this.removeAllTags(n);
        this.getInfoPersistence().removeInstance(n);
    }

    public void notifyItunesStarted() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(557853696);
        ITunesHandler.getTarget().sendSafe(eventGeneric);
    }

    public void updateResult(int n) {
        this.getModelController().updateResultToHMI(n);
    }

    public void setDeviceConnectedStatus(int n) {
        this.deviceConnectedStatus = n;
    }

    public int getDeviceConnectedStatus() {
        return this.deviceConnectedStatus;
    }
}

