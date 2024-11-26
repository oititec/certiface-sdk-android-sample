package br.com.oiti.certiface.sample.ui.theme

import br.com.oiti.certiface.core.providers.doc.core.builders.CustomCaptureScreenBuilder
import br.com.oiti.certiface.core.providers.doc.core.builders.CustomLoadingDialogBuilder
import br.com.oiti.certiface.core.providers.doc.core.builders.CustomResultScreenBuilder
import br.com.oiti.certiface.core.providers.doc.core.builders.DocCoreCustomInstructionsBuilder
import br.com.oiti.certiface.core.providers.theme.doccore.DocCoreFontsKey
import br.com.oiti.certiface.core.providers.theme.doccore.DocCoreTheme

fun getDocCoreThemeBuilder(): DocCoreTheme {
    return DocCoreTheme.Builder()
        .setInstructionsTheme(getDocCoreInstructionsTheme())
        .setCaptureTheme(getDocCoreCaptureScreenBuilder())
        .setLoadingDialogTheme(getDocCoreLoadingBuilder())
        .setResultScreenTheme(getDocCoreResultScreenBuilder())
        .setFontsKey(getDocCoreFonts())
        .build()
}

private fun getDocCoreResultScreenBuilder(): CustomResultScreenBuilder {
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

private fun getDocCoreLoadingBuilder(): CustomLoadingDialogBuilder {
    return CustomLoadingDialogBuilder.Builder()
        .setCircularProgressIndicatorColor("#329ea8")
        .setBackgroundColor("#7132a8")
        .setCircularProgressIndicatorSize(1000)
        .setCircularProgressIndicatorWidth(50)
        .build()
}

private fun getDocCoreFonts(): Map<DocCoreFontsKey, *> {
    return mapOf(
        DocCoreFontsKey.INSTRUCTIONS_TITLE_FONT to "fonts/sixty.ttf",
        DocCoreFontsKey.INSTRUCTIONS_CAPTION_FONT to "fonts/sixty.ttf",
        DocCoreFontsKey.INSTRUCTIONS_DOCUMENT_TYPES_INSTRUCTIONS_FONT to "fonts/sixty.ttf",
        DocCoreFontsKey.INSTRUCTIONS_DOCUMENT_TIPS_INSTRUCTIONS_FONT to "fonts/sixty.ttf",
        DocCoreFontsKey.INSTRUCTIONS_BUTTON_FONT to "fonts/sixty.ttf",
        DocCoreFontsKey.CAPTURE_INSTRUCTION_TEXT_FONT to "fonts/sixty.ttf",
        DocCoreFontsKey.CAPTURE_INSTRUCTION_GUIDE_FONT to "fonts/sixty.ttf",
        DocCoreFontsKey.CAPTURE_BOTTOM_SHEET_FONT to "fonts/sixty.ttf",
        DocCoreFontsKey.CAPTURE_CONFIRMATION_MESSAGE_FONT to "fonts/sixty.ttf",
        DocCoreFontsKey.CAPTURE_CONFIRM_BUTTON_FONT to "fonts/sixty.ttf",
        DocCoreFontsKey.CAPTURE_RETRY_BUTTON_FONT to "fonts/sixty.ttf",
        DocCoreFontsKey.RESULT_MESSAGE_FONT to "fonts/sixty.ttf",
        DocCoreFontsKey.RESULT_RETRY_BUTTON_FONT to "fonts/sixty.ttf",
    )
}


private fun getDocCoreInstructionsTheme(): DocCoreCustomInstructionsBuilder {
    return DocCoreCustomInstructionsBuilder.Builder()
        .setTitleText("titulo exemplo customizado da docCore")
        .setCaptionText("subtitulo exemplo customizado da docCore")
        .setBackgroundColor("#32a852")
        .setDocumentTypesInstructionIcon(android.R.drawable.ic_delete)
        .setDocumentTypesInstructionText("descricao do primeiro campo da docCore")
        .setDocumentTipsInstructionText("descricao do segundo campo da docCore")
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

private fun getDocCoreCaptureScreenBuilder(): CustomCaptureScreenBuilder {
    return CustomCaptureScreenBuilder.Builder()
        .setBackButtonIcon(android.R.drawable.ic_delete)
        .setBackButtonColor("#bcbcd1")
        .setCloseButtonIcon(android.R.drawable.ic_delete)
        .setCloseButtonColor("#FF0000")
        .setBackgroundColor("#fcba03")
        .setFrontIndicatorText("frontal indicator")
        .setBackIndicatorText("traseira indicator")
        .setIndicatorColor("#0000FF")
        .setFrontIndicatorImage(android.R.drawable.ic_delete)
        .setIndicatorTextColor("#FF00FF")
        .setBackIndicatorImage(android.R.drawable.ic_delete)
        .setInstructionsGuideTextFront("tire uma foto frontal.")
        .setInstructionsGuideTextBack("foto traseira.")
        .setInstructionsGuideTextConfirmation("Confirmacao das fotos")
        .setInstructionsGuideColor("#0000FF")
        .setCapturePreviewBorderColorCaptured("#008000")
        .setCapturePreviewBorderColorUncaptured("#FF0000")
        .setCaptureButtonIcon(android.R.drawable.ic_delete)
        .setCaptureButtonColor("#00FFFF")
        .setBottomSheetColor("#3e32a8")
        .setSelectedIndicatorColor("#db820d")
        .setBottomSheetCornerRadius(15.0f)
        .setConfirmationMessageText("Confirmando se ficou boa")
        .setConfirmationMessageColor("#FFFFFF")
        .setConfirmButtonText("simButton")
        .setConfirmButtonTextConfirmation("confime aqui")
        .setConfirmButtonColor("#00FF00")
        .setRetryButtonText("NãoButton")
        .setRetryButtonColor("#FF0000")
        .setCaptureButtonBorderColor("#ff0000")
        .build()
}