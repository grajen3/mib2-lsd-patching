/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.uota.sequence;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.common.uota.OnlineUotAPackage;
import de.vw.mib.asl.internal.online.uota.UotAFactory;
import de.vw.mib.asl.internal.online.uota.common.UotAConstants;
import de.vw.mib.asl.internal.online.uota.sequence.UotASequence;
import de.vw.mib.asl.internal.online.uota.states.UotATarget;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.uota.DSIUotA;

public class UotADownload
implements UotASequence {
    private final String _classname = super.getClass().getName();
    private final UotATarget _target;
    private OnlineUotAPackage _currentPacket;
    private final OnlineUotAPackage[] _packets;

    public UotADownload(UotATarget uotATarget, OnlineUotAPackage[] onlineUotAPackageArray) {
        this._target = uotATarget;
        this._packets = onlineUotAPackageArray;
        this._currentPacket = null;
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(" -->DOWNLOAD STARTED").log();
        }
    }

    public UotADownload(UotATarget uotATarget, OnlineUotAPackage onlineUotAPackage) {
        this._target = uotATarget;
        this._currentPacket = onlineUotAPackage;
        this._packets = null;
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(" -->DOWNLOAD STARTED").log();
        }
    }

    private OnlineUotAPackage getCurrentPacket() {
        return this._currentPacket;
    }

    private OnlineUotAPackage[] getCurrentPacketList() {
        return this._packets;
    }

    @Override
    public void start() {
        DSIUotA dSIUotA;
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".start()-> STARTED").log();
        }
        if ((dSIUotA = this._target.getDSIUotA()) != null) {
            dSIUotA.startDownload(UotAFactory.getSessionManager().getSessionID());
        }
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".start()-> ENDED").log();
        }
    }

    @Override
    public void stop() {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".stop()-> STARTED").log();
        }
        if (!Util.isNullOrEmpty(this._packets)) {
            int n = this.getCurrentPacketList().length;
            for (int i2 = 0; i2 < n; ++i2) {
                this.getCurrentPacketList()[i2].reset();
            }
            DSIUotA dSIUotA = this._target.getDSIUotA();
            if (dSIUotA != null) {
                dSIUotA.abortDownload(UotAFactory.getSessionManager().getSessionID());
            }
        } else {
            if (this.getCurrentPacket() != null) {
                this.getCurrentPacket().setPackageEnabled(true);
                DSIUotA dSIUotA = this._target.getDSIUotA();
                if (dSIUotA != null) {
                    dSIUotA.abortDownload(UotAFactory.getSessionManager().getSessionID());
                }
            } else {
                this._target.info().append(this._classname).append(".stop()->package is not valid").log();
            }
            this.getCurrentPacket().reset();
        }
        ListManager.getGenericASLList(1325208320).updateList(UotAConstants.EMPTY_PACKAGE_LIST);
        ListManager.getGenericASLList(1358762752).updateList(UotAFactory.getPacketListController().getCurrentlyDownloadingPackets(null));
        this._target.getPropertyManager().setTogglePacketArray(null);
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".stop()-> ENDED").log();
            this._target.trace().append(this._classname).append("DOWNLOAD STOPPED").log();
        }
    }

    @Override
    public void finish(int n) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append("finish(").append(n).append(")").append("-> STARTED").toString()).log();
        }
        ServiceManager.aslPropertyManager.valueChangedString(855446272, this.getCurrentPacket().getLabel());
        DSIUotA dSIUotA = this._target.getDSIUotA();
        if (dSIUotA != null) {
            dSIUotA.getAttribute(UotAFactory.getSessionManager().getSessionID(), 1);
        }
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append("finish(").append(n).append(")").append("-> ENDED").toString()).log();
            this._target.trace().append(this._classname).append("DOWNLOAD FINISHED").log();
        }
    }

    @Override
    public void reStart() {
    }

    @Override
    public boolean process(int n) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".process(").append(n).append(")").toString()).log();
        }
        block0 : switch (n) {
            case 907: {
                if (!this._target.isTraceEnabled()) break;
                this._target.trace().append("DOWNLOAD_START").log();
                break;
            }
            case 906: {
                DSIUotA dSIUotA;
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append("DOWNLOAD_TOGGLE").log();
                }
                if ((dSIUotA = this._target.getDSIUotA()) == null) break;
                dSIUotA.startDownload(UotAFactory.getSessionManager().getSessionID());
                break;
            }
            case 908: {
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append("DOWNLOAD_CANCEL").log();
                }
                this.stop();
                break;
            }
            case 909: {
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append("DOWNLOAD_STATE").log();
                }
                int n2 = this._target.getPropertyManager().getDownloadState();
                ServiceManager.aslPropertyManager.valueChangedInteger(1107104512, 0);
                switch (n2) {
                    case 0: {
                        if (!this._target.isTraceEnabled()) break block0;
                        this._target.trace().append("STATE_DOWNLOAD_NOT_ACTIVE").log();
                        break;
                    }
                    case 1: {
                        if (this._target.isTraceEnabled()) {
                            this._target.trace().append("STATE_DOWNLOAD_ACTIVE").log();
                        }
                        ServiceManager.aslPropertyManager.valueChangedInteger(1107104512, 1);
                        break;
                    }
                    case 4: {
                        if (this._target.isTraceEnabled()) {
                            this._target.trace().append("STATE_DOWNLOAD_WAIT_FOR_PDD").log();
                        }
                        ServiceManager.aslPropertyManager.valueChangedInteger(1107104512, 1);
                        break;
                    }
                    case 2: {
                        DSIUotA dSIUotA;
                        if (this._target.isTraceEnabled()) {
                            this._target.trace().append("STATE_DOWNLOAD_FINISHED").log();
                        }
                        if ((dSIUotA = this._target.getDSIUotA()) != null) {
                            dSIUotA.getAttribute(UotAFactory.getSessionManager().getSessionID(), 1);
                        }
                        if (this._target.isTraceEnabled()) {
                            this._target.trace().append(this._classname).append("-->DOWNLOAD FINISHED").log();
                        }
                        this._target.getPropertyManager().setProgress(0, 0, "");
                        break;
                    }
                    case 3: {
                        if (this._target.isTraceEnabled()) {
                            this._target.trace().append("STATE_DOWNLOAD_ERROR_CANCELED_BY_USER").log();
                        }
                        this._target.getPropertyManager().setProgress(0, 0, "");
                        UotAFactory.getErrorHandler().sendDownloadFailure(3);
                        break;
                    }
                    case 10: {
                        if (this._target.isTraceEnabled()) {
                            this._target.trace().append("STATE_ERROR").log();
                        }
                        this._target.getPropertyManager().setProgress(0, 0, "");
                        UotAFactory.getErrorHandler().sendDownloadFailure(10);
                        break;
                    }
                    case 11: {
                        if (this._target.isTraceEnabled()) {
                            this._target.trace().append("STATE_DOWNLOAD_ERROR").log();
                        }
                        this._target.getPropertyManager().setProgress(0, 0, "");
                        UotAFactory.getErrorHandler().sendDownloadFailure(11);
                        break;
                    }
                    case 12: 
                    case 13: {
                        if (this._target.isTraceEnabled()) {
                            this._target.trace().append("STATE_ERROR_CONNECTION_FAILURE").log();
                        }
                        this._target.getPropertyManager().setProgress(0, 0, "");
                        UotAFactory.getErrorHandler().sendDownloadFailure(13);
                        break;
                    }
                }
                break;
            }
            case 910: {
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append("DOWNLOAD_PROGRESS").log();
                }
                if (this._currentPacket == null || this._target.getPropertyManager().getDownloadProgress() == 0) {
                    this._currentPacket = this._target.getPropertyManager().getCurrentPacket();
                }
                switch (this._target.getPropertyManager().getDownloadKind()) {
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: {
                        if (this.getCurrentPacket() != null) {
                            this.getCurrentPacket().setProgressState(this._target.getPropertyManager().getDownloadProgress());
                            ListManager.getGenericASLList(1358762752).updateList(UotAFactory.getPacketListController().getCurrentlyDownloadingPackets(this.getCurrentPacket()));
                            break block0;
                        }
                        this._target.info().append("Packet is not valid in progress state").log();
                        break block0;
                    }
                    case 0: {
                        break block0;
                    }
                    case 5: {
                        break block0;
                    }
                }
                break;
            }
            default: {
                return false;
            }
        }
        return true;
    }
}

