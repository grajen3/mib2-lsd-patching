/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel.lock;

import de.vw.mib.asl.api.system.input.UserInteractionLockService;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.keypanel.lock.DsiKeyDescriptor;
import de.vw.mib.asl.internal.system.keypanel.lock.KeyLockManager;
import de.vw.mib.asl.internal.system.keypanel.lock.KeyLockService;
import de.vw.mib.asl.internal.system.keypanel.lock.KeyLockServiceImpl$1;
import de.vw.mib.asl.internal.system.keypanel.lock.KeyState;
import de.vw.mib.asl.internal.system.keypanel.lock.LockStateListener;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.asl.internal.system.util.SystemKeyUtil;
import de.vw.mib.log4mib.Logger;
import java.util.HashMap;
import java.util.Iterator;

public class KeyLockServiceImpl
implements KeyLockService {
    private final Logger logger;
    private final KeyLockManager keyLockManager;
    private final SystemKeyUtil systemKeyUtil;
    private final HashMap keyEventHashMap = new HashMap();
    private UserInteractionLockService userInteractionLockService;

    public KeyLockServiceImpl(SystemServices systemServices, SystemKeyUtil systemKeyUtil) {
        Preconditions.checkArgumentNotNull(systemServices);
        Preconditions.checkArgumentNotNull(systemKeyUtil);
        this.logger = systemServices.getAsl1Logger();
        this.systemKeyUtil = systemKeyUtil;
        this.keyLockManager = systemServices.getKeyLockManager();
        this.userInteractionLockService = systemServices.getUserInteractionLockService();
        this.keyLockManager.addListener(this.createLockStateListener());
    }

    @Override
    public void processKeyEvent(int n, int n2, int n3) {
        boolean bl;
        DsiKeyDescriptor dsiKeyDescriptor = new DsiKeyDescriptor(n2, n);
        boolean bl2 = bl = this.keyLockManager.isLocked(n, n2) && !this.isSpecialHardKey(n2, n3);
        if (bl) {
            if (this.isTraceEnabled()) {
                this.logTrace(new StringBuffer().append("The keyboard id >").append(n).append("< is locked.").toString());
            }
            this.userInteractionLockService.onUserInteraction();
            this.storeCurrentKeyEvent(dsiKeyDescriptor, new KeyState(n3, true));
        } else if (this.checkIsKeyLocked(n, n2) || this.isSpecialHardKey(n2, n3)) {
            this.storeCurrentKeyEvent(dsiKeyDescriptor, new KeyState(n3, false));
            this.systemKeyUtil.createAndSubmitHardkeyEvent(n, n2, n3);
        } else {
            this.removeCurrentKeyEvent(dsiKeyDescriptor, n3);
        }
    }

    void updateKeyLockState() {
        Iterator iterator = this.keyEventHashMap.keySet().iterator();
        while (iterator.hasNext()) {
            DsiKeyDescriptor dsiKeyDescriptor = (DsiKeyDescriptor)iterator.next();
            KeyState keyState = (KeyState)this.keyEventHashMap.get(dsiKeyDescriptor);
            if (keyState.islocked() || !this.keyLockManager.isLocked(dsiKeyDescriptor.getKeyboardId(), dsiKeyDescriptor.getDsiKey())) continue;
            this.simulateReleaseEvent(dsiKeyDescriptor, keyState.getKeyPressState());
        }
    }

    private LockStateListener createLockStateListener() {
        return new KeyLockServiceImpl$1(this);
    }

    private boolean checkIsKeyLocked(int n, int n2) {
        DsiKeyDescriptor dsiKeyDescriptor = new DsiKeyDescriptor(n2, n);
        KeyState keyState = (KeyState)this.keyEventHashMap.get(dsiKeyDescriptor);
        return !this.keyEventHashMap.containsKey(dsiKeyDescriptor) || !keyState.islocked();
    }

    private void simulateReleaseEvent(DsiKeyDescriptor dsiKeyDescriptor, int n) {
        int n2 = this.transformPressEventToReleaseEvent(n);
        if (n2 != -1) {
            this.systemKeyUtil.createAndSubmitHardkeyEvent(dsiKeyDescriptor.getKeyboardId(), dsiKeyDescriptor.getDsiKey(), n2);
            this.removeCurrentKeyEvent(dsiKeyDescriptor, n);
        }
    }

    private int transformPressEventToReleaseEvent(int n) {
        switch (n) {
            case 1: {
                return 0;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 101: {
                return 100;
            }
        }
        this.logger.warn(2048).append("Unsupported key state: ").append(n).log();
        return -1;
    }

    private boolean isSpecialHardKey(int n, int n2) {
        return !(n != 78 && n != 6 || n2 != 4 && n2 != 3);
    }

    private void storeCurrentKeyEvent(DsiKeyDescriptor dsiKeyDescriptor, KeyState keyState) {
        if (this.checkIsPressState(keyState.getKeyPressState())) {
            this.keyEventHashMap.put(dsiKeyDescriptor, keyState);
        } else {
            this.removeCurrentKeyEvent(dsiKeyDescriptor, keyState.getKeyPressState());
        }
    }

    private boolean checkIsPressState(int n) {
        return n == 1 || n == 3 || n == 4 || n == 2 || n == 5 || n == 101;
    }

    private void removeCurrentKeyEvent(DsiKeyDescriptor dsiKeyDescriptor, int n) {
        if (!this.checkIsPressState(n)) {
            this.keyEventHashMap.remove(dsiKeyDescriptor);
        }
    }

    private boolean isTraceEnabled() {
        return this.logger.isTraceEnabled(2048);
    }

    private void logTrace(String string) {
        this.logger.trace(2048, new StringBuffer().append("[KeyLockService] ").append(string).toString());
    }
}

