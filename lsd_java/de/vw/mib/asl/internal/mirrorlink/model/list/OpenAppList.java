/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mirrorlink.model.list;

import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.mirrorlink.helper.MirrorlinkHelper;
import de.vw.mib.asl.internal.mirrorlink.model.list.AbstractListHandler;
import de.vw.mib.asl.internal.mirrorlink.target.MirrorLinkTarget;
import de.vw.mib.asl.internal.mirrorlink.transformer.MirrorLinkAppListCollector;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import edu.emory.mathcs.backport.java.util.Collections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.dsi.ifc.mirrorlink.Application;

public class OpenAppList
extends AbstractListHandler {
    private final String classname;
    private final MirrorLinkTarget target;
    private Set deletionSet = Collections.synchronizedSet(new HashSet());
    private long deletionDelay = 0;

    public OpenAppList(MirrorLinkTarget mirrorLinkTarget) {
        super(3545);
        this.classname = "OpenAppList";
        this.target = mirrorLinkTarget;
        this.clear();
    }

    private MirrorLinkTarget getTarget() {
        return this.target;
    }

    public int getIndex(int n) {
        if (this.getList().getSize() > 0) {
            GenericASLList genericASLList = this.getList();
            for (int i2 = 0; i2 < genericASLList.getItemCount(); ++i2) {
                MirrorLinkAppListCollector mirrorLinkAppListCollector;
                Object object = genericASLList.getRowItem(i2);
                if (!genericASLList.isValidItem(object) || (mirrorLinkAppListCollector = (MirrorLinkAppListCollector)object) == null || mirrorLinkAppListCollector.getApplication().getAppID() != n) continue;
                return i2;
            }
        }
        return -1;
    }

    public MirrorLinkAppListCollector getActivatedElement() {
        int n = this.getList().getActivatedIndex();
        if (n > -1) {
            return this.getApplicationCollector(n);
        }
        return null;
    }

    public MirrorLinkAppListCollector getApplicationCollector(int n) {
        Object object;
        GenericASLList genericASLList;
        if (n > -1 && this.getList().getSize() > 0 && !this.deletionSet.contains(new Integer(n)) && (genericASLList = this.getList()).isValidItem(object = genericASLList.getRowItem(n))) {
            return (MirrorLinkAppListCollector)object;
        }
        return null;
    }

    public Application[] getApplications() {
        Object[] objectArray;
        ArrayList arrayList = new ArrayList();
        if (this.getList().getSize() > 0 && !Util.isNullOrEmpty(objectArray = (MirrorLinkAppListCollector[])this.getList().getDSIObjects())) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                arrayList.add(((MirrorLinkAppListCollector)objectArray[i2]).getApplication());
            }
        }
        return (Application[])arrayList.toArray(new Application[arrayList.size()]);
    }

    public void addOpenApp(Application application) {
        Object[] objectArray;
        Object object;
        if (this.getTarget().isTraceEnabled()) {
            object = this.getTarget().trace();
            object.append("OpenAppList").append(new StringBuffer().append(".addOpenApp(").append(application != null ? application.toString() : "NULL").append(")").toString()).log();
        }
        if (application == null) {
            return;
        }
        this.deletionSet.remove(new Integer(application.getAppID()));
        object = new ArrayList();
        boolean bl = false;
        if (this.getList().getSize() > 0 && !Util.isNullOrEmpty(objectArray = (MirrorLinkAppListCollector[])this.getList().getDSIObjects())) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                if (MirrorlinkHelper.compareApplication(((MirrorLinkAppListCollector)objectArray[i2]).getApplication(), application)) {
                    bl = true;
                }
                ((ArrayList)object).add(objectArray[i2]);
            }
        }
        if (!bl) {
            ((ArrayList)object).add(new MirrorLinkAppListCollector(application));
        }
        this.getList().updateList(((ArrayList)object).toArray(new MirrorLinkAppListCollector[((ArrayList)object).size()]));
    }

    public void removeOpenApp(Application application) {
        Object[] objectArray;
        Object object;
        if (this.getTarget().isTraceEnabled()) {
            object = this.getTarget().trace();
            object.append("OpenAppList").append(new StringBuffer().append(".removeOpenApp(").append(application != null ? application.toString() : "NULL").append(")").toString()).log();
        }
        if (application == null) {
            return;
        }
        object = new ArrayList();
        if (this.getList().getSize() > 0 && !Util.isNullOrEmpty(objectArray = (MirrorLinkAppListCollector[])this.getList().getDSIObjects())) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                if (objectArray[i2] == null || ((MirrorLinkAppListCollector)objectArray[i2]).getApplication().getAppID() == application.getAppID()) continue;
                ((ArrayList)object).add(objectArray[i2]);
            }
        }
        boolean bl = this.getList().isFrozen();
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("OpenAppList").append(new StringBuffer().append(".removeOpenApp() - list size before update: ").append(this.getList().getSize()).append(", isfrozen: ").append(bl).toString()).log();
        }
        if (bl) {
            this.deletionSet.add(new Integer(application.getAppID()));
            this.getTarget().retriggerOrStartTimer(-1417281280, this.deletionDelay, false);
            if (this.getTarget().isTraceEnabled()) {
                LogMessage logMessage = this.getTarget().trace();
                logMessage.append("OpenAppList").append(new StringBuffer().append(".removeOpenApp() - list frozen, will try again in: ").append(this.deletionDelay).append("ms").toString()).log();
            }
        } else {
            this.getList().updateList(((ArrayList)object).toArray(new MirrorLinkAppListCollector[((ArrayList)object).size()]));
            if (this.getTarget().isTraceEnabled()) {
                LogMessage logMessage = this.getTarget().trace();
                logMessage.append("OpenAppList").append(new StringBuffer().append(".removeOpenApp() - list size after update: ").append(this.getList().getSize()).toString()).log();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeQueuedApps() {
        Object object;
        if (this.getTarget().isTraceEnabled()) {
            object = this.getTarget().trace();
            object.append("OpenAppList").append(new StringBuffer().append(".removeQueuedApps() - list size before update: ").append(this.getList().getSize()).append(", queue size: ").append(this.deletionSet.size()).toString()).log();
        }
        object = this.deletionSet;
        synchronized (object) {
            Object object2;
            ArrayList arrayList = new ArrayList();
            if (this.getList().getSize() > 0 && !Util.isNullOrEmpty((Object[])(object2 = (MirrorLinkAppListCollector[])this.getList().getDSIObjects()))) {
                for (int i2 = 0; i2 < ((Object[])object2).length; ++i2) {
                    Integer n = new Integer(((MirrorLinkAppListCollector)object2[i2]).getApplication().getAppID());
                    if (object2[i2] == null || this.deletionSet.contains(n)) continue;
                    arrayList.add(object2[i2]);
                }
            }
            if (this.getList().isFrozen()) {
                if (this.getTarget().isTraceEnabled()) {
                    object2 = this.getTarget().trace();
                    object2.append("OpenAppList").append(new StringBuffer().append(".removeQueuedApps() - list still frozen, will try again in: ").append(this.deletionDelay).append("ms").toString()).log();
                }
                this.getTarget().retriggerOrStartTimer(-1417281280, this.deletionDelay, false);
            } else {
                if (this.getTarget().isTraceEnabled()) {
                    object2 = this.getTarget().trace();
                    object2.append("OpenAppList").append(new StringBuffer().append(".removeQueuedApps() - items: ").append(arrayList.size()).append(", deletionSet: ").append(this.deletionSet.size()).toString()).log();
                }
                this.deletionSet.clear();
                this.getList().updateList(arrayList.toArray(new MirrorLinkAppListCollector[arrayList.size()]));
                if (this.getTarget().isTraceEnabled()) {
                    object2 = this.getTarget().trace();
                    object2.append("OpenAppList").append(new StringBuffer().append(".removeQueuedApps() - list size after update: ").append(this.getList().getSize()).toString()).log();
                }
            }
        }
    }

    public void closeAllOpenApps() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("OpenAppList").append(".closeAllOpenApps()").log();
        }
        this.deletionSet.clear();
        this.getList().setSize(0);
    }

    public void updateApplicationStatus(int n, int n2, int n3) {
        int n4;
        MirrorLinkAppListCollector mirrorLinkAppListCollector;
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("OpenAppList").append(new StringBuffer().append(".updateApplicationStatus(").append(n).append(", ").append(n2).append(", ").append(n3).append(")").toString()).log();
        }
        if ((mirrorLinkAppListCollector = this.getApplicationCollector(n4 = this.getIndex(n))) == null) {
            LogMessage logMessage = this.getTarget().warn();
            logMessage.append("OpenAppList").append(".updateApplicationStatus(").append(n).append(", ").append(n2).append(", ").append(n3).append(") Launched application not available.").log();
        } else {
            mirrorLinkAppListCollector.setApplicationStatus(n2);
            mirrorLinkAppListCollector.setApplicationRunStatus(n3);
            this.getList().updateListItem(n4, mirrorLinkAppListCollector);
            if (this.getTarget().isTraceEnabled()) {
                LogMessage logMessage = this.getTarget().trace();
                logMessage.append("OpenAppList").append(new StringBuffer().append(".updateApplicationStatus() - list size:").append(this.getList().getSize()).append(")").toString()).log();
            }
        }
    }

    @Override
    public void reset() {
    }
}

