package com.mking11.compose.buttons.utils

import android.os.Build

fun android12(): Boolean {
  return Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
}