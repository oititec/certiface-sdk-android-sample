package br.com.oiti.certiface.sample.ui.theme

import android.content.Context
import androidx.core.content.ContextCompat
import br.com.oiti.certiface.core.providers.theme.InstructionCustomsBuilder
import br.com.oiti.certiface.core.providers.theme.facetec.FacetecFontsKey
import br.com.oiti.certiface.core.providers.theme.facetec.FacetecTextKey
import br.com.oiti.certiface.core.providers.theme.facetec.FacetecTheme

fun getFacetecThemeBuilder(
    context: Context
): FacetecTheme {
    return FacetecTheme.Builder()
        .guidanceBackgroundColors("#73997d")
        .guidanceForegroundColor("#3b3bd4")
        .guidanceReadyScreenHeaderTextColor("#5e3766")
        .guidanceReadyScreenSubtextTextColor("#665437")
        .guidanceRetryScreenHeaderTextColor("#383531")
        .guidanceRetryScreenSubtextTextColor("#ad1540")
        .guidanceButtonBackgroundNormalColor("#15abad")
        .guidanceButtonBackgroundHighlightColor("#70856e")
        .guidanceButtonTextHighlightColor("#6e8485")
        .guidanceButtonTextDisabledColor("#21bf13")
        .guidanceButtonTextNormalColor("#fefefe")
        .guidanceButtonBackgroundDisabledColor("#9fc49b")
        .guidanceButtonBorderColor("#3f453e")
        .guidanceReadyScreenOvalFillColor("#7c1bd1")
        .guidanceReadyScreenTextBackgroundColor(
            ContextCompat.getColor(
                context,
                android.R.color.black
            )
        )
        .guidanceRetryScreenImageBorderColor("#f50fa8")
        .guidanceRetryScreenOvalStrokeColor("#f5890f")
        .resultScreenForegroundColor("#0f9df5")
        .resultScreenBackgroundColors("#040d12")
        .resultScreenActivityIndicatorColor("#7b00ff")
        .resultScreenUploadProgressFillColor("#ff4400")
        .resultScreenUploadProgressTrackColor("#78402c")
        .resultScreenResultAnimationBackgroundColor("#381103")
        .resultScreenResultAnimationForegroundColor("#508536")
        .ovalCustomizationStrokeColor("#266606")
        .ovalCustomizationProgressColor1("#66063c")
        .ovalCustomizationProgressColor2("#f7dd59")
        .frameBorderColor("#f75969")
        .frameBackgroundColor("#302e2e")
        .overlayBackgroundColor("#e3babe")
        .feedbackBackgroundColors("#ed4758")
        .feedbackTextColor("#15d100")
        .setInstructionsTheme(getFacetecInstructionsTheme())
        .setFacetecTextMap(getFacetecTexts())
        .setFacetecFontsMap(getFacetecFonts())
        .build()
}

fun getFacetecFonts(): HashMap<FacetecFontsKey, *> {
    return hashMapOf(
        FacetecFontsKey.GUIDANCE_CUSTOMIZATION_HEADER_FONT to "fonts/sixty.ttf",
        FacetecFontsKey.GUIDANCE_CUSTOMIZATION_SUBTEXT_FONT to "fonts/sixty.ttf",
        FacetecFontsKey.GUIDANCE_CUSTOMIZATION_READY_SCREEN_HEADER_FONT to "fonts/sixty.ttf",
        FacetecFontsKey.GUIDANCE_CUSTOMIZATION_READY_SCREEN_SUBTEXT_FONT to "fonts/sixty.ttf",
        FacetecFontsKey.GUIDANCE_CUSTOMIZATION_RETRY_SCREEN_HEADER_FONT to "fonts/sixty.ttf",
        FacetecFontsKey.GUIDANCE_CUSTOMIZATION_RETRY_SCREEN_SUBTEXT_FONT to "fonts/sixty.ttf",
        FacetecFontsKey.RESULT_SCREEN_CUSTOMIZATION_MESSAGE_FONT to "fonts/sixty.ttf",
        FacetecFontsKey.GUIDANCE_CUSTOMIZATION_BUTTON_FONT to "fonts/sixty.ttf",
        FacetecFontsKey.FEEDBACK_CUSTOMIZATION_TEXT_FONT to "fonts/sixty.ttf",

        FacetecFontsKey.INSTRUCTIONS_TITLE_FONT to "fonts/sixty.ttf",
        FacetecFontsKey.INSTRUCTIONS_CAPTION_FONT to "fonts/sixty.ttf",
        FacetecFontsKey.INSTRUCTIONS_DOCUMENT_TYPES_INSTRUCTIONS_FONT to "fonts/sixty.ttf",
        FacetecFontsKey.INSTRUCTIONS_DOCUMENT_TIPS_INSTRUCTIONS_FONT to "fonts/sixty.ttf",
        FacetecFontsKey.INSTRUCTIONS_BUTTON_FONT to "fonts/sixty.ttf"
    )
}

