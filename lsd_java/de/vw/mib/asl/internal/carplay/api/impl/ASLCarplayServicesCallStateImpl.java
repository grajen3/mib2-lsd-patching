/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carplay.api.impl;

import de.vw.mib.asl.api.carplay.ASLCarplayServicesCallState;
import java.util.Hashtable;
import java.util.Iterator;
import org.dsi.ifc.carplay.CallState;

public final class ASLCarplayServicesCallStateImpl
implements ASLCarplayServicesCallState {
    String phoneNumber = "";
    String callerName = "";
    int status = 0;
    int direction = 2;
    String uniqueCallID = "";

    static ASLCarplayServicesCallStateImpl[] createClusterCallstates(Hashtable hashtable) {
        ASLCarplayServicesCallStateImpl[] aSLCarplayServicesCallStateImplArray = new ASLCarplayServicesCallStateImpl[hashtable.size()];
        int n = 0;
        Iterator iterator = hashtable.values().iterator();
        while (iterator.hasNext()) {
            CallState callState = (CallState)iterator.next();
            aSLCarplayServicesCallStateImplArray[n] = new ASLCarplayServicesCallStateImpl(callState.getPhoneNumber(), callState.getCallerName(), callState.getStatus(), callState.getDirection(), callState.getUniqueCallID());
            ++n;
        }
        return aSLCarplayServicesCallStateImplArray;
    }

    private ASLCarplayServicesCallStateImpl(String string, String string2, int n, int n2, String string3) {
        this.phoneNumber = string;
        this.callerName = string2;
        this.status = n;
        this.direction = n2;
        this.uniqueCallID = string3;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public String getCallerName() {
        return this.callerName;
    }

    @Override
    public int getStatus() {
        return this.status;
    }

    @Override
    public int getDirection() {
        return this.direction;
    }

    @Override
    public String getUniqueCallID() {
        return this.uniqueCallID;
    }
}

