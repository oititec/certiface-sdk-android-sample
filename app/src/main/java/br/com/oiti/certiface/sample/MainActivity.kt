package br.com.oiti.certiface.sample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.view.WindowInsetsControllerCompat
import br.com.oiti.certiface.core.contracts.request.HubCoreRequestParams
import br.com.oiti.certiface.core.manager.HubCallback
import br.com.oiti.certiface.core.manager.HubManager
import br.com.oiti.certiface.core.manager.HubManagerLauncher
import br.com.oiti.certiface.core.model.HubManagerUser
import br.com.oiti.certiface.core.providers.doc.core.DocCoreOitiProvider
import br.com.oiti.certiface.core.providers.liveness.LivenessInterceptor
import br.com.oiti.certiface.core.providers.liveness.LivenessResult
import br.com.oiti.certiface.core.providers.liveness.facetec.FacetecProvider
import br.com.oiti.certiface.core.providers.liveness.facetec.FacetecProviderInterceptor
import br.com.oiti.certiface.core.providers.liveness.liveness2d.Liveness2DProvider
import br.com.oiti.certiface.core.providers.liveness.liveness2d.Liveness2DProviderInterceptor
import br.com.oiti.certiface.sample.R.*
import br.com.oiti.certiface.sample.ui.components.Button
import br.com.oiti.certiface.sample.ui.components.FormDialog
import br.com.oiti.certiface.sample.ui.components.LoadingDialog
import br.com.oiti.certiface.sample.ui.theme.CertifacesdksampleTheme
import br.com.oiti.certiface.sample.ui.theme.HighlightColors.Companion.HighlightPure
import br.com.oiti.certiface.sample.ui.theme.NeutralColors.Companion.HighLight
import br.com.oiti.certiface.sample.ui.theme.getDocCoreThemeBuilder
import br.com.oiti.certiface.sample.ui.theme.getFacetecThemeBuilder
import br.com.oiti.certiface.sample.ui.theme.getLiveness2DThemeBuilder
import br.com.oiti.certiface.sample.utils.Connection
import br.com.oiti.certiface.sample.viewmodel.MainViewModel
import kotlin.getValue

class MainActivity : ComponentActivity() {
    private var hubManager: HubManager? = null

    val dynamicTextState = mutableStateOf("")

    private var hubManagerLauncher: HubManagerLauncher? = null

