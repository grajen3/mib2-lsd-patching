/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.clients.model.control;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.clients.model.common.CoreServiceModelMap;
import de.vw.mib.asl.internal.online.clients.model.common.OnlineServicePackage;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineUser;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.ArrayList;

public class CoreServiceModelListHandler {
    private final String _classname = super.getClass().getName();
    private OnlineUser[] _userList;
    private OnlineUser _mainUser;
    private OnlineService[] _serviceList;
    private OnlineServicePackage[] _packageList;
    private int _currentFilter = 0;
    private OnlineServicePackage _currentPackage;

    public boolean addPackageToList(OnlineServicePackage onlineServicePackage) {
        if (onlineServicePackage != null) {
            if (Util.isNullOrEmpty(this._packageList)) {
                this._packageList = new OnlineServicePackage[1];
                this._packageList[0] = new OnlineServicePackage();
                this._packageList[0].copyTo(onlineServicePackage);
            } else {
                OnlineServicePackage onlineServicePackage2 = this.getPackageWithPackageID(onlineServicePackage.getPackageID());
                if (onlineServicePackage2 != null) {
                    onlineServicePackage2.copyTo(onlineServicePackage);
                } else {
                    this._packageList = (OnlineServicePackage[])Arrays.copyOf(this._packageList, this._packageList.length + 1);
                    this._packageList[this._packageList.length - 1] = new OnlineServicePackage();
                    this._packageList[this._packageList.length - 1].copyTo(onlineServicePackage);
                }
            }
            return true;
        }
        return false;
    }

