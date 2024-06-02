package com.example.quicknote.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.quicknote.dao.NoteDataDao
import com.example.quicknote.database.NoteDataBase
import com.example.quicknote.repository.NoteBookRepository
import com.example.quicknote.repository.impl.NoteBookRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNoteDatabase(context:Application): NoteDataBase {
        return Room.databaseBuilder(
            context = context,
            klass = NoteDataBase::class.java,
            name = "NOTE_DB"
            ).fallbackToDestructiveMigrationFrom()
            .build()
    }

    @Provides
    @Singleton
    fun provideNoteDao(noteDataBase: NoteDataBase): NoteDataDao {
        return noteDataBase.getNoteDataDao()
    }

    @Provides
    @Singleton
    fun provideNoteBookRepo(noteDataDao: NoteDataDao):NoteBookRepository{
        return NoteBookRepositoryImpl(noteDataDao)
    }

}