    private val mViewModel: MainViewModel by viewModels()
    private val loadingState = mutableStateOf(false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkIsOnline()
        setStatusBarColor(HighlightPure)

        setContent {
            CertifacesdksampleTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    LoadingDialog(loadingState.value) {
                        ButtonNavigation()
                    }
                }
            }
        }
        hubManagerLauncher = HubManagerLauncher(this)
    }

    private fun setStatusBarColor(color: Color) {
        val windowInsetsController = WindowInsetsControllerCompat(window, window.decorView)
        window.statusBarColor = color.toArgb()
        windowInsetsController.isAppearanceLightStatusBars = false
    }


    private fun checkIsOnline() {
        if (!Connection.isOnline(this)) {
            dynamicTextState.value = "Sem conexão com a internet"
            return
        }
    }


    private fun startFlowDefault() {
        loadingState.value = true
        val hubManagerUser = HubManagerUser.Builder(
            ticket = mViewModel.customTicket,
            environment = HubCoreRequestParams.ENVIRONMENT.HML,
            org = mViewModel.org,
            branch = mViewModel.branch,
            key = mViewModel.xKey
        ).build()

        hubManager = HubManager.Builder(
            hubManagerLauncher = hubManagerLauncher,
            hubManagerUser = hubManagerUser,
            hubCallback = object : HubCallback {
                override fun onConnect() {
                    dynamicTextState.value = "result: onConnect"
                    loadingState.value = false
                }

                override fun onSuccess() {
                    dynamicTextState.value = "result: onSuccess"
                    loadingState.value = false
                }

                override fun onError(code: String?, message: String?) {
                    dynamicTextState.value = "result: $message \ncode: $code"
                    loadingState.value = false
                }

                override fun onCancel() {
                    dynamicTextState.value = "result: onCancel"
                    loadingState.value = false
                }
            }
        )
            .addProvider(FacetecProvider())
            .addProvider(Liveness2DProvider())
            .addGroup(mViewModel.group)
            .addSubOrg(mViewModel.subOrg)
            .addProvider(DocCoreOitiProvider())
            .build()

        hubManager?.start(this)
    }

    private fun startFlowCustom() {
        loadingState.value = true
        val hubManagerUser = HubManagerUser.Builder(
            ticket = mViewModel.customTicket,
            environment = HubCoreRequestParams.ENVIRONMENT.HML,
            org = mViewModel.org,
            branch = mViewModel.branch,
            key = mViewModel.xKey
        ).build()

        hubManager = HubManager.Builder(
            hubManagerLauncher = hubManagerLauncher,
            hubManagerUser = hubManagerUser,
            hubCallback = object : HubCallback {
                override fun onConnect() {
                    dynamicTextState.value = "result: onConnect"
                    loadingState.value = false
                }

                override fun onSuccess() {
                    dynamicTextState.value = "result: onSuccess"
                    loadingState.value = false
                }

                override fun onError(code: String?, message: String?) {
                    dynamicTextState.value = "result: $message \ncode: $code"
                    loadingState.value = false
                }

                override fun onCancel() {
                    dynamicTextState.value = "result: onCancel"
                    loadingState.value = false
                }
            }
        )
            .addProvider(FacetecProvider(getFacetecThemeBuilder(this)))
            .addProvider(Liveness2DProvider(getLiveness2DThemeBuilder()))
            .addGroup(mViewModel.group)
            .addSubOrg(mViewModel.subOrg)
            .addProvider(DocCoreOitiProvider(getDocCoreThemeBuilder()))
            .build()

        hubManager?.start(this)
    }

    private fun startFlowInterceptorDefault() {
        loadingState.value = true
        val facetecProviderInterceptor = FacetecProviderInterceptor(
            null,
            object : LivenessInterceptor {
                override fun onIntercept(result: LivenessResult) {
                    dynamicTextState.value =
                        "identifier: ${result.ticket}\nvalid: ${result.valid}\ncodeId: ${result.codeId}\nprotocol: ${result.protocol}\nimage: ${result.image}\nprovider: ${result.provider}"
                }
            }
        )

        val liveness2DProviderInterceptor = Liveness2DProviderInterceptor(
            null,
            object : LivenessInterceptor {
                override fun onIntercept(result: LivenessResult) {
                    dynamicTextState.value =
                        "identifier: ${result.ticket}\nvalid: ${result.valid}\ncodeId: ${result.codeId}\nprotocol: ${result.protocol}\nimage: ${result.image}\nprovider: ${result.provider}"
                }
            }
        )

        val hubManagerUser = HubManagerUser.Builder(
            ticket = mViewModel.customTicket,
            environment = HubCoreRequestParams.ENVIRONMENT.HML,
            org = mViewModel.org,
            branch = mViewModel.branch,
            key = mViewModel.xKey
        ).build()

        hubManager = HubManager.Builder(
            hubManagerLauncher = hubManagerLauncher,
            hubManagerUser = hubManagerUser,
            hubCallback = object : HubCallback {
                override fun onConnect() {
                    dynamicTextState.value = "result: onConnect"
                    loadingState.value = false
                }

                override fun onSuccess() {
                    dynamicTextState.value = "result: onSuccess"
                    loadingState.value = false
                }

                override fun onError(code: String?, message: String?) {
                    dynamicTextState.value = "result: $message \ncode: $code"
                    loadingState.value = false
                }

                override fun onCancel() {
                    dynamicTextState.value = "result: onCancel"
                    loadingState.value = false
                }
            }
        )
            .addProvider(facetecProviderInterceptor)
            .addProvider(liveness2DProviderInterceptor)
            .addGroup(mViewModel.group)
            .addSubOrg(mViewModel.subOrg)
            .addProvider(DocCoreOitiProvider())
            .build()
        hubManager?.start(this)
    }

    private fun startFlowInterceptorCustom() {
        loadingState.value = true
        val facetecProviderInterceptor = FacetecProviderInterceptor(
            getFacetecThemeBuilder(this),
            object : LivenessInterceptor {
                override fun onIntercept(result: LivenessResult) {
                    dynamicTextState.value =
                        "identifier: ${result.ticket}\nvalid: ${result.valid}\ncodeId: ${result.codeId}\nprotocol: ${result.protocol}\nimage: ${result.image}\nprovider: ${result.provider}"
                }
            }
        )

        val liveness2DProviderInterceptor = Liveness2DProviderInterceptor(
            getLiveness2DThemeBuilder(),
            object : LivenessInterceptor {
                override fun onIntercept(result: LivenessResult) {
                    dynamicTextState.value =
                        "identifier: ${result.ticket}\nvalid: ${result.valid}\ncodeId: ${result.codeId}\nprotocol: ${result.protocol}\nimage: ${result.image}\nprovider: ${result.provider}"
                }
            }
        )

        val hubManagerUser = HubManagerUser.Builder(
            ticket = mViewModel.customTicket,
            environment = HubCoreRequestParams.ENVIRONMENT.HML,
            org = mViewModel.org,
            branch = mViewModel.branch,
            key = mViewModel.xKey
        ).build()

        hubManager = HubManager.Builder(
            hubManagerLauncher = hubManagerLauncher,
            hubManagerUser = hubManagerUser,
            hubCallback = object : HubCallback {
                override fun onConnect() {
                    dynamicTextState.value = "result: onConnect"
                    loadingState.value = false
                }

                override fun onSuccess() {
                    dynamicTextState.value = "result: onSuccess"
                    loadingState.value = false
                }

                override fun onError(code: String?, message: String?) {
                    dynamicTextState.value = "result: $message \ncode: $code"
                    loadingState.value = false
                }

                override fun onCancel() {
                    dynamicTextState.value = "result: onCancel"
                    loadingState.value = false
                }
            }
        )
            .addProvider(facetecProviderInterceptor)
            .addProvider(liveness2DProviderInterceptor)
            .addGroup(mViewModel.group)
            .addSubOrg(mViewModel.subOrg)
            .addProvider(DocCoreOitiProvider(getDocCoreThemeBuilder()))
            .build()

        hubManager?.start(this)
    }

    private fun resumeFlow() {
        hubManager?.resume()
    }

    @Composable
    fun ButtonNavigation() {
        var showDialog by remember { mutableStateOf(false) }
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(ScrollState(0))
                .background(color = HighLight)
        ) {
            val (logo, column) = createRefs()

            Row(
                modifier = Modifier
                    .background(color = HighlightPure)
                    .fillMaxWidth()
                    .constrainAs(logo) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .padding(32.dp)) {
                Image(
                    painter = painterResource(id = drawable.brand_logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .fillMaxSize()
                )
            }

            Column(
                modifier = Modifier
                    .constrainAs(column) {
                        top.linkTo(logo.bottom, margin = 16.dp)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button("Flow Default", action = { startFlowDefault() })
                Spacer(modifier = Modifier.height(8.dp))
                Button("Flow Custom", action = { startFlowCustom() })
                Spacer(modifier = Modifier.height(8.dp))
                Button("Interceptor Default", action = { startFlowInterceptorDefault() })
                Spacer(modifier = Modifier.height(8.dp))
                Button("Interceptor Custom", action = { startFlowInterceptorCustom() })
                Spacer(modifier = Modifier.height(8.dp))
                Button("Resume Flow", action = { resumeFlow() })
                Spacer(modifier = Modifier.height(8.dp))
                Button("Config", action = { showDialog = true })

                Spacer(modifier = Modifier.height(16.dp))

                if (showDialog) {
                    FormDialog(
                        onDismiss = { showDialog = false },
                        viewModel = mViewModel,
                        onSave = {
                            Toast.makeText(
                                this@MainActivity,
                                "configuração salva!",
                                Toast.LENGTH_SHORT
                            ).show()
                            dynamicTextState.value =
                                mViewModel.customTicket ?: "falha ao salvar ticket."
                        }
                    )
                }

                Text(
                    text = dynamicTextState.value,
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainPreview() {
        CertifacesdksampleTheme {
            ButtonNavigation()
        }
    }
}

