/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mirrorlink.model.list;

import de.vw.mib.asl.internal.list.ASLListDataUpdateListener;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.mirrorlink.model.list.AbstractListHandler;
import de.vw.mib.asl.internal.mirrorlink.model.list.MirrorlinkAppListFetcher;
import de.vw.mib.asl.internal.mirrorlink.target.MirrorLinkTarget;
import de.vw.mib.asl.internal.mirrorlink.transformer.MirrorLinkAppListCollector;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import java.util.ArrayList;
import org.dsi.ifc.mirrorlink.Application;

public class AppList
extends AbstractListHandler {
    private static final MirrorLinkAppListCollector[] APP_LIST_WINDOW = new MirrorLinkAppListCollector[10];
    private final String classname;
    private int availableAppListSize = 0;
    private final MirrorLinkTarget target;

    public AppList(MirrorLinkTarget mirrorLinkTarget) {
        super(3419);
        this.classname = "AppList";
        this.target = mirrorLinkTarget;
        new MirrorlinkAppListFetcher(3419, mirrorLinkTarget);
        this.clear();
    }

    private MirrorLinkTarget getTarget() {
        return this.target;
    }

    public Application[] getAvailableApplicationList() {
        ArrayList arrayList = new ArrayList();
        if (this.getList().getSize() > 0) {
            GenericASLList genericASLList = this.getList();
            for (int i2 = 0; i2 < genericASLList.getItemCount(); ++i2) {
                Object object = genericASLList.getRowItem(i2);
                if (!genericASLList.isValidItem(object)) continue;
                MirrorLinkAppListCollector mirrorLinkAppListCollector = (MirrorLinkAppListCollector)object;
                arrayList.add(mirrorLinkAppListCollector.getApplication());
            }
        }
        return (Application[])arrayList.toArray(new Application[arrayList.size()]);
    }

    public int getAvailableAppListSize() {
        return this.availableAppListSize;
    }

    public int getIndex(int n) {
        Object object;
        if (this.getTarget().isTraceEnabled()) {
            object = this.getTarget().trace();
            object.append("AppList").append(new StringBuffer().append(".getIndex(").append(n).append(")").toString()).log();
        }
        if (this.getList().getSize() > 0) {
            object = this.getList();
            for (int i2 = 0; i2 < object.getItemCount(); ++i2) {
                Object object2 = object.getRowItem(i2);
                if (object.isValidItem(object2)) {
                    MirrorLinkAppListCollector mirrorLinkAppListCollector = (MirrorLinkAppListCollector)object2;
                    if (mirrorLinkAppListCollector == null || mirrorLinkAppListCollector.getApplication().getAppID() != n) continue;
                    return i2;
                }
                return -2;
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
        if (n > -1 && this.getList().getSize() > 0) {
            Object object;
            GenericASLList genericASLList = this.getList();
            if (genericASLList.isValidItem(object = genericASLList.getRowItem(n))) {
                return (MirrorLinkAppListCollector)object;
            }
            return null;
        }
        return null;
    }

    public void addASLListDataUpdateListener(ASLListDataUpdateListener aSLListDataUpdateListener) {
        this.getList().addASLListDataUpdateListener(aSLListDataUpdateListener);
    }

    public void removeASLListDataUpdateListener(ASLListDataUpdateListener aSLListDataUpdateListener) {
        this.getList().removeASLListDataUpdateListener(aSLListDataUpdateListener);
    }

    public void updateAvailableApplications(int n, Application[] applicationArray) {
        Object[] objectArray;
        if (this.getTarget().isTraceEnabled()) {
            objectArray = this.getTarget().trace();
            objectArray.append("AppList").append(new StringBuffer().append(".updateAvailableApplications(").append(n).append(", ").append(Util.isNullOrEmpty(applicationArray) ? 0 : applicationArray.length).append(")").toString()).log();
        }
        if (!Util.isNullOrEmpty(applicationArray)) {
            objectArray = applicationArray.length == APP_LIST_WINDOW.length ? APP_LIST_WINDOW : new MirrorLinkAppListCollector[applicationArray.length];
            for (int i2 = 0; i2 < applicationArray.length; ++i2) {
                MirrorLinkAppListCollector mirrorLinkAppListCollector = new MirrorLinkAppListCollector(applicationArray[i2]);
                objectArray[i2] = mirrorLinkAppListCollector;
            }
            this.getList().updateListItems(n, objectArray);
            this.availableAppListSize = objectArray.length;
        }
    }

    public void updateApplicationStatus(int n, int n2, int n3) {
        int n4;
        MirrorLinkAppListCollector mirrorLinkAppListCollector;
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("AppList").append(".updateApplicationStatus(").append(new StringBuffer().append(n).append(", ").append(n2).append(", ").append(n3).toString()).append(" )").log();
        }
        if ((mirrorLinkAppListCollector = this.getApplicationCollector(n4 = this.getIndex(n))) == null) {
            LogMessage logMessage = this.getTarget().warn();
            logMessage.append("AppList").append(".updateApplicationStatus(").append(n).append(", ").append(n2).append(", ").append(n3).append(") Launched application not available.").log();
        } else {
            mirrorLinkAppListCollector.setApplicationStatus(n2);
            mirrorLinkAppListCollector.setApplicationRunStatus(n3);
            this.getList().updateListItem(n4, mirrorLinkAppListCollector);
        }
    }

    @Override
    public void reset() {
    }
}

