/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carplay.api.impl;

import de.vw.mib.asl.api.carplay.ASLCarplayServices;
import de.vw.mib.asl.api.carplay.ASLCarplayServicesCallState;
import de.vw.mib.asl.api.carplay.ASLCarplayServicesListener;
import de.vw.mib.asl.api.carplay.ASLCarplayServicesTelephonyState;
import de.vw.mib.asl.internal.carplay.api.impl.ASLCarplayServicesCallStateImpl;
import de.vw.mib.asl.internal.carplay.api.impl.ASLCarplayServicesTelephonyStateImpl;
import de.vw.mib.asl.internal.carplay.common.CarPlayGlobalProperies;
import de.vw.mib.asl.internal.carplay.target.HsmTarget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ASLCarplayServicesImpl
implements ASLCarplayServices {
    List listeners = new ArrayList();
    ASLCarplayServicesTelephonyStateImpl telephonyState = new ASLCarplayServicesTelephonyStateImpl();
    private HsmTarget target;
    CarPlayGlobalProperies properties;

    public void setGlobalProperties(CarPlayGlobalProperies carPlayGlobalProperies) {
        this.telephonyState.setGlobalProperties(carPlayGlobalProperies);
        this.properties = carPlayGlobalProperies;
        this.sendCarplayIsReadyUpdate();
    }

    public void setTarget(HsmTarget hsmTarget) {
        this.target = hsmTarget;
    }

    public void sendTelephonyStateUpdate() {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ASLCarplayServicesListener aSLCarplayServicesListener = (ASLCarplayServicesListener)iterator.next();
            aSLCarplayServicesListener.updateCarPlaTelefonyState(this.telephonyState);
        }
    }

    public void sendRouteGuidanceUpdate() {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ASLCarplayServicesListener aSLCarplayServicesListener = (ASLCarplayServicesListener)iterator.next();
            aSLCarplayServicesListener.updateCarPlayRouteGuidanceActive(this.properties.getActiveNavigation() == 2);
        }
    }

    public void sendCarplayActiveUpdate() {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ASLCarplayServicesListener aSLCarplayServicesListener = (ASLCarplayServicesListener)iterator.next();
            aSLCarplayServicesListener.updateCarPlayActive(this.properties.isConnected());
        }
    }

    public void sendCarplayIsReadyUpdate() {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ASLCarplayServicesListener aSLCarplayServicesListener = (ASLCarplayServicesListener)iterator.next();
            aSLCarplayServicesListener.updateCarPlayActive(this.properties != null);
        }
    }

    public void sendCallStatesUpdate() {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ASLCarplayServicesListener aSLCarplayServicesListener = (ASLCarplayServicesListener)iterator.next();
            aSLCarplayServicesListener.updateCarPlayCallStates(this.getCarPlayCallStates());
        }
    }

   // @Override
    public void sendCompleteUpdate() {
        this.sendCarplayIsReadyUpdate();
        this.sendCarplayActiveUpdate();
        this.sendRouteGuidanceUpdate();
        this.sendRouteGuidanceUpdate();
        this.sendCallStatesUpdate();
    }

   // @Override
    public void registerListener(ASLCarplayServicesListener aSLCarplayServicesListener) {
        this.listeners.add(aSLCarplayServicesListener);
    }

   // @Override
    public void unregisterListener(ASLCarplayServicesListener aSLCarplayServicesListener) {
        this.listeners.remove(aSLCarplayServicesListener);
    }

   // @Override
    public boolean isReady() {
        return this.properties != null;
    }

   // @Override
    public boolean isCarPlayActive() {
        return this.properties.isConnected();
    }

   // @Override
    public boolean isCarPlayRouteGuidanceActive() {
        return this.properties.getActiveNavigation() == 2;
    }

   // @Override
    public ASLCarplayServicesCallState[] getCarPlayCallStates() {
        return ASLCarplayServicesCallStateImpl.createClusterCallstates(this.properties.getCurrentCallStates());
    }

   // @Override
    public ASLCarplayServicesTelephonyState getCarPlayTelephonyState() {
        return this.telephonyState;
    }

   // @Override
    public void requestAcceptCall() {
        if (this.target != null && this.target.getDSICarPlay() != null) {
            this.target.getDSICarPlay().postButtonEvent(13, 0);
            this.target.getDSICarPlay().postButtonEvent(13, 1);
        }
    }

   // @Override
    public void requestEndCall() {
        if (this.target != null && this.target.getDSICarPlay() != null) {
            this.target.getDSICarPlay().postButtonEvent(14, 0);
            this.target.getDSICarPlay().postButtonEvent(14, 1);
        }
    }
}

