package com.teckudos.goldenhicare.viewmodels

import androidx.lifecycle.ViewModel
import com.teckudos.goldenhicare.R
import com.teckudos.goldenhicare.domain.Category
import com.teckudos.goldenhicare.domain.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class MainViewModel : ViewModel() {

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    var images = listOf<Item>()
    var category = listOf<Category>()

    init {
        images = listOf(
            Item(1, "https://irp-cdn.multiscreensite.com/a82f7d82/dms3rep/multi/desktop/roach-1000.png"),
            Item(2, "https://irp-cdn.multiscreensite.com/a82f7d82/dms3rep/multi/desktop/AdobeStock_106486504.png"),
            Item(3, "https://irp-cdn.multiscreensite.com/a82f7d82/dms3rep/multi/desktop/AdobeStock_78999698.png"),
            Item(4, "https://irp-cdn.multiscreensite.com/a82f7d82/dms3rep/multi/desktop/carpenter-ant.png"),
            Item(5, "https://irp-cdn.multiscreensite.com/md/unsplash/dms3rep/multi/desktop/photo-1492515114975-b062d1a270ae.jpg")
        )
        category = listOf(
            Category(1, "Cockroach", R.drawable.cockroach_on),
            Category(2, "Termite", R.drawable.termite_on),
            Category(3, "Bed Bug", R.drawable.bed_bugs_on),
            Category(4, "Wood Borer",R.drawable.wood_borer_on),
            Category(5, "Anti-Dengue", R.drawable.mosquitos_on)
        )
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
