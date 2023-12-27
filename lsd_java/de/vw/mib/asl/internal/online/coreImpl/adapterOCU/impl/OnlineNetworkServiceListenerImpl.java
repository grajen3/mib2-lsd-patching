/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.adapterOCU.impl;

import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkService;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceListenerAdapter;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkList;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceListEntry;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceStatus;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkSupportedServices;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkTrackingServices;
import de.vw.mib.asl.api.ocu.onlinev10.data.ServiceListSynchronisationState;
import de.vw.mib.asl.internal.online.coreImpl.adapterOCU.CoreServiceOCUFactory;
import de.vw.mib.asl.internal.online.coreImpl.adapterOCU.states.CoreServiceOCUTarget;

public class OnlineNetworkServiceListenerImpl
extends OnlineNetworkServiceListenerAdapter {
    private final String _classname = super.getClass().getName();
    private final CoreServiceOCUTarget _target;

    public OnlineNetworkServiceListenerImpl(CoreServiceOCUTarget coreServiceOCUTarget) {
        this._target = coreServiceOCUTarget;
    }

    @Override
    public void updateOnlineNetworkServiceStatus(OnlineNetworkService onlineNetworkService, OnlineNetworkServiceStatus onlineNetworkServiceStatus) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".updateOnlineNetworkServiceStatus( )").log();
        }
        CoreServiceOCUFactory.getController(this._target).updateServiceStatus(onlineNetworkService, onlineNetworkServiceStatus);
    }

    @Override
    public void updateOnlineNetworkSupportedServices(OnlineNetworkService onlineNetworkService, OnlineNetworkSupportedServices onlineNetworkSupportedServices) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".updateOnlineNetworkSupportedServices( )").log();
        }
        CoreServiceOCUFactory.getController(this._target).setServiceAvailability(onlineNetworkSupportedServices);
    }

    @Override
    public void updateOnlineNetworkUserList(OnlineNetworkService onlineNetworkService, OnlineNetworkList onlineNetworkList) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".updateOnlineNetworkUserList( )").log();
        }
        if (onlineNetworkList.getListState().value() != 2 && onlineNetworkList.getListState().value() != 1) {
            CoreServiceOCUFactory.getController(this._target).updateUserList(onlineNetworkList);
        } else {
            this._target.info().append(this._classname).append(".updateOnlineNetworkUserList( )--> not loaded state").log();
        }
    }

    @Override
    public void updateOnlineNetworkServiceList(OnlineNetworkService onlineNetworkService, OnlineNetworkList onlineNetworkList) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".updateOnlineNetworkServiceList( )").log();
        }
        if (onlineNetworkList.getListState().value() == 3) {
            CoreServiceOCUFactory.getController(this._target).updateServiceList(onlineNetworkList);
        } else {
            this._target.info().append(this._classname).append(".updateOnlineNetworkServiceList( )--> not loaded state").log();
        }
    }

    @Override
    public void updateOnlineNetworkTrackingServices(OnlineNetworkService onlineNetworkService, OnlineNetworkTrackingServices onlineNetworkTrackingServices) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".updateOnlineNetworkTrackingServices( )").log();
        }
        CoreServiceOCUFactory.getController(this._target).updateTrackingServices(onlineNetworkTrackingServices);
    }

    @Override
    public void updatePrivacyModeActive(OnlineNetworkService onlineNetworkService, boolean bl) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".updatePrivacyModeActive(").append(bl).append(")").toString()).log();
        }
        CoreServiceOCUFactory.getController(this._target).updatePrivacyMode(bl);
    }

    @Override
    public void updateServiceListSynchronisationState(OnlineNetworkService onlineNetworkService, ServiceListSynchronisationState serviceListSynchronisationState) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".updateServiceListSynchronisationState(").append(serviceListSynchronisationState.value()).append(")").toString()).log();
        }
        CoreServiceOCUFactory.getController(this._target).updateServiceListState(serviceListSynchronisationState.value());
    }

    @Override
    public void updateOnlineNetworkServiceSetBlocking(OnlineNetworkService onlineNetworkService, OnlineNetworkServiceListEntry onlineNetworkServiceListEntry) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".updateOnlineNetworkServiceSetBlocking(").append(onlineNetworkServiceListEntry.getServiceId()).append(")").toString()).log();
        }
        CoreServiceOCUFactory.getController(this._target).setServiceStateResponse(onlineNetworkServiceListEntry);
    }
}

