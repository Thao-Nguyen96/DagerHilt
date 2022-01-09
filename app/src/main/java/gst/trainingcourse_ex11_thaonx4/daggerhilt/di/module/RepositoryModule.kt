package gst.trainingcourse_ex11_thaonx4.daggerhilt.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gst.trainingcourse_ex11_thaonx4.daggerhilt.database.NoteDao
import gst.trainingcourse_ex11_thaonx4.daggerhilt.repository.INoteRepository
import gst.trainingcourse_ex11_thaonx4.daggerhilt.repository.NoteRepository
import gst.trainingcourse_ex11_thaonx4.daggerhilt.utils.DispatcherProvider
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providerNoteRepository(
        noteDao: NoteDao,
        dispatcherProvider: DispatcherProvider
    ):INoteRepository{
        return NoteRepository(noteDao, dispatcherProvider)
    }
}