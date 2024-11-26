package br.com.oiti.certiface.sample.ui.theme

import br.com.oiti.certiface.core.providers.doc.core.builders.CustomLoadingDialogBuilder
import br.com.oiti.certiface.core.providers.doc.core.builders.CustomResultScreenBuilder
import br.com.oiti.certiface.core.providers.liveness.liveness2d.builders.CustomCaptureScreenBuilder
import br.com.oiti.certiface.core.providers.theme.InstructionCustomsBuilder
import br.com.oiti.certiface.core.providers.theme.liveness2d.Liveness2DFontsKey
import br.com.oiti.certiface.core.providers.theme.liveness2d.Liveness2DTheme

fun getLiveness2DThemeBuilder(): Liveness2DTheme {
    return Liveness2DTheme.Builder()
        .setInstructionsTheme(getLiveness2DInstructionsTheme())
        .setCaptureTheme(getLiveness2DCaptureScreenBuilder())
        .setLoadingDialogTheme(getLiveness2DLoadingBuilder())
        .setResultScreenTheme(getLiveness2DResultScreenBuilder())
        .setFontsKey(getLiveness2DFonts())
        .build()
}

private fun getLiveness2DCaptureScreenBuilder(): CustomCaptureScreenBuilder {
    return CustomCaptureScreenBuilder.Builder()
        .setBackButtonIcon(android.R.drawable.ic_delete)
        .setBackButtonColor("#ff0000")
        .setCloseButtonIcon(android.R.drawable.ic_delete)
        .setCloseButtonColor("#ffffff")
        .setBackgroundColor("#00ff00")
        .setInstructionsGuideTextColor("#0000ff")
        .setInstructionsGuideText("texto inicial")
        .setInstructionsGuideBackgroundColor("#4b6351")
        .setCapturePreviewBorderColor("#d11339")
        .setChallengeButtonBackgroundColor("#13d178")
        .setChallengeButtonTextColor("#d14f13")
        .setChallengeButtonLoadingColor("#131cd1")
        .setLoadingFirstArcColor("#13d17b")
        .setLoadingSecondArcColor("#29473a")
        .build()
}

private fun getLiveness2DResultScreenBuilder(): CustomResultScreenBuilder {
    return CustomResultScreenBuilder.Builder()
        .setSuccessBackgroundColor("#fcba03")
        .setSuccessIcon(android.R.drawable.ic_delete)
        .setSuccessText("Deu tudo certo eu acho!")
        .setSuccessTextColor("#4b455c")
        .setErrorBackgroundColor("#de14ab")
        .setErrorIcon(android.R.drawable.ic_delete)
        .setErrorText("Deu ruim!")
        .setErrorTextColor("#2c294d")
        .setRetryButtonColor("#c2eb0e")
        .setRetryButtonText("vamos tentar novamente?")
        .setRetryButtonTextColor("#6c0bdb")
        .build()
}

private fun getLiveness2DLoadingBuilder(): CustomLoadingDialogBuilder {
    return CustomLoadingDialogBuilder.Builder()
        .setCircularProgressIndicatorColor("#329ea8")
        .setBackgroundColor("#7132a8")
        .setCircularProgressIndicatorSize(1000)
        .setCircularProgressIndicatorWidth(50)
        .build()
}

private fun getLiveness2DFonts(): Map<Liveness2DFontsKey, *> {
    return mapOf(
        Liveness2DFontsKey.INSTRUCTIONS_TITLE_FONT to "fonts/sixty.ttf",
        Liveness2DFontsKey.INSTRUCTIONS_CAPTION_FONT to "fonts/sixty.ttf",
        Liveness2DFontsKey.INSTRUCTIONS_DOCUMENT_TYPES_INSTRUCTIONS_FONT to "fonts/sixty.ttf",
        Liveness2DFontsKey.INSTRUCTIONS_DOCUMENT_TIPS_INSTRUCTIONS_FONT to "fonts/sixty.ttf",
        Liveness2DFontsKey.INSTRUCTIONS_BUTTON_FONT to "fonts/sixty.ttf",
        Liveness2DFontsKey.CAPTURE_INSTRUCTION_TEXT_FONT to "fonts/sixty.ttf",
        Liveness2DFontsKey.CAPTURE_CHALLENGE_BUTTON_FONT to "fonts/sixty.ttf",
        Liveness2DFontsKey.RESULT_MESSAGE_FONT to "fonts/sixty.ttf",
        Liveness2DFontsKey.RESULT_RETRY_BUTTON_FONT to "fonts/sixty.ttf",
    )
}


private fun getLiveness2DInstructionsTheme(): InstructionCustomsBuilder {
    return InstructionCustomsBuilder.Builder()
        .setTitleText("titulo exemplo customizado do Liveness 2D")
        .setCaptionText("subtitulo exemplo customizado da Liveness 2D")
        .setBackgroundColor("#32a852")
        .setDocumentTypesInstructionIcon(android.R.drawable.ic_delete)
        .setDocumentTypesInstructionText("descricao do primeiro campo da Liveness 2D")
        .setDocumentTipsInstructionText("descricao do segundo campo da Liveness 2D")
        .setDocumentTipsInstructionIcon(android.R.drawable.ic_delete)
        .setContextImage(android.R.drawable.ic_delete)
        .setBackButtonImg(android.R.drawable.ic_delete)
        .setBottomSheetColor("#3e32a8")
        .setTitleColor("#a83290")
        .setCaptionColor("#a86b32")
        .setDocumentTypesInstructionTextColor("#a8927d")
        .setDocumentTypesInstructionIconBackgroundColor("#cc6f16")
        .setDocumentTipsInstructionTextColor("#16cc3a")
        .setDocumentTipsInstructionIconBackgroundColor("#012e0a")
        .setBackButtonColor("#01012e")
        .setContinueButtonText("Continuar button")
        .setContinueButtonColor("#2e030a")
        .setContinueButtonTextColor("#0000ff")
        .setDocumentTypesInstructionIconBorderColor("#ff0000")
        .setDocumentTipsInstructionIconBorderColor("#00ff00")
        .setBottomSheetCornerRadius(15.0f)
        .build()
}