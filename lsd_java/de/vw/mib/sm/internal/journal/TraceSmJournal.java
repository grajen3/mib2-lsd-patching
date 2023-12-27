/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.journal;

import de.vw.mib.sm.internal.ServiceManagerStatemachine;
import de.vw.mib.sm.internal.journal.SmJournalEx;
import de.vw.mib.sm.internal.journal.TraceSmJournalTasks;
import de.vw.mib.timer.TimerManager;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

public final class TraceSmJournal
extends SmJournalEx
implements TraceSmJournalTasks {
    public static final String SYSTEM_PROPERTY;
    private static final String TRACE_CFG;
    private static final String EVENTMAP;
    private static final int TRACE_BLOCK_SIZE;
    private static final int TRACE_BLOCK_COUNT;
    private final short[][] traceBlocks;
    private short[] trace;
    private int traceIndex;
    private int traceBlock;
    private long traceTiming;
    private boolean traceOn;
    private final TimerManager timerManager;
    private int eventSwitch;
    private final int eventStop;
    private final String output;

    public TraceSmJournal(TimerManager timerManager) {
        long l = timerManager.getSystemTimeFrequency();
        this.banner(new StringBuffer().append("Timer Frequence ").append(l).toString());
        int n = TRACE_CFG.indexOf(59, 0);
        int n2 = TRACE_CFG.indexOf(59, n + 1);
        this.eventSwitch = this.getEvent("Start", TRACE_CFG, 0, n);
        this.eventStop = this.getEvent("Stop", TRACE_CFG, n + 1, n2);
        this.output = TRACE_CFG.substring(n2 + 1);
        this.timerManager = timerManager;
        this.traceBlocks = new short[64][];
        this.trace = new short[16384];
        this.traceIndex = -1;
        this.traceBlock = 0;
        this.traceBlocks[this.traceBlock] = this.trace;
        this.traceOn = false;
        this.traceTiming = this.click();
        this.trace((short)1025);
        this.trace[++this.traceIndex] = (short)(l >> 48 & 0);
        this.trace[++this.traceIndex] = (short)(l >> 32 & 0);
        this.trace[++this.traceIndex] = (short)(l >> 16 & 0);
        this.trace[++this.traceIndex] = (short)(l >> 0 & 0);
        this.measureTime();
    }

    private void measureTime() {
        long l = this.timerManager.getSystemTime();
        try {
            Thread.sleep(0);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        l = this.timerManager.getSystemTime() - l;
        this.trace((short)1123);
        this.trace[++this.traceIndex] = (short)(l >> 48 & 0);
        this.trace[++this.traceIndex] = (short)(l >> 32 & 0);
        this.trace[++this.traceIndex] = (short)(l >> 16 & 0);
        this.trace[++this.traceIndex] = (short)(l >> 0 & 0);
    }

    private void banner(String string) {
        this.println("____ _  _    ___ ____ ____ ____ ____ ");
        this.println("[__  |`/|     |  |__/ |__| |    |___ ");
        this.println("___] |  |     |  |  ` |  | |___ |___");
        this.println(string);
        ServiceManagerStatemachine.genericEvents.getServiceRegister().triggerObserver(-2129853696, ServiceManagerStatemachine.eventFactory.newEvent());
    }

    private int getEvent(String string, String string2, int n, int n2) {
        try {
            try {
                String string3 = string2.substring(n, n2);
                Class clazz = Class.forName("generated.de.vw.mib.event.EventMap");
                Field field = clazz.getField(string3);
                int n3 = field.getInt(null);
                this.println(new StringBuffer().append("SM-Journal: Trace ").append(string).append(" = ").append(string3).append(" (").append(n3).append(")").toString());
                return n3;
            }
            catch (ClassNotFoundException classNotFoundException) {
            }
            catch (NoSuchFieldException noSuchFieldException) {
                // empty catch block
            }
            int n4 = Integer.parseInt(string2.substring(n, n2));
            this.println(new StringBuffer().append("SM-Journal: Trace ").append(string).append(" = ").append(n4).toString());
            return n4;
        }
        catch (Exception exception) {
            this.println(new StringBuffer().append("SM-Journal: Trace ").append(string).append(" = -1").toString());
            return -1;
        }
    }

    private void println(String string) {
        System.out.println(string);
        System.out.flush();
    }

    private long click() {
        return this.timerManager.getSystemTime();
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    private void trace(short s) {
        long l = this.click() - this.traceTiming;
        int n = s >> 8 & 0xFF;
        if (this.traceIndex + n + 2 >= 16384) {
            while (this.traceIndex < 16383) {
                this.trace[++this.traceIndex] = 0;
            }
            this.traceIndex = -1;
            ++this.traceBlock;
            if (this.traceBlock == 64) {
                this.trace = new short[n + 1];
                this.traceOn = false;
            } else {
                this.trace = new short[16384];
                this.traceBlocks[this.traceBlock] = this.trace;
            }
        }
        this.trace[++this.traceIndex] = s;
        this.trace[++this.traceIndex] = (short)(l < 0 ? l : (long)0);
        this.traceTiming = this.click();
    }

    @Override
    public void managerStarted() {
    }

    @Override
    public void managerFinished() {
    }

    @Override
    public void eventProcessing(int n, short s) {
        if (n == this.eventSwitch) {
            if (this.traceOn) {
                this.eventSwitch = -1;
                this.traceOn = false;
                this.banner("Trace OFF \b\b");
                this.writeTrace();
            } else {
                this.banner("Trace ON \b");
                this.eventSwitch = this.eventStop;
                this.traceOn = true;
                this.traceTiming = this.click();
            }
        }
        if (this.traceOn) {
            this.trace((short)258);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = s;
        }
    }

    @Override
    public void eventProcessed(int n, boolean bl) {
        if (this.traceOn) {
            this.trace(bl ? (short)4 : 3);
        }
    }

    @Override
    public void eventSkipped(int n) {
        if (this.traceOn) {
            this.trace((short)5);
        }
    }

    @Override
    public void eventForwardingToStatemachine(int n, int n2) {
        if (this.traceOn) {
            this.trace((short)43);
            this.trace[++this.traceIndex] = (short)n2;
        }
    }

    @Override
    public void checkpoint(char c2) {
        if (this.traceOn) {
            this.trace((short)294);
            this.trace[++this.traceIndex] = (short)c2;
        }
    }

    private void writeTrace() {
        block5: {
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(this.output);
                byte[] byArray = new byte[0x800000];
                for (int i2 = 0; i2 < this.traceBlock; ++i2) {
                    this.toBuffer(byArray, this.traceBlocks[i2], 16384);
                    fileOutputStream.write(byArray, 0, 0x800000);
                }
                this.toBuffer(byArray, this.trace, this.traceIndex);
                fileOutputStream.write(byArray, 0, this.traceIndex * 2);
                fileOutputStream.close();
                this.banner(new StringBuffer().append("Log: ").append(this.output).toString());
            }
            catch (Exception exception) {
                if (fileOutputStream == null) break block5;
                try {
                    fileOutputStream.close();
                }
                catch (IOException iOException) {
                    // empty catch block
                }
            }
        }
    }

    private void toBuffer(byte[] byArray, short[] sArray, int n) {
        int n2 = -1;
        for (int i2 = 0; i2 < n; ++i2) {
            byArray[++n2] = (byte)(sArray[i2] >> 8);
            byArray[++n2] = (byte)(sArray[i2] & 0xFF);
        }
    }

    @Override
    public void fatalError(int n, int n2, short s, RuntimeException runtimeException) {
    }

    @Override
    public void activatorChecking(int n) {
        if (this.traceOn) {
            this.trace((short)295);
            this.trace[++this.traceIndex] = (short)n;
        }
    }

    @Override
    public void activatorChecked(int n) {
        if (this.traceOn) {
            this.trace((short)40);
        }
    }

    @Override
    public void deactivatorChecking(int n) {
        if (this.traceOn) {
            this.trace((short)297);
            this.trace[++this.traceIndex] = (short)n;
        }
    }

    @Override
    public void deactivatorChecked(int n) {
        if (this.traceOn) {
            this.trace((short)42);
        }
    }

    @Override
    public void statemachineActivating(int n) {
        if (this.traceOn) {
            this.trace((short)7);
        }
    }

    @Override
    public void statemachineActivated(int n) {
        if (this.traceOn) {
            this.trace((short)8);
        }
    }

    @Override
    public void statemachineDeactivating(int n) {
        if (this.traceOn) {
            this.trace((short)9);
        }
    }

    @Override
    public void statemachineDeactivated(int n) {
        if (this.traceOn) {
            this.trace((short)10);
        }
    }

    @Override
    public void internalTransitionPerforming(int n, int n2, short s, short s2) {
        if (this.traceOn) {
            this.trace((short)783);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
            this.trace[++this.traceIndex] = s;
            this.trace[++this.traceIndex] = s2;
        }
    }

    @Override
    public void internalTransitionActing(int n, int n2, short s, short s2) {
        if (this.traceOn) {
            this.trace((short)16);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
            this.trace[++this.traceIndex] = s;
            this.trace[++this.traceIndex] = s2;
        }
    }

    @Override
    public void internalTransitionActed(int n, int n2, short s, short s2) {
        if (this.traceOn) {
            this.trace((short)17);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
            this.trace[++this.traceIndex] = s;
            this.trace[++this.traceIndex] = s2;
        }
    }

    @Override
    public void internalTransitionPerformed(int n, int n2, short s, short s2, boolean bl) {
        if (this.traceOn) {
            this.trace((short)18);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
            this.trace[++this.traceIndex] = s;
            this.trace[++this.traceIndex] = s2;
        }
    }

    @Override
    public void triggeredTransitionPerforming(int n, int n2, short s, short s2) {
        if (this.traceOn) {
            this.trace((short)787);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
            this.trace[++this.traceIndex] = s;
            this.trace[++this.traceIndex] = s2;
        }
    }

    @Override
    public void triggeredTransitionActing(int n, int n2, short s, short s2) {
        if (this.traceOn) {
            this.trace((short)20);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
            this.trace[++this.traceIndex] = s;
            this.trace[++this.traceIndex] = s2;
        }
    }

    @Override
    public void triggeredTransitionActed(int n, int n2, short s, short s2) {
        if (this.traceOn) {
            this.trace((short)21);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
            this.trace[++this.traceIndex] = s;
            this.trace[++this.traceIndex] = s2;
        }
    }

    @Override
    public void triggeredTransitionPerformed(int n, int n2, short s, short s2, boolean bl) {
        if (this.traceOn) {
            this.trace((short)22);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
            this.trace[++this.traceIndex] = s;
            this.trace[++this.traceIndex] = s2;
        }
    }

    @Override
    public void untriggeredTransitionPerforming(int n, int n2, short s, short s2) {
        if (this.traceOn) {
            this.trace((short)791);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
            this.trace[++this.traceIndex] = s;
            this.trace[++this.traceIndex] = s2;
        }
    }

    @Override
    public void untriggeredTransitionActing(int n, int n2, short s, short s2) {
        if (this.traceOn) {
            this.trace((short)24);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
            this.trace[++this.traceIndex] = s;
            this.trace[++this.traceIndex] = s2;
        }
    }

    @Override
    public void untriggeredTransitionActed(int n, int n2, short s, short s2) {
        if (this.traceOn) {
            this.trace((short)25);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
            this.trace[++this.traceIndex] = s;
            this.trace[++this.traceIndex] = s2;
        }
    }

    @Override
    public void untriggeredTransitionPerformed(int n, int n2, short s, short s2) {
        if (this.traceOn) {
            this.trace((short)26);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
            this.trace[++this.traceIndex] = s;
            this.trace[++this.traceIndex] = s2;
        }
    }

    @Override
    public void subStatemachineActivating(int n, int n2) {
        if (this.traceOn) {
            this.trace((short)267);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
        }
    }

    @Override
    public void subStatemachineActivated(int n, int n2) {
        if (this.traceOn) {
            this.trace((short)12);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
        }
    }

    @Override
    public void subStatemachineDeactivating(int n, int n2) {
        if (this.traceOn) {
            this.trace((short)269);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
        }
    }

    @Override
    public void subStatemachineDeactivated(int n, int n2) {
        if (this.traceOn) {
            this.trace((short)14);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
        }
    }

    @Override
    public void stateEntryActing(int n, int n2, short s, boolean bl) {
        if (this.traceOn) {
            this.trace(bl ? (short)540 : 539);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
            this.trace[++this.traceIndex] = s;
        }
    }

    @Override
    public void stateEntryActed(int n, int n2, short s) {
        if (this.traceOn) {
            this.trace((short)29);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
            this.trace[++this.traceIndex] = s;
        }
    }

    @Override
    public void stateExitActing(int n, int n2, short s) {
        if (this.traceOn) {
            this.trace((short)30);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
            this.trace[++this.traceIndex] = s;
        }
    }

    @Override
    public void stateExitActed(int n, int n2, short s) {
        if (this.traceOn) {
            this.trace((short)31);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
            this.trace[++this.traceIndex] = s;
        }
    }

    @Override
    public void stateFocusGainedActing(int n, int n2, short s) {
        if (this.traceOn) {
            this.trace((short)34);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
            this.trace[++this.traceIndex] = s;
        }
    }

    @Override
    public void stateFocusGainedActed(int n, int n2, short s) {
        if (this.traceOn) {
            this.trace((short)35);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
            this.trace[++this.traceIndex] = s;
        }
    }

    @Override
    public void stateFocusLostActing(int n, int n2, short s) {
        if (this.traceOn) {
            this.trace((short)36);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
            this.trace[++this.traceIndex] = s;
        }
    }

    @Override
    public void stateFocusLostActed(int n, int n2, short s) {
        if (this.traceOn) {
            this.trace((short)37);
            this.trace[++this.traceIndex] = (short)n;
            this.trace[++this.traceIndex] = (short)n2;
            this.trace[++this.traceIndex] = s;
        }
    }

    static {
        TRACE_CFG = System.getProperty("smjournal.tracelog");
    }
}

