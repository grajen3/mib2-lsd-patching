/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.persistence;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.persistence.DSIPersistenceReply;
import de.esolutions.fw.comm.dsi.persistence.impl.DSIPersistenceReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.persistence.DSIPersistenceListener;

public class DSIPersistenceDispatcher
extends AbstractDispatcher
implements DSIPersistenceReply {
    private DSIPersistenceReplyService service = new DSIPersistenceReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$persistence$DSIPersistenceListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIPersistenceDispatcher(int n) {
        super(n, (class$org$dsi$ifc$persistence$DSIPersistenceListener == null ? (class$org$dsi$ifc$persistence$DSIPersistenceListener = DSIPersistenceDispatcher.class$("org.dsi.ifc.persistence.DSIPersistenceListener")) : class$org$dsi$ifc$persistence$DSIPersistenceListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateActiveSQLDatabaseMedium(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)iterator.next();
                    this.confirmNotificationListener(1, dSIPersistenceListener);
                    dSIPersistenceListener.updateActiveSQLDatabaseMedium(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)iterator.next();
                    dSIPersistenceListener.updateActiveSQLDatabaseMedium(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void writeInt(int n, long l, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)objectArray[i2];
                    dSIPersistenceListener.writeInt(n, l, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void readInt(int n, long l, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)objectArray[i2];
                    dSIPersistenceListener.readInt(n, l, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void writeBuffer(int n, long l, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)objectArray[i2];
                    dSIPersistenceListener.writeBuffer(n, l, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void readBuffer(int n, long l, byte[] byArray, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)objectArray[i2];
                    dSIPersistenceListener.readBuffer(n, l, byArray, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void writeString(int n, long l, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)objectArray[i2];
                    dSIPersistenceListener.writeString(n, l, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void readString(int n, long l, String string, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)objectArray[i2];
                    dSIPersistenceListener.readString(n, l, string, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void writeArray(int n, long l, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)objectArray[i2];
                    dSIPersistenceListener.writeArray(n, l, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void readArray(int n, long l, int[] nArray, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)objectArray[i2];
                    dSIPersistenceListener.readArray(n, l, nArray, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void writeStringArray(int n, long l, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)objectArray[i2];
                    dSIPersistenceListener.writeStringArray(n, l, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void readStringArray(int n, long l, String[] stringArray, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)objectArray[i2];
                    dSIPersistenceListener.readStringArray(n, l, stringArray, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getVisibleSystemLanguages(String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)objectArray[i2];
                    dSIPersistenceListener.getVisibleSystemLanguages(string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void flushSQLDatabase(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)objectArray[i2];
                    dSIPersistenceListener.flushSQLDatabase(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void beginTransaction(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)objectArray[i2];
                    dSIPersistenceListener.beginTransaction(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void endTransaction(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)objectArray[i2];
                    dSIPersistenceListener.endTransaction(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void valueChangedInt(int n, long l, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)objectArray[i2];
                    dSIPersistenceListener.valueChangedInt(n, l, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void valueChangedString(int n, long l, String string, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)objectArray[i2];
                    dSIPersistenceListener.valueChangedString(n, l, string, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void valueChangedArray(int n, long l, int[] nArray, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)objectArray[i2];
                    dSIPersistenceListener.valueChangedArray(n, l, nArray, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void valueChangedStringArray(int n, long l, String[] stringArray, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)objectArray[i2];
                    dSIPersistenceListener.valueChangedStringArray(n, l, stringArray, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void valueChangedBuffer(int n, long l, byte[] byArray, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)objectArray[i2];
                    dSIPersistenceListener.valueChangedBuffer(n, l, byArray, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void unsubscribe(int n, int[] nArray, long[] lArray, int[] nArray2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)objectArray[i2];
                    dSIPersistenceListener.unsubscribe(n, nArray, lArray, nArray2);
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
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)objectArray[i2];
                    dSIPersistenceListener.asyncException(n, string, n2);
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
                    DSIPersistenceListener dSIPersistenceListener = (DSIPersistenceListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIPersistenceDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIPersistenceDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIPersistenceListener, new Object[]{string, string2});
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

