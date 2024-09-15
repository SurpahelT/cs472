$(document).ready(function () {
    $("#fetchData").click(function () {
        var userId = $("#userId").val();
        fetchUserInfo(userId);
        fetchUserPosts(userId);
    });
});

function fetchUserInfo(userId) {
    $.ajax({
        url: `https://jsonplaceholder.typicode.com/users/${userId}`,
        method: 'GET',
        success: function (user) {
            $("#userName").text(user.name);
            $("#userEmail").text(user.email);
            $("#userAddress").text(`${user.address.street}, ${user.address.city}`);
        }
    });
}

function fetchUserPosts(userId) {
    $.ajax({
        url: `https://jsonplaceholder.typicode.com/posts?userId=${userId}`,
        method: 'GET',
        success: function (posts) {
            var postsHtml = '';
            posts.forEach(function (post) {
                postsHtml += `
                    <div class="post">
                        <h3>${post.title}</h3>
                        <p>${post.body}</p>
                        <button class="showComments" data-postid="${post.id}">Show Comments</button>
                        <div class="comments" id="comments-${post.id}" style="display: none;"></div>
                    </div>
                `;
            });
            $("#postsList").html(postsHtml);
        }
    });
}

$(document).on('click', '.showComments', function () {
    var postId = $(this).data('postid');
    var commentsDiv = $(`#comments-${postId}`);
    
    if (commentsDiv.is(':empty')) {  // Only fetch if comments haven't been loaded yet
        $.ajax({
            url: `https://jsonplaceholder.typicode.com/comments?postId=${postId}`,
            method: 'GET',
            success: function (comments) {
                var commentsHtml = '<ul>';
                comments.forEach(function (comment) {
                    commentsHtml += `<li><strong>${comment.name}:</strong> ${comment.body}</li>`;
                });
                commentsHtml += '</ul>';
                commentsDiv.html(commentsHtml);
            }
        });
    }
    
    commentsDiv.toggle();
});
