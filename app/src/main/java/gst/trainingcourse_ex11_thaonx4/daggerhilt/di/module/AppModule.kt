package gst.trainingcourse_ex11_thaonx4.daggerhilt.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gst.trainingcourse_ex11_thaonx4.daggerhilt.database.NoteDao
import gst.trainingcourse_ex11_thaonx4.daggerhilt.database.NoteDatabase
import gst.trainingcourse_ex11_thaonx4.daggerhilt.utils.DispatcherProvider
import gst.trainingcourse_ex11_thaonx4.daggerhilt.utils.StandardDispatcher
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Singleton
    @Provides
    fun providerData(application: Application): NoteDatabase =
        NoteDatabase.getInstance(application)

    @Singleton
    @Provides
    fun providerNoteDao(database: NoteDatabase): NoteDao = database.getNoteDao()

    @Singleton
    @Provides
    fun providerDispatcherProvider(): DispatcherProvider = StandardDispatcher()
}