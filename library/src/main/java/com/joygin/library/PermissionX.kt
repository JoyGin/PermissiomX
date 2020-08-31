package com.joygin.library

import androidx.fragment.app.FragmentActivity

object PermissionX {

    private const val TAG = "InvisibleFragment"

    fun request(activity: FragmentActivity, vararg permissions: String, cb: PermissionCallback){
        val fragmentManager = activity.supportFragmentManager
        var exitedFragment = fragmentManager.findFragmentByTag(TAG)
        if (exitedFragment == null){
            exitedFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(exitedFragment, TAG).commitNow()
        }
        exitedFragment = exitedFragment as InvisibleFragment
        exitedFragment.requestNow(cb, *permissions)
    }
}