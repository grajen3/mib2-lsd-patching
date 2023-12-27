/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.itunes.model;

import de.vw.mib.asl.api.itunes.model.CurrentSongTagCollector;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.itunes.ITunesHandler;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.TagInformation;

public class ITunesModelController {
    public void setPropertyBoolean(int n, boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(n, bl);
    }

    public void setPropertyInteger(int n, int n2) {
        ServiceManager.aslPropertyManager.valueChangedInteger(n, n2);
    }

    public void setPropertyLong(int n, long l) {
        ServiceManager.aslPropertyManager.valueChangedLong(n, l);
    }

    public void setPropertyString(int n, String string) {
        ServiceManager.aslPropertyManager.valueChangedString(n, string);
    }

    public void setPropertyResourceLocator(int n, ResourceLocator resourceLocator) {
        ServiceManager.aslPropertyManager.valueChangedResourceLocator(n, resourceLocator);
    }

    public void updateTaggingList(TagInformation[] tagInformationArray) {
        Object[] objectArray = new CurrentSongTagCollector[tagInformationArray.length];
        for (int i2 = 0; i2 < tagInformationArray.length; ++i2) {
            objectArray[i2] = new CurrentSongTagCollector(tagInformationArray[i2].getArtist(), tagInformationArray[i2].getTitle());
            if (!ServiceManager.logger2.isTraceEnabled(8192)) continue;
            ServiceManager.logger2.trace(8192).append("ITUNES : ").append("Tag List to model : ").append(" ARTIST : ").append(tagInformationArray[i2].getArtist()).append(" TITLE : ").append(tagInformationArray[i2].getTitle()).log();
        }
        ListManager.getGenericASLList(1453).updateList(objectArray);
    }

    public CurrentSongTagCollector getSongTagWithIndex(int n) {
        CurrentSongTagCollector currentSongTagCollector = null;
        CurrentSongTagCollector[] currentSongTagCollectorArray = (CurrentSongTagCollector[])ListManager.getGenericASLList(1453).getDSIObjects();
        if (currentSongTagCollectorArray != null && n < currentSongTagCollectorArray.length) {
            return currentSongTagCollectorArray[n];
        }
        return currentSongTagCollector;
    }

    public void updateTaggingStatistics(int n, int n2) {
        if (ServiceManager.logger2.isTraceEnabled(8192)) {
            ServiceManager.logger2.trace(8192).append("ITUNES : ").append("Tag List Size : ").append(" Number of Stored Tags : ").append(n).append(" Number of Tags Possible : ").append(n2).log();
        }
        this.setPropertyInteger(1406, n2);
    }

    public void enableTaggingButton(boolean bl) {
        this.setPropertyBoolean(3537, bl);
    }

    public void updateSongTagged(boolean bl) {
        this.setPropertyBoolean(1428, bl);
    }

    public void updateChannelTagable(boolean bl) {
        this.setPropertyBoolean(1427, bl);
    }

    public void updateTransferredSongTags(int n) {
        this.setPropertyInteger(1425, n);
    }

    public void updateTransferringSongTagsActive(boolean bl) {
        this.setPropertyBoolean(1450, bl);
    }

    public void taggingPossible(int n) {
        boolean bl = false;
        boolean bl2 = false;
        if (n == 17) {
            bl = true;
        } else if (n == 0 || n == 14) {
            bl2 = true;
        }
        if (ServiceManager.logger2.isTraceEnabled(8192)) {
            ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" Tagged ").append(bl).append(" isTaggable = ").append(bl2).log();
        }
        this.updateSongTagged(bl);
        this.updateChannelTagable(bl2);
    }

    public void updateTaggingResult(int n) {
        boolean bl = false;
        if (n == 17) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(228);
        } else if (n == 24) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(231);
        } else if (n == 21) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(226);
        } else if (n == 18) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(427);
            bl = true;
        } else if (n == 20) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(428);
            bl = true;
        } else if (n == 0) {
            bl = true;
        }
        this.enableTaggingButton(true);
        this.updateSongTagged(bl);
        this.updateChannelTagable(!bl);
    }

    public void notifySongTagged() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(531);
    }

    public void updateResultToHMI(int n) {
        if (ServiceManager.logger2.isTraceEnabled(8192)) {
            ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" Update result to HMI : ").append(n).log();
        }
        if (n == 17) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(228);
        } else if (n == 24) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(231);
        } else if (n == 21) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(226);
        } else if (n == 18) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(427);
        } else if (n == 20) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(428);
        } else if (n == 29) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(224);
        } else if (n == 23) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(225);
        } else if (n == 22) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(227);
        } else if (n == 28) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(229);
        } else if (n == 26) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(230);
        } else if (n == 27) {
            int n2 = ITunesHandler.getITunesController().getDeviceConnectedStatus();
            if (n2 == 0) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(314975232);
            } else if (n2 == 2) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(331752448);
            } else {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(348529664);
            }
        }
    }

    public void updateTagCountTransferedSuccessfully(int n) {
        if (ServiceManager.logger2.isTraceEnabled(8192)) {
            ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" Number of tags been transfered : ").append(n).log();
        }
        this.setPropertyInteger(1425, n);
    }
}

