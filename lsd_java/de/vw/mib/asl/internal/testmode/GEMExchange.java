/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.testmode.TargetGEM;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.persistence.DSIPersistence;
import org.dsi.ifc.persistence.DSIPersistenceListener;

public final class GEMExchange
implements DSIPersistence {
    private DSIPersistenceListener mListener = null;
    private Logger mLogger = ServiceManager.logger;
    private static final byte[] DEFAULT_BYTE_ARR = new byte[0];
    private static final int DEFAULT_INT;
    private static final int[] DEFAULT_INT_ARR;
    private static final String DEFAULT_STRING;
    private static final String[] DEFAULT_STRING_ARR;
    private TargetGEM targetGEM = TargetGEM.getInstance();
    private static final String LOGGING_DELIM;

    private void errorNoListenerSet() {
        this.mLogger.error(64).append("[GEMExchange] ").append("no Listener set").log();
    }

    private void errorWrongNamespace(int n, long l) {
        this.mLogger.error(64).append("[GEMExchange] ").append("Wrong namespace requested: (namespace/key) (").append(n).append(" / ").append(l).append(")").log();
    }

    private void errorWrongKey(int n, long l) {
        this.mLogger.error(64).append("[GEMExchange] ").append("Wrong key requested: (namespace/key) (").append(n).append(" / ").append(l).append(")").log();
    }

    @Override
    public void readBuffer(int n, long l) {
        if (this.mListener != null) {
            if (n == -553599487) {
                byte[] byArray = DEFAULT_BYTE_ARR;
                boolean bl = false;
                switch ((int)l) {
                    default: 
                }
                if (bl) {
                    this.mListener.readBuffer(n, l, byArray, 0);
                } else {
                    this.errorWrongKey(n, l);
                    this.mListener.readBuffer(n, l, DEFAULT_BYTE_ARR, 2);
                }
            } else {
                this.errorWrongNamespace(n, l);
                this.mListener.readBuffer(n, l, DEFAULT_BYTE_ARR, 1);
            }
        } else {
            this.errorNoListenerSet();
        }
    }

    @Override
    public void readInt(int n, long l) {
        if (this.mListener != null) {
            if (n == -553599487) {
                int n2 = 0;
                boolean bl = true;
                switch ((int)l) {
                    case 302: {
                        n2 = this.targetGEM.getSdsHmiTtsChannel();
                        break;
                    }
                    case 307: {
                        n2 = this.targetGEM.getSdsEnableVoiceBargeIn();
                        break;
                    }
                    case 306: {
                        n2 = this.targetGEM.getSdsEnablePttBargeIn();
                        break;
                    }
                    case 801: {
                        n2 = this.targetGEM.getTvEnableTunerTestmode();
                        break;
                    }
                    case 401: {
                        n2 = this.targetGEM.getBtAuthActivate();
                        break;
                    }
                    case 220: {
                        n2 = this.targetGEM.getNavOverwriteEnableOnlineFeatures();
                        break;
                    }
                    case 502: {
                        n2 = this.targetGEM.getCarEcoAvgShort();
                        break;
                    }
                    case 503: {
                        n2 = this.targetGEM.getCarEcoVehlCrtAccel();
                        break;
                    }
                    default: {
                        bl = false;
                    }
                }
                if (bl) {
                    this.mListener.readInt(n, l, n2, 0);
                } else {
                    this.errorWrongKey(n, l);
                    this.mListener.readInt(n, l, 0, 2);
                }
            } else {
                this.errorWrongNamespace(n, l);
                this.mListener.readInt(n, l, 0, 1);
            }
        } else {
            this.errorNoListenerSet();
        }
    }

    @Override
    public void readArray(int n, long l) {
        if (this.mListener != null) {
            if (n == -553599487) {
                int[] nArray = DEFAULT_INT_ARR;
                boolean bl = false;
                switch ((int)l) {
                    default: 
                }
                if (bl) {
                    this.mListener.readArray(n, l, nArray, 0);
                } else {
                    this.errorWrongKey(n, l);
                    this.mListener.readArray(n, l, DEFAULT_INT_ARR, 2);
                }
            } else {
                this.errorWrongNamespace(n, l);
                this.mListener.readArray(n, l, DEFAULT_INT_ARR, 1);
            }
        } else {
            this.errorNoListenerSet();
        }
    }

    @Override
    public void readString(int n, long l) {
        if (this.mListener != null) {
            if (n == -553599487) {
                String string = "";
                boolean bl = true;
                switch ((int)l) {
                    case 10: {
                        string = this.targetGEM.getHmiLanguage();
                        break;
                    }
                    case 501: {
                        string = this.targetGEM.getCarEcoCurrentDrivingState();
                        break;
                    }
                    default: {
                        bl = false;
                    }
                }
                if (bl) {
                    this.mListener.readString(n, l, string, 0);
                } else {
                    this.errorWrongKey(n, l);
                    this.mListener.readString(n, l, "", 2);
                }
            } else {
                this.errorWrongNamespace(n, l);
                this.mListener.readString(n, l, "", 1);
            }
        } else {
            this.errorNoListenerSet();
        }
    }

    @Override
    public void readStringArray(int n, long l) {
        if (this.mListener != null) {
            if (n == -553599487) {
                String[] stringArray = DEFAULT_STRING_ARR;
                boolean bl = false;
                switch ((int)l) {
                    default: 
                }
                if (bl) {
                    this.mListener.readStringArray(n, l, stringArray, 0);
                } else {
                    this.errorWrongKey(n, l);
                    this.mListener.readStringArray(n, l, DEFAULT_STRING_ARR, 2);
                }
            } else {
                this.errorWrongNamespace(n, l);
                this.mListener.readStringArray(n, l, DEFAULT_STRING_ARR, 1);
            }
        } else {
            this.errorNoListenerSet();
        }
    }

    @Override
    public void writeBuffer(int n, long l, byte[] byArray) {
        if (this.mListener != null) {
            if (n == -553599487) {
                boolean bl = false;
                switch ((int)l) {
                    default: 
                }
                if (bl) {
                    this.mListener.writeBuffer(n, l, 0);
                } else {
                    this.errorWrongKey(n, l);
                    this.mListener.writeBuffer(n, l, 2);
                }
            } else {
                this.errorWrongNamespace(n, l);
                this.mListener.writeBuffer(n, l, 1);
            }
        } else {
            this.errorNoListenerSet();
        }
    }

    @Override
    public void writeInt(int n, long l, int n2) {
        if (this.mListener != null) {
            if (n == -553599487) {
                boolean bl = true;
                switch ((int)l) {
                    case 302: {
                        this.targetGEM.setSdsHmiTtsChannel(n2);
                        break;
                    }
                    case 307: {
                        this.targetGEM.setSdsEnableVoiceBargeIn(n2 == 1);
                        break;
                    }
                    case 306: {
                        this.targetGEM.setSdsEnablePttBargeIn(n2 == 1);
                        break;
                    }
                    case 801: {
                        this.targetGEM.setTvEnableTunerTestmode(n2 == 1);
                        break;
                    }
                    case 401: {
                        this.targetGEM.setBtAuthActivate(n2 == 1);
                        break;
                    }
                    case 220: {
                        this.targetGEM.toggleNavOverwriteEnableOnlineFeatures();
                        break;
                    }
                    default: {
                        bl = false;
                    }
                }
                if (bl) {
                    this.mListener.writeInt(n, l, 0);
                } else {
                    this.errorWrongKey(n, l);
                    this.mListener.writeInt(n, l, 2);
                }
            } else {
                this.errorWrongNamespace(n, l);
                this.mListener.writeInt(n, l, 1);
            }
        } else {
            this.errorNoListenerSet();
        }
    }

    @Override
    public void writeArray(int n, long l, int[] nArray) {
        if (this.mListener != null) {
            if (n == -553599487) {
                boolean bl = false;
                switch ((int)l) {
                    default: 
                }
                if (bl) {
                    this.mListener.writeArray(n, l, 0);
                } else {
                    this.errorWrongKey(n, l);
                    this.mListener.writeArray(n, l, 2);
                }
            } else {
                this.errorWrongNamespace(n, l);
                this.mListener.writeArray(n, l, 1);
            }
        } else {
            this.errorNoListenerSet();
        }
    }

    @Override
    public void writeString(int n, long l, String string) {
        if (this.mListener != null) {
            if (n == -553599487) {
                boolean bl = false;
                switch ((int)l) {
                    default: 
                }
                if (bl) {
                    this.mListener.writeString(n, l, 0);
                } else {
                    this.errorWrongKey(n, l);
                    this.mListener.writeString(n, l, 2);
                }
            } else {
                this.errorWrongNamespace(n, l);
                this.mListener.writeString(n, l, 1);
            }
        } else {
            this.errorNoListenerSet();
        }
    }

    @Override
    public void writeStringArray(int n, long l, String[] stringArray) {
        if (this.mListener != null) {
            if (n == -553599487) {
                boolean bl = false;
                switch ((int)l) {
                    default: 
                }
                if (bl) {
                    this.mListener.writeStringArray(n, l, 0);
                } else {
                    this.errorWrongKey(n, l);
                    this.mListener.writeStringArray(n, l, 2);
                }
            } else {
                this.errorWrongNamespace(n, l);
                this.mListener.writeStringArray(n, l, 1);
            }
        } else {
            this.errorNoListenerSet();
        }
    }

    @Override
    public void enterEngineeringSession(int n) {
        if (this.mLogger.isTraceEnabled(64)) {
            this.mLogger.trace(64).append("[GEMExchange] ").append("enterEngineeringSession (").append(n).append(")").log();
        }
    }

    @Override
    public void exitEngineeringSession(int n) {
        if (this.mLogger.isTraceEnabled(64)) {
            this.mLogger.trace(64).append("[GEMExchange] ").append("exitEngineeringSession (").append(n).append(")").log();
        }
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.clearNotification(dSIListener);
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.clearNotification(dSIListener);
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.mListener = null;
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.setNotification(dSIListener);
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.setNotification(dSIListener);
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        if (dSIListener instanceof DSIPersistenceListener) {
            this.mListener = (DSIPersistenceListener)dSIListener;
        }
    }

    @Override
    public void setSQLDatabaseMedium(int n) {
    }

    @Override
    public void beginTransaction(int n) {
    }

    @Override
    public void endTransaction(int n, boolean bl) {
    }

    @Override
    public void flushSQLDatabase() {
    }

    @Override
    public void getVisibleSystemLanguages() {
    }

    @Override
    public void readArrayTimeout(int n, long l, int n2) {
    }

    @Override
    public void readBufferTimeout(int n, long l, int n2) {
    }

    @Override
    public void readIntTimeout(int n, long l, int n2) {
    }

    @Override
    public void readStringArrayTimeout(int n, long l, int n2) {
    }

    @Override
    public void readStringTimeout(int n, long l, int n2) {
    }

    @Override
    public void subscribe(int n, int[] nArray, long[] lArray, int n2) {
    }

    @Override
    public void unsubscribe(int n, int[] nArray, long[] lArray) {
    }

    @Override
    public void unsubscribeAll(int n) {
    }

    static {
        DEFAULT_INT_ARR = new int[0];
        DEFAULT_STRING_ARR = new String[0];
    }
}

