/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.uota.sequence;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.common.uota.OnlineUotAPackage;
import de.vw.mib.asl.internal.online.uota.UotAFactory;
import de.vw.mib.asl.internal.online.uota.sequence.UotASequence;
import de.vw.mib.asl.internal.online.uota.states.UotATarget;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.uota.DSIUotA;

public class UotAInstallation
implements UotASequence {
    private final String _classname = super.getClass().getName();
    private final UotATarget _target;
    private final OnlineUotAPackage _currentPacket;

    public UotAInstallation(UotATarget uotATarget, OnlineUotAPackage onlineUotAPackage) {
        this._target = uotATarget;
        this._currentPacket = onlineUotAPackage;
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append("--> INSTALLATION STARTED").log();
        }
    }

    private OnlineUotAPackage getCurrentPacket() {
        return this._currentPacket;
    }

    @Override
    public void start() {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append("start()-> STARTED").log();
        }
        if (this.getCurrentPacket() != null) {
            this.getCurrentPacket().setPackageState(0);
            ServiceManager.aslPropertyManager.valueChangedString(855446272, this.getCurrentPacket().getLabel());
            UotAFactory.getSessionManager().setSessionID(1);
            DSIUotA dSIUotA = this._target.getDSIUotA();
            if (dSIUotA != null) {
                dSIUotA.getAttribute(UotAFactory.getSessionManager().getSessionID(), 1);
            }
            if (this._target.isTraceEnabled()) {
                this._target.trace().append(this._classname).append("start()-> ENDED").log();
            }
        } else {
            this._target.info().append(this._classname).append(".start()-> FAILED").log();
        }
    }

    @Override
    public void stop() {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append("stop()").log();
        }
    }

    @Override
    public void finish(int n) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".finish(").append(n).append(")").append("-> STARTED").toString()).log();
        }
        if (this._target.getDSIUotA() != null) {
            int n2 = 0;
            boolean bl = true;
            switch (n) {
                case 914: {
                    this.getCurrentPacket().reset();
                    bl = false;
                    break;
                }
                case 915: {
                    this.getCurrentPacket().reset();
                    bl = false;
                    n2 = 1;
                    break;
                }
            }
            this._target.getDSIUotA().customerDownloadFinished(UotAFactory.getSessionManager().getSessionID(), n2, bl);
            if (!bl) {
                ListManager.getGenericASLList(1358762752).updateList(UotAFactory.getPacketListController().getCurrentlyDownloadingPackets(null));
            }
            if (this._target.isTraceEnabled()) {
                this._target.trace().append(this._classname).append(new StringBuffer().append("finish(").append(n).append(")").append("-> ENDED").toString()).log();
                switch (n) {
                    case 914: {
                        this._target.trace().append(this._classname).append("--> INSTALLATION CANCELLED").log();
                        break;
                    }
                    case 915: {
                        this._target.trace().append(this._classname).append("--> INSTALLATION ERROR").log();
                        break;
                    }
                    default: {
                        this._target.trace().append(this._classname).append("--> INSTALLATION FINISHED").log();
                    }
                }
            }
        }
    }

    @Override
    public void reStart() {
    }

    @Override
    public boolean process(int n) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".process(").append(n).append(")").append("-> STARTED").toString()).log();
        }
        switch (n) {
            case 912: {
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append("INSTALL_INITIATE").log();
                }
                this._target.sendHMIEvent(855446272);
                return true;
            }
            case 913: {
                break;
            }
            case 914: {
                break;
            }
            case 915: {
                break;
            }
        }
        return false;
    }
}

