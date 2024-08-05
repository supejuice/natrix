package feature.thread


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class GetThreadsResponse(
    @SerialName("threads")
    val threads: List<Thread>
) {
    @Serializable
    internal data class Thread(
        @SerialName("posts")
        val posts: List<Post>
    ) {

        @Serializable
        internal data class Post(
            /**
             * The numeric post ID.
             */
            @SerialName("no")
            val no: Int,

            /**
             * For replies: this is the ID of the thread being replied to. For OP: this value is zero.
             */
            @SerialName("resto")
            val resto: Int,

            /**
             * OP only, if thread is currently stickied.
             */
            @SerialName("sticky")
            val sticky: Int? = null,

            /**
             * OP only, if thread is currently closed.
             */
            @SerialName("closed")
            val closed: Int? = null,

            /**
             * MM/DD/YY(Day)HH:MM (:SS on some boards), EST/EDT timezone.
             */
            @SerialName("now")
            val now: String,

            /**
             * UNIX timestamp the post was created.
             */
            @SerialName("time")
            val time: Int,

            /**
             * Name user posted with. Defaults to Anonymous.
             */
            @SerialName("name")
            val name: String,

            /**
             * The user's tripcode, in format: !tripcode or !!securetripcode.
             */
            @SerialName("trip")
            val trip: String? = null,

            /**
             * The poster's ID.
             */
            @SerialName("id")
            val id: String? = null,

            /**
             * The capcode identifier for a post.
             */
            @SerialName("capcode")
            val capcode: String? = null,

            /**
             * Poster's ISO 3166-1 alpha-2 country code.
             */
            @SerialName("country")
            val country: String? = null,

            /**
             * Poster's country name.
             */
            @SerialName("country_name")
            val countryName: String? = null,

            /**
             * OP Subject text.
             */
            @SerialName("sub")
            val sub: String? = null,

            /**
             * Comment (HTML escaped).
             */
            @SerialName("com")
            val com: String? = null,

            /**
             * Unix timestamp + microtime that an image was uploaded.
             */
            @SerialName("tim")
            val tim: Long? = null,

            /**
             * Filename as it appeared on the poster's device.
             */
            @SerialName("filename")
            val filename: String? = null,

            /**
             * Filetype.
             */
            @SerialName("ext")
            val ext: String? = null,

            /**
             * Size of uploaded file in bytes.
             */
            @SerialName("fsize")
            val fsize: Int? = null,

            /**
             * 24 character, packed base64 MD5 hash of file.
             */
            @SerialName("md5")
            val md5: String? = null,

            /**
             * Image width dimension.
             */
            @SerialName("w")
            val w: Int? = null,

            /**
             * Image height dimension.
             */
            @SerialName("h")
            val h: Int? = null,

            /**
             * Thumbnail image width dimension.
             */
            @SerialName("tn_w")
            val tnW: Int? = null,

            /**
             * Thumbnail image height dimension.
             */
            @SerialName("tn_h")
            val tnH: Int? = null,

            /**
             * If the file was deleted from the post.
             */
            @SerialName("filedeleted")
            val filedeleted: Int? = null,

            /**
             * If the image was spoilered or not.
             */
            @SerialName("spoiler")
            val spoiler: Int? = null,

            /**
             * The custom spoiler ID for a spoilered image.
             */
            @SerialName("custom_spoiler")
            val customSpoiler: Int? = null,

            /**
             * Number of replies minus the number of previewed replies.
             */
            @SerialName("omitted_posts")
            val omittedPosts: Int? = null,

            /**
             * Number of image replies minus the number of previewed image replies.
             */
            @SerialName("omitted_images")
            val omittedImages: Int? = null,

            /**
             * Total number of replies to a thread.
             */
            @SerialName("replies")
            val replies: Int? = null,

            /**
             * Total number of image replies to a thread.
             */
            @SerialName("images")
            val images: Int? = null,

            /**
             * OP only, only if bump limit has been reached.
             */
            @SerialName("bumplimit")
            val bumplimit: Int? = null,

            /**
             * OP only, only if image limit has been reached.
             */
            @SerialName("imagelimit")
            val imagelimit: Int? = null,

            /**
             * The UNIX timestamp marking the last time the thread was modified (post added/modified/deleted, thread closed/sticky settings modified).
             */
            @SerialName("last_modified")
            val lastModified: Int? = null,

            /**
             * OP only, /f/ only, The category of .swf upload.
             */
            @SerialName("tag")
            val tag: String? = null,

            /**
             * SEO URL slug for thread.
             */
            @SerialName("semantic_url")
            val semanticUrl: String? = null,

            /**
             * Year 4chan pass bought.
             */
            @SerialName("since4pass")
            val since4pass: Int? = null,

            /**
             * Number of unique posters in a thread.
             */
            @SerialName("unique_ips")
            val uniqueIps: Int? = null,

            /**
             * Mobile optimized image exists for post.
             */
            @SerialName("m_img")
            val mImg: Int? = null
        )
    }
}