class Comments(
    val id: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val replyToUser: Int,
    val replyToComment: Int,
    attachment: Attachment
){

}