    public boolean addService(OnlineService onlineService) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(".addService()").log();
        }
        if (onlineService != null) {
            if (Util.isNullOrEmpty(this._serviceList)) {
                this._serviceList = new OnlineService[1];
                this._serviceList[0] = new OnlineService();
                this._serviceList[0].copyTo(onlineService);
            } else {
                object = this.getServiceWithServiceID(onlineService.getServiceID());
                if (object != null) {
                    ((OnlineService)object).copyTo(onlineService);
                } else {
                    this._serviceList = (OnlineService[])Arrays.copyOf(this._serviceList, this._serviceList.length + 1);
                    this._serviceList[this._serviceList.length - 1] = new OnlineService();
                    this._serviceList[this._serviceList.length - 1].copyTo(onlineService);
                }
            }
            return true;
        }
        return false;
    }

    public void setServiceList(OnlineService[] onlineServiceArray) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".setServiceList(").append(Util.isNullOrEmpty(onlineServiceArray) ? 0 : onlineServiceArray.length).append(")").toString()).log();
        }
        if (!Util.isNullOrEmpty(onlineServiceArray)) {
            this._serviceList = new OnlineService[onlineServiceArray.length];
            for (int i2 = 0; i2 < onlineServiceArray.length; ++i2) {
                this._serviceList[i2] = new OnlineService();
                this._serviceList[i2].copyTo(onlineServiceArray[i2]);
            }
        } else {
            this._serviceList = new OnlineService[0];
        }
        this._packageList = null;
        if (!Util.isNullOrEmpty(this._serviceList)) {
            this.setPackageList(this._serviceList);
            this.setPackagesStateStatus(this.getCompletePackageList());
        }
    }

    private static int packageStateFromService(OnlineService onlineService) {
        return onlineService.isEnabledState() ? 2 : 0;
    }

    private void setPackagesStateStatus(OnlineServicePackage[] onlineServicePackageArray) {
        if (!Util.isNullOrEmpty(onlineServicePackageArray)) {
            int n = onlineServicePackageArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (Util.isNullOrEmpty(onlineServicePackageArray[i2].getServices())) continue;
                int n2 = onlineServicePackageArray[i2].getServices()[0] != null ? CoreServiceModelListHandler.packageStateFromService(onlineServicePackageArray[i2].getServices()[0]) : 2;
                int n3 = onlineServicePackageArray[i2].getServices().length;
                for (int i3 = 1; i3 < n3; ++i3) {
                    if (CoreServiceModelListHandler.packageStateFromService(onlineServicePackageArray[i2].getServices()[i3]) == n2) continue;
                    n2 = 1;
                    break;
                }
                onlineServicePackageArray[i2].setPackageState(n2);
            }
        } else {
            LogMessage logMessage = ServiceManager.logger2.info(16384);
            logMessage.append(this._classname).append(".Package List is empty").log();
        }
    }

    private void setPackageList(OnlineService[] onlineServiceArray) {
        if (!Util.isNullOrEmpty(onlineServiceArray)) {
            int n = onlineServiceArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (Util.isNullOrEmpty(this.getServiceList()[i2].getPrivacyGroups())) continue;
                int n2 = this.getServiceList()[i2].getPrivacyGroups().length;
                for (int i3 = 0; i3 < n2; ++i3) {
                    OnlineServicePackage onlineServicePackage = this.getPackageWithPackageID(this.getServiceList()[i2].getPrivacyGroups()[i3]);
                    if (onlineServicePackage == null) {
                        onlineServicePackage = new OnlineServicePackage();
                        onlineServicePackage.setPackageID(this.getServiceList()[i2].getPrivacyGroups()[i3]);
                        onlineServicePackage.setPackageState(2);
                        onlineServicePackage.setPackageCategory(CoreServiceModelMap.getCategoryWithGroup(this.getServiceList()[i2].getPrivacyGroups()[i3]));
                    }
                    onlineServicePackage.addService(this.getServiceList()[i2]);
                    this.addPackageToList(onlineServicePackage);
                }
            }
        }
    }

    public boolean checkForServiceBlocksDeactivation() {
        if (!Util.isNullOrEmpty(this.getServiceList())) {
            int n = this.getServiceList().length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!this.getServiceList()[i2].isDeactivationBlocked() || Util.isNullOrEmpty(this.getServiceList()[i2].getPrivacyGroups())) continue;
                return true;
            }
        }
        return false;
    }

    public OnlineService[] getServiceList() {
        return this._serviceList;
    }

    public OnlineService getServiceWithServiceID(String string) {
        if (!Util.isNullOrEmpty(this.getServiceList()) && !Util.isNullOrEmpty(string)) {
            int n = this.getServiceList().length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!this.getServiceList()[i2].getServiceID().equalsIgnoreCase(string)) continue;
                return this.getServiceList()[i2];
            }
        }
        return null;
    }

    public OnlineServicePackage[] getCompletePackageList() {
        return this._packageList;
    }

    public int getPackageListCount() {
        return this._packageList != null ? this._packageList.length : 0;
    }

    public OnlineServicePackage getPackageWithPackageID(int n) {
        if (!Util.isNullOrEmpty(this._packageList)) {
            int n2 = this._packageList.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (this._packageList[i2].getPackageID() != n) continue;
                return this._packageList[i2];
            }
        }
        return null;
    }

    public OnlineServicePackage[] getPackageListWithCategory(int n) {
        ArrayList arrayList = new ArrayList();
        if (!Util.isNullOrEmpty(this._packageList)) {
            int n2 = this._packageList.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (this._packageList[i2].getPackageCategory() != n) continue;
                OnlineServicePackage onlineServicePackage = new OnlineServicePackage();
                onlineServicePackage.copyTo(this._packageList[i2]);
                arrayList.add(onlineServicePackage);
            }
        }
        return arrayList.isEmpty() ? new OnlineServicePackage[]{} : (OnlineServicePackage[])arrayList.toArray(new OnlineServicePackage[arrayList.size()]);
    }

    public OnlineService[] getServicesWithPackageID(int n) {
        if (!Util.isNullOrEmpty(this._packageList)) {
            int n2 = this._packageList.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (this._packageList[i2].getPackageID() != n) continue;
                OnlineServicePackage onlineServicePackage = new OnlineServicePackage();
                onlineServicePackage.copyTo(this._packageList[i2]);
                return onlineServicePackage.getServices();
            }
        }
        return new OnlineService[0];
    }

    public OnlineUser[] getUserList() {
        return this._userList;
    }

    public void addUser(OnlineUser onlineUser) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(".addUser()").log();
        }
        if (onlineUser != null) {
            if (Util.isNullOrEmpty(this._userList)) {
                this._userList = new OnlineUser[1];
                this._userList[0] = new OnlineUser();
                this._userList[0].copyTo(onlineUser);
            } else {
                object = this.getUserWithID(onlineUser.getUserID());
                if (object != null) {
                    ((OnlineUser)object).copyTo(onlineUser);
                } else {
                    this._userList = (OnlineUser[])Arrays.copyOf(this._userList, this._userList.length + 1);
                    this._userList[this._userList.length - 1] = new OnlineUser();
                    this._userList[this._userList.length - 1].copyTo(onlineUser);
                }
            }
        }
        this.setMainUser(this._userList);
    }

    public void setUserList(OnlineUser[] onlineUserArray) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".setUserList()").log();
        }
        if (!Util.isNullOrEmpty(onlineUserArray)) {
            this._userList = new OnlineUser[onlineUserArray.length];
            for (int i2 = 0; i2 < onlineUserArray.length; ++i2) {
                this._userList[i2] = new OnlineUser();
                this._userList[i2].copyTo(onlineUserArray[i2]);
            }
        } else {
            this._userList = onlineUserArray;
        }
    }

    public OnlineUser getUserWithID(int n) {
        if (!Util.isNullOrEmpty(this._userList)) {
            int n2 = this._userList.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (this._userList[i2].getUserID() != n) continue;
                return this._userList[i2];
            }
        }
        return null;
    }

    public void setMainUser(OnlineUser[] onlineUserArray) {
        if (!Util.isNullOrEmpty(onlineUserArray)) {
            int n = onlineUserArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (onlineUserArray[i2].getUserType() != 1) continue;
                this._mainUser = onlineUserArray[i2];
                break;
            }
        }
    }

    public OnlineUser getMainUser() {
        return this._mainUser;
    }

    public int getCurrentCategoryFilter() {
        return this._currentFilter;
    }

    public void setCurrentCategoryFilter(int n) {
        this._currentFilter = n;
    }

    public void setCurrentSelectedPackage(OnlineServicePackage onlineServicePackage) {
        this._currentPackage = onlineServicePackage;
    }

    public OnlineServicePackage getCurrentSelectedPackage() {
        return this._currentPackage;
    }
}

