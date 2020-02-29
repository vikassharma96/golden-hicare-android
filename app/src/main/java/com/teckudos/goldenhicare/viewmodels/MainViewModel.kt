package com.teckudos.goldenhicare.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teckudos.goldenhicare.R
import com.teckudos.goldenhicare.domain.Category
import com.teckudos.goldenhicare.domain.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.random.Random

class MainViewModel : ViewModel() {

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    var images = listOf<Item>()
    var category = listOf<Category>()
    var recommendation = arrayListOf<Category>()

    init {
        images = listOf(
            Item(
                1,
                "https://irp-cdn.multiscreensite.com/a82f7d82/dms3rep/multi/desktop/roach-1000.png"
            ),
            Item(
                2,
                "https://irp-cdn.multiscreensite.com/a82f7d82/dms3rep/multi/desktop/AdobeStock_106486504.png"
            ),
            Item(
                3,
                "https://irp-cdn.multiscreensite.com/a82f7d82/dms3rep/multi/desktop/AdobeStock_78999698.png"
            ),
            Item(
                4,
                "https://irp-cdn.multiscreensite.com/a82f7d82/dms3rep/multi/desktop/carpenter-ant.png"
            ),
            Item(
                5,
                "https://irp-cdn.multiscreensite.com/md/unsplash/dms3rep/multi/desktop/photo-1492515114975-b062d1a270ae.jpg"
            )
        )
        category = listOf(
            Category(1, "Cockroach & ant control services", R.drawable.cockroach),
            Category(3, "Termites control services", R.drawable.termite),
            Category(2, "Bedbugs control services", R.drawable.bed_bug),
            Category(4, "Mosquitoes Control Services", R.drawable.mosquitos)
        )
        for (pos in 0..1) {
            val i = Random.nextInt(pos, 4)
            recommendation.add(category[i])
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
