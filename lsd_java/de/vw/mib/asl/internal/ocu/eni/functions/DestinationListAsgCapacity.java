/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.functions;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.ASLNavigationServices;
import de.vw.mib.asl.api.navigation.ASLNavigationServicesListener;
import de.vw.mib.asl.internal.ocu.eni.functions.ENIFunction;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.DestinationList_ASGcapacity_SetGet;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.DestinationList_ASGcapacity_Status;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;

public final class DestinationListAsgCapacity
extends ENIFunction
implements PropertyListener,
ASLNavigationServicesListener {
    private ASLNavigationServices _navigationOnlineServices;
    private boolean _fsgNewCapacityRequested;
    private static final int UNKNOWN_CONTACT_CAPACITY;
    private int _contactCapacity = -1;
    private int _asgCapacity;
    private boolean _navigationServiceAvailable;

    private ASLNavigationServices getNavigationOnlineServices() {
        if (this._navigationOnlineServices == null) {
            this._navigationOnlineServices = ASLNavigationFactory.getNavigationApi().getASLNavigationServices(this);
        }
        return this._navigationOnlineServices;
    }

    private boolean isFsgNewCapacityRequested() {
        return this._fsgNewCapacityRequested;
    }

    private void setFsgNewCapacityRequested(boolean bl) {
        this._fsgNewCapacityRequested = bl;
    }

    private int getContactCapacity() {
        return this._contactCapacity;
    }

    private void setContactCapacity(int n) {
        this._contactCapacity = n;
    }

    private int getAsgCapacity() {
        return this._asgCapacity;
    }

    private void setAsgCapacity(int n) {
        this._asgCapacity = n;
    }

    private boolean isNavigationServiceAvailable() {
        return this._navigationServiceAvailable;
    }

    private void setNavigationServiceAvailable(boolean bl) {
        this._navigationServiceAvailable = bl;
    }

    @Override
    public void initialize(boolean bl) {
        if (bl) {
            this.setFsgNewCapacityRequested(false);
            this.getDelegate().getProperty(this).getProperty(null, this);
        }
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public int getFunctionId() {
        return 17;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
        this.setFsgNewCapacityRequested(false);
    }

    @Override
    public boolean statusProperty(BAPEntity bAPEntity, Property property) {
        DestinationList_ASGcapacity_Status destinationList_ASGcapacity_Status = (DestinationList_ASGcapacity_Status)bAPEntity;
        this.setAsgCapacity(destinationList_ASGcapacity_Status.asgcapacity);
        int n = this.getNavigationOnlineServices().getContactCapacity();
        if (n >= 0 && this.isNavigationServiceAvailable() && this.getAsgCapacity() != n && !this.isFsgNewCapacityRequested()) {
            this._setNewEniCapacity(n);
        } else {
            this.setFsgNewCapacityRequested(false);
        }
        return true;
    }

    @Override
    public boolean statusAckProperty(BAPEntity bAPEntity, Property property) {
        return false;
    }

    @Override
    public void importContactResult(int n) {
    }

    @Override
    public void updateContactCapacity(int n) {
        this.setContactCapacity(n);
        if (n >= 0 && this.getAsgCapacity() != n && this.isNavigationServiceAvailable()) {
            this._setNewEniCapacity(n);
        }
    }

    @Override
    public void updateGuidanceActive(boolean bl) {
    }

    @Override
    public void updateServiceAvailable(boolean bl) {
        if (this.isNavigationServiceAvailable() != bl) {
            this.setNavigationServiceAvailable(bl);
            if (bl) {
                this.updateContactCapacity(this.getContactCapacity());
            }
        }
    }

    private void _setNewEniCapacity(int n) {
        DestinationList_ASGcapacity_SetGet destinationList_ASGcapacity_SetGet = new DestinationList_ASGcapacity_SetGet();
        destinationList_ASGcapacity_SetGet.asgcapacity = n;
        this.getDelegate().getProperty(this).setGetProperty(destinationList_ASGcapacity_SetGet, this);
        this.setFsgNewCapacityRequested(true);
    }
}

