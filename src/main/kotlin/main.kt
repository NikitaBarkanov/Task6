fun main() {
    val post = Post(
        1,
        1,
        1,
        2,
        333,
        text = Text("OOOaq"),
        1,
        1,
        false,
        1,
        1,
        2,
        "type",
        1,
        false,
        true,
        true, true,
        true,
        true,
        null
    )
    val post1 = Post(
        1,
        1,
        1,
        2,
        444,
        text = Text("OOOaq"),
        1,
        1,
        false,
        1,
        1,
        2,
        "type",
        1,
        false,
        true,
        true, true,
        true,
        true,
        original = post
    )
    WallService.addPost(post)
    WallService.addPost(post1)
    WallService.repost(post1)
    println(WallService.update(post1))
    post.attachments += AudioAttachment()
    post1.attachments += VideoAttachment()
    post.attachments += VideoAttachment()
    println(post)
    println(WallService.repost(post))
    println(WallService.repost(post1))
    val comment = Comments(1, 3, 2, "GGG", 2, 3, attachment = post.attachments[1])
    println(WallService.comment(66, comment, post))

}

interface Attachment {
    val type: String
}

data class AudioAttachment(val audioAttachment: String = "Audio") : Attachment {
    override val type: String = "Audio"
}

data class VideoAttachment(val videoAttachment: String = "Video") : Attachment {
    override val type: String = "Video"
}

data class Text(val str: String = "text")

data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createBy: Int,
    val date: Int,
    val text: Text = Text(),
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comments: Int,
    val likes: Int = 0,
    val reposts: Int,
    val postType: String,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavourite: Boolean,
    val original: Post?,
    var attachments: Array<Attachment> = emptyArray()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Post

        if (id != other.id) return false
        if (ownerId != other.ownerId) return false
        if (fromId != other.fromId) return false
        if (createBy != other.createBy) return false
        if (date != other.date) return false
        if (text != other.text) return false
        if (replyOwnerId != other.replyOwnerId) return false
        if (replyPostId != other.replyPostId) return false
        if (friendsOnly != other.friendsOnly) return false
        if (comments != other.comments) return false
        if (likes != other.likes) return false
        if (reposts != other.reposts) return false
        if (postType != other.postType) return false
        if (signerId != other.signerId) return false
        if (canPin != other.canPin) return false
        if (canDelete != other.canDelete) return false
        if (canEdit != other.canEdit) return false
        if (isPinned != other.isPinned) return false
        if (markedAsAds != other.markedAsAds) return false
        if (isFavourite != other.isFavourite) return false
        if (original != other.original) return false
        if (!attachments.contentEquals(other.attachments)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + ownerId
        result = 31 * result + fromId
        result = 31 * result + createBy
        result = 31 * result + date
        result = 31 * result + text.hashCode()
        result = 31 * result + replyOwnerId
        result = 31 * result + replyPostId
        result = 31 * result + friendsOnly.hashCode()
        result = 31 * result + comments
        result = 31 * result + likes
        result = 31 * result + reposts
        result = 31 * result + postType.hashCode()
        result = 31 * result + signerId
        result = 31 * result + canPin.hashCode()
        result = 31 * result + canDelete.hashCode()
        result = 31 * result + canEdit.hashCode()
        result = 31 * result + isPinned.hashCode()
        result = 31 * result + markedAsAds.hashCode()
        result = 31 * result + isFavourite.hashCode()
        result = 31 * result + (original?.hashCode() ?: 0)
        result = 31 * result + attachments.contentHashCode()
        return result
    }
}
