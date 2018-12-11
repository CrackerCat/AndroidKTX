package com.lxj.androidktx.core

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

/**
 * Description: Fragment相关扩展
 * Create by dance, at 2018/12/5
 */

fun FragmentActivity.replace(layoutId: Int, f: Fragment, bundle: Array<out Pair<String, Any?>>?){
    if(bundle!=null)f.arguments = bundle.toBundle()
    supportFragmentManager.beginTransaction()
            .replace(layoutId, f)
            .commitAllowingStateLoss()
}

fun FragmentActivity.add(layoutId: Int, f: Fragment,  bundle: Array<out Pair<String, Any?>>?){
    if(bundle!=null)f.arguments = bundle.toBundle()
    supportFragmentManager.beginTransaction()
            .add(layoutId, f)
            .commitAllowingStateLoss()
}

fun FragmentActivity.hide(f: Fragment){
    supportFragmentManager.beginTransaction()
            .hide(f)
            .commitAllowingStateLoss()
}

fun Fragment.replace(layoutId: Int, f: Fragment,  bundle: Array<out Pair<String, Any?>>?){
    if(bundle!=null)f.arguments = bundle.toBundle()
    childFragmentManager.beginTransaction()
            .replace(layoutId, f)
            .commitAllowingStateLoss()
}

fun Fragment.add(layoutId: Int, f: Fragment,  bundle: Array<out Pair<String, Any?>>?){
    if(bundle!=null)f.arguments = bundle.toBundle()
    childFragmentManager.beginTransaction()
            .add(layoutId, f)
            .commitAllowingStateLoss()
}

fun Fragment.hide( f: Fragment){
    childFragmentManager.beginTransaction()
            .hide(f)
            .commitAllowingStateLoss()
}