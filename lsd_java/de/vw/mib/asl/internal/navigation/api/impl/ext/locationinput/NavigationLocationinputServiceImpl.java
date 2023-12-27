/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.locationinput;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.locationinput.ASLNavigationLocationinputFactory;
import de.vw.mib.asl.api.navigation.locationinput.IHnrFlags;
import de.vw.mib.asl.api.navigation.locationinput.ILocationinputResultListener;
import de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputListener;
import de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputService;
import de.vw.mib.asl.api.navigation.memory.ASLNavigationMemoryFactory;
import de.vw.mib.asl.api.navigation.memory.INavigationContactAddress;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.INavigationLocationHelper;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavServiceLockable;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavigationListElementImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavigationLocationImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.NavigationExtServiceImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.locationinput.NavigationLocationinputServiceImpl$1;
import de.vw.mib.asl.internal.navigation.api.impl.ext.locationinput.NavigationLocationinputServiceImpl$2;
import de.vw.mib.asl.internal.navigation.api.impl.ext.locationinput.NavigationLocationinputServiceImpl$3;
import de.vw.mib.asl.internal.navigation.api.impl.ext.locationinput.NavigationLocationinputServiceImpl$4;
import de.vw.mib.asl.internal.navigation.api.impl.ext.locationinput.NavigationLocationinputServiceImpl$5;
import de.vw.mib.asl.internal.navigation.api.impl.ext.memory.INavigationContactAddressImpl;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStreamToNavLocation;
import de.vw.mib.asl.internal.navigation.util.WeakIdentityHashSet;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.TryBestMatchData;

