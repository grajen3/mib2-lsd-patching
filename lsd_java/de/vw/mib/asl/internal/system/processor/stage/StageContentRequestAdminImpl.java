/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor.stage;

import de.vw.mib.asl.api.system.content.AbstractStageContentRequest;
import de.vw.mib.asl.internal.system.processor.stage.AbstractStageContentRequestPermission;
import de.vw.mib.asl.internal.system.processor.stage.StageContentRequestAdmin;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.asl.internal.system.util.SystemLogger;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.Iterator;

public class StageContentRequestAdminImpl
implements StageContentRequestAdmin {
    private ArrayList permissionList;
    private SystemLogger systemLogger;

    public StageContentRequestAdminImpl(Logger logger) {
        Preconditions.checkArgumentNotNull(logger, "The given instance of Logger must not be null.");
        this.permissionList = new ArrayList();
        this.systemLogger = new SystemLogger(logger, super.getClass());
    }

    @Override
    public void addPermission(AbstractStageContentRequestPermission abstractStageContentRequestPermission) {
        Preconditions.checkArgumentNotNull(abstractStageContentRequestPermission, "The given instance of StageContentRequestPermission must not be null.");
        this.permissionList.add(abstractStageContentRequestPermission);
    }

    @Override
    public void removePermission(AbstractStageContentRequestPermission abstractStageContentRequestPermission) {
        Preconditions.checkArgumentNotNull(abstractStageContentRequestPermission, "The given instance of StageContentRequestPermission must not be null.");
        this.permissionList.remove(abstractStageContentRequestPermission);
    }

    @Override
    public boolean isRequestGranted(AbstractStageContentRequest abstractStageContentRequest) {
        Preconditions.checkArgumentNotNull(abstractStageContentRequest, "The given instance of StageContentRequest must not be null.");
        if (this.permissionList.isEmpty()) {
            this.systemLogger.warn(new StringBuffer().append("Permission list is empty. Content request for content id ").append(abstractStageContentRequest.getContentId()).append(" will be granted.").toString());
        }
        Iterator iterator = this.permissionList.iterator();
        while (iterator.hasNext()) {
            AbstractStageContentRequestPermission abstractStageContentRequestPermission = (AbstractStageContentRequestPermission)iterator.next();
            if (abstractStageContentRequestPermission.doIsGranted(abstractStageContentRequest.getContentId())) continue;
            this.systemLogger.warn(new StringBuffer().append(super.getClass().getName()).append(": ").append(abstractStageContentRequestPermission.getRefuseMessage()).toString());
            return false;
        }
        return true;
    }

    ArrayList getPermissionList() {
        return this.permissionList;
    }

    void setPermissionList(ArrayList arrayList) {
        this.permissionList = arrayList;
    }
}

