package com.rahul.pod.login

import com.rahul.dino.core.network.NetworkConfigInterface
import com.rahul.dino.navigation.mock.NetworkConfigMockImpl
import com.rahul.pod.login.network.LoginServiceRepo
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import java.util.concurrent.CountDownLatch

@RunWith(RobolectricTestRunner::class)
open class LoginBaseTest : KoinTest {

    @Before
    open fun beforeEach() {
        loadModule()
        MockitoAnnotations.initMocks(this)
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
    }

    @After
    open fun afterEach() {
        stopKoin()
    }

    private fun loadModule() {
        startKoin {
            modules(
                module {
                    single<NetworkConfigInterface> { NetworkConfigMockImpl() }
                    factory { LoginServiceRepo() }
                    viewModel { LoginViewModel() }
                })
        }
    }

}