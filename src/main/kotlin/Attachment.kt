interface Attachment {
    val type: String
}

class PhotoAttachment(
    val id: Int = 1,
    val ownerId: Int = 1,
    val photo130: String = "url",
    val photo604: String = "url"
) : Attachment {
    override val type: String = "photo"
}

class VideoAttachment(
    val ownerId: Int = 1,
    val id: Int = 1,
    val title: String = "Title",
    val duration: Int = 30
) : Attachment {
    override val type: String = "video"
}

class AudioAttachment(
    val id: Int = 1,
    val ownerId: Int = 1,
    val url: String = "url",
    val duration: Long = 24600
) : Attachment {
    override val type: String = "audio"
}

class DocAttachment(
    val id: Int = 1,
    val ownerId: Int = 1,
    val title: String = "Title",
    val size: Long = 100000,
    val url: String = "url"
) : Attachment {
    override val type: String = "doc"
}

class UrlAttachment(
    val url: String = "url",
    val title: String = "Title",
    val caption: String = "Caption",
    val description: String = "Description"
) : Attachment {
    override val type: String = "url"
}