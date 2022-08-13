object WallService{

    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comments>()

    fun addPost(post: Post): Post {
        posts += post
        return posts.last()
    }

    fun update(newPost: Post): Boolean{
        for ((index, post) in posts.withIndex()){
            if (post.id == newPost.id){
                posts[index] = post.copy(
                    ownerId = newPost.ownerId + 1,
                    fromId = newPost.fromId + 1,
                    createBy = newPost.createBy + 1,
                    text = newPost.text)
                return true
            }
        }
        return false
    }

    fun repost(post: Post): Post{
        val original = post.original ?: post
        return post
    }

    fun comment(postId: Int, comment: Comments,thisPost:Post): Comments{
        for (post in posts) {
            if (postId == thisPost.id)
                comments += comment
            else
                throw PostNotFoundException("No Post with postId")

        }
        return comments.last()
    }

}