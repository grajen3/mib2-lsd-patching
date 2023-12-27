/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager.api.impl;

import de.vw.mib.asl.framework.api.entertainmentmanager.ASLEntertainmentmanagerServiceIds;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentContext;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerResponder;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;

public final class EntertainmentManagerResponderImpl
implements EntertainmentManagerResponder,
ASLEntertainmentmanagerServiceIds {
    private final int context;
    private final int targetId;

    public EntertainmentManagerResponderImpl(int n, int n2) {
        this.context = n;
        this.targetId = n2;
    }

    @Override
    public void sendAnswerToEntertainmentManager(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.targetId, 272503040, n);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    private void sendAnswerToEntertainmentManager(int n, int n2) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.targetId, 272503040, n);
        eventGeneric.setInt(0, n2);
        eventGeneric.setInt(1, this.context);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void activated() {
        this.sendAnswerToEntertainmentManager(-1067707136);
    }

    @Override
    public void deactivated() {
        this.sendAnswerToEntertainmentManager(-1050929920);
    }

    @Override
    public void cancelled() {
        this.sendAnswerToEntertainmentManager(-1034152704);
    }

    @Override
    public void sourceAdded(int n) {
        this.sendAnswerToEntertainmentManager(-916712192, n);
    }

    @Override
    public void rqIndepedentBrowsing(int n) {
        this.sendAnswerToEntertainmentManager(-832826112, n);
    }

    @Override
    public void rqBtnDn(int n) {
        this.sendAnswerToEntertainmentManager(-782494464, n);
    }

    @Override
    public void rqBtnUp(int n) {
        this.sendAnswerToEntertainmentManager(-765717248, n);
    }

    @Override
    public void emptyDnUpQueue() {
        this.sendAnswerToEntertainmentManager(-748940032);
    }

    @Override
    public void register(int n, boolean bl, int n2) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.targetId, 272503040, -899934976);
        eventGeneric.setInt(0, this.context);
        eventGeneric.setInt(1, n);
        eventGeneric.setBoolean(2, bl);
        eventGeneric.setInt(3, n2);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void register2(int n, boolean bl, int n2) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.targetId, 272503040, -816048896);
        eventGeneric.setInt(0, this.context);
        eventGeneric.setInt(1, n);
        eventGeneric.setBoolean(2, bl);
        eventGeneric.setInt(3, n2);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void register(EntertainmentContext entertainmentContext) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.targetId, 272503040, -681831168);
        eventGeneric.setObject(0, entertainmentContext);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void deregister() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.targetId, 272503040, -883157760);
        eventGeneric.setSenderTargetId(this.targetId);
        eventGeneric.setInt(0, this.context);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void exBoxRequest(int n) {
        this.sendAnswerToEntertainmentManager(-866380544, n);
    }

    @Override
    public void weakRequest(int n) {
        this.sendAnswerToEntertainmentManager(-732162816, n);
    }
}

