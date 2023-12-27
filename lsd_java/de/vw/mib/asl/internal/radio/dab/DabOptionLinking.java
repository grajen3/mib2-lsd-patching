/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.RadioData;

public final class DabOptionLinking {
    public void reset() {
        this.setDabFollowing(true);
        this.setFmLinking(true);
        GuiApiDab.enableSoftLinkingButton(true);
        this.setSoftLinking(true);
    }

    public void notifyHMI() {
        GuiApiDab.updateOptionServiceFollowing(this.getDabServiceFollowing());
        GuiApiDab.updateOptionServiceLinking(this.getFmLinking());
        GuiApiDab.enableSoftLinkingButton(this.getDabServiceFollowing() || this.getFmLinking());
        GuiApiDab.updateOptionSoftLinking(this.getSoftLinking());
    }

    public void set(int n) {
        this.fromDsi(n);
        this.announce();
    }

    public void setDabFollowing(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append("DabOptionLinking persistening DabLinking : ").append(bl).log();
        }
        RadioData.getDabDatabase().mPersistable.setDabFollowing(bl);
    }

    public void setFmLinking(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append("DabOptionLinking persistening FmLinking : ").append(bl).log();
        }
        RadioData.getDabDatabase().mPersistable.setFmLinking(bl);
    }

    public void setSoftLinking(boolean bl) {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(416) && (this.getDabServiceFollowing() || this.getFmLinking())) {
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append("setSoftLinking : ").append(bl).log();
            }
            RadioData.getDabDatabase().mPersistable.setSoftLinking(bl);
        }
    }

    public void announce() {
        this.log();
        this.notifyHMI();
    }

    private void log() {
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256, this.toString());
        }
    }

    public String toString() {
        return new StringBuffer().append("DAB Service Following = ").append(this.getDabServiceFollowing()).append(", DAB FM Linking = ").append(this.getFmLinking()).append(", DAB or FM Soft Linking = ").append(this.getSoftLinking()).toString();
    }

    public boolean getFmLinking() {
        return RadioData.getDabDatabase().mPersistable.getFmLinking();
    }

    public boolean getSoftLinking() {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(416)) {
            return RadioData.getDabDatabase().mPersistable.getSoftLinking();
        }
        return false;
    }

    public boolean getDabServiceFollowing() {
        return RadioData.getDabDatabase().mPersistable.getDabFollowing();
    }

    private int toDsi(boolean bl, boolean bl2, boolean bl3) {
        int n = 1;
        if (bl) {
            if (bl2) {
                n = 3;
                if (bl3) {
                    n = 7;
                }
            } else {
                n = 2;
                if (bl3) {
                    n = 6;
                }
            }
        } else if (bl2) {
            n = 4;
            if (bl3) {
                n = 8;
            }
        }
        if (1 == n) {
            GuiApiDab.enableSoftLinkingButton(false);
        } else {
            GuiApiDab.enableSoftLinkingButton(true);
        }
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append("DabOptionLinking in toDsi method : ").append(n).log();
        }
        return n;
    }

    private void fromDsi(int n) {
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append("DabOptionLinking in fromDsi method : ").append(n).log();
        }
        this.setDabFollowing(n == 3 || n == 2 || n == 7 || n == 6);
        this.setFmLinking(n == 3 || n == 4 || n == 7 || n == 8);
        this.setSoftLinking(n == 7 || n == 6 || n == 8);
    }

    public int getOption() {
        return this.toDsi(this.getDabServiceFollowing(), this.getFmLinking(), this.getSoftLinking());
    }
}

