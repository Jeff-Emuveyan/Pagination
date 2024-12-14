package com.bellogatecaliphate.pagination.ui.main.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.bellogatecaliphate.pagination.ui.main.data.local.AppDatabase
import com.bellogatecaliphate.pagination.ui.main.data.remote.Api
import com.bellogatecaliphate.pagination.ui.main.paging.UserRemoteMediator
import com.bellogatecaliphate.pagination.ui.main.paging.UsersPagingSource
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class UserRepository @Inject constructor(val ioDispatchers: CoroutineContext,
                                         val api: Api,
                                         val appDatabase: AppDatabase,
                                         private val pagingSource: UsersPagingSource,
                                         private val remoteMediator: UserRemoteMediator
) {

   /* suspend fun getUser(id: Int, noofRecords: Int): List<UserResponse>? = withContext(ioDispatchers) {
        try {
            api.getUsers(id, noofRecords)
        } catch (e: Exception) {
            null
        }
    }*/

    /***
     * GET LIST OF PAGINATED USERS
     */
    fun getUsers() = Pager(PagingConfig(pageSize = 20)) { pagingSource }

    /**
     * GET LIST OF PAGINATED USERS WITH LOCAL STORAGE BACKUP
     */
    @OptIn(ExperimentalPagingApi::class)
    fun getUsersWithLocalPagination(id: Int) = Pager(
        config = PagingConfig(pageSize = 20),
        remoteMediator = remoteMediator
    ) {
        appDatabase.userDao().pagingSource(id)
    }
}
