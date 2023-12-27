/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.admin;

import de.esolutions.fw.dsi.admin.ServiceStateMap$State;
import java.util.HashMap;
import java.util.Map;

public final class ServiceStateMap {
    public static final int ADDED;
    public static final int PENDING;
    public static final int REGISTERED;
    private final Map svcMap = new HashMap();

    public synchronized boolean checkAndAddService(String string, int n) {
        if (string == null) {
            return false;
        }
        String string2 = this.genKey(string, n);
        ServiceStateMap$State serviceStateMap$State = this.getState(string, n);
        if (serviceStateMap$State != null) {
            serviceStateMap$State.stopFlag = false;
            serviceStateMap$State.restartFlag = true;
            return false;
        }
        this.svcMap.put(string2, new ServiceStateMap$State());
        return true;
    }

    public synchronized boolean removeService(String string, int n) {
        if (string == null) {
            return false;
        }
        String string2 = this.genKey(string, n);
        return this.svcMap.remove(string2) != null;
    }

    public synchronized boolean removeStopFlag(String string, int n) {
        if (string == null) {
            return false;
        }
        String string2 = this.genKey(string, n);
        ServiceStateMap$State serviceStateMap$State = (ServiceStateMap$State)this.svcMap.get(string2);
        if (serviceStateMap$State == null) {
            return false;
        }
        serviceStateMap$State.stopFlag = false;
        return true;
    }

    public synchronized boolean setServiceState(String string, int n, int n2) {
        ServiceStateMap$State serviceStateMap$State = this.getState(string, n);
        if (serviceStateMap$State == null) {
            return false;
        }
        serviceStateMap$State.state = n2;
        return true;
    }

    public synchronized Integer getServiceState(String string, int n) {
        ServiceStateMap$State serviceStateMap$State = this.getState(string, n);
        if (serviceStateMap$State == null) {
            return null;
        }
        return new Integer(serviceStateMap$State.state);
    }

    public synchronized boolean isEmpty() {
        return this.svcMap.isEmpty();
    }

    public synchronized Boolean checkAndSetStopFlag(String string, int n) {
        ServiceStateMap$State serviceStateMap$State = this.getState(string, n);
        if (serviceStateMap$State == null) {
            return null;
        }
        if (!serviceStateMap$State.stopFlag) {
            serviceStateMap$State.stopFlag = true;
            serviceStateMap$State.restartFlag = false;
            return new Boolean(true);
        }
        return new Boolean(false);
    }

    public synchronized Boolean getStopFlag(String string, int n) {
        ServiceStateMap$State serviceStateMap$State = this.getState(string, n);
        if (serviceStateMap$State == null) {
            return null;
        }
        return new Boolean(serviceStateMap$State.stopFlag);
    }

    private String genKey(String string, int n) {
        return new StringBuffer().append(string).append(Integer.toString(n)).toString();
    }

    private ServiceStateMap$State getState(String string, int n) {
        if (string == null) {
            return null;
        }
        String string2 = this.genKey(string, n);
        ServiceStateMap$State serviceStateMap$State = (ServiceStateMap$State)this.svcMap.get(string2);
        return serviceStateMap$State;
    }

    public synchronized Boolean checkAndClearStopFlag(String string, int n) {
        ServiceStateMap$State serviceStateMap$State = this.getState(string, n);
        if (serviceStateMap$State == null) {
            return null;
        }
        if (serviceStateMap$State.stopFlag) {
            serviceStateMap$State.stopFlag = false;
            return new Boolean(true);
        }
        return new Boolean(false);
    }

    public synchronized Boolean checkAndClearRestartFlag(String string, int n) {
        ServiceStateMap$State serviceStateMap$State = this.getState(string, n);
        if (serviceStateMap$State == null) {
            return null;
        }
        if (serviceStateMap$State.restartFlag) {
            serviceStateMap$State.restartFlag = false;
            return new Boolean(true);
        }
        return new Boolean(false);
    }

    public synchronized boolean removeRestartFlag(String string, int n) {
        if (string == null) {
            return false;
        }
        String string2 = this.genKey(string, n);
        ServiceStateMap$State serviceStateMap$State = (ServiceStateMap$State)this.svcMap.get(string2);
        if (serviceStateMap$State == null) {
            return false;
        }
        serviceStateMap$State.restartFlag = false;
        return true;
    }
}

