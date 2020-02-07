package com.teckudos.goldenhicare.utils

import android.app.Activity
import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Toast
import androidx.core.app.ShareCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.teckudos.goldenhicare.R
import timber.log.Timber

fun showDialog(
    context: Context,
    message: String,
    positiveBtnName: String?,
    negativeBtnName: String?,
    positiveBtnListener: DialogInterface.OnClickListener?,
    negativeBtnListener: DialogInterface.OnClickListener?
): Dialog? {
    val dialog: Dialog?
    val builder = MaterialAlertDialogBuilder(context)
    builder.setMessage(message)
    builder.setCancelable(false)
    if (positiveBtnName != null && positiveBtnListener != null)
        builder.setPositiveButton(positiveBtnName, positiveBtnListener)
    if (negativeBtnName != null && negativeBtnListener != null)
        builder.setNegativeButton(negativeBtnName, negativeBtnListener)
    dialog = builder.create()

    return dialog
}

fun call(context: Context, view: View, number: String) {
    try {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:$number")
        context.startActivity(callIntent)
    } catch (e: Exception) {
        Timber.i(e)
        Snackbar.make(
            view,
            "No sim found",
            Snackbar.LENGTH_LONG
        ).show()
    }
}

fun share(context: Context) {
    val shareIntent = ShareCompat.IntentBuilder.from(context as Activity?)
        .setText("Golden Hicare")
        .setType("text/plain")
        .intent
    try {
        context.startActivity(shareIntent)
    } catch (ex: ActivityNotFoundException) {
        Toast.makeText(
            context, context.getString(R.string.sharing_not_available),
            Toast.LENGTH_LONG
        ).show()
    }
}