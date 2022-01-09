package gst.trainingcourse_ex11_thaonx4.daggerhilt.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlin.coroutines.CoroutineContext

interface DispatcherProvider {
    val main: CoroutineDispatcher
    val default: CoroutineDispatcher
    val io: CoroutineDispatcher
    val undefined: CoroutineDispatcher
}