package feature.boards

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BoardsResponse(
    @SerialName("boards") val boards: List<Board>
) {
    @Serializable
    data class Board(
        val board: String,
        val title: String,
        @SerialName("ws_board") val isWorksafe: Int,
        @SerialName("per_page") val perPage: Int,
        val pages: Int,
        @SerialName("max_filesize") val maxFileSize: Int,
        @SerialName("max_webm_filesize") val maxWebmFileSize: Int,
        @SerialName("max_comment_chars") val maxCommentChars: Int,
        @SerialName("max_webm_duration") val maxWebmDuration: Int,
        @SerialName("bump_limit") val bumpLimit: Int,
        @SerialName("image_limit") val imageLimit: Int,
        val cooldowns: List<String>, // Adjust this type according to the actual type of the `cooldowns` field
        @SerialName("meta_description") val metaDescription: String,
        val spoilers: Int? = null,
        @SerialName("custom_spoilers") val customSpoilers: Int? = null,
        @SerialName("is_archived") val isArchived: Int? = null,
        @SerialName("board_flags") val boardFlags: List<String>? = null, // Adjust this type according to the actual type of the `board_flags` field
        @SerialName("country_flags") val countryFlags: Int? = null,
        @SerialName("user_ids") val userIds: Int? = null,
        val oekaki: Int? = null,
        @SerialName("sjis_tags") val sjisTags: Int? = null,
        @SerialName("code_tags") val codeTags: Int? = null,
        @SerialName("math_tags") val mathTags: Int? = null,
        @SerialName("text_only") val textOnly: Int? = null,
        @SerialName("forced_anon") val forcedAnon: Int? = null,
        @SerialName("webm_audio") val webmAudio: Int? = null,
        @SerialName("require_subject") val requireSubject: Int? = null,
        @SerialName("min_image_width") val minImageWidth: Int? = null,
        @SerialName("min_image_height") val minImageHeight: Int? = null
    )
}
