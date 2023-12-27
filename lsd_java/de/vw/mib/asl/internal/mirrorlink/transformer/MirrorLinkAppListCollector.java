/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mirrorlink.transformer;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.mirrorlink.Application;

public final class MirrorLinkAppListCollector
implements Comparable {
    private Application application = null;
    private int applicationStatus = 0;
    private int applicationRunStatus = 0;

    public MirrorLinkAppListCollector(Application application) {
        this.application = application;
    }

    public static MirrorLinkAppListCollector copyOf(MirrorLinkAppListCollector mirrorLinkAppListCollector) {
        MirrorLinkAppListCollector mirrorLinkAppListCollector2 = null;
        Application application = mirrorLinkAppListCollector.getApplication();
        mirrorLinkAppListCollector2 = new MirrorLinkAppListCollector(application);
        mirrorLinkAppListCollector2.application.appID = application.appID;
        mirrorLinkAppListCollector2.application.appName = application.appName;
        mirrorLinkAppListCollector2.application.appCategory = application.appCategory;
        mirrorLinkAppListCollector2.application.appIcon.id = application.appIcon.id;
        mirrorLinkAppListCollector2.application.appIcon.url = application.appIcon.url;
        mirrorLinkAppListCollector2.application.certType = application.certType;
        return mirrorLinkAppListCollector2;
    }

    public Application getApplication() {
        if (this.application != null) {
            return this.application;
        }
        return new Application();
    }

    public boolean isCertifiedApp() {
        if (this.application != null) {
            int n = this.application.getCertType();
            return n == 1;
        }
        return false;
    }

    public boolean isNotLaunchableRegion() {
        if (this.application != null) {
            int n = this.application.getNotLaunchableReason() & 1;
            return n == 1;
        }
        return false;
    }

    public ResourceLocator getImageResourceLocator() {
        if (this.application != null) {
            return this.application.getAppIcon();
        }
        return new ResourceLocator();
    }

    public String getApplicationName() {
        if (this.application != null) {
            return this.application.getAppName();
        }
        return "";
    }

    @Override
    public int compareTo(Object object) {
        MirrorLinkAppListCollector mirrorLinkAppListCollector = (MirrorLinkAppListCollector)object;
        return this.getApplication().getAppName().compareTo(mirrorLinkAppListCollector.getApplication().getAppName());
    }

    public int getApplicationStatus() {
        return this.applicationStatus;
    }

    public void setApplicationStatus(int n) {
        this.applicationStatus = n;
    }

    public int getApplicationRunStatus() {
        return this.applicationRunStatus;
    }

    public void setApplicationRunStatus(int n) {
        this.applicationRunStatus = n;
    }
}

