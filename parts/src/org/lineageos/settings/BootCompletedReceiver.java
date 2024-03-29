/*
 * Copyright (C) 2023 LineageOS Project
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.lineageos.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import org.lineageos.settings.refreshrate.RefreshUtils;
import org.lineageos.settings.thermal.ThermalUtils;

public class BootCompletedReceiver extends BroadcastReceiver {

    private static final String TAG = "XiaomiParts";
    private static final boolean DEBUG = true;

    @Override
    public void onReceive(final Context context, Intent intent) {
        if (!intent.getAction().equals(Intent.ACTION_LOCKED_BOOT_COMPLETED)) {
            return;
        }
        if (DEBUG) Log.d(TAG, "Received boot completed intent");

        // Refreshrate
        RefreshUtils.startService(context);

        // Thermal
        ThermalUtils.startService(context);
    }
}
