/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.audio;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.audio.DSISoundReply;
import de.esolutions.fw.comm.dsi.audio.impl.DSISoundReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.audio.AmplifierCapabilities;
import org.dsi.ifc.audio.DSISoundListener;

public class DSISoundDispatcher
extends AbstractDispatcher
implements DSISoundReply {
    private DSISoundReplyService service = new DSISoundReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISoundListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSISoundDispatcher(int n) {
        super(n, (class$org$dsi$ifc$audio$DSISoundListener == null ? (class$org$dsi$ifc$audio$DSISoundListener = DSISoundDispatcher.class$("org.dsi.ifc.audio.DSISoundListener")) : class$org$dsi$ifc$audio$DSISoundListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void inputGainOffsetRange(int n, int n2, int n3, int n4) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)objectArray[i2];
                    dSISoundListener.inputGainOffsetRange(n, n2, n3, n4);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void menuVolEntRange(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)objectArray[i2];
                    dSISoundListener.menuVolEntRange(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void menuVolumeRange(int n, int n2, int n3, int n4) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)objectArray[i2];
                    dSISoundListener.menuVolumeRange(n, n2, n3, n4);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void volumeRange(int n, int n2, int n3, int n4, int n5) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)objectArray[i2];
                    dSISoundListener.volumeRange(n, n2, n3, n4, n5);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSurroundOnOff(int n, int n2, boolean bl, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(49, dSISoundListener);
                    dSISoundListener.updateSurroundOnOff(n, n2, bl, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateSurroundOnOff(n, n2, bl, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBalance(int n, int n2, short s, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(2, dSISoundListener);
                    dSISoundListener.updateBalance(n, n2, s, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateBalance(n, n2, s, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBalanceRange(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(3, dSISoundListener);
                    dSISoundListener.updateBalanceRange(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateBalanceRange(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBass(int n, int n2, short s, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(4, dSISoundListener);
                    dSISoundListener.updateBass(n, n2, s, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateBass(n, n2, s, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBassRange(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(5, dSISoundListener);
                    dSISoundListener.updateBassRange(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateBassRange(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void createExportFileResult(int n, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)objectArray[i2];
                    dSISoundListener.createExportFileResult(n, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateFader(int n, int n2, short s, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(9, dSISoundListener);
                    dSISoundListener.updateFader(n, n2, s, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateFader(n, n2, s, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateFaderRange(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(10, dSISoundListener);
                    dSISoundListener.updateFaderRange(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateFaderRange(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void importFileResponse(int n, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)objectArray[i2];
                    dSISoundListener.importFileResponse(n, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateInputGainOffset(int n, int n2, short s, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(12, dSISoundListener);
                    dSISoundListener.updateInputGainOffset(n, n2, s, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateInputGainOffset(n, n2, s, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLoweringEntertainment(int n, int n2, int n3, short s, int n4) {
        if ((n4 & 0x80) == 128) {
            n4 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(13, dSISoundListener);
                    dSISoundListener.updateLoweringEntertainment(n, n2, n3, s, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateLoweringEntertainment(n, n2, n3, s, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMutePinState(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(14, dSISoundListener);
                    dSISoundListener.updateMutePinState(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateMutePinState(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSubwoofer(int n, int n2, short s, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(17, dSISoundListener);
                    dSISoundListener.updateSubwoofer(n, n2, s, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateSubwoofer(n, n2, s, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSubwooferRange(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(18, dSISoundListener);
                    dSISoundListener.updateSubwooferRange(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateSubwooferRange(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSurrLevelRange(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(19, dSISoundListener);
                    dSISoundListener.updateSurrLevelRange(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateSurrLevelRange(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSurroundLevel(int n, int n2, short s, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(20, dSISoundListener);
                    dSISoundListener.updateSurroundLevel(n, n2, s, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateSurroundLevel(n, n2, s, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTreble(int n, int n2, short s, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(21, dSISoundListener);
                    dSISoundListener.updateTreble(n, n2, s, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateTreble(n, n2, s, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTrebleRange(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(22, dSISoundListener);
                    dSISoundListener.updateTrebleRange(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateTrebleRange(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVolume(int n, int n2, short s, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(24, dSISoundListener);
                    dSISoundListener.updateVolume(n, n2, s, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateVolume(n, n2, s, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVolumeRange(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(26, dSISoundListener);
                    dSISoundListener.updateVolumeRange(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateVolumeRange(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMiddle(int n, int n2, short s, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(27, dSISoundListener);
                    dSISoundListener.updateMiddle(n, n2, s, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateMiddle(n, n2, s, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMiddleRange(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(28, dSISoundListener);
                    dSISoundListener.updateMiddleRange(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateMiddleRange(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEqualizerRange(int n, int n2, int[] nArray, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(31, dSISoundListener);
                    dSISoundListener.updateEqualizerRange(n, n2, nArray, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateEqualizerRange(n, n2, nArray, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEqualizer(int[] nArray, int[] nArray2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(32, dSISoundListener);
                    dSISoundListener.updateEqualizer(nArray, nArray2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateEqualizer(nArray, nArray2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateOnVolumeLimit(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(33, dSISoundListener);
                    dSISoundListener.updateOnVolumeLimit(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateOnVolumeLimit(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateOnVolumeLimitRange(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(34, dSISoundListener);
                    dSISoundListener.updateOnVolumeLimitRange(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateOnVolumeLimitRange(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateActiveAmplifierCapabilities(AmplifierCapabilities amplifierCapabilities, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(35, dSISoundListener);
                    dSISoundListener.updateActiveAmplifierCapabilities(amplifierCapabilities, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateActiveAmplifierCapabilities(amplifierCapabilities, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMuteTheftProtection(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(36, dSISoundListener);
                    dSISoundListener.updateMuteTheftProtection(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateMuteTheftProtection(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMicGainLevel(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(37, dSISoundListener);
                    dSISoundListener.updateMicGainLevel(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateMicGainLevel(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVolumeFocus(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(38, dSISoundListener);
                    dSISoundListener.updateVolumeFocus(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateVolumeFocus(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNoiseCompensation(int n, int n2, short s, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(39, dSISoundListener);
                    dSISoundListener.updateNoiseCompensation(n, n2, s, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateNoiseCompensation(n, n2, s, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNoiseCompensationRange(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(47, dSISoundListener);
                    dSISoundListener.updateNoiseCompensationRange(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateNoiseCompensationRange(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateThreeDMode(int n, int n2, int n3, int n4) {
        if ((n4 & 0x80) == 128) {
            n4 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(50);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(50, dSISoundListener);
                    dSISoundListener.updateThreeDMode(n, n2, n3, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(50);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateThreeDMode(n, n2, n3, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateThreeDModeRange(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(51);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(51, dSISoundListener);
                    dSISoundListener.updateThreeDModeRange(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(51);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateThreeDModeRange(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePresetPosition(int n, int n2, int n3, int n4) {
        if ((n4 & 0x80) == 128) {
            n4 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(42, dSISoundListener);
                    dSISoundListener.updatePresetPosition(n, n2, n3, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updatePresetPosition(n, n2, n3, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePresetPositionList(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(44, dSISoundListener);
                    dSISoundListener.updatePresetPositionList(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updatePresetPositionList(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePresetEQList(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(45, dSISoundListener);
                    dSISoundListener.updatePresetEQList(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updatePresetEQList(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePresetEQ(int n, int n2, int n3, int n4) {
        if ((n4 & 0x80) == 128) {
            n4 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(43, dSISoundListener);
                    dSISoundListener.updatePresetEQ(n, n2, n3, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updatePresetEQ(n, n2, n3, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSubwooferActivity(int n, int n2, boolean bl, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(48, dSISoundListener);
                    dSISoundListener.updateSubwooferActivity(n, n2, bl, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateSubwooferActivity(n, n2, bl, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseWidebandSpeech(int n, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)objectArray[i2];
                    dSISoundListener.responseWidebandSpeech(n, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSoundShapeActive(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(52);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(52, dSISoundListener);
                    dSISoundListener.updateSoundShapeActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(52);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateSoundShapeActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSoundShape(short s, short s2, short s3, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(53);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(53, dSISoundListener);
                    dSISoundListener.updateSoundShape(s, s2, s3, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(53);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateSoundShape(s, s2, s3, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSoundShapeRange(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        if ((n7 & 0x80) == 128) {
            n7 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(54);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(54, dSISoundListener);
                    dSISoundListener.updateSoundShapeRange(n, n2, n3, n4, n5, n6, n7);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(54);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateSoundShapeRange(n, n2, n3, n4, n5, n6, n7);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateICCAvailable(boolean bl, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(55);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(55, dSISoundListener);
                    dSISoundListener.updateICCAvailable(bl, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(55);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateICCAvailable(bl, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(56);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    this.confirmNotificationListener(56, dSISoundListener);
                    dSISoundListener.updateProfileState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(56);
            while (iterator.hasNext()) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)iterator.next();
                    dSISoundListener.updateProfileState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileChanged(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)objectArray[i2];
                    dSISoundListener.profileChanged(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)objectArray[i2];
                    dSISoundListener.profileCopied(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileReset(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)objectArray[i2];
                    dSISoundListener.profileReset(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileResetAll(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)objectArray[i2];
                    dSISoundListener.profileResetAll(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)objectArray[i2];
                    dSISoundListener.asyncException(n, string, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void yyIndication(String string, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISoundListener dSISoundListener = (DSISoundListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSISoundDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSISoundDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSISoundListener, new Object[]{string, string2});
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