public class NavigationLocationinputServiceImpl
implements NavigationLocationinputService,
INavServiceLockable {
    static IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "NavigationLocationinputServiceImpl");
    static WeakIdentityHashSet serviceInstances = new WeakIdentityHashSet();
    private static final int DEFAULT_TIMEOUT;
    NavigationLocationinputListener listener;
    NavigationExtServiceImpl navigationExtServiceImpl;
    private int activeFiled;
    String currentInput;
    static NavLocation currentLocation;
    static ILocationinputResultListener liResults;

    public NavigationLocationinputServiceImpl(NavigationLocationinputListener navigationLocationinputListener, NavigationExtServiceImpl navigationExtServiceImpl) {
        this.listener = navigationLocationinputListener;
        this.navigationExtServiceImpl = navigationExtServiceImpl;
        serviceInstances.add(this);
    }

    protected void notifySpecialFlags(IHnrFlags iHnrFlags) {
        if (this.listener != null) {
            this.listener.updateSpecialFlags(iHnrFlags);
        }
    }

    public void notifyValueList(LIValueList lIValueList, long l, IHnrFlags iHnrFlags) {
        if (this.listener != null) {
            INavigationListElement[] iNavigationListElementArray = new INavigationListElement[lIValueList != null && lIValueList.list != null ? lIValueList.list.length : 0];
            for (int i2 = 0; i2 < iNavigationListElementArray.length && lIValueList != null; ++i2) {
                iNavigationListElementArray[i2] = new INavigationListElementImpl(lIValueList.list[i2]);
            }
            this.listener.valueListBlock(iNavigationListElementArray, (int)l, iHnrFlags);
        }
    }

    public void notifyInputState(NavLocation navLocation, int[] nArray, boolean bl, boolean bl2, boolean bl3) {
        if (this.listener != null) {
            int[] nArray2 = new int[nArray.length];
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                nArray2[i2] = this.convertSelcritToField(nArray[i2]);
            }
            this.listener.updateInputState(this.activeFiled, new INavigationLocationImpl(navLocation), bl, nArray2, bl2, bl3);
        }
    }

    private int convertSelcritToField(int n) {
        return n;
    }

    private int convertFieldToSelcrit(int n) {
        return n;
    }

    @Override
    public void lockInput(int n) {
        this.lockInput();
    }

    @Override
    public void unlockInput() {
        this.navigationExtServiceImpl.releaseLocationinputLock(this);
    }

    @Override
    public INavigationLocation getCurrentLocation() {
        if (currentLocation == null) {
            return new INavigationLocationImpl(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper().getLocation());
        }
        return new INavigationLocationImpl(currentLocation);
    }

    @Override
    public void setCurrentLocation(INavigationLocation iNavigationLocation) {
        this.navigationExtServiceImpl.checkLockLocationInput(this);
        ASLNavigationLocationinputFactory.getNavigationLocationinputApi().setCurrentLocation(((INavigationLocationHelper)((Object)iNavigationLocation)).getRealLocation());
    }

    @Override
    public void startInput(int n) {
        this.navigationExtServiceImpl.checkLockLocationInput(this);
        this.activeFiled = n;
        this.currentInput = "";
        ASLNavigationLocationinputFactory.getNavigationLocationinputApi().startInput(n);
    }

    @Override
    public void setInput(String string) {
        this.navigationExtServiceImpl.checkLockLocationInput(this);
        this.currentInput = string;
        ASLNavigationLocationinputFactory.getNavigationLocationinputApi().setInput(this.activeFiled, string);
    }

    @Override
    public void getValueListBlock(int n) {
        throw new NavigationServiceException("not implemented");
    }

    @Override
    public void selectEntry(int n) {
        this.navigationExtServiceImpl.checkLockLocationInput(this);
        ASLNavigationLocationinputFactory.getNavigationLocationinputApi().selectEntryViaIndex(this.activeFiled, n);
    }

    @Override
    public void selectEntry(String string) {
        this.navigationExtServiceImpl.checkLockLocationInput(this);
        ASLNavigationLocationinputFactory.getNavigationLocationinputApi().selectEntryViaId(this.activeFiled, string);
    }

    @Override
    public void updateLock(boolean bl) {
        try {
            this.listener.updateLock(bl);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void lockInput() {
        this.navigationExtServiceImpl.acquireLocationinputLock(20000, this, false);
    }

    @Override
    public void weakLockInput() {
        this.navigationExtServiceImpl.acquireLocationinputLock(20000, this, true);
    }

    @Override
    public void lock() {
        this.navigationExtServiceImpl.acquireLocationinputLock(20000, this, false);
    }

    @Override
    public void weakLock() {
        this.navigationExtServiceImpl.acquireLocationinputLock(20000, this, true);
    }

    @Override
    public void unlock() {
        this.navigationExtServiceImpl.releaseLocationinputLock(this);
    }

    @Override
    public void resolveContact(INavigationContactAddress iNavigationContactAddress, Object object) {
        this.navigationExtServiceImpl.checkLockLocationInput(this);
        if (iNavigationContactAddress instanceof INavigationContactAddressImpl && ((INavigationContactAddressImpl)iNavigationContactAddress).realAddressData != null && ((INavigationContactAddressImpl)iNavigationContactAddress).realAddressData.navLocation != null && ((INavigationContactAddressImpl)iNavigationContactAddress).realAddressData.navLocation.length > 0) {
            new CmdStreamToNavLocation(new NavigationLocationinputServiceImpl$2(this, object), 0, ((INavigationContactAddressImpl)iNavigationContactAddress).realAddressData.navLocation).execute();
        } else {
            TryBestMatchData tryBestMatchData = new TryBestMatchData();
            tryBestMatchData.country = iNavigationContactAddress.getCountry() != null ? iNavigationContactAddress.getCountry() : "";
            tryBestMatchData.postalCode = iNavigationContactAddress.getPostalCode() != null ? iNavigationContactAddress.getPostalCode() : "";
            tryBestMatchData.locality = iNavigationContactAddress.getLocality() != null ? iNavigationContactAddress.getLocality() : "";
            tryBestMatchData.region = iNavigationContactAddress.getRegion() != null ? iNavigationContactAddress.getRegion() : "";
            tryBestMatchData.streedAndOrHouseNumber = iNavigationContactAddress.getStreet() != null ? iNavigationContactAddress.getStreet() : "";
            tryBestMatchData.unstructured = iNavigationContactAddress.getGeoPosition() != null ? iNavigationContactAddress.getGeoPosition() : "";
            ASLNavigationMemoryFactory.getNavigationMemoryApi().tryBestMatch(new NavigationLocationinputServiceImpl$3(this), tryBestMatchData, object);
        }
    }

    @Override
    public void freeService() {
        serviceInstances.remove(this);
    }

    @Override
    public void requestCountryIcon(INavigationLocation iNavigationLocation) {
        ILocationWrapper iLocationWrapper;
        if (iNavigationLocation != null && iNavigationLocation instanceof INavigationLocationImpl) {
            iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(((INavigationLocationImpl)iNavigationLocation).getRealLocation());
            if (iLocationWrapper.getCountry() == null || iLocationWrapper.getCountry().equals("")) {
                throw new NavigationServiceException("requestCountryIcon: Country null or empty");
            }
            if (iLocationWrapper.getCountryIconIndex() < 0) {
                throw new NavigationServiceException("requestCountryIcon: CountryIconIndex invalid");
            }
        } else {
            throw new NavigationServiceException("requestCountryIcon: NavigationLocation null or invalid type.");
        }
        Integer n = new Integer(-2000);
        ResourceLocator resourceLocator = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForCountryIcon(iLocationWrapper.getCountryIconIndex(), 1, new NavigationLocationinputServiceImpl$4(this, iNavigationLocation), n);
        this.listener.updateCountryIcon(iNavigationLocation, resourceLocator);
    }

    @Override
    public void requestStartupState(NavigationLocationinputListener navigationLocationinputListener) {
        ASLNavigationLocationinputFactory.getNavigationLocationinputApi().requestStartupState(new NavigationLocationinputServiceImpl$5(this, navigationLocationinputListener));
    }

    static {
        liResults = new NavigationLocationinputServiceImpl$1();
        ASLNavigationLocationinputFactory.getNavigationLocationinputApi().registerListener(liResults);
    }
}

