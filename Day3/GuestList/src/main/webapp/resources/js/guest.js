$(function() {
    $("#send").click(updateGuests);
});

function updateGuests() {
    var first = $("#first").val();
    var last = $("#last").val();
    var contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

    $.ajax(contextPath + "/guest.ajax", {
        type: "post",
        data: {
            "first": first,
            "last": last
        }
    }).done(displayGuests);
}

function displayGuests(data) {
    var guestList = "<ul>";
    data.forEach(function(guest) {
        guestList += "<li>" + guest.first + " " + guest.last + "</li>";
    });
    guestList += "</ul>";

    $("#guestList").html(guestList);
}
