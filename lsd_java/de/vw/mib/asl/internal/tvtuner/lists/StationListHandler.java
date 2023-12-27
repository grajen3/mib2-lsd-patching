/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.lists;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.tvtuner.accessor.TVTunerObjectAccessor;
import de.vw.mib.asl.internal.tvtuner.collector.TVStationListCollector;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerHelper;
import de.vw.mib.asl.internal.tvtuner.lists.AbstractListHandler;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class StationListHandler
extends AbstractListHandler {
    private final Object lock = new Object();
    private boolean isStationListEntered = false;
    private ServiceInfo[] stationList = null;
    private ServiceInfo[] browserlist = null;
    private ServiceInfo[] tmpStationList = null;
    List markedServiceInfos = new ArrayList();
    private boolean saveStation = false;
    private boolean isFirstElementDummy = false;

    public void setStationListEntered(boolean bl) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("StationListHandler#setStationListEntered called - isStationListEntered = ").append(bl).toString());
        }
        this.isStationListEntered = bl;
        if (bl) {
            TVTunerObjectAccessor.getTvBAP().updateBAPStationList();
        }
    }

    public void activateSelectedStation(int n, boolean bl) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("StationListHandler#activateSelectedStation called - SelectedIndex = ").append(n).toString());
        }
        ServiceInfo serviceInfo = this.stationList[n];
        this.activateSelectedService(serviceInfo);
        if (bl) {
            this.saveStation = true;
        }
    }

    public void activateSelectedService(long l, int n, int n2, boolean bl) {
        ServiceInfo serviceInfo;
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("StationListHandler#activateSelectedService called - Selected service = ").append(l).append(" - Save Service = ").append(bl).toString());
        }
        if ((serviceInfo = TVTunerObjectAccessor.getTVInfo().getCurrentServiceInfo()) != null && l == serviceInfo.getNamePID() && n == serviceInfo.getServicePID() && bl) {
            TVTunerObjectAccessor.getTargetTVTuner().sendHMIEvent(436);
            return;
        }
        TVTunerObjectAccessor.getTargetTVTunerDSI().getDSITVTuner().selectService(l, n, n2);
        if (bl) {
            this.saveStation = true;
        }
    }

    public void updateServiceInfo() {
        if (this.stationList == null) {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace("StationListHandler#updateServiceInfo called - stationlist is null - leave and do nothing");
            }
            return;
        }
        this.updateServiceInfo(this.stationList, false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateServiceInfo(ServiceInfo[] serviceInfoArray, boolean bl) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("StationListHandler#updateServiceInfo called - isDSIUpdate = ").append(bl).toString());
        }
        Object[] objectArray = this.lock;
        synchronized (this.lock) {
            if (bl) {
                this.browserlist = serviceInfoArray;
                if (!this.markedServiceInfos.isEmpty()) {
                    if (TVTunerHelper.isTraceEnabled()) {
                        TVTunerHelper.trace("StationListHandler#updateServiceInfo - there are marked services available - will be inserted in list");
                    }
                    serviceInfoArray = this.insertMarkedServiceInfosAfterDSIUpdate(serviceInfoArray);
                } else {
                    this.isFirstElementDummy = false;
                }
            } else if (!this.markedServiceInfos.isEmpty() && !TVTunerObjectAccessor.getTargetTVTuner().getTimerServer().isTimerActive(TVTunerObjectAccessor.getTargetTVTuner().getTargetId(), -1585053440)) {
                if (TVTunerHelper.isTraceEnabled()) {
                    TVTunerHelper.trace("StationListHandler#updateServiceInfo - marked services available and no dsi-update - start timer EV_TVTUNER_SERVICE_INFO_LIFETIME_TIMER");
                }
                TVTunerObjectAccessor.getTargetTVTuner().startTimer(-1585053440, (long)0, false);
            }
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace("StationListHandler#updateServiceInfo - stationlist updated");
            }
            this.stationList = serviceInfoArray;
            ServiceInfo serviceInfo = TVTunerObjectAccessor.getTVInfo().getCurrentServiceInfo();
            if (serviceInfo != null) {
                if (serviceInfo.getSType() == 15) {
                    ServiceInfo serviceInfo2;
                    if (TVTunerHelper.isTraceEnabled()) {
                        TVTunerHelper.trace("StationListHandler#updateServiceInfo - current active station has stype dummy - so put dummy stype at first position");
                    }
                    if ((serviceInfo2 = TVTunerObjectAccessor.getTVInfo().getsTypeDummyService()) != null) {
                        serviceInfo = serviceInfo2;
                    }
                    if (this.isFirstElementDummy) {
                        this.stationList[0] = serviceInfo;
                    } else {
                        this.addServiceInfoAtFirstPosition(serviceInfo);
                        this.isFirstElementDummy = true;
                    }
                } else {
                    if (this.isFirstElementDummy) {
                        if (TVTunerHelper.isTraceEnabled()) {
                            TVTunerHelper.trace("StationListHandler#updateServiceInfo - last station had stype dummy, new active station not, remove first listelement");
                        }
                        this.removeServiceAtPosition(0);
                        this.isFirstElementDummy = false;
                    }
                    if (this.getListindexForServiceInfo(serviceInfo, this.stationList, true) == -1) {
                        if (TVTunerHelper.isTraceEnabled()) {
                            TVTunerHelper.trace(new StringBuffer().append("StationListHandler#updateServiceInfo - current service ").append(serviceInfo.getName()).append(" is not part of browserlist and will be inserted in stationlist and marked services").toString());
                        }
                        this.addServiceInfoAtFirstPosition(serviceInfo);
                        this.markedServiceInfos.add(0, serviceInfo);
                    }
                }
            }
            // ** MonitorExit[var3_3] (shouldn't be in output)
            objectArray = new TVStationListCollector[this.stationList.length];
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                objectArray[i2] = new TVStationListCollector(this.getPresetNumber(this.stationList[i2]), this.stationList[i2].getName(), this.stationList[i2].getSType(), this.stationList[i2].getNamePID(), this.stationList[i2].getServicePID());
            }
            ListManager.getGenericASLList(2525).updateList(objectArray);
            TVTunerObjectAccessor.getTvBAP().updateBAPStationList();
            ServiceInfo serviceInfo3 = TVTunerObjectAccessor.getTVInfo().getCurrentServiceInfo();
            if (serviceInfo3 != null) {
                this.setStationListIndex(serviceInfo3);
            }
            return;
        }
    }

    private ServiceInfo[] insertMarkedServiceInfosAfterDSIUpdate(ServiceInfo[] serviceInfoArray) {
        Iterator iterator = this.markedServiceInfos.iterator();
        while (iterator.hasNext()) {
            ServiceInfo serviceInfo = (ServiceInfo)iterator.next();
            if (this.getListindexForServiceInfo(serviceInfo, serviceInfoArray, true) == -1) {
                serviceInfoArray = this.addServiceInfoAtPosition(0, serviceInfoArray, serviceInfo);
                continue;
            }
            this.markedServiceInfos.remove(serviceInfo);
        }
        return serviceInfoArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void checkMarkedServiceInfos() {
        Object object = this.lock;
        synchronized (object) {
            ServiceInfo serviceInfo = TVTunerObjectAccessor.getTVInfo().getCurrentServiceInfo();
            for (int i2 = this.markedServiceInfos.size() - 1; i2 > -1; --i2) {
                ServiceInfo serviceInfo2 = (ServiceInfo)this.markedServiceInfos.get(i2);
                if (this.getListindexForServiceInfo(serviceInfo2, this.browserlist, true) != -1 || serviceInfo.getNamePID() == serviceInfo2.getNamePID() && serviceInfo.getServicePID() == serviceInfo2.getServicePID()) continue;
                int n = this.getListindexForServiceInfo(serviceInfo2, this.stationList, true);
                if (n != -1) {
                    this.removeServiceAtPosition(n);
                }
                this.markedServiceInfos.remove(serviceInfo2);
            }
        }
        this.updateServiceInfo();
    }

    private int getPresetNumber(ServiceInfo serviceInfo) {
        int n;
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("StationListHandler#getPresetNumber called");
        }
        if ((n = TVTunerObjectAccessor.getPresetListHandler().getPresetPosition(serviceInfo)) != -1) {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace(new StringBuffer().append("StationListHandler#getPresetNumber - presetnumber for service ").append(serviceInfo.getName()).append("is ").append(n + 1).toString());
            }
            return n + 1;
        }
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("StationListHandler#getPresetNumber - service ").append(serviceInfo.getName()).append(" is not stored in presets").toString());
        }
        return 0;
    }

    public void setStationListIndex(ServiceInfo serviceInfo) {
        int n;
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("StationListHandler#setStationListIndex called - service ").append(serviceInfo.getName()).toString());
        }
        boolean bl = true;
        if (TVTunerObjectAccessor.getTvTunerSettings().isServiceLinking()) {
            bl = false;
        }
        if ((n = this.getListindexForServiceInfo(serviceInfo, this.stationList, bl)) != -1) {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace(new StringBuffer().append("StationListHandler#setStationListIndex - stationListIndex = ").append(n).toString());
            }
            ServiceManager.aslPropertyManager.valueChangedInteger(2566, n);
        } else if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("StationListHandler#setStationListIndex - service ").append(serviceInfo.getName()).append(" not present in stationlist").toString());
        }
    }

    public void updateStationListAfterExiting() {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("StationListHandler#updateStationListAfterExiting called");
        }
        if (this.tmpStationList != null) {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace("StationListHandler#updateStationListAfterExiting - tmpStationList != null - call updateServiceInfo(tmpStationList)");
            }
            this.updateServiceInfo(this.tmpStationList, false);
            this.tmpStationList = null;
        } else if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("StationListHandler#updateStationListAfterExiting - tmpStationList == null - do not update");
        }
    }

    public boolean isSaveStation() {
        return this.saveStation;
    }

    public void setSaveStation(boolean bl) {
        this.saveStation = bl;
    }

    public void setStypeDummyStationInFirstRow(ServiceInfo serviceInfo) {
        this.addServiceInfoAtFirstPosition(serviceInfo);
    }

    private void addServiceInfoAtFirstPosition(ServiceInfo serviceInfo) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("StationListHandler#addServiceInfoAtFirstPosition called - ServiceInfo = ").append(serviceInfo.toString()).toString());
        }
        this.stationList = this.addServiceInfoAtPosition(0, this.stationList, serviceInfo);
    }

    private void removeServiceAtPosition(int n) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("StationListHandler#removeServiceAtPosition called - position = ").append(n).toString());
        }
        if (n > this.stationList.length - 1) {
            return;
        }
        ServiceInfo[] serviceInfoArray = new ServiceInfo[this.stationList.length - 1];
        for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
            serviceInfoArray[i2] = i2 < n ? this.stationList[i2] : this.stationList[i2 + 1];
        }
        this.stationList = serviceInfoArray;
    }

    public String getStationName(long l, int n) {
        for (int i2 = 0; i2 < this.stationList.length; ++i2) {
            if (this.stationList[i2].getNamePID() != l || this.stationList[i2].getServicePID() != n) continue;
            return this.stationList[i2].getName();
        }
        return null;
    }

    public ServiceInfo[] getStationList() {
        return this.stationList;
    }

    public int activateBAPStation(long l, int n) {
        for (int i2 = 0; i2 < this.stationList.length; ++i2) {
            if (this.stationList[i2].getNamePID() != l || this.stationList[i2].getServicePID() != n) continue;
            this.activateSelectedService(this.stationList[i2]);
            return 1;
        }
        return 0;
    }

    public void selectNextStationService(int n) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("StationListHandler#selectNextStationService called - direction = ").append(n).toString());
        }
        if (this.stationList == null || this.stationList.length == 0) {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace("StationListHandler#selectNextStationService called - but no stations available - do nothing");
            }
            return;
        }
        int n2 = -1;
        ServiceInfo serviceInfo = TVTunerObjectAccessor.getTVInfo().getCurrentServiceInfo();
        if (serviceInfo != null) {
            n2 = this.getListindexForServiceInfo(serviceInfo, this.stationList, true);
        }
        if (n2 != -1) {
            if (n == 1) {
                this.activateSelectedService(this.stationList[n2 == this.stationList.length - 1 ? 0 : ++n2]);
            } else {
                this.activateSelectedService(this.stationList[n2 == 0 ? this.stationList.length - 1 : --n2]);
            }
        } else if (n == 1) {
            this.activateSelectedService(this.stationList[0]);
        } else {
            this.activateSelectedService(this.stationList[this.stationList.length - 1]);
        }
    }
}