fun getFacetecTexts(): HashMap<FacetecTextKey, String> {
    return hashMapOf(
        FacetecTextKey.READY_HEADER_1 to "READY_HEADER_1",
        FacetecTextKey.READY_HEADER_2 to "READY_HEADER_2",
        FacetecTextKey.READY_MESSAGE_1 to "READY_MESSAGE_1",
        FacetecTextKey.READY_MESSAGE_2 to "READY_MESSAGE_2",
        FacetecTextKey.READY_BUTTON to "READY_BUTTON",

        FacetecTextKey.RETRY_HEADER to "RETRY_HEADER",
        FacetecTextKey.RETRY_SUBHEADER to "RETRY_SUBHEADER",
        FacetecTextKey.RETRY_MESSAGE_SMILE to "RETRY_MESSAGE_SMILE",
        FacetecTextKey.RETRY_MESSAGE_LIGHTING to "RETRY_MESSAGE_LIGHTING",
        FacetecTextKey.RETRY_MESSAGE_CONTRAST to "RETRY_MESSAGE_CONTRAST",
        FacetecTextKey.RETRY_YOUR_PICTURE to "RETRY_YOUR_PICTURE",
        FacetecTextKey.RETRY_IDEAL_PICTURE to "RETRY_IDEAL_PICTURE",
        FacetecTextKey.RETRY_BUTTON to "RETRY_BUTTON",

        FacetecTextKey.RESULT_UPLOAD_MESSAGE to "RESULT_UPLOAD_MESSAGE",
        FacetecTextKey.RESULT_SUCCESS_MESSAGE to "RESULT_SUCCESS_MESSAGE",

        FacetecTextKey.FEEDBACK_LOOK_STRAIGHT_IN_OVAL to "FEEDBACK_LOOK_STRAIGHT_IN_OVAL",

        FacetecTextKey.FEEDBACK_CENTER_FACE to "FEEDBACK_CENTER_FACE",
        FacetecTextKey.FEEDBACK_FACE_NOT_FOUND to "FEEDBACK_FACE_NOT_FOUND",
        FacetecTextKey.FEEDBACK_FACE_NOT_LOOKING_STRAIGHT_AHEAD to "FEEDBACK_FACE_NOT_LOOKING_STRAIGHT_AHEAD",
        FacetecTextKey.FEEDBACK_FACE_NOT_UPRIGHT to "FEEDBACK_FACE_NOT_UPRIGHT",
        FacetecTextKey.FEEDBACK_HOLD_STEADY to "FEEDBACK_HOLD_STEADY",
        FacetecTextKey.FEEDBACK_MOVE_PHONE_AWAY to "FEEDBACK_MOVE_PHONE_AWAY",
        FacetecTextKey.FEEDBACK_MOVE_PHONE_CLOSER to "FEEDBACK_MOVE_PHONE_CLOSER",
        FacetecTextKey.FEEDBACK_MOVE_PHONE_TO_EYE_LEVEL to "FEEDBACK_MOVE_PHONE_TO_EYE_LEVEL",
        FacetecTextKey.FEEDBACK_USE_EVEN_LIGHTING to "FEEDBACK_USE_EVEN_LIGHTING",

        FacetecTextKey.FEEDBACK_FRAME_YOUR_FACE to "FEEDBACK_FRAME_YOUR_FACE",
        FacetecTextKey.FEEDBACK_HOLD_STEADY_1 to "FEEDBACK_HOLD_STEADY_1",
        FacetecTextKey.FEEDBACK_HOLD_STEADY_2 to "FEEDBACK_HOLD_STEADY_2",
        FacetecTextKey.FEEDBACK_HOLD_STEADY_3 to "FEEDBACK_HOLD_STEADY_3",
        FacetecTextKey.FEEDBACK_REMOVE_DARK_GLASSES to "FEEDBACK_REMOVE_DARK_GLASSES",
        FacetecTextKey.FEEDBACK_NEUTRAL_EXPRESSION to "FEEDBACK_NEUTRAL_EXPRESSION",
        FacetecTextKey.FEEDBACK_CONDITIONS_TOO_BRIGHT to "FEEDBACK_CONDITIONS_TOO_BRIGHT",
        FacetecTextKey.FEEDBACK_BRIGHTEN_YOUR_ENVIRONMENT to "FEEDBACK_BRIGHTEN_YOUR_ENVIRONMENT",
    )
}

private fun getFacetecInstructionsTheme(): InstructionCustomsBuilder {
    return InstructionCustomsBuilder.Builder()
        .setTitleText("titulo exemplo customizado da Facetec")
        .setCaptionText("subtitulo exemplo customizado da Facetec")
        .setBackgroundColor("#170ec4")
        .setDocumentTypesInstructionIcon(android.R.drawable.ic_delete)
        .setDocumentTypesInstructionText("descricao do primeiro campo da Facetec")
        .setDocumentTipsInstructionText("descricao do segundo campo da Facetec")
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