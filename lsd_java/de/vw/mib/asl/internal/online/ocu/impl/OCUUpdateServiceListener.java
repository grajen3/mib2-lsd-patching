/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.ocu.impl;

import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateService;
import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateServiceListenerAdapter;
import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateChallengeList;
import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateList;
import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateState;
import de.vw.mib.asl.internal.online.ocu.OCUUpdateServiceFactory;
import de.vw.mib.asl.internal.online.ocu.states.OCUUpdateServiceTarget;

public class OCUUpdateServiceListener
extends OnlineUpdateServiceListenerAdapter {
    private final String _classname = super.getClass().getName();
    private final OCUUpdateServiceTarget _target;

    public OCUUpdateServiceListener(OCUUpdateServiceTarget oCUUpdateServiceTarget) {
        this._target = oCUUpdateServiceTarget;
    }

    @Override
    public void updateOnlineUpdateState(OnlineUpdateService onlineUpdateService, OnlineUpdateState onlineUpdateState) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".updateOnlineUpdateState( )").log();
        }
        if (onlineUpdateService.getOnlineUpdateList().getListState().value() == 3) {
            OCUUpdateServiceFactory.getController(this._target).updateOCURemoteService(onlineUpdateService, onlineUpdateState, onlineUpdateService.getOnlineUpdateList());
        }
    }

    @Override
    public void updateOnlineUpdateList(OnlineUpdateService onlineUpdateService, OnlineUpdateList onlineUpdateList) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".updateOnlineUpdateList( )").log();
        }
        if (onlineUpdateList.getListState().value() == 3) {
            OCUUpdateServiceFactory.getController(this._target).updateOCURemoteService(onlineUpdateService, onlineUpdateService.getOnlineUpdateState(), onlineUpdateList);
        }
    }

    @Override
    public void updateOnlineUpdateChallengeList(OnlineUpdateService onlineUpdateService, OnlineUpdateChallengeList onlineUpdateChallengeList) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".updateOnlineUpdateChallengeList( )").log();
        }
        if (onlineUpdateChallengeList.getListState().value() == 3) {
            OCUUpdateServiceFactory.getController(this._target).updateChallengeData(onlineUpdateChallengeList);
        }
    }
}

