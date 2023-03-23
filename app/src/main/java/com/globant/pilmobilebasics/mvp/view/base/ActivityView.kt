package com.globant.mobilebasics.mvp.view.base

import android.app.Activity
import java.lang.ref.WeakReference

open class ActivityView(activity: Activity) {

    private val activityRef: WeakReference<Activity> = WeakReference(activity)

    protected val activity: Activity?
        get() = activityRef.get()
}
