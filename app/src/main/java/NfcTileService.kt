package com.harriswong.nfcshortcut;

import android.app.PendingIntent
import android.content.Intent
import android.provider.Settings
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService

class NfcTileService : TileService() {
    override fun onClick() {
        // Create an Intent to open the NFC settings page
        val intent = Intent(Settings.ACTION_NFC_SETTINGS)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
        startActivityAndCollapse(pendingIntent)
    }

    override fun onStartListening() {
        // A shortcut only, keep it always as grey/inactive.
        qsTile.state = Tile.STATE_INACTIVE
        qsTile.updateTile()
    }

    override fun onStopListening() {
        // Nothing to do.
    }
}