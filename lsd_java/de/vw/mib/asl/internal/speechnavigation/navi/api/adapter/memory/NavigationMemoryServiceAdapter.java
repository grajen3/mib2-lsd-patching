/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.memory.INavigationContact;
import de.vw.mib.asl.api.navigation.memory.NavigationMemoryListener;
import de.vw.mib.asl.api.navigation.memory.NavigationMemoryService;
import de.vw.mib.asl.api.speechengine.slots.SlotEntry;
import de.vw.mib.asl.api.speechengine.slots.SlotUpdater;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.common.SpeechServices;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.ContactsService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.HomeAddressService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.LastDestinationService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.NavigationMemoryServiceAdapterBase;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.NavigationMemoryServiceAdapterBase$DownloadContactsStatus;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.NavigationMemoryServiceAdapterBase$GetContactsCallerLock;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.NavigationMemoryServiceAdapterBase$GetLastDestinationCallerLock;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.listener.ContactsDownloadStatusListener;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.listener.GetContactsListener;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.listener.GetLastDestinationAddressListener;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.listener.LastDestinationListener;
import java.util.ArrayList;
import java.util.List;

public final class NavigationMemoryServiceAdapter
extends NavigationMemoryServiceAdapterBase
implements NavigationMemoryListener,
LastDestinationService,
HomeAddressService,
ContactsService {
    private final SlotUpdater slotUpdater;
    private final NavigationMemoryService navigationMemoryService;
    private NavigationMemoryServiceAdapterBase$GetLastDestinationCallerLock getLastDestinationCallerLock = new NavigationMemoryServiceAdapterBase$GetLastDestinationCallerLock(this);
    private NavigationMemoryServiceAdapterBase$GetContactsCallerLock getContactsCallerLock = new NavigationMemoryServiceAdapterBase$GetContactsCallerLock(this);
    private final List lastDestinationChangedListeners = new ArrayList();
    final NavigationMemoryServiceAdapterBase$DownloadContactsStatus downloadContactsStatus = new NavigationMemoryServiceAdapterBase$DownloadContactsStatus(this);
    private static NavigationMemoryServiceAdapter instance = null;

    private NavigationMemoryServiceAdapter() {
        this.slotUpdater = SpeechServices.getSlotUpdaterService();
        this.navigationMemoryService = ASLNavigationFactory.getNavigationApi().getNavigationMemoryService(this);
        if (this.navigationMemoryService.isServiceAvailable()) {
            this.updateLastDestinations(this.navigationMemoryService.getLastDestinations());
        }
    }

    private static NavigationMemoryServiceAdapter getInstance() {
        if (instance == null) {
            instance = new NavigationMemoryServiceAdapter();
        }
        return instance;
    }

    public static HomeAddressService getHomeAddressService() {
        return NavigationMemoryServiceAdapter.getInstance();
    }

    public static LastDestinationService getLastDestinationService() {
        return NavigationMemoryServiceAdapter.getInstance();
    }

    public static ContactsService getContactsService() {
        return NavigationMemoryServiceAdapter.getInstance();
    }

    @Override
    public void getContacts(GetContactsListener getContactsListener, long[] lArray) {
        try {
            this.getContactsCallerLock.acquire(getContactsListener, lArray);
            this.navigationMemoryService.getContacts(lArray, null);
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", error calling getContacts: ").append(navigationServiceException.getMessage()).toString());
            this.getContactsCallerLock.release(1);
        }
    }

    @Override
    public void getLastDestination(GetLastDestinationAddressListener getLastDestinationAddressListener, INavigationListElement iNavigationListElement) {
        try {
            this.getLastDestinationCallerLock.acquire(getLastDestinationAddressListener, iNavigationListElement);
            this.navigationMemoryService.getLastDestination(iNavigationListElement);
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(new StringBuffer().append("error calling getLastDestination: ").append(navigationServiceException.getMessage()).toString());
            this.getLastDestinationCallerLock.release(1, iNavigationListElement);
        }
    }

    @Override
    public void getLastUsedDestination(GetLastDestinationAddressListener getLastDestinationAddressListener) {
        INavigationListElement[] iNavigationListElementArray = this.getLastDestinations();
        if (iNavigationListElementArray != null && iNavigationListElementArray.length > 0) {
            this.getLastDestination(getLastDestinationAddressListener, iNavigationListElementArray[0]);
        } else {
            getLastDestinationAddressListener.getLastDestinationAddressResponse(0, null, null);
        }
    }

    @Override
    public void getContactsResult(int n, INavigationContact[] iNavigationContactArray, Object object) {
        if (this.getContactsCallerLock.isAcquired()) {
            if (n == 1) {
                AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", getContactsResult FAILED").toString());
                this.getContactsCallerLock.release(1);
            } else {
                this.getContactsCallerLock.release(0, iNavigationContactArray);
            }
        } else {
            AppLogger.trace(new StringBuffer().append(super.getClass().getName()).append(", got getContactsResult but no listener has been aquired").toString());
        }
    }

    @Override
    public void getLastDestinationResult(INavigationListElement iNavigationListElement, INavigationLocation iNavigationLocation, int n) {
        if (this.getLastDestinationCallerLock.isAcquired()) {
            if (n == 1) {
                AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", getLastDestinationResult FAILED").toString());
                this.getLastDestinationCallerLock.release(1, iNavigationListElement, iNavigationLocation);
            } else {
                this.getLastDestinationCallerLock.release(0, iNavigationListElement, iNavigationLocation);
            }
        } else {
            AppLogger.trace(new StringBuffer().append(super.getClass().getName()).append(", got getLastDestinationResult but no listener has been aquired").toString());
        }
    }

    @Override
    public INavigationLocation getHomeAddress() {
        try {
            return this.navigationMemoryService.getHomeAddress();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", error calling getHomeAddress: ").append(navigationServiceException.getMessage()).toString());
            return null;
        }
    }

    @Override
    public INavigationListElement[] getLastDestinations() {
        try {
            INavigationListElement[] iNavigationListElementArray = this.navigationMemoryService.getLastDestinations();
            if (iNavigationListElementArray != null && iNavigationListElementArray.length > 0) {
                return iNavigationListElementArray;
            }
            return new INavigationListElement[0];
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(new StringBuffer().append("error calling getLastDestinations: ").append(navigationServiceException.getMessage()).toString());
            return new INavigationListElement[0];
        }
    }

    @Override
    public INavigationListElement getLastDestination(long l) {
        INavigationListElement[] iNavigationListElementArray = this.getLastDestinations();
        for (int i2 = 0; i2 < iNavigationListElementArray.length; ++i2) {
            if (iNavigationListElementArray[i2].getId() != l) continue;
            return iNavigationListElementArray[i2];
        }
        return null;
    }

    @Override
    public void updateLastDestinations(INavigationListElement[] iNavigationListElementArray) {
        if (iNavigationListElementArray != null && iNavigationListElementArray.length > 0) {
            AppLogger.trace(this, ".updateLastDestinations(..), last destinations list has been updated");
            this.updateListeners(iNavigationListElementArray[0]);
            if (this.slotUpdater == null) {
                AppLogger.error(this, ", slot updater service is not initialized.");
                return;
            }
            SlotEntry[] slotEntryArray = new SlotEntry[iNavigationListElementArray.length];
            for (int i2 = 0; i2 < iNavigationListElementArray.length; ++i2) {
                SlotEntry slotEntry;
                long l = iNavigationListElementArray[i2].getId();
                String string = iNavigationListElementArray[i2].getTitle();
                slotEntryArray[i2] = slotEntry = this.slotUpdater.createSlotEntry(l, string);
            }
            this.slotUpdater.updateSlotData(14, 1, slotEntryArray);
        } else {
            AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(", last destinations list has been deleted").toString());
            this.updateListeners(null);
            this.slotUpdater.updateSlotData(14, 1, new SlotEntry[0]);
        }
    }

    private void updateListeners(INavigationListElement iNavigationListElement) {
        for (int i2 = 0; i2 < this.lastDestinationChangedListeners.size(); ++i2) {
            LastDestinationListener lastDestinationListener = (LastDestinationListener)this.lastDestinationChangedListeners.get(i2);
            if (lastDestinationListener == null) continue;
            lastDestinationListener.onLastDestinationChanged(iNavigationListElement);
        }
    }

    @Override
    public void updateProfileDownloadState(int n, int n2, boolean bl) {
        AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(".updateProfileDownloadState( downloadState = ").append(n).append(", failureReason = ").append(n2).append(", isValid = ").append(bl).toString());
        if (bl) {
            this.downloadContactsStatus.updateDownloadStatus(n);
        }
    }

    @Override
    public void updateViewSizes(int n, int n2, int n3, int n4, boolean bl) {
        AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(".updateViewSizes( allPhone = ").append(n).append(", naviPhone = ").append(n2).append(", navi = ").append(n3).append(", online = ").append(n4).append(", isValid = ").append(bl).toString());
        if (bl) {
            int n5 = n2 + n3 + n4;
            this.downloadContactsStatus.updateImportStatus(n, n5);
        }
    }

    @Override
    public void register(LastDestinationListener lastDestinationListener) {
        this.lastDestinationChangedListeners.add(lastDestinationListener);
        try {
            this.updateLastDestinations(this.navigationMemoryService.getLastDestinations());
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", error updating last used destination: ").append(navigationServiceException.getMessage()).toString());
        }
    }

    @Override
    public void register(ContactsDownloadStatusListener contactsDownloadStatusListener) {
        this.downloadContactsStatus.register(contactsDownloadStatusListener);
        contactsDownloadStatusListener.onDownloadStatus(this.downloadContactsStatus.getStatus());
        this.downloadContactsStatus.updateImportStatus();
    }
}

