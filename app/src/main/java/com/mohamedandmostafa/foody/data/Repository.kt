package com.mohamedandmostafa.foody.data

import com.mohamedandmostafa.foody.data.RemoteDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(
    remoteDataSource: RemoteDataSource,
    localDataSource: LocalDataSource
) {

    val remote  = remoteDataSource
    val local  = localDataSource


}