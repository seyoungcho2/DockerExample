package kr.simplecode.dockerapp.simpleapplication

import org.springframework.web.bind.annotation.*
import java.io.File
import java.util.UUID.randomUUID

data class PostRequest(
    val title: String,
    val content: String
)

@RestController
class PostController {
    @PostMapping("/post")
    fun createPost(
        @RequestBody postRequest: PostRequest
    ): String {
        val postsDir = File("posts")
        if (!postsDir.exists()) {
            postsDir.mkdirs()
        }

        val id = randomUUID().toString()
        val file = File(postsDir, "$id.json")
        val postJson =
            """
            {
                "id": "$id",
                "title": "${postRequest.title}",
                "content": "${postRequest.content}"
            }
            """.trimIndent()
        file.writeText(postJson)

        return postJson
    }

    @GetMapping("/post")
    fun getPostById(
        @RequestParam id: String
    ): String {
        val file = File("posts/$id.json")
        return file.readText()
    }
}