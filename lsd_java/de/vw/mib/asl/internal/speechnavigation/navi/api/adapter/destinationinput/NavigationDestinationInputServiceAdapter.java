/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.locationinput.IHnrFlags;
import de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputService;
import de.vw.mib.asl.api.navigation.memory.INavigationContactAddress;
import de.vw.mib.asl.api.speechengine.vde.Capabilities;
import de.vw.mib.asl.api.speechengine.vde.VoiceDestinationEntryCallback;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.common.SpeechServices;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.AddressService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.DestinationInputService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapter$1;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapter$2;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapter$3;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapter$4;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapterBase;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapterBase$InitializeLocationCallerLock;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapterBase$ResolveAddressCallerLock;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapterBase$SelectEntryByIndexCaller;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapterBase$SelectInputTypeCallerLock;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapterBase$SetInputByValueCaller;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.CapabilitiesStartUpListener;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.CurrentLocationListener;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.GetValuePartMatchesListener;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.GetValuePartMatchesListener$HouseNumberListInfo;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.ResolveAddressListener;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.LastDestinationService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.NavigationMemoryServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariant;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariantImpl;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.model.HouseNumber;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.util.StringBuilder;
import java.util.Iterator;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationDestinationInputServiceAdapter
extends NavigationDestinationInputServiceAdapterBase
implements DestinationInputService,
AddressService {
    private static NavigationDestinationInputServiceAdapter instance = null;
    protected final NavigationLocationinputService destinationInputService = ASLNavigationFactory.getNavigationApi().getNavigationLocationinputService(this);
    protected final NavigationDestinationInputServiceAdapterBase$SelectInputTypeCallerLock selectInputTypeCaller = new NavigationDestinationInputServiceAdapterBase$SelectInputTypeCallerLock(this, this.destinationInputService);
    protected final NavigationDestinationInputServiceAdapterBase$SelectEntryByIndexCaller selectEntryByIndexCaller = new NavigationDestinationInputServiceAdapterBase$SelectEntryByIndexCaller(this, this.destinationInputService);
    protected final NavigationDestinationInputServiceAdapterBase$SetInputByValueCaller setInputByValueCaller = new NavigationDestinationInputServiceAdapterBase$SetInputByValueCaller(this, this.destinationInputService);
    protected final NavigationDestinationInputServiceAdapterBase$InitializeLocationCallerLock initLocationCaller = new NavigationDestinationInputServiceAdapterBase$InitializeLocationCallerLock(this, this.destinationInputService);
    protected final NavigationDestinationInputServiceAdapterBase$ResolveAddressCallerLock resolveAddressCaller = new NavigationDestinationInputServiceAdapterBase$ResolveAddressCallerLock(this, this.destinationInputService);
    protected INavigationLocation currentLocation;
    protected Capabilities speechCapabilities;
    private final LastDestinationService lastDestinationsService = NavigationMemoryServiceAdapter.getLastDestinationService();
    private final ObjectArrayList currentLocationListeners = new ObjectArrayList(2);
    private boolean isCountryAvailable = false;
    private boolean isCountryStateAvailable = false;
    private boolean isCityAvailable = false;
    private boolean isZipAvailable = false;
    private boolean isStreetAvailable = false;
    private boolean isStreetDisambiguationAvailable = false;
    private boolean isCrossingAvailable = false;
    private boolean isAnyHouseNumberAvailable = false;
    private boolean isPrefectureAvailable = false;
    private boolean isMunicipalityAvailable = false;
    private boolean isWardAvailable = false;
    private boolean isPlaceAvailable = false;
    private boolean isChomeAvailable = false;
    private boolean isHouseNumberBySds = false;
    private final ApplicationVariant variantService;
    private ObjectArrayList capabilitiesStartUpListener = new ObjectArrayList(2);
    private boolean onStartup = true;

    private NavigationDestinationInputServiceAdapter() {
        this.variantService = new ApplicationVariantImpl();
        this.destinationInputService.requestStartupState(this);
    }

    private static NavigationDestinationInputServiceAdapter getInstance() {
        if (instance == null) {
            instance = new NavigationDestinationInputServiceAdapter();
        }
        return instance;
    }

    public static DestinationInputService getService() {
        return NavigationDestinationInputServiceAdapter.getInstance();
    }

    public static AddressService getAddressService() {
        return NavigationDestinationInputServiceAdapter.getInstance();
    }

    @Override
    public void release() {
        AppLogger.trace(this, ".release(), on app - idle.");
        try {
            if (this.selectEntryByIndexCaller.isAcquired()) {
                this.selectEntryByIndexCaller.releaseOnIdle();
            }
            if (this.setInputByValueCaller.isAcquired()) {
                this.setInputByValueCaller.releaseOnIdle();
            }
            if (this.selectInputTypeCaller.isAcquired()) {
                this.selectInputTypeCaller.releaseOnIdle();
            }
            if (this.initLocationCaller.isAcquired()) {
                this.initLocationCaller.releaseOnIdle();
            }
            if (this.resolveAddressCaller.isAcquired()) {
                this.resolveAddressCaller.releaseOnIdle();
            }
            if (this.isServiceAquired()) {
                this.destinationInputService.unlockInput();
            }
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.info(this, new StringBuffer().append(".release(), error releasing the NAVI interface: ").append(navigationServiceException.getMessage()).toString());
        }
    }

    @Override
    public void resolveAddress(ResolveAddressListener resolveAddressListener, INavigationContactAddress iNavigationContactAddress) {
        this.resolveAddressCaller.acquire(resolveAddressListener, iNavigationContactAddress);
    }

    public void onResolveAddressGranted() {
        AppLogger.trace(this, new StringBuffer().append(".onResolveAddressGranted( address = ").append(this.resolveAddressCaller.getAddress()).append(" ) ").toString());
        try {
            this.destinationInputService.resolveContact(this.resolveAddressCaller.getAddress(), null);
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.trace(this, new StringBuffer().append(".onResolveAddressGranted( address = ").append(this.resolveAddressCaller.getAddress()).append(" ), failed with: ").append(navigationServiceException.getMessage()).toString());
            this.resolveAddressCaller.release(null);
        }
    }

    @Override
    public void resolveContactResult(INavigationLocation[] iNavigationLocationArray, Object object) {
        if (this.resolveAddressCaller.isAcquired()) {
            AppLogger.trace(this, ".resolveContactResult( locations = .. ) ");
            this.resolveAddressCaller.release(iNavigationLocationArray);
        } else {
            AppLogger.warn(this, ".resolveContactResult(..), ignored as no listener has been aquired.");
        }
    }

    @Override
    public void initializeDestinationInput(DestinationInputListener destinationInputListener) {
        this.initLocationCaller.acquire(destinationInputListener);
    }

    private void onInitializeLocationGranted(DestinationInputListener destinationInputListener) {
        AppLogger.trace(this, ".onInitializeLocationGranted(..)");
        this.lastDestinationsService.getLastUsedDestination(new NavigationDestinationInputServiceAdapter$1(this, destinationInputListener));
    }

    @Override
    public void selectCountryInput(DestinationInputListener destinationInputListener) {
        this.selectInputTypeCaller.acquire(destinationInputListener, 1);
    }

    @Override
    public void setCountry(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
        this.selectEntryByIndexCaller.acquire(destinationInputListener, viewModelItem, 1);
    }

    @Override
    public void selectCityInput(DestinationInputListener destinationInputListener) {
        this.selectInputTypeCaller.acquire(destinationInputListener, 2);
    }

    @Override
    public void setCity(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
        this.selectEntryByIndexCaller.acquire(destinationInputListener, viewModelItem, 2);
    }

    public void selectCityLPInput(DestinationInputListener destinationInputListener) {
        this.selectInputTypeCaller.acquire(destinationInputListener, 133);
    }

    public void setCityLP(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
        this.selectEntryByIndexCaller.acquire(destinationInputListener, viewModelItem, 133);
    }

    @Override
    public void selectPostalCodeInput(DestinationInputListener destinationInputListener) {
        this.selectInputTypeCaller.acquire(destinationInputListener, 6);
    }

    @Override
    public void setPostalCode(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
        this.selectEntryByIndexCaller.acquire(destinationInputListener, viewModelItem, 6);
    }

    @Override
    public void selectStreetInput(DestinationInputListener destinationInputListener) {
        this.selectInputTypeCaller.acquire(destinationInputListener, 3);
    }

    @Override
    public void setStreet(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
        this.selectEntryByIndexCaller.acquire(destinationInputListener, viewModelItem, 3);
    }

    public void selectStreetDisambiguationInput(DestinationInputListener destinationInputListener) {
        this.selectInputTypeCaller.acquire(destinationInputListener, 127);
    }

    public void setStreetDisambiguation(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
        this.selectEntryByIndexCaller.acquire(destinationInputListener, viewModelItem, 127);
    }

    @Override
    public void selectCrossingInput(DestinationInputListener destinationInputListener) {
        this.selectInputTypeCaller.acquire(destinationInputListener, 4);
    }

    @Override
    public void setCrossing(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
        this.selectEntryByIndexCaller.acquire(destinationInputListener, viewModelItem, 4);
    }

    @Override
    public void selectStateInput(DestinationInputListener destinationInputListener) {
        this.selectInputTypeCaller.acquire(destinationInputListener, 138);
    }

    @Override
    public void setState(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
        this.selectEntryByIndexCaller.acquire(destinationInputListener, viewModelItem, 138);
    }

    @Override
    public void selectHouseNumberInput(DestinationInputListener destinationInputListener) {
        this.selectInputTypeCaller.acquire(destinationInputListener, this.getHouseNumberType());
    }

    @Override
    public void setHouseNumber(DestinationInputListener destinationInputListener, HouseNumber houseNumber) {
        this.selectEntryByIndexCaller.acquire(destinationInputListener, houseNumber, this.getHouseNumberType());
    }

    @Override
    public void setHouseNumberLike(GetValuePartMatchesListener getValuePartMatchesListener, String string) {
        this.setInputByValueCaller.acquire(getValuePartMatchesListener, string, this.getHouseNumberType());
    }

    private void onSetHouseNumberLikeGranted(GetValuePartMatchesListener getValuePartMatchesListener) {
        try {
            this.destinationInputService.setInput(this.setInputByValueCaller.getPartId());
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(this, new StringBuffer().append(".onGetHouseNumberMatchesGranted(..), setInput failed for part id [").append(this.setInputByValueCaller.getPartId()).append("]: ").append(navigationServiceException.getMessage()).toString());
            this.setInputByValueCaller.release(1);
        }
    }

    @Override
    public void selectPrefectureInput(DestinationInputListener destinationInputListener) {
        this.selectInputTypeCaller.acquire(destinationInputListener, 138);
    }

    @Override
    public void setPrefecture(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
        this.selectEntryByIndexCaller.acquire(destinationInputListener, viewModelItem, 138);
    }

    @Override
    public void selectMunicipalityInput(DestinationInputListener destinationInputListener) {
        this.selectInputTypeCaller.acquire(destinationInputListener, 2);
    }

    @Override
    public void setMunicipality(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
        this.selectEntryByIndexCaller.acquire(destinationInputListener, viewModelItem, 2);
    }

    @Override
    public void selectWardInput(DestinationInputListener destinationInputListener) {
        this.selectInputTypeCaller.acquire(destinationInputListener, 152);
    }

    @Override
    public void setWard(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
        this.selectEntryByIndexCaller.acquire(destinationInputListener, viewModelItem, 152);
    }

    @Override
    public void selectPlaceInput(DestinationInputListener destinationInputListener) {
        this.selectInputTypeCaller.acquire(destinationInputListener, 147);
    }

    @Override
    public void setPlace(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
        this.selectEntryByIndexCaller.acquire(destinationInputListener, viewModelItem, 147);
    }

    @Override
    public void selectChomeInput(DestinationInputListener destinationInputListener) {
        this.selectInputTypeCaller.acquire(destinationInputListener, 144);
    }

    @Override
    public void setChome(DestinationInputListener destinationInputListener, ViewModelItem viewModelItem) {
        this.selectEntryByIndexCaller.acquire(destinationInputListener, viewModelItem, 144);
    }

    private void onSelectInputTypeGranted(DestinationInputListener destinationInputListener) {
        AppLogger.trace(this, new StringBuffer().append(".onSelectInputTypeGranted( type = ").append(this.selectInputTypeCaller.getInputType()).append(" )").toString());
        try {
            this.destinationInputService.startInput(this.selectInputTypeCaller.getInputType());
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.trace(this, new StringBuffer().append(".onSelectInputTypeGranted( type = ").append(this.selectInputTypeCaller.getInputType()).append(" ), failed with: ").append(navigationServiceException.getMessage()).toString());
            this.selectInputTypeCaller.release(1);
        }
    }

    private void onSelectInputValueByIndexGranted(DestinationInputListener destinationInputListener) {
        AppLogger.trace(this, new StringBuffer().append(".onSelectInputValueByIndexGranted( type = ").append(this.selectEntryByIndexCaller.getInputType()).append(", value = ").append(this.selectEntryByIndexCaller.getPartId()).append(" ) ").toString());
        try {
            switch (this.selectEntryByIndexCaller.getInputType()) {
                case 5: 
                case 136: {
                    if (this.variantService.isJPNVariant()) {
                        if (!this.selectEntryByIndexCaller.getPartId().isObjectIdValid()) {
                            this.handleSetHouseNumber();
                            break;
                        }
                        this.handleSetXXX();
                        break;
                    }
                    this.handleSetHouseNumber();
                    break;
                }
                default: {
                    this.handleSetXXX();
                    break;
                }
            }
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(this, new StringBuffer().append(".onSelectInputValueByIndexGranted( type = ").append(this.selectEntryByIndexCaller.getInputType()).append(", value = ").append(this.selectEntryByIndexCaller.getPartId()).append(" ), failed with: ").append(navigationServiceException.getMessage()).toString());
            this.selectEntryByIndexCaller.release(1);
        }
    }

    private void onSetInputValueByValueGranted(GetValuePartMatchesListener getValuePartMatchesListener) {
        AppLogger.trace(this, new StringBuffer().append(".onSetInputValueByValueGranted( type = ").append(this.setInputByValueCaller.getType()).append(", value = ").append(this.setInputByValueCaller.getPartId()).append(" ) ").toString());
        switch (this.setInputByValueCaller.getType()) {
            case 5: 
            case 136: {
                this.onSetHouseNumberLikeGranted(this.setInputByValueCaller.getListener());
                break;
            }
            default: {
                AppLogger.warn(this, new StringBuffer().append(".onSetInputValueByValueGranted( type = ").append(this.setInputByValueCaller.getType()).append(", value = ").append(this.setInputByValueCaller.getPartId()).append(" ) ").append("is not handled").toString());
            }
        }
    }

    @Override
    public void updateLock(boolean bl) {
        AppLogger.info(this, new StringBuffer().append(".updateLock( haveLock = ").append(bl).append(" )").toString());
        if (this.initLocationCaller.isAcquired()) {
            if (!bl) {
                this.initLocationCaller.releaseOnLockLost();
                return;
            }
            this.onInitializeLocationGranted(this.initLocationCaller.getListener());
        } else if (this.selectInputTypeCaller.isAcquired()) {
            if (!bl) {
                this.selectInputTypeCaller.releaseOnLockLost();
                return;
            }
            this.onSelectInputTypeGranted(this.selectInputTypeCaller.getListener());
        } else if (this.selectEntryByIndexCaller.isAcquired()) {
            if (!bl) {
                this.selectEntryByIndexCaller.releaseOnLockLost();
                return;
            }
            this.onSelectInputValueByIndexGranted(this.selectEntryByIndexCaller.getListener());
        } else if (this.setInputByValueCaller.isAcquired()) {
            if (!bl) {
                this.setInputByValueCaller.releaseOnLockLost();
                return;
            }
            this.onSetInputValueByValueGranted(this.setInputByValueCaller.getListener());
        } else if (this.resolveAddressCaller.isAcquired()) {
            if (!bl) {
                this.resolveAddressCaller.release(null);
                return;
            }
            this.onResolveAddressGranted();
        }
    }

    @Override
    public void valueListBlock(INavigationListElement[] iNavigationListElementArray, int n, IHnrFlags iHnrFlags) {
        AppLogger.trace(this, new StringBuffer().append(".valueListBlock( items = ").append(iNavigationListElementArray.length).append(", totalAvailableItems = ").append(n).append(" )").toString());
        if (this.setInputByValueCaller.isAcquired()) {
            AppLogger.trace(this, new StringBuffer().append(".valueListBlock(), call setInputCaller by [recognizedString] for [type = ").append(this.setInputByValueCaller.getType()).append(", value = ").append(this.setInputByValueCaller.getPartId()).append("]").toString());
            if (iHnrFlags != null) {
                this.houseNumberOptions = iHnrFlags;
            }
            this.setInputByValueCaller.release(0, new GetValuePartMatchesListener$HouseNumberListInfo(iNavigationListElementArray, n, iHnrFlags));
        } else if (this.selectEntryByIndexCaller.isAcquired()) {
            switch (this.selectEntryByIndexCaller.getInputType()) {
                case 5: 
                case 136: {
                    AppLogger.warn(this, ".valueListBlock(..), .selectEntry() for house types is delegated to .handleSetHouseNumber()");
                    break;
                }
                default: {
                    try {
                        AppLogger.trace(this, new StringBuffer().append(".valueListBlock(..), call selectEntry( 0 ) for [type = ").append(this.selectEntryByIndexCaller.getInputType()).append(", value = ").append(this.selectEntryByIndexCaller.getPartId()).append("]").toString());
                        this.destinationInputService.selectEntry(0);
                        break;
                    }
                    catch (NavigationServiceException navigationServiceException) {
                        AppLogger.error(this, new StringBuffer().append(".valueListBlock(..), call selectEntry( 0 ) for [type = ").append(this.selectEntryByIndexCaller.getInputType()).append(", value = ").append(this.selectEntryByIndexCaller.getPartId()).append("], failed with: ").append(navigationServiceException.getMessage()).toString());
                        this.selectEntryByIndexCaller.release(1);
                    }
                }
            }
        }
    }

    protected boolean isLocationValid(INavigationLocation iNavigationLocation) {
        if (iNavigationLocation == null) {
            AppLogger.warn(this, ", SDS ends because current navi location is invalid [null]");
            return false;
        }
        if (StringUtil.isEmpty(iNavigationLocation.getCountry()) || StringUtil.isEmpty(iNavigationLocation.getCountryAbbreviation())) {
            AppLogger.warn(this, ", SDS ends because current navi location is invalid ['country' and/or 'country abbreviation' not set/empty]");
            return false;
        }
        return true;
    }

    @Override
    public void updateInputState(int n, INavigationLocation iNavigationLocation, boolean bl, int[] nArray, boolean bl2, boolean bl3) {
        if (AppLogger.isLoggingEnabled()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(".updateInputState( ").append("activeField = ").append(n).append(", ").append("inputActive = ").append(bl).append(", ").append("inputLocation = ").append(iNavigationLocation).append(" );");
            AppLogger.trace(this, stringBuilder.toString());
        }
        this.updateNextPossibleFields(nArray, bl2, bl3);
        this.hasPointLocations = bl3;
        this.currentLocation = iNavigationLocation;
        if (this.initLocationCaller.isAcquired()) {
            if (!this.isLocationValid(iNavigationLocation)) {
                this.initLocationCaller.release(1, iNavigationLocation, nArray);
                return;
            }
            SpeechServices.getVDEDestinationService().requestCapabilities(iNavigationLocation.getCountryAbbreviation(), new NavigationDestinationInputServiceAdapter$2(this, iNavigationLocation, nArray));
        } else if (this.selectInputTypeCaller.isAcquired()) {
            this.selectInputTypeCaller.release(0, iNavigationLocation, nArray);
        } else if (this.selectEntryByIndexCaller.isAcquired()) {
            if (this.selectEntryByIndexCaller.getInputType() == 1 || this.selectEntryByIndexCaller.getInputType() == 138) {
                SpeechServices.getVDEDestinationService().requestCapabilities(iNavigationLocation.getCountryAbbreviation(), this.createVoiceDestinationEntryCallback(iNavigationLocation, nArray));
            } else {
                this.selectEntryByIndexCaller.release(0, iNavigationLocation, nArray);
            }
        } else if (this.onStartup) {
            try {
                this.destinationInputService.setCurrentLocation(this.destinationInputService.getCurrentLocation());
            }
            catch (NavigationServiceException navigationServiceException) {
                // empty catch block
            }
            this.onStartup = false;
            if (!this.isLocationValid(iNavigationLocation)) {
                if (AppLogger.isLoggingEnabled()) {
                    AppLogger.trace(this, "updateInputState on startup FAIL");
                }
                return;
            }
            SpeechServices.getVDEDestinationService().requestCapabilities(iNavigationLocation.getCountryAbbreviation(), new NavigationDestinationInputServiceAdapter$3(this, iNavigationLocation));
        }
    }

    private VoiceDestinationEntryCallback createVoiceDestinationEntryCallback(INavigationLocation iNavigationLocation, int[] nArray) {
        return new NavigationDestinationInputServiceAdapter$4(this, iNavigationLocation, nArray);
    }

    private void updateNextPossibleFields(int[] nArray, boolean bl, boolean bl2) {
        boolean bl3 = this.isCrossingAvailable;
        this.isCountryAvailable = false;
        this.isCountryStateAvailable = false;
        this.isCityAvailable = false;
        this.isZipAvailable = false;
        this.isStreetAvailable = false;
        this.isStreetDisambiguationAvailable = false;
        this.isCrossingAvailable = false;
        this.isAnyHouseNumberAvailable = false;
        this.isPrefectureAvailable = false;
        this.isMunicipalityAvailable = false;
        this.isWardAvailable = false;
        this.isPlaceAvailable = false;
        this.isChomeAvailable = false;
        this.setHouseNumberBySds(false);
        block19: for (int i2 = 0; i2 < nArray.length; ++i2) {
            switch (nArray[i2]) {
                case 1: {
                    this.isCountryAvailable = true;
                    break;
                }
                case 2: {
                    this.isCityAvailable = true;
                    break;
                }
                case 6: {
                    this.isZipAvailable = true;
                    break;
                }
                case 3: {
                    this.isStreetAvailable = true;
                    break;
                }
                case 127: {
                    this.isStreetDisambiguationAvailable = true;
                    break;
                }
                case 4: {
                    this.isCrossingAvailable = true;
                    break;
                }
                case 5: 
                case 136: {
                    this.isAnyHouseNumberAvailable = true;
                    if (bl2) {
                        this.houseNumberComputedFieldType = 5;
                        break;
                    }
                    this.houseNumberComputedFieldType = 136;
                    break;
                }
                case 138: {
                    this.isCountryStateAvailable = true;
                    break;
                }
            }
            if (!this.variantService.isJPNVariant()) continue;
            switch (nArray[i2]) {
                case 138: {
                    this.isPrefectureAvailable = true;
                    continue block19;
                }
                case 2: {
                    this.isMunicipalityAvailable = true;
                    continue block19;
                }
                case 152: {
                    this.isWardAvailable = true;
                    continue block19;
                }
                case 147: {
                    this.isPlaceAvailable = true;
                    continue block19;
                }
                case 144: {
                    this.isChomeAvailable = true;
                    continue block19;
                }
                case 154: {
                    continue block19;
                }
                case 5: 
                case 136: {
                    this.isAnyHouseNumberAvailable = true;
                    if (bl2) {
                        this.houseNumberComputedFieldType = 5;
                        continue block19;
                    }
                    this.houseNumberComputedFieldType = 136;
                    continue block19;
                }
            }
        }
        if (this.isCrossingAvailable != bl3) {
            Framework.updateUIValue(2047357952, this.isCrossingAvailable);
        }
        if (AppLogger.isLoggingEnabled()) {
            IntArrayList intArrayList = new IntArrayList(nArray.length);
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                intArrayList.add(nArray[i3]);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(".updateNextPossibleFields( ").append("nextSelectableFields = ").append(intArrayList.toString()).append(", ").append("isFullPostalCode = ").append(bl).append(", ").append("hasPointLocations = ").append(bl2).append(", ").append("houseNumberComputedFieldType = ").append(this.houseNumberComputedFieldType).append(" );");
            AppLogger.trace(this, stringBuilder.toString());
        }
    }

    private void setHouseNumberBySds(boolean bl) {
        this.isHouseNumberBySds = bl;
        Framework.updateUIValue(-1844956160, bl);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void handleSetHouseNumber() {
        HouseNumber houseNumber = (HouseNumber)this.selectEntryByIndexCaller.getPartId();
        if (!this.hasPointLocations) {
            if (this.houseNumberOptions.isHousenumberUnique()) {
                AppLogger.trace(this, ".handleSetHouseNumber(), set as [standard_hn_input, hn_unique], select 0");
                this.destinationInputService.selectEntry(0);
                return;
            }
            if (this.houseNumberOptions.isHousenumberAlternatives()) {
                AppLogger.trace(this, ".handleSetHouseNumber(), set as [standard_hn_input, hn_alt], select 0");
                this.destinationInputService.selectEntry(0);
                return;
            }
            if (this.houseNumberOptions.isHousenumberMatchesFound()) {
                AppLogger.error(this, ".handleSetHouseNumber(), set as [standard_hn_input, hn_multiple], incompatible combination");
                throw new NavigationServiceException(new StringBuffer().append(super.getClass().getName()).append(".handleSetHouseNumber(), set as [standard_hn_input, hn_multiple], incompatible combination").toString());
            }
            AppLogger.error(this, ".handleSetHouseNumber(), set as [standard_hn_input, hn_none]");
            throw new NavigationServiceException(new StringBuffer().append(super.getClass().getName()).append(".handleSetHouseNumber(), set as [standard_hn_input, hn_none], incompatible combination").toString());
        }
        if (this.houseNumberOptions.isHousenumberUnique()) {
            AppLogger.trace(this, ".handleSetHouseNumber(), set as [pointlocation_hn_input, hn_unique], select 0");
            this.destinationInputService.selectEntry(0);
            return;
        }
        if (this.houseNumberOptions.isHousenumberAlternatives()) {
            AppLogger.trace(this, ".handleSetHouseNumber(), set as [pointlocation_hn_input, hn_alt], select 0. Note that entered house number value has been replaced with an alternative from 'lastValueListBlock'");
            this.destinationInputService.selectEntry(0);
            return;
        }
        if (this.houseNumberOptions.isHousenumberMatchesFound()) {
            AppLogger.trace(this, ".handleSetHouseNumber(), set as [pointlocation_hn_input, hn_multiple], select x (user input)");
            this.destinationInputService.selectEntry(houseNumber.getIndex());
            return;
        }
        AppLogger.trace(this, ".handleSetHouseNumber(), set as [pointlocation_hn_input, hn_none], select -1");
        this.destinationInputService.selectEntry(-1);
    }

    private void handleSetXXX() {
        ViewModelItem viewModelItem = this.selectEntryByIndexCaller.getPartId();
        if (viewModelItem.isObjectIdValid()) {
            AppLogger.trace(this, new StringBuffer().append(".handleSetXXX(), call selectEntry by [objectStringId] for [type = ").append(this.selectEntryByIndexCaller.getInputType()).append(", value = ").append(viewModelItem.objectId).append("]").toString());
            this.destinationInputService.selectEntry(viewModelItem.objectId);
        } else {
            AppLogger.trace(this, new StringBuffer().append(".handleSetXXX(), call setInput by [recognizedString] for [type = ").append(this.selectEntryByIndexCaller.getInputType()).append(", value = ").append(viewModelItem.recognizedString).append("]").toString());
            this.destinationInputService.setInput(viewModelItem.recognizedString);
        }
    }

    @Override
    public boolean isCountrySelected() {
        return this.currentLocation.getCountry() != null && this.currentLocation.getCountry().length() > 0;
    }

    @Override
    public boolean isCountryStateSelected() {
        return this.currentLocation.getState() != null && this.currentLocation.getState().length() > 0;
    }

    @Override
    public boolean isCitySelected() {
        return this.currentLocation.getTown() != null && this.currentLocation.getTown().length() > 0;
    }

    @Override
    public boolean isStreetSelected() {
        return this.currentLocation.getStreet() != null && this.currentLocation.getStreet().length() > 0;
    }

    @Override
    public boolean isHousenumberSelected() {
        return this.currentLocation.getHousenumber() != null && this.currentLocation.getHousenumber().length() > 0;
    }

    @Override
    public boolean isPrefectureSelected() {
        return this.currentLocation.getPrefecture() != null && this.currentLocation.getPrefecture().length() > 0;
    }

    @Override
    public boolean isMunicipalitySelected() {
        return this.currentLocation.getMunicipality() != null && this.currentLocation.getMunicipality().length() > 0;
    }

    @Override
    public boolean isWardSelected() {
        return this.currentLocation.getWard() != null && this.currentLocation.getWard().length() > 0;
    }

    @Override
    public boolean isPlaceSelected() {
        return this.currentLocation.getPlace() != null && this.currentLocation.getPlace().length() > 0;
    }

    @Override
    public boolean isChomeSelected() {
        return this.currentLocation.getChome() != null && this.currentLocation.getChome().length() > 0;
    }

    void updateCountryChanged(INavigationLocation iNavigationLocation, Capabilities capabilities) {
        Iterator iterator = this.currentLocationListeners.iterator();
        while (iterator.hasNext()) {
            CurrentLocationListener currentLocationListener = (CurrentLocationListener)iterator.next();
            if (currentLocationListener == null) continue;
            currentLocationListener.onCountryChanged(iNavigationLocation, capabilities);
        }
    }

    @Override
    public void requestCountryIcon(INavigationLocation iNavigationLocation) {
        try {
            if (!StringUtil.isEmpty(iNavigationLocation.getCountry())) {
                this.destinationInputService.requestCountryIcon(iNavigationLocation);
            }
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(this, new StringBuffer().append(".requestCountryIcon(..) failed: ").append(navigationServiceException.getMessage()).toString());
        }
    }

    @Override
    public void updateCountryIcon(INavigationLocation iNavigationLocation, ResourceLocator resourceLocator) {
        Iterator iterator = this.currentLocationListeners.iterator();
        while (iterator.hasNext()) {
            CurrentLocationListener currentLocationListener = (CurrentLocationListener)iterator.next();
            if (currentLocationListener == null) continue;
            currentLocationListener.onCountryFlagChanged(iNavigationLocation, resourceLocator);
        }
    }

    @Override
    public void registerOnStartUpCapabilities(CapabilitiesStartUpListener capabilitiesStartUpListener) {
        this.capabilitiesStartUpListener.add(capabilitiesStartUpListener);
    }

    @Override
    public void unregisterOnStartUpCapabilities(CapabilitiesStartUpListener capabilitiesStartUpListener) {
        this.capabilitiesStartUpListener.removeValue(capabilitiesStartUpListener);
    }

    private void updateStartupCapabilitiesRetrieved() {
        Iterator iterator = this.capabilitiesStartUpListener.iterator();
        while (iterator.hasNext()) {
            CapabilitiesStartUpListener capabilitiesStartUpListener = (CapabilitiesStartUpListener)iterator.next();
            if (capabilitiesStartUpListener == null) continue;
            capabilitiesStartUpListener.onStartUpCapabilitiesRetrieved();
        }
    }

    @Override
    public void registerOnCountryChanges(CurrentLocationListener currentLocationListener) {
        this.currentLocationListeners.add(currentLocationListener);
    }

    @Override
    public void unregisterOnCountryChanges(CurrentLocationListener currentLocationListener) {
        this.currentLocationListeners.removeValue(currentLocationListener);
    }

    @Override
    public Capabilities getCurrentInputSpeechCapabilities() {
        return this.speechCapabilities;
    }

    @Override
    public INavigationLocation getCurrentInput() {
        return this.currentLocation;
    }

    @Override
    public boolean isCountryAvailable() {
        return this.isCountryAvailable;
    }

    @Override
    public boolean isCityAvailable() {
        return this.isCityAvailable;
    }

    @Override
    public boolean isZipAvailable() {
        return this.isZipAvailable;
    }

    @Override
    public boolean isStreetAvailable() {
        return this.isStreetAvailable;
    }

    @Override
    public boolean isStreetDisambiguationAvailable() {
        return this.isStreetDisambiguationAvailable;
    }

    @Override
    public boolean isHouseNumberAvailable() {
        return this.isAnyHouseNumberAvailable;
    }

    @Override
    public boolean arePointLocationHouseNumbersAvailable() {
        return this.hasPointLocations;
    }

    @Override
    public boolean isCrossingAvailable() {
        return this.isCrossingAvailable;
    }

    @Override
    public boolean isCountryStateAvailable() {
        return this.isCountryStateAvailable;
    }

    @Override
    public boolean isPrefectureAvailable() {
        return this.isPrefectureAvailable;
    }

    @Override
    public boolean isMunicipalityAvailable() {
        return this.isMunicipalityAvailable;
    }

    @Override
    public boolean isWardAvailable() {
        return this.isWardAvailable;
    }

    @Override
    public boolean isPlaceAvailable() {
        return this.isPlaceAvailable;
    }

    @Override
    public boolean isChomeAvailable() {
        return this.isChomeAvailable;
    }

    @Override
    public boolean isHouseNumberBySds() {
        return this.isHouseNumberBySds;
    }

    private boolean isServiceAquired() {
        return this.selectEntryByIndexCaller.isAcquired() || this.setInputByValueCaller.isAcquired() || this.selectInputTypeCaller.isAcquired() || this.initLocationCaller.isAcquired() || this.resolveAddressCaller.isAcquired();
    }

    private int getHouseNumberType() {
        return this.houseNumberComputedFieldType;
    }

    boolean checkLanguageDestinationCountryMatchesSystemLanguage(String[] stringArray, String string) {
        boolean bl = false;
        if (string != null && stringArray != null) {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                if (stringArray[i2] == null || !stringArray[i2].equals(string)) continue;
                bl = true;
                break;
            }
        }
        return bl;
    }

    static /* synthetic */ void access$000(NavigationDestinationInputServiceAdapter navigationDestinationInputServiceAdapter) {
        navigationDestinationInputServiceAdapter.updateStartupCapabilitiesRetrieved();
    }
}

