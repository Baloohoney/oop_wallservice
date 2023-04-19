data class Post (
    val id: Int = 0,
    val ownerId: Int = 1,
    val fromId: Int = 1,
    val createdBy: Int = 1,
    val date: Int = 1010101010,
    val text: String = "content",
    val replyOwnerId: Int = 1,
    val replyPostId: Int = 1,
    val friendsOnly: Boolean = false,
    val comments: Int = 1,
    val likes: Likes = Likes(1, false, true, true),
    val reposts: Int = 1,
    val views: Views = Views(1),
    val postType: String = "post",
    val signerId: Int = 1,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true)

data class Likes (
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

data class Views (
    val count: Int
)

object WallService {
    private var posts = emptyArray<Post>()

    fun clear() {
        posts = emptyArray()
        val id = 0
    }

    fun add(post: Post): Post {
        posts += post.copy(id = posts.size + 1)
        return post
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
}