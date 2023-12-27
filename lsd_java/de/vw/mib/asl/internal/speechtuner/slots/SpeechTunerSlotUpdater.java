/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.slots;

import de.vw.mib.asl.api.radio.amFm.AmFmStation;
import de.vw.mib.asl.api.radio.dab.DabService;
import de.vw.mib.asl.api.radio.sdars.SiriusChannel;
import de.vw.mib.asl.api.speechengine.slots.SlotEntry;
import de.vw.mib.asl.api.speechengine.slots.SlotUpdater;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerLogger;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;
import java.util.ArrayList;

public class SpeechTunerSlotUpdater {
    private static final String LOGGER_PREFIX;
    protected SpeechTunerServiceManager serviceManager;
    protected SpeechTunerLogger logger;
    private final SlotUpdater slotUpdater;

    public SpeechTunerSlotUpdater(SpeechTunerServiceManager speechTunerServiceManager, SlotUpdater slotUpdater) {
        this.serviceManager = speechTunerServiceManager;
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[SpeechTunerSlotUpdater] ");
        this.slotUpdater = slotUpdater;
    }

    private SlotEntry[] convertFmStationList(AmFmStation[] amFmStationArray) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("converting FM stationlist to slot entries");
        }
        ArrayList arrayList = new ArrayList();
        if (amFmStationArray != null) {
            for (int i2 = 0; i2 < amFmStationArray.length; ++i2) {
                AmFmStation amFmStation = amFmStationArray[i2];
                boolean bl = false;
                if (amFmStation != null) {
                    long l = this.serviceManager.getRadioUtils().getObjectId(amFmStation);
                    if (amFmStation.getLongName() != null && !amFmStation.getLongName().equals("")) {
                        arrayList.add(this.slotUpdater.createSlotEntry(l, amFmStation.getLongName()));
                        bl = true;
                        if (this.logger.isTraceEnabled()) {
                            this.logger.trace(new StringBuffer().append("... adding entry id ").append(l).append(" as ").append(amFmStation.getLongName()).toString());
                        }
                    }
                    if (!(amFmStation.getShortName() == null || amFmStation.getShortName().equals("") || amFmStation.getLongName() != null && amFmStation.getShortName().equals(amFmStation.getLongName()))) {
                        arrayList.add(this.slotUpdater.createSlotEntry(l, amFmStation.getShortName()));
                        bl = true;
                        if (this.logger.isTraceEnabled()) {
                            this.logger.trace(new StringBuffer().append("... adding entry id ").append(l).append(" as ").append(amFmStation.getShortName()).toString());
                        }
                    }
                    if (bl) continue;
                    String string = this.serviceManager.getRadioUtils().getStringFromStationWithoutUnit(amFmStation);
                    arrayList.add(this.slotUpdater.createSlotEntry(l, string));
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace(new StringBuffer().append("... adding entry id ").append(l).append(" as ").append(string).toString());
                    }
                    string = this.serviceManager.getRadioUtils().getStringFromStationWithMHz(amFmStation);
                    arrayList.add(this.slotUpdater.createSlotEntry(l, string));
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace(new StringBuffer().append("... adding entry id ").append(l).append(" as ").append(string).toString());
                    }
                    string = this.serviceManager.getRadioUtils().getStringFromStationWithBand(amFmStation);
                    arrayList.add(this.slotUpdater.createSlotEntry(l, string));
                    if (!this.logger.isTraceEnabled()) continue;
                    this.logger.trace(new StringBuffer().append("... adding entry id ").append(l).append(" as ").append(string).toString());
                    continue;
                }
                this.logger.warn("FM station not added to slot because it was null");
            }
        } else {
            this.logger.warn("no slot update because FM stationlist was null");
        }
        Object[] objectArray = new SlotEntry[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    private SlotEntry[] convertDabServiceList(DabService[] dabServiceArray) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("converting DAB stationlist to slot entries");
        }
        ArrayList arrayList = new ArrayList();
        if (dabServiceArray != null) {
            for (int i2 = 0; i2 < dabServiceArray.length; ++i2) {
                DabService dabService = dabServiceArray[i2];
                boolean bl = false;
                if (dabService != null) {
                    long l = this.serviceManager.getRadioUtils().getObjectId(dabService);
                    if (dabService.getLongName() != null && !dabService.getLongName().equals("")) {
                        arrayList.add(this.slotUpdater.createSlotEntry(l, dabService.getLongName()));
                        bl = true;
                        if (this.logger.isTraceEnabled()) {
                            this.logger.trace(new StringBuffer().append("... adding entry id ").append(l).append(" as ").append(dabService.getLongName()).toString());
                        }
                    }
                    if (!(dabService.getShortName() == null || dabService.getShortName().equals("") || dabService.getLongName() != null && dabService.getShortName().equals(dabService.getLongName()))) {
                        arrayList.add(this.slotUpdater.createSlotEntry(l, dabService.getShortName()));
                        bl = true;
                        if (this.logger.isTraceEnabled()) {
                            this.logger.trace(new StringBuffer().append("... adding entry id ").append(l).append(" as ").append(dabService.getShortName()).toString());
                        }
                    }
                    if (bl) continue;
                    this.logger.warn("tried to add a DAB service without name to the slot, this is not possible ");
                    continue;
                }
                this.logger.warn("DAB service not added to slot because it was null");
            }
        } else {
            this.logger.warn("no slot update because DAB servicelist was null");
        }
        Object[] objectArray = new SlotEntry[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    private SlotEntry[] convertSiriusChannelList(SiriusChannel[] siriusChannelArray) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("converting Sirius stationlist to slot entries");
        }
        ArrayList arrayList = new ArrayList();
        if (siriusChannelArray != null) {
            for (int i2 = 0; i2 < siriusChannelArray.length; ++i2) {
                SiriusChannel siriusChannel = siriusChannelArray[i2];
                boolean bl = false;
                if (siriusChannel != null) {
                    long l = this.serviceManager.getRadioUtils().getObjectId(siriusChannel);
                    if (siriusChannel.getLongName() != null && !siriusChannel.getLongName().equals("")) {
                        arrayList.add(this.slotUpdater.createSlotEntry(l, siriusChannel.getLongName()));
                        bl = true;
                        if (this.logger.isTraceEnabled()) {
                            this.logger.trace(new StringBuffer().append("... adding entry id ").append(l).append(" as ").append(siriusChannel.getLongName()).toString());
                        }
                    }
                    if (!(siriusChannel.getShortName() == null || siriusChannel.getShortName().equals("") || siriusChannel.getLongName() != null && siriusChannel.getShortName().equals(siriusChannel.getLongName()))) {
                        arrayList.add(this.slotUpdater.createSlotEntry(l, siriusChannel.getShortName()));
                        bl = true;
                        if (this.logger.isTraceEnabled()) {
                            this.logger.trace(new StringBuffer().append("... adding entry id ").append(l).append(" as ").append(siriusChannel.getShortName()).toString());
                        }
                    }
                    if (bl) continue;
                    this.logger.warn("tried to add a Sirius channel without name to the slot, this is not possible ");
                    continue;
                }
                this.logger.warn("Sirius channel not added to slot because it was null");
            }
        } else {
            this.logger.warn("no slot update because Sirius channellist was null");
        }
        Object[] objectArray = new SlotEntry[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    public void updateFMSlotData(AmFmStation[] amFmStationArray) {
        SlotEntry[] slotEntryArray = this.convertFmStationList(amFmStationArray);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("sending slot update for FM stations to speech engine");
        }
        this.slotUpdater.updateSlotData(42, 2, slotEntryArray);
    }

    public void updateDABSlotData(DabService[] dabServiceArray) {
        SlotEntry[] slotEntryArray = this.convertDabServiceList(dabServiceArray);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("sending slot update for DAB services to speech engine");
        }
        this.slotUpdater.updateSlotData(41, 2, slotEntryArray);
    }

    public void updateSiriusSlotData(SiriusChannel[] siriusChannelArray) {
        SlotEntry[] slotEntryArray = this.convertSiriusChannelList(siriusChannelArray);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("sending slot update for Sirius channels to speech engine");
        }
        this.slotUpdater.updateSlotData(52, 1, slotEntryArray);
    }
}

