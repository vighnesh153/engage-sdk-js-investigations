package com.reactnativeproject.engage

import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.google.android.engage.js.converter.convertJsonToEngagePublishContinuationClusterRequest
import com.google.android.engage.service.AppEngagePublishClient
import com.google.android.engage.service.PublishContinuationClusterRequest

class EngageNativeModule(val reactContext: ReactApplicationContext) :
    ReactContextBaseJavaModule(reactContext) {
    private val TAG = "EngageNativeModule"
    override fun getName() = TAG

    @ReactMethod
    fun publishContinuationCluster(continuationClusterRequestJson: String) {
        val continuationClusterRequest = try {
            convertJsonToEngagePublishContinuationClusterRequest(
                continuationClusterRequestJson
            )
        } catch (e: Exception) {
            Log.d(TAG, "publishContinuationCluster: Some error occurred = $e")
            return
        }

        val client = AppEngagePublishClient(reactContext.applicationContext)
        client.isServiceAvailable.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                if (task.result) {
                    client.publishContinuationCluster(continuationClusterRequest)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                Log.d(TAG, "publishContinuationCluster: Publish successful")
                            } else {
                                Log.d(TAG, "publishContinuationCluster: Publish failed")
                            }
                        }
                } else {
                    Log.d(TAG, "Service is not available")
                }
            } else {
                Log.d(TAG, "Failed to check if service is available. Retry again later...")
            }
        }
    }
}