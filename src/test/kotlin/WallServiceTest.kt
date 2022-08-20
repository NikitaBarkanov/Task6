import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService
        val post = service.addPost(
            Post(
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
                null
            )
        )
        val result = post.id != 0
        assertEquals(false, result)
    }

    @Test
    fun update() {
        val service = WallService
        val post1 = Post(
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
            null
        )
        val post2 = Post(
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
            null
        )
        service.addPost(post1)
        service.addPost(post2)
        val result = service.update(post2)

        assertEquals(true, result)
    }

    @Test
    fun updateFalse(){
        val service = WallService
        val post1 = Post(
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
            null
        )
        val post2 = Post(
            id = 1,
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
            null
        )
        service.addPost(post1)
        service.addPost(post2)
        val update = Post(
            id = 3333,
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
            null
        )
        val result = service.update(update)

        assertEquals(false, result)
    }

    @Test
    fun repost(){
        val service = WallService
        val repost = Post(
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
            null
        )
        val result = service.repost(repost)

        assertEquals(repost, result)
    }

    @Test
    fun comments(){
        val service = WallService
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
            null
        )

        service.addPost(post)
        val comment = Comments(
            0,3,2,"GGG", 2,3, attachment = AudioAttachment("Audio")
        )
        val result = service.comment(0,comment,post)

        assertEquals(comment, result)
    }

    @Test(expected = PostNotFoundException::class)
        fun shouldItThrown() {
        val service = WallService
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
            null
        )

        service.addPost(post)
        val comment = Comments(
            0, 3, 2, "GGG", 2, 3, attachment = AudioAttachment("Audio")
        )
        val comment1 = Comments(
            1, 3, 2, "GGG", 2, 3, attachment = AudioAttachment("Audio")
        )
        val result = service.comment(0, comment, post)
        val result1 = service.comment(2, comment1, post)
    }

}

