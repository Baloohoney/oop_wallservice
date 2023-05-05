import java.util.Stack

data class Post(
    val id: Int = 0,
    val ownerId: Int = 1,
    val fromId: Int = 1,
    val createdBy: Int = 1,
    val date: Int = 1010101010,
    val text: String = "content",
    val replyOwnerId: Int? = null,
    val replyPostId: Int? = null,
    val friendsOnly: Boolean = false,
    val comments: Comments = Comments(1, canPost = false, groupsCanPost = false, canClose = true, canOpen = false),
    val copyright: Copyright = Copyright(1, "name", "link", "type"),
    val likes: Likes = Likes(1, userLikes = false, canLike = true, canPublish = true),
    val reposts: Reposts = Reposts(1, false),
    val views: Views = Views(1),
    val postType: String = "post",
    val postSource: PostSource = PostSource("type", "name", "link"),
    val geo: Geo = Geo("type", "name", Place(1, "name", 1.0, 1.0, "address", 1, "name", 1, 1, 1, 1, 1)),
    val signerId: Int = 1,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isPinned: Boolean = true,
    val markedAsAds: Boolean = true,
    val isFavorite: Boolean = true,
    val postponed: Int? = null,
    val attachments: Array<Attachment> = arrayOf(
        PhotoAttachment(),
        VideoAttachment(),
        AudioAttachment(),
        DocAttachment(),
        UrlAttachment()
    )
)

data class Likes(
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

data class Views(
    val count: Int
)

data class Comments(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
)

data class Copyright(
    val id: Int,
    val name: String,
    val link: String,
    val type: String
)

data class Reposts(
    val count: Int,
    val userReposted: Boolean
)

data class Geo(
    val type: String,
    val coordinates: String,
    val place: Place
)

data class Place(
    val id: Int,
    val title: String,
    val latitude: Double,
    val longitude: Double,
    val address: String,
    val created: Int,
    val icon: String,
    val checkIns: Int,
    val updated: Int,
    val type: Int,
    val country: Int,
    val city: Int
)

data class PostSource(
    val type: String,
    val platform: String,
    val url: String
)

data class Comment(
    val id: Int = 1,
    val fromId: Int = 1,
    val date: Int = 10101010,
    val text: String = "content",
    val donat: Donat = Donat(1, true),
    val replyToUser: Int? = null,
    val replyToComment: Int? = null,
    val parentsStack: Array<Int> = arrayOf(),
    val attachments: Array<Attachment> = arrayOf(
        PhotoAttachment(),
        VideoAttachment(),
        AudioAttachment(),
        DocAttachment(),
        UrlAttachment()
    ),
    val thread: Thread = Thread(1, canPost = false, groupsCanPost = true, showReplyButton = true)
)

data class Donat(
    val count: Int,
    val canDonate: Boolean
)

data class Thread(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val showReplyButton: Boolean
)

class PostNotFoundException(message: String) : Exception(message)

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    fun clear() {
        posts = emptyArray()
        comments = emptyArray()
    }

    fun add(post: Post): Post {
        posts += post.copy(id = posts.size + 1)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for (i in posts.indices) {
            if (posts[i].id == post.id) {
                posts[i] = post
                return true
            }
        }
        return false
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        for (post in posts) {
            if (post.id == postId) {
                comments += comment
                return comments.last()
            } else {
                throw PostNotFoundException("Post not found")
            }
        }
        return comment
    }
}

fun main() {
    WallService.add(Post())
    println (WallService.createComment(postId = 2, comment = Comment()))
}