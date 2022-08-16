package me.avdovichev.androidxfragmentstest

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit

const val TAG = "AXFT"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (null == savedInstanceState) {
            supportFragmentManager.commit {
                setReorderingAllowed(false)
                val fragment = FirstFragment()
                val ftName = fragment.javaClass.name
                val tag = ftName + System.currentTimeMillis()
                this.addToBackStack(ftName)
                replace(R.id.fragment_container_view, fragment, tag)
            }
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        android.util.Log.d(TAG, "MainActivity.onConfigurationChanged")
    }

    fun goNextFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(false)
            val fragment = SecondFragment()
            val ftName = fragment.javaClass.name
            val tag = ftName + System.currentTimeMillis()
            this.addToBackStack(ftName)
            replace(R.id.fragment_container_view, fragment, tag)
        }
    }
}