/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online;

import de.vw.mib.asl.api.navigation.AbstractASLNavigationServicesListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.OnlineDestinationImportManager;
import de.vw.mib.asl.internal.online.common.destinationimport.AddressEntry;
import de.vw.mib.asl.internal.online.states.OnlineDestinationImportTarget;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.util.Util;
import java.lang.reflect.Array;
import org.dsi.ifc.online.PortalADBEntry;
import org.dsi.ifc.organizer.AdbEntry;

public class OnlineDestinationImportController
extends AbstractASLNavigationServicesListener {
    final String _classname = super.getClass().getName();
    private int _aNumberEntriesRemaining = 0;
    private boolean _navServiceAvailable = false;
    private boolean _guidanceState = false;
    private LongObjectOptHashMap _portalEntries = null;
    private int _importStatus = 0;
    private long[] _keys = null;
    private int _contactCapacity = 0;
    private PortalADBEntry _importedEntry = null;
    private boolean _downloadState = false;
    private int _entriesAvailable = 0;
    private int _entriesSuccess = 0;
    private int _entriesFailed = 0;
    private int _importContactResult = 1;
    private boolean _stopDownload = false;
    private boolean _automaticDownload = false;
    private int _autoDestImportstatus = 0;
    private boolean _contactCapacityFull = false;
    private int _serviceStatus = -1;

    @Override
    public void importContactResult(int n) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(new StringBuffer().append(".importContactResult(").append(n).append(")").toString()).log();
        }
        if (this.isStopDownload()) {
            this.removeRemainingEntries();
            this._importStatus = 3002;
            this.getEntries(0);
            return;
        }
        switch (n) {
            case 1: {
                if (this._importedEntry == null) break;
                ++this._entriesSuccess;
                this.getPortalEntriesMap().remove(this._importedEntry.getEntryID());
                if (this.getContactCapacity() <= 0) {
                    if (!this.getPortalEntriesMap().isEmpty()) {
                        this.removeRemainingEntries();
                        this._importStatus = 3003;
                    }
                    this.startTimer();
                    this.getEntries(this.getContactCapacity());
                    break;
                }
                if (this.getPortalEntriesMap().isEmpty()) {
                    if (this._importStatus == 3002) {
                        this.startTimer();
                    }
                    this.getEntries(this.getContactCapacity());
                    break;
                }
                this.sendImportedEntriesToNavigation();
                break;
            }
            case 2: {
                this.getTarget().warn().append(this._classname).append(new StringBuffer().append(".importContactResult(").append(n).append(") Import contact failed").toString()).log();
                if (this.isNavServiceAvailable() && this.getContactCapacity() > 0) {
                    ++this._entriesFailed;
                    this.removeEntry(this._importedEntry);
                    this.getPortalEntriesMap().remove(this._importedEntry.getEntryID());
                    this.sendImportedEntriesToNavigation();
                    break;
                }
                this.setDownloadStateActive(false);
                if (this.getContactCapacity() > 0) break;
                this.removeRemainingEntries();
                this._importStatus = 3003;
                this.getEntries(this.getContactCapacity());
                this.startTimer();
                break;
            }
            default: {
                this.getTarget().info().append(this._classname).append(new StringBuffer().append(".importContactResult(").append(n).append(") Unknown result code").toString()).log();
            }
        }
    }

    @Override
    public void updateContactCapacity(int n) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(new StringBuffer().append(".updateContactCapacity(").append(n).append(")").toString()).log();
        }
        this._contactCapacity = n;
    }

    @Override
    public void updateGuidanceActive(boolean bl) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(new StringBuffer().append(".updateGuidanceActive(").append(bl).append(")").toString()).log();
        }
        this._guidanceState = bl;
    }

    @Override
    public void updateServiceAvailable(boolean bl) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(new StringBuffer().append(".updateServiceAvailable(").append(bl).append(")").toString()).log();
        }
        this._navServiceAvailable = bl;
        if (bl && this.getAutomaticDestinationImportProcess() != 2 && this._serviceStatus == 0 && this.getAutomaticDestinationImportProcess() != 1) {
            this.callForAutomaticDestinationImportonStartup();
        }
    }

    private LongObjectOptHashMap getPortalEntriesMap() {
        if (this._portalEntries == null) {
            this._portalEntries = new LongObjectOptHashMap();
        }
        return this._portalEntries;
    }

    OnlineDestinationImportTarget getTarget() {
        return OnlineDestinationImportManager.getOnlineDestinationImportTarget();
    }

    private void setNumberEntriesRemaining(int n) {
        this._aNumberEntriesRemaining = n;
    }

    private void getEntries(int n) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(new StringBuffer().append(".getEntries(").append(n).append(")").toString()).log();
        }
        boolean bl = true;
        if (this.getTarget().getDSIDestinationImport() != null) {
            if (!Util.isNullOrEmpty(this._keys)) {
                this.getTarget().getDSIDestinationImport().setADBImportStatus(this._keys, this._importStatus);
            }
            if (n <= 0 || this.getNumberEntriesRemaining() == 0) {
                bl = false;
                this.setDownloadStateActive(bl);
                if (n < 0) {
                    n = 0;
                }
            } else {
                this.getTarget().getDSIDestinationImport().downloadAddressList(n, bl);
            }
        }
    }

    private void sendImportedEntriesToNavigation() {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".sendEntriesToNavigation()").log();
        }
        if (!this.getPortalEntriesMap().isEmpty() && OnlineDestinationImportManager.getNaviServices() != null) {
            LongIterator longIterator = this.getPortalEntriesMap().keyIterator();
            while (longIterator.hasNext()) {
                long l = longIterator.next();
                Object object = this.getPortalEntriesMap().get(l);
                if (object != null) {
                    this._importedEntry = (PortalADBEntry)object;
                    AdbEntry adbEntry = new AddressEntry().mapPortalAddressEntry(this._importedEntry);
                    if (this.isNavServiceAvailable() && this.getContactCapacity() > 0) {
                        if (this.getTarget().isTraceEnabled()) {
                            this.getTarget().trace().append(new StringBuffer().append("Imported Entry to Navigation->").append(adbEntry != null ? adbEntry.toString() : "NULL").toString()).log();
                        }
                        OnlineDestinationImportManager.getNaviServices().importContact(adbEntry, 1);
                    } else {
                        this.getTarget().info().append(this._classname).append(".sendEntriesToNavigation()->Either Service is not available or Contact capactiy is zero ").log();
                    }
                    break;
                }
                this._importedEntry = null;
                ++this._entriesFailed;
            }
        } else {
            this.setDownloadStateActive(false);
            this.getEntries(this.getContactCapacity());
            this.startTimer();
            this.getTarget().info().append(this._classname).append(".sendEntriesToNavigation()-> EMPTY elements || Navi Services interface not yet started").log();
        }
    }

    private void removeRemainingEntries() {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".removeRemainingEntries()").log();
        }
        if (!this.getPortalEntriesMap().isEmpty()) {
            LongIterator longIterator = this.getPortalEntriesMap().keyIterator();
            while (longIterator.hasNext()) {
                this.removeEntry((PortalADBEntry)this.getPortalEntriesMap().get(longIterator.next()));
            }
            this.getPortalEntriesMap().clear();
        } else if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".removeRemainingEntries()-> No Entries available").log();
        }
    }

    private void removeEntry(PortalADBEntry portalADBEntry) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(new StringBuffer().append(".removeEntry(").append(portalADBEntry != null ? portalADBEntry.toString() : "NULL").append(")").toString()).log();
        }
        if (!Util.isNullOrEmpty(this._keys) && portalADBEntry != null) {
            int n = -1;
            int n2 = this._keys.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (this._keys[i2] != portalADBEntry.entryID) continue;
                n = i2;
            }
            if (n > -1) {
                this._keys = (long[])this.remove(this._keys, n);
            } else if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace().append(this._classname).append(".removeEntry()-> Index of the element not found").log();
            }
        }
    }

    private Object remove(Object object, int n) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".remove()").log();
        }
        int n2 = Array.getLength(object);
        if (n < 0 || n >= n2) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n).append(", Length: ").append(n2).toString());
        }
        Object object2 = Array.newInstance(object.getClass().getComponentType(), n2 - 1);
        System.arraycopy(object, 0, object2, 0, n);
        if (n < n2 - 1) {
            System.arraycopy(object, n + 1, object2, n, n2 - n - 1);
        }
        return object2;
    }

    private void sendSafeEvent(boolean bl) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(54413568);
        eventGeneric.setBoolean(0, bl);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    private boolean isImportStatusValid(int n) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(new StringBuffer().append(".importStatusValid(").append(n).append(")").toString()).log();
        }
        boolean bl = false;
        switch (n) {
            case 1000: 
            case 1003: 
            case 3003: 
            case 3004: {
                this.getTarget().info().append(this._classname).append(new StringBuffer().append(".importStatusValid(").append(n).append(")-> Import status resulted in error.").toString()).log();
                break;
            }
            case 0: 
            case 3001: 
            case 3002: {
                bl = true;
                break;
            }
        }
        return bl;
    }

    private void setImportStatus(int n, int n2) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(new StringBuffer().append(".setImportStatus(").append(n).append(", ").append(n2).append(")").toString()).log();
        }
        switch (n) {
            case 1000: {
                this._importStatus = 3004;
                break;
            }
            case 1003: {
                this._importStatus = 3004;
                break;
            }
            case 3003: {
                this._importStatus = 3003;
                break;
            }
            case 3004: {
                this._importStatus = 3004;
                this.getTarget().info().append(this._classname).append(new StringBuffer().append(".importStatusValid(").append(n).append(")-> Import status resulted in error.").toString()).log();
                break;
            }
            case 3001: {
                this._importStatus = 3001;
                break;
            }
            case 0: 
            case 3002: {
                if (n2 > 0) {
                    this._importStatus = 3001;
                    break;
                }
                this._importStatus = 3002;
                break;
            }
        }
    }

    public void startTimer() {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".startTimer()").log();
        }
        this.getTarget().startTimer(-1585053440, (long)0, false);
    }

    public void reset() {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".reset()").log();
        }
        this._importContactResult = 1;
        this._entriesSuccess = 0;
        this._entriesFailed = 0;
        this.setNumberEntriesRemaining(0);
        this.setDownloadStateActive(false);
        this.setStopDownload(false);
        this.setContactCapacityFull(false);
    }

    public boolean isNavServiceAvailable() {
        return this._navServiceAvailable;
    }

    public boolean isGuidanceStateActive() {
        return this._guidanceState;
    }

    public int getContactCapacity() {
        return this._contactCapacity;
    }

    public int getNumberEntriesRemaining() {
        return this._aNumberEntriesRemaining;
    }

    public int getEntriesAvailableOnServer() {
        return this._entriesAvailable;
    }

    public void handleServiceFullFactoryReset() {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".handleServiceFullFactoryReset()").log();
        }
    }

    public void setDownloadStateActive(boolean bl) {
        if (this._downloadState != bl) {
            this.sendSafeEvent(bl);
            this._downloadState = bl;
        }
    }

    public boolean isDownloadStateActive() {
        return this._downloadState;
    }

    public int getEntriesSucceeded() {
        return this._entriesSuccess;
    }

    public int getEntriesFailed() {
        return this._entriesFailed;
    }

    public int getimportContactResult() {
        return this._importContactResult;
    }

    public boolean isStopDownload() {
        return this._stopDownload;
    }

    public void setStopDownload(boolean bl) {
        this._stopDownload = bl;
    }

    public void responseDownloadAddressListResult(PortalADBEntry[] portalADBEntryArray, int n, int n2) {
        if (this.isStopDownload()) {
            if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace().append(this._classname).append(".responseDownloadAddressListResult()--> stopping download in progress").log();
            }
            return;
        }
        this.setImportStatus(n, n2);
        if (!Util.isNullOrEmpty(portalADBEntryArray) && this.isImportStatusValid(n)) {
            if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace().append(this._classname).append(new StringBuffer().append(".responseDownloadAddressListResult(").append(portalADBEntryArray.length).append(", ").append(n).append(", ").append(n2).append(")").toString()).log();
            }
            int n3 = portalADBEntryArray.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                if (portalADBEntryArray[i2] == null) continue;
                this.getPortalEntriesMap().put(portalADBEntryArray[i2].entryID, portalADBEntryArray[i2]);
            }
            this._keys = this.getPortalEntriesMap().keysToArray();
            this.sendImportedEntriesToNavigation();
        } else {
            this.getTarget().warn().append(this._classname).append(new StringBuffer().append(".responseDownloadAddressListResult(0, ").append(n).append(", ").append(n2).append(")").toString()).append("->Either address list is EMPTY or NULL or Status is INVALID").log();
            if (this.getTarget().getDSIDestinationImport() != null) {
                this.getTarget().getDSIDestinationImport().setADBImportStatus(null, n);
            }
            if (!this.isImportStatusValid(n)) {
                this._importContactResult = 2;
            }
            if (this._automaticDownload) {
                this.reset();
            } else {
                this.startTimer();
            }
        }
        this.setNumberEntriesRemaining(n2);
    }

    public void responseStopActionResult(int n) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(new StringBuffer().append(".responseStopActionResult(").append(n).append(")").toString()).log();
        }
        this.startTimer();
    }

    public void updateEntries(int n) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(new StringBuffer().append(".updateEntries(").append(n).append(")").toString()).log();
        }
        this._entriesAvailable = n;
    }

    public void errorHandling(int n, int n2) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(new StringBuffer().append(".errorHandling(").append(n).append(", ").append(n2).append(")").toString()).log();
        }
        if (n == 8304) {
            switch (n2) {
                case 1003: {
                    break;
                }
                case 1004: {
                    break;
                }
                case 1005: {
                    break;
                }
            }
        } else {
            switch (n) {
                case 1000: {
                    break;
                }
                case 1003: {
                    break;
                }
                case 8300: {
                    break;
                }
                case 8301: {
                    break;
                }
                case 8302: {
                    break;
                }
                case 8303: {
                    break;
                }
                case 8305: {
                    break;
                }
                case 10001: {
                    break;
                }
            }
        }
        if (this.isDownloadStateActive()) {
            this.setDownloadStateActive(false);
            if (this._automaticDownload) {
                this.reset();
            } else {
                this._importContactResult = 2;
                this.startTimer();
            }
        }
    }

    public void startDownloadDestinations(boolean bl) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(new StringBuffer().append(".startDownloadDestinations(").append(bl).append(")").toString()).log();
        }
        this._automaticDownload = bl;
        if (!this.isStopDownload() && this.isNavServiceAvailable() && this.getContactCapacity() > 0) {
            if (this.getTarget().getDSIDestinationImport() != null) {
                this.getTarget().getDSIDestinationImport().downloadAddressList(this.getContactCapacity(), true);
                this.setDownloadStateActive(true);
            }
        } else if (this.isStopDownload() || this.getContactCapacity() <= 0 || !this.isNavServiceAvailable()) {
            if (this._automaticDownload) {
                this.reset();
            } else {
                if (this.getContactCapacity() <= 0) {
                    this.setContactCapacityFull(true);
                }
                this.startTimer();
            }
        }
    }

    public void stopDownloadDestinations() {
        if (this.isDownloadStateActive()) {
            this.setStopDownload(true);
            this.getTarget().getDSIDestinationImport().stopAction();
        } else {
            this.reset();
        }
    }

    public void setAutomaticDestinationImportProcess(int n) {
        this._autoDestImportstatus = n;
    }

    public int getAutomaticDestinationImportProcess() {
        return this._autoDestImportstatus;
    }

    public boolean isContactCapacityFull() {
        return this._contactCapacityFull;
    }

    public void setContactCapacityFull(boolean bl) {
        this._contactCapacityFull = bl;
    }

    public void callForAutomaticDestinationImportonStartup() {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".callForAutomaticDestinationImportonStartup()").log();
        }
        if (this.isNavServiceAvailable() && this.getContactCapacity() > 0) {
            if (this.getAutomaticDestinationImportProcess() != 1) {
                this.setAutomaticDestinationImportProcess(1);
                this.startDownloadDestinations(true);
                this.setAutomaticDestinationImportProcess(2);
            }
        } else if (this.getTarget().isTraceEnabled()) {
            this.getTarget().info().append(this._classname).append(new StringBuffer().append(".callForAutomaticDestinationImportonStartup()--> NaviServiceReady = ").append(this.isNavServiceAvailable()).toString()).log();
        }
    }

    public void setServiceStatus(int n) {
        this._serviceStatus = n;
    }
}

