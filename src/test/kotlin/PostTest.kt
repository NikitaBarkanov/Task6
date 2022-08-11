import org.junit.Test

import org.junit.Assert.*

class PostTest {

    @Test
    fun testEquals() {
        val post = Post(
            id = 0,
            ownerId = 0,
            fromId = 0,
            createBy = 0,
            date = 0,
            text = Text(),
            replyOwnerId = 0,
            replyPostId = 0,
            friendsOnly = false,
            comments = 0,
            likes = 0,
            reposts = 0,
            postType = " ",
            signerId = 0,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = true,
            isFavourite = false,
            null)

    }

    @Test
    fun testHashCode() {
    }
